import { CharacterSetEffectOptionFullBody } from '../../response/character/characterSetEffectBody';

/**
 * 모든 세트 효과 정보
 */
class CharacterSetEffectOptionFullDto {
  /**
   * 세트 효과 레벨 (장비 수)
   */
  setCount: number;

  /**
   * 세트 효과
   */
  setOption: string;

  constructor(obj: CharacterSetEffectOptionFullBody) {
    const { set_count, set_option } = obj;

    this.setCount = set_count;
    this.setOption = set_option;
  }
}

export { CharacterSetEffectOptionFullDto };
