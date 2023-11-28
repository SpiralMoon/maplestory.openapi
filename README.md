# MapleStory OpenAPI Library

This library project enables the use of the MapleStory OpenAPI provided by Nexon.

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
    <version>1.0.0</version> <!-- Replace with the latest version -->
</dependency>
```
or
```groovy
implementation 'dev.spiralmoon:maplestory-openapi:1.0.0' // Replace with the latest version
```

For detailed information on how to use the library in Java, refer to the [HERE](./java/README.md).

### JavaScript (TypeScript)

Install the latest version of the JavaScript/TypeScript library in your npm project:

```bash
npm install maplestory-openapi@1.0.0
```

For detailed information on how to use the library in JavaScript/TypeScript, refer to the [HERE](./js/README.md).

### C#

Add the latest version of the C# library to your NuGet project:


```xml
<PackageReference Include="MapleStory.OpenAPI" Version="1.0.0" />
```


For detailed information on how to use the library in C#, refer to the [HERE](./csharp/README.md).

## Features

1. Get cube usage history
2. ~~Get star-force enhancement history~~ (coming soon)
3. ~~Get character information~~ (coming soon)

## Additional Information

1. The implementation details of the API are documented on the [MapleStory OpenAPI spec](https://developers.nexon.com/Maplestory/apiList). Refer to the documentation for each language.
2. Data based on [NEXON DEVELOPERS](https://developers.nexon.com)
3. Contributions from other developers are welcome! Feel free to contribute by submitting pull requests.

## License

This project is licensed under the MIT License - see the [LICENSE](./LICENSE) file for details.