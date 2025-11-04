namespace MapleStory.OpenAPI.Common.DTO
{
    public abstract class CharacterHyperStatDTO<TCharacterHyperStatPreset>
    {
        public abstract DateTimeOffset? Date { get; set; }
        public abstract string CharacterClass { get; set; }
        public abstract string UsePresetNo { get; set; }
        public abstract int UseAvailableHyperStat { get; set; }
        public abstract List<TCharacterHyperStatPreset> HyperStatPreset1 { get; set; }
        public abstract int HyperStatPreset1RemainPoint { get; set; }
        public abstract List<TCharacterHyperStatPreset> HyperStatPreset2 { get; set; }
        public abstract int HyperStatPreset2RemainPoint { get; set; }
        public abstract List<TCharacterHyperStatPreset> HyperStatPreset3 { get; set; }
        public abstract int HyperStatPreset3RemainPoint { get; set; }
    }

    public abstract class CharacterHyperStatDTO : CharacterHyperStatDTO<CharacterHyperStatPresetDTO>
    {

    }

    public abstract class CharacterHyperStatPresetDTO
    {
        public abstract string StatType { get; set; }
        public abstract long? StatPoint { get; set; }
        public abstract long StatLevel { get; set; }
        public abstract string? StatIncrease { get; set; }
    }
}
