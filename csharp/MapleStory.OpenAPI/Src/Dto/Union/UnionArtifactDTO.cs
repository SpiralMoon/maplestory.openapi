using Newtonsoft.Json;
using Newtonsoft.Json.Serialization;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 유니온 아티팩트 정보
    /// </summary>
    public class UnionArtifactDTO
    {
        /// <summary>
        /// 조회 기준일
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
        /// 아티팩트 효과 정보
        /// </summary>
        [JsonProperty("union_artifact_effect")]
        public List<UnionArtifactEffectDTO> UnionArtifactEffect { get; set; }

        /// <summary>
        /// 아티팩트 크리스탈 정보
        /// </summary>
        [JsonProperty("union_artifact_crystal")]
        public List<UnionArtifactCrystalDTO> UnionArtifactCrystal { get; set; }

        /// <summary>
        /// 잔여 아티팩트 AP
        /// </summary>
        [JsonProperty("union_artifact_remain_ap")]
        public int? UnionArtifactRemainAp { get; set; }
    }
}
