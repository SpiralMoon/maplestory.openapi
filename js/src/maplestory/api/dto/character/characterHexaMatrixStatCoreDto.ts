import {
  CharacterHexaMatrixStatCoreDtoBody
} from '@src/maplestory/api/response/character/characterHexaMatrixStatDtoBody';

/**
 * 캐릭터 HEXA 스탯 코어 정보
 */
class CharacterHexaMatrixStatCoreDto {
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

  constructor(obj: CharacterHexaMatrixStatCoreDtoBody) {
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

export { CharacterHexaMatrixStatCoreDto };
