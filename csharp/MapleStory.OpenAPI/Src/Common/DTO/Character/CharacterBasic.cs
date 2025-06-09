namespace MapleStory.OpenAPI.Common.DTO
{
    public abstract class CharacterBasicDTO
    {
        public abstract DateTimeOffset? Date { get; set; }
        public abstract string CharacterName { get; set; }
        public abstract string WorldName { get; set; }
        public abstract string CharacterGender { get; set; }
        public abstract string CharacterClass { get; set; }
        public abstract string CharacterClassLevel { get; set; }
        public abstract long CharacterLevel { get; set; }
        public abstract long CharacterExp { get; set; }
        public abstract string CharacterExpRate { get; set; }
        public abstract string? CharacterGuildName { get; set; }
        public abstract string CharacterImage { get; set; }
        public abstract DateTimeOffset CharacterDateCreate { get; set; }
        public abstract bool AccessFlag { get; }
        public abstract bool LiberationQuestClearFlag { get; }
    }
}
