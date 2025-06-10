import * as base from '../../../common/dto/union/unionArtifact';
import {
  UnionArtifactBody,
  UnionArtifactCrystalBody,
  UnionArtifactEffectBody,
} from '../../response/union/unionArtifactBody';

/**
 * Union artifact information
 */
export class UnionArtifactDto extends base.UnionArtifactDto {
  /**
   * Reference date for query (SGT, daily data with hours and minutes set to 0)
   */
  public override date: Date | null;

  /**
   * Artifact effect information
   */
  public override unionArtifactEffect: UnionArtifactEffectDto[];

  /**
   * Artifact crystal information
   */
  public override unionArtifactCrystal: UnionArtifactCrystalDto[];

  /**
   * Remaining artifact AP
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
 * Artifact artifact information
 */
export class UnionArtifactEffectDto extends base.UnionArtifactEffectDto {
  /**
   * Name of the artifact effect
   */
  public override name: string;

  /**
   * Level of the artifact effect
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
 * Artifact crystal information
 */
export class UnionArtifactCrystalDto extends base.UnionArtifactCrystalDto {
  /**
   * Name of the artifact crystal
   */
  public override name: string;

  /**
   * Validity of the stat (0:Valid, 1:Invalid)
   */
  public override validityFlag: string;

  /**
   * Expiration date of the stat (SGT)
   */
  public override dateExpire: Date | null = null;

  /**
   * Whether the artifact crystal is expired
   */
  public override isExpired: boolean | null = null;

  /**
   * Grade of the artifact crystal
   */
  public override level: number;

  /**
   * First option of the artifact crystal
   */
  public override crystalOptionName1: string;

  /**
   * Second option of the artifact crystal
   */
  public override crystalOptionName2: string;

  /**
   * Third option of the artifact crystal
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
