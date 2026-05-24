import {
  BattlePracticeResultBody,
  BattlePracticeSkillStatisticBody,
} from '../../response/battlePractice/battlePracticeResultBody';

/**
 * 연무장 측정 결과 정보
 */
export class BattlePracticeResultDto {
  /**
   * 리플레이 등록 일시 (KST)
   */
  public registerDate: Date;

  /**
   * 총 연무 시간 (ms)
   */
  public totalPlayTime: number;

  /**
   * 총합 데미지
   */
  public totalDamage: number;

  /**
   * 초당 평균 데미지
   */
  public totalDps: number;

  /**
   * 종료 타입 (1:자동 종료, 2:수동 종료, 3:시간 초과, 9:기타 종료)
   */
  public endType: string;

  /**
   * 리플레이 추천 수
   */
  public likeCount: number;

  /**
   * 스킬 단위 전투 분석 정보
   */
  public skillStatistic: BattlePracticeSkillStatisticDto[];

  constructor(obj: BattlePracticeResultBody) {
    this.registerDate = new Date(obj.register_date);
    this.totalPlayTime = obj.total_play_time;
    this.totalDamage = obj.total_damage;
    this.totalDps = obj.total_dps;
    this.endType = obj.end_type;
    this.likeCount = obj.like_count;
    this.skillStatistic = obj.skill_statistic.map(
      (s) => new BattlePracticeSkillStatisticDto(s),
    );
  }
}

/**
 * 연무장 스킬 단위 전투 분석 정보
 */
export class BattlePracticeSkillStatisticDto {
  /**
   * 스킬 명
   */
  public skillName: string;

  /**
   * 누적 데미지
   */
  public damage: number;

  /**
   * 데미지 점유율
   */
  public damagePercent: string;

  /**
   * 초당 평균 데미지
   */
  public dps: number;

  /**
   * 사용 횟수
   */
  public useCount: number;

  /**
   * 1회당 평균 데미지
   */
  public damagePerUse: number;

  /**
   * 공격 횟수
   */
  public attackCount: number;

  /**
   * 최대 데미지 (1타)
   */
  public maxDamage: number;

  /**
   * 최소 데미지 (1타)
   */
  public minDamage: number;

  constructor(obj: BattlePracticeSkillStatisticBody) {
    this.skillName = obj.skill_name;
    this.damage = obj.damage;
    this.damagePercent = obj.damage_percent;
    this.dps = obj.dps;
    this.useCount = obj.use_count;
    this.damagePerUse = obj.damage_per_use;
    this.attackCount = obj.attack_count;
    this.maxDamage = obj.max_damage;
    this.minDamage = obj.min_damage;
  }
}
