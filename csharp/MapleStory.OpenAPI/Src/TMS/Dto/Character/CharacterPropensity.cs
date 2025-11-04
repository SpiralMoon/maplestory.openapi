using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.TMS.DTO
{
    /// <summary>
    /// 角色性向資訊
    /// </summary>
    public class CharacterPropensityDTO : Base.CharacterPropensityDTO
    {
        /// <summary>
        /// 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
        /// </summary>
        [JsonProperty("date")]
        public override DateTimeOffset? Date
        {
            get
            {
                return _date?.ToOffset(TimeSpan.FromHours(8));
            }
            set
            {
                _date = value;
            }
        }

        private DateTimeOffset? _date;

        /// <summary>
        /// 領導力等級
        /// </summary>
        [JsonProperty("charisma_level")]
        public override int CharismaLevel { get; set; }

        /// <summary>
        /// 感性等級
        /// </summary>
        [JsonProperty("sensibility_level")]
        public override int SensibilityLevel { get; set; }

        /// <summary>
        /// 洞察力等級
        /// </summary>
        [JsonProperty("insight_level")]
        public override int InsightLevel { get; set; }

        /// <summary>
        /// 意志等級
        /// </summary>
        [JsonProperty("willingness_level")]
        public override int WillingnessLevel { get; set; }

        /// <summary>
        /// 手藝等級
        /// </summary>
        [JsonProperty("handicraft_level")]
        public override int HandicraftLevel { get; set; }

        /// <summary>
        /// 魅力等級
        /// </summary>
        [JsonProperty("charm_level")]
        public override int CharmLevel { get; set; }
    }
}
