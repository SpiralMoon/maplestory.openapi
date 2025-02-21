using Newtonsoft.Json;
using Newtonsoft.Json.Serialization;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 유니온 챔피언 휘장 정보
    /// </summary>
    public class UnionChampionBadgeInfoDTO
    {
        /// <summary>
        /// 유니온 챔피언 휘장 효과
        /// </summary>
        [JsonProperty("stat")]
        public string? Stat { get; set; }
    }
}
