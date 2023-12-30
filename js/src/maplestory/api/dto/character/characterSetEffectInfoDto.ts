import { CharacterSetEffectOptionInfoDto } from './characterSetEffectOptionInfoDto';
import { CharacterSetEffectInfoDtoBody } from '../../response/character/characterSetEffectDtoBody';

/**
 * 캐릭터 세트 효과 정보
 */
class CharacterSetEffectInfoDto {
  /**
   * 세트 효과 명
   */
  setName: string;

  /**
   * 세트 개수 (럭키 아이템 포함)
   */
  totalSetCount: number;

  /**
   * 세트 효과 옵션
   */
  setEffectInfo: CharacterSetEffectOptionInfoDto[];

  constructor(obj: CharacterSetEffectInfoDtoBody) {
    const { set_name, total_set_count, set_effect_info } = obj;

    this.setName = set_name;
    this.totalSetCount = total_set_count;
    this.setEffectInfo = set_effect_info.map(
      (info) => new CharacterSetEffectOptionInfoDto(info),
    );
  }
}

export { CharacterSetEffectInfoDto };
