using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.MSEA.DTO
{
    /// <summary>
    /// Guild basic information
    /// </summary>
    public class GuildBasicDTO : Base.GuildBasicDTO<GuildSkillDTO>
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
        /// World name
        /// </summary>
        [JsonProperty("world_name")]
        public override string WorldName { get; set; }

        /// <summary>
        /// Guild name
        /// </summary>
        [JsonProperty("guild_name")]
        public override string GuildName { get; set; }

        /// <summary>
        /// Guild level
        /// </summary>
        [JsonProperty("guild_level")]
        public override long GuildLevel { get; set; }

        /// <summary>
        /// Honor EXP
        /// </summary>
        [JsonProperty("guild_fame")]
        public override long GuildFame { get; set; }

        /// <summary>
        /// Guild Points (GP)
        /// </summary>
        [JsonProperty("guild_point")]
        public override long GuildPoint { get; set; }

        /// <summary>
        /// Character name of the Guild Master
        /// </summary>
        [JsonProperty("guild_master_name")]
        public override string GuildMasterName { get; set; }

        /// <summary>
        /// Number of guild members
        /// </summary>
        [JsonProperty("guild_member_count")]
        public override long GuildMemberCount { get; set; }

        /// <summary>
        /// List of guild members
        /// </summary>
        [JsonProperty("guild_member")]
        public override List<string> GuildMember { get; set; }

        /// <summary>
        /// List of guild skills
        /// </summary>
        [JsonProperty("guild_skill")]
        public override List<GuildSkillDTO> GuildSkill { get; set; }

        /// <summary>
        /// List of Noblesse Guild Skills
        /// </summary>
        [JsonProperty("guild_noblesse_skill")]
        public override List<GuildSkillDTO> GuildNoblesseSkill { get; set; }
    }

    /// <summary>
    /// Guild skill information
    /// </summary>
    public class GuildSkillDTO : Base.GuildSkillDTO
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
        /// Effects by skill level
        /// </summary>
        [JsonProperty("skill_effect")]
        public override string SkillEffect { get; set; }

        /// <summary>
        /// Skill icon
        /// </summary>
        [JsonProperty("skill_icon")]
        public override string SkillIcon { get; set; }
    }
}
