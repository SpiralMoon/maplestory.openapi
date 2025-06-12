export type UnionRaiderBody = {
  date: string | null;
  union_raider_stat: string[];
  union_occupied_stat: string[];
  union_inner_stat: UnionRaiderInnerStatBody[];
  union_block: UnionRaiderBlockBody[];
  use_preset_no: number;
  union_raider_preset_1: UnionRaiderPresetBody | null;
  union_raider_preset_2: UnionRaiderPresetBody | null;
  union_raider_preset_3: UnionRaiderPresetBody | null;
  union_raider_preset_4: UnionRaiderPresetBody | null;
  union_raider_preset_5: UnionRaiderPresetBody | null;
};

export type UnionRaiderInnerStatBody = {
  stat_field_id: string;
  stat_field_effect: string;
};

export type UnionRaiderBlockBody = {
  block_type: string;
  block_class: string;
  block_level: string;
  block_control_point: UnionRaiderBlockControlPointBody;
  block_position: UnionRaiderBlockPositionBody[];
};

export type UnionRaiderBlockControlPointBody = {
  x: number;
  y: number;
};

export type UnionRaiderBlockPositionBody = {
  x: number;
  y: number;
};

export type UnionRaiderPresetBody = {
  union_raider_stat: string[];
  union_occupied_stat: string[];
  union_inner_stat: UnionRaiderInnerStatBody[];
  union_block: UnionRaiderBlockBody[];
};
