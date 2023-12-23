using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 펫 장비 자동 스킬 정보
    /// </summary>
    public class CharacterPetEquipmentAutoSkillDTO
    {
        /// <summary>
        /// 첫 번째 슬롯에 등록된 자동 스킬
        /// </summary>
        [JsonProperty("skill_1")]
        public string Skill1 { get; set; }

        /// <summary>
        /// 첫 번째 슬롯에 등록된 자동 스킬 아이콘
        /// </summary>
        [JsonProperty("skill_1_icon")]
        public string Skill1Icon { get; set; }

        /// <summary>
        /// 두 번째 슬롯에 등록된 자동 스킬
        /// </summary>
        [JsonProperty("skill_2")]
        public string Skill2 { get; set; }

        /// <summary>
        /// 두 번째 슬롯에 등록된 자동 스킬 아이콘
        /// </summary>
        [JsonProperty("skill_2_icon")]
        public string Skill2Icon { get; set; }
    }
}
