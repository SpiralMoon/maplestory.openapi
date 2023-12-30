using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 유니온 블록이 차지하고 있는 영역 좌표들
    /// </summary>
    public class UnionRaiderBlockPositionDTO
    {
        /// <summary>
        /// 블록 X좌표
        /// </summary>
        [JsonProperty("x")]
        public long X { get; set; }

        /// <summary>
        /// 블록 Y좌표
        /// </summary>
        [JsonProperty("y")]
        public long Y { get; set; }
    }
}
