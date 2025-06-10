namespace MapleStory.OpenAPI.Common.DTO
{
    public abstract class CharacterAndroidEquipmentDTO<TCharacterAndroidEquipmentHair, TCharacterAndroidEquipmentFace, TCharacterAndroidEquipmentSkin, TCharacterAndroidCashItemEquipment, TCharacterAndroidEquipmentPreset>
    {
        public abstract DateTimeOffset? Date { get; set; }
        public abstract string? AndroidName { get; set; }
        public abstract string? AndroidNickname { get; set; }
        public abstract string? AndroidIcon { get; set; }
        public abstract string? AndroidDescription { get; set; }
        public abstract TCharacterAndroidEquipmentHair? AndroidHair { get; set; }
        public abstract TCharacterAndroidEquipmentFace? AndroidFace { get; set; }
        public abstract TCharacterAndroidEquipmentSkin? AndroidSkin { get; set; }
        public abstract List<TCharacterAndroidCashItemEquipment> AndroidCashItemEquipment { get; set; }
        public abstract string? AndroidEarSensorClipFlag { get; set; }
        public abstract string? AndroidGender { get; set; }
        public abstract string? AndroidGrade { get; set; }
        public abstract string? AndroidNonHumanoidFlag { get; set; }
        public abstract string? AndroidShopUsableFlag { get; set; }
        public abstract int? PresetNo { get; set; }
        public abstract TCharacterAndroidEquipmentPreset? AndroidPreset1 { get; set; }
        public abstract TCharacterAndroidEquipmentPreset? AndroidPreset2 { get; set; }
        public abstract TCharacterAndroidEquipmentPreset? AndroidPreset3 { get; set; }
    }

    public abstract class CharacterAndroidEquipmentDTO : CharacterAndroidEquipmentDTO<CharacterAndroidEquipmentHairDTO, CharacterAndroidEquipmentFaceDTO, CharacterAndroidEquipmentSkinDTO, CharacterAndroidCashItemEquipmentDTO, CharacterAndroidEquipmentPresetDTO>
    {

    }

    public abstract class CharacterAndroidEquipmentHairDTO
    {
        public abstract string? HairName { get; set; }
        public abstract string? BaseColor { get; set; }
        public abstract string? MixColor { get; set; }
        public abstract string MixRate { get; set; }
    }

    public abstract class CharacterAndroidEquipmentFaceDTO
    {
        public abstract string? FaceName { get; set; }
        public abstract string? BaseColor { get; set; }
        public abstract string? MixColor { get; set; }
        public abstract string MixRate { get; set; }
    }

    public abstract class CharacterAndroidEquipmentSkinDTO
    {
        public abstract string SkinName { get; set; }
        public abstract string? ColorStyle { get; set; }
        public abstract int? Hue { get; set; }
        public abstract int? Saturation { get; set; }
        public abstract int? Brightness { get; set; }
    }

    public abstract class CharacterAndroidEquipmentPresetDTO<TCharacterAndroidEquipmentHair, TCharacterAndroidEquipmentFace, TCharacterAndroidEquipmentSkin>
    {
        public abstract string AndroidName { get; set; }
        public abstract string AndroidNickname { get; set; }
        public abstract string AndroidIcon { get; set; }
        public abstract string AndroidDescription { get; set; }
        public abstract string? AndroidGender { get; set; }
        public abstract string AndroidGrade { get; set; }
        public abstract TCharacterAndroidEquipmentHair AndroidHair { get; set; }
        public abstract TCharacterAndroidEquipmentFace AndroidFace { get; set; }
        public abstract TCharacterAndroidEquipmentSkin? AndroidSkin { get; set; }
        public abstract string AndroidEarSensorClipFlag { get; set; }
        public abstract string AndroidNonHumanoidFlag { get; set; }
        public abstract string AndroidShopUsableFlag { get; set; }
    }

    public abstract class CharacterAndroidEquipmentPresetDTO : CharacterAndroidEquipmentPresetDTO<CharacterAndroidEquipmentHairDTO, CharacterAndroidEquipmentFaceDTO, CharacterAndroidEquipmentSkinDTO>
    {

    }

    public abstract class CharacterAndroidCashItemEquipmentColoringPrismDTO
    {
        public abstract string ColorRange { get; set; }
        public abstract long Hue { get; set; }
        public abstract long Saturation { get; set; }
        public abstract long Value { get; set; }
    }

    public abstract class CharacterAndroidCashItemEquipmentOptionDTO
    {
        public abstract string OptionType { get; set; }
        public abstract string OptionValue { get; set; }
    }

    public abstract class CharacterAndroidCashItemEquipmentDTO<TCharacterAndroidCashItemEquipmentOption, TCharacterAndroidCashItemEquipmentColoringPrism>
    {
        public abstract string CashItemEquipmentPart { get; set; }
        public abstract string CashItemEquipmentSlot { get; set; }
        public abstract string CashItemName { get; set; }
        public abstract string CashItemIcon { get; set; }
        public abstract string? CashItemDescription { get; set; }
        public abstract List<TCharacterAndroidCashItemEquipmentOption> CashItemOption { get; set; }
        public abstract DateTimeOffset? DateExpire { get; }
        public abstract bool? IsExpired { get; }
        public abstract DateTimeOffset? DateOptionExpire { get; }
        public abstract bool? IsOptionExpired { get; }
        public abstract string? CashItemLabel { get; set; }
        public abstract TCharacterAndroidCashItemEquipmentColoringPrism? CashItemColoringPrism { get; set; }
    }

    public abstract class CharacterAndroidCashItemEquipmentDTO : CharacterAndroidCashItemEquipmentDTO<CharacterAndroidCashItemEquipmentOptionDTO, CharacterAndroidCashItemEquipmentColoringPrismDTO>
    {

    }
}
