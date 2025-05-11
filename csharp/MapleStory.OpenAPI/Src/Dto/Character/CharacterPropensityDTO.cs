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
        public DateTimeOffset? Date
        {
            get
            {
                return _date?.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _date = value;
            }
        }

        private DateTimeOffset? _date;

        /// <summary>
        /// 카리스마 레벨
        /// </summary>
        [JsonProperty("charisma_level")]
        public int? CharismaLevel { get; set; }

        /// <summary>
        /// 감성 레벨
        /// </summary>
        [JsonProperty("sensibility_level")]
        public int? SensibilityLevel { get; set; }

        /// <summary>
        /// 통찰력 레벨
        /// </summary>
        [JsonProperty("insight_level")]
        public int? InsightLevel { get; set; }

        /// <summary>
        /// 의지 레벨
        /// </summary>
        [JsonProperty("willingness_level")]
        public int? WillingnessLevel { get; set; }

        /// <summary>
        /// 손재주 레벨
        /// </summary>
        [JsonProperty("handicraft_level")]
        public int? HandicraftLevel { get; set; }

        /// <summary>
        /// 매력 레벨
        /// </summary>
        [JsonProperty("charm_level")]
        public int? CharmLevel { get; set; }
    }
}
