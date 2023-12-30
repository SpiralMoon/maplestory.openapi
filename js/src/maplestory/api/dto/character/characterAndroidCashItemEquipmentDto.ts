import { CharacterAndroidCashItemEquipmentColoringPrismDto } from './characterAndroidCashItemEquipmentColoringPrismDto';
import { CharacterAndroidCashItemEquipmentOptionDto } from './characterAndroidCashItemEquipmentOptionDto';
import { CharacterAndroidCashItemEquipmentDtoBody } from '../../response/character/characterAndroidEquipmentDtoBody';

/**
 * 캐릭터 안드로이드 캐시 아이템 장착 정보
 */
class CharacterAndroidCashItemEquipmentDto {
  /**
   * 안드로이드 캐시 아이템 부위 명
   */
  cashItemEquipmentPart: string;

  /**
   * 안드로이드 캐시 아이템 슬롯 위치
   */
  cashItemEquipmentSlot: string;

  /**
   * 안드로이드 캐시 아이템 명
   */
  cashItemName: string;

  /**
   * 안드로이드 캐시 아이템 아이콘
   */
  cashItemIcon: string;

  /**
   * 안드로이드 캐시 아이템 설명
   */
  cashItemDescription: string | null;

  /**
   * 안드로이드 캐시 아이템 옵션
   */
  cashItemOption: CharacterAndroidCashItemEquipmentOptionDto[];

  /**
   * 안드로이드 캐시 아이템 유효 기간 (KST)
   */
  dateExpire: Date | null;

  /**
   * 안드로이드 캐시 아이템 옵션 유효 기간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
   */
  dateOptionExpire: Date | null;

  /**
   * 안드로이드 캐시 아이템 라벨 정보 (스페셜라벨, 레드라벨, 블랙라벨, 마스터라벨)
   */
  cashItemLabel: string | null;

  /**
   * 안드로이드 캐시 아이템 컬러링프리즘 정보
   */
  cashItemColoringPrism: CharacterAndroidCashItemEquipmentColoringPrismDto | null;

  constructor(obj: CharacterAndroidCashItemEquipmentDtoBody) {
    const {
      cash_item_equipment_part,
      cash_item_equipment_slot,
      cash_item_name,
      cash_item_icon,
      cash_item_description,
      cash_item_option,
      date_expire,
      date_option_expire,
      cash_item_label,
      cash_item_coloring_prism,
    } = obj;

    this.cashItemEquipmentPart = cash_item_equipment_part;
    this.cashItemEquipmentSlot = cash_item_equipment_slot;
    this.cashItemName = cash_item_name;
    this.cashItemIcon = cash_item_icon;
    this.cashItemDescription = cash_item_description;
    this.cashItemOption = cash_item_option.map(
      (option) => new CharacterAndroidCashItemEquipmentOptionDto(option),
    );
    this.dateExpire = date_expire ? new Date(date_expire) : null;
    this.dateOptionExpire = date_option_expire
      ? new Date(date_option_expire)
      : null;
    this.cashItemLabel = cash_item_label;
    this.cashItemColoringPrism = cash_item_coloring_prism
      ? new CharacterAndroidCashItemEquipmentColoringPrismDto(
          cash_item_coloring_prism,
        )
      : null;
  }
}

export { CharacterAndroidCashItemEquipmentDto };
