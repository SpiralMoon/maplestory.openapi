import * as base from '../../../common/dto/character/characterSymbolEquipment';
import {
  CharacterSymbolEquipmentBody,
  CharacterSymbolEquipmentInfoBody,
} from '../../response/character/characterSymbolEquipmentBody';

/**
 * 캐릭터 심볼 정보
 */
export class CharacterSymbolEquipmentDto extends base.CharacterSymbolEquipmentDto {
  /**
   * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
   */
  public override date: Date | null;

  /**
   * 캐릭터 직업
   */
  public override characterClass: string;

  /**
   * 심볼 정보
   */
  public override symbol: CharacterSymbolEquipmentInfoDto[];

  constructor(obj: CharacterSymbolEquipmentBody) {
    super();

    const { date, character_class, symbol } = obj;

    this.date = date ? new Date(date) : null;
    this.characterClass = character_class!;
    this.symbol = symbol.map((s) => new CharacterSymbolEquipmentInfoDto(s));
  }
}

/**
 * 캐릭터 심볼 상세 정보
 */
export class CharacterSymbolEquipmentInfoDto extends base.CharacterSymbolEquipmentInfoDto {
  /**
   * 심볼 명
   */
  public override symbolName: string;

  /**
   * 심볼 아이콘
   */
  public override symbolIcon: string;

  /**
   * 심볼 설명
   */
  public override symbolDescription: string;

  /**
   * 심볼로 인한 증가 수치
   */
  public override symbolForce: string;

  /**
   * 심볼 레벨
   */
  public override symbolLevel: number;

  /**
   * 심볼로 증가한 힘
   */
  public override symbolStr: string;

  /**
   * 심볼로 증가한 민첩
   */
  public override symbolDex: string;

  /**
   * 심볼로 증가한 지력
   */
  public override symbolInt: string;

  /**
   * 심볼로 증가한 운
   */
  public override symbolLuk: string;

  /**
   * 심볼로 증가한 체력
   */
  public override symbolHp: string;

  /**
   * 심볼로 증가한 아이템 드롭률
   */
  public override symbolDropRate: string;

  /**
   * 심볼로 증가한 메소 획득량
   */
  public override symbolMesoRate: string;

  /**
   * 심볼로 증가한 경험치 획득량
   */
  public override symbolExpRate: string;

  /**
   * 현재 보유 성장치
   */
  public override symbolGrowthCount: number;

  /**
   * 성장 시 필요한 성장치
   */
  public override symbolRequireGrowthCount: number;

  constructor(obj: CharacterSymbolEquipmentInfoBody) {
    super();

    const {
      symbol_name,
      symbol_icon,
      symbol_description,
      symbol_force,
      symbol_level,
      symbol_str,
      symbol_dex,
      symbol_int,
      symbol_luk,
      symbol_hp,
      symbol_drop_rate,
      symbol_meso_rate,
      symbol_exp_rate,
      symbol_growth_count,
      symbol_require_growth_count,
    } = obj;

    this.symbolName = symbol_name;
    this.symbolIcon = symbol_icon;
    this.symbolDescription = symbol_description;
    this.symbolForce = symbol_force;
    this.symbolLevel = symbol_level;
    this.symbolStr = symbol_str;
    this.symbolDex = symbol_dex;
    this.symbolInt = symbol_int;
    this.symbolLuk = symbol_luk;
    this.symbolHp = symbol_hp;
    this.symbolDropRate = symbol_drop_rate ?? '0%';
    this.symbolMesoRate = symbol_meso_rate ?? '0%';
    this.symbolExpRate = symbol_exp_rate ?? '0%';
    this.symbolHp = symbol_hp;
    this.symbolHp = symbol_hp;
    this.symbolGrowthCount = symbol_growth_count;
    this.symbolRequireGrowthCount = symbol_require_growth_count;
  }
}
