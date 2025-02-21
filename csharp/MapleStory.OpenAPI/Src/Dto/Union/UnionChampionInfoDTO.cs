using Newtonsoft.Json;
using Newtonsoft.Json.Serialization;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 유니온 챔피언 상세 정보

    /// </summary>
    public class UnionChampionInfoDTO
    {
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
