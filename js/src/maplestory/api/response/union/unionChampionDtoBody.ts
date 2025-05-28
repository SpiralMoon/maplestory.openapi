export type UnionChampionDtoBody = {
  date: string;
  union_champion: UnionChampionInfoDtoBody[];
  champion_badge_total_info: UnionChampionBadgeInfoDtoBody[];
}

export type UnionChampionInfoDtoBody = {
  champion_name: string;
  champion_slot: number;
  champion_grade: string;
  champion_class: string;
  champion_badge_info: UnionChampionBadgeInfoDtoBody[];
}

export type UnionChampionBadgeInfoDtoBody = {
  stat: string;
}
