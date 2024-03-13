import { CharacterAbilityInfoDto } from '@src/maplestory/api/dto/character/characterAbilityInfoDto';
import { CharacterAbilityPresetDtoBody } from '@src/maplestory/api/response/character/characterAbilityDtoBody';

/**
 * 캐릭터 어빌리티 프리셋 정보
 */
class CharacterAbilityPresetDto {
  /**
   * 프리셋의 어빌리티 등급
   */
  abilityPresetGrade: string;

  /**
   * 프리셋의 어빌리티 정보
   */
  abilityInfo: CharacterAbilityInfoDto[];

  constructor(obj: CharacterAbilityPresetDtoBody) {
    const { ability_preset_grade, ability_info } = obj;

    this.abilityPresetGrade = ability_preset_grade;
    this.abilityInfo = ability_info.map(
      (info) => new CharacterAbilityInfoDto(info),
    );
  }
}

export { CharacterAbilityPresetDto };
