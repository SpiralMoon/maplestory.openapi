# Migration

> 💡 버전업에 따른 간단한 몇가지 변경사항이 있습니다. 이전 버전 사용자들은 아래 안내를 따라 마이그레이션 진행을 권장합니다.

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