using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 안드로이드 헤어 정보
    /// </summary>
    public class CharacterAndroidEquipmentHairDTO
    {
        /// <summary>
        /// 안드로이드 헤어 명
        /// </summary>
        [JsonProperty("hair_name")]
        public string HairName { get; set; }

        /// <summary>
        /// 안드로이드 헤어 베이스 컬러
        /// </summary>
        [JsonProperty("base_color")]
        public string BaseColor { get; set; }

        /// <summary>
        /// 안드로이드 헤어 믹스 컬러
        /// </summary>
        [JsonProperty("mix_color")]
        public string MixColor { get; set; }

        /// <summary>
        /// 안드로이드 헤어 믹스 컬러의 염색 비율
        /// </summary>
        [JsonProperty("mix_rate")]
        public string MixRate { get; set; }
    }
}
