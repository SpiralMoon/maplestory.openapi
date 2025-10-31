using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.MSEA.DTO
{
    /// <summary>
    /// Character equipped symbol information
    /// </summary>
    public class CharacterSymbolEquipmentDTO : Base.CharacterSymbolEquipmentDTO<CharacterSymbolEquipmentInfoDTO>
    {
        /// <summary>
        /// Reference date for query (SGT, daily data with hours and minutes set to 0)
        /// </summary>
        [JsonProperty("date")]
        public override DateTimeOffset? Date
        {
            get => _date?.ToOffset(TimeSpan.FromHours(8));
            set => _date = value;
        }

        private DateTimeOffset? _date;

        /// <summary>
        /// Character job
        /// </summary>
        [JsonProperty("character_class")]
        public override string? CharacterClass { get; set; }

        /// <summary>
        /// Symbol information
        /// </summary>
        [JsonProperty("symbol")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterSymbolEquipmentInfoDTO> Symbol { get; set; } = new();
    }

    /// <summary>
    /// Symbol information
    /// </summary>
    public class CharacterSymbolEquipmentInfoDTO : Base.CharacterSymbolEquipmentInfoDTO
    {
        /// <summary>
        /// Symbol name
        /// </summary>
        [JsonProperty("symbol_name")]
        public override string SymbolName { get; set; }

        /// <summary>
        /// Symbol icon
        /// </summary>
        [JsonProperty("symbol_icon")]
        public override string SymbolIcon { get; set; }

        /// <summary>
        /// Symbol description
        /// </summary>
        [JsonProperty("symbol_description")]
        public override string SymbolDescription { get; set; }

        /// <summary>
        /// Increase in stats due to the symbol
        /// </summary>
        [JsonProperty("symbol_force")]
        public override string SymbolForce { get; set; }

        /// <summary>
        /// Symbol level
        /// </summary>
        [JsonProperty("symbol_level")]
        public override long SymbolLevel { get; set; }

        /// <summary>
        /// Increase in Strength due to the symbol
        /// </summary>
        [JsonProperty("symbol_str")]
        public override string SymbolStr { get; set; }

        /// <summary>
        /// Increase in Dexterity due to the symbol
        /// </summary>
        [JsonProperty("symbol_dex")]
        public override string SymbolDex { get; set; }

        /// <summary>
        /// Increase in Intelligence due to the symbol
        /// </summary>
        [JsonProperty("symbol_int")]
        public override string SymbolInt { get; set; }

        /// <summary>
        /// Increase in Luck due to the symbol
        /// </summary>
        [JsonProperty("symbol_luk")]
        public override string SymbolLuk { get; set; }

        /// <summary>
        /// Increase in HP due to the symbol
        /// </summary>
        [JsonProperty("symbol_hp")]
        public override string SymbolHp { get; set; }

        /// <summary>
        /// Increase in item drop rate due to the symbol
        /// </summary>
        public override string SymbolDropRate => _symbolDropRate ?? "0%";

        [JsonProperty("symbol_drop_rate")]
        private string? _symbolDropRate { get; set; }

        /// <summary>
        /// Increase in Meso acquisition rate due to the symbol
        /// </summary>
        public override string SymbolMesoRate => _symbolMesoRate ?? "0%";

        [JsonProperty("symbol_meso_rate")]
        private string? _symbolMesoRate { get; set; }

        /// <summary>
        /// Increase in EXP acquisition rate due to the symbol
        /// </summary>
        public override string SymbolExpRate => _symbolExpRate ?? "0%";

        [JsonProperty("symbol_exp_rate")]
        private string? _symbolExpRate { get; set; }

        /// <summary>
        /// Current growth points
        /// </summary>
        [JsonProperty("symbol_growth_count")]
        public override long SymbolGrowthCount { get; set; }

        /// <summary>
        /// Growth points required for the next level
        /// </summary>
        [JsonProperty("symbol_require_growth_count")]
        public override long SymbolRequireGrowthCount { get; set; }
    }
}
