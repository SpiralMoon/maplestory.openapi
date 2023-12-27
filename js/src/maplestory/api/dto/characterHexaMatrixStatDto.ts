import { CharacterHexaMatrixStatCoreDto } from './characterHexaMatrixStatCoreDto';
import { CharacterHexaMatrixStatDtoBody } from '../response/characterHexaMatrixStatDtoBody';

/**
 * 캐릭터 HEXA 스탯 코어 정보
 */
class CharacterHexaMatrixStatDto {
  /**
   * 조회 기준일
   */
  date: Date;

  /**
   * 캐릭터 직업
   */
  characterClass: string;

  /**
   * HEXA 스탯 코어 정보
   */
  characterHexaStatCore: CharacterHexaMatrixStatCoreDto[];

  /**
   * 프리셋 HEXA 스탯 코어 정보
   */
  presetHexaStatCore: CharacterHexaMatrixStatCoreDto[];

  constructor(obj: CharacterHexaMatrixStatDtoBody) {
    const {
      date,
      character_class,
      character_hexa_stat_core,
      preset_hexa_stat_core,
    } = obj;

    this.date = new Date(date);
    this.characterClass = character_class;
    this.characterHexaStatCore = character_hexa_stat_core.map(
      (core) => new CharacterHexaMatrixStatCoreDto(core),
    );
    this.presetHexaStatCore = preset_hexa_stat_core.map(
      (core) => new CharacterHexaMatrixStatCoreDto(core),
    );
  }
}

export { CharacterHexaMatrixStatDto };
