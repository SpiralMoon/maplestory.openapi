using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 업적 랭킹 정보
    /// </summary>
    public class AchievementRankingDTO
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
        /// 업적 랭킹 순위
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
        /// 업적 등급
        /// </summary>
        [JsonProperty("trophy_grade")]
        public string TrophyGrade { get; set; }

        /// <summary>
        /// 업적 점수
        /// </summary>
        [JsonProperty("trophy_score")]
        public int TrophyScore { get; set; }
    }
}
