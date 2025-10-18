# MapleStory OpenAPI Java Library

[![Maven Central](https://img.shields.io/maven-central/v/dev.spiralmoon/maplestory-openapi)](https://search.maven.org/artifact/dev.spiralmoon/maplestory-openapi)
[![Java](https://github.com/SpiralMoon/maplestory.openapi/actions/workflows/java_test.yaml/badge.svg)](https://github.com/SpiralMoon/maplestory.openapi/actions/workflows/java_test.yaml)

This Java library enables the use of the MapleStory OpenAPI of Nexon.

Packages written in other languages can be found [HERE](https://github.com/SpiralMoon/maplestory.openapi).

English | [한국어](./README-ko.md)

## Notice

>🌏 Notice 1: Starting from version 3.4.0, support for tms region has been added. You can now retrieve data from [KMS](https://maplestory.nexon.com/), [TMS](https://maplestory.beanfun.com/), [MSEA](http://www.maplesea.com/index/).
>
>🌏 Notice 2: Starting from version 3.0.0, support for msea region has been added.
>
>💡 Notice 3: Migration is required when updating from version 2.x.x to 3.0.0. Please refer to the documentation for [Migration](https://github.com/SpiralMoon/maplestory.openapi/tree/master/java/docs/migration-en.md).

## Installation

Install the latest version of the Java library in your java project:

```xml
<dependency>
    <groupId>dev.spiralmoon</groupId>
    <artifactId>maplestory-openapi</artifactId>
</dependency>
```
or 
```groovy
implementation 'dev.spiralmoon:maplestory-openapi:+'
```

## Usage

### API Key

Before using the library, register your application and obtain an **api key** from the [Nexon Open API Console](https://openapi.nexon.com/my-application/).

Applications must be registered separately for each region. (For example, an API key issued for KMS cannot be used to request data from MSEA.)

### Region

Currently, this library supports data retrieval from the KMS, TMS, MSEA regions. To access data from a specific region, import the corresponding namespace.

```java
import dev.spiralmoon.maplestory.api.kms.MapleStoryApi; // data from KMS
// or
import dev.spiralmoon.maplestory.api.msea.MapleStoryApi; // data from MSEA
```

Even though the regions differ, each package inherits the same interface, ensuring a consistent API usage experience across all regions.

### Sample Code

Below is an example that retrieves the identifier of a specific character from the KMS server based on the nickname, and then fetches that character’s basic information.

```java
import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;

class Sample {
    public static void main(String[] args) {
        final String apiKey = "{Your API Key}";
        final MapleStoryApi api = new MapleStoryApi(apiKey);

        // run your code
        try {
            final CharacterDTO character = api.getCharacter("{Your Character Name}").join();
            final CharacterBasicDTO characterBasic = api.getCharacterBasic(character.getOcid());

            System.out.println(characterBasic.toString());
        }
        // exception handling
        catch (Exception exception) {
            if (exception.getCause() instanceof MapleStoryApiException) {
                // handle MapleStoryApiException
            } else {
                // handle
            }
        }
    }
}

```

You can find more examples in the test cases at the following link.

- [Character Information Retrieval](https://github.com/SpiralMoon/maplestory.openapi/blob/master/java/src/test/java/CharacterApi.java)
- [Union Information Retrieval](https://github.com/SpiralMoon/maplestory.openapi/blob/master/java/src/test/java/UnionApi.java)
- [Guild Information Retrieval](https://github.com/SpiralMoon/maplestory.openapi/blob/master/java/src/test/java/GuildApi.java)
- [History Information Retrieval](https://github.com/SpiralMoon/maplestory.openapi/blob/master/java/src/test/java/HistoryApi.java)
- [Ranking Information Retrieval](https://github.com/SpiralMoon/maplestory.openapi/blob/master/java/src/test/java/RankingApi.java)
- [Notice Information Retrieval](https://github.com/SpiralMoon/maplestory.openapi/blob/master/java/src/test/java/NoticeApi.java)

### Features
This library supports all apis published in the MapleStory OpenAPI official docs.

Some features are supported only in specific regions. Please refer to the official documentation for each region for details.

- KMS: [https://openapi.nexon.com/game/maplestory](https://openapi.nexon.com/game/maplestory)
- TMS: [https://openapi.nexon.com/game/maplestorytw](https://openapi.nexon.com/game/maplestorytw)
- MSEA: [https://openapi.nexon.com/game/maplestorysea](https://openapi.nexon.com/game/maplestorysea)

### Exception Handling

Handle `MapleStoryApiException` to safely make calls, ensuring that specific Status defined in the [MapleStory OpenAPI Guide](https://openapi.nexon.com/guide/request-api) are not encountered.

While `MapleStoryApi` is designed to prevent the occurrence of certain Status, exceptions may arise due to developer mistakes.

Therefore, it's recommended to use `MapleStoryApiException` for exception handling based on the `MapleStoryApiErrorCode` list described in the table below.

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