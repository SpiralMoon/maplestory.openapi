import { CharacterSetEffectInfoDto } from '@src/maplestory/api/dto/character/characterSetEffectInfoDto';
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
  setEffect: CharacterSetEffectInfoDto[];

  constructor(obj: CharacterSetEffectDtoBody) {
    const { date, set_effect } = obj;
    this.date = date ? new Date(date) : null;
    this.setEffect = set_effect.map(
      (effect) => new CharacterSetEffectInfoDto(effect),
    );
  }
}

export { CharacterSetEffectDto };
