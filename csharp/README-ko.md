# MapleStory OpenAPI C# Library

[![NuGet](https://img.shields.io/nuget/v/MapleStory.OpenAPI)](https://www.nuget.org/packages/MapleStory.OpenAPI)

넥슨의 MapleStory OpenAPI를 C# 환경에서 사용할 수 있게 해주는 라이브러리입니다.

다른 언어로 작성된 패키지는 [여기](https://github.com/SpiralMoon/maplestory.openapi)에서 확인할 수 있습니다.

(English document is [HERE](https://github.com/SpiralMoon/maplestory.openapi/blob/master/csharp/README.md))

## Installation

NuGet 기반 프로젝트에 아래 정보를 입력하여 패키지를 추가하세요:

```xml
<PackageReference Include="MapleStory.OpenAPI" Version="2.3.1" />
```

## Usage

### API Key

라이브러리를 사용하기 전에 [Nexon Open API 콘솔](https://openapi.nexon.com/my-application/)에서 애플리케이션을 등록하고 **api key**를 발급 받으세요.

### Sample Code

```csharp
using MapleStory.OpenAPI;

var apiKey = "{Your API Key}";
var api = new MapleStoryAPI(apiKey);
var dateTimeOffset = new DateTimeOffset(2023, 10, 15, 0, 0, 0, TimeSpan.FromHours(9));

// run your code
try
{
    var response = await api.GetCubeHistory(1000, dateTimeOffset);

    var count = response.Count;
    var cubeHistory = response.CubeHistory;
    var nextCursor = response.NextCursor;

    Console.WriteLine("You used " + count + " cubes.");
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
