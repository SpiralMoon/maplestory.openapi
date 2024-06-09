# MapleStory OpenAPI Java Library

[![Maven Central](https://img.shields.io/maven-central/v/dev.spiralmoon/maplestory-openapi)](https://search.maven.org/artifact/dev.spiralmoon/maplestory-openapi)

넥슨의 MapleStory OpenAPI를 Java 환경에서 사용할 수 있게 해주는 라이브러리입니다.

다른 언어로 작성된 패키지는 [여기](https://github.com/SpiralMoon/maplestory.openapi)에서 확인할 수 있습니다.

(English document is [HERE](https://github.com/SpiralMoon/maplestory.openapi/blob/master/java/README-en.md))

## Installation

Java 기반 프로젝트에 아래 정보를 입력하여 패키지를 추가하세요:

```xml
<dependency>
    <groupId>dev.spiralmoon</groupId>
    <artifactId>maplestory-openapi</artifactId>
    <version>2.5.0</version> <!-- Replace with the latest version -->
</dependency>
```
또는
```groovy
implementation 'dev.spiralmoon:maplestory-openapi:2.5.0' // Replace with the latest version
```

## Usage

### API Key

라이브러리를 사용하기 전에 [Nexon Open API 콘솔](https://openapi.nexon.com/my-application/)에서 애플리케이션을 등록하고 **api key**를 발급 받으세요.

### Sample Code

```java
import dev.spiralmoon.maplestory.api.MapleStoryApi;
import dev.spiralmoon.maplestory.api.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.dto.history.CubeHistoryDTO;
import dev.spiralmoon.maplestory.api.dto.history.CubeHistoryResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

class Sample {
    public static void main(String[] args) {
        final String apiKey = "{Your API Key}";
        final MapleStoryApi api = new MapleStoryApi(apiKey);
        final LocalDateTime localDateTime = LocalDateTime.of(2023, 10, 15, 0, 0);

        // run your code
        try {
            final CubeHistoryResponseDTO response = api.getCubeHistory(1000, localDateTime);

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

[MapleStory OpenAPI 가이드](https://openapi.nexon.com/guide/request-api)에 서술된 에러 사유를 `MapleStoryApiException`를 통해 예외 처리 해야합니다.

`MapleStoryApi`는 특정 상태의 예외를 발생시키지 않도록 설계되었으나, 라이브러리를 사용하는 개발자의 실수로 인해 여전히 일부 상태의 예외가 발생할 수 있습니다.

따라서 아래 표에 설명된 `MapleStoryApiErrorCode` 목록을 기반으로 `MapleStoryApiException`를 예외 처리하시기 바랍니다.

| ErrorCode    | Description        |
|--------------|--------------------|
| OPENAPI00001 | 서버 내부 오류           |
| OPENAPI00002 | 권한이 없는 경우          |
| OPENAPI00003 | 유효하지 않은 식별자        |
| OPENAPI00004 | 파라미터 누락 또는 유효하지 않음 |
| OPENAPI00005 | 유효하지 않은 API KEY    |
| OPENAPI00006 | 유효하지 않은 API PATH   |
| OPENAPI00007 | API 호출량 초과         |
| OPENAPI00009 | 데이터 준비 중           |
| OPENAPI00010 | 게임 점검 중            |
| OPENAPI00011 | API 점검 중           |
