import { CharacterSymbolEquipmentInfoDto } from './characterSymbolEquipmentInfoDto';
import { CharacterSymbolEquipmentDtoBody } from '../../response/character/characterSymbolEquipmentDtoBody';

/**
 * 캐릭터 심볼 정보
 */
class CharacterSymbolEquipmentDto {
  /**
   * 조회 기준일
   */
  date: Date;

  /**
   * 캐릭터 직업
   */
  characterClass: string;

  /**
   * 심볼 정보
   */
  symbol: CharacterSymbolEquipmentInfoDto[];

  constructor(obj: CharacterSymbolEquipmentDtoBody) {
    const { date, character_class, symbol } = obj;

    this.date = new Date(date);
    this.characterClass = character_class;
    this.symbol = symbol.map((s) => new CharacterSymbolEquipmentInfoDto(s));
  }
}

export { CharacterSymbolEquipmentDto };
