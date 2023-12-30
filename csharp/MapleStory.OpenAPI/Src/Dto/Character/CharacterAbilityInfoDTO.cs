using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 어빌리티 상세 정보
    /// </summary>
    public class CharacterAbilityInfoDTO
    {
        /// <summary>
        /// 어빌리티 번호
        /// </summary>
        [JsonProperty("ability_no")]
        public string AbilityNo { get; set; }

        /// <summary>
        /// 어빌리티 등급
        /// </summary>
        [JsonProperty("ability_grade")]
        public string AbilityGrade { get; set; }

        /// <summary>
        /// 어빌리티 옵션 및 수치
        /// </summary>
        [JsonProperty("ability_value")]
        public string AbilityValue { get; set; }
    }
}
