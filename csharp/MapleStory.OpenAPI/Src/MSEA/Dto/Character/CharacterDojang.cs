using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.MSEA.DTO
{
    /// <summary>
    /// Character Mu Lung Garden highest record information
    /// </summary>
    public class CharacterDojangDTO : Base.CharacterDojangDTO
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
        /// Character job
        /// </summary>
        [JsonProperty("character_class")]
        public override string? CharacterClass { get; set; }

        /// <summary>
        /// World name
        /// </summary>
        [JsonProperty("world_name")]
        public override string? WorldName { get; set; }

        /// <summary>
        /// Highest floor record in Mu Lung Garden
        /// </summary>
        [JsonProperty("dojang_best_floor")]
        public override int? DojangBestFloor { get; set; }

        /// <summary>
        /// Achievement date of the highest Mu Lung Garden record (SGT, daily data with hours and minutes set to 0)
        /// </summary>
        [JsonProperty("date_dojang_record")]
        public override DateTimeOffset? DateDojangRecord
        {
            get
            {
                return _dateDojangRecord?.ToOffset(TimeSpan.FromHours(8));
            }
            set
            {
                _dateDojangRecord = value;
            }
        }

        private DateTimeOffset? _dateDojangRecord;

        /// <summary>
        /// Time taken to clear the highest floor in Mu Lung Garden (in seconds)
        /// </summary>
        [JsonProperty("dojang_best_time")]
        public override int? DojangBestTime { get; set; }
    }
}
