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
        public string? CharacterClass { get; set; }

        /// <summary>
        /// 스킬 전직 차수
        /// </summary>
        [JsonProperty("character_skill_grade")]
        public string? CharacterSkillGrade { get; set; }

        /// <summary>
        /// 스킬 정보 리스트
        /// </summary>
        [JsonProperty("character_skill")]
        public List<CharacterLinkSkillInfoDTO> CharacterSkill { get; set; }
    }

    /// <summary>
    /// 캐릭터 스킬 상세 정보
    /// </summary>
    public class CharacterSkillInfoDTO
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
        public long? SkillLevel { get; set; }

        /// <summary>
        /// 스킬 레벨 별 효과 설명
        /// </summary>
        [JsonProperty("skill_effect")]
        public string SkillEffect { get; set; }

        /// <summary>
        /// 다음 스킬 레벨 효과 설명
        /// </summary>
        [JsonProperty("skill_effect_next")]
        public string? SkillEffectNext { get; set; }

        /// <summary>
        /// 스킬 아이콘
        /// </summary>
        [JsonProperty("skill_icon")]
        public string SkillIcon { get; set; }
    }
}
