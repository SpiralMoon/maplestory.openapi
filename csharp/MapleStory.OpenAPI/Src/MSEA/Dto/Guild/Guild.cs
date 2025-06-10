using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.MSEA.DTO
{
    /// <summary>
    /// Guild identifier information
    /// </summary>
    public class GuildDTO : Base.GuildDTO
    {
        /// <summary>
        /// Guild identifier
        /// </summary>
        [JsonProperty("oguild_id")]
        public override string OGuildId { get; set; }
    }
}
