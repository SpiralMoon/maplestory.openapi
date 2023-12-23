using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 펫 장비 자동 스킬 정보
    /// </summary>
    public class CharacterPetEquipmentAutoSkillDTO
    {
        /// <summary>
        /// 스킬 1
        /// </summary>
        [JsonProperty("skill_1")]
        public string Skill1 { get; set; }

        /// <summary>
        /// 스킬 1 아이콘
        /// </summary>
        [JsonProperty("skill_1_icon")]
        public string Skill1Icon { get; set; }

        /// <summary>
        /// 스킬 2
        /// </summary>
        [JsonProperty("skill_2")]
        public string Skill2 { get; set; }

        /// <summary>
        /// 스킬 2 아이콘
        /// </summary>
        [JsonProperty("skill_2_icon")]
        public string Skill2Icon { get; set; }
    }
}
