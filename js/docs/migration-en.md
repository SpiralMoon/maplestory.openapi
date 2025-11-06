# Migration

> 💡 There are a few simple changes introduced in this version upgrade. If you're using a previous version, we recommend following the guide below to migrate smoothly.

## to 3.5.0

### API Result Objects Can Now Be `null`

Starting from version 3.5.0, result objects from `Character`, `Guild`, and `Union` APIs can return `null`.

```typescript
getCharacterBasic(ocid: string, dateOptions?: DateOptions): Promise<CharacterBasicDto | null>;
```

`null` is returned in the following situations:

- When attempting to query data that did not exist at the specified point in time
- When all fields in the API response are `null` or `[]` except for the `date` field

```typescript
const ocid = 'Your Character OCID';
const date = new Date(2024, 12, 31); // Date before character creation

// Returns null as data before character creation does not exist
const character = await api.getCharacterBasic(ocid, date);
```

Additionally, some fields in response objects have been changed to not-null types.

These changes help API users clearly recognize and handle the existence of data, while reducing unnecessary null checks for response object fields.

However, `api.getCharacter()` always returns a not-null object. Attempting to query a non-existent character will throw a `MapleStoryApiError`.

```typescript
const nickname = 'Your Character Nickname';
const character = await api.getCharacter(ocid); // Always returns not-null for existing characters

const nickname = 'Not Exist Character Nickname';
const character = await api.getCharacter(ocid); // Always throws MapleStoryApiError for non-existent characters
```

### Safe Array Field Handling

In some Nexon Open API responses, array type fields were returned as `null` when no data existed, making it difficult to handle data safely.

For response object fields with array type, when there is no value, the API now always returns an empty array (`[]`) instead of `null`, reducing the need for null checks.

## 2.x.x to 3.0.0

### Changed import paths

Starting from version 3.0.0, support for multiple service regions has been added. To achieve this, common logic has been abstracted into interfaces, and API classes as well as response types have been split by region and implemented accordingly.

You now need to include the region identifier in the submodule path when importing classes related to a specific region.

```typescript
import { MapleStoryApi, CharacterBasicDto } from 'maplestory-openapi';

// Update to:

import { MapleStoryApi, CharacterBasicDto } from 'maplestory-openapi/kms';
```

However, elements that are shared across all regions, including abstract interfaces, are still provided from `'maplestory-openapi'`

```typescript
import { MapleStoryApi } from 'maplestory-openapi'; // Abstract API base class
import { CharacterBasicDto } from 'maplestory-openapi'; // Abstract character response DTO
import { MapleStoryError } from 'maplestory-openapi'; // Common error class
import { CharacterImageAction } from 'maplestory-openapi'; // Enum used as API parameters
```

### TS2307 Cannot find module

When submodule paths are used, your IDE may fail to recognize the package if `moduleResolution` is set to `node`. To resolve this, set `moduleResolution` to `node16`, `nodenext`, or `bundler` in your `tsconfig.json`

```json
{
  "compilerOptions": {
    "moduleResolution": "nodenext"
  }
}
```
