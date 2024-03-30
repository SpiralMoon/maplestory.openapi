type UnionRaiderDtoBody = {
  date: string | null;
  union_raider_stat: string[];
  union_occupied_stat: string[];
  union_inner_stat: UnionRaiderInnerStatDtoBody[];
  union_block: UnionRaiderBlockDtoBody[];
};

type UnionRaiderInnerStatDtoBody = {
  stat_field_id: string;
  stat_field_effect: string;
};

type UnionRaiderBlockDtoBody = {
  block_type: string;
  block_class: string;
  block_level: string;
  block_control_point: UnionRaiderBlockControlPointDtoBody;
  block_position: UnionRaiderBlockPositionDtoBody[];
};

type UnionRaiderBlockControlPointDtoBody = {
  x: number;
  y: number;
};

type UnionRaiderBlockPositionDtoBody = {
  x: number;
  y: number;
};

export type {
  UnionRaiderDtoBody,
  UnionRaiderInnerStatDtoBody,
  UnionRaiderBlockDtoBody,
  UnionRaiderBlockControlPointDtoBody,
  UnionRaiderBlockPositionDtoBody,
};
