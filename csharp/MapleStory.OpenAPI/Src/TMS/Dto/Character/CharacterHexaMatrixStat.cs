using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.TMS.DTO
{
    /// <summary>
    /// 角色設定於 HEXA 矩陣中的 HEXA 屬性資訊
    /// </summary>
    public class CharacterHexaMatrixStatDTO : Base.CharacterHexaMatrixStatDTO<CharacterHexaMatrixStatCoreDTO>
    {
        /// <summary>
        /// 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
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
        /// 角色職業
        /// </summary>
        [JsonProperty("character_class")]
        public override string CharacterClass { get; set; }

        /// <summary>
        /// HEXA 屬性 I 核心資訊
        /// </summary>
        [JsonProperty("character_hexa_stat_core")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterHexaMatrixStatCoreDTO> CharacterHexaStatCore { get; set; } = new();

        /// <summary>
        /// HEXA 屬性 II 核心資訊
        /// </summary>
        [JsonProperty("character_hexa_stat_core_2")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterHexaMatrixStatCoreDTO> CharacterHexaStatCore2 { get; set; } = new();

        /// <summary>
        /// HEXA 屬性 III 核心資訊
        /// </summary>
        [JsonProperty("character_hexa_stat_core_3")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterHexaMatrixStatCoreDTO> CharacterHexaStatCore3 { get; set; } = new();

        /// <summary>
        /// 預設的 HEXA 屬性 I 核心資訊
        /// </summary>
        [JsonProperty("preset_hexa_stat_core")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterHexaMatrixStatCoreDTO> PresetHexaStatCore { get; set; } = new();

        /// <summary>
        /// 預設的 HEXA 屬性 II 核心資訊
        /// </summary>
        [JsonProperty("preset_hexa_stat_core_2")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterHexaMatrixStatCoreDTO> PresetHexaStatCore2 { get; set; } = new();

        /// <summary>
        /// 預設的 HEXA 屬性 III 核心資訊
        /// </summary>
        [JsonProperty("preset_hexa_stat_core_3")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterHexaMatrixStatCoreDTO> PresetHexaStatCore3 { get; set; } = new();
    }

    /// <summary>
    /// HEXA 屬性核心資訊
    /// </summary>
    public class CharacterHexaMatrixStatCoreDTO : Base.CharacterHexaMatrixStatCoreDTO
    {
        /// <summary>
        /// 欄位索引
        /// </summary>
        [JsonProperty("slot_id")]
        public override string SlotId { get; set; }

        /// <summary>
        /// 主要屬性名稱
        /// </summary>
        [JsonProperty("main_stat_name")]
        public override string MainStatName { get; set; }

        /// <summary>
        /// 第一副屬性名稱
        /// </summary>
        [JsonProperty("sub_stat_name_1")]
        public override string SubStatName1 { get; set; }

        /// <summary>
        /// 第二副屬性名稱
        /// </summary>
        [JsonProperty("sub_stat_name_2")]
        public override string SubStatName2 { get; set; }

        /// <summary>
        /// 主要屬性等級
        /// </summary>
        [JsonProperty("main_stat_level")]
        public override long MainStatLevel { get; set; }

        /// <summary>
        /// 第一副屬性等級
        /// </summary>
        [JsonProperty("sub_stat_level_1")]
        public override long SubStatLevel1 { get; set; }

        /// <summary>
        /// 第二副屬性等級
        /// </summary>
        [JsonProperty("sub_stat_level_2")]
        public override long SubStatLevel2 { get; set; }

        /// <summary>
        /// 屬性核心階級
        /// </summary>
        [JsonProperty("stat_grade")]
        public override long StatGrade { get; set; }
    }
}
