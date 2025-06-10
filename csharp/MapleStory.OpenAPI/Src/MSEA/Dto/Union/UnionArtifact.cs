using Newtonsoft.Json;
using Newtonsoft.Json.Serialization;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.MSEA.DTO
{
    /// <summary>
    /// Union artifact information
    /// </summary>
    public class UnionArtifactDTO : Base.UnionArtifactDTO<UnionArtifactEffectDTO, UnionArtifactCrystalDTO>
    {
        /// <summary>
        /// Reference date for query (SGT, daily data with hours and minutes set to 0)
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
        /// Artifact effect information
        /// </summary>
        [JsonProperty("union_artifact_effect")]
        public List<UnionArtifactEffectDTO> UnionArtifactEffect { get; set; }

        /// <summary>
        /// Artifact crystal information
        /// </summary>
        [JsonProperty("union_artifact_crystal")]
        public List<UnionArtifactCrystalDTO> UnionArtifactCrystal { get; set; }

        /// <summary>
        /// Remaining artifact AP
        /// </summary>
        [JsonProperty("union_artifact_remain_ap")]
        public int? UnionArtifactRemainAp { get; set; }
    }

    /// <summary>
    /// Artifact crystal information
    /// </summary>
    public class UnionArtifactCrystalDTO : Base.UnionArtifactCrystalDTO
    {
        /// <summary>
        /// Name of the artifact crystal
        /// </summary>
        [JsonProperty("name")]
        public override string Name { get; set; }

        /// <summary>
        /// Validity of the stat (0:Valid, 1:Invalid)
        /// </summary>
        [JsonProperty("validity_flag")]
        public override string ValidityFlag { get; set; }

        /// <summary>
        /// Expiration date of the stat (SGT)
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
        /// Grade of the artifact crystal
        /// </summary>
        [JsonProperty("level")]
        public override int Level { get; set; }

        /// <summary>
        /// First option of the artifact crystal
        /// </summary>
        [JsonProperty("crystal_option_name_1")]
        public override string CrystalOptionName1 { get; set; }

        /// <summary>
        /// Second option of the artifact crystal
        /// </summary>
        [JsonProperty("crystal_option_name_2")]
        public override string CrystalOptionName2 { get; set; }

        /// <summary>
        /// Third option of the artifact crystal
        /// </summary>
        [JsonProperty("crystal_option_name_3")]
        public override string CrystalOptionName3 { get; set; }
    }

    /// <summary>
    /// Artifact effect information
    /// </summary>
    public class UnionArtifactEffectDTO : Base.UnionArtifactEffectDTO
    {
        /// <summary>
        /// Name of the artifact effect
        /// </summary>
        [JsonProperty("name")]
        public override string Name { get; set; }

        /// <summary>
        /// Level of the artifact effect
        /// </summary>
        [JsonProperty("level")]
        public override int Level { get; set; }
    }
}
