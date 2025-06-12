namespace MapleStory.OpenAPI.Common.DTO
{
    public abstract class CharacterSetEffectDTO<TCharacterSetEffectSet>
    {
        public abstract DateTimeOffset? Date { get; set; }
        public abstract List<TCharacterSetEffectSet> SetEffect { get; set; }
    }

    public abstract class CharacterSetEffectDTO : CharacterSetEffectDTO<CharacterSetEffectSetDTO>
    {

    }

    public abstract class CharacterSetEffectInfoDTO
    {
        public abstract int SetCount { get; set; }
        public abstract string SetOption { get; set; }
    }

    public abstract class CharacterSetEffectOptionFullDTO
    {
        public abstract int SetCount { get; set; }
        public abstract string SetOption { get; set; }
    }

    public abstract class CharacterSetEffectSetDTO<TCharacterSetEffectInfo, TCharacterSetEffectOptionFull>
    {
        public abstract string SetName { get; set; }
        public abstract long TotalSetCount { get; set; }
        public abstract List<TCharacterSetEffectInfo> SetEffectInfo { get; set; }
        public abstract List<TCharacterSetEffectOptionFull> SetOptionFull { get; set; }
    }

    public abstract class CharacterSetEffectSetDTO : CharacterSetEffectSetDTO<CharacterSetEffectInfoDTO, CharacterSetEffectOptionFullDTO>
    {

    }
}
