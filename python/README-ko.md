# MapleStory OpenAPI Python Library

[![PyPi](https://img.shields.io/pypi/v/maplestory-openapi)](https://img.shields.io/pypi/v/maplestory-openapi)

넥슨의 MapleStory OpenAPI를 Python 환경에서 사용할 수 있게 해주는 라이브러리입니다.

다른 언어로 작성된 패키지는 [여기](https://github.com/SpiralMoon/maplestory.openapi)에서 확인할 수 있습니다.

(English document is [HERE](https://github.com/SpiralMoon/maplestory.openapi/blob/master/python/README.md))

## Installation

python 기반 프로젝트에 아래 정보를 입력하여 패키지를 추가하세요:

```bash
pip install maplestory-openapi
```

## Usage

### API Key

라이브러리를 사용하기 전에 [Nexon Open API 콘솔](https://openapi.nexon.com/my-application/)에서 애플리케이션을 등록하고 **api key**를 발급 받으세요.

### Supports

≧ Python 3.9

```python
from maplestory_openapi import MapleStoryApi

api_key = '{Your API Key}'
api = MapleStoryApi(api_key=api_key)

ocid = api.get_character_id('{Your Character Name}').ocid
character_basic_info = api.get_character_basic(ocid=ocid)
```

### Exception Handling

https://openapi.nexon.com/guide/request-api/#error-code-table
