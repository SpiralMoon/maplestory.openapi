import {
  CharacterHexaMatrixStatBody,
  CharacterHexaMatrixStatCoreBody,
} from '../../response/character/characterHexaMatrixStatBody';

/**
 * 캐릭터 HEXA 스탯 코어 정보
 */
export class CharacterHexaMatrixStatDto {
  /**
   * 조회 기준일
   */
  date: Date | null;

  /**
   * 캐릭터 직업
   */
  characterClass: string | null;

  /**
   * HEXA 스탯 I 코어 정보
   */
  characterHexaStatCore: CharacterHexaMatrixStatCoreDto[];

  /**
   * HEXA 스탯 II 코어 정보
   */
  characterHexaStatCore2: CharacterHexaMatrixStatCoreDto[];

  /**
   * HEXA 스탯 III 코어 정보
   */
  characterHexaStatCore3: CharacterHexaMatrixStatCoreDto[];

  /**
   * 프리셋 HEXA 스탯 I 코어 정보
   */
  presetHexaStatCore: CharacterHexaMatrixStatCoreDto[];

  /**
   * 프리셋 HEXA 스탯 II 코어 정보
   */
  presetHexaStatCore2: CharacterHexaMatrixStatCoreDto[];

  /**
   * 프리셋 HEXA 스탯 III 코어 정보
   */
  presetHexaStatCore3: CharacterHexaMatrixStatCoreDto[];

  constructor(obj: CharacterHexaMatrixStatBody) {
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
    this.characterHexaStatCore = character_hexa_stat_core?.map(
      (core) => new CharacterHexaMatrixStatCoreDto(core),
    ) ?? [];
    this.characterHexaStatCore2 = character_hexa_stat_core_2?.map(
      (core) => new CharacterHexaMatrixStatCoreDto(core),
    ) ?? [];
    this.characterHexaStatCore3 = character_hexa_stat_core_3?.map(
      (core) => new CharacterHexaMatrixStatCoreDto(core),
    ) ?? [];
    this.presetHexaStatCore = preset_hexa_stat_core?.map(
      (core) => new CharacterHexaMatrixStatCoreDto(core),
    ) ?? [];
    this.presetHexaStatCore2 = preset_hexa_stat_core_2?.map(
      (core) => new CharacterHexaMatrixStatCoreDto(core),
    ) ?? [];
    this.presetHexaStatCore3 = preset_hexa_stat_core_3?.map(
      (core) => new CharacterHexaMatrixStatCoreDto(core),
    ) ?? [];
  }
}

/**
 * 캐릭터 HEXA 스탯 코어 정보
 */
export class CharacterHexaMatrixStatCoreDto {
  /**
   * 슬롯 인덱스
   */
  slotId: string;

  /**
   * 메인 스탯 명
   */
  mainStatName: string;

  /**
   * 첫 번째 서브 명
   */
  subStatName1: string;

  /**
   * 두 번째 서브 명
   */
  subStatName2: string;

  /**
   * 메인 스탯 레벨
   */
  mainStatLevel: number;

  /**
   * 첫 번째 서브 레벨
   */
  subStatLevel1: number;

  /**
   * 두 번째 서브 레벨
   */
  subStatLevel2: number;

  /**
   * 스탯 코어 등급
   */
  statGrade: number;

  constructor(obj: CharacterHexaMatrixStatCoreBody) {
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
