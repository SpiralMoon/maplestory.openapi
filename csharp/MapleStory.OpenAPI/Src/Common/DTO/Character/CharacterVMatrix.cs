namespace MapleStory.OpenAPI.Common.DTO
{
    public abstract class CharacterVMatrixDTO<TCharacterVMatrixCoreEquipment>
    {
        public abstract DateTimeOffset? Date { get; set; }
        public abstract string? CharacterClass { get; set; }
        public abstract List<TCharacterVMatrixCoreEquipment> CharacterVCoreEquipment { get; set; }
        public abstract int? CharacterVMatrixRemainSlotUpgradePoint { get; set; }
    }

    public abstract class CharacterVMatrixDTO : CharacterVMatrixDTO<CharacterVMatrixCoreEquipmentDTO>
    {

    }

    public abstract class CharacterVMatrixCoreEquipmentDTO
    {
        public abstract string SlotId { get; set; }
        public abstract long SlotLevel { get; set; }
        public abstract string? VCoreName { get; set; }
        public abstract string? VCoreType { get; set; }
        public abstract long VCoreLevel { get; set; }
        public abstract string VCoreSkill1 { get; set; }
        public abstract string? VCoreSkill2 { get; set; }
        public abstract string? VCoreSkill3 { get; set; }
    }
}
