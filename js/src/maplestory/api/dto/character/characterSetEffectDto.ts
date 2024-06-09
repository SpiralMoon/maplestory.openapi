import { CharacterSetEffectSetDto } from '@src/maplestory/api/dto/character/characterSetEffectSetDto';
import { CharacterSetEffectDtoBody } from '@src/maplestory/api/response/character/characterSetEffectDtoBody';

/**
 * 캐릭터 세트 효과 정보
 */
class CharacterSetEffectDto {
  /**
   * 조회 기준일
   */
  date: Date | null;

  /**
   * 세트 효과 정보
   */
  setEffect: CharacterSetEffectSetDto[];

  constructor(obj: CharacterSetEffectDtoBody) {
    const { date, set_effect } = obj;
    this.date = date ? new Date(date) : null;
    this.setEffect = set_effect.map(
      (effect) => new CharacterSetEffectSetDto(effect),
    );
  }
}

export { CharacterSetEffectDto };
