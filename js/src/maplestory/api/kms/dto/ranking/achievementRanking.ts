import {
  AchievementRankingBody,
  AchievementRankingResponseBody,
} from '../../response/ranking/achievementRankingBody';

/**
 * 업적 랭킹 정보
 */
export class AchievementRankingDto {
  /**
   * 랭킹 업데이트 일자 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
   */
  date: Date;

  /**
   * 업적 랭킹 순위
   */
  ranking: number;

  /**
   * 캐릭터 명
   */
  characterName: string;

  /**
   * 월드 명
   */
  worldName: string;

  /**
   * 직업 명
   */
  className: string;

  /**
   * 전직 직업 명
   */
  subClassName: string;

  /**
   * 업적 등급
   */
  trophyGrade: string;

  /**
   * 업적 점수
   */
  trophyScore: number;

  constructor(obj: AchievementRankingBody) {
    const {
      date,
      ranking,
      character_name,
      world_name,
      class_name,
      sub_class_name,
      trophy_grade,
      trophy_score,
    } = obj;

    this.date = new Date(date);
    this.ranking = ranking;
    this.characterName = character_name;
    this.worldName = world_name;
    this.className = class_name;
    this.subClassName = sub_class_name;
    this.trophyGrade = trophy_grade;
    this.trophyScore = trophy_score;
  }
}

/**
 * 업적 랭킹 응답 정보
 */
export class AchievementRankingResponseDto {
  /**
   * 업적 랭킹 정보
   */
  ranking: AchievementRankingDto[];

  constructor(obj: AchievementRankingResponseBody) {
    const { ranking } = obj;

    this.ranking = ranking.map((rank) => new AchievementRankingDto(rank));
  }
}
