import {
  CharacterAbilityBody,
  CharacterAbilityInfoBody,
  CharacterAbilityPresetBody,
} from '../../response/character/characterAbilityBody';

/**
 * 캐릭터 어빌리티 정보
 */
export class CharacterAbilityDto {
  /**
   * 조회 기준일
   */
  date: Date | null;

  /**
   * 어빌리티 등급
   */
  abilityGrade: string | null;

  /**
   *  어빌리티 정보
   */
  abilityInfo: CharacterAbilityInfoDto[];

  /**
   * 보유 명성치
   */
  remainFame: number | null;

  /**
   * 적용 중인 어빌리티 프리셋 번호
   */
  presetNo: number | null;

  /**
   * 어빌리티 1번 프리셋 전체 정보
   */
  abilityPreset1: CharacterAbilityPresetDto | null;

  /**
   * 어빌리티 2번 프리셋 전체 정보
   */
  abilityPreset2: CharacterAbilityPresetDto | null;

  /**
   * 어빌리티 3번 프리셋 전체 정보
   */
  abilityPreset3: CharacterAbilityPresetDto | null;

  constructor(obj: CharacterAbilityBody) {
    const {
      date,
      ability_grade,
      ability_info,
      remain_fame,
      preset_no,
      ability_preset_1,
      ability_preset_2,
      ability_preset_3,
    } = obj;

    // 날짜는 Date 객체로 변환
    this.date = date ? new Date(date) : null;
    this.abilityGrade = ability_grade;
    this.abilityInfo = ability_info.map(
      (info) => new CharacterAbilityInfoDto(info),
    );
    this.remainFame = remain_fame;
    this.presetNo = preset_no;
    this.abilityPreset1 = ability_preset_1
      ? new CharacterAbilityPresetDto(ability_preset_1)
      : null;
    this.abilityPreset2 = ability_preset_2
      ? new CharacterAbilityPresetDto(ability_preset_2)
      : null;
    this.abilityPreset3 = ability_preset_3
      ? new CharacterAbilityPresetDto(ability_preset_3)
      : null;
  }
}

/**
 * 캐릭터 어빌리티 상세 정보
 */
export class CharacterAbilityInfoDto {
  /**
   * 어빌리티 번호
   */
  abilityNo: string;

  /**
   * 어빌리티 등급
   */
  abilityGrade: string;

  /**
   * 어빌리티 옵션 및 수치
   */
  abilityValue: string;

  constructor(obj: CharacterAbilityInfoBody) {
    const { ability_no, ability_grade, ability_value } = obj;

    this.abilityNo = ability_no;
    this.abilityGrade = ability_grade;
    this.abilityValue = ability_value;
  }
}

/**
 * 캐릭터 어빌리티 프리셋 정보
 */
export class CharacterAbilityPresetDto {
  /**
   * 프리셋의 어빌리티 등급
   */
  abilityPresetGrade: string;

  /**
   * 프리셋의 어빌리티 정보
   */
  abilityInfo: CharacterAbilityInfoDto[];

  constructor(obj: CharacterAbilityPresetBody) {
    const { ability_preset_grade, ability_info } = obj;

    this.abilityPresetGrade = ability_preset_grade;
    this.abilityInfo = ability_info.map(
      (info) => new CharacterAbilityInfoDto(info),
    );
  }
}
