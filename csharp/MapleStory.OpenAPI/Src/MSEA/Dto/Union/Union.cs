using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.MSEA.DTO
{
    /// <summary>
    /// Union information
    /// </summary>
    public class UnionDTO : Base.UnionDTO
    {
        /// <summary>
        /// Reference date for query (SGT, daily data with hours and minutes set to 0)
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
        /// Union level
        /// </summary>
        [JsonProperty("union_level")]
        public override int? UnionLevel { get; set; }

        /// <summary>
        /// Union grade
        /// </summary>
        [JsonProperty("union_grade")]
        public override string? UnionGrade { get; set; }

        /// <summary>
        /// Artifact level
        /// </summary>
        [JsonProperty("union_artifact_level")]
        public override int? UnionArtifactLevel { get; set; }

        /// <summary>
        /// Earned Artifact EXP
        /// </summary>
        [JsonProperty("union_artifact_exp")]
        public override int? UnionArtifactExp { get; set; }

        /// <summary>
        /// Earned Artifact Points
        /// </summary>
        [JsonProperty("union_artifact_point")]
        public override int? UnionArtifactPoint { get; set; }
    }
}
