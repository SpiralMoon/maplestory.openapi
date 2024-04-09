[한국어](./README) | English

[![GitHub contributors](https://img.shields.io/github/contributors/SpiralMoon/maplestory.openapi.svg)](https://github.com/SpiralMoon/maplestory.openapi/graphs/contributors)
[![GitHub issues](https://img.shields.io/github/issues/SpiralMoon/maplestory.openapi.svg)](https://github.com/SpiralMoon/maplestory.openapi/issues)
[![GitHub stars](https://img.shields.io/github/stars/SpiralMoon/maplestory.openapi.svg)](https://github.com/SpiralMoon/maplestory.openapi/stargazers)
[![GitHub forks](https://img.shields.io/github/forks/SpiralMoon/maplestory.openapi.svg)](https://github.com/SpiralMoon/maplestory.openapi/network/members)
[![GitHub license](https://img.shields.io/github/license/SpiralMoon/maplestory.openapi.svg)](https://github.com/SpiralMoon/maplestory.openapi/blob/master/LICENSE)

[![npm](https://img.shields.io/npm/v/maplestory-openapi)](https://www.npmjs.com/package/maplestory-openapi)
[![Maven Central](https://img.shields.io/maven-central/v/dev.spiralmoon/maplestory-openapi)](https://search.maven.org/artifact/dev.spiralmoon/maplestory-openapi)
[![NuGet](https://img.shields.io/nuget/v/MapleStory.OpenAPI)](https://www.nuget.org/packages/MapleStory.OpenAPI)
[![PyPi](https://img.shields.io/pypi/v/maplestory-openapi)](https://pypi.org/project/maplestory-openapi)

<div align="center">
    <img src="./logo.png" width="120" height="120"/>
</div>
<h1 align="center">🍁 MapleStory OpenAPI Library 🍁</h1>
<p align="center">This library project enables the use of the MapleStory OpenAPI of Nexon.</p>

>💡 Note: This library project is capable of retrieving only [KMS](https://maplestory.nexon.com/)(Korea MapleStory) data.

## Getting Started
### Supported Languages
<div align="center">
    <table>
      <tr>
        <td align="center">
          <a href="https://www.npmjs.com/package/maplestory-openapi" target="_blank" rel="noreferrer">
            <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/javascript/javascript-original.svg" alt="javascript" width="40" height="40"/>
          </a>
          <a href="https://search.maven.org/artifact/dev.spiralmoon/maplestory-openapi" target="_blank" rel="noreferrer">
            <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/typescript/typescript-original.svg" alt="typescript" width="40" height="40"/>
          </a>
        </td>
        <td align="center">
          <a href="https://search.maven.org/artifact/dev.spiralmoon/maplestory-openapi" target="_blank" rel="noreferrer">
            <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/>
          </a>
        </td>
        <td align="center">
          <a href="https://www.nuget.org/packages/MapleStory.OpenAPI" target="_blank" rel="noreferrer">
            <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/csharp/csharp-original.svg" alt="csharp" width="40" height="40"/>
          </a>
        </td>
        <td align="center">
          <a href="https://pypi.org/project/maplestory_openapi" target="_blank" rel="noreferrer">
            <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/python/python-original.svg" alt="python" width="40" height="40"/>
          </a>
        </td>
      </tr>
      <tr>
        <td align="center">
          <a href="https://www.npmjs.com/package/maplestory-openapi" target="_blank" rel="noreferrer">
            <img src="https://img.shields.io/npm/v/maplestory-openapi?label=" alt="typescript"/>
          </a>
        </td>
        <td align="center">
          <a href="https://search.maven.org/artifact/dev.spiralmoon/maplestory-openapi" target="_blank" rel="noreferrer">
            <img src="https://img.shields.io/maven-central/v/dev.spiralmoon/maplestory-openapi?label=" alt="csharp"/>
          </a>
        </td>
        <td align="center">
          <a href="https://www.nuget.org/packages/MapleStory.OpenAPI" target="_blank" rel="noreferrer">
            <img src="https://img.shields.io/nuget/v/MapleStory.OpenAPI?label=" alt="java"/>
          </a>
        </td>
        <td align="center">
          <a href="https://pypi.org/project/maplestory_openapi" target="_blank" rel="noreferrer">
            <img src="https://img.shields.io/pypi/v/maplestory-openapi?label=" alt="python"/>
          </a>
        </td>
      </tr>
    </table>
</div>

This library project is concurrently provided in various languages, including JavaScript(TypeScript), Java, C#, Python, and more, and is available on package repositories.
### Documentation
Before getting started, please read the document in the README list below that matches your development environment.

- Go to read [**JavaScript(TypeScript)** document](./js/README-en).
- Go to read [**Java** document](./java/README-en).
- Go to read [**C#** document](./csharp/README-en).
- Go to read [**Python** document](./python/README-en).

## Features
This library supports all apis published in the [MapleStory OpenAPI official docs](https://openapi.nexon.com/game/maplestory) link below.

- [Get character information](https://openapi.nexon.com/game/maplestory/?id=22)
- [Get union information](https://openapi.nexon.com/game/maplestory/?id=23)
- [Get guild information](https://openapi.nexon.com/game/maplestory/?id=24)
- [Get cube, potential, starforce history information](https://openapi.nexon.com/game/maplestory/?id=25)
- [Get ranking information](https://openapi.nexon.com/game/maplestory/?id=26)

And, while not part of the MapleStory OpenAPI specifications, it additionally supports the following API.

- [Get server inspection information](https://api.maplestory.nexon.com/soap/maplestory.asmx?op=GetInspectionInfo)

## Contributors
<a href="https://github.com/SpiralMoon/maplestory.openapi/graphs/contributors">
    <img src="https://contrib.rocks/image?repo=SpiralMoon/maplestory.openapi" />
</a>

This project exists thanks to all the people who contribute.

Contributions from other developers are welcome! Feel free to contribute by submitting pull requests.

Please give us a ⭐ star ⭐ to support us. Thank you.💖

## Additional Information

1. The implementation details of the API are documented on the [MapleStory OpenAPI spec](https://openapi.nexon.com/game/maplestory). Refer to the documentation for each language.
2. This library adheres to language-specific naming style guides, resulting in slight differences from the naming conventions in the official documentation. ex) 'cube_history' -> 'cubeHistory'
3. The comments for the methods and properties provided by this library are synchronized with the official documentation.
4. Data based on [NEXON Open API](https://openapi.nexon.com)

## License

This project is licensed under the MIT License - see the [LICENSE](./LICENSE) file for details.
