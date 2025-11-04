import * as base from '../../../common/dto/character/characterHexaMatrixStat';
import {
  CharacterHexaMatrixStatBody,
  CharacterHexaMatrixStatCoreBody,
} from '../../response/character/characterHexaMatrixStatBody';

/**
 * Character HEXA Matrix configured HEXA stats information
 */
export class CharacterHexaMatrixStatDto extends base.CharacterHexaMatrixStatDto {
  /**
   * Reference date for query (SGT, daily data with hours and minutes set to 0)
   */
  public override date: Date | null;

  /**
   * Character job
   */
  public override characterClass: string;

  /**
   * Information for HEXA Stat Node I
   */
  public override characterHexaStatCore: CharacterHexaMatrixStatCoreDto[];

  /**
   * Information for HEXA Stat Node II
   */
  public override characterHexaStatCore2: CharacterHexaMatrixStatCoreDto[];

  /**
   * Information for HEXA Stat Node III
   */
  public override characterHexaStatCore3: CharacterHexaMatrixStatCoreDto[];

  /**
   * Preset HEXA Stat Node I information
   */
  public override presetHexaStatCore: CharacterHexaMatrixStatCoreDto[];

  /**
   * Preset HEXA Stat Node II information
   */
  public override presetHexaStatCore2: CharacterHexaMatrixStatCoreDto[];

  /**
   * Preset HEXA Stat Node III information
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
    this.characterClass = character_class!;
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
 * Information for HEXA Stat Node
 */
export class CharacterHexaMatrixStatCoreDto extends base.CharacterHexaMatrixStatCoreDto {
  /**
   * Slot index
   */
  public override slotId: string;

  /**
   * Main Stat name
   */
  public override mainStatName: string;

  /**
   * First sub stat name
   */
  public override subStatName1: string;

  /**
   * Second sub stat name
   */
  public override subStatName2: string;

  /**
   * Main Stat level
   */
  public override mainStatLevel: number;

  /**
   * First sub stat level
   */
  public override subStatLevel1: number;

  /**
   * Second sub stat level
   */
  public override subStatLevel2: number;

  /**
   * Stat core level
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
