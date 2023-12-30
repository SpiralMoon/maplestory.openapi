using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 유니온 블록 기준점 좌표 정보
    /// </summary>
    public class UnionRaiderBlockControlPointDTO
    {
        /// <summary>
        /// 블록 기준점 X좌표
        /// </summary>
        [JsonProperty("x")]
        public long X { get; set; }

        /// <summary>
        /// 블록 기준점 Y좌표
        /// </summary>
        [JsonProperty("y")]
        public long Y { get; set; }
    }
}
