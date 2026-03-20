import { CharacterRingReserveSkillEquipmentBody } from '../../response/character/characterRingReserveSkillEquipmentBody';

/**
 * 캐릭터 예비 특수 반지 장착 정보
 */
export class CharacterRingReserveSkillEquipmentDto {
  /**
   * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
   */
  public date: Date | null;

  /**
   * 캐릭터 직업
   */
  public characterClass: string;

  /**
   * 예비 특수 반지 슬롯에 장착한 특수 반지
   */
  public specialRingReserveName: string | null;

  /**
   * 예비 특수 반지 슬롯에 장착한 특수 반지 레벨
   */
  public specialRingReserveLevel: number | null;

  /**
   * 예비 특수 반지 슬롯에 장착한 특수 반지 아이콘
   */
  public specialRingReserveIcon: string | null;

  /**
   * 예비 특수 반지 슬롯에 장착한 특수 반지 설명
   */
  public specialRingReserveDescription: string | null;

  constructor(obj: CharacterRingReserveSkillEquipmentBody) {
    const {
      date,
      character_class,
      special_ring_reserve_name,
      special_ring_reserve_level,
      special_ring_reserve_icon,
      special_ring_reserve_description,
    } = obj;

    this.date = date ? new Date(date) : null;
    this.characterClass = character_class;
    this.specialRingReserveName = special_ring_reserve_name;
    this.specialRingReserveLevel = special_ring_reserve_level;
    this.specialRingReserveIcon = special_ring_reserve_icon;
    this.specialRingReserveDescription = special_ring_reserve_description;
  }
}
