using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 스킬 정보
    /// </summary>
    public class CharacterSkillDTO
    {
        /// <summary>
        /// 조회 기준일 (KST)
        /// </summary>
        [JsonProperty("date")]
        public DateTimeOffset? Date
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
        public string CharacterClass { get; set; }

        /// <summary>
        /// 스킬 전직 차수
        /// </summary>
        [JsonProperty("character_skill_grade")]
        public string CharacterSkillGrade { get; set; }

        /// <summary>
        /// 스킬 정보 리스트
        /// </summary>
        [JsonProperty("character_skill")]
        public List<CharacterLinkSkillInfoDTO> CharacterSkill { get; set; }
    }
}
