using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 링크 스킬 정보
    /// </summary>
    public class CharacterLinkSkillDTO
    {
        /// <summary>
        /// 조회 기준일 (KST)
        /// </summary>
        [JsonProperty("date")]
        public DateTimeOffset Date
        {
            get
            {
                return _date.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _date = value;
            }
        }

        private DateTimeOffset _date;

        /// <summary>
        /// 캐릭터 직업
        /// </summary>
        [JsonProperty("character_class")]
        public string CharacterClass { get; set; }

        /// <summary>
        /// 링크 스킬 정보
        /// </summary>
        [JsonProperty("character_link_skill")]
        public CharacterLinkSkillInfoDTO CharacterLinkSkill { get; set; }

        /// <summary>
        /// 내 링크 스킬 정보
        /// </summary>
        [JsonProperty("character_owned_link_skill")]
        public CharacterLinkSkillInfoDTO CharacterOwnedLinkSkill { get; set; }
    }
}
