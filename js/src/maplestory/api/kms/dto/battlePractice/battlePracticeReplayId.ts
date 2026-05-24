import {
  BattlePracticeReplayBody,
  BattlePracticeReplayIdBody,
} from '../../response/battlePractice/battlePracticeReplayIdBody';

/**
 * 연무장 리플레이 식별자 목록
 */
export class BattlePracticeReplayIdDto {
  /**
   * 리플레이 목록
   */
  public replayList: BattlePracticeReplayIdInfoDto[];

  constructor(obj: BattlePracticeReplayIdBody) {
    this.replayList = obj.replay_list.map((r) => new BattlePracticeReplayIdInfoDto(r));
  }
}

/**
 * 연무장 리플레이 식별자 상세 정보
 */
export class BattlePracticeReplayIdInfoDto {
  /**
   * 기간 번호 (연무장 초기화 시마다 1씩 증가됩니다.)
   */
  public periodNo: number;

  /**
   * 리플레이 등록 일시 (KST)
   */
  public registerDate: Date;

  /**
   * 연무장 리플레이 고유 식별자
   */
  public replayId: string;

  constructor(obj: BattlePracticeReplayBody) {
    this.periodNo = obj.period_no;
    this.registerDate = new Date(obj.register_date);
    this.replayId = obj.replay_id;
  }
}
