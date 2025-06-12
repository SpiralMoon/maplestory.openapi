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
 * 유니온 공격대 정보
 */
export class UnionRaiderDto extends base.UnionRaiderDto {
  /**
   * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
   */
  public override date: Date | null;

  /**
   * 유니온 공격대원 효과
   */
  public override unionRaiderStat: string[];

  /**
   * 유니온 공격대 점령 효과
   */
  public override unionOccupiedStat: string[];

  /**
   * 유니온 공격대 배치
   */
  public override unionInnerStat: UnionRaiderInnerStatDto[];

  /**
   * 유니온 블록 정보
   */
  public override unionBlock: UnionRaiderBlockDto[];

  /**
   * 적용 중인 프리셋 번호
   */
  public override usePresetNo: number;

  /**
   * 유니온 프리셋 1번 정보
   */
  public override unionRaiderPreset1: UnionRaiderPresetDto | null;

  /**
   * 유니온 프리셋 2번 정보
   */
  public override unionRaiderPreset2: UnionRaiderPresetDto | null;

  /**
   * 유니온 프리셋 3번 정보
   */
  public override unionRaiderPreset3: UnionRaiderPresetDto | null;

  /**
   * 유니온 프리셋 4번 정보
   */
  public override unionRaiderPreset4: UnionRaiderPresetDto | null;

  /**
   * 유니온 프리셋 5번 정보
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
 * 유니온 공격대 배치 정보
 */
export class UnionRaiderInnerStatDto extends base.UnionRaiderInnerStatDto {
  /**
   * 공격대 배치 위치 (11시 방향부터 시계 방향 순서대로 0~7)
   */
  public override statFieldId: string;

  /**
   * 해당 지역 점령 효과
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
 * 유니온 블록이 차지하고 있는 영역 좌표들
 */
export class UnionRaiderBlockPositionDto extends base.UnionRaiderBlockPositionDto {
  /**
   * 블록 X좌표
   */
  public override x: number;

  /**
   * 블록 Y좌표
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
 * 유니온 블록 기준점 좌표 정보
 */
export class UnionRaiderBlockControlPointDto extends base.UnionRaiderBlockControlPointDto {
  /**
   * 블록 기준점 X좌표
   */
  public override x: number;

  /**
   * 블록 기준점 Y좌표
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
 * 유니온 블록 정보
 */
export class UnionRaiderBlockDto extends base.UnionRaiderBlockDto {
  /**
   * 블록 모양 (전사, 마법사, 궁수, 도적, 해적, 메이플m, 하이브리드)
   */
  public override blockType: string;

  /**
   * 블록 해당 캐릭터 직업
   */
  public override blockClass: string;

  /**
   * 블록 해당 캐릭터 레벨
   */
  public override blockLevel: string;

  /**
   * 블록 기준점 좌표
   */
  public override blockControlPoint: UnionRaiderBlockControlPointDto;

  /**
   * 블록이 차지하고 있는 영역 좌표들 (null:미 배치 시)
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
 * 유니온 프리셋 정보
 */
export class UnionRaiderPresetDto extends base.UnionRaiderPresetDto {
  /**
   * 유니온 공격대원 효과
   */
  public override unionRaiderStat: string[];

  /**
   * 유니온 공격대 점령 효과
   */
  public override unionOccupiedStat: string[];

  /**
   * 유니온 공격대 배치
   */
  public override unionInnerStat: UnionRaiderInnerStatDto[];

  /**
   * 유니온 블록 정보
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
