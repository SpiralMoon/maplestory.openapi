import { CharacterSetEffectInfoDtoBody } from '@src/maplestory/api/response/character/characterSetEffectDtoBody';

/**
 * 모든 세트 효과 정보
 */
class CharacterSetEffectFullInfoDto {
  /**
   * 세트 효과 레벨 (장비 수)
   */
  setCount: number;

  /**
   * 세트 효과
   */
  setOption: string;

  constructor(obj: CharacterSetEffectInfoDtoBody) {
    const { set_count, set_option } = obj;

    this.setCount = set_count;
    this.setOption = set_option;
  }
}

export { CharacterSetEffectFullInfoDto };
