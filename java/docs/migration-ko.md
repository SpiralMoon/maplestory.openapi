# Migration

> 💡 버전업에 따른 간단한 몇가지 변경사항이 있습니다. 이전 버전 사용자들은 아래 안내를 따라 마이그레이션 진행을 권장합니다.

## to 3.5.0

### API 결과 객체가 `null`이 될 수 있음

버전 3.5.0부터는 `Character`, `Guild`, `Union` API의 결과 객체가 `null`이 될 수 있습니다.

`null`이 반환되는 상황은 다음과 같습니다.

- 조회 시점에 존재하지 않은 데이터에 조회를 시도할 경우
- API 응답에서 `date` 필드를 제외한 모든 필드가 `null`이거나 `[]`인 경우

```java
String ocid = "Your Character OCID";
LocalDateTime date = LocalDateTime.of(2024, 12, 31, 0, 0); // 캐릭터 생성일 이전 날짜

// 생성 이전의 데이터는 존재하지 않으므로 null
CharacterBasicDTO character = api.getCharacterBasic(ocid, date).join();
```

이와 더불어, 일부 응답 객체의 필드가 not-null 타입으로 변경되었습니다.

이러한 변경 사항은 API 사용자가 데이터의 존재 여부를 명확히 인지하고 처리할 수 있도록 돕고, 응답 객체 필드의 불필요한 null 검사를 줄이기 위함입니다.

그러나 `api.getCharacter()`은 항상 not-null 객체를 반환합니다. 존재하지 않는 캐릭터에 대한 조회 시도는 `MapleStoryApiException` 예외가 발생합니다.

```java
String nickname = "Your Character Nickname";
CharacterBasicDTO character = api.getCharacter(ocid).join(); // 실제 존재하는 캐릭터는 항상 not-null

String nickname = "Not Exist Character Nickname";
CharacterBasicDTO character = api.getCharacter(ocid).join(); // 실제 존재하지 않은 캐릭터는 항상 MapleStoryApiException 예외 발생
```

### 안전한 `List<T>` 필드 처리

Nexon Open API의 일부 응답 결과에서는 `List<T>` 타입 필드가 존재하지 않을 때 `null`로 반환되는 경우가 있어 데이터의 안전한 처리가 어려웠습니다.

API 결과 객체의 필드 중 타입이 `List<T>`인 경우, 해당 필드에 값이 없을 때 이제 항상 빈 배열(`[]`)을 반환하여 null 검사를 줄일 수 있도록 개선하였습니다.

## 2.x.x to 3.0.0

### import 경로 변경

버전 3부터는 여러 서비스 지역에 대한 지원을 추가하면서 공통된 부분을 추상 인터페이스로 정의하고 API 클래스, 응답 클래스를 지역별로 나누어 상속 구현하였습니다.

이제부터 데이터를 조회하려는 지역의 식별자를 패키지의 경로로 포함해야 합니다.

```java
import dev.spiralmoon.maplestory.api.MapleStoryApi;
import dev.spiralmoon.maplestory.api.dto.character.CharacterBasicDto;

// 위 코드를 아래처럼 변경하세요.

import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.character.CharacterBasicDto;
```

그리고 모든 지역에 공통으로 사용되는 요소와 추상 인터페이스는 `dev.spiralmoon.maplestory.api.common.*`에서 제공합니다.

```java
import dev.spiralmoon.maplestory.api.common.MapleStoryApi; // API의 공통 추상 클래스 제공
import dev.spiralmoon.maplestory.api.common.dto.character.CharacterBasicDto; // 캐릭터 정보 응답의 공통 추상 클래스 제공
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException; // 공통 예외 클래스 제공
import dev.spiralmoon.maplestory.api.common.enums.CharacterImageAction; // API 파라미터로 사용될 열거 클래스
```

### DateTime 타입 변경

버전 3부터는 여러 서비스 지역의 응답 클래스가 추가되면서 `LocalDateTime` 대신 시간대 정보가 포함된 `ZonedDateTime`을 제공하도록 변경되었습니다.

```java
public interface CharacterBasicDTO {
    LocalDateTime getDate();
}

// 아래처럼 변경되었습니다.

public interface CharacterBasicDTO {
    ZonedDateTime getDate();
}
```

KMS는 UTC+9 (KST), MSEA는 UTC+8 (SGT)가 적용됩니다.

### API 메소드의 반환 타입 변경

기존에 제공하던 동기 메소드와 callback을 호출하던 비동기 메소드를 더 이상 지원하지 않으며, 대신 비동기 인터페이스 `CompletableFuture<T>`를 지원합니다.

```java
public CharacterBasicDTO getCharacterBasic(@NonNull String ocid);
public void getCharacterBasicAsync(@NonNull String ocid, SuccessCallback<CharacterBasicDTO> onSuccess, FailureCallback onFailure);

// 아래처럼 변경되었습니다.

public CompletableFuture<CharacterBasicDTO> getCharacterBasic(@NonNull String ocid);
```

**수정 안내 (Sync)**
```java
CharacterBasicDto character = api.getCharacterBasic(ocid);

// 위 코드를 아래처럼 변경하세요.

CharacterBasicDto character = api.getCharacterBasic(ocid).join();
// 또는
CharacterBasicDto character = api.getCharacterBasic(ocid).get();
```

**수정 안내 (Async)**
```java
api.getCharacterBasicAsync(ocid,
        (character) -> {
    
        },
        (throwable) -> {
    
        });

// 위 코드를 아래처럼 변경하세요.

api.getCharacterBasic(ocid)
    .thenAccept(character -> {
        
    })
    .exceptionally(throwable -> {
        
    });
```

### Exception 처리 방식 변경

API 메소드가 `CompletableFuture<T>`로 변경되어 예외 처리 방식을 변경 해야 합니다.

예외 발생은 `CompletableFuture<T>`에 의해 평가되므로 `MapleStoryApiException` 예외가 직접적으로 발생하지 않으며 `e.getCause()`로 예외 객체 타입을 검사 해야 합니다.

```java
try {
    // using api method
} catch (Exception e) {
    if (e instanceof MapleStoryApiException) {
    // handle MapleStoryApiException
    }
}

// 위 코드를 아래처럼 변경하세요.

try {
    // using api method
} catch (Exception e) { // future.join(): throw CompletionException, future.get(): throw InterruptedException or ExecutionException
    if (e.getCause() instanceof MapleStoryApiException) {
        // handle MapleStoryApiException
    }
}
```
