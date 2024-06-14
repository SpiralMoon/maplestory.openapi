import { CharacterSetEffectOptionFullDto } from '@src/maplestory/api/dto/character/characterSetEffectOptionFullDto';
import { CharacterSetEffectInfoDto } from '@src/maplestory/api/dto/character/characterSetEffectInfoDto';
import {
  CharacterSetEffectSetDtoBody,
} from '@src/maplestory/api/response/character/characterSetEffectDtoBody';

/**
 * 세트 효과 정보
 */
class CharacterSetEffectSetDto {
  /**
   * 세트 효과 명
   */
  setName: string;

  /**
   * 세트 개수 (럭키 아이템 포함)
   */
  totalSetCount: number;

  /**
   * 적용 중인 세트 효과 정보
   */
  setEffectInfo: CharacterSetEffectInfoDto[];

  /**
   * 모든 세트 효과 정보
   */
  setOptionFull: CharacterSetEffectOptionFullDto[];

  constructor(obj: CharacterSetEffectSetDtoBody) {
    const { set_name, total_set_count, set_effect_info, set_option_full } = obj;

    this.setName = set_name;
    this.totalSetCount = total_set_count;
    this.setEffectInfo = set_effect_info.map(
      (info) => new CharacterSetEffectInfoDto(info),
    );
    this.setOptionFull = set_option_full.map(
      (info) => new CharacterSetEffectOptionFullDto(info),
    );
  }
}

export { CharacterSetEffectSetDto };
