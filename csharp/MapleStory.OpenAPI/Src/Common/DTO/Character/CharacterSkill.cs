namespace MapleStory.OpenAPI.Common.DTO
{
    public abstract class CharacterSkillDTO<TCharacterSkillInfo>
    {
        public abstract DateTimeOffset? Date { get; set; }
        public abstract string CharacterClass { get; set; }
        public abstract string? CharacterSkillGrade { get; set; }
        public abstract List<TCharacterSkillInfo> CharacterSkill { get; set; }
    }

    public abstract class CharacterSkillDTO : CharacterSkillDTO<CharacterSkillInfoDTO>
    {

    }

    public abstract class CharacterSkillInfoDTO
    {
        public abstract string SkillName { get; set; }
        public abstract string SkillDescription { get; set; }
        public abstract long? SkillLevel { get; set; }
        public abstract string? SkillEffect { get; set; }
        public abstract string? SkillEffectNext { get; set; }
        public abstract string SkillIcon { get; set; }
    }
}
