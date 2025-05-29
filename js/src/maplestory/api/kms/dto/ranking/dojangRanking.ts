import {
  DojangRankingBody,
  DojangRankingResponseBody,
} from '../../response/ranking/dojangRankingBody';

/**
 * 무릉도장 랭킹 정보
 */
export class DojangRankingDto {
  /**
   * 랭킹 업데이트 일자 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
   */
  date: Date;

  /**
   * 무릉도장 랭킹 순위
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
   * 무릉도장 구간
   */
  dojangFloor: number;

  /**
   * 무릉도장 클리어 시간 기록 (초 단위)
   */
  dojangTimeRecord: number;

  constructor(obj: DojangRankingBody) {
    const {
      date,
      ranking,
      character_name,
      world_name,
      class_name,
      sub_class_name,
      character_level,
      dojang_floor,
      dojang_time_record,
    } = obj;

    this.date = new Date(date);
    this.ranking = ranking;
    this.characterName = character_name;
    this.worldName = world_name;
    this.className = class_name;
    this.subClassName = sub_class_name;
    this.characterLevel = character_level;
    this.dojangFloor = dojang_floor;
    this.dojangTimeRecord = dojang_time_record;
  }
}

/**
 * 무릉도장 랭킹 응답 정보
 */
export class DojangRankingResponseDto {
  /**
   * 길드 랭킹 정보
   */
  ranking: DojangRankingDto[];

  constructor(obj: DojangRankingResponseBody) {
    const { ranking } = obj;

    this.ranking = ranking.map((rank) => new DojangRankingDto(rank));
  }
}
