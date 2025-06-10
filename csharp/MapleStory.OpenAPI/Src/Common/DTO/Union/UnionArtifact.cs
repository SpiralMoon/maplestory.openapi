namespace MapleStory.OpenAPI.Common.DTO
{
    public abstract class UnionArtifactDTO<TUnionArtifactEffect, TUnionArtifactCrystal>
    {
        public DateTimeOffset? Date { get; set; }
        public List<TUnionArtifactEffect> UnionArtifactEffect { get; set; }
        public List<TUnionArtifactCrystal> UnionArtifactCrystal { get; set; }
        public int? UnionArtifactRemainAp { get; set; }
    }

    public abstract class UnionArtifactDTO : UnionArtifactDTO<UnionArtifactEffectDTO, UnionArtifactCrystalDTO>
    {

    }

    public abstract class UnionArtifactCrystalDTO
    {
        public abstract string Name { get; set; }
        public abstract string ValidityFlag { get; set; }
        public abstract DateTimeOffset? DateExpire { get; }
        public abstract bool? IsExpired { get; }
        public abstract int Level { get; set; }
        public abstract string CrystalOptionName1 { get; set; }
        public abstract string CrystalOptionName2 { get; set; }
        public abstract string CrystalOptionName3 { get; set; }
    }

    public abstract class UnionArtifactEffectDTO
    {
        public abstract string Name { get; set; }
        public abstract int Level { get; set; }
    }
}
