# MapleStory OpenAPI Java Library

[![Maven Central](https://img.shields.io/maven-central/v/dev.spiralmoon/maplestory-openapi)](https://search.maven.org/artifact/dev.spiralmoon/maplestory-openapi)

넥슨에서 제공하는 MapleStory OpenAPI를 Java 환경에서 사용할 수 있게 해주는 라이브러리입니다.

다른 언어로 작성된 패키지는 [여기](https://github.com/SpiralMoon/maplestory.openapi)에서 확인할 수 있습니다.

(English document is [HERE](https://github.com/SpiralMoon/maplestory.openapi/blob/master/java/README.md))

## Installation

Java 기반 프로젝트에 아래 정보를 입력하여 패키지를 추가하세요:

```xml
<dependency>
    <groupId>dev.spiralmoon</groupId>
    <artifactId>maplestory-openapi</artifactId>
    <version>1.1.0</version> <!-- Replace with the latest version -->
</dependency>
```
또는
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

[MapleStory OpenAPI 가이드](https://developers.nexon.com/Maplestory/guides)에 서술된 에러 사유를 `MapleStoryApiException`를 통해 예외 처리 해야합니다.

`MapleStoryApi`는 특정 상태의 예외를 발생시키지 않도록 설계되었으나, 라이브러리를 사용하는 개발자의 실수로 인해 여전히 일부 상태의 예외가 발생할 수 있습니다.

따라서 아래 표에 설명된 상태 목록을 기반으로 `MapleStoryApiException`를 예외 처리하시기 바랍니다.

| Status | Message                             |
|--------|-------------------------------------|
| 400    | 요청 형식 오류 (잘못된 파라미터 입력)              | 
| 401    | 미승인 서비스 (미지원 service, service type) |
| 403    | 허용되지 않은 AccessToken 사용              |
| 429    | AccessToken의 요청 허용량(Rate Limit) 초과  |
| 500    | 서버 내부 에러                            |
| 504    | 서버 내부 처리 timeout                    |
