# MapleStory OpenAPI JavaScript Library

[![npm](https://img.shields.io/npm/v/maplestory-openapi)](https://www.npmjs.com/package/maplestory-openapi)
[![JS](https://github.com/SpiralMoon/maplestory.openapi/actions/workflows/js_test.yaml/badge.svg)](https://github.com/SpiralMoon/maplestory.openapi/actions/workflows/js_test.yaml)

This JavaScript library enables the use of the MapleStory OpenAPI of Nexon.

Packages written in other languages can be found [HERE](https://github.com/SpiralMoon/maplestory.openapi).

(한국어 문서는 [이쪽](https://github.com/SpiralMoon/maplestory.openapi/blob/master/js/README.md)입니다.)

## Notice

>🌏 Notice 1: Starting from version 3.0.0, support for multiple service regions has been added. You can now retrieve data from [KMS](https://maplestory.nexon.com/) and [MSEA](http://www.maplesea.com/index/).
>
>💡 Notice 2: Migration is required when updating from version 2.x.x to 3.0.0. Please refer to the documentation for [Migration](https://github.com/SpiralMoon/maplestory.openapi/tree/master/js/docs/migration-en.md).

## Installation

Install the latest version of the JavaScript/TypeScript library in your npm project:

```bash
npm install maplestory-openapi
```

## Usage

### API Key

Before using the library, register your application and obtain an **api key** from the [Nexon Open API Console](https://openapi.nexon.com/my-application/).

Applications must be registered separately for each region. (For example, an API key issued for KMS cannot be used to request data from MSEA.)

### Region

Currently, this library supports data retrieval from the KMS and MSEA regions. To access data from a specific region, import the corresponding package path.

```typescript
import { MapleStoryApi } from 'maplestory-openapi/kms'; // data from KMS
// or
import { MapleStoryApi } from 'maplestory-openapi/msea'; // data from MSEA
```

Even though the regions differ, each package inherits the same interface, ensuring a consistent API usage experience across all regions.

### Supports

1. **TypeScript Support**: TypeScript is fully supported. Type definitions are included.

2. **CommonJS, ESM Support**: The library supports both CommonJS and ESM usage.

```javascript
const { MapleStoryApi } = require('maplestory-openapi/kms'); // CommonJS
```
```typescript
import { MapleStoryApi } from 'maplestory-openapi/kms'; // ESM
```

3. **TS2307 Cannot find module**: it may be due to the `moduleResolution` option being set to `node`. In such cases, update it to `node16`, `nodenext`, or `bundler` as shown below

```json
{
  "compilerOptions": {
    "moduleResolution": "nodenext"
  }
}
```

### Sample Code

Below is an example that retrieves the identifier of a specific character from the KMS server based on the nickname, and then fetches that character’s basic information.

```javascript
const { MapleStoryApi } = require('maplestory-openapi/kms');
const { MapleStoryApiError } = require('maplestory-openapi');

const apiKey = '{Your API Key}';
const api = new MapleStoryApi(apiKey);

try {
  // run your code

  const character = await api.getCharacter('{Your Character Name}');
  const characterBasic = await api.getCharacterBasic(character.ocid);

  console.log(characterBasic);
} catch (e) {
  // exception handling

  if (e instanceof MapleStoryApiError) {
    // handle MapleStoryApiError
  } else {
    // handle other errors
  }
}
```

You can find more examples in the test cases at the following link.

- [Get character information](https://github.com/SpiralMoon/maplestory.openapi/blob/master/js/test/characterApi.test.ts)
- [Get union information](https://github.com/SpiralMoon/maplestory.openapi/blob/master/js/test/unionApi.test.ts)
- [Get guild information](https://github.com/SpiralMoon/maplestory.openapi/blob/master/js/test/guildApi.test.ts)
- [Get history information](https://github.com/SpiralMoon/maplestory.openapi/blob/master/js/test/historyApi.test.ts)
- [Get ranking information](https://github.com/SpiralMoon/maplestory.openapi/blob/master/js/test/rankingApi.test.ts)
- [Get notice information](https://github.com/SpiralMoon/maplestory.openapi/blob/master/js/test/noticeApi.test.ts)

### Exception Handling

Handle `MapleStoryApiError` to safely make calls, ensuring that specific Status defined in the [MapleStory OpenAPI Guide](https://openapi.nexon.com/guide/request-api) are not encountered.

While `MapleStoryApi` is designed to prevent the occurrence of certain Status, exceptions may arise due to developer mistakes.

Therefore, it's recommended to use `MapleStoryApiError` for exception handling based on the `MapleStoryApiErrorCode` list described in the table below.

| ErrorCode    | Description                                      |
|--------------|--------------------------------------------------|
| OPENAPI00001 | Internal server error                            |
| OPENAPI00002 | Access denied                                    |
| OPENAPI00003 | Invalid identifier                               |
| OPENAPI00004 | Request format error (incorrect parameter input) |
| OPENAPI00005 | Invalid api key                                  |
| OPENAPI00006 | Invalid api path                                 |
| OPENAPI00007 | Request allowance (Rate Limit) exceeded          |
| OPENAPI00009 | Not prepared data                                |
| OPENAPI00010 | Game server maintenance                          |
| OPENAPI00011 | API server maintenance                           |
