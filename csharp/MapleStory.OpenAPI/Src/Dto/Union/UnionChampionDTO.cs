using Newtonsoft.Json;
using Newtonsoft.Json.Serialization;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 유니온 챔피언 정보
    /// </summary>
    public class UnionChampionDTO
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
        /// 유니온 챔피언 정보
        /// </summary>
        [JsonProperty("union_champion")]
        public List<UnionChampionInfoDTO> UnionChampion { get; set; }

        /// <summary>
        /// 유니온 챔피언 휘장 정보
        /// </summary>
        [JsonProperty("champion_badge_total_info")]
        public List<UnionChampionBadgeInfoDTO> ChampionBadgeTotalInfo { get; set; }
    }
}
