# MapleStory OpenAPI Library

This library project enables the use of the MapleStory OpenAPI of Nexon.

Before using the library, register your application and obtain an **api key** from the [Nexon Open API Console](https://openapi.nexon.com/my-application/).

This library project is capable of retrieving only KMS(Korea MapleStory) data.

(한국어 문서는 [이쪽](./README-ko.md)입니다.)

## Supported Languages

1. **Java**: [![Maven Central](https://img.shields.io/maven-central/v/dev.spiralmoon/maplestory-openapi)](https://search.maven.org/artifact/dev.spiralmoon/maplestory-openapi)
2. **JavaScript (TypeScript)**: [![npm](https://img.shields.io/npm/v/maplestory-openapi)](https://www.npmjs.com/package/maplestory-openapi)
3. **C#**: [![NuGet](https://img.shields.io/nuget/v/MapleStory.OpenAPI)](https://www.nuget.org/packages/MapleStory.OpenAPI)

## Installation

### Java

Include the latest version of the Java library in your java project by adding the following dependency:

```xml
<dependency>
    <groupId>dev.spiralmoon</groupId>
    <artifactId>maplestory-openapi</artifactId>
    <version>2.2.0</version> <!-- Replace with the latest version -->
</dependency>
```
or
```groovy
implementation 'dev.spiralmoon:maplestory-openapi:2.2.0' // Replace with the latest version
```

For detailed information on how to use the library in Java, refer to the [HERE](./java/README.md).

### JavaScript (TypeScript)

Install the latest version of the JavaScript/TypeScript library in your npm project:

```bash
npm install maplestory-openapi
```

For detailed information on how to use the library in JavaScript/TypeScript, refer to the [HERE](./js/README.md).

### C#

Add the latest version of the C# library to your NuGet project:


```xml
<PackageReference Include="MapleStory.OpenAPI" Version="2.2.0" />
```


For detailed information on how to use the library in C#, refer to the [HERE](./csharp/README.md).

## Features
This library supports all apis published in the link below.

1. [Get character information](https://openapi.nexon.com/game/maplestory/?id=22)
2. [Get union information](https://openapi.nexon.com/game/maplestory/?id=23)
3. [Get guild information](https://openapi.nexon.com/game/maplestory/?id=24)
4. [Get probability information](https://openapi.nexon.com/game/maplestory/?id=25)
5. [Get ranking information](https://openapi.nexon.com/game/maplestory/?id=26)
6. [Get server inspection information](https://api.maplestory.nexon.com/soap/maplestory.asmx?op=GetInspectionInfo)

## Additional Information

1. The implementation details of the API are documented on the [MapleStory OpenAPI spec](https://openapi.nexon.com/game/maplestory). Refer to the documentation for each language.
2. This library adheres to language-specific naming style guides, resulting in slight differences from the naming conventions in the official documentation. ex) 'cube_history' -> 'cubeHistory'
3. The comments for the methods and properties provided by this library are synchronized with the official documentation.
4. Data based on [NEXON Open API](https://openapi.nexon.com)
5. Contributions from other developers are welcome! Feel free to contribute by submitting pull requests.

## License

This project is licensed under the MIT License - see the [LICENSE](./LICENSE) file for details.