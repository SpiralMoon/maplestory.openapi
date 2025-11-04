using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.TMS.DTO
{
    /// <summary>
    /// 角色已裝備符文資訊
    /// </summary>
    public class CharacterSymbolEquipmentDTO : Base.CharacterSymbolEquipmentDTO<CharacterSymbolEquipmentInfoDTO>
    {
        /// <summary>
        /// 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
        /// </summary>
        [JsonProperty("date")]
        public override DateTimeOffset? Date
        {
            get => _date?.ToOffset(TimeSpan.FromHours(8));
            set => _date = value;
        }

        private DateTimeOffset? _date;

        /// <summary>
        /// 角色職業
        /// </summary>
        [JsonProperty("character_class")]
        public override string CharacterClass { get; set; }

        /// <summary>
        /// 符文資訊
        /// </summary>
        [JsonProperty("symbol")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterSymbolEquipmentInfoDTO> Symbol { get; set; } = new();
    }

    /// <summary>
    /// 符文資訊
    /// </summary>
    public class CharacterSymbolEquipmentInfoDTO : Base.CharacterSymbolEquipmentInfoDTO
    {
        /// <summary>
        /// 符文名稱
        /// </summary>
        [JsonProperty("symbol_name")]
        public override string SymbolName { get; set; }

        /// <summary>
        /// 符文圖示
        /// </summary>
        [JsonProperty("symbol_icon")]
        public override string SymbolIcon { get; set; }

        /// <summary>
        /// 符文描述
        /// </summary>
        [JsonProperty("symbol_description")]
        public override string SymbolDescription { get; set; }

        /// <summary>
        /// 因符文增加的數值
        /// </summary>
        [JsonProperty("symbol_force")]
        public override string SymbolForce { get; set; }

        /// <summary>
        /// 符文等級
        /// </summary>
        [JsonProperty("symbol_level")]
        public override long SymbolLevel { get; set; }

        /// <summary>
        /// 符文增加的力量 (STR)
        /// </summary>
        [JsonProperty("symbol_str")]
        public override string SymbolStr { get; set; }

        /// <summary>
        /// 符文增加的敏捷 (DEX)
        /// </summary>
        [JsonProperty("symbol_dex")]
        public override string SymbolDex { get; set; }

        /// <summary>
        /// 符文增加的智力 (INT)
        /// </summary>
        [JsonProperty("symbol_int")]
        public override string SymbolInt { get; set; }

        /// <summary>
        /// 符文增加的幸運 (LUK)
        /// </summary>
        [JsonProperty("symbol_luk")]
        public override string SymbolLuk { get; set; }

        /// <summary>
        /// 符文增加的體力 (HP)
        /// </summary>
        [JsonProperty("symbol_hp")]
        public override string SymbolHp { get; set; }

        /// <summary>
        /// 符文增加的道具掉落率
        /// </summary>
        public override string SymbolDropRate => _symbolDropRate ?? "0%";

        [JsonProperty("symbol_drop_rate")]
        private string? _symbolDropRate { get; set; }

        /// <summary>
        /// 符文增加的楓幣掉落率
        /// </summary>
        public override string SymbolMesoRate => _symbolMesoRate ?? "0%";

        [JsonProperty("symbol_meso_rate")]
        private string? _symbolMesoRate { get; set; }

        /// <summary>
        /// 符文增加的經驗值獲得量
        /// </summary>
        public override string SymbolExpRate => _symbolExpRate ?? "0%";

        [JsonProperty("symbol_exp_rate")]
        private string? _symbolExpRate { get; set; }

        /// <summary>
        /// 現有成長值
        /// </summary>
        [JsonProperty("symbol_growth_count")]
        public override long SymbolGrowthCount { get; set; }

        /// <summary>
        /// 成長所需的成長值
        /// </summary>
        [JsonProperty("symbol_require_growth_count")]
        public override long SymbolRequireGrowthCount { get; set; }
    }
}
