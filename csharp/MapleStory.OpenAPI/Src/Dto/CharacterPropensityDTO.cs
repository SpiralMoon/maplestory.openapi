using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 성향 정보
    /// </summary>
    public class CharacterPropensityDTO
    {
        /// <summary>
        /// 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        /// </summary>
        [JsonProperty("date")]
        public string Date { get; set; }

        /// <summary>
        /// 카리스마 레벨
        /// </summary>
        [JsonProperty("charisma_level")]
        public long CharismaLevel { get; set; }

        /// <summary>
        /// 감성 레벨
        /// </summary>
        [JsonProperty("sensibility_level")]
        public long SensibilityLevel { get; set; }

        /// <summary>
        /// 통찰력 레벨
        /// </summary>
        [JsonProperty("insight_level")]
        public long InsightLevel { get; set; }

        /// <summary>
        /// 의지 레벨
        /// </summary>
        [JsonProperty("willingness_level")]
        public long WillingnessLevel { get; set; }

        /// <summary>
        /// 손재주 레벨
        /// </summary>
        [JsonProperty("handicraft_level")]
        public long HandicraftLevel { get; set; }

        /// <summary>
        /// 매력 레벨
        /// </summary>
        [JsonProperty("charm_level")]
        public long CharmLevel { get; set; }
    }
}
