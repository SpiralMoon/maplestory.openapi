# MapleStory OpenAPI JavaScript Library

[![npm](https://img.shields.io/npm/v/maplestory-openapi)](https://www.npmjs.com/package/maplestory-openapi)

넥슨에서 제공하는 MapleStory OpenAPI를 Javascript 환경에서 사용할 수 있게 해주는 라이브러리입니다.

다른 언어로 작성된 패키지는 [여기](https://github.com/SpiralMoon/maplestory.openapi)에서 확인할 수 있습니다.

(English document is [HERE](https://github.com/SpiralMoon/maplestory.openapi/blob/master/js/README.md))

## Installation

npm 기반 프로젝트에 아래 정보를 입력하여 패키지를 추가하세요:

```bash
npm install maplestory-openapi@1.0.1 # Replace with the latest version
```

## Usage

### Supports

1. **CommonJS, ESM 지원**: 이 라이브러리는 CommonJS 와 ESM 방식을 모두 지원합니다.

```javascript
const {MapleStoryApi, MapleStoryApiError} = require('maplestory-openapi'); // CommonJS
```
```typescript
import {MapleStoryApi, MapleStoryApiError} from 'maplestory-openapi'; // ESM
```

2. **TypeScript 지원**: 타입 정의가 포함되어 있으므로 타입스크립트 환경에서도 사용 가능합니다.

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

[MapleStory OpenAPI 가이드](https://developers.nexon.com/Maplestory/guides)에 서술된 에러 사유를 `MapleStoryApiError`를 통해 예외 처리 해야합니다.

`MapleStoryApi`는 특정 상태의 예외를 발생시키지 않도록 설계되었으나, 라이브러리를 사용하는 개발자의 실수로 인해 여전히 일부 상태의 예외가 발생할 수 있습니다.

따라서 아래 표에 설명된 상태 목록을 기반으로 `MapleStoryApiError`를 예외 처리하시기 바랍니다.

| Status | Message                             |
|--------|-------------------------------------|
| 400    | 요청 형식 오류 (잘못된 파라미터 입력)              |
| 401    | 미승인 서비스 (미지원 service, service type) |
| 403    | 허용되지 않은 AccessToken 사용              |
| 429    | AccessToken의 요청 허용량(Rate Limit) 초과  |
| 500    | 서버 내부 에러                            |
| 504    | 서버 내부 처리 timeout                    |
