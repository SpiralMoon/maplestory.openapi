using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 유니온 정보
    /// </summary>
    public class UnionDTO
    {
        /// <summary>
        /// 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        /// </summary>
        [JsonProperty("date")]
        public string Date { get; set; }

        /// <summary>
        /// 유니온 레벨
        /// </summary>
        [JsonProperty("union_level")]
        public long UnionLevel { get; set; }

        /// <summary>
        /// 유니온 등급
        /// </summary>
        [JsonProperty("union_grade")]
        public string UnionGrade { get; set; }
    }
}
