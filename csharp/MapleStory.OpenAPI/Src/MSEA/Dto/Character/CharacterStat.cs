using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.MSEA.DTO
{
    /// <summary>
    /// Character comprehensive stats information
    /// </summary>
    public class CharacterStatDTO : Base.CharacterStatDTO<CharacterFinalStatDTO>
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
        /// Character job
        /// </summary>
        [JsonProperty("character_class")]
        public override string CharacterClass { get; set; }

        /// <summary>
        /// Current stat information
        /// </summary>
        [JsonProperty("final_stat")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterFinalStatDTO> FinalStat { get; set; } = new();

        /// <summary>
        /// Remaining AP
        /// </summary>
        [JsonProperty("remain_ap")]
        public override int RemainAp { get; set; }
    }

    /// <summary>
    /// Current stat information
    /// </summary>
    public class CharacterFinalStatDTO : Base.CharacterFinalStatDTO
    {
        /// <summary>
        /// Stat name
        /// </summary>
        [JsonProperty("stat_name")]
        public override string StatName { get; set; }

        /// <summary>
        /// Stat value
        /// </summary>
        [JsonProperty("stat_value")]
        public override string StatValue { get; set; }
    }
}
