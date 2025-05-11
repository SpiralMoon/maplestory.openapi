using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터의 무릉도장 정보
    /// </summary>
    public class CharacterDojangDTO
    {
        /// <summary>
        /// 조회 기준일 (KST)
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
        /// 캐릭터 직업
        /// </summary>
        [JsonProperty("character_class")]
        public string? CharacterClass { get; set; }

        /// <summary>
        /// 월드 명
        /// </summary>
        [JsonProperty("world_name")]
        public string? WorldName { get; set; }

        /// <summary>
        /// 무릉도장 최고 기록 층수
        /// </summary>
        [JsonProperty("dojang_best_floor")]
        public int? DojangBestFloor { get; set; }

        /// <summary>
        /// 무릉도장 최고 기록 달성 일 (KST)
        /// </summary>
        [JsonProperty("date_dojang_record")]
        public DateTimeOffset? DateDojangRecord
        {
            get
            {
                return _dateDojangRecord?.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _dateDojangRecord = value;
            }
        }

        private DateTimeOffset? _dateDojangRecord;

        /// <summary>
        /// 무릉도장 최고 층수 클리어에 걸린 시간 (초)
        /// </summary>
        [JsonProperty("dojang_best_time")]
        public int? DojangBestTime { get; set; }
    }
}
