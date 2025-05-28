import {
  CharacterSetEffectBody,
  CharacterSetEffectInfoBody,
  CharacterSetEffectOptionFullBody,
  CharacterSetEffectSetBody,
} from '../../response/character/characterSetEffectBody';

/**
 * 캐릭터 세트 효과 정보
 */
export class CharacterSetEffectDto {
  /**
   * 조회 기준일
   */
  date: Date | null;

  /**
   * 세트 효과 정보
   */
  setEffect: CharacterSetEffectSetDto[];

  constructor(obj: CharacterSetEffectBody) {
    const { date, set_effect } = obj;
    this.date = date ? new Date(date) : null;
    this.setEffect = set_effect.map(
      (effect) => new CharacterSetEffectSetDto(effect),
    );
  }
}

/**
 * 적용 중인 세트 효과 정보
 */
export class CharacterSetEffectInfoDto {
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

/**
 * 모든 세트 효과 정보
 */
export class CharacterSetEffectOptionFullDto {
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

/**
 * 세트 효과 정보
 */
export class CharacterSetEffectSetDto {
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

  constructor(obj: CharacterSetEffectSetBody) {
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
