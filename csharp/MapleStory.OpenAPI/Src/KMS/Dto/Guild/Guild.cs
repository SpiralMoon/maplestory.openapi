using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 길드 식별자 정보
    /// </summary>
    public class GuildDTO : Base.GuildDTO
    {
        /// <summary>
        /// 길드 식별자
        /// </summary>
        [JsonProperty("oguild_id")]
        public override string OGuildId { get; set; }
    }
}
