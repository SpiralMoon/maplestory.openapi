namespace MapleStory.OpenAPI.Common.DTO
{
    public abstract class CharacterPropensityDTO
    {
        public abstract DateTimeOffset? Date { get; set; }
        public abstract int? CharismaLevel { get; set; }
        public abstract int? SensibilityLevel { get; set; }
        public abstract int? InsightLevel { get; set; }
        public abstract int? WillingnessLevel { get; set; }
        public abstract int? HandicraftLevel { get; set; }
        public abstract int? CharmLevel { get; set; }
    }
}
