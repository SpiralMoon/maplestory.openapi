# Migration

> 💡 There are a few simple changes introduced in this version upgrade. If you're using a previous version, we recommend following the guide below to migrate smoothly.

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