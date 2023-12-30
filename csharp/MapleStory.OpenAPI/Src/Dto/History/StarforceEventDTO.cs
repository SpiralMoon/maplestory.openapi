using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 스타포스 강화 이벤트 정보
    /// </summary>
    public class StarforceEventDTO
    {
        /// <summary>
        /// 이벤트 성공 확률
        /// </summary>
        [JsonProperty("success_rate")]
        public string SuccessRate { get; set; }

        /// <summary>
        /// 이벤트 비용 할인율
        /// </summary>
        [JsonProperty("cost_discount_rate")]
        public string CostDiscountRate { get; set; }

        /// <summary>
        /// 이벤트 강화 수치 가중값
        /// </summary>
        [JsonProperty("plus_value")]
        public string PlusValue { get; set; }

        /// <summary>
        /// 이벤트 적용 강화 시도 가능한 n성 범위
        /// </summary>
        [JsonProperty("starforce_event_range")]
        public string StarforceEventRange { get; set; }
    }
}
