using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 펫 장비 아이템 옵션 정보
    /// </summary>
    public class CharacterPetEquipmentItemOptionDTO
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
