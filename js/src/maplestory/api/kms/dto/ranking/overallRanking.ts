import {
  OverallRankingBody,
  OverallRankingResponseBody,
} from '../../response/ranking/overallRankingBody';

/**
 * 종합 랭킹 정보
 */
export class OverallRankingDto {
  /**
   * 랭킹 업데이트 일자 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
   */
  date: Date;

  /**
   * 종합 랭킹 순위
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
   * 캐릭터 레벨
   */
  characterLevel: number;

  /**
   * 캐릭터 경험치
   */
  characterExp: number;

  /**
   * 캐릭터 인기도
   */
  characterPopularity: number;

  /**
   * 길드 명
   */
  characterGuildName: string | null;

  constructor(obj: OverallRankingBody) {
    const {
      date,
      ranking,
      character_name,
      world_name,
      class_name,
      sub_class_name,
      character_level,
      character_exp,
      character_popularity,
      character_guildname,
    } = obj;

    this.date = new Date(date);
    this.ranking = ranking;
    this.characterName = character_name;
    this.worldName = world_name;
    this.className = class_name;
    this.subClassName = sub_class_name;
    this.characterLevel = character_level;
    this.characterExp = character_exp;
    this.characterPopularity = character_popularity;
    this.characterGuildName = character_guildname;
  }
}

/**
 * 종합 랭킹 응답 정보
 */
export class OverallRankingResponseDto {
  /**
   * 종합 랭킹 정보
   */
  ranking: OverallRankingDto[];

  constructor(obj: OverallRankingResponseBody) {
    const { ranking } = obj;

    this.ranking = ranking.map((rank) => new OverallRankingDto(rank));
  }
}
