namespace MapleStory.OpenAPI.Common.DTO
{
    public abstract class CharacterSymbolEquipmentDTO<TCharacterSymbolEquipmentInfo>
    {
        public abstract DateTimeOffset? Date { get; set; }
        public abstract string? CharacterClass { get; set; }
        public abstract List<TCharacterSymbolEquipmentInfo> Symbol { get; set; }
    }

    public abstract class CharacterSymbolEquipmentDTO : CharacterSymbolEquipmentDTO<CharacterSymbolEquipmentInfoDTO>
    {

    }

    public abstract class CharacterSymbolEquipmentInfoDTO
    {
        public abstract string SymbolName { get; set; }
        public abstract string SymbolIcon { get; set; }
        public abstract string SymbolDescription { get; set; }
        public abstract string SymbolForce { get; set; }
        public abstract long SymbolLevel { get; set; }
        public abstract string SymbolStr { get; set; }
        public abstract string SymbolDex { get; set; }
        public abstract string SymbolInt { get; set; }
        public abstract string SymbolLuk { get; set; }
        public abstract string SymbolHp { get; set; }
        public abstract string SymbolDropRate { get; }
        public abstract string SymbolMesoRate { get; }
        public abstract string SymbolExpRate { get; }
        public abstract long SymbolGrowthCount { get; set; }
        public abstract long SymbolRequireGrowthCount { get; set; }
    }
}
