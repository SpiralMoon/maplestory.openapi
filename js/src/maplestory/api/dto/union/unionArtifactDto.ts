import { UnionArtifactCrystalDto } from '@src/maplestory/api/dto/union/unionArtifactCrystalDto';
import { UnionArtifactEffectDto } from '@src/maplestory/api/dto/union/unionArtifactEffectDto';
import { UnionArtifactDtoBody } from '@src/maplestory/api/response/union/unionArtifactDtoBody';

/**
 * 유니온 아티팩트 정보
 */
class UnionArtifactDto {
  /**
   * 조회 기준일
   */
  date: Date | null;

  /**
   * 아티팩트 효과 정보
   */
  unionArtifactEffect: UnionArtifactEffectDto[];

  /**
   * 아티팩트 크리스탈 정보
   */
  unionArtifactCrystal: UnionArtifactCrystalDto[];

  /**
   * 잔여 아티팩트 AP
   */
  unionArtifactRemainAp: number | null;

  constructor(obj: UnionArtifactDtoBody) {
    const {
      date,
      union_artifact_effect,
      union_artifact_crystal,
      union_artifact_remain_ap,
    } = obj;

    this.date = date ? new Date(date) : null;
    this.unionArtifactEffect = union_artifact_effect.map(
      (effect) => new UnionArtifactEffectDto(effect),
    );
    this.unionArtifactCrystal = union_artifact_crystal.map(
      (crystal) => new UnionArtifactCrystalDto(crystal),
    );
    this.unionArtifactRemainAp = union_artifact_remain_ap;
  }
}

export { UnionArtifactDto };
