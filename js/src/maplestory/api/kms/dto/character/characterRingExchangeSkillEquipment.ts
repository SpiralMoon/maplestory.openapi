import { CharacterRingExchangeSkillEquipmentBody } from '../../response/character/characterRingExchangeSkillEquipmentBody';

/**
 * 캐릭터 링 익스체인지 스킬 등록 장비 정보
 */
export class CharacterRingExchangeSkillEquipmentDto {
  /**
   * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
   */
  public date: Date | null;

  /**
   * 캐릭터 직업
   */
  public characterClass: string | null;

  /**
   * 링 익스체인지에 등록된 특수 반지
   */
  public specialRingExchangeName: string | null;

  /**
   * 링 익스체인지에 등록된 특수 반지 레벨
   */
  public specialRingExchangeLevel: number | null;

  /**
   * 링 익스체인지에 등록된 특수 반지 아이콘
   */
  public specialRingExchangeIcon: string | null;

  /**
   * 링 익스체인지에 등록된 특수 반지 설명
   */
  public specialRingExchangeDescription: string | null;

  constructor(obj: CharacterRingExchangeSkillEquipmentBody) {
    const {
      date,
      character_class,
      special_ring_exchange_name,
      special_ring_exchange_level,
      special_ring_exchange_icon,
      special_ring_exchange_description
    } = obj;

    this.date = date ? new Date(date) : null;
    this.characterClass = character_class ?? null;
    this.specialRingExchangeName = special_ring_exchange_name ?? null;
    this.specialRingExchangeLevel = special_ring_exchange_level ?? null;
    this.specialRingExchangeIcon = special_ring_exchange_icon ?? null;
    this.specialRingExchangeDescription = special_ring_exchange_description ?? null;
  }
}
