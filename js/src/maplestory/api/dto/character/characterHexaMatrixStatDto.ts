import { CharacterHexaMatrixStatCoreDto } from './characterHexaMatrixStatCoreDto';
import { CharacterHexaMatrixStatBody } from '../../response/character/characterHexaMatrixStatBody';

/**
 * 캐릭터 HEXA 스탯 코어 정보
 */
class CharacterHexaMatrixStatDto {
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

export { CharacterHexaMatrixStatDto };
