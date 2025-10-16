using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.TMS.DTO
{
    /// <summary>
    /// 公會識別碼資訊
    /// </summary>
    public class GuildDTO : Base.GuildDTO
    {
        /// <summary>
        /// 公會識別碼
        /// </summary>
        [JsonProperty("oguild_id")]
        public override string OGuildId { get; set; }
    }
}
