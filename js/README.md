# MapleStory OpenAPI JavaScript Library

[![npm](https://img.shields.io/npm/v/maplestory-openapi)](https://www.npmjs.com/package/maplestory-openapi)

This JavaScript library enables the use of the MapleStory OpenAPI provided by Nexon.


## Installation

Install the latest version of the JavaScript/TypeScript library in your npm project:

```bash
npm install maplestory-openapi@1.0.0 # Replace with the latest version
```

## Usage

### Supports

1. **CommonJS, ESM Support**: The library supports both CommonJS and ESM usage.

```javascript
const {MapleStoryApi, MapleStoryApiError} = require('maplestory-openapi'); // CommonJS
```
```typescript
import {MapleStoryApi, MapleStoryApiError} from 'maplestory-openapi'; // ESM
```

2. **TypeScript Support**: TypeScript is fully supported. Type definitions are included.

### Sample Code

```javascript
const {MapleStoryApi, MapleStoryApiError} = require('maplestory-openapi');

const apiKey = '{Your API Key}';
const api = new MapleStoryApi(apiKey);

api.getCubeResult(1000, {
    year: 2023,
    month: 10,
    day: 15
})
    .then((dto) => {
        const {count, cubeHistories, nextCursor} = dto;

        console.log('You used ' + count + ' cubes.');
    })
    .catch((e) => {
        if (e instanceof MapleStoryApiError) {
            // handle MapleStoryApiError
        } else {
            // handle other errors
        }

        console.log(e);
    });
```

### Exception Handling

Handle `MapleStoryApiError` to safely make calls, ensuring that specific Status defined in the [MapleStory OpenAPI Guide](https://developers.nexon.com/Maplestory/guides) are not encountered.

While `MapleStoryApi` is designed to prevent the occurrence of certain Status, exceptions may arise due to developer mistakes.

Therefore, it's recommended to use `MapleStoryApiError` for exception handling based on the Status list described in the table below.

| Status | Message                                                 |
|--------|---------------------------------------------------------|
| 400    | Request format error (incorrect parameter input)        |
| 401    | Unauthorized service (unsupported service, service type) |
| 403    | Unauthorized AccessToken usage                          |
| 429    | AccessToken's request allowance (Rate Limit) exceeded   |
| 500    | Internal server error                                   |
| 504    | Internal server processing timeout                      |
