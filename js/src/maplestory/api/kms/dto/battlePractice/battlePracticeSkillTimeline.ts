import {
  BattlePracticeSkillTimelineBody,
  BattlePracticeSkillTimelineEventBody,
} from '../../response/battlePractice/battlePracticeSkillTimelineBody';

/**
 * 연무장 스킬 사용 내역
 */
export class BattlePracticeSkillTimelineDto {
  /**
   * 조회된 페이지 번호
   */
  public pageNo: number;

  /**
   * 전체 페이지 번호
   */
  public totalPageNo: number;

  /**
   * 스킬 타임라인 정보
   */
  public skillTimeline: BattlePracticeSkillTimelineEventDto[];

  constructor(obj: BattlePracticeSkillTimelineBody) {
    this.pageNo = obj.page_no;
    this.totalPageNo = obj.total_page_no;
    this.skillTimeline = obj.skill_timeline.map(
      (event) => new BattlePracticeSkillTimelineEventDto(event),
    );
  }
}

/**
 * 연무장 스킬 타임라인
 */
export class BattlePracticeSkillTimelineEventDto {
  /**
   * 연무 시작 후 경과 시간 (ms)
   */
  public elapseTime: number;

  /**
   * 사용한 스킬 명
   */
  public skillName: string;

  /**
   * 헥사 스킬 특성 여부 (0:그 외 스킬, 1:오리진 스킬, 2:어센트 스킬)
   */
  public hexaSkillSpecificityFlag: string ;

  /**
   * 시퀀스 명
   */
  public sequenceName: string | null;

  /**
   * 시퀀스 키
   */
  public sequenceKey: string | null;

  constructor(obj: BattlePracticeSkillTimelineEventBody) {
    this.elapseTime = obj.elapse_time;
    this.skillName = obj.skill_name;
    this.hexaSkillSpecificityFlag = obj.hexa_skill_specificity_flag;
    this.sequenceName = obj.sequence_name;
    this.sequenceKey = obj.sequence_key;
  }
}
