using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.MSEA.DTO
{
    /// <summary>
    /// Character Hyper Stat information
    /// </summary>
    public class CharacterHyperStatDTO : Base.CharacterHyperStatDTO<CharacterHyperStatPresetDTO>
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
        /// Active preset number
        /// </summary>
        [JsonProperty("use_preset_no")]
        public override string UsePresetNo { get; set; }

        /// <summary>
        /// Maximum available Hyper Stat points
        /// </summary>
        [JsonProperty("use_available_hyper_stat")]
        public override int UseAvailableHyperStat { get; set; }

        /// <summary>
        /// Hyper Stat information for preset 1
        /// </summary>
        [JsonProperty("hyper_stat_preset_1")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterHyperStatPresetDTO> HyperStatPreset1 { get; set; } = new();

        /// <summary>
        /// Remaining Hyper Stat points for preset 1
        /// </summary>
        [JsonProperty("hyper_stat_preset_1_remain_point")]
        public override int HyperStatPreset1RemainPoint { get; set; }

        /// <summary>
        /// Hyper Stat information for preset 2
        /// </summary>
        [JsonProperty("hyper_stat_preset_2")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterHyperStatPresetDTO> HyperStatPreset2 { get; set; } = new();

        /// <summary>
        /// Remaining Hyper Stat points for preset 2
        /// </summary>
        [JsonProperty("hyper_stat_preset_2_remain_point")]
        public override int HyperStatPreset2RemainPoint { get; set; }

        /// <summary>
        /// Hyper Stat information for preset 3
        /// </summary>
        [JsonProperty("hyper_stat_preset_3")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterHyperStatPresetDTO> HyperStatPreset3 { get; set; } = new();

        /// <summary>
        /// Remaining Hyper Stat points for preset 3
        /// </summary>
        [JsonProperty("hyper_stat_preset_3_remain_point")]
        public override int HyperStatPreset3RemainPoint { get; set; }
    }

    /// <summary>
    /// Hyper Stat information for preset
    /// </summary>
    public class CharacterHyperStatPresetDTO : Base.CharacterHyperStatPresetDTO
    {
        /// <summary>
        /// Stat type
        /// </summary>
        [JsonProperty("stat_type")]
        public override string StatType { get; set; }

        /// <summary>
        /// Stat points to invest
        /// </summary>
        [JsonProperty("stat_point")]
        public override long? StatPoint { get; set; }

        /// <summary>
        /// Stat level
        /// </summary>
        [JsonProperty("stat_level")]
        public override long StatLevel { get; set; }

        /// <summary>
        /// Stat increases
        /// </summary>
        [JsonProperty("stat_increase")]
        public override string? StatIncrease { get; set; }
    }
}
