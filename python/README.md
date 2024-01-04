# MapleStory OpenAPI Python Library

[![PyPi](https://img.shields.io/pypi/v/maplestory-openpai)](https://img.shields.io/pypi/v/maplestory-openpai)

This Python library enables the use of the MapleStory OpenAPI of Nexon.

Packages written in other languages can be found [HERE](https://github.com/SpiralMoon/maplestory.openapi).

(한국어 문서는 [이쪽](https://github.com/SpiralMoon/maplestory.openapi/blob/master/python/README-ko.md)입니다.)

## Installation

Install the latest version of the Python library in your python project:

```bash
pip install maplestory-openapi
```

## Usage

### API Key

Before using the library, register your application and obtain an **api key** from the [Nexon Open API Console](https://openapi.nexon.com/my-application/).

### Supports

≧ Python 3.9

### Sample Code

```python
from maplestory_openapi import MapleStoryApi

api_key = '{Your API Key}'
api = MapleStoryApi(api_key=api_key)

ocid = api.get_character_id('{Your Character Name}').ocid
character_basic_info = api.get_character_basic(ocid=ocid)
```

### Exception Handling

https://openapi.nexon.com/guide/request-api/#error-code-table
