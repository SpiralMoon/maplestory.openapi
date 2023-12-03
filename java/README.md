# MapleStory OpenAPI Java Library

[![Maven Central](https://img.shields.io/maven-central/v/dev.spiralmoon/maplestory-openapi)](https://search.maven.org/artifact/dev.spiralmoon/maplestory-openapi)

This Java library enables the use of the MapleStory OpenAPI provided by Nexon.

Packages written in other languages can be found [HERE](https://github.com/SpiralMoon/maplestory.openapi).

(한국어 문서는 [이쪽](https://github.com/SpiralMoon/maplestory.openapi/blob/master/java/README-ko.md)입니다.)

## Installation

Install the latest version of the Java library in your java project:

```xml
<dependency>
    <groupId>dev.spiralmoon</groupId>
    <artifactId>maplestory-openapi</artifactId>
    <version>1.1.0</version> <!-- Replace with the latest version -->
</dependency>
```
or 
```groovy
implementation 'dev.spiralmoon:maplestory-openapi:1.1.0' // Replace with the latest version
```

## Usage

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
            final List<CubeHistoryDTO> cubeHistories = response.getCubeHistories();
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

Handle `MapleStoryApiException` to safely make calls, ensuring that specific Status defined in the [MapleStory OpenAPI Guide](https://developers.nexon.com/Maplestory/guides) are not encountered.

While `MapleStoryApi` is designed to prevent the occurrence of certain Status, exceptions may arise due to developer mistakes.

Therefore, it's recommended to use `MapleStoryApiException` for exception handling based on the Status list described in the table below.

| Status | Message                                                 |
|--------|---------------------------------------------------------|
| 400    | Request format error (incorrect parameter input)        |
| 401    | Unauthorized service (unsupported service, service type) |
| 403    | Unauthorized AccessToken usage                          |
| 429    | AccessToken's request allowance (Rate Limit) exceeded   |
| 500    | Internal server error                                   |
| 504    | Internal server processing timeout                      |
