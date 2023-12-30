using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 링크 스킬 정보
    /// </summary>
    public class CharacterLinkSkillInfoDTO
    {
        /// <summary>
        /// 스킬 명
        /// </summary>
        [JsonProperty("skill_name")]
        public string SkillName { get; set; }

        /// <summary>
        /// 스킬 설명
        /// </summary>
        [JsonProperty("skill_description")]
        public string SkillDescription { get; set; }

        /// <summary>
        /// 스킬 레벨
        /// </summary>
        [JsonProperty("skill_level")]
        public long SkillLevel { get; set; }

        /// <summary>
        /// 스킬 효과
        /// </summary>
        [JsonProperty("skill_effect")]
        public string SkillEffect { get; set; }

        /// <summary>
        /// 스킬 아이콘
        /// </summary>
        [JsonProperty("skill_icon")]
        public string SkillIcon { get; set; }
    }
}
