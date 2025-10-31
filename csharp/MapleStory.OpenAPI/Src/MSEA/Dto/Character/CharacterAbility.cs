using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.MSEA.DTO
{
    /// <summary>
    /// Character ability information
    /// </summary>
    public class CharacterAbilityDTO : Base.CharacterAbilityDTO<CharacterAbilityInfoDTO, CharacterAbilityPresetDTO>
    {
        /// <summary>
        /// Reference date for query (SGT, daily data with hours and minutes set to 0)
        /// </summary>
        [JsonProperty("date")]
        public override DateTimeOffset? Date
        {
            get
            {
                return _date?.ToOffset(TimeSpan.FromHours(8));
            }
            set
            {
                _date = value;
            }
        }

        private DateTimeOffset? _date;

        /// <summary>
        /// Ability grade
        /// </summary>
        [JsonProperty("ability_grade")]
        public override string? AbilityGrade { get; set; }

        /// <summary>
        /// Ability information
        /// </summary>
        [JsonProperty("ability_info")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterAbilityInfoDTO> AbilityInfo { get; set; } = new();

        /// <summary>
        /// Owned Honor EXP
        /// </summary>
        [JsonProperty("remain_fame")]
        public override long? RemainFame { get; set; }

        /// <summary>
        /// Active ability preset number
        /// </summary>
        [JsonProperty("preset_no")]
        public override int? PresetNo { get; set; }

        /// <summary>
        /// Complete information for Ability Preset 1
        /// </summary>
        [JsonProperty("ability_preset_1")]
        public override CharacterAbilityPresetDTO? AbilityPreset1 { get; set; }

        /// <summary>
        /// Complete information for Ability Preset 2
        /// </summary>
        [JsonProperty("ability_preset_2")]
        public override CharacterAbilityPresetDTO? AbilityPreset2 { get; set; }

        /// <summary>
        /// Complete information for Ability Preset 3
        /// </summary>
        [JsonProperty("ability_preset_3")]
        public override CharacterAbilityPresetDTO? AbilityPreset3 { get; set; }
    }

    /// <summary>
    /// Information for Ability Preset
    /// </summary>
    public class CharacterAbilityInfoDTO : Base.CharacterAbilityInfoDTO
    {
        /// <summary>
        /// Ability number
        /// </summary>
        [JsonProperty("ability_no")]
        public override string AbilityNo { get; set; }

        /// <summary>
        /// Ability grade
        /// </summary>
        [JsonProperty("ability_grade")]
        public override string AbilityGrade { get; set; }

        /// <summary>
        /// Ability option and value
        /// </summary>
        [JsonProperty("ability_value")]
        public override string AbilityValue { get; set; }
    }

    /// <summary>
    /// Character ability preset information
    /// </summary>
    public class CharacterAbilityPresetDTO : Base.CharacterAbilityPresetDTO<CharacterAbilityInfoDTO>
    {
        /// <summary>
        /// Ability grade for Preset
        /// </summary>
        [JsonProperty("ability_preset_grade")]
        public override string AbilityPresetGrade { get; set; }

        /// <summary>
        /// Information for Ability Preset
        /// </summary>
        [JsonProperty("ability_info")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterAbilityInfoDTO> AbilityInfo { get; set; } = new();
    }
}
