import { UnionChampionBadgeInfoDto } from './unionChampionBadgeInfoDto';
import { UnionChampionInfoDtoBody } from '../../response/union/unionChampionDtoBody';

/**
 * 유니온 챔피언 상세 정보
 */
class UnionChampionInfoDto {

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

  constructor(obj: UnionChampionInfoDtoBody) {
    const { champion_slot, champion_grade, champion_class, champion_badge_info } = obj;

    this.championSlot = champion_slot;
    this.championGrade = champion_grade;
    this.championClass = champion_class;
    this.championBadgeInfo = champion_badge_info.map((info) => new UnionChampionBadgeInfoDto(info));
  }
}

export { UnionChampionInfoDto }
