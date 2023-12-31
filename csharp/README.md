# MapleStory OpenAPI C# Library

[![NuGet](https://img.shields.io/nuget/v/MapleStory.OpenAPI)](https://www.nuget.org/packages/MapleStory.OpenAPI)

This C# library enables the use of the MapleStory OpenAPI of Nexon.

Packages written in other languages can be found [HERE](https://github.com/SpiralMoon/maplestory.openapi).

(한국어 문서는 [이쪽](https://github.com/SpiralMoon/maplestory.openapi/blob/master/csharp/README-ko.md)입니다.)

## Installation

Install the latest version of the C# library in your NuGet project:

```xml
<PackageReference Include="MapleStory.OpenAPI" Version="2.3.0" />
```

## Usage

### API Key

Before using the library, register your application and obtain an **api key** from the [Nexon Open API Console](https://openapi.nexon.com/my-application/).

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

Handle `MapleStoryAPIException` to safely make calls, ensuring that specific Status defined in the [MapleStory OpenAPI Guide](https://openapi.nexon.com/guide/request-api) are not encountered.

While `MapleStoryAPI` is designed to prevent the occurrence of certain Status, exceptions may arise due to developer mistakes.

Therefore, it's recommended to use `MapleStoryAPIException` for exception handling based on the `MapleStoryAPIErrorCode` list described in the table below.

| ErrorCode    | Description                                     |
|--------------|-------------------------------------------------|
| OPENAPI00001 | Internal server error                           |
| OPENAPI00002 | Access denied                                   |
| OPENAPI00003 | Invalid identifier                              |
| OPENAPI00004 | Request format error (incorrect parameter input) |
| OPENAPI00005 | Invalid api key                                 |
| OPENAPI00006 | Invalid api path                                |
| OPENAPI00007 | Request allowance (Rate Limit) exceeded         |
