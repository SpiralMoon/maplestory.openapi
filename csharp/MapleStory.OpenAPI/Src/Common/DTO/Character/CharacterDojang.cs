namespace MapleStory.OpenAPI.Common.DTO
{
    public abstract class CharacterDojangDTO
    {
        public abstract DateTimeOffset? Date { get; set; }
        public abstract string CharacterClass { get; set; }
        public abstract string WorldName { get; set; }
        public abstract int DojangBestFloor { get; set; }
        public abstract DateTimeOffset? DateDojangRecord { get; set; }
        public abstract int DojangBestTime { get; set; }
    }
}
