using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.TMS.DTO
{
    /// <summary>
    /// 角色技能與超技能資訊
    /// </summary>
    public class CharacterSkillDTO : Base.CharacterSkillDTO<CharacterSkillInfoDTO>
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
        /// 技能轉職次數
        /// </summary>
        [JsonProperty("character_skill_grade")]
        public override string? CharacterSkillGrade { get; set; }

        /// <summary>
        /// 技能資訊
        /// </summary>
        [JsonProperty("character_skill")]
        public override List<CharacterSkillInfoDTO> CharacterSkill { get; set; }
    }

    /// <summary>
    /// 技能資訊
    /// </summary>
    public class CharacterSkillInfoDTO : Base.CharacterSkillInfoDTO
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
        public override long? SkillLevel { get; set; }

        /// <summary>
        /// 技能等級的效果描述
        /// </summary>
        [JsonProperty("skill_effect")]
        public override string? SkillEffect { get; set; }

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
