# MapleStory OpenAPI C# Library

[![NuGet](https://img.shields.io/nuget/v/MapleStory.OpenAPI)](https://www.nuget.org/packages/MapleStory.OpenAPI)
[![C#](https://github.com/SpiralMoon/maplestory.openapi/actions/workflows/csharp_test.yaml/badge.svg)](https://github.com/SpiralMoon/maplestory.openapi/actions/workflows/csharp_test.yaml)

This C# library enables the use of the MapleStory OpenAPI of Nexon.

Packages written in other languages can be found [HERE](https://github.com/SpiralMoon/maplestory.openapi).

English | [한국어](./README-ko.md)

## Notice
>💡 Notice 1: Migration is required when updating to version 3.5.0. Please refer to the documentation for [Migration](https://github.com/SpiralMoon/maplestory.openapi/tree/master/csharp/docs/migration-en.md).
>
>🌏 Notice 2: Starting from version 3.4.0, support for tms region has been added. You can now retrieve data from [KMS](https://maplestory.nexon.com/), [TMS](https://maplestory.beanfun.com/), [MSEA](http://www.maplesea.com/index/).
>
>🌏 Notice 3: Starting from version 3.0.0, support for msea region has been added.
>
>💡 Notice 4: Migration is required when updating from version 2.x.x to 3.0.0. Please refer to the documentation for [Migration](https://github.com/SpiralMoon/maplestory.openapi/tree/master/csharp/docs/migration-en.md).

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

Currently, this library supports data retrieval from the KMS, TMS, MSEA regions. To access data from a specific region, import the corresponding namespace.

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

- [Character Information Retrieval](https://github.com/SpiralMoon/maplestory.openapi/blob/master/csharp/MapleStory.Test/KMS/Character)
- [Union Information Retrieval](https://github.com/SpiralMoon/maplestory.openapi/blob/master/csharp/MapleStory.Test/KMS/Union)
- [Guild Information Retrieval](https://github.com/SpiralMoon/maplestory.openapi/blob/master/csharp/MapleStory.Test/KMS/Guild)
- [History Information Retrieval](https://github.com/SpiralMoon/maplestory.openapi/blob/master/csharp/MapleStory.Test/KMS/History)
- [Ranking Information Retrieval](https://github.com/SpiralMoon/maplestory.openapi/blob/master/csharp/MapleStory.Test/KMS/Ranking)
- [Notice Information Retrieval](https://github.com/SpiralMoon/maplestory.openapi/blob/master/csharp/MapleStory.Test/KMS/Notice)

### Features
This library supports all apis published in the MapleStory OpenAPI official docs.

Some features are supported only in specific regions. Please refer to the official documentation for each region for details.

- KMS: [https://openapi.nexon.com/game/maplestory](https://openapi.nexon.com/game/maplestory)
- TMS: [https://openapi.nexon.com/game/maplestorytw](https://openapi.nexon.com/game/maplestorytw)
- MSEA: [https://openapi.nexon.com/game/maplestorysea](https://openapi.nexon.com/game/maplestorysea)

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