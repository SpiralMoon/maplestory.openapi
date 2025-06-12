# Migration

> 💡 There are a few simple changes introduced in this version upgrade. If you're using a previous version, we recommend following the guide below to migrate smoothly.

## 2.x.x to 3.0.0

### Changed import paths

Starting from version 3.0.0, support for multiple service regions has been added. To achieve this, common logic has been abstracted into interfaces, and API classes as well as response types have been split by region and implemented accordingly.

You now need to include the region identifier in the path when importing classes related to a specific region.

```java
import dev.spiralmoon.maplestory.api.MapleStoryApi;
import dev.spiralmoon.maplestory.api.dto.character.CharacterBasicDto;

// Update to:

import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.character.CharacterBasicDto;
```

Common elements and abstract interfaces shared across all regions are provided via `dev.spiralmoon.maplestory.api.common.*`

```java
import dev.spiralmoon.maplestory.api.common.MapleStoryApi; // Abstract API base class
import dev.spiralmoon.maplestory.api.common.dto.character.CharacterBasicDto; // Abstract character response DTO
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException; // Common error class
import dev.spiralmoon.maplestory.api.common.enums.CharacterImageAction; // Enum used as API parameters
```

### DateTime Type Change

Starting from version 3, with the addition of response classes for multiple service regions, the `LocalDateTime` type has been replaced with `ZonedDateTime`, which includes time zone information.

```java
public interface CharacterBasicDTO {
    LocalDateTime getDate();
}

// has been changed to:

public interface CharacterBasicDTO {
    ZonedDateTime getDate();
}
```

KMS uses UTC+9 (KST), while MSEA uses UTC+8 (SGT).

### Return Type Change for API Methods

The previously supported synchronous methods and asynchronous methods using callbacks are no longer available. Instead, asynchronous operations now use the `CompletableFuture<T>` interface.

```java
public CharacterBasicDTO getCharacterBasic(@NonNull String ocid);
public void getCharacterBasicAsync(@NonNull String ocid, SuccessCallback<CharacterBasicDTO> onSuccess, FailureCallback onFailure);

// has been changed to:

public CompletableFuture<CharacterBasicDTO> getCharacterBasic(@NonNull String ocid);
```

**Update Required (Sync)**
```java
CharacterBasicDto character = api.getCharacterBasic(ocid);

// Update to:

CharacterBasicDto character = api.getCharacterBasic(ocid).join();
// or
CharacterBasicDto character = api.getCharacterBasic(ocid).get();
```

**Update Required (Async)**
```java
api.getCharacterBasicAsync(ocid,
        (character) -> {
    
        },
        (throwable) -> {
    
        });

// Update to:

api.getCharacterBasic(ocid)
    .thenAccept(character -> {
        
    })
    .exceptionally(throwable -> {
        
    });
```

### Exception Handling Update

With API methods now returning `CompletableFuture<T>`, the approach to exception handling has also changed.

Exceptions are now propagated through the `CompletableFuture<T>`, meaning that `MapleStoryApiException` will not be thrown directly. Instead, you must inspect the exception type using `e.getCause()`.

```java
try {
    // using api method
} catch (Exception e) {
    if (e instanceof MapleStoryApiException) {
    // handle MapleStoryApiException
    }
}

// Update to:

try {
    // using api method
} catch (Exception e) { // future.join(): throw CompletionException, future.get(): throw InterruptedException or ExecutionException
    if (e.getCause() instanceof MapleStoryApiException) {
        // handle MapleStoryApiException
    }
}
```