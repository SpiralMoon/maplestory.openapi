namespace MapleStory.OpenAPI.Common.DTO
{
    public abstract class UnionRaiderDTO<IUnionRaiderInnerStat, IUnionRaiderBlock, IUnionRaiderPreset>
        where IUnionRaiderInnerStat : UnionRaiderInnerStatDTO
        where IUnionRaiderBlock : UnionRaiderBlockDTO
        where IUnionRaiderPreset : UnionRaiderPresetDTO
    {
        public abstract DateTimeOffset? Date { get; set; }
        public abstract List<string> UnionRaiderStat { get; set; }
        public abstract List<string> UnionOccupiedStat { get; set; }
        public abstract List<IUnionRaiderInnerStat> UnionInnerStat { get; set; }
        public abstract List<IUnionRaiderBlock> UnionBlock { get; set; }
        public abstract int UsePresetNo { get; set; }
        public abstract IUnionRaiderPreset? UnionRaiderPreset1 { get; set; }
        public abstract IUnionRaiderPreset? UnionRaiderPreset2 { get; set; }
        public abstract IUnionRaiderPreset? UnionRaiderPreset3 { get; set; }
        public abstract IUnionRaiderPreset? UnionRaiderPreset4 { get; set; }
        public abstract IUnionRaiderPreset? UnionRaiderPreset5 { get; set; }
    }

    //public abstract class UnionRaiderDTO : UnionRaiderDTO<UnionRaiderInnerStatDTO, UnionRaiderBlockDTO, UnionRaiderPresetDTO>
    //{
    //    public abstract DateTimeOffset? Date { get; set; }
    //    public abstract List<string> UnionRaiderStat { get; set; }
    //    public abstract List<string> UnionOccupiedStat { get; set; }
    //    public abstract List<UnionRaiderInnerStatDTO> UnionInnerStat { get; set; }
    //    public abstract List<UnionRaiderBlockDTO> UnionBlock { get; set; }
    //    public abstract int UsePresetNo { get; set; }
    //    public abstract UnionRaiderPresetDTO? UnionRaiderPreset1 { get; set; }
    //    public abstract UnionRaiderPresetDTO? UnionRaiderPreset2 { get; set; }
    //    public abstract UnionRaiderPresetDTO? UnionRaiderPreset3 { get; set; }
    //    public abstract UnionRaiderPresetDTO? UnionRaiderPreset4 { get; set; }
    //    public abstract UnionRaiderPresetDTO? UnionRaiderPreset5 { get; set; }
    //}

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

    public abstract class UnionRaiderBlockDTO<IUnionRaiderBlockControlPoint, IUnionRaiderBlockPosition>
        where IUnionRaiderBlockControlPoint : UnionRaiderBlockControlPointDTO
        where IUnionRaiderBlockPosition : UnionRaiderBlockPositionDTO
    {
        public abstract string BlockType { get; set; }
        public abstract string BlockClass { get; set; }
        public abstract string BlockLevel { get; set; }
        public abstract IUnionRaiderBlockControlPoint BlockControlPoint { get; set; }
        public abstract List<IUnionRaiderBlockPosition> BlockPosition { get; set; }
    }

    public abstract class UnionRaiderBlockDTO : UnionRaiderBlockDTO<UnionRaiderBlockControlPointDTO, UnionRaiderBlockPositionDTO>
    {

    }

    public abstract class UnionRaiderInnerStatDTO
    {
        public abstract string StatFieldId { get; set; }
        public abstract string StatFieldEffect { get; set; }
    }

    public abstract class UnionRaiderPresetDTO<IUnionRaiderInnerStat, IUnionRaiderBlock>
        where IUnionRaiderInnerStat : UnionRaiderInnerStatDTO
        where IUnionRaiderBlock : UnionRaiderBlockDTO
    {
        public abstract List<string> UnionRaiderStat { get; set; }
        public abstract List<string> UnionOccupiedStat { get; set; }
        public abstract List<IUnionRaiderInnerStat> UnionInnerStat { get; set; }
        public abstract List<IUnionRaiderBlock> UnionBlock { get; set; }
    }

    public abstract class UnionRaiderPresetDTO : UnionRaiderPresetDTO<UnionRaiderInnerStatDTO, UnionRaiderBlockDTO>
    {

    }
}
