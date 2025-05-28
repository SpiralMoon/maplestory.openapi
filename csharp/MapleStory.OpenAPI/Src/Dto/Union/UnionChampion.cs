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

    /// <summary>
    /// 유니온 챔피언 휘장 정보
    /// </summary>
    public class UnionChampionBadgeInfoDTO
    {
        /// <summary>
        /// 유니온 챔피언 휘장 효과
        /// </summary>
        [JsonProperty("stat")]
        public string? Stat { get; set; }
    }

    /// <summary>
    /// 유니온 챔피언 상세 정보

    /// </summary>
    public class UnionChampionInfoDTO
    {
        /// <summary>
        /// 유니온 챔피언 캐릭터 명
        /// </summary>
        [JsonProperty("champion_name")]
        public string ChampionName { get; set; }

        /// <summary>
        /// 유니온 챔피언 슬롯
        /// </summary>
        [JsonProperty("champion_slot")]
        public int ChampionSlot { get; set; }

        /// <summary>
        /// 유니온 챔피언 등급
        /// </summary>
        [JsonProperty("champion_grade")]
        public string ChampionGrade { get; set; }

        /// <summary>
        /// 유니온 챔피언 캐릭터의 직업
        /// </summary>
        [JsonProperty("champion_class")]
        public string ChampionClass { get; set; }

        /// <summary>
        /// 챔피언 휘장 효과
        /// </summary>
        [JsonProperty("champion_badge_info")]
        public List<UnionChampionBadgeInfoDTO> ChampionBadgeInfo { get; set; }
    }
}
