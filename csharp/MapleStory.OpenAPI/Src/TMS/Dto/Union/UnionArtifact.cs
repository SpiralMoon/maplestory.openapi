using Newtonsoft.Json;
using Newtonsoft.Json.Serialization;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.TMS.DTO
{
    /// <summary>
    /// 戰地神器資訊
    /// </summary>
    public class UnionArtifactDTO : Base.UnionArtifactDTO<UnionArtifactEffectDTO, UnionArtifactCrystalDTO>
    {
        /// <summary>
        /// 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
        /// </summary>
        [JsonProperty("date")]
        public DateTimeOffset? Date
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
        /// 神器效果資訊
        /// </summary>
        [JsonProperty("union_artifact_effect")]
        public List<UnionArtifactEffectDTO> UnionArtifactEffect { get; set; }

        /// <summary>
        /// 神器水晶資訊
        /// </summary>
        [JsonProperty("union_artifact_crystal")]
        public List<UnionArtifactCrystalDTO> UnionArtifactCrystal { get; set; }

        /// <summary>
        /// 剩餘神器 AP
        /// </summary>
        [JsonProperty("union_artifact_remain_ap")]
        public int? UnionArtifactRemainAp { get; set; }
    }

    /// <summary>
    /// 神器水晶資訊
    /// </summary>
    public class UnionArtifactCrystalDTO : Base.UnionArtifactCrystalDTO
    {
        /// <summary>
        /// 神器水晶名稱
        /// </summary>
        [JsonProperty("name")]
        public override string Name { get; set; }

        /// <summary>
        /// 能力有效性 (0：有效，1：無效)
        /// </summary>
        [JsonProperty("validity_flag")]
        public override string ValidityFlag { get; set; }

        /// <summary>
        /// 能力有效期間 (TST)
        /// </summary>
        public override DateTimeOffset? DateExpire
        {
            get
            {
                if (_dateExpire != null && _dateExpire != "expired")
                {
                    return DateTimeOffset.Parse(_dateExpire).ToOffset(TimeSpan.FromHours(8));
                }

                return null;
            }
        }

        [JsonProperty("date_expire")]
        private string? _dateExpire;

        /// <summary>
        /// Whether the artifact crystal is expired
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
        /// 神器水晶階級
        /// </summary>
        [JsonProperty("level")]
        public override int Level { get; set; }

        /// <summary>
        /// 神器水晶第一選項名稱
        /// </summary>
        [JsonProperty("crystal_option_name_1")]
        public override string CrystalOptionName1 { get; set; }

        /// <summary>
        /// 神器水晶第二選項名稱
        /// </summary>
        [JsonProperty("crystal_option_name_2")]
        public override string CrystalOptionName2 { get; set; }

        /// <summary>
        /// 神器水晶第三選項名稱
        /// </summary>
        [JsonProperty("crystal_option_name_3")]
        public override string CrystalOptionName3 { get; set; }
    }

    /// <summary>
    /// 神器效果資訊
    /// </summary>
    public class UnionArtifactEffectDTO : Base.UnionArtifactEffectDTO
    {
        /// <summary>
        /// 神器效果名稱
        /// </summary>
        [JsonProperty("name")]
        public override string Name { get; set; }

        /// <summary>
        /// 神器效果等級
        /// </summary>
        [JsonProperty("level")]
        public override int Level { get; set; }
    }
}
