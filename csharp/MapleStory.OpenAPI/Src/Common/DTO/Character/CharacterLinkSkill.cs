namespace MapleStory.OpenAPI.Common.DTO
{
    public abstract class CharacterLinkSkillDTO<TCharacterLinkSkillInfo>
    {
        public abstract DateTimeOffset? Date { get; set; }
        public abstract string? CharacterClass { get; set; }
        public abstract List<CharacterLinkSkillInfoDTO> CharacterLinkSkill { get; set; }
        public abstract List<CharacterLinkSkillInfoDTO> CharacterLinkSkillPreset1 { get; set; }
        public abstract List<CharacterLinkSkillInfoDTO> CharacterLinkSkillPreset2 { get; set; }
        public abstract List<CharacterLinkSkillInfoDTO> CharacterLinkSkillPreset3 { get; set; }
        public abstract CharacterLinkSkillInfoDTO? CharacterOwnedLinkSkill { get; set; }
        public abstract CharacterLinkSkillInfoDTO? CharacterOwnedLinkSkillPreset1 { get; set; }
        public abstract CharacterLinkSkillInfoDTO? CharacterOwnedLinkSkillPreset2 { get; set; }
        public abstract CharacterLinkSkillInfoDTO? CharacterOwnedLinkSkillPreset3 { get; set; }
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
