using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 모든 세트 효과 정보
    /// </summary>
    public class CharacterSetEffectOptionFullDTO
    {
        /// <summary>
        /// 세트 효과 레벨 (장비 수)
        /// </summary>
        [JsonProperty("set_count")]
        public int SetCount { get; set; }

        /// <summary>
        /// 세트 효과
        /// </summary>
        [JsonProperty("set_option")]
        public string SetOption { get; set; }
    }
}
