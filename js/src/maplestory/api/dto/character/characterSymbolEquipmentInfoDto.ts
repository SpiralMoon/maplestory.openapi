import { CharacterSymbolEquipmentInfoDtoBody } from '../../response/character/characterSymbolEquipmentDtoBody';

/**
 * 캐릭터 심볼 상세 정보
 */
class CharacterSymbolEquipmentInfoDto {
  /**
   * 심볼 명
   */
  symbolName: string;

  /**
   * 심볼 아이콘
   */
  symbolIcon: string;

  /**
   * 심볼 설명
   */
  symbolDescription: string;

  /**
   * 심볼로 인한 증가 수치
   */
  symbolForce: string;

  /**
   * 심볼 레벨
   */
  symbolLevel: number;

  /**
   * 심볼로 증가한 힘
   */
  symbolStr: string;

  /**
   * 심볼로 증가한 민첩
   */
  symbolDex: string;

  /**
   * 심볼로 증가한 지력
   */
  symbolInt: string;

  /**
   * 심볼로 증가한 운
   */
  symbolLuk: string;

  /**
   * 심볼로 증가한 체력
   */
  symbolHp: string;

  /**
   * 현재 보유 성장치
   */
  symbolGrowthCount: number;

  /**
   * 성장 시 필요한 성장치
   */
  symbolRequireGrowthCount: number;

  constructor(obj: CharacterSymbolEquipmentInfoDtoBody) {
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
    this.symbolGrowthCount = symbol_growth_count;
    this.symbolRequireGrowthCount = symbol_require_growth_count;
  }
}

export { CharacterSymbolEquipmentInfoDto };
