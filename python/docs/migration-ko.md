# Migration

> 💡 버전업에 따른 간단한 몇가지 변경사항이 있습니다. 이전 버전 사용자들은 아래 안내를 따라 마이그레이션 진행을 권장합니다.

## to 3.5.0

### API 결과 객체가 `None`이 될 수 있음

버전 3.5.0부터는 `Character`, `Guild`, `Union` API의 결과 객체가 `None`이 될 수 있습니다.

```python
async def get_character_basic(self, ocid: str, date: datetime | None = None) -> CharacterBasic | None
```

`None`이 반환되는 상황은 다음과 같습니다.

- 조회 시점에 존재하지 않은 데이터에 조회를 시도할 경우
- API 응답에서 `date` 필드를 제외한 모든 필드가 `None`이거나 `[]`인 경우

```python
ocid = 'Your Character OCID'
date = datetime(2024, 12, 31)  # 캐릭터 생성일 이전 날짜

# 생성 이전의 데이터는 존재하지 않으므로 None
character = await api.get_character_basic(ocid, date)
```

이와 더불어, 일부 응답 객체의 필드가 not-null 타입으로 변경되었습니다.

이러한 변경 사항은 API 사용자가 데이터의 존재 여부를 명확히 인지하고 처리할 수 있도록 돕고, 응답 객체 필드의 불필요한 null 검사를 줄이기 위함입니다.

그러나 `api.get_character_id()`은 항상 not-null 객체를 반환합니다. 존재하지 않는 캐릭터에 대한 조회 시도는 `MapleStoryApiException` 예외가 발생합니다.

```python
nickname = 'Your Character Nickname'
character = await api.get_character_id(nickname)  # 실제 존재하는 캐릭터는 항상 not-null

nickname = 'Not Exist Character Nickname'
character = await api.get_character_id(nickname)  # 실제 존재하지 않은 캐릭터는 항상 MapleStoryApiException 예외 발생
```

### 안전한 `list` 필드 처리

Nexon Open API의 일부 응답 결과에서는 `list` 타입 필드가 존재하지 않을 때 `None`로 반환되는 경우가 있어 데이터의 안전한 처리가 어려웠습니다.

API 결과 객체의 필드 중 타입이 `list`인 경우, 해당 필드에 값이 없을 때 이제 항상 빈 리스트(`[]`)를 반환하여 null 검사를 줄일 수 있도록 개선하였습니다.

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