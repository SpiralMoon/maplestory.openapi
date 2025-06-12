namespace MapleStory.OpenAPI.Common.DTO
{
    public abstract class CharacterStatDTO<TCharacterFinalStat>
    {
        public abstract DateTimeOffset? Date { get; set; }
        public abstract string? CharacterClass { get; set; }
        public abstract List<TCharacterFinalStat> FinalStat { get; set; }
        public abstract int? RemainAp { get; set; }
    }

    public abstract class CharacterStatDTO : CharacterStatDTO<CharacterFinalStatDTO>
    {

    }

    public abstract class CharacterFinalStatDTO
    {
        public abstract string StatName { get; set; }
        public abstract string StatValue { get; set; }
    }
}
