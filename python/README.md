# MapleStory OpenAPI Python Library

[![PyPi](https://img.shields.io/pypi/v/maplestory-openapi)](https://img.shields.io/pypi/v/maplestory-openapi)
[![Python](https://github.com/SpiralMoon/maplestory.openapi/actions/workflows/python_test.yaml/badge.svg)](https://github.com/SpiralMoon/maplestory.openapi/actions/workflows/python_test.yaml)

This Python library enables the use of the MapleStory OpenAPI of Nexon.

Packages written in other languages can be found [HERE](https://github.com/SpiralMoon/maplestory.openapi).

English | [한국어](./README-ko.md)

## Notice

>🌏 Notice 1: Starting from version 3.4.0, support for tms region has been added. You can now retrieve data from [KMS](https://maplestory.nexon.com/), [TMS](https://maplestory.beanfun.com/), [MSEA](http://www.maplesea.com/index/).
> 
>🌏 Notice 2: Starting from version 3.0.0, support for msea region has been added.
>
>💡 Notice 3: Migration is required when updating from version 2.x.x to 3.0.0. Please refer to the documentation for [Migration](https://github.com/SpiralMoon/maplestory.openapi/tree/master/python/docs/migration-en.md).

## Installation

Install the latest version of the Python library in your python project:

```bash
pip install maplestory-openapi
```

## Usage

### API Key

Before using the library, register your application and obtain an **api key** from the [Nexon Open API Console](https://openapi.nexon.com/my-application/).

Applications must be registered separately for each region. (For example, an API key issued for KMS cannot be used to request data from MSEA.)

### Region

Currently, this library supports data retrieval from the KMS, TMS, MSEA regions. To access data from a specific region, import the corresponding package path.

```python
from maplestory_openapi.kms import MapleStoryApi # data from KMS
# or
from maplestory_openapi.msea import MapleStoryApi # data from MSEA
```

Even though the regions differ, each package inherits the same interface, ensuring a consistent API usage experience across all regions.

### Sample Code

Below is an example that retrieves the identifier of a specific character from the KMS server based on the nickname, and then fetches that character’s basic information.

```python
from maplestory_openapi.kms import MapleStoryApi
from maplestory_openapi.common import MapleStoryApiException

api_key = '{Your API Key}'
api = MapleStoryApi(api_key=api_key)

# run your code
try:
    character = api.get_character_id('{Your Character Name}')
    character_basic = api.get_character_basic(ocid=character.ocid)

    print(character_basic)
# exception handling
except MapleStoryApiException as e:
    # handle MapleStoryApiException
```

You can find more examples in the test cases at the following link.

- [Character Information Retrieval](https://github.com/SpiralMoon/maplestory.openapi/blob/master/python/test/character_api_test.py)
- [Union Information Retrieval](https://github.com/SpiralMoon/maplestory.openapi/blob/master/python/test/union_api_test.py)
- [Guild Information Retrieval](https://github.com/SpiralMoon/maplestory.openapi/blob/master/python/test/guild_api_test.py)
- [History Information Retrieval](https://github.com/SpiralMoon/maplestory.openapi/blob/master/python/test/history_api_test.py)
- [Ranking Information Retrieval](https://github.com/SpiralMoon/maplestory.openapi/blob/master/python/test/ranking_api_test.py)
- [Notice Information Retrieval](https://github.com/SpiralMoon/maplestory.openapi/blob/master/python/test/notice_api_test.py)

### Features
This library supports all apis published in the MapleStory OpenAPI official docs.

Some features are supported only in specific regions. Please refer to the official documentation for each region for details.

- KMS: [https://openapi.nexon.com/game/maplestory](https://openapi.nexon.com/game/maplestory)
- TMS: [https://openapi.nexon.com/game/maplestorytw](https://openapi.nexon.com/game/maplestorytw)
- MSEA: [https://openapi.nexon.com/game/maplestorysea](https://openapi.nexon.com/game/maplestorysea)

### Exception Handling

Handle `MapleStoryApiException` to safely make calls, ensuring that specific Status defined in the [MapleStory OpenAPI Guide](https://openapi.nexon.com/guide/request-api) are not encountered.

While `MapleStoryApi` is designed to prevent the occurrence of certain Status, exceptions may arise due to developer mistakes.

Therefore, it's recommended to use `MapleStoryApiException` for exception handling based on the error code list described in the table below.

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
| OPENAPI00010 | Game server maintenance                         |
| OPENAPI00011 | API server maintenance                          |