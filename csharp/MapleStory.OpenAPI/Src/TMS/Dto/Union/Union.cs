using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.TMS.DTO
{
    /// <summary>
    /// 戰地資訊
    /// </summary>
    public class UnionDTO : Base.UnionDTO
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
        /// 聯盟等級
        /// </summary>
        [JsonProperty("union_level")]
        public override int? UnionLevel { get; set; }

        /// <summary>
        /// 聯盟階級
        /// </summary>
        [JsonProperty("union_grade")]
        public override string? UnionGrade { get; set; }

        /// <summary>
        /// 神器等級
        /// </summary>
        [JsonProperty("union_artifact_level")]
        public override int? UnionArtifactLevel { get; set; }

        /// <summary>
        /// 持有的神器經驗值
        /// </summary>
        [JsonProperty("union_artifact_exp")]
        public override int? UnionArtifactExp { get; set; }

        /// <summary>
        /// 持有的神器點數
        /// </summary>
        [JsonProperty("union_artifact_point")]
        public override int? UnionArtifactPoint { get; set; }
    }
}
