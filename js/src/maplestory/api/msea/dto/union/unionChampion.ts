import * as base from '../../../common/dto/union/unionChampion';
import {
  UnionChampionBadgeInfoBody,
  UnionChampionBody,
  UnionChampionInfoBody,
} from '../../response/union/unionChampionBody';

/**
 * Union Champion information
 */
export class UnionChampionDto extends base.UnionChampionDto {
  /**
   * Reference date for query (SGT, daily data with hours and minutes set to 0)
   */
  public override date: Date | null;

  /**
   * Union Champion information
   */
  public override unionChampion: UnionChampionInfoDto[];

  /**
   * Champion Insignia effects
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
 * Champion Insignia effects
 */
export class UnionChampionBadgeInfoDto extends base.UnionChampionBadgeInfoDto {
  /**
   * Union Champion Insignia effects
   */
  public override stat: string;

  constructor(obj: UnionChampionBadgeInfoBody) {
    super();

    const { stat } = obj;

    this.stat = stat;
  }
}

/**
 * Union Champion information
 */
export class UnionChampionInfoDto extends base.UnionChampionInfoDto {
  /**
   * Union Champion character name
   */
  public override championName: string;

  /**
   * Union Champion slot
   */
  public override championSlot: number;

  /**
   * Union Champion level
   */
  public override championGrade: string;

  /**
   * Union Champion character's job
   */
  public override championClass: string;

  /**
   * Union Champion Insignia information
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