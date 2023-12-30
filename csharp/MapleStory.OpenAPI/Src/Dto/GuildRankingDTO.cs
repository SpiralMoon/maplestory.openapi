using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 길드 랭킹 정보
    /// </summary>
    public class GuildRankingDTO
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
        /// 길드 랭킹 순위
        /// </summary>
        [JsonProperty("ranking")]
        public int Ranking { get; set; }

        /// <summary>
        /// 길드 명
        /// </summary>
        [JsonProperty("guild_name")]
        public string GuildName { get; set; }

        /// <summary>
        /// 월드 명
        /// </summary>
        [JsonProperty("world_name")]
        public string WorldName { get; set; }

        /// <summary>
        /// 길드 레벨
        /// </summary>
        [JsonProperty("guild_level")]
        public int GuildLevel { get; set; }

        /// <summary>
        /// 길드 마스터 캐릭터 명
        /// </summary>
        [JsonProperty("guild_master_name")]
        public string GuildMasterName { get; set; }

        /// <summary>
        /// 길드 마크
        /// </summary>
        [JsonProperty("guild_mark")]
        public string GuildMark { get; set; }

        /// <summary>
        /// 길드 포인트
        /// </summary>
        [JsonProperty("guild_point")]
        public long GuildPoint { get; set; }
    }
}
