namespace MapleStory.OpenAPI.Common.DTO
{
    public abstract class CharacterAbilityDTO<TCharacterAbilityInfo, TCharacterAbilityPreset>
    {
        public abstract DateTimeOffset? Date { get; set; }
        public abstract string AbilityGrade { get; set; }
        public abstract List<TCharacterAbilityInfo> AbilityInfo { get; set; }
        public abstract long RemainFame { get; set; }
        public abstract int? PresetNo { get; set; }
        public abstract TCharacterAbilityPreset? AbilityPreset1 { get; set; }
        public abstract TCharacterAbilityPreset? AbilityPreset2 { get; set; }
        public abstract TCharacterAbilityPreset? AbilityPreset3 { get; set; }
    }

    public abstract class CharacterAbilityDTO : CharacterAbilityDTO<CharacterAbilityInfoDTO, CharacterAbilityPresetDTO>
    {

    }

    public abstract class CharacterAbilityInfoDTO
    {
        public abstract string AbilityNo { get; set; }
        public abstract string AbilityGrade { get; set; }
        public abstract string AbilityValue { get; set; }
    }

    public abstract class CharacterAbilityPresetDTO<TCharacterAbilityInfo>
    {
        public abstract string AbilityPresetGrade { get; set; }
        public abstract List<TCharacterAbilityInfo> AbilityInfo { get; set; }
    }

    public abstract class CharacterAbilityPresetDTO : CharacterAbilityPresetDTO<CharacterAbilityInfoDTO>
    {

    }
}
