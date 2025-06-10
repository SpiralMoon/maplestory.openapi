using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.MSEA.DTO
{
    /// <summary>
    /// Character traits information
    /// </summary>
    public class CharacterPropensityDTO : Base.CharacterPropensityDTO
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
        /// Ambition level
        /// </summary>
        [JsonProperty("charisma_level")]
        public override int? CharismaLevel { get; set; }

        /// <summary>
        /// Empathy level
        /// </summary>
        [JsonProperty("sensibility_level")]
        public override int? SensibilityLevel { get; set; }

        /// <summary>
        /// Insight level
        /// </summary>
        [JsonProperty("insight_level")]
        public override int? InsightLevel { get; set; }

        /// <summary>
        /// Willpower level
        /// </summary>
        [JsonProperty("willingness_level")]
        public override int? WillingnessLevel { get; set; }

        /// <summary>
        /// Diligence level
        /// </summary>
        [JsonProperty("handicraft_level")]
        public override int? HandicraftLevel { get; set; }

        /// <summary>
        /// Charm level
        /// </summary>
        [JsonProperty("charm_level")]
        public override int? CharmLevel { get; set; }
    }
}
