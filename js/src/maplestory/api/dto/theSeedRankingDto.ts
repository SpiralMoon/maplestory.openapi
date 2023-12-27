import { TheSeedRankingDtoBody } from '../response/theSeedRankingResponseDtoBody';

/**
 * 더 시드 랭킹 정보
 */
class TheSeedRankingDto {
  /**
   * 랭킹 업데이트 일자 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
   */
  date: Date;

  /**
   * 더 시드 랭킹 순위
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
   * 더 시드 도달 층
   */
  theSeedFloor: number;

  /**
   * 더 시드 클리어 시간 기록 (초 단위)
   */
  theSeedTimeRecord: number;

  constructor(obj: TheSeedRankingDtoBody) {
    const {
      date,
      ranking,
      character_name,
      world_name,
      class_name,
      sub_class_name,
      character_level,
      theseed_floor,
      theseed_time_record,
    } = obj;

    this.date = new Date(date);
    this.ranking = ranking;
    this.characterName = character_name;
    this.worldName = world_name;
    this.className = class_name;
    this.subClassName = sub_class_name;
    this.characterLevel = character_level;
    this.theSeedFloor = theseed_floor;
    this.theSeedTimeRecord = theseed_time_record;
  }
}

export { TheSeedRankingDto };
