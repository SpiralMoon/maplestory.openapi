using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 안드로이드 캐시 아이템 옵션 정보
    /// </summary>
    public class CharacterAndroidCashItemEquipmentOptionDTO
    {
        /// <summary>
        /// 옵션 타입
        /// </summary>
        [JsonProperty("option_type")]
        public string OptionType { get; set; }

        /// <summary>
        /// 옵션 값
        /// </summary>
        [JsonProperty("option_value")]
        public string OptionValue { get; set; }
    }
}
