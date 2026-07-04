import {
  SchedulerBossContentBody,
  SchedulerCharacterStateBody,
  SchedulerDailyContentBody,
  SchedulerWeeklyContentBody,
} from '../../response/scheduler/schedulerCharacterStateBody';

/**
 * 캐릭터 스케줄러 정보
 */
export class SchedulerCharacterStateDto {
  /**
   * 조회 기준일 (YYYY-MM-DD)
   */
  public date: Date | null;

  /**
   * 캐릭터 명
   */
  public characterName: string;

  /**
   * 월드 명
   */
  public worldName: string;

  /**
   * 캐릭터 레벨
   */
  public characterLevel: number;

  /**
   * 캐릭터 직업
   */
  public characterClass: string;

  /**
   * 일일 콘텐츠 정보
   */
  public dailyContents: SchedulerDailyContentDto[];

  /**
   * 주간 콘텐츠 정보
   */
  public weeklyContents: SchedulerWeeklyContentDto[];

  /**
   * 보스 콘텐츠 정보
   */
  public bossContents: SchedulerBossContentDto[];

  /**
   * 주간 보스 처치 완료 횟수
   */
  public weeklyBossClearCount: number;

  /**
   * 주간 보스 처치 제한 횟수
   */
  public weeklyBossClearLimitCount: number;

  constructor(obj: SchedulerCharacterStateBody) {
    this.date = obj.date ? new Date(obj.date) : null;
    this.characterName = obj.character_name;
    this.worldName = obj.world_name;
    this.characterLevel = obj.character_level;
    this.characterClass = obj.character_class;
    this.dailyContents = (obj.daily_contents ?? []).map((item) => new SchedulerDailyContentDto(item));
    this.weeklyContents = (obj.weekly_contents ?? []).map((item) => new SchedulerWeeklyContentDto(item));
    this.bossContents = (obj.boss_contents ?? []).map((item) => new SchedulerBossContentDto(item));
    this.weeklyBossClearCount = obj.weekly_boss_clear_count;
    this.weeklyBossClearLimitCount = obj.weekly_boss_clear_limit_count;
  }
}

/**
 * 스케줄러 일일 콘텐츠 정보
 */
export class SchedulerDailyContentDto {
  /**
   * 콘텐츠/퀘스트 명
   */
  public contentName: string;

  /**
   * 타입 ('contents', 'quest')
   */
  public type: string;

  /**
   * 인게임 스케줄러 등록 여부 (true/false)
   */
  public registrationFlag: string;

  /**
   * 현재 완료 횟수/점수
   */
  public nowCount: number;

  /**
   * 최대 완료 가능 횟수/점수
   */
  public maxCount: number;

  /**
   * 퀘스트인 경우 진행 상태 ("0":기타, "1":진행 중, "2":완료)
   */
  public questState: string | null;

  constructor(obj: SchedulerDailyContentBody) {
    this.contentName = obj.content_name;
    this.type = obj.type;
    this.registrationFlag = obj.registration_flag;
    this.nowCount = obj.now_count;
    this.maxCount = obj.max_count;
    this.questState = obj.quest_state;
  }
}

/**
 * 스케줄러 주간 콘텐츠 정보
 */
export class SchedulerWeeklyContentDto {
  /**
   * 콘텐츠 명
   */
  public contentName: string;

  /**
   * 콘텐츠 종류 ('contents', 'quest')
   */
  public type: string;

  /**
   * 인게임 스케줄러 등록 여부 (true/false)
   */
  public registrationFlag: string;

  /**
   * 현재 완료 횟수/점수
   */
  public nowCount: number;

  /**
   * 최대 완료 가능 횟수/점수
   */
  public maxCount: number;

  /**
   * 퀘스트인 경우 진행 상태 ("0":기타, "1":진행 중, "2":완료)
   */
  public questState: string | null;

  constructor(obj: SchedulerWeeklyContentBody) {
    this.contentName = obj.content_name;
    this.type = obj.type;
    this.registrationFlag = obj.registration_flag;
    this.nowCount = obj.now_count;
    this.maxCount = obj.max_count;
    this.questState = obj.quest_state;
  }
}

/**
 * 스케줄러 보스 콘텐츠 정보
 */
export class SchedulerBossContentDto {
  /**
   * 보스 명
   */
  public contentName: string;

  /**
   * 보스 난이도
   */
  public difficulty: string;

  /**
   * 보스 초기화 주기
   */
  public cycle: string;

  /**
   * 리스트 순서
   */
  public listOrderNo: number;

  /**
   * 인게임 스케줄러 등록 여부 (true/false)
   */
  public registrationFlag: string;

  /**
   * 완료 여부 (true/false)
   */
  public completeFlag: string;

  constructor(obj: SchedulerBossContentBody) {
    this.contentName = obj.content_name;
    this.difficulty = obj.difficulty;
    this.cycle = obj.cycle;
    this.listOrderNo = obj.list_order_no;
    this.registrationFlag = obj.registration_flag;
    this.completeFlag = obj.complete_flag;
  }
}
