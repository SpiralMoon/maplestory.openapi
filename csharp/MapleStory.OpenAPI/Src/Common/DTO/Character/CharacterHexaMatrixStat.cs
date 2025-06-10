namespace MapleStory.OpenAPI.Common.DTO
{
    public abstract class CharacterHexaMatrixStatDTO<TCharacterHexaMatrixStatCore>
    {
        public abstract DateTimeOffset? Date { get; set; }
        public abstract string? CharacterClass { get; set; }
        public abstract List<TCharacterHexaMatrixStatCore> CharacterHexaStatCore { get; set; }
        public abstract List<TCharacterHexaMatrixStatCore> CharacterHexaStatCore2 { get; set; }
        public abstract List<TCharacterHexaMatrixStatCore> CharacterHexaStatCore3 { get; set; }
        public abstract List<TCharacterHexaMatrixStatCore> PresetHexaStatCore { get; set; }
        public abstract List<TCharacterHexaMatrixStatCore> PresetHexaStatCore2 { get; set; }
        public abstract List<TCharacterHexaMatrixStatCore> PresetHexaStatCore3 { get; set; }
    }

    public abstract class CharacterHexaMatrixStatDTO : CharacterHexaMatrixStatDTO<CharacterHexaMatrixStatCoreDTO>
    {

    }

    public abstract class CharacterHexaMatrixStatCoreDTO
    {
        public abstract string SlotId { get; set; }
        public abstract string MainStatName { get; set; }
        public abstract string SubStatName1 { get; set; }
        public abstract string SubStatName2 { get; set; }
        public abstract long MainStatLevel { get; set; }
        public abstract long SubStatLevel1 { get; set; }
        public abstract long SubStatLevel2 { get; set; }
        public abstract long StatGrade { get; set; }
    }
}
