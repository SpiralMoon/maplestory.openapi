namespace MapleStory.OpenAPI.Common.DTO
{
    public abstract class UnionDTO
    {
        public abstract DateTimeOffset? Date { get; set; }
        public abstract int? UnionLevel { get; set; }
        public abstract string? UnionGrade { get; set; }
        public abstract int? UnionArtifactLevel { get; set; }
        public abstract int? UnionArtifactExp { get; set; }
        public abstract int? UnionArtifactPoint { get; set; }
    }
}
