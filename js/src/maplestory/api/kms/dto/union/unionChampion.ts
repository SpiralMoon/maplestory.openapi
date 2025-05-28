import {
  UnionChampionBadgeInfoBody,
  UnionChampionBody,
  UnionChampionInfoBody,
} from '../../response/union/unionChampionBody';

/**
 * 유니온 챔피언 정보
 */
export class UnionChampionDto {

  /**
   * 조회 기준일
   */
  date: Date | null;

  /**
   * 유니온 챔피언 정보
   */
  unionChampion: UnionChampionInfoDto[];

  /**
   * 유니온 챔피언 휘장 정보
   */
  championBadgeTotalInfo: UnionChampionBadgeInfoDto[];

  constructor(obj: UnionChampionBody) {
    const { date, union_champion, champion_badge_total_info } = obj;

    this.date = date ? new Date(date) : null;
    this.unionChampion = union_champion.map((info) => new UnionChampionInfoDto(info))
    this.championBadgeTotalInfo = champion_badge_total_info.map((info) => new UnionChampionBadgeInfoDto(info));
  }
}

/**
 * 유니온 챔피언 휘장 정보
 */
export class UnionChampionBadgeInfoDto {

  /**
   * 유니온 챔피언 휘장 효과
   */
  stat: string;

  constructor(obj: UnionChampionBadgeInfoBody) {
    const { stat } = obj;

    this.stat = stat;
  }
}

/**
 * 유니온 챔피언 상세 정보
 */
export class UnionChampionInfoDto {

  /**
   * 유니온 챔피언 캐릭터 명
   */
  championName: string;

  /**
   * 유니온 챔피언 슬롯
   */
  championSlot: number;

  /**
   * 유니온 챔피언 등급
   */
  championGrade: string;

  /**
   * 유니온 챔피언 캐릭터의 직업
   */
  championClass: string;

  /**
   * 챔피언 휘장 효과
   */
  championBadgeInfo: UnionChampionBadgeInfoDto[];

  constructor(obj: UnionChampionInfoBody) {
    const { champion_name, champion_slot, champion_grade, champion_class, champion_badge_info } = obj;

    this.championName = champion_name;
    this.championSlot = champion_slot;
    this.championGrade = champion_grade;
    this.championClass = champion_class;
    this.championBadgeInfo = champion_badge_info.map((info) => new UnionChampionBadgeInfoDto(info));
  }
}
