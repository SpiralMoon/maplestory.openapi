import {
  UnionRaiderBlockBody,
  UnionRaiderBlockControlPointBody,
  UnionRaiderBlockPositionBody,
  UnionRaiderBody,
  UnionRaiderInnerStatBody, UnionRaiderPresetBody,
} from '../../response/union/unionRaiderBody';

/**
 * 유니온 공격대 정보
 */
export class UnionRaiderDto {
  date: Date | null;

  /**
   * 유니온 공격대원 효과
   */
  unionRaiderStat: string[];

  /**
   * 유니온 공격대 점령 효과
   */
  unionOccupiedStat: string[];

  /**
   * 유니온 공격대 배치
   */
  unionInnerStat: UnionRaiderInnerStatDto[];

  /**
   * 유니온 블록 정보
   */
  unionBlock: UnionRaiderBlockDto[];

  /**
   * 적용 중인 프리셋 번호
   */
  usePresetNo: number;

  /**
   * 유니온 프리셋 1번 정보
   */
  unionRaiderPreset1: UnionRaiderPresetDto | null;

  /**
   * 유니온 프리셋 2번 정보
   */
  unionRaiderPreset2: UnionRaiderPresetDto | null;

  /**
   * 유니온 프리셋 3번 정보
   */
  unionRaiderPreset3: UnionRaiderPresetDto | null;

  /**
   * 유니온 프리셋 4번 정보
   */
  unionRaiderPreset4: UnionRaiderPresetDto | null;

  /**
   * 유니온 프리셋 5번 정보
   */
  unionRaiderPreset5: UnionRaiderPresetDto | null;

  constructor(obj: UnionRaiderBody) {
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
export class UnionRaiderInnerStatDto {
  /**
   * 공격대 배치 위치 (11시 방향부터 시계 방향 순서대로 0~7)
   */
  statFieldId: string;

  /**
   * 해당 지역 점령 효과
   */
  statFieldEffect: string;

  constructor(obj: UnionRaiderInnerStatBody) {
    const { stat_field_id, stat_field_effect } = obj;

    this.statFieldId = stat_field_id;
    this.statFieldEffect = stat_field_effect;
  }
}

/**
 * 유니온 블록이 차지하고 있는 영역 좌표들
 */
export class UnionRaiderBlockPositionDto {
  /**
   * 블록 X좌표
   */
  x: number;

  /**
   * 블록 Y좌표
   */
  y: number;

  constructor(obj: UnionRaiderBlockPositionBody) {
    const { x, y } = obj;

    this.x = x;
    this.y = y;
  }
}

/**
 * 유니온 블록 기준점 좌표 정보
 */
export class UnionRaiderBlockControlPointDto {
  /**
   * 블록 기준점 X좌표
   */
  x: number;

  /**
   * 블록 기준점 Y좌표
   */
  y: number;

  constructor(obj: UnionRaiderBlockControlPointBody) {
    const { x, y } = obj;

    this.x = x;
    this.y = y;
  }
}

/**
 * 유니온 블록 정보
 */
export class UnionRaiderBlockDto {
  /**
   * 블록 모양 (전사, 마법사, 궁수, 도적, 해적, 메이플m, 하이브리드)
   */
  blockType: string;

  /**
   * 블록 해당 캐릭터 직업
   */
  blockClass: string;

  /**
   * 블록 해당 캐릭터 레벨
   */
  blockLevel: string;

  /**
   * 블록 기준점 좌표
   */
  blockControlPoint: UnionRaiderBlockControlPointDto;

  /**
   * 블록이 차지하고 있는 영역 좌표들 (null:미 배치 시)
   */
  blockPosition: UnionRaiderBlockPositionDto[] | null;

  constructor(obj: UnionRaiderBlockBody) {
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
export class UnionRaiderPresetDto {

  /**
   * 유니온 공격대원 효과
   */
  unionRaiderStat: string[];

  /**
   * 유니온 공격대 점령 효과
   */
  unionOccupiedStat: string[];

  /**
   * 유니온 공격대 배치
   */
  unionInnerStat: UnionRaiderInnerStatDto[];

  /**
   * 유니온 블록 정보
   */
  unionBlock: UnionRaiderBlockDto[];

  constructor(obj: UnionRaiderPresetBody) {
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
