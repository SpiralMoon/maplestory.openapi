using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 캐릭터 심볼 정보
    /// </summary>
    public class CharacterSymbolEquipmentDTO : Base.CharacterSymbolEquipmentDTO<CharacterSymbolEquipmentInfoDTO>
    {
        /// <summary>
        /// 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        /// </summary>
        [JsonProperty("date")]
        public override DateTimeOffset? Date
        {
            get
            {
                return _date?.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _date = value;
            }
        }

        private DateTimeOffset? _date;

        /// <summary>
        /// 캐릭터 직업
        /// </summary>
        [JsonProperty("character_class")]
        public override string CharacterClass { get; set; }

        /// <summary>
        /// 심볼 정보 목록
        /// </summary>
        [JsonProperty("symbol")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterSymbolEquipmentInfoDTO> Symbol { get; set; } = new();
    }

    /// <summary>
    /// 캐릭터 심볼 상세 정보
    /// </summary>
    public class CharacterSymbolEquipmentInfoDTO : Base.CharacterSymbolEquipmentInfoDTO
    {
        /// <summary>
        /// 심볼 명
        /// </summary>
        [JsonProperty("symbol_name")]
        public override string SymbolName { get; set; }

        /// <summary>
        /// 심볼 아이콘
        /// </summary>
        [JsonProperty("symbol_icon")]
        public override string SymbolIcon { get; set; }

        /// <summary>
        /// 심볼 설명
        /// </summary>
        [JsonProperty("symbol_description")]
        public override string SymbolDescription { get; set; }

        /// <summary>
        /// 심볼로 인한 증가 수치
        /// </summary>
        [JsonProperty("symbol_force")]
        public override string SymbolForce { get; set; }

        /// <summary>
        /// 심볼 레벨
        /// </summary>
        [JsonProperty("symbol_level")]
        public override long SymbolLevel { get; set; }

        /// <summary>
        /// 심볼로 증가한 힘
        /// </summary>
        [JsonProperty("symbol_str")]
        public override string SymbolStr { get; set; }

        /// <summary>
        /// 심볼로 증가한 민첩
        /// </summary>
        [JsonProperty("symbol_dex")]
        public override string SymbolDex { get; set; }

        /// <summary>
        /// 심볼로 증가한 지력
        /// </summary>
        [JsonProperty("symbol_int")]
        public override string SymbolInt { get; set; }

        /// <summary>
        /// 심볼로 증가한 운
        /// </summary>
        [JsonProperty("symbol_luk")]
        public override string SymbolLuk { get; set; }

        /// <summary>
        /// 심볼로 증가한 체력
        /// </summary>
        [JsonProperty("symbol_hp")]
        public override string SymbolHp { get; set; }

        /// <summary>
        /// 심볼로 증가한 아이템 드롭률
        /// </summary>
        public override string SymbolDropRate
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
        public override string SymbolMesoRate
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
        public override string SymbolExpRate
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
        public override long SymbolGrowthCount { get; set; }

        /// <summary>
        /// 성장 시 필요한 성장치
        /// </summary>
        [JsonProperty("symbol_require_growth_count")]
        public override long SymbolRequireGrowthCount { get; set; }
    }
}
