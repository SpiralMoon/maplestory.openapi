# MapleStory OpenAPI Java Library

[![Maven Central](https://img.shields.io/maven-central/v/dev.spiralmoon/maplestory-openapi)](https://search.maven.org/artifact/dev.spiralmoon/maplestory-openapi)
[![Java](https://github.com/SpiralMoon/maplestory.openapi/actions/workflows/java_test.yaml/badge.svg)](https://github.com/SpiralMoon/maplestory.openapi/actions/workflows/java_test.yaml)

This Java library enables the use of the MapleStory OpenAPI of Nexon.

Packages written in other languages can be found [HERE](https://github.com/SpiralMoon/maplestory.openapi).

(한국어 문서는 [이쪽](https://github.com/SpiralMoon/maplestory.openapi/blob/master/java/README.md)입니다.)

## Notice

>🌏 Notice 1: Starting from version 3.0.0, support for multiple service regions has been added. You can now retrieve data from [KMS](https://maplestory.nexon.com/) and [MSEA](http://www.maplesea.com/index/).
>
>💡 Notice 2: Migration is required when updating from version 2.x.x to 3.0.0. Please refer to the documentation for [Migration](https://github.com/SpiralMoon/maplestory.openapi/tree/master/java/docs/migration-en.md).

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

Currently, this library supports data retrieval from the KMS and MSEA regions. To access data from a specific region, import the corresponding namespace.

```java
import dev.spiralmoon.maplestory.api.kms.*; // data from KMS
// or
import dev.spiralmoon.maplestory.api.msea.*; // data from MSEA
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

- [Get character information](https://github.com/SpiralMoon/maplestory.openapi/blob/master/java/src/test/java/CharacterApi.java)
- [Get union information](https://github.com/SpiralMoon/maplestory.openapi/blob/master/java/src/test/java/UnionApi.java)
- [Get guild information](https://github.com/SpiralMoon/maplestory.openapi/blob/master/java/src/test/java/GuildApi.java)
- [Get history information](https://github.com/SpiralMoon/maplestory.openapi/blob/master/java/src/test/java/HistoryApi.java)
- [Get ranking information](https://github.com/SpiralMoon/maplestory.openapi/blob/master/java/src/test/java/RankingApi.java)
- [Get notice information](https://github.com/SpiralMoon/maplestory.openapi/blob/master/java/src/test/java/NoticeApi.java)


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
