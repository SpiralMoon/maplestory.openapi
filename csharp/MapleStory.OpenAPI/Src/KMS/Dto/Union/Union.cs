using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 유니온 정보
    /// </summary>
    public class UnionDTO : Base.UnionDTO
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
        /// 유니온 레벨
        /// </summary>
        [JsonProperty("union_level")]
        public override int? UnionLevel { get; set; }

        /// <summary>
        /// 유니온 등급
        /// </summary>
        [JsonProperty("union_grade")]
        public override string? UnionGrade { get; set; }

        /// <summary>
        /// 아티팩트 레벨
        /// </summary>
        [JsonProperty("union_artifact_level")]
        public override int? UnionArtifactLevel { get; set; }

        /// <summary>
        /// 보유 아티팩트 경험치
        /// </summary>
        [JsonProperty("union_artifact_exp")]
        public override int? UnionArtifactExp { get; set; }

        /// <summary>
        /// 보유 아티팩트 포인트
        /// </summary>
        [JsonProperty("union_artifact_point")]
        public override int? UnionArtifactPoint { get; set; }
    }
}
