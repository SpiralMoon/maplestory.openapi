namespace MapleStory.OpenAPI.Common.DTO
{
    public abstract class CharacterLinkSkillDTO<TCharacterLinkSkillInfo>
    {
        public abstract DateTimeOffset? Date { get; set; }
        public abstract string? CharacterClass { get; set; }
        public abstract List<TCharacterLinkSkillInfo> CharacterLinkSkill { get; set; }
        public abstract List<TCharacterLinkSkillInfo> CharacterLinkSkillPreset1 { get; set; }
        public abstract List<TCharacterLinkSkillInfo> CharacterLinkSkillPreset2 { get; set; }
        public abstract List<TCharacterLinkSkillInfo> CharacterLinkSkillPreset3 { get; set; }
        public abstract TCharacterLinkSkillInfo? CharacterOwnedLinkSkill { get; set; }
        public abstract TCharacterLinkSkillInfo? CharacterOwnedLinkSkillPreset1 { get; set; }
        public abstract TCharacterLinkSkillInfo? CharacterOwnedLinkSkillPreset2 { get; set; }
        public abstract TCharacterLinkSkillInfo? CharacterOwnedLinkSkillPreset3 { get; set; }
    }

    public abstract class CharacterLinkSkillDTO : CharacterLinkSkillDTO<CharacterLinkSkillInfoDTO>
    {

    }

    public abstract class CharacterLinkSkillInfoDTO
    {
        public abstract string SkillName { get; set; }
        public abstract string SkillDescription { get; set; }
        public abstract long SkillLevel { get; set; }
        public abstract string SkillEffect { get; set; }
        public abstract string? SkillEffectNext { get; set; }
        public abstract string SkillIcon { get; set; }
    }
}
