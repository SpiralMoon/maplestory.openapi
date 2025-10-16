using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.TMS.DTO
{
    /// <summary>
    /// 角色能力資訊
    /// </summary>
    public class CharacterAbilityDTO : Base.CharacterAbilityDTO<CharacterAbilityInfoDTO, CharacterAbilityPresetDTO>
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
        /// 能力階級
        /// </summary>
        [JsonProperty("ability_grade")]
        public override string? AbilityGrade { get; set; }

        /// <summary>
        /// 能力資訊
        /// </summary>
        [JsonProperty("ability_info")]
        public override List<CharacterAbilityInfoDTO> AbilityInfo { get; set; }

        /// <summary>
        /// 名聲值
        /// </summary>
        [JsonProperty("remain_fame")]
        public override long? RemainFame { get; set; }

        /// <summary>
        /// 目前套用的能力預設編號
        /// </summary>
        [JsonProperty("preset_no")]
        public override int? PresetNo { get; set; }

        /// <summary>
        /// 能力 1 預設完整資訊
        /// </summary>
        [JsonProperty("ability_preset_1")]
        public override CharacterAbilityPresetDTO? AbilityPreset1 { get; set; }

        /// <summary>
        /// 能力 2 預設完整資訊
        /// </summary>
        [JsonProperty("ability_preset_2")]
        public override CharacterAbilityPresetDTO? AbilityPreset2 { get; set; }

        /// <summary>
        /// 能力 3 預設完整資訊
        /// </summary>
        [JsonProperty("ability_preset_3")]
        public override CharacterAbilityPresetDTO? AbilityPreset3 { get; set; }
    }

    /// <summary>
    /// 能力資訊
    /// </summary>
    public class CharacterAbilityInfoDTO : Base.CharacterAbilityInfoDTO
    {
        /// <summary>
        /// 能力編號
        /// </summary>
        [JsonProperty("ability_no")]
        public override string AbilityNo { get; set; }

        /// <summary>
        /// 能力階級
        /// </summary>
        [JsonProperty("ability_grade")]
        public override string AbilityGrade { get; set; }

        /// <summary>
        /// 能力選項與數值
        /// </summary>
        [JsonProperty("ability_value")]
        public override string AbilityValue { get; set; }
    }

    /// <summary>
    /// 能力預設完整資訊
    /// </summary>
    public class CharacterAbilityPresetDTO : Base.CharacterAbilityPresetDTO<CharacterAbilityInfoDTO>
    {
        /// <summary>
        /// 能力預設能力階級
        /// </summary>
        [JsonProperty("ability_preset_grade")]
        public override string AbilityPresetGrade { get; set; }

        /// <summary>
        /// 能力預設資訊
        /// </summary>
        [JsonProperty("ability_info")]
        public override List<CharacterAbilityInfoDTO> AbilityInfo { get; set; }
    }
}
