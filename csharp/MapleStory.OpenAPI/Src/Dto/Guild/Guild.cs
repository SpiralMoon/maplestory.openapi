using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 길드 식별자 정보
    /// </summary>
    public class GuildDTO
    {
        /// <summary>
        /// 길드 식별자
        /// </summary>
        [JsonProperty("oguild_id")]
        public string OGuildId { get; set; }
    }
}
