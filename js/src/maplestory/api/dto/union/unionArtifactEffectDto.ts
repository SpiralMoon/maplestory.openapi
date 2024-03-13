import { UnionArtifactEffectDtoBody } from '@src/maplestory/api/response/union/unionArtifactDtoBody';

/**
 * 유니온 아티팩트 효과 정보
 */
class UnionArtifactEffectDto {
  /**
   * 아티팩트 효과 명
   */
  name: string;

  /**
   * 아티팩트 효과 레벨
   */
  level: number;

  constructor(obj: UnionArtifactEffectDtoBody) {
    const { name, level } = obj;

    this.name = name;
    this.level = level;
  }
}

export { UnionArtifactEffectDto };
