import * as base from '../../../common/dto/character/characterHexaMatrixStat';
import {
  CharacterHexaMatrixStatBody,
  CharacterHexaMatrixStatCoreBody,
} from '../../response/character/characterHexaMatrixStatBody';

/**
 * 角色設定於 HEXA 矩陣中的 HEXA 屬性資訊
 */
export class CharacterHexaMatrixStatDto extends base.CharacterHexaMatrixStatDto {
  /**
   * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
   */
  public override date: Date | null;

  /**
   * 角色職業
   */
  public override characterClass: string | null;

  /**
   * HEXA 屬性 I 核心資訊
   */
  public override characterHexaStatCore: CharacterHexaMatrixStatCoreDto[];

  /**
   * HEXA 屬性 II 核心資訊
   */
  public override characterHexaStatCore2: CharacterHexaMatrixStatCoreDto[];

  /**
   * HEXA 屬性 III 核心資訊
   */
  public override characterHexaStatCore3: CharacterHexaMatrixStatCoreDto[];

  /**
   * 預設的 HEXA 屬性 I 核心資訊
   */
  public override presetHexaStatCore: CharacterHexaMatrixStatCoreDto[];

  /**
   * 預設的 HEXA 屬性 II 核心資訊
   */
  public override presetHexaStatCore2: CharacterHexaMatrixStatCoreDto[];

  /**
   * 預設的 HEXA 屬性 III 核心資訊
   */
  public override presetHexaStatCore3: CharacterHexaMatrixStatCoreDto[];

  constructor(obj: CharacterHexaMatrixStatBody) {
    super();

    const {
      date,
      character_class,
      character_hexa_stat_core,
      character_hexa_stat_core_2,
      character_hexa_stat_core_3,
      preset_hexa_stat_core,
      preset_hexa_stat_core_2,
      preset_hexa_stat_core_3,
    } = obj;

    this.date = date ? new Date(date) : null;
    this.characterClass = character_class;
    this.characterHexaStatCore =
      character_hexa_stat_core?.map(
        (core) => new CharacterHexaMatrixStatCoreDto(core),
      ) ?? [];
    this.characterHexaStatCore2 =
      character_hexa_stat_core_2?.map(
        (core) => new CharacterHexaMatrixStatCoreDto(core),
      ) ?? [];
    this.characterHexaStatCore3 =
      character_hexa_stat_core_3?.map(
        (core) => new CharacterHexaMatrixStatCoreDto(core),
      ) ?? [];
    this.presetHexaStatCore =
      preset_hexa_stat_core?.map(
        (core) => new CharacterHexaMatrixStatCoreDto(core),
      ) ?? [];
    this.presetHexaStatCore2 =
      preset_hexa_stat_core_2?.map(
        (core) => new CharacterHexaMatrixStatCoreDto(core),
      ) ?? [];
    this.presetHexaStatCore3 =
      preset_hexa_stat_core_3?.map(
        (core) => new CharacterHexaMatrixStatCoreDto(core),
      ) ?? [];
  }
}

/**
 * HEXA 屬性核心資訊
 */
export class CharacterHexaMatrixStatCoreDto extends base.CharacterHexaMatrixStatCoreDto {
  /**
   * 欄位索引
   */
  public override slotId: string;

  /**
   * 主要屬性名稱
   */
  public override mainStatName: string;

  /**
   * 第一副屬性名稱
   */
  public override subStatName1: string;

  /**
   * 第二副屬性名稱
   */
  public override subStatName2: string;

  /**
   * 主要屬性等級
   */
  public override mainStatLevel: number;

  /**
   * 第一副屬性等級
   */
  public override subStatLevel1: number;

  /**
   * 第二副屬性等級
   */
  public override subStatLevel2: number;

  /**
   * 屬性核心階級
   */
  public override statGrade: number;

  constructor(obj: CharacterHexaMatrixStatCoreBody) {
    super();

    const {
      slot_id,
      main_stat_name,
      sub_stat_name_1,
      sub_stat_name_2,
      main_stat_level,
      sub_stat_level_1,
      sub_stat_level_2,
      stat_grade,
    } = obj;

    this.slotId = slot_id;
    this.mainStatName = main_stat_name;
    this.subStatName1 = sub_stat_name_1;
    this.subStatName2 = sub_stat_name_2;
    this.mainStatLevel = main_stat_level;
    this.subStatLevel1 = sub_stat_level_1;
    this.subStatLevel2 = sub_stat_level_2;
    this.statGrade = stat_grade;
  }
}
