# MapleStory OpenAPI C# Library

[![NuGet](https://img.shields.io/nuget/v/MapleStory.OpenAPI)](https://www.nuget.org/packages/MapleStory.OpenAPI)
[![C#](https://github.com/SpiralMoon/maplestory.openapi/actions/workflows/csharp_test.yaml/badge.svg)](https://github.com/SpiralMoon/maplestory.openapi/actions/workflows/csharp_test.yaml)

넥슨의 MapleStory OpenAPI를 C# 환경에서 사용할 수 있게 해주는 라이브러리입니다.

다른 언어로 작성된 패키지는 [여기](https://github.com/SpiralMoon/maplestory.openapi)에서 확인할 수 있습니다.

(English document is [HERE](https://github.com/SpiralMoon/maplestory.openapi/blob/master/csharp/README-en.md))

## Installation

NuGet 기반 프로젝트에 아래 정보를 입력하여 패키지를 추가하세요:

```bash
dotnet add package MapleStory.OpenAPI
```

## Usage

### API Key

라이브러리를 사용하기 전에 [Nexon Open API 콘솔](https://openapi.nexon.com/my-application/)에서 애플리케이션을 등록하고 **api key**를 발급 받으세요.

### Sample Code

아래 코드는 닉네임을 바탕으로 특정 캐릭터의 식별자를 조회한 후 캐릭터의 기본 정보를 조회하는 예시입니다.

```csharp
using MapleStory.OpenAPI;

var apiKey = "{Your API Key}";
var api = new MapleStoryAPI(apiKey);

// run your code
try
{
    var character = await api.GetCharacter("{Your Character Name}");
    var characterBasic = await api.GetCharacterBasic(character.OCID);

    Console.WriteLine(characterBasic.ToJson());
}
// exception handling
catch (MapleStoryAPIException e)
{
    // handle MapleStoryApiException
}
catch (HttpRequestException e)
{
    // handle HttpRequestException
}
```

더 많은 예시는 아래 링크의 테스트 케이스에서 확인할 수 있습니다.

- [캐릭터 정보 조회](https://github.com/SpiralMoon/maplestory.openapi/blob/master/csharp/MapleStory.Test/CharacterAPI.cs)
- [유니온 정보 조회](https://github.com/SpiralMoon/maplestory.openapi/blob/master/csharp/MapleStory.Test/UnionAPI.cs)
- [길드 정보 조회](https://github.com/SpiralMoon/maplestory.openapi/blob/master/csharp/MapleStory.Test/GuildAPI.cs)
- [확률 정보 조회](https://github.com/SpiralMoon/maplestory.openapi/blob/master/csharp/MapleStory.Test/HistoryAPI.cs)
- [랭킹 정보 조회](https://github.com/SpiralMoon/maplestory.openapi/blob/master/csharp/MapleStory.Test/RankingAPI.cs)

### Exception Handling

[MapleStory OpenAPI 가이드](https://openapi.nexon.com/guide/request-api)에 서술된 에러 사유를 `MapleStoryAPIException`를 통해 예외 처리 해야합니다.

`MapleStoryAPI`는 특정 상태의 예외를 발생시키지 않도록 설계되었으나, 라이브러리를 사용하는 개발자의 실수로 인해 여전히 일부 상태의 예외가 발생할 수 있습니다.

따라서 아래 표에 설명된 `MapleStoryAPIErrorCode` 목록을 기반으로 `MapleStoryAPIException`를 예외 처리하시기 바랍니다.

| ErrorCode    | Description       |
|--------------|-------------------|
| OPENAPI00001 | 서버 내부 오류          |
| OPENAPI00002 | 권한이 없는 경우         |
| OPENAPI00003 | 유효하지 않은 식별자       |
| OPENAPI00004 | 파라미터 누락 또는 유효하지 않음 |
| OPENAPI00005 | 유효하지 않은 API KEY   |
| OPENAPI00006 | 유효하지 않은 API PATH  |
| OPENAPI00007 | API 호출량 초과        |
| OPENAPI00009 | 데이터 준비 중          |
| OPENAPI00010 | 게임 점검 중           |
| OPENAPI00010 | API 점검 중          |
