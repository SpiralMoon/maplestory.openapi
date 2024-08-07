# MapleStory OpenAPI JavaScript Library

[![npm](https://img.shields.io/npm/v/maplestory-openapi)](https://www.npmjs.com/package/maplestory-openapi)
[![JS](https://github.com/SpiralMoon/maplestory.openapi/actions/workflows/js_test.yaml/badge.svg)](https://github.com/SpiralMoon/maplestory.openapi/actions/workflows/js_test.yaml)

넥슨의 MapleStory OpenAPI를 Javascript 환경에서 사용할 수 있게 해주는 라이브러리입니다.

다른 언어로 작성된 패키지는 [여기](https://github.com/SpiralMoon/maplestory.openapi)에서 확인할 수 있습니다.

(English document is [HERE](https://github.com/SpiralMoon/maplestory.openapi/blob/master/js/README-en.md))

## Installation

npm 기반 프로젝트에 아래 정보를 입력하여 패키지를 추가하세요:

```bash
npm install maplestory-openapi
```

## Usage

### API Key

라이브러리를 사용하기 전에 [Nexon Open API 콘솔](https://openapi.nexon.com/my-application/)에서 애플리케이션을 등록하고 **api key**를 발급 받으세요.

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

아래 코드는 닉네임을 바탕으로 특정 캐릭터의 식별자를 조회한 후 캐릭터의 기본 정보를 조회하는 예시입니다.

```javascript
const {MapleStoryApi, MapleStoryApiError} = require('maplestory-openapi');

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

더 많은 예시는 아래 링크의 테스트 케이스에서 확인할 수 있습니다.

- [캐릭터 정보 조회](https://github.com/SpiralMoon/maplestory.openapi/blob/master/js/test/characterApi.test.ts)
- [유니온 정보 조회](https://github.com/SpiralMoon/maplestory.openapi/blob/master/js/test/unionApi.test.ts)
- [길드 정보 조회](https://github.com/SpiralMoon/maplestory.openapi/blob/master/js/test/guildApi.test.ts)
- [확률 정보 조회](https://github.com/SpiralMoon/maplestory.openapi/blob/master/js/test/historyApi.test.ts)
- [랭킹 정보 조회](https://github.com/SpiralMoon/maplestory.openapi/blob/master/js/test/rankingApi.test.ts)
- [공지 정보 조회](https://github.com/SpiralMoon/maplestory.openapi/blob/master/js/test/noticeApi.test.ts)

### Exception Handling

[MapleStory OpenAPI 가이드](https://openapi.nexon.com/guide/request-api/)에 서술된 에러 사유를 `MapleStoryApiError`를 통해 예외 처리 해야합니다.

`MapleStoryApi`는 특정 상태의 예외를 발생시키지 않도록 설계되었으나, 라이브러리를 사용하는 개발자의 실수로 인해 여전히 일부 상태의 예외가 발생할 수 있습니다.

따라서 아래 표에 설명된 `MapleStoryApiErrorCode` 목록을 기반으로 `MapleStoryApiError`를 예외 처리하시기 바랍니다.

| ErrorCode    | Description        |
|--------------|--------------------|
| OPENAPI00001 | 서버 내부 오류           |
| OPENAPI00002 | 권한이 없는 경우          |
| OPENAPI00003 | 유효하지 않은 식별자        |
| OPENAPI00004 | 파라미터 누락 또는 유효하지 않음 |
| OPENAPI00005 | 유효하지 않은 API KEY    |
| OPENAPI00006 | 유효하지 않은 API PATH   |
| OPENAPI00007 | API 호출량 초과         |
| OPENAPI00009 | 데이터 준비 중           |
| OPENAPI00010 | 게임 점검 중            |
| OPENAPI00011 | API 점검 중           |
