using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.MSEA.DTO
{
    /// <summary>
    /// Character skill information
    /// </summary>
    public class CharacterSkillDTO : Base.CharacterSkillDTO<CharacterSkillInfoDTO>
    {
        /// <summary>
        /// Reference date for query (SGT, daily data with hours and minutes set to 0)
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
        /// Character job
        /// </summary>
        [JsonProperty("character_class")]
        public override string? CharacterClass { get; set; }

        /// <summary>
        /// Job advancement tier required to acquire the skill
        /// </summary>
        [JsonProperty("character_skill_grade")]
        public override string? CharacterSkillGrade { get; set; }

        /// <summary>
        /// Skill information
        /// </summary>
        [JsonProperty("character_skill")]
        public override List<CharacterSkillInfoDTO> CharacterSkill { get; set; }
    }

    /// <summary>
    /// Skill information
    /// </summary>
    public class CharacterSkillInfoDTO : Base.CharacterSkillInfoDTO
    {
        /// <summary>
        /// Skill name
        /// </summary>
        [JsonProperty("skill_name")]
        public override string SkillName { get; set; }

        /// <summary>
        /// Skill description
        /// </summary>
        [JsonProperty("skill_description")]
        public override string SkillDescription { get; set; }

        /// <summary>
        /// Skill level
        /// </summary>
        [JsonProperty("skill_level")]
        public override long? SkillLevel { get; set; }

        /// <summary>
        /// Effect description by skill level
        /// </summary>
        [JsonProperty("skill_effect")]
        public override string SkillEffect { get; set; }

        /// <summary>
        /// Effect description for the next skill level
        /// </summary>
        [JsonProperty("skill_effect_next")]
        public override string? SkillEffectNext { get; set; }

        /// <summary>
        /// Skill icon
        /// </summary>
        [JsonProperty("skill_icon")]
        public override string SkillIcon { get; set; }
    }
}
