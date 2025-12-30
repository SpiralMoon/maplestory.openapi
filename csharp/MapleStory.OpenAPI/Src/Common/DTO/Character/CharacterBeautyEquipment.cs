namespace MapleStory.OpenAPI.Common.DTO
{
    public abstract class CharacterBeautyEquipmentDTO<TCharacterBeautyEquipmentHair, TCharacterBeautyEquipmentFace, TCharacterBeautyEquipmentSkin>
    {
        public abstract DateTimeOffset? Date { get; set; }
        public abstract string? CharacterGender { get; set; }
        public abstract string? CharacterClass { get; set; }
        public abstract TCharacterBeautyEquipmentHair? CharacterHair { get; set; }
        public abstract TCharacterBeautyEquipmentFace? CharacterFace { get; set; }
        public abstract TCharacterBeautyEquipmentSkin? CharacterSkin { get; set; }
        public abstract TCharacterBeautyEquipmentHair? AdditionalCharacterHair { get; set; }
        public abstract TCharacterBeautyEquipmentFace? AdditionalCharacterFace { get; set; }
        public abstract TCharacterBeautyEquipmentSkin? AdditionalCharacterSkin { get; set; }
    }

    public abstract class CharacterBeautyEquipmentDTO : CharacterBeautyEquipmentDTO<CharacterBeautyEquipmentHairDTO, CharacterBeautyEquipmentFaceDTO, CharacterBeautyEquipmentSkinDTO>
    {

    }

    public abstract class CharacterBeautyEquipmentHairDTO
    {
        public abstract string HairName { get; set; }
        public abstract string BaseColor { get; set; }
        public abstract string? MixColor { get; set; }
        public abstract string MixRate { get; set; }
        public abstract string? FreestyleFlag { get; set; }
    }

    public abstract class CharacterBeautyEquipmentFaceDTO
    {
        public abstract string FaceName { get; set; }
        public abstract string BaseColor { get; set; }
        public abstract string? MixColor { get; set; }
        public abstract string MixRate { get; set; }
        public abstract string? FreestyleFlag { get; set; }
    }

    public abstract class CharacterBeautyEquipmentSkinDTO
    {
        public abstract string SkinName { get; set; }
        public abstract string? ColorStyle { get; set; }
        public abstract int? Hue { get; set; }
        public abstract int? Saturation { get; set; }
        public abstract int? Brightness { get; set; }
    }
}
