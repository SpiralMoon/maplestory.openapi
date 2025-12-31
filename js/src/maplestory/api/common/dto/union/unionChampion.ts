export abstract class UnionChampionDto {
  public abstract date: Date | null;
  public abstract unionChampion: UnionChampionInfoDto[];
  public abstract championBadgeTotalInfo: UnionChampionBadgeInfoDto[];
}

export abstract class UnionChampionBadgeInfoDto {
  public abstract stat: string;
}

export abstract class UnionChampionInfoDto {
  public abstract championName: string;
  public abstract championSlot: number;
  public abstract championGrade: string;
  public abstract championClass: string;
  public abstract championBadgeInfo: UnionChampionBadgeInfoDto[];
}