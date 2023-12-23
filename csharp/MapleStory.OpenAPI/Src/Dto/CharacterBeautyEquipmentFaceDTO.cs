using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 성형 정보
    /// </summary>
    public class CharacterBeautyEquipmentFaceDTO
    {
        /// <summary>
        /// 성형 명
        /// </summary>
        [JsonProperty("face_name")]
        public string FaceName { get; set; }

        /// <summary>
        /// 성형 베이스 컬러
        /// </summary>
        [JsonProperty("base_color")]
        public string BaseColor { get; set; }

        /// <summary>
        /// 성형 믹스 컬러
        /// </summary>
        [JsonProperty("mix_color")]
        public string MixColor { get; set; }

        /// <summary>
        /// 성형 믹스 컬러의 염색 비율
        /// </summary>
        [JsonProperty("mix_rate")]
        public string MixRate { get; set; }
    }
}
