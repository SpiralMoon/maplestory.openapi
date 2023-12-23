using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 유니온 공격대 배치 정보
    /// </summary>
    public class UnionRaiderInnerStatDTO
    {
        /// <summary>
        /// 공격대 배치 위치 (11시 방향부터 시계 방향 순서대로 0~7)
        /// </summary>
        [JsonProperty("stat_field_id")]
        public string StatFieldId { get; set; }

        /// <summary>
        /// 해당 지역 점령 효과
        /// </summary>
        [JsonProperty("stat_field_effect")]
        public string StatFieldEffect { get; set; }
    }
}
