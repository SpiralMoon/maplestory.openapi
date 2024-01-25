using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 어빌리티 프리셋 정보
    /// </summary>
    public class CharacterAbilityPresetDTO
    {
        /// <summary>
        /// 프리셋의 어빌리티 등급
        /// </summary>
        [JsonProperty("ability_preset_grade")]
        public string AbilityPresetGrade { get; set; }

        /// <summary>
        /// 프리셋의 어빌리티 정보
        /// </summary>
        [JsonProperty("ability_info")]
        public List<CharacterAbilityInfoDTO> AbilityInfo { get; set; }
    }
}
