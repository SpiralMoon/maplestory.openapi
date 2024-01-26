import { UnionArtifactCrystalDto } from './unionArtifactCrystalDto';
import { UnionArtifactEffectDto } from './unionArtifactEffectDto';
import { UnionArtifactDtoBody } from '../../response/union/unionArtifactDtoBody';

/**
 * 유니온 아티팩트 정보
 */
class UnionArtifactDto {
  /**
   * 조회 기준일
   */
  date: Date;

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

    this.date = new Date(date);
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
