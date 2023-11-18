# MapleStory OpenAPI C# Library

[![NuGet](https://img.shields.io/nuget/v/MapleStory.OpenAPI)](https://www.nuget.org/packages/MapleStory.OpenAPI)

This C# library enables the use of the MapleStory OpenAPI provided by Nexon.

Packages written in other languages can be found [HERE](https://github.com/SpiralMoon/maplestory.openapi).

## Installation

Install the latest version of the C# library in your NuGet project:

```xml
<PackageReference Include="MapleStory.OpenAPI" Version="1.0.0" />
```

## Usage

### Sample Code

```csharp
using MapleStory.OpenAPI;

var apiKey = "{Your API Key}";
var api = new MapleStoryAPI(apiKey);

// run your code
try
{
    var response = await api.GetCubeResult(1000, 2023, 10, 15);

    var count = response.Count;
    var cubeHistories = response.CubeHistories;
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

Handle `MapleStoryAPIException` to safely make calls, ensuring that specific Status defined in the [MapleStory OpenAPI Guide](https://developers.nexon.com/Maplestory/guides) are not encountered.

While `MapleStoryAPI` is designed to prevent the occurrence of certain Status, exceptions may arise due to developer mistakes.

Therefore, it's recommended to use `MapleStoryAPIException` for exception handling based on the Status list described in the table below.

| Status | Message                                                 |
|--------|---------------------------------------------------------|
| 400    | Request format error (incorrect parameter input)        |
| 401    | Unauthorized service (unsupported service, service type) |
| 403    | Unauthorized AccessToken usage                          |
| 429    | AccessToken's request allowance (Rate Limit) exceeded   |
| 500    | Internal server error                                   |
| 504    | Internal server processing timeout                      |
