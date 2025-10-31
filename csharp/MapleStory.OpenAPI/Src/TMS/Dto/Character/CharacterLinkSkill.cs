using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.TMS.DTO
{
    /// <summary>
    /// 角色已裝備連結技能資訊
    /// </summary>
    public class CharacterLinkSkillDTO : Base.CharacterLinkSkillDTO<CharacterLinkSkillInfoDTO>
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
        /// 連結技能資訊
        /// </summary>
        [JsonProperty("character_link_skill")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterLinkSkillInfoDTO> CharacterLinkSkill { get; set; } = new();

        /// <summary>
        /// 連結技能 1 預設資訊
        /// </summary>
        [JsonProperty("character_link_skill_preset_1")]
        public override List<CharacterLinkSkillInfoDTO> CharacterLinkSkillPreset1 { get; set; }

        /// <summary>
        /// 連結技能 2 預設資訊
        /// </summary>
        [JsonProperty("character_link_skill_preset_2")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterLinkSkillInfoDTO> CharacterLinkSkillPreset2 { get; set; } = new();

        /// <summary>
        /// 連結技能 3 預設資訊
        /// </summary>
        [JsonProperty("character_link_skill_preset_3")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterLinkSkillInfoDTO> CharacterLinkSkillPreset3 { get; set; } = new();

        /// <summary>
        /// 我的連結技能資訊
        /// </summary>
        [JsonProperty("character_owned_link_skill")]
        public override CharacterLinkSkillInfoDTO? CharacterOwnedLinkSkill { get; set; }

        /// <summary>
        /// 我的連結技能 1 預設資訊
        /// </summary>
        [JsonProperty("character_owned_link_skill_preset_1")]
        public override CharacterLinkSkillInfoDTO? CharacterOwnedLinkSkillPreset1 { get; set; }

        /// <summary>
        /// 我的連結技能 2 預設資訊
        /// </summary>
        [JsonProperty("character_owned_link_skill_preset_2")]
        public override CharacterLinkSkillInfoDTO? CharacterOwnedLinkSkillPreset2 { get; set; }

        /// <summary>
        /// 我的連結技能 3 預設資訊
        /// </summary>
        [JsonProperty("character_owned_link_skill_preset_3")]
        public override CharacterLinkSkillInfoDTO? CharacterOwnedLinkSkillPreset3 { get; set; }
    }

    /// <summary>
    /// 角色連結技能資訊
    /// </summary>
    public class CharacterLinkSkillInfoDTO : Base.CharacterLinkSkillInfoDTO
    {
        /// <summary>
        /// 技能名稱
        /// </summary>
        [JsonProperty("skill_name")]
        public override string SkillName { get; set; }

        /// <summary>
        /// 技能描述
        /// </summary>
        [JsonProperty("skill_description")]
        public override string SkillDescription { get; set; }

        /// <summary>
        /// 技能等級
        /// </summary>
        [JsonProperty("skill_level")]
        public override long SkillLevel { get; set; }

        /// <summary>
        /// 技能效果
        /// </summary>
        [JsonProperty("skill_effect")]
        public override string SkillEffect { get; set; }

        /// <summary>
        /// 下一等級的技能效果
        /// </summary>
        [JsonProperty("skill_effect_next")]
        public override string? SkillEffectNext { get; set; }

        /// <summary>
        /// 技能圖示
        /// </summary>
        [JsonProperty("skill_icon")]
        public override string SkillIcon { get; set; }
    }
}
