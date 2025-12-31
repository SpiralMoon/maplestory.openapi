namespace MapleStory.OpenAPI.Common.DTO
{
    public abstract class UnionChampionDTO<TUnionChampionInfo, TUnionChampionBadgeInfo>
    {
        public abstract DateTimeOffset? Date { get; set; }
        public abstract List<TUnionChampionInfo> UnionChampion { get; set; }
        public abstract List<TUnionChampionBadgeInfo> ChampionBadgeTotalInfo { get; set; }
    }

    public abstract class UnionChampionDTO : UnionChampionDTO<UnionChampionInfoDTO, UnionChampionBadgeInfoDTO>
    {

    }

    public abstract class UnionChampionBadgeInfoDTO
    {
        public abstract string Stat { get; set; }
    }

    public abstract class UnionChampionInfoDTO<TUnionChampionBadgeInfo>
    {
        public abstract string ChampionName { get; set; }
        public abstract int ChampionSlot { get; set; }
        public abstract string ChampionGrade { get; set; }
        public abstract string ChampionClass { get; set; }
        public abstract List<TUnionChampionBadgeInfo> ChampionBadgeInfo { get; set; }
    }

    public abstract class UnionChampionInfoDTO : UnionChampionInfoDTO<UnionChampionBadgeInfoDTO>
    {

    }
}
