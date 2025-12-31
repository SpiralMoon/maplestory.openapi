using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.MSEA.DTO
{
    /// <summary>
    /// Union Champion information
    /// </summary>
    public class UnionChampionDTO : Base.UnionChampionDTO<UnionChampionInfoDTO, UnionChampionBadgeInfoDTO>
    {
        /// <summary>
        /// Reference date for query (SGT, daily data with hours and minutes set to 0)
        /// </summary>
        [JsonProperty("date")]
        public override DateTimeOffset? Date
        {
            get
            {
                return _date?.ToOffset(TimeSpan.FromHours(8));
            }
            set
            {
                _date = value;
            }
        }

        private DateTimeOffset? _date;

        /// <summary>
        /// Union Champion information
        /// </summary>
        [JsonProperty("union_champion")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<UnionChampionInfoDTO> UnionChampion { get; set; } = new();

        /// <summary>
        /// Champion Insignia effects
        /// </summary>
        [JsonProperty("champion_badge_total_info")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<UnionChampionBadgeInfoDTO> ChampionBadgeTotalInfo { get; set; } = new();
    }

    /// <summary>
    /// Union Champion Insignia information
    /// </summary>
    public class UnionChampionBadgeInfoDTO : Base.UnionChampionBadgeInfoDTO
    {
        /// <summary>
        /// Union Champion Insignia information
        /// </summary>
        [JsonProperty("stat")]
        public override string? Stat { get; set; }
    }

    /// <summary>
    /// Union Champion information
    /// </summary>
    public class UnionChampionInfoDTO : Base.UnionChampionInfoDTO<UnionChampionBadgeInfoDTO>
    {
        /// <summary>
        /// Union Champion character name
        /// </summary>
        [JsonProperty("champion_name")]
        public override string ChampionName { get; set; }

        /// <summary>
        /// Union Champion slot
        /// </summary>
        [JsonProperty("champion_slot")]
        public override int ChampionSlot { get; set; }

        /// <summary>
        /// Union Champion level
        /// </summary>
        [JsonProperty("champion_grade")]
        public override string ChampionGrade { get; set; }

        /// <summary>
        /// Union Champion character's job
        /// </summary>
        [JsonProperty("champion_class")]
        public override string ChampionClass { get; set; }

        /// <summary>
        /// Union Champion Insignia information
        /// </summary>
        [JsonProperty("champion_badge_info")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<UnionChampionBadgeInfoDTO> ChampionBadgeInfo { get; set; } = new();
    }
}
