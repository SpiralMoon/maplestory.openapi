namespace MapleStory.OpenAPI.Common.DTO
{
    public abstract class UnionRaiderDTO<TUnionRaiderInnerStat, TUnionRaiderBlock, TUnionRaiderPreset>
    {
        public abstract DateTimeOffset? Date { get; set; }
        public abstract List<string> UnionRaiderStat { get; set; }
        public abstract List<string> UnionOccupiedStat { get; set; }
        public abstract List<TUnionRaiderInnerStat> UnionInnerStat { get; set; }
        public abstract List<TUnionRaiderBlock> UnionBlock { get; set; }
        public abstract int UsePresetNo { get; set; }
        public abstract TUnionRaiderPreset? UnionRaiderPreset1 { get; set; }
        public abstract TUnionRaiderPreset? UnionRaiderPreset2 { get; set; }
        public abstract TUnionRaiderPreset? UnionRaiderPreset3 { get; set; }
        public abstract TUnionRaiderPreset? UnionRaiderPreset4 { get; set; }
        public abstract TUnionRaiderPreset? UnionRaiderPreset5 { get; set; }
    }

    public abstract class UnionRaiderDTO : UnionRaiderDTO<UnionRaiderInnerStatDTO, UnionRaiderBlockDTO, UnionRaiderPresetDTO>
    {

    }

    public abstract class UnionRaiderBlockControlPointDTO
    {
        public abstract long X { get; set; }
        public abstract long Y { get; set; }
    }

    public abstract class UnionRaiderBlockPositionDTO
    {
        public abstract long X { get; set; }
        public abstract long Y { get; set; }
    }

    public abstract class UnionRaiderBlockDTO<TUnionRaiderBlockControlPoint, TUnionRaiderBlockPosition>
    {
        public abstract string BlockType { get; set; }
        public abstract string? BlockClass { get; set; }
        public abstract string BlockLevel { get; set; }
        public abstract TUnionRaiderBlockControlPoint BlockControlPoint { get; set; }
        public abstract List<TUnionRaiderBlockPosition> BlockPosition { get; set; }
    }

    public abstract class UnionRaiderBlockDTO : UnionRaiderBlockDTO<UnionRaiderBlockControlPointDTO, UnionRaiderBlockPositionDTO>
    {

    }

    public abstract class UnionRaiderInnerStatDTO
    {
        public abstract string StatFieldId { get; set; }
        public abstract string StatFieldEffect { get; set; }
    }

    public abstract class UnionRaiderPresetDTO<TUnionRaiderInnerStat, TUnionRaiderBlock>
    {
        public abstract List<string> UnionRaiderStat { get; set; }
        public abstract List<string> UnionOccupiedStat { get; set; }
        public abstract List<TUnionRaiderInnerStat> UnionInnerStat { get; set; }
        public abstract List<TUnionRaiderBlock> UnionBlock { get; set; }
    }

    public abstract class UnionRaiderPresetDTO : UnionRaiderPresetDTO<UnionRaiderInnerStatDTO, UnionRaiderBlockDTO>
    {

    }
}
