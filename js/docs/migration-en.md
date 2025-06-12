# Migration

> 💡 There are a few simple changes introduced in this version upgrade. If you're using a previous version, we recommend following the guide below to migrate smoothly.

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