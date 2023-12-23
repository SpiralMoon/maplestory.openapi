using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 캐시 장비 컬러링프리즘
    /// </summary>
    public class CharacterCashItemEquipmentColoringPrismDTO
    {
        /// <summary>
        /// 컬러링프리즘 색상 범위
        /// </summary>
        [JsonProperty("color_range")]
        public string ColorRange { get; set; }

        /// <summary>
        /// 컬러링프리즘 색조
        /// </summary>
        [JsonProperty("hue")]
        public long Hue { get; set; }

        /// <summary>
        /// 컬러링프리즘 채도
        /// </summary>
        [JsonProperty("saturation")]
        public long Saturation { get; set; }

        /// <summary>
        /// 컬러링프리즘 명도
        /// </summary>
        [JsonProperty("value")]
        public long Value { get; set; }
    }
}
