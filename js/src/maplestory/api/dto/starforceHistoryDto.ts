import { StarforceEventDto } from './starforceEventDto';
import { StarforceHistoryDtoBody } from '../response/starforceHistoryDtoBody';

/**
 * 스타포스 히스토리
 */
class StarforceHistoryDto {
  /**
   *스타포스 히스토리 식별자
   */
  id: string;

  /**
   *강화 시도 결과
   */
  itemUpgradeResult: string;

  /**
   *강화 시도 전 스타포스 수치
   */
  beforeStarforceCount: number;

  /**
   *강화 시도 후 스타포스 수치
   */
  afterStarforceCount: number;

  /**
   *스타 캐치
   */
  starCatchResult: string;

  /**
   *슈페리얼 장비
   */
  superiorItemFlag: string;

  /**
   *파괴 방지
   */
  destroyDefence: string;

  /**
   *찬스 타임
   */
  chanceTime: string;

  /**
   *파괴 방지 필드 이벤트
   */
  eventFieldFlag: string;

  /**
   *사용 주문서 명
   */
  upgradeItem: string;

  /**
   *프로텍트 실드
   */
  protectShield: string;

  /**
   *보너스 스탯 부여 아이템 여부
   */
  bonusStatUpgrade: string;

  /**
   *캐릭터 명
   */
  characterName: string;

  /**
   *월드 명
   */
  worldName: string;

  /**
   *대상 장비 아이템 명
   */
  targetItem: string;

  /**
   *강화 일시 (KST)
   */
  dateCreate: Date;

  /**
   * 진행 중인 스타포스 강화 이벤트 정보
   */
  starforceEventList: StarforceEventDto[];

  constructor(obj: StarforceHistoryDtoBody) {
    const {
      id,
      item_upgrade_result,
      before_starforce_count,
      after_starforce_count,
      starcatch_result,
      superior_item_flag,
      destroy_defence,
      chance_time,
      event_field_flag,
      upgrade_item,
      protect_shield,
      bonus_stat_upgrade,
      character_name,
      world_name,
      target_item,
      date_create,
      starforce_event_list,
    } = obj;

    this.id = id;
    this.itemUpgradeResult = item_upgrade_result;
    this.beforeStarforceCount = before_starforce_count;
    this.afterStarforceCount = after_starforce_count;
    this.starCatchResult = starcatch_result;
    this.superiorItemFlag = superior_item_flag;
    this.destroyDefence = destroy_defence;
    this.chanceTime = chance_time;
    this.eventFieldFlag = event_field_flag;
    this.upgradeItem = upgrade_item;
    this.protectShield = protect_shield;
    this.bonusStatUpgrade = bonus_stat_upgrade;
    this.characterName = character_name;
    this.worldName = world_name;
    this.targetItem = target_item;
    this.dateCreate = new Date(date_create);
    this.starforceEventList = starforce_event_list.map(
      (event) => new StarforceEventDto(event),
    );
  }
}

export { StarforceHistoryDto };
