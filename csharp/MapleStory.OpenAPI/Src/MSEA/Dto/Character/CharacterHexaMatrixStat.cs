using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.MSEA.DTO
{
    /// <summary>
    /// Character HEXA Matrix configured HEXA stats information
    /// </summary>
    public class CharacterHexaMatrixStatDTO : Base.CharacterHexaMatrixStatDTO<CharacterHexaMatrixStatCoreDTO>
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
        /// Information for HEXA Stat Node I
        /// </summary>
        [JsonProperty("character_hexa_stat_core")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterHexaMatrixStatCoreDTO> CharacterHexaStatCore { get; set; } = new();

        /// <summary>
        /// Information for HEXA Stat Node II
        /// </summary>
        [JsonProperty("character_hexa_stat_core_2")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterHexaMatrixStatCoreDTO> CharacterHexaStatCore2 { get; set; } = new();

        /// <summary>
        /// Information for HEXA Stat Node III
        /// </summary>
        [JsonProperty("character_hexa_stat_core_3")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterHexaMatrixStatCoreDTO> CharacterHexaStatCore3 { get; set; } = new();

        /// <summary>
        /// Preset HEXA Stat Node I information
        /// </summary>
        [JsonProperty("preset_hexa_stat_core")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterHexaMatrixStatCoreDTO> PresetHexaStatCore { get; set; } = new();

        /// <summary>
        /// Preset HEXA Stat Node II information
        /// </summary>
        [JsonProperty("preset_hexa_stat_core_2")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterHexaMatrixStatCoreDTO> PresetHexaStatCore2 { get; set; } = new();

        /// <summary>
        /// Preset HEXA Stat Node III information
        /// </summary>
        [JsonProperty("preset_hexa_stat_core_3")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterHexaMatrixStatCoreDTO> PresetHexaStatCore3 { get; set; } = new();
    }

    /// <summary>
    /// Information for HEXA Stat Node
    /// </summary>
    public class CharacterHexaMatrixStatCoreDTO : Base.CharacterHexaMatrixStatCoreDTO
    {
        /// <summary>
        /// Slot index
        /// </summary>
        [JsonProperty("slot_id")]
        public override string SlotId { get; set; }

        /// <summary>
        /// Main Stat name
        /// </summary>
        [JsonProperty("main_stat_name")]
        public override string MainStatName { get; set; }

        /// <summary>
        /// First sub stat name
        /// </summary>
        [JsonProperty("sub_stat_name_1")]
        public override string SubStatName1 { get; set; }

        /// <summary>
        /// Second sub stat name
        /// </summary>
        [JsonProperty("sub_stat_name_2")]
        public override string SubStatName2 { get; set; }

        /// <summary>
        /// Main Stat level
        /// </summary>
        [JsonProperty("main_stat_level")]
        public override long MainStatLevel { get; set; }

        /// <summary>
        /// First sub stat level
        /// </summary>
        [JsonProperty("sub_stat_level_1")]
        public override long SubStatLevel1 { get; set; }

        /// <summary>
        /// Second sub stat level
        /// </summary>
        [JsonProperty("sub_stat_level_2")]
        public override long SubStatLevel2 { get; set; }

        /// <summary>
        /// Stat core level
        /// </summary>
        [JsonProperty("stat_grade")]
        public override long StatGrade { get; set; }
    }
}
