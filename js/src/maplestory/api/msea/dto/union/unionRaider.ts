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
 * Union raider information
 */
export class UnionRaiderDto extends base.UnionRaiderDto {
  /**
   * Reference date for query (SGT, daily data with hours and minutes set to 0)
   */
  public override date: Date | null;

  /**
   * Union raid member effects
   */
  public override unionRaiderStat: string[];

  /**
   * Union raid capture effects
   */
  public override unionOccupiedStat: string[];

  /**
   * Union raider deployment
   */
  public override unionInnerStat: UnionRaiderInnerStatDto[];

  /**
   * Union Legion Block
   */
  public override unionBlock: UnionRaiderBlockDto[];

  /**
   * Number of the preset currently in use
   */
  public override usePresetNo: number;

  /**
   * Information for Union Preset 1
   */
  public override unionRaiderPreset1: UnionRaiderPresetDto | null;

  /**
   * Information for Union Preset 2
   */
  public override unionRaiderPreset2: UnionRaiderPresetDto | null;

  /**
   * Information for Union Preset 3
   */
  public override unionRaiderPreset3: UnionRaiderPresetDto | null;

  /**
   * Information for Union Preset 4
   */
  public override unionRaiderPreset4: UnionRaiderPresetDto | null;

  /**
   * Information for Union Preset 5
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
 * Union raider deployment information
 */
export class UnionRaiderInnerStatDto extends base.UnionRaiderInnerStatDto {
  /**
   * Raider deployment position (0 to 7, clockwise from 11 o'clock)
   */
  public override statFieldId: string;

  /**
   * Occupation effects over the area
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
 * Coordinates of the area occupied by the block
 */
export class UnionRaiderBlockPositionDto extends base.UnionRaiderBlockPositionDto {
  /**
   * Block X-coordinate
   */
  public override x: number;

  /**
   * Block Y-coordinate
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
 * Coordinates of the block's reference point:
 * - The bottom-right square among the four central squares is positioned at x: 0, y: 0.
 * - Moving one square to the left decreases x by 1.
 * - Moving one square to the right increases x by 1.
 * - Moving one square downward decreases y by 1.
 * - Moving one square upward increases y by 1.
 */
export class UnionRaiderBlockControlPointDto extends base.UnionRaiderBlockControlPointDto {
  /**
   * Block reference point X-coordinate
   */
  public override x: number;

  /**
   * Block reference point Y-coordinate
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
 * Union Legion Block information
 */
export class UnionRaiderBlockDto extends base.UnionRaiderBlockDto {
  /**
   * Block shapes (Warrior, Magician, Bowman, Thief, Pirate, Maple M, Hybrid)
   */
  public override blockType: string;

  /**
   * Character class corresponding to the block
   */
  public override blockClass: string;

  /**
   * Character level corresponding to the block
   */
  public override blockLevel: string;

  /**
   * Coordinates of the block's reference point
   */
  public override blockControlPoint: UnionRaiderBlockControlPointDto;

  /**
   * Coordinates of the area occupied by the block (null if not placed)
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
 * Union preset information
 */
export class UnionRaiderPresetDto extends base.UnionRaiderPresetDto {
  /**
   * Union raid member effects
   */
  public override unionRaiderStat: string[];

  /**
   * Union raid capture effects
   */
  public override unionOccupiedStat: string[];

  /**
   * Union raider deployment
   */
  public override unionInnerStat: UnionRaiderInnerStatDto[];

  /**
   * Information about Legion Blocks
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
