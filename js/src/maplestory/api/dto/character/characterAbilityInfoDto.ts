import { CharacterAbilityInfoDtoBody } from '@src/maplestory/api/response/character/characterAbilityDtoBody';

/**
 * 캐릭터 어빌리티 상세 정보
 */
class CharacterAbilityInfoDto {
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

  constructor(obj: CharacterAbilityInfoDtoBody) {
    const { ability_no, ability_grade, ability_value } = obj;

    this.abilityNo = ability_no;
    this.abilityGrade = ability_grade;
    this.abilityValue = ability_value;
  }
}

export { CharacterAbilityInfoDto };
