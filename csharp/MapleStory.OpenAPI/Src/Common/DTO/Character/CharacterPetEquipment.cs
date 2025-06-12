namespace MapleStory.OpenAPI.Common.DTO
{
    public abstract class CharacterPetEquipmentDTO<TCharacterPetEquipmentItem, TCharacterPetEquipmentAutoSkill>
    {
        public abstract DateTimeOffset? Date { get; set; }
        public abstract string? Pet1Name { get; set; }
        public abstract string? Pet1Nickname { get; set; }
        public abstract string? Pet1Icon { get; set; }
        public abstract string? Pet1Description { get; set; }
        public abstract TCharacterPetEquipmentItem? Pet1Equipment { get; set; }
        public abstract TCharacterPetEquipmentAutoSkill? Pet1AutoSkill { get; set; }
        public abstract string? Pet1PetType { get; set; }
        public abstract List<string> Pet1Skill { get; set; }
        public abstract DateTimeOffset? Pet1DateExpire { get; }
        public abstract bool? Pet1Expired { get; }
        public abstract string? Pet1Appearance { get; set; }
        public abstract string? Pet1AppearanceIcon { get; set; }
        public abstract string? Pet2Name { get; set; }
        public abstract string? Pet2Nickname { get; set; }
        public abstract string? Pet2Icon { get; set; }
        public abstract string? Pet2Description { get; set; }
        public abstract TCharacterPetEquipmentItem? Pet2Equipment { get; set; }
        public abstract TCharacterPetEquipmentAutoSkill? Pet2AutoSkill { get; set; }
        public abstract string? Pet2PetType { get; set; }
        public abstract List<string> Pet2Skill { get; set; }
        public abstract DateTimeOffset? Pet2DateExpire { get; }
        public abstract bool? Pet2Expired { get; }
        public abstract string? Pet2Appearance { get; set; }
        public abstract string? Pet2AppearanceIcon { get; set; }
        public abstract string? Pet3Name { get; set; }
        public abstract string? Pet3Nickname { get; set; }
        public abstract string? Pet3Icon { get; set; }
        public abstract string? Pet3Description { get; set; }
        public abstract TCharacterPetEquipmentItem? Pet3Equipment { get; set; }
        public abstract TCharacterPetEquipmentAutoSkill? Pet3AutoSkill { get; set; }
        public abstract string? Pet3PetType { get; set; }
        public abstract List<string> Pet3Skill { get; set; }
        public abstract DateTimeOffset? Pet3DateExpire { get; }
        public abstract bool? Pet3Expired { get; }
        public abstract string? Pet3Appearance { get; set; }
        public abstract string? Pet3AppearanceIcon { get; set; }
    }

    public abstract class CharacterPetEquipmentDTO : CharacterPetEquipmentDTO<CharacterPetEquipmentItemDTO, CharacterPetEquipmentAutoSkillDTO>
    {

    }

    public abstract class CharacterPetEquipmentAutoSkillDTO
    {
        public abstract string? Skill1 { get; set; }
        public abstract string? Skill1Icon { get; set; }
        public abstract string? Skill2 { get; set; }
        public abstract string? Skill2Icon { get; set; }
    }

    public abstract class CharacterPetEquipmentItemOptionDTO
    {
        public abstract string OptionType { get; set; }
        public abstract string OptionValue { get; set; }
    }

    public abstract class CharacterPetEquipmentItemDTO<TCharacterPetEquipmentItemOption>
    {
        public abstract string? ItemName { get; set; }
        public abstract string? ItemIcon { get; set; }
        public abstract string? ItemDescription { get; set; }
        public abstract List<TCharacterPetEquipmentItemOption> ItemOption { get; set; }
        public abstract int ScrollUpgrade { get; set; }
        public abstract int ScrollUpgradable { get; set; }
        public abstract string? ItemShape { get; set; }
        public abstract string? ItemShapeIcon { get; set; }
    }

    public abstract class CharacterPetEquipmentItemDTO : CharacterPetEquipmentItemDTO<CharacterPetEquipmentItemOptionDTO>
    {

    }
}
