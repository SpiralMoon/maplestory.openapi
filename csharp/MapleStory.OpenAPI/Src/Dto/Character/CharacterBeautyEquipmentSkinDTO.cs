using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 피부 정보
    /// </summary>
    public class CharacterBeautyEquipmentSkinDTO
    {
        /// <summary>
        /// 피부 명
        /// </summary>
        [JsonProperty("skin_name")]
        public string SkinName { get; set; }

        /// <summary>
        /// 색상 계열
        /// </summary>
        [JsonProperty("color_style")]
        public string? ColorStyle { get; set; }

        /// <summary>
        /// 피부 색조
        /// </summary>
        [JsonProperty("hue")]
        public int? Hue { get; set; }

        /// <summary>
        /// 피부 채도
        /// </summary>
        [JsonProperty("saturation")]
        public int? Saturation { get; set; }

        /// <summary>
        /// 피부 명도
        /// </summary>
        [JsonProperty("brightness")]
        public int? Brightness { get; set; }
    }
}
