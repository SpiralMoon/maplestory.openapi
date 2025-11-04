# Migration

> 💡 There are a few simple changes introduced in this version upgrade. If you're using a previous version, we recommend following the guide below to migrate smoothly.

## to 3.5.0

### API Result Objects Can Now Be `null`

Starting from version 3.5.0, result objects from `Character`, `Guild`, and `Union` APIs can return `null`.

```csharp
async Task<CharacterBasicDTO?> GetCharacterBasic(string ocid, DateTime? date = null);
```

`null` is returned in the following situations:

- When attempting to query data that did not exist at the specified point in time
- When all fields in the API response are `null` or `[]` except for the `date` field

```csharp
string ocid = "Your Character OCID";
DateTime date = new DateTime(2024, 12, 31, 0, 0, 0); // Date before character creation

// Returns null as data before character creation does not exist
CharacterBasicDTO? character = await api.GetCharacterBasic(ocid, date);
```

Additionally, some fields in response objects have been changed to not-null types.

These changes help API users clearly recognize and handle the existence of data, while reducing unnecessary null checks for response object fields.

However, `api.GetCharacter()` always returns a not-null object. Attempting to query a non-existent character will throw a `MapleStoryAPIException`.

```csharp
string nickname = "Your Character Nickname";
CharacterDTO character = await api.GetCharacter(nickname); // Always returns not-null for existing characters

string nickname = "Not Exist Character Nickname";
CharacterDTO character = await api.GetCharacter(nickname); // Always throws MapleStoryAPIException for non-existent characters
```

### Safe `List<T>` Field Handling

In some Nexon Open API responses, `List<T>` type fields were returned as `null` when no data existed, making it difficult to handle data safely.

For response object fields with `List<T>` type, when there is no value, the API now always returns an empty list (`[]`) instead of `null`, reducing the need for null checks.

## 2.x.x to 3.0.0

### Changed namespace

Starting from version 3.0.0, support for multiple service regions has been added. To achieve this, common logic has been abstracted into interfaces, and API classes as well as response types have been split by region and implemented accordingly.

You now need to include the region identifier in the namespace when importing classes related to a specific region.

```csharp
using MapleStory.OpenAPI;

// Update to:

using MapleStory.OpenAPI.KMS;
```

Common elements and abstract interfaces shared across all regions are provided via `MapleStory.OpenAPI.Common`

```csharp
using MapleStory.OpenAPI.Common; // Abstract API base class, Common error class
using MapleStory.OpenAPI.Common.DTO; // Abstract character response DTO
using MapleStory.OpenAPI.Common.Enum; // Enum used as API parameters
```