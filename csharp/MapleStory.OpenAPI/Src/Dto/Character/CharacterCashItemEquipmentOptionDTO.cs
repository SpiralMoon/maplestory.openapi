using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 캐시 장비 옵션
    /// </summary>
    public class CharacterCashItemEquipmentOptionDTO
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
