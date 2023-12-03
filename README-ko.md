# MapleStory OpenAPI Library

넥슨에서 제공하는 MapleStory OpenAPI를 사용할 수 있게 해주는 라이브러리입니다.

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
    <version>1.0.0</version> <!-- Replace with the latest version -->
</dependency>
```
또는
```groovy
implementation 'dev.spiralmoon:maplestory-openapi:1.0.0' // Replace with the latest version
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
<PackageReference Include="MapleStory.OpenAPI" Version="1.0.0" />
```


C# 라이브러리를 사용하는 자세한 방법은 [여기](./csharp/README-ko.md)에서 확인해주세요.

## Features

1. 큐브 사용기록 조회
2. ~~스타포스 강화기록 조회~~ (추가 예정)
3. ~~캐릭터 정보 조회~~ (추가 예정)
4. 서버 점검 정보 조회

## Additional Information

1. 이 라이브러리는 [MapleStory OpenAPI spec](https://developers.nexon.com/Maplestory/apiList)의 기능을 사용할 수 있도록 만든 구현체입니다. 언어별 문서를 확인하여 사용법을 확인하세요.
2. 데이터는 [NEXON DEVELOPERS](https://developers.nexon.com)에서 제공받고 있습니다.
3. 다른 개발자의 참여를 환영합니다! 적극적으로 PR을 보내주세요.

## License

This project is licensed under the MIT License - see the [LICENSE](./LICENSE) file for details.