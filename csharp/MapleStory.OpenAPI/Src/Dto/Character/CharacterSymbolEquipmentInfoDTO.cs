using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 심볼 상세 정보
    /// </summary>
    public class CharacterSymbolEquipmentInfoDTO
    {
        /// <summary>
        /// 심볼 명
        /// </summary>
        [JsonProperty("symbol_name")]
        public string SymbolName { get; set; }

        /// <summary>
        /// 심볼 아이콘
        /// </summary>
        [JsonProperty("symbol_icon")]
        public string SymbolIcon { get; set; }

        /// <summary>
        /// 심볼 설명
        /// </summary>
        [JsonProperty("symbol_description")]
        public string SymbolDescription { get; set; }

        /// <summary>
        /// 심볼로 인한 증가 수치
        /// </summary>
        [JsonProperty("symbol_force")]
        public string SymbolForce { get; set; }

        /// <summary>
        /// 심볼 레벨
        /// </summary>
        [JsonProperty("symbol_level")]
        public long SymbolLevel { get; set; }

        /// <summary>
        /// 심볼로 증가한 힘
        /// </summary>
        [JsonProperty("symbol_str")]
        public string SymbolStr { get; set; }

        /// <summary>
        /// 심볼로 증가한 민첩
        /// </summary>
        [JsonProperty("symbol_dex")]
        public string SymbolDex { get; set; }

        /// <summary>
        /// 심볼로 증가한 지력
        /// </summary>
        [JsonProperty("symbol_int")]
        public string SymbolInt { get; set; }

        /// <summary>
        /// 심볼로 증가한 운
        /// </summary>
        [JsonProperty("symbol_luk")]
        public string SymbolLuk { get; set; }

        /// <summary>
        /// 심볼로 증가한 체력
        /// </summary>
        [JsonProperty("symbol_hp")]
        public string SymbolHp { get; set; }

        /// <summary>
        /// 심볼로 증가한 아이템 드롭률
        /// </summary>
        public string SymbolDropRate
        {
            get
            {
                return _symbolDropRate == null ? "0%" : _symbolDropRate;
            }
        }

        [JsonProperty("symbol_drop_rate")]
        private string _symbolDropRate { get; set; }

        /// <summary>
        /// 심볼로 증가한 체력
        /// </summary>
        public string SymbolMesoRate
        {
            get
            {
                return _symbolMesoRate == null ? "0%" : _symbolMesoRate;
            }
        }

        [JsonProperty("symbol_meso_rate")]
        private string _symbolMesoRate { get; set; }

        /// <summary>
        /// 심볼로 증가한 체력
        /// </summary>
        public string SymbolExpRate
        {
            get
            {
                return _symbolExpRate == null ? "0%" : _symbolExpRate;
            }
        }

        [JsonProperty("symbol_exp_rate")]
        private string _symbolExpRate { get; set; }

        /// <summary>
        /// 현재 보유 성장치
        /// </summary>
        [JsonProperty("symbol_growth_count")]
        public long SymbolGrowthCount { get; set; }

        /// <summary>
        /// 성장 시 필요한 성장치
        /// </summary>
        [JsonProperty("symbol_require_growth_count")]
        public long SymbolRequireGrowthCount { get; set; }
    }
}
