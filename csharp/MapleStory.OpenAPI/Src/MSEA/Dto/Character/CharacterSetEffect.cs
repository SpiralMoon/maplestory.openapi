using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.MSEA.DTO
{
    /// <summary>
    /// Character information about equipped set item effects
    /// </summary>
    public class CharacterSetEffectDTO : Base.CharacterSetEffectDTO<CharacterSetEffectSetDTO>
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
        /// Set Item effect information
        /// </summary>
        [JsonProperty("set_effect")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterSetEffectSetDTO> SetEffect { get; set; } = new();
    }

    /// <summary>
    /// Active Set Item effect information
    /// </summary>
    public class CharacterSetEffectInfoDTO : Base.CharacterSetEffectInfoDTO
    {
        /// <summary>
        /// Set Item effect level (number of equipped items)
        /// </summary>
        [JsonProperty("set_count")]
        public override int SetCount { get; set; }

        /// <summary>
        /// Set Item effect
        /// </summary>
        [JsonProperty("set_option")]
        public override string SetOption { get; set; }
    }

    /// <summary>
    /// All Set Item effect information
    /// </summary>
    public class CharacterSetEffectOptionFullDTO : Base.CharacterSetEffectOptionFullDTO
    {
        /// <summary>
        /// Set Item effect level (number of equipped items)
        /// </summary>
        [JsonProperty("set_count")]
        public override int SetCount { get; set; }

        /// <summary>
        /// Set Item effect
        /// </summary>
        [JsonProperty("set_option")]
        public override string SetOption { get; set; }
    }

    /// <summary>
    /// Set Item effect information
    /// </summary>
    public class CharacterSetEffectSetDTO : Base.CharacterSetEffectSetDTO<CharacterSetEffectInfoDTO, CharacterSetEffectOptionFullDTO>
    {
        /// <summary>
        /// Set Item effect name
        /// </summary>
        [JsonProperty("set_name")]
        public override string SetName { get; set; }

        /// <summary>
        /// Number of Set Items (including Lucky Items)
        /// </summary>
        [JsonProperty("total_set_count")]
        public override long TotalSetCount { get; set; }

        /// <summary>
        /// Active Set Item effect information
        /// </summary>
        [JsonProperty("set_effect_info")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterSetEffectInfoDTO> SetEffectInfo { get; set; } = new();

        /// <summary>
        /// All Set Item effect information
        /// </summary>
        [JsonProperty("set_option_full")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterSetEffectOptionFullDTO> SetOptionFull { get; set; } = new();
    }
}
