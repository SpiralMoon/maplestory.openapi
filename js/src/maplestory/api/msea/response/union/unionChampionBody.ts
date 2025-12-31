export type UnionChampionBody = {
  date: string;
  union_champion: UnionChampionInfoBody[];
  champion_badge_total_info: UnionChampionBadgeInfoBody[];
};

export type UnionChampionInfoBody = {
  champion_name: string;
  champion_slot: number;
  champion_grade: string;
  champion_class: string;
  champion_badge_info: UnionChampionBadgeInfoBody[];
};

export type UnionChampionBadgeInfoBody = {
  stat: string;
};
