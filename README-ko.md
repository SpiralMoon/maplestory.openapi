한국어 | [English](./README.md) 

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
<p align="center">넥슨의 MapleStory OpenAPI를 사용할 수 있게 해주는 라이브러리입니다.</p>

> 💻 넥슨 OpenAPI 패치를 따라가며 관리되고 있습니다. 항상 최신 버전 사용을 권장합니다.
> 
>💡 알림1: Version 3.5.0로의 업데이트 과정에서 마이그레이션이 필요합니다. 문서를 참고 해주세요.
> 
>🌏 알림2: 3.4.0 버전부터 TMS 서비스 지역에 대한 지원이 추가 되었습니다. 현재 [KMS](https://maplestory.nexon.com/), [TMS](https://maplestory.beanfun.com/), [MSEA](http://www.maplesea.com/index/)의 데이터를 조회 가능합니다.
>
>🌏 알림3: 3.0.0 버전부터 MSEA 서비스 지역에 대한 지원이 추가 되었습니다.
> 
>💡 알림4: Version 2.x.x → 3.0.0 업데이트 과정에서 마이그레이션이 필요합니다. 문서를 참고 해주세요.


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

이 라이브러리 프로젝트는 JavaScript(TypeScript), Java, C#, Python 등 여러 언어로 개발되어 패키지 저장소에서 동시에 제공됩니다.

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

이 라이브러리는 Nexon Open API에서 지원하는 서비스 지역의 데이터만 조회할 수 있습니다. 넥슨이 새로운 지역에 대한 API를 공개할 경우 이 프로젝트에서도 지원할 계획입니다.

## Documentation
시작하기 전에, 아래의 README 목록에서 자신의 개발 환경과 일치하는 문서를 읽어보세요.

- [**JavaScript(TypeScript)** 사용법](./js/README.md)
- [**Java** 사용법](./java/README.md)
- [**C#** 사용법](./csharp/README.md)
- [**Python** 사용법](./python/README.md)

## Features

이 라이브러리는 메이플스토리 OpenAPI 공식 문서에 기재된 모든 API를 지원합니다.

- 캐릭터 정보 조회
- 유니온 정보 조회
- 길드 정보 조회
- 확률 정보 조회
- 랭킹 정보 조회
- 공지 정보 조회

일부 기능은 특정 지역에서만 지원되므로 자세한 내용은 각 리전의 공식 문서를 참고하세요.

- KMS: [https://openapi.nexon.com/game/maplestory](https://openapi.nexon.com/game/maplestory)
- TMS: [https://openapi.nexon.com/game/maplestorytw](https://openapi.nexon.com/game/maplestorytw)
- MSEA: [https://openapi.nexon.com/game/maplestorysea](https://openapi.nexon.com/game/maplestorysea)

그리고 메이플스토리 OpenAPI 사양에는 포함되어 있지 않지만, 추가적으로 아래 API를 지원합니다.

- [서버 점검 정보 조회](https://api.maplestory.nexon.com/soap/maplestory.asmx?op=GetInspectionInfo)

## Release note
1. 이 라이브러리의 주요 변경사항은 [릴리즈 노트](https://github.com/SpiralMoon/maplestory.openapi/releases)를 통해 안내하고 있습니다.
2. 주요 버전 업데이트 과정에서 마이그레이션이 필요합니다. 패키지별 문서를 참고 해주세요.

## Contributors
<a href="https://github.com/SpiralMoon/maplestory.openapi/graphs/contributors">
    <img src="https://contrib.rocks/image?repo=SpiralMoon/maplestory.openapi" />
</a>

이 프로젝트는 기여해주신 모든 분들 덕분에 존재합니다. 다른 개발자의 참여를 환영합니다! 적극적으로 PR을 보내주세요.

⭐ 스타 ⭐를 눌러서 우리를 응원해주세요. 감사합니다 💖

## Additional Information

1. 이 라이브러리는 [MapleStory OpenAPI spec](https://openapi.nexon.com/game/maplestory)의 기능을 사용할 수 있도록 만든 구현체입니다. 언어별 문서를 확인하여 사용법을 확인하세요.
2. 이 라이브러리는 언어별 네이밍 스타일가이드를 준수하였기 때문에 공식 문서의 네이밍 규칙과 약간의 차이가 있습니다. ex) 'cube_history' -> 'cubeHistory'
3. 이 라이브러리에서 제공하는 메소드와 프로퍼티에 대한 주석은 공식 문서와 동기화하고 있습니다.
4. 이 라이브러리는 공식이 아닙니다.
5. 데이터는 [NEXON Open API](https://openapi.nexon.com)에서 제공받고 있습니다.

## License

This project is licensed under the MIT License - see the [LICENSE](./LICENSE) file for details.
