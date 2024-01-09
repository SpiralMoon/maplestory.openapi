import { CharacterItemEquipmentAddOptionDto } from './characterItemEquipmentAddOptionDto';
import { CharacterItemEquipmentBaseOptionDto } from './characterItemEquipmentBaseOptionDto';
import { CharacterItemEquipmentEtcOptionDto } from './characterItemEquipmentEtcOptionDto';
import { CharacterItemEquipmentExceptionalOptionDto } from './characterItemEquipmentExceptionalOptionDto';
import { CharacterItemEquipmentStarforceOptionDto } from './characterItemEquipmentStarforceOptionDto';
import { CharacterItemEquipmentTotalOptionDto } from './characterItemEquipmentTotalOptionDto';
import { CharacterItemEquipmentInfoDtoBody } from '../../response/character/characterItemEquipmentDtoBody';

/**
 * 메카닉 장비 정보
 */
class CharacterItemEquipmentMechanicInfoDto {
  /**
   * 장비 부위 명
   */
  itemEquipmentPart: string;

  /**
   * 장비 슬롯 위치
   */
  itemEquipmentSlot: string;

  /**
   * 장비 명
   */
  itemName: string;

  /**
   * 장비 아이콘
   */
  itemIcon: string;

  /**
   * 장비 설명
   */
  itemDescription: string | null;

  /**
   * 장비 외형
   */
  itemShapeName: string;

  /**
   * 장비 외형 아이콘
   */
  itemShapeIcon: string;

  /**
   * 전용 성별
   */
  itemGender: string | null;

  /**
   * 장비 최종 옵션
   */
  itemTotalOption: CharacterItemEquipmentTotalOptionDto;

  /**
   * 장비 기본 옵션
   */
  itemBaseOption: CharacterItemEquipmentBaseOptionDto;

  /**
   * 착용 레벨 증가
   */
  equipmentLevelIncrease: number;

  /**
   * 장비 특별 옵션
   */
  itemExceptionalOption: CharacterItemEquipmentExceptionalOptionDto;

  /**
   * 장비 추가 옵션
   */
  itemAddOption: CharacterItemEquipmentAddOptionDto;

  /**
   * 성장 경험치
   */
  growthExp: number;

  /**
   * 성장 레벨
   */
  growthLevel: number;

  /**
   * 업그레이드 횟수
   */
  scrollUpgrade: string;

  /**
   * 가위 사용 가능 횟수 (교환 불가 장비, 가위 횟수가 없는 교환 가능 장비는 255)
   */
  cuttableCount: string;

  /**
   * 황금 망치 재련 적용 (1:적용, 이외 미 적용)
   */
  goldenHammerFlag: string;

  /**
   * 복구 가능 횟수
   */
  scrollResilienceCount: string;

  /**
   * 업그레이드 가능 횟수
   */
  scrollUpgradeableCount: string;

  /**
   * 소울 명
   */
  soulName: string | null;

  /**
   * 소울 옵션
   */
  soulOption: string | null;

  /**
   * 장비 기타 옵션
   */
  itemEtcOption: CharacterItemEquipmentEtcOptionDto;

  /**
   * 강화 단계
   */
  starforce: string;

  /**
   * 놀라운 장비 강화 주문서 사용 여부 (0:미사용, 1:사용)
   */
  starforceScrollFlag: string;

  /**
   * 장비 스타포스 옵션
   */
  itemStarforceOption: CharacterItemEquipmentStarforceOptionDto;

  /**
   * 특수 반지 레벨
   */
  specialRingLevel: number;

  /**
   * 장비 유효 기간
   */
  dateExpire: Date | null;

  constructor(obj: CharacterItemEquipmentInfoDtoBody) {
    const {
      item_equipment_part,
      item_equipment_slot,
      item_name,
      item_icon,
      item_description,
      item_shape_name,
      item_shape_icon,
      item_gender,
      item_total_option,
      item_base_option,
      equipment_level_increase,
      item_exceptional_option,
      item_add_option,
      growth_exp,
      growth_level,
      scroll_upgrade,
      cuttable_count,
      golden_hammer_flag,
      scroll_resilience_count,
      scroll_upgradeable_count,
      soul_name,
      soul_option,
      item_etc_option,
      starforce,
      starforce_scroll_flag,
      item_starforce_option,
      special_ring_level,
      date_expire,
    } = obj;

    this.itemEquipmentPart = item_equipment_part;
    this.itemEquipmentSlot = item_equipment_slot;
    this.itemName = item_name;
    this.itemIcon = item_icon;
    this.itemDescription = item_description;
    this.itemShapeName = item_shape_name;
    this.itemShapeIcon = item_shape_icon;
    this.itemGender = item_gender;
    this.itemTotalOption = new CharacterItemEquipmentTotalOptionDto(
      item_total_option,
    );
    this.itemBaseOption = new CharacterItemEquipmentBaseOptionDto(
      item_base_option,
    );
    this.equipmentLevelIncrease = equipment_level_increase;
    this.itemExceptionalOption = new CharacterItemEquipmentExceptionalOptionDto(
      item_exceptional_option,
    );
    this.itemAddOption = new CharacterItemEquipmentAddOptionDto(
      item_add_option,
    );
    this.growthExp = growth_exp;
    this.growthLevel = growth_level;
    this.scrollUpgrade = scroll_upgrade;
    this.cuttableCount = cuttable_count;
    this.goldenHammerFlag = golden_hammer_flag;
    this.scrollResilienceCount = scroll_resilience_count;
    this.scrollUpgradeableCount = scroll_upgradeable_count;
    this.soulName = soul_name;
    this.soulOption = soul_option;
    this.itemEtcOption = new CharacterItemEquipmentEtcOptionDto(
      item_etc_option,
    );
    this.starforce = starforce;
    this.starforceScrollFlag = starforce_scroll_flag;
    this.itemStarforceOption = new CharacterItemEquipmentStarforceOptionDto(
      item_starforce_option,
    );
    this.specialRingLevel = special_ring_level;
    this.dateExpire = date_expire ? new Date(date_expire) : null;
  }
}

export { CharacterItemEquipmentMechanicInfoDto };
