import * as base from '../../../common/dto/union/unionChampion';
import {
  UnionChampionBadgeInfoBody,
  UnionChampionBody,
  UnionChampionInfoBody,
} from '../../response/union/unionChampionBody';

/**
 * 聯盟冠軍資訊
 */
export class UnionChampionDto extends base.UnionChampionDto {
  public override date: Date | null;

  /**
   * 聯盟冠軍資訊
   */
  public override unionChampion: UnionChampionInfoDto[];

  /**
   * 冠軍徽章效果
   */
  public override championBadgeTotalInfo: UnionChampionBadgeInfoDto[];

  constructor(obj: UnionChampionBody) {
    super();

    const { date, union_champion, champion_badge_total_info } = obj;

    this.date = date ? new Date(date) : null;
    this.unionChampion = union_champion.map(
      (info) => new UnionChampionInfoDto(info),
    );
    this.championBadgeTotalInfo = champion_badge_total_info.map(
      (info) => new UnionChampionBadgeInfoDto(info),
    );
  }
}

/**
 * 聯盟冠軍徽章資訊
 */
export class UnionChampionBadgeInfoDto extends base.UnionChampionBadgeInfoDto {
  /**
   * 聯盟冠軍徽章資訊
   */
  public override stat: string;

  constructor(obj: UnionChampionBadgeInfoBody) {
    super();

    const { stat } = obj;

    this.stat = stat;
  }
}

/**
 * 聯盟冠軍資訊
 */
export class UnionChampionInfoDto extends base.UnionChampionInfoDto {
  /**
   * 聯盟冠軍角色名稱
   */
  public override championName: string;

  /**
   * 聯盟冠軍欄位
   */
  public override championSlot: number;

  /**
   * 聯盟冠軍等級
   */
  public override championGrade: string;

  /**
   * 聯盟冠軍角色職業
   */
  public override championClass: string;

  /**
   * 聯盟冠軍徽章資訊
   */
  public override championBadgeInfo: UnionChampionBadgeInfoDto[];

  constructor(obj: UnionChampionInfoBody) {
    super();

    const {
      champion_name,
      champion_slot,
      champion_grade,
      champion_class,
      champion_badge_info,
    } = obj;

    this.championName = champion_name;
    this.championSlot = champion_slot;
    this.championGrade = champion_grade;
    this.championClass = champion_class;
    this.championBadgeInfo = champion_badge_info.map(
      (info) => new UnionChampionBadgeInfoDto(info),
    );
  }
}