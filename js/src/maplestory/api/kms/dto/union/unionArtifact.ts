import {
  UnionArtifactBody,
  UnionArtifactCrystalBody,
  UnionArtifactEffectBody,
} from '../../response/union/unionArtifactBody';

/**
 * 유니온 아티팩트 정보
 */
export class UnionArtifactDto {
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

  constructor(obj: UnionArtifactBody) {
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

/**
 * 유니온 아티팩트 효과 정보
 */
export class UnionArtifactEffectDto {
  /**
   * 아티팩트 효과 명
   */
  name: string;

  /**
   * 아티팩트 효과 레벨
   */
  level: number;

  constructor(obj: UnionArtifactEffectBody) {
    const { name, level } = obj;

    this.name = name;
    this.level = level;
  }
}

/**
 * 유니온 아티팩트 크리스탈 정보
 */
export class UnionArtifactCrystalDto {
  /**
   * 아티팩트 크리스탈 명
   */
  name: string;

  /**
   * 능력치 유효 여부 (0:유효, 1:유효하지 않음)
   */
  validityFlag: string;

  /**
   * 능력치 유효 기간 (KST)
   */
  dateExpire: Date | null = null;

  /**
   * 능력치 유효 기간 만료 여부
   */
  isExpired: boolean | null = null;

  /**
   * 아티팩트 크리스탈 등급
   */
  level: number;

  /**
   * 아티팩트 크리스탈 첫 번째 옵션 명
   */
  crystalOptionName1: string;

  /**
   * 아티팩트 크리스탈 두 번째 옵션 명
   */
  crystalOptionName2: string;

  /**
   * 아티팩트 크리스탈 세 번째 옵션 명
   */
  crystalOptionName3: string;

  constructor(obj: UnionArtifactCrystalBody) {
    const {
      name,
      validity_flag,
      date_expire,
      level,
      crystal_option_name_1,
      crystal_option_name_2,
      crystal_option_name_3,
    } = obj;

    this.name = name;
    this.validityFlag = validity_flag;
    this.level = level;
    this.crystalOptionName1 = crystal_option_name_1;
    this.crystalOptionName2 = crystal_option_name_2;
    this.crystalOptionName3 = crystal_option_name_3;

    if (date_expire === 'expired') {
      this.isExpired = true;
    } else if (typeof date_expire === 'string') {
      this.dateExpire = date_expire
        ? new Date(date_expire)
        : null;
    }
  }
}
