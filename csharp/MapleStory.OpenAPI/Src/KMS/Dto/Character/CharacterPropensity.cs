using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 캐릭터 성향 정보
    /// </summary>
    public class CharacterPropensityDTO : Base.CharacterPropensityDTO
    {
        /// <summary>
        /// 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        /// </summary>
        [JsonProperty("date")]
        public override DateTimeOffset? Date
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
        public override int CharismaLevel { get; set; }

        /// <summary>
        /// 감성 레벨
        /// </summary>
        [JsonProperty("sensibility_level")]
        public override int SensibilityLevel { get; set; }

        /// <summary>
        /// 통찰력 레벨
        /// </summary>
        [JsonProperty("insight_level")]
        public override int InsightLevel { get; set; }

        /// <summary>
        /// 의지 레벨
        /// </summary>
        [JsonProperty("willingness_level")]
        public override int WillingnessLevel { get; set; }

        /// <summary>
        /// 손재주 레벨
        /// </summary>
        [JsonProperty("handicraft_level")]
        public override int HandicraftLevel { get; set; }

        /// <summary>
        /// 매력 레벨
        /// </summary>
        [JsonProperty("charm_level")]
        public override int CharmLevel { get; set; }
    }
}
