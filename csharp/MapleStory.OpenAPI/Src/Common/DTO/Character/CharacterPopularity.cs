namespace MapleStory.OpenAPI.Common.DTO
{
    public abstract class CharacterPopularityDTO
    {
        public abstract DateTimeOffset? Date { get; set; }
        public abstract long Popularity { get; set; }
    }
}
