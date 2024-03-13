import {
  CharacterPetEquipmentItemOptionDto
} from '@src/maplestory/api/dto/character/characterPetEquipmentItemOptionDto';
import { CharacterPetEquipmentItemDtoBody } from '@src/maplestory/api/response/character/characterPetEquipmentDtoBody';

/**
 * 캐릭터 펫 장비 아이템 정보
 */
class CharacterPetEquipmentItemDto {
  /**
   * 아이템 명
   */
  itemName: string | null;

  /**
   * 아이템 아이콘
   */
  itemIcon: string | null;

  /**
   * 아이템 설명
   */
  itemDescription: string | null;

  /**
   * 아이템 표기상 옵션
   */
  itemOption: CharacterPetEquipmentItemOptionDto[];

  /**
   * 업그레이드 횟수
   */
  scrollUpgrade: number;

  /**
   * 업그레이드 가능 횟수
   */
  scrollUpgradable: number;

  /**
   * 아이템 외형
   */
  itemShape: string | null;

  /**
   * 아이템 외형 아이콘
   */
  itemShapeIcon: string | null;

  constructor(obj: CharacterPetEquipmentItemDtoBody) {
    const {
      item_name,
      item_icon,
      item_description,
      item_option,
      scroll_upgrade,
      scroll_upgradable,
      item_shape,
      item_shape_icon
    } = obj;

    this.itemName = item_name;
    this.itemIcon = item_icon;
    this.itemDescription = item_description;
    this.itemOption = item_option.map(
      (option) => new CharacterPetEquipmentItemOptionDto(option),
    );
    this.scrollUpgrade = scroll_upgrade;
    this.scrollUpgradable = scroll_upgradable;
    this.itemShape = item_shape;
    this.itemShapeIcon = item_shape_icon;
  }
}

export { CharacterPetEquipmentItemDto };
