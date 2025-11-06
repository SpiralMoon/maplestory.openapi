# Migration

> 💡 버전업에 따른 간단한 몇가지 변경사항이 있습니다. 이전 버전 사용자들은 아래 안내를 따라 마이그레이션 진행을 권장합니다.

## to 3.5.0

### API 결과 객체가 `null`이 될 수 있음

버전 3.5.0부터는 `Character`, `Guild`, `Union` API의 결과 객체가 `null`이 될 수 있습니다.

```typescript
getCharacterBasic(ocid: string, dateOptions?: DateOptions): Promise<CharacterBasicDto | null>;
```

`null`이 반환되는 상황은 다음과 같습니다.

- 조회 시점에 존재하지 않은 데이터에 조회를 시도할 경우
- API 응답에서 `date` 필드를 제외한 모든 필드가 `null`이거나 `[]`인 경우

```typescript
const ocid = 'Your Character OCID';
const date = new Date(2024, 12, 31); // 캐릭터 생성일 이전 날짜

// 생성 이전의 데이터는 존재하지 않으므로 null
const character = await api.getCharacterBasic(ocid, date);
```

이와 더불어, 일부 응답 객체의 필드가 not-null 타입으로 변경되었습니다.

이러한 변경 사항은 API 사용자가 데이터의 존재 여부를 명확히 인지하고 처리할 수 있도록 돕고, 응답 객체 필드의 불필요한 null 검사를 줄이기 위함입니다.

그러나 `api.getCharacter()`은 항상 not-null 객체를 반환합니다. 존재하지 않는 캐릭터에 대한 조회 시도는 `MapleStoryApiError` 예외가 발생합니다.

```typescript
const nickname = 'Your Character Nickname';
const character = await api.getCharacter(ocid); // 실제 존재하는 캐릭터는 항상 not-null

const nickname = 'Not Exist Character Nickname';
const character = await api.getCharacter(ocid); // 실제 존재하지 않은 캐릭터는 항상 MapleStoryApiError 예외 발생
```

### 안전한 배열 필드 처리

Nexon Open API의 일부 응답 결과에서는 배열 타입 필드가 존재하지 않을 때 `null`로 반환되는 경우가 있어 데이터의 안전한 처리가 어려웠습니다.

API 결과 객체의 필드 중 타입이 배열인 경우, 해당 필드에 값이 없을 때 이제 항상 빈 배열(`[]`)을 반환하여 null 검사를 줄일 수 있도록 개선하였습니다.

## 2.x.x to 3.0.0

### import 경로 변경

버전 3부터는 여러 서비스 지역에 대한 지원을 추가하면서 공통된 부분을 추상 인터페이스로 정의하고 API 클래스, 응답 클래스를 지역별로 나누어 상속 구현하였습니다.

이제부터 데이터를 조회하려는 지역의 식별자를 패키지의 서브 모듈 경로로 포함해야 합니다.

```typescript
import { MapleStoryApi, CharacterBasicDto } from 'maplestory-openapi';

// 위 코드를 아래처럼 변경하세요.

import { MapleStoryApi, CharacterBasicDto } from 'maplestory-openapi/kms';
```

그러나 모든 지역에 공통으로 사용되는 요소와 추상 인터페이스는 여전히 `'maplestory-openapi'`에서 제공합니다.

```typescript
import { MapleStoryApi } from 'maplestory-openapi'; // API의 공통 추상 클래스 제공
import { CharacterBasicDto } from 'maplestory-openapi'; // 캐릭터 정보 응답의 공통 추상 클래스 제공
import { MapleStoryError } from 'maplestory-openapi'; // 공통 예외 클래스 제공
import { CharacterImageAction } from 'maplestory-openapi'; // API 파라미터로 사용될 열거 클래스
```

### TS2307 Cannot find module

서브 모듈 경로를 포함하게 되면서 `moduleResolution`이 `node`인 경우 IDE에서 패키지를 인식하지 못 할 수 있습니다. `tsconfig.json`에서 `moduleResolution`을 `node16`, `nodenext`, `bundler` 등으로 수정 하세요.

```json
{
  "compilerOptions": {
    "moduleResolution": "nodenext"
  }
}
```
