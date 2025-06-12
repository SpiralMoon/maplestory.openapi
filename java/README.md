# MapleStory OpenAPI Java Library

[![Maven Central](https://img.shields.io/maven-central/v/dev.spiralmoon/maplestory-openapi)](https://search.maven.org/artifact/dev.spiralmoon/maplestory-openapi)
[![Java](https://github.com/SpiralMoon/maplestory.openapi/actions/workflows/java_test.yaml/badge.svg)](https://github.com/SpiralMoon/maplestory.openapi/actions/workflows/java_test.yaml)

넥슨의 MapleStory OpenAPI를 Java 환경에서 사용할 수 있게 해주는 라이브러리입니다.

다른 언어로 작성된 패키지는 [여기](https://github.com/SpiralMoon/maplestory.openapi)에서 확인할 수 있습니다.

(English document is [HERE](https://github.com/SpiralMoon/maplestory.openapi/blob/master/java/README-en.md))

## Notice

>🌏 알림1: 3.0.0 버전부터 여러 서비스 지역에 대한 지원이 추가 되었습니다. 현재 [KMS](https://maplestory.nexon.com/), [MSEA](http://www.maplesea.com/index/)의 데이터를 조회 가능합니다.
>
>💡 알림2: Version 2.x.x → 3.0.0 업데이트 과정에서 마이그레이션이 필요합니다. [Migration](https://github.com/SpiralMoon/maplestory.openapi/tree/master/java/docs/migration-ko.md) 항목을 참고 해주세요.

## Installation

Java 기반 프로젝트에 아래 정보를 입력하여 패키지를 추가하세요:

```xml
<dependency>
    <groupId>dev.spiralmoon</groupId>
    <artifactId>maplestory-openapi</artifactId>
</dependency>
```
또는
```groovy
implementation 'dev.spiralmoon:maplestory-openapi:+'
```

## Usage

### API Key

라이브러리를 사용하기 전에 [Nexon Open API 콘솔](https://openapi.nexon.com/my-application/)에서 애플리케이션을 등록하고 **api key**를 발급 받으세요.

애플리케이션은 지역별로 따로 등록해야 합니다. (KMS의 api key로 MSEA의 데이터를 요청할 수 없음)

### Region

현재 KMS, MSEA 지역에 대한 데이터 조회를 지원 합니다. 조회를 원하는 지역별로 패키지 경로를 다르게 설정 합니다.

```java
import dev.spiralmoon.maplestory.api.kms.MapleStoryApi; // data from KMS
// or
import dev.spiralmoon.maplestory.api.msea.MapleStoryApi; // data from MSEA
```

지역이 달라도 동일한 인터페이스를 상속하기 때문에 API의 사용 경험은 기본적으로 동일 합니다.

### Sample Code

아래 코드는 KMS 서버에서 닉네임을 바탕으로 특정 캐릭터의 식별자를 조회한 후 캐릭터의 기본 정보를 조회하는 예시입니다.

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

더 많은 예시는 아래 링크의 테스트 케이스에서 확인할 수 있습니다.

- [캐릭터 정보 조회](https://github.com/SpiralMoon/maplestory.openapi/blob/master/java/src/test/java/CharacterApi.java)
- [유니온 정보 조회](https://github.com/SpiralMoon/maplestory.openapi/blob/master/java/src/test/java/UnionApi.java)
- [길드 정보 조회](https://github.com/SpiralMoon/maplestory.openapi/blob/master/java/src/test/java/GuildApi.java)
- [확률 정보 조회](https://github.com/SpiralMoon/maplestory.openapi/blob/master/java/src/test/java/HistoryApi.java)
- [랭킹 정보 조회](https://github.com/SpiralMoon/maplestory.openapi/blob/master/java/src/test/java/RankingApi.java)
- [공지 정보 조회](https://github.com/SpiralMoon/maplestory.openapi/blob/master/java/src/test/java/NoticeApi.java)

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
