namespace MapleStory.OpenAPI.Common.DTO
{
    public abstract class GuildBasicDTO<TGuildSkill>
    {
        public abstract DateTimeOffset? Date { get; set; }
        public abstract string WorldName { get; set; }
        public abstract string GuildName { get; set; }
        public abstract long GuildLevel { get; set; }
        public abstract long GuildFame { get; set; }
        public abstract long GuildPoint { get; set; }
        public abstract string GuildMasterName { get; set; }
        public abstract long GuildMemberCount { get; set; }
        public abstract List<string> GuildMember { get; set; }
        public abstract List<TGuildSkill> GuildSkill { get; set; }
        public abstract List<TGuildSkill> GuildNoblesseSkill { get; set; }
    }

    public abstract class GuildBasicDTO : GuildBasicDTO<GuildSkillDTO>
    {

    }

    public abstract class GuildSkillDTO
    {
        public abstract string SkillName { get; set; }
        public abstract string SkillDescription { get; set; }
        public abstract long SkillLevel { get; set; }
        public abstract string SkillEffect { get; set; }
        public abstract string SkillIcon { get; set; }
    }
}
