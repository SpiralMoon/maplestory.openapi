namespace MapleStory.OpenAPI.Common.DTO
{
    public abstract class CharacterHexaMatrixDTO<TCharacterHexaMatrixEquipment>
    {
        public abstract DateTimeOffset? Date { get; set; }
        public abstract List<TCharacterHexaMatrixEquipment>? CharacterHexaCoreEquipment { get; set; }
    }

    public abstract class CharacterHexaMatrixDTO : CharacterHexaMatrixDTO<CharacterHexaMatrixEquipmentDTO>
    {

    }

    public abstract class CharacterHexaMatrixEquipmentLinkedSkillDTO
    {
        public abstract string HexaSkillId { get; set; }
    }

    public abstract class CharacterHexaMatrixEquipmentDTO<TCharacterHexaMatrixEquipmentLinkedSkill>
    {
        public abstract string HexaCoreName { get; set; }
        public abstract long HexaCoreLevel { get; set; }
        public abstract string HexaCoreType { get; set; }
        public abstract List<TCharacterHexaMatrixEquipmentLinkedSkill> LinkedSkill { get; set; }
    }

    public abstract class CharacterHexaMatrixEquipmentDTO : CharacterHexaMatrixEquipmentDTO<CharacterHexaMatrixEquipmentLinkedSkillDTO>
    {

    }
}
