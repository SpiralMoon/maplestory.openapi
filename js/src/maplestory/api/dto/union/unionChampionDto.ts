import { UnionChampionBadgeInfoDto } from './unionChampionBadgeInfoDto';
import { UnionChampionInfoDto } from './unionChampionInfoDto';
import {
  UnionChampionDtoBody,
} from '../../response/union/unionChampionDtoBody';

/**
 * 유니온 챔피언 정보
 */
class UnionChampionDto {

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

  constructor(obj: UnionChampionDtoBody) {
    const { date, union_champion, champion_badge_total_info } = obj;

    this.date = date ? new Date(date) : null;
    this.unionChampion = union_champion.map((info) => new UnionChampionInfoDto(info))
    this.championBadgeTotalInfo = champion_badge_total_info.map((info) => new UnionChampionBadgeInfoDto(info));
  }
}

export { UnionChampionDto }
