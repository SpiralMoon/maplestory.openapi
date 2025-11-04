# Migration

> 💡 There are a few simple changes introduced in this version upgrade. If you're using a previous version, we recommend following the guide below to migrate smoothly.

## to 3.5.0

### API Result Objects Can Now Be `None`

Starting from version 3.5.0, result objects from `Character`, `Guild`, and `Union` APIs can return `None`.

```python
async def get_character_basic(self, ocid: str, date: datetime | None = None) -> CharacterBasic | None
```

`None` is returned in the following situations:

- When attempting to query data that did not exist at the specified point in time
- When all fields in the API response are `None` or `[]` except for the `date` field

```python
ocid = 'Your Character OCID'
date = datetime(2024, 12, 31)  # Date before character creation

# Returns None as data before character creation does not exist
character = await api.get_character_basic(ocid, date)
```

Additionally, some fields in response objects have been changed to not-null types.

These changes help API users clearly recognize and handle the existence of data, while reducing unnecessary null checks for response object fields.

However, `api.get_character_id()` always returns a not-null object. Attempting to query a non-existent character will throw a `MapleStoryApiException`.

```python
nickname = 'Your Character Nickname'
character = await api.get_character_id(nickname)  # Always returns not-null for existing characters

nickname = 'Not Exist Character Nickname'
character = await api.get_character_id(nickname)  # Always throws MapleStoryApiException for non-existent characters
```

### Safe `list` Field Handling

In some Nexon Open API responses, `list` type fields were returned as `None` when no data existed, making it difficult to handle data safely.

For response object fields with `list` type, when there is no value, the API now always returns an empty list (`[]`) instead of `None`, reducing the need for null checks.

## 2.x.x to 3.0.0

### Changed import paths

Starting from version 3.0.0, support for multiple service regions has been added. To achieve this, common logic has been abstracted into interfaces, and API classes as well as response types have been split by region and implemented accordingly.

You now need to include the region identifier in the path when importing classes related to a specific region.

```python
from maplestory_openapi import MapleStoryApi

# Update to:

from maplestory_openapi.kms import MapleStoryApi
# or
from maplestory_openapi.api.kms import MapleStoryApi
```

Common elements and abstract interfaces shared across all regions are provided via `maplestory_openapi.common`

```python
from maplestory_openapi.common import MapleStoryApi # Abstract API base class
from maplestory_openapi.common.dto.character.character_basic import CharacterBasic # Abstract character response DTO
from maplestory_openapi.common import MapleStoryApiException # Common error class
from maplestory_openapi.common.enum.character_image import CharacterImageAction # Enum used as API parameters
```

### Return Type Change for API Methods

The previously provided synchronous methods are no longer supported, as they are not considered suitable for data analysis workflows in Python. Instead, asynchronous methods are now used.

```python
def get_character_basic(self, ocid: str, date: datetime | None = None) -> CharacterBasic

# has been changed to:

async def get_character_basic(self, ocid: str, date: datetime | None = None) -> CharacterBasic
```

**Update Required**
```python
api.get_character_basic(ocid)

# should be updated to:

await api.get_character_basic(ocid)
```