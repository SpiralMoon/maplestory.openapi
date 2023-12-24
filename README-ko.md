# MapleStory OpenAPI Library

넥슨의 MapleStory OpenAPI를 사용할 수 있게 해주는 라이브러리입니다.

라이브러리를 사용하기 전에 [Nexon Open API 콘솔](https://openapi.nexon.com/my-application/)에서 애플리케이션을 등록하고 **api key**를 발급 받으세요.

KMS(한국 메이플스토리)의 데이터만 조회할 수 있습니다.

(English document is [HERE](./README.md))

## Supported Languages

1. **Java**: [![Maven Central](https://img.shields.io/maven-central/v/dev.spiralmoon/maplestory-openapi)](https://search.maven.org/artifact/dev.spiralmoon/maplestory-openapi)
2. **JavaScript (TypeScript)**: [![npm](https://img.shields.io/npm/v/maplestory-openapi)](https://www.npmjs.com/package/maplestory-openapi)
3. **C#**: [![NuGet](https://img.shields.io/nuget/v/MapleStory.OpenAPI)](https://www.nuget.org/packages/MapleStory.OpenAPI)

## Installation

### Java

Java 기반 프로젝트에 아래 정보를 입력하여 패키지를 추가하세요:

```xml
<dependency>
    <groupId>dev.spiralmoon</groupId>
    <artifactId>maplestory-openapi</artifactId>
    <version>2.1.1</version> <!-- Replace with the latest version -->
</dependency>
```
또는
```groovy
implementation 'dev.spiralmoon:maplestory-openapi:2.1.1' // Replace with the latest version
```

Java 라이브러리를 사용하는 자세한 방법은 [여기](./java/README-ko.md)에서 확인해주세요.

### JavaScript (TypeScript)

npm 기반 프로젝트에 아래 정보를 입력하여 패키지를 추가하세요:

```bash
npm install maplestory-openapi
```

Javascript/Typescript 라이브러리를 사용하는 자세한 방법은 [여기](./js/README-ko.md)에서 확인해주세요.

### C#

NuGet 기반 프로젝트에 아래 정보를 입력하여 패키지를 추가하세요:


```xml
<PackageReference Include="MapleStory.OpenAPI" Version="2.1.1" />
```


C# 라이브러리를 사용하는 자세한 방법은 [여기](./csharp/README-ko.md)에서 확인해주세요.

## Features

이 라이브러리는 아래 링크에 기재된 모든 API를 지원합니다.

1. [캐릭터 정보 조회](https://openapi.nexon.com/game/maplestory/?id=22)
2. [유니온 정보 조회](https://openapi.nexon.com/game/maplestory/?id=23)
3. [길드 정보 조회](https://openapi.nexon.com/game/maplestory/?id=24)
4. [확률 정보 조회](https://openapi.nexon.com/game/maplestory/?id=25)
5. [랭킹 정보 조회](https://openapi.nexon.com/game/maplestory/?id=26)
6. [서버 점검 정보 조회](https://api.maplestory.nexon.com/soap/maplestory.asmx?op=GetInspectionInfo)

## Additional Information

1. 이 라이브러리는 [MapleStory OpenAPI spec](https://openapi.nexon.com/game/maplestory)의 기능을 사용할 수 있도록 만든 구현체입니다. 언어별 문서를 확인하여 사용법을 확인하세요.
2. 이 라이브러리는 언어별 네이밍 스타일가이드를 준수하였기 때문에 공식 문서의 네이밍 규칙과 약간의 차이가 있습니다. ex) 'cube_history' -> 'cubeHistory'
3. 이 라이브러리에서 제공하는 메소드와 프로퍼티에 대한 주석은 공식 문서와 동기화하고 있습니다.
4. 데이터는 [NEXON Open API](https://openapi.nexon.com)에서 제공받고 있습니다.
5. 다른 개발자의 참여를 환영합니다! 적극적으로 PR을 보내주세요.

## License

This project is licensed under the MIT License - see the [LICENSE](./LICENSE) file for details.