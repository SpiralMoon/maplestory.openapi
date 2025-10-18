import * as base from '../../../common/dto/union/unionRaider';
import {
  UnionRaiderBlockBody,
  UnionRaiderBlockControlPointBody,
  UnionRaiderBlockPositionBody,
  UnionRaiderBody,
  UnionRaiderInnerStatBody,
  UnionRaiderPresetBody,
} from '../../response/union/unionRaiderBody';

/**
 * 戰地攻擊隊資訊
 */
export class UnionRaiderDto extends base.UnionRaiderDto {
  /**
   * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
   */
  public override date: Date | null;

  /**
   * 戰地攻擊隊員效果
   */
  public override unionRaiderStat: string[];

  /**
   * 戰地攻擊隊佔領效果
   */
  public override unionOccupiedStat: string[];

  /**
   * 戰地攻擊隊部署
   */
  public override unionInnerStat: UnionRaiderInnerStatDto[];

  /**
   * 聯盟方塊資訊
   */
  public override unionBlock: UnionRaiderBlockDto[];

  /**
   * 目前套用的預設編號
   */
  public override usePresetNo: number;

  /**
   * 聯盟預設 1 資訊
   */
  public override unionRaiderPreset1: UnionRaiderPresetDto | null;

  /**
   * 聯盟預設 2 資訊
   */
  public override unionRaiderPreset2: UnionRaiderPresetDto | null;

  /**
   * 聯盟預設 3 資訊
   */
  public override unionRaiderPreset3: UnionRaiderPresetDto | null;

  /**
   * 聯盟預設 4 資訊
   */
  public override unionRaiderPreset4: UnionRaiderPresetDto | null;

  /**
   * 聯盟預設 5 資訊
   */
  public override unionRaiderPreset5: UnionRaiderPresetDto | null;

  constructor(obj: UnionRaiderBody) {
    super();

    const {
      date,
      union_raider_stat,
      union_occupied_stat,
      union_inner_stat,
      union_block,
      use_preset_no,
      union_raider_preset_1,
      union_raider_preset_2,
      union_raider_preset_3,
      union_raider_preset_4,
      union_raider_preset_5,
    } = obj;

    this.date = date ? new Date(date) : null;
    this.unionRaiderStat = union_raider_stat;
    this.unionOccupiedStat = union_occupied_stat;
    this.unionInnerStat = union_inner_stat.map(
      (stat) => new UnionRaiderInnerStatDto(stat),
    );
    this.unionBlock = union_block.map(
      (block) => new UnionRaiderBlockDto(block),
    );
    this.usePresetNo = use_preset_no;
    this.unionRaiderPreset1 = union_raider_preset_1
      ? new UnionRaiderPresetDto(union_raider_preset_1)
      : null;
    this.unionRaiderPreset2 = union_raider_preset_2
      ? new UnionRaiderPresetDto(union_raider_preset_2)
      : null;
    this.unionRaiderPreset3 = union_raider_preset_3
      ? new UnionRaiderPresetDto(union_raider_preset_3)
      : null;
    this.unionRaiderPreset4 = union_raider_preset_4
      ? new UnionRaiderPresetDto(union_raider_preset_4)
      : null;
    this.unionRaiderPreset5 = union_raider_preset_5
      ? new UnionRaiderPresetDto(union_raider_preset_5)
      : null;
  }
}

/**
 * 戰地攻擊隊部署
 */
export class UnionRaiderInnerStatDto extends base.UnionRaiderInnerStatDto {
  /**
   * 攻擊單位部署位置 (以 11 點鐘方向為起點，順時針 0-7)
   */
  public override statFieldId: string;

  /**
   * 相關區域佔領效果
   */
  public override statFieldEffect: string;

  constructor(obj: UnionRaiderInnerStatBody) {
    super();

    const { stat_field_id, stat_field_effect } = obj;

    this.statFieldId = stat_field_id;
    this.statFieldEffect = stat_field_effect;
  }
}

/**
 * 方塊佔領區域的座標
 */
export class UnionRaiderBlockPositionDto extends base.UnionRaiderBlockPositionDto {
  /**
   * 方塊 x 座標
   */
  public override x: number;

  /**
   * 方塊 y 座標
   */
  public override y: number;

  constructor(obj: UnionRaiderBlockPositionBody) {
    super();

    const { x, y } = obj;

    this.x = x;
    this.y = y;
  }
}

/**
 * 方塊基準點座標
 * - 四個中央方塊的右下角為位置 x : 0, y : 0
 * - 向左移動一格，x 減少 1
 * - 向右移動一格，x 增加 1
 * - 向下移動一格，y 減少 1
 * - 向上移動一格，y 增加 1
 */
export class UnionRaiderBlockControlPointDto extends base.UnionRaiderBlockControlPointDto {
  /**
   * 方塊基準點 x 座標
   */
  public override x: number;

  /**
   * 方塊基準點 y 座標
   */
  public override y: number;

  constructor(obj: UnionRaiderBlockControlPointBody) {
    super();

    const { x, y } = obj;

    this.x = x;
    this.y = y;
  }
}

/**
 * 聯盟方塊資訊
 */
export class UnionRaiderBlockDto extends base.UnionRaiderBlockDto {
  /**
   * 方塊編制 (戰士、法師、弓箭手、盜賊、海盜、混合)
   */
  public override blockType: string;

  /**
   * 方塊角色職業
   */
  public override blockClass: string;

  /**
   * 方塊角色等級
   */
  public override blockLevel: string;

  /**
   * 方塊基準點座標
   */
  public override blockControlPoint: UnionRaiderBlockControlPointDto;

  /**
   * 方塊佔領區域的座標 (null：未部署時)
   */
  public override blockPosition: UnionRaiderBlockPositionDto[] | null;

  constructor(obj: UnionRaiderBlockBody) {
    super();

    const {
      block_type,
      block_class,
      block_level,
      block_control_point,
      block_position,
    } = obj;

    this.blockType = block_type;
    this.blockClass = block_class;
    this.blockLevel = block_level;
    this.blockControlPoint = new UnionRaiderBlockControlPointDto(
      block_control_point,
    );
    this.blockPosition = block_position
      ? block_position.map(
          (position) => new UnionRaiderBlockPositionDto(position),
        )
      : null;
  }
}

/**
 * 聯盟預設 資訊
 */
export class UnionRaiderPresetDto extends base.UnionRaiderPresetDto {
  /**
   * 戰地攻擊隊員效果
   */
  public override unionRaiderStat: string[];

  /**
   * 戰地攻擊隊佔領效果
   */
  public override unionOccupiedStat: string[];

  /**
   * 戰地攻擊隊部署
   */
  public override unionInnerStat: UnionRaiderInnerStatDto[];

  /**
   * 聯盟方塊資訊
   */
  public override unionBlock: UnionRaiderBlockDto[];

  constructor(obj: UnionRaiderPresetBody) {
    super();

    const {
      union_raider_stat,
      union_occupied_stat,
      union_inner_stat,
      union_block,
    } = obj;

    this.unionRaiderStat = union_raider_stat;
    this.unionOccupiedStat = union_occupied_stat;
    this.unionInnerStat = union_inner_stat.map(
      (stat) => new UnionRaiderInnerStatDto(stat),
    );
    this.unionBlock = union_block.map(
      (block) => new UnionRaiderBlockDto(block),
    );
  }
}
