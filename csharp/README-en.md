# MapleStory OpenAPI C# Library

[![NuGet](https://img.shields.io/nuget/v/MapleStory.OpenAPI)](https://www.nuget.org/packages/MapleStory.OpenAPI)
[![C#](https://github.com/SpiralMoon/maplestory.openapi/actions/workflows/csharp_test.yaml/badge.svg)](https://github.com/SpiralMoon/maplestory.openapi/actions/workflows/csharp_test.yaml)

This C# library enables the use of the MapleStory OpenAPI of Nexon.

Packages written in other languages can be found [HERE](https://github.com/SpiralMoon/maplestory.openapi).

(한국어 문서는 [이쪽](https://github.com/SpiralMoon/maplestory.openapi/blob/master/csharp/README.md)입니다.)

## Notice

>🌏 Notice 1: Starting from version 3.0.0, support for multiple service regions has been added. You can now retrieve data from [KMS](https://maplestory.nexon.com/) and [MSEA](http://www.maplesea.com/index/).
>
>💡 Notice 2: Migration is required when updating from version 2.x.x to 3.0.0. Please refer to the documentation for [Migration](https://github.com/SpiralMoon/maplestory.openapi/tree/master/csharp/docs/migration-en.md).

## Installation

Install the latest version of the C# library in your NuGet project:

```bash
dotnet add package MapleStory.OpenAPI
```

## Usage

### API Key

Before using the library, register your application and obtain an **api key** from the [Nexon Open API Console](https://openapi.nexon.com/my-application/).

Applications must be registered separately for each region. (For example, an API key issued for KMS cannot be used to request data from MSEA.)

### Region

Currently, this library supports data retrieval from the KMS and MSEA regions. To access data from a specific region, import the corresponding namespace.

```csharp
using MapleStory.OpenAPI.KMS; // data from KMS
// or
using MapleStory.OpenAPI.MSEA; // data from MSEA
```

Even though the regions differ, each package inherits the same interface, ensuring a consistent API usage experience across all regions.

### Sample Code

Below is an example that retrieves the identifier of a specific character from the KMS server based on the nickname, and then fetches that character’s basic information.

```csharp
using MapleStory.OpenAPI.KMS;

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

You can find more examples in the test cases at the following link.

- [Get character information](https://github.com/SpiralMoon/maplestory.openapi/blob/master/csharp/MapleStory.Test/CharacterAPI.cs)
- [Get union information](https://github.com/SpiralMoon/maplestory.openapi/blob/master/csharp/MapleStory.Test/UnionAPI.cs)
- [Get guild information](https://github.com/SpiralMoon/maplestory.openapi/blob/master/csharp/MapleStory.Test/GuildAPI.cs)
- [Get history information](https://github.com/SpiralMoon/maplestory.openapi/blob/master/csharp/MapleStory.Test/HistoryAPI.cs)
- [Get ranking information](https://github.com/SpiralMoon/maplestory.openapi/blob/master/csharp/MapleStory.Test/RankingAPI.cs)
- [Get notice information](https://github.com/SpiralMoon/maplestory.openapi/blob/master/csharp/MapleStory.Test/NoticeAPI.cs)

### Exception Handling

Handle `MapleStoryAPIException` to safely make calls, ensuring that specific Status defined in the [MapleStory OpenAPI Guide](https://openapi.nexon.com/guide/request-api) are not encountered.

While `MapleStoryAPI` is designed to prevent the occurrence of certain Status, exceptions may arise due to developer mistakes.

Therefore, it's recommended to use `MapleStoryAPIException` for exception handling based on the `MapleStoryAPIErrorCode` list described in the table below.

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
