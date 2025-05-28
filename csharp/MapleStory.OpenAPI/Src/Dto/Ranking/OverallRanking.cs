using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 종합 랭킹 정보
    /// </summary>
    public class OverallRankingDTO
    {
        /// <summary>
        /// 랭킹 업데이트 일자 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        /// </summary>
        [JsonProperty("date")]
        public DateTimeOffset Date
        {
            get
            {
                return _date.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _date = value;
            }
        }

        private DateTimeOffset _date;

        /// <summary>
        /// 종합 랭킹 순위
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
        /// 캐릭터 경험치
        /// </summary>
        [JsonProperty("character_exp")]
        public long CharacterExp { get; set; }

        /// <summary>
        /// 캐릭터 인기도
        /// </summary>
        [JsonProperty("character_popularity")]
        public int CharacterPopularity { get; set; }

        /// <summary>
        /// 길드 명
        /// </summary>
        [JsonProperty("character_guildname")]
        public string? CharacterGuildName { get; set; }
    }

    /// <summary>
    /// 종합 랭킹 응답 정보
    /// </summary>
    public class OverallRankingResponseDTO : RankingResponseDTO<OverallRankingDTO>
    {

    }
}
