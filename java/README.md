# MapleStory OpenAPI Java Library

[![Maven Central](https://img.shields.io/maven-central/v/dev.spiralmoon/maplestory-openapi)](https://search.maven.org/artifact/dev.spiralmoon/maplestory-openapi)

This Java library enables the use of the MapleStory OpenAPI of Nexon.

Packages written in other languages can be found [HERE](https://github.com/SpiralMoon/maplestory.openapi).

(한국어 문서는 [이쪽](https://github.com/SpiralMoon/maplestory.openapi/blob/master/java/README-ko.md)입니다.)

## Installation

Install the latest version of the Java library in your java project:

```xml
<dependency>
    <groupId>dev.spiralmoon</groupId>
    <artifactId>maplestory-openapi</artifactId>
    <version>2.0.0</version> <!-- Replace with the latest version -->
</dependency>
```
or 
```groovy
implementation 'dev.spiralmoon:maplestory-openapi:2.0.0' // Replace with the latest version
```

## Usage

### API Key

Before using the library, register your application and obtain an **api key** from the [Nexon Open API Console](https://openapi.nexon.com/my-application/).

### Sample Code

```java
import dev.spiralmoon.maplestory.api.MapleStoryApi;
import dev.spiralmoon.maplestory.api.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.dto.CubeHistoryDTO;
import dev.spiralmoon.maplestory.api.dto.CubeHistoryResponseDTO;

import java.util.List;

class Sample {
    public static void main(String[] args) {
        final String apiKey = "{Your API Key}";
        final MapleStoryApi api = new MapleStoryApi(apiKey);

        // run your code
        try {
            final CubeHistoryResponseDTO response = api.getCubeResult(1000, 2023, 10, 15);

            final int count = response.getCount();
            final List<CubeHistoryDTO> cubeHistory = response.getCubeHistory();
            final String nextCursor = response.getNextCursor();

            System.out.println("You used " + count + " cubes.");
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

### Exception Handling

Handle `MapleStoryApiException` to safely make calls, ensuring that specific Status defined in the [MapleStory OpenAPI Guide](https://openapi.nexon.com/guide/request-api) are not encountered.

While `MapleStoryApi` is designed to prevent the occurrence of certain Status, exceptions may arise due to developer mistakes.

Therefore, it's recommended to use `MapleStoryApiException` for exception handling based on the `MapleStoryApiErrorCode` list described in the table below.

| ErrorCode    | Description                                     |
|--------------|-------------------------------------------------|
| OPENAPI00001 | Internal server error                           |
| OPENAPI00002 | Access denied                                   |
| OPENAPI00003 | Invalid identifier                              |
| OPENAPI00004 | Request format error (incorrect parameter input) |
| OPENAPI00005 | Invalid api key                                 |
| OPENAPI00006 | Invalid api path                                |
| OPENAPI00007 | Request allowance (Rate Limit) exceeded         |
