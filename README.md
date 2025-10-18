[한국어](./README-ko.md) | English

[![GitHub contributors](https://img.shields.io/github/contributors/SpiralMoon/maplestory.openapi.svg)](https://github.com/SpiralMoon/maplestory.openapi/graphs/contributors)
[![GitHub issues](https://img.shields.io/github/issues/SpiralMoon/maplestory.openapi.svg)](https://github.com/SpiralMoon/maplestory.openapi/issues)
[![GitHub stars](https://img.shields.io/github/stars/SpiralMoon/maplestory.openapi.svg)](https://github.com/SpiralMoon/maplestory.openapi/stargazers)
[![GitHub forks](https://img.shields.io/github/forks/SpiralMoon/maplestory.openapi.svg)](https://github.com/SpiralMoon/maplestory.openapi/network/members)
[![GitHub license](https://img.shields.io/github/license/SpiralMoon/maplestory.openapi.svg)](https://github.com/SpiralMoon/maplestory.openapi/blob/master/LICENSE)

[![npm](https://img.shields.io/npm/v/maplestory-openapi)](https://www.npmjs.com/package/maplestory-openapi)
[![Maven Central](https://img.shields.io/maven-central/v/dev.spiralmoon/maplestory-openapi)](https://search.maven.org/artifact/dev.spiralmoon/maplestory-openapi)
[![NuGet](https://img.shields.io/nuget/v/MapleStory.OpenAPI)](https://www.nuget.org/packages/MapleStory.OpenAPI)
[![PyPi](https://img.shields.io/pypi/v/maplestory-openapi)](https://pypi.org/project/maplestory-openapi)

[![JS](https://github.com/SpiralMoon/maplestory.openapi/actions/workflows/js_test.yaml/badge.svg)](https://github.com/SpiralMoon/maplestory.openapi/actions/workflows/js_test.yaml)
[![Java](https://github.com/SpiralMoon/maplestory.openapi/actions/workflows/java_test.yaml/badge.svg)](https://github.com/SpiralMoon/maplestory.openapi/actions/workflows/java_test.yaml)
[![C#](https://github.com/SpiralMoon/maplestory.openapi/actions/workflows/csharp_test.yaml/badge.svg)](https://github.com/SpiralMoon/maplestory.openapi/actions/workflows/csharp_test.yaml)
[![Python](https://github.com/SpiralMoon/maplestory.openapi/actions/workflows/python_test.yaml/badge.svg)](https://github.com/SpiralMoon/maplestory.openapi/actions/workflows/python_test.yaml)

<div align="center">
    <img src="./logo.png" width="120" height="120"/>
</div>
<h1 align="center">🍁 MapleStory OpenAPI Library 🍁</h1>
<p align="center">This library project enables the use of the MapleStory OpenAPI of Nexon.</p>

>💻 This library is maintained in sync with Nexon OpenAPI patches. It is recommended to always use the latest version.
>
>🌏 Notice 1: Starting from version 3.4.0, support for tms region has been added. You can now retrieve data from [KMS](https://maplestory.nexon.com/), [TMS](https://maplestory.beanfun.com/), [MSEA](http://www.maplesea.com/index/).
>
>🌏 Notice 2: Starting from version 3.0.0, support for msea region has been added.
> 
> 💡 Notice 2: Migration is required when updating from version 2.x.x to 3.0.0. Please refer to the documentation for details.

## Supported
### Languages
<div align="center">
    <table>
      <tr>
        <td align="center">
          <a href="https://www.npmjs.com/package/maplestory-openapi" target="_blank" rel="noreferrer">
            <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/javascript/javascript-original.svg" alt="javascript" width="40" height="40"/>
          </a>
          <a href="https://www.npmjs.com/package/maplestory-openapi" target="_blank" rel="noreferrer">
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

### Regions
<div align="center">
    <table>
      <tr>
        <td align="center">
          <a href="https://maplestory.nexon.com/" target="_blank" rel="noreferrer">
            <img src="https://github.com/SpiralMoon/maplestory.openapi/blob/master/logo/kms.png" alt="KMS" />
          </a>
        </td>
        <td align="center">
          <a href="https://www.nexon.com/maplestory/" target="_blank" rel="noreferrer">
            <img src="https://github.com/SpiralMoon/maplestory.openapi/blob/master/logo/gms.png" alt="GMS" />
          </a>
        </td>
        <td align="center">
          <a href="https://maplestory.nexon.co.jp/" target="_blank" rel="noreferrer">
            <img src="https://github.com/SpiralMoon/maplestory.openapi/blob/master/logo/jms.png" alt="JMS" />
          </a>
        </td>
      </tr>
      <tr>
        <td align="center">
          <a href="https://openapi.nexon.com/ko/game/maplestory/?id=14" target="_blank" rel="noreferrer">
            <img src="https://img.shields.io/badge/KMS-support-green" />
          </a>
        </td>
        <td align="center">
          <a target="_blank" rel="noreferrer">
            <img src="https://img.shields.io/badge/GMS-not_supported-red" />
          </a>
        </td>
        <td align="center">
          <a target="_blank" rel="noreferrer">
            <img src="https://img.shields.io/badge/JMS-not_supported-red" />
          </a>
        </td>
      </tr>
      <tr>
        <td align="center">
          <a href="http://www.maplesea.com/index" target="_blank" rel="noreferrer">
            <img src="https://github.com/SpiralMoon/maplestory.openapi/blob/master/logo/msea.png" alt="MSEA" />
          </a>
        </td>
        <td align="center">
          <a href="http://maplestory.beanfun.com/" target="_blank" rel="noreferrer">
            <img src="https://github.com/SpiralMoon/maplestory.openapi/blob/master/logo/tms.png" alt="TMS" />
          </a>
        </td>
        <td align="center">
          <a href="https://mxd.web.sdo.com/web7/home/index.html" target="_blank" rel="noreferrer">
            <img src="https://github.com/SpiralMoon/maplestory.openapi/blob/master/logo/cms.png" alt="CMS" />
          </a>
        </td>
      </tr>
      <tr>
        <td align="center">
          <a href="https://openapi.nexon.com/en/game/maplestorysea/?id=45" target="_blank" rel="noreferrer">
            <img src="https://img.shields.io/badge/MSEA-support-green" />
          </a>
        </td>
        <td align="center">
          <a target="_blank" rel="noreferrer">
            <img src="https://img.shields.io/badge/TMS-support-green" />
          </a>
        </td>
        <td align="center">
          <a target="_blank" rel="noreferrer">
            <img src="https://img.shields.io/badge/CMS-not_supported-red" />
          </a>
        </td>
      </tr>
    </table>
</div>

This library can only retrieve data from the service regions supported by the Nexon Open API. If Nexon releases an API for a new region, this project plans to support it as well.

## Documentation
Before getting started, please read the document in the README list below that matches your development environment.

- Go to read [**JavaScript(TypeScript)** document](./js/README.md).
- Go to read [**Java** document](./java/README.md).
- Go to read [**C#** document](./csharp/README.md).
- Go to read [**Python** document](./python/README.md).

## Features
This library supports all apis published in the MapleStory OpenAPI official docs.

- Character Information Retrieval
- Union Information Retrieval
- Guild Information Retrieval
- History Information Retrieval
- Ranking Information Retrieval
- Notice Information Retrieval

Some features are supported only in specific regions. Please refer to the official documentation for each region for details.

- KMS: [https://openapi.nexon.com/game/maplestory](https://openapi.nexon.com/game/maplestory)
- TMS: [https://openapi.nexon.com/game/maplestorytw](https://openapi.nexon.com/game/maplestorytw)
- MSEA: [https://openapi.nexon.com/game/maplestorysea](https://openapi.nexon.com/game/maplestorysea)

And, while not part of the MapleStory OpenAPI specifications, it additionally supports the following API.

- [Get server inspection information](https://api.maplestory.nexon.com/soap/maplestory.asmx?op=GetInspectionInfo)

## Release note
1. The main changes to this library are documented in the [release notes](https://github.com/SpiralMoon/maplestory.openapi/releases).
2. Migration is required during major version updates. Please refer to the documentation for each package.

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
4. This library is nonofficial.
5. Data based on [NEXON Open API](https://openapi.nexon.com)

## License

This project is licensed under the MIT License - see the [LICENSE](./LICENSE) file for details.
