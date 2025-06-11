using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 캐릭터 스킬 정보
    /// </summary>
    public class CharacterSkillDTO : Base.CharacterSkillDTO<CharacterSkillInfoDTO>
    {
        /// <summary>
        /// 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        /// </summary>
        [JsonProperty("date")]
        public override DateTimeOffset? Date
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
        public override string? CharacterClass { get; set; }

        /// <summary>
        /// 스킬 전직 차수
        /// </summary>
        [JsonProperty("character_skill_grade")]
        public override string? CharacterSkillGrade { get; set; }

        /// <summary>
        /// 스킬 정보 리스트
        /// </summary>
        [JsonProperty("character_skill")]
        public override List<CharacterSkillInfoDTO> CharacterSkill { get; set; }
    }

    /// <summary>
    /// 캐릭터 스킬 상세 정보
    /// </summary>
    public class CharacterSkillInfoDTO : Base.CharacterSkillInfoDTO
    {
        /// <summary>
        /// 스킬 명
        /// </summary>
        [JsonProperty("skill_name")]
        public override string SkillName { get; set; }

        /// <summary>
        /// 스킬 설명
        /// </summary>
        [JsonProperty("skill_description")]
        public override string SkillDescription { get; set; }

        /// <summary>
        /// 스킬 레벨
        /// </summary>
        [JsonProperty("skill_level")]
        public override long? SkillLevel { get; set; }

        /// <summary>
        /// 스킬 레벨 별 효과 설명
        /// </summary>
        [JsonProperty("skill_effect")]
        public override string SkillEffect { get; set; }

        /// <summary>
        /// 다음 스킬 레벨 효과 설명
        /// </summary>
        [JsonProperty("skill_effect_next")]
        public override string? SkillEffectNext { get; set; }

        /// <summary>
        /// 스킬 아이콘
        /// </summary>
        [JsonProperty("skill_icon")]
        public override string SkillIcon { get; set; }
    }
}
