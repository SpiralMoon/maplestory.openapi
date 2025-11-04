using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.MSEA.DTO
{
    /// <summary>
    /// Character equipped link skill information
    /// </summary>
    public class CharacterLinkSkillDTO : Base.CharacterLinkSkillDTO<CharacterLinkSkillInfoDTO>
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
        public override string CharacterClass { get; set; }

        /// <summary>
        /// Link Skill information
        /// </summary>
        [JsonProperty("character_link_skill")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterLinkSkillInfoDTO> CharacterLinkSkill { get; set; } = new();

        /// <summary>
        /// Link Skill information for preset 1
        /// </summary>
        [JsonProperty("character_link_skill_preset_1")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterLinkSkillInfoDTO> CharacterLinkSkillPreset1 { get; set; } = new();

        /// <summary>
        /// Link Skill information for preset 2
        /// </summary>
        [JsonProperty("character_link_skill_preset_2")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterLinkSkillInfoDTO> CharacterLinkSkillPreset2 { get; set; } = new();

        /// <summary>
        /// Link Skill information for preset 3
        /// </summary>
        [JsonProperty("character_link_skill_preset_3")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterLinkSkillInfoDTO> CharacterLinkSkillPreset3 { get; set; } = new();

        /// <summary>
        /// My Link Skill information
        /// </summary>
        [JsonProperty("character_owned_link_skill")]
        public override CharacterLinkSkillInfoDTO? CharacterOwnedLinkSkill { get; set; }

        /// <summary>
        /// My Link Skill information for preset 1
        /// </summary>
        [JsonProperty("character_owned_link_skill_preset_1")]
        public override CharacterLinkSkillInfoDTO? CharacterOwnedLinkSkillPreset1 { get; set; }

        /// <summary>
        /// My Link Skill information for preset 2
        /// </summary>
        [JsonProperty("character_owned_link_skill_preset_2")]
        public override CharacterLinkSkillInfoDTO? CharacterOwnedLinkSkillPreset2 { get; set; }

        /// <summary>
        /// My Link Skill information for preset 3
        /// </summary>
        [JsonProperty("character_owned_link_skill_preset_3")]
        public override CharacterLinkSkillInfoDTO? CharacterOwnedLinkSkillPreset3 { get; set; }
    }

    /// <summary>
    /// Character link skill information
    /// </summary>
    public class CharacterLinkSkillInfoDTO : Base.CharacterLinkSkillInfoDTO
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
        public override long SkillLevel { get; set; }

        /// <summary>
        /// Skill effect
        /// </summary>
        [JsonProperty("skill_effect")]
        public override string SkillEffect { get; set; }

        /// <summary>
        /// Effect for the next skill level
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
