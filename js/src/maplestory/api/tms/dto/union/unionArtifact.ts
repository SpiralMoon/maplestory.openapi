import * as base from '../../../common/dto/union/unionArtifact';
import {
  UnionArtifactBody,
  UnionArtifactCrystalBody,
  UnionArtifactEffectBody,
} from '../../response/union/unionArtifactBody';

/**
 * 戰地神器資訊
 */
export class UnionArtifactDto extends base.UnionArtifactDto {
  /**
   * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
   */
  public override date: Date | null;

  /**
   * 神器效果資訊
   */
  public override unionArtifactEffect: UnionArtifactEffectDto[];

  /**
   * 神器水晶資訊
   */
  public override unionArtifactCrystal: UnionArtifactCrystalDto[];

  /**
   * 剩餘神器 AP
   */
  public override unionArtifactRemainAp: number | null;

  constructor(obj: UnionArtifactBody) {
    super();

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
 * 神器效果資訊
 */
export class UnionArtifactEffectDto extends base.UnionArtifactEffectDto {
  /**
   * 神器效果名稱
   */
  public override name: string;

  /**
   * 神器效果等級
   */
  public override level: number;

  constructor(obj: UnionArtifactEffectBody) {
    super();

    const { name, level } = obj;

    this.name = name;
    this.level = level;
  }
}

/**
 * 神器水晶資訊
 */
export class UnionArtifactCrystalDto extends base.UnionArtifactCrystalDto {
  /**
   * 神器水晶名稱
   */
  public override name: string;

  /**
   * 能力有效性 (0：有效，1：無效)
   */
  public override validityFlag: string;

  /**
   * 能力有效期間 (TST)
   */
  public override dateExpire: Date | null = null;

  /**
   * Whether the artifact crystal is expired
   */
  public override isExpired: boolean | null = null;

  /**
   * 神器水晶階級
   */
  public override level: number;

  /**
   * 神器水晶第一選項名稱
   */
  public override crystalOptionName1: string;

  /**
   * 神器水晶第二選項名稱
   */
  public override crystalOptionName2: string;

  /**
   * 神器水晶第三選項名稱
   */
  public override crystalOptionName3: string;

  constructor(obj: UnionArtifactCrystalBody) {
    super();

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
      this.dateExpire = date_expire ? new Date(date_expire) : null;
    }
  }
}
