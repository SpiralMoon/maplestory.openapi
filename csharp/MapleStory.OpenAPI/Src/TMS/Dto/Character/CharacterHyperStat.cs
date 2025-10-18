using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.TMS.DTO
{
    /// <summary>
    /// 角色極限屬性資訊
    /// </summary>
    public class CharacterHyperStatDTO : Base.CharacterHyperStatDTO<CharacterHyperStatPresetDTO>
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
        public override string? CharacterClass { get; set; }

        /// <summary>
        /// 目前套用的預設編號
        /// </summary>
        [JsonProperty("use_preset_no")]
        public override string? UsePresetNo { get; set; }

        /// <summary>
        /// 可用的極限屬性點數上限
        /// </summary>
        [JsonProperty("use_available_hyper_stat")]
        public override int? UseAvailableHyperStat { get; set; }

        /// <summary>
        /// 預設 1 的極限屬性資訊
        /// </summary>
        [JsonProperty("hyper_stat_preset_1")]
        public override List<CharacterHyperStatPresetDTO> HyperStatPreset1 { get; set; }

        /// <summary>
        /// 預設 1 剩餘的極限屬性點數
        /// </summary>
        [JsonProperty("hyper_stat_preset_1_remain_point")]
        public override int? HyperStatPreset1RemainPoint { get; set; }

        /// <summary>
        /// 預設 2 的極限屬性資訊
        /// </summary>
        [JsonProperty("hyper_stat_preset_2")]
        public override List<CharacterHyperStatPresetDTO> HyperStatPreset2 { get; set; }

        /// <summary>
        /// 預設 2 剩餘的極限屬性點數
        /// </summary>
        [JsonProperty("hyper_stat_preset_2_remain_point")]
        public override int? HyperStatPreset2RemainPoint { get; set; }

        /// <summary>
        /// 預設 3 的極限屬性資訊
        /// </summary>
        [JsonProperty("hyper_stat_preset_3")]
        public override List<CharacterHyperStatPresetDTO> HyperStatPreset3 { get; set; }

        /// <summary>
        /// 預設 3 剩餘的極限屬性點數
        /// </summary>
        [JsonProperty("hyper_stat_preset_3_remain_point")]
        public override int? HyperStatPreset3RemainPoint { get; set; }
    }

    /// <summary>
    /// 預設的極限屬性資訊
    /// </summary>
    public class CharacterHyperStatPresetDTO : Base.CharacterHyperStatPresetDTO
    {
        /// <summary>
        /// 能力值類型
        /// </summary>
        [JsonProperty("stat_type")]
        public override string StatType { get; set; }

        /// <summary>
        /// 投入於能力值的點數
        /// </summary>
        [JsonProperty("stat_point")]
        public override long? StatPoint { get; set; }

        /// <summary>
        /// 能力值等級
        /// </summary>
        [JsonProperty("stat_level")]
        public override long StatLevel { get; set; }

        /// <summary>
        /// 能力值提升量
        /// </summary>
        [JsonProperty("stat_increase")]
        public override string? StatIncrease { get; set; }
    }
}
