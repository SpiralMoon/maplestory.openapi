# Migration

> 💡 버전업에 따른 간단한 몇가지 변경사항이 있습니다. 이전 버전 사용자들은 아래 안내를 따라 마이그레이션 진행을 권장합니다.

## 2.x.x to 3.0.0

### import 경로 변경

버전 3부터는 여러 서비스 지역에 대한 지원을 추가하면서 공통된 부분을 추상 인터페이스로 정의하고 API 클래스, 응답 클래스를 지역별로 나누어 상속 구현하였습니다.

이제부터 데이터를 조회하려는 지역의 식별자를 패키지의 경로로 포함해야 합니다.

```python
from maplestory_openapi import MapleStoryApi

# 위 코드를 아래처럼 변경하세요.

from maplestory_openapi.kms import MapleStoryApi
# 또는
from maplestory_openapi.api.kms import MapleStoryApi
```

그리고 모든 지역에 공통으로 사용되는 요소와 추상 인터페이스는 `maplestory_openapi.common`에서 제공합니다.

```python
from maplestory_openapi.common import MapleStoryApi # API의 공통 추상 클래스 제공
from maplestory_openapi.common.dto.character.character_basic import CharacterBasic # 캐릭터 정보 응답의 공통 추상 클래스 제공
from maplestory_openapi.common import MapleStoryApiException # 공통 예외 클래스 제공
from maplestory_openapi.common.enum.character_image import CharacterImageAction # API 파라미터로 사용될 열거 클래스
```

### API 메소드의 반환 타입 변경

기존에 제공하던 동기 메소드는 데이터 분석에 특화된 Python에는 적합하지 않다고 판단하여 더 이상 지원하지 않으며, 대신 비동기 메소드를 지원합니다.

```python
def get_character_basic(self, ocid: str, date: datetime | None = None) -> CharacterBasic

# 아래처럼 변경되었습니다.

async def get_character_basic(self, ocid: str, date: datetime | None = None) -> CharacterBasic
```

**수정 안내**
```python
api.get_character_basic(ocid)

# 위 코드를 아래처럼 변경하세요.

await api.get_character_basic(ocid)
```