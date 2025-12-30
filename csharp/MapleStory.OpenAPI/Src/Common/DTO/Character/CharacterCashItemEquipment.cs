namespace MapleStory.OpenAPI.Common.DTO
{
    public abstract class CharacterCashItemEquipmentDTO<TCharacterCashItemEquipmentPreset>
    {
        public abstract DateTimeOffset? Date { get; set; }
        public abstract string CharacterGender { get; set; }
        public abstract string CharacterClass { get; set; }
        public abstract string? CharacterLookMode { get; set; }
        public abstract int PresetNo { get; set; }
        public abstract List<TCharacterCashItemEquipmentPreset> CashItemEquipmentBase { get; set; }
        public abstract List<TCharacterCashItemEquipmentPreset> CashItemEquipmentPreset1 { get; set; }
        public abstract List<TCharacterCashItemEquipmentPreset> CashItemEquipmentPreset2 { get; set; }
        public abstract List<TCharacterCashItemEquipmentPreset> CashItemEquipmentPreset3 { get; set; }
        public abstract List<TCharacterCashItemEquipmentPreset> AdditionalCashItemEquipmentBase { get; set; }
        public abstract List<TCharacterCashItemEquipmentPreset> AdditionalCashItemEquipmentPreset1 { get; set; }
        public abstract List<TCharacterCashItemEquipmentPreset> AdditionalCashItemEquipmentPreset2 { get; set; }
        public abstract List<TCharacterCashItemEquipmentPreset> AdditionalCashItemEquipmentPreset3 { get; set; }
    }

    public abstract class CharacterCashItemEquipmentDTO : CharacterCashItemEquipmentDTO<CharacterCashItemEquipmentPresetDTO>
    {

    }

    public abstract class CharacterCashItemEquipmentColoringPrismDTO
    {
        public abstract string ColorRange { get; set; }
        public abstract long Hue { get; set; }
        public abstract long Saturation { get; set; }
        public abstract long Value { get; set; }
    }

    public abstract class CharacterCashItemEquipmentOptionDTO
    {
        public abstract string OptionType { get; set; }
        public abstract string OptionValue { get; set; }
    }

    public abstract class CharacterCashItemEquipmentPresetDTO<TCharacterCashItemEquipmentOption, TCharacterCashItemEquipmentColoringPrism>
    {
        public abstract string CashItemEquipmentPart { get; set; }
        public abstract string CashItemEquipmentSlot { get; set; }
        public abstract string CashItemName { get; set; }
        public abstract string CashItemIcon { get; set; }
        public abstract string? CashItemDescription { get; set; }
        public abstract List<TCharacterCashItemEquipmentOption> CashItemOption { get; set; }
        public abstract DateTimeOffset? DateExpire { get; }
        public abstract bool? IsExpired { get; }
        public abstract DateTimeOffset? DateOptionExpire { get; }
        public abstract bool? IsOptionExpired { get; }
        public abstract string? CashItemLabel { get; set; }
        public abstract TCharacterCashItemEquipmentColoringPrism? CashItemColoringPrism { get; set; }
        public abstract string? ItemGender { get; set; }
        public abstract string? FreestyleFlag { get; set; }
    }

    public abstract class CharacterCashItemEquipmentPresetDTO : CharacterCashItemEquipmentPresetDTO<CharacterCashItemEquipmentOptionDTO, CharacterCashItemEquipmentColoringPrismDTO>
    {

    }
}
