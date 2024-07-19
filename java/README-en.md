# MapleStory OpenAPI Java Library

[![Maven Central](https://img.shields.io/maven-central/v/dev.spiralmoon/maplestory-openapi)](https://search.maven.org/artifact/dev.spiralmoon/maplestory-openapi)
[![Java](https://github.com/SpiralMoon/maplestory.openapi/actions/workflows/java_test.yaml/badge.svg)](https://github.com/SpiralMoon/maplestory.openapi/actions/workflows/java_test.yaml)

This Java library enables the use of the MapleStory OpenAPI of Nexon.

Packages written in other languages can be found [HERE](https://github.com/SpiralMoon/maplestory.openapi).

(한국어 문서는 [이쪽](https://github.com/SpiralMoon/maplestory.openapi/blob/master/java/README.md)입니다.)

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

### Sample Code

Below is an example code that retrieves the identifier of a specific character based on the nickname and then fetches the basic information of that character.

```java
import dev.spiralmoon.maplestory.api.MapleStoryApi;
import dev.spiralmoon.maplestory.api.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.dto.*;

class Sample {
    public static void main(String[] args) {
        final String apiKey = "{Your API Key}";
        final MapleStoryApi api = new MapleStoryApi(apiKey);

        // run your code
        try {
            final CharacterDTO character = api.getCharacter("{Your Character Name}");
            final CharacterBasicDTO characterBasic = api.getCharacterBasic(character.getOcid());

            System.out.println(characterBasic.toString());
        }
        // exception handling
        catch (Exception exception) {
            if (exception instanceof MapleStoryApiException) {
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
