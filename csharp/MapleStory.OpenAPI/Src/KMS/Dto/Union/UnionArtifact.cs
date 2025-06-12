using Newtonsoft.Json;
using Newtonsoft.Json.Serialization;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 유니온 아티팩트 정보
    /// </summary>
    public class UnionArtifactDTO : Base.UnionArtifactDTO<UnionArtifactEffectDTO, UnionArtifactCrystalDTO>
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

    /// <summary>
    /// 유니온 아티팩트 크리스탈 정보
    /// </summary>
    public class UnionArtifactCrystalDTO : Base.UnionArtifactCrystalDTO
    {
        /// <summary>
        /// 아티팩트 효과 명
        /// </summary>
        [JsonProperty("name")]
        public override string Name { get; set; }

        /// <summary>
        /// 능력치 유효 여부 (0:유효, 1:유효하지 않음)
        /// </summary>
        [JsonProperty("validity_flag")]
        public override string ValidityFlag { get; set; }

        /// <summary>
        /// 능력치 유효 기간 (KST)
        /// </summary>
        public override DateTimeOffset? DateExpire
        {
            get
            {
                if (_dateExpire != null && _dateExpire != "expired")
                {
                    return DateTimeOffset.Parse(_dateExpire).ToOffset(TimeSpan.FromHours(9));
                }

                return null;
            }
        }

        [JsonProperty("date_expire")]
        private string? _dateExpire;

        /// <summary>
        /// 능력치 유효 기간 만료 여부
        /// </summary>
        public override bool? IsExpired
        {
            get
            {
                if (_dateExpire == null)
                {
                    return null;
                }

                return _dateExpire == "expired";
            }
        }

        /// <summary>
        /// 아티팩트 크리스탈 등급
        /// </summary>
        [JsonProperty("level")]
        public override int Level { get; set; }

        /// <summary>
        /// 아티팩트 크리스탈 첫 번째 옵션 명
        /// </summary>
        [JsonProperty("crystal_option_name_1")]
        public override string CrystalOptionName1 { get; set; }

        /// <summary>
        /// 아티팩트 크리스탈 두 번째 옵션 명
        /// </summary>
        [JsonProperty("crystal_option_name_2")]
        public override string CrystalOptionName2 { get; set; }

        /// <summary>
        /// 아티팩트 크리스탈 세 번째 옵션 명
        /// </summary>
        [JsonProperty("crystal_option_name_3")]
        public override string CrystalOptionName3 { get; set; }
    }

    /// <summary>
    /// 유니온 아티팩트 효과 정보
    /// </summary>
    public class UnionArtifactEffectDTO : Base.UnionArtifactEffectDTO
    {
        /// <summary>
        /// 아티팩트 효과 명
        /// </summary>
        [JsonProperty("name")]
        public override string Name { get; set; }

        /// <summary>
        /// 아티팩트 효과 레벨
        /// </summary>
        [JsonProperty("level")]
        public override int Level { get; set; }
    }
}
