import { CharacterSetEffectInfoBody } from '../../response/character/characterSetEffectBody';

/**
 * 적용 중인 세트 효과 정보
 */
class CharacterSetEffectInfoDto {
  /**
   * 세트 효과 레벨 (장비 수)
   */
  setCount: number;

  /**
   * 세트 효과
   */
  setOption: string;

  constructor(obj: CharacterSetEffectInfoBody) {
    const { set_count, set_option } = obj;

    this.setCount = set_count;
    this.setOption = set_option;
  }
}

export { CharacterSetEffectInfoDto };
