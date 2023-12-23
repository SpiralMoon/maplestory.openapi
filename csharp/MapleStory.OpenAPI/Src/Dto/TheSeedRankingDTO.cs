using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 더 시드 랭킹 정보
    /// </summary>
    public class TheSeedRankingDTO
    {
        /// <summary>
        /// 랭킹 업데이트 일자 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        /// </summary>
        [JsonProperty("date")]
        public string Date { get; set; }

        /// <summary>
        /// 더 시드 랭킹 순위
        /// </summary>
        [JsonProperty("ranking")]
        public int Ranking { get; set; }

        /// <summary>
        /// 캐릭터 명
        /// </summary>
        [JsonProperty("character_name")]
        public string CharacterName { get; set; }

        /// <summary>
        /// 월드 명
        /// </summary>
        [JsonProperty("world_name")]
        public string WorldName { get; set; }

        /// <summary>
        /// 직업 명
        /// </summary>
        [JsonProperty("class_name")]
        public string ClassName { get; set; }

        /// <summary>
        /// 전직 직업 명
        /// </summary>
        [JsonProperty("sub_class_name")]
        public string SubClassName { get; set; }

        /// <summary>
        /// 캐릭터 레벨
        /// </summary>
        [JsonProperty("character_level")]
        public int CharacterLevel { get; set; }

        /// <summary>
        /// 더 시드 도달 층
        /// </summary>
        [JsonProperty("theseed_floor")]
        public int TheSeedFloor { get; set; }

        /// <summary>
        /// 더 시드 클리어 시간 기록 (초 단위)
        /// </summary>
        [JsonProperty("theseed_time_record")]
        public int TheSeedTimeRecord { get; set; }
    }
}
