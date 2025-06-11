using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 캐릭터의 무릉도장 정보
    /// </summary>
    public class CharacterDojangDTO : Base.CharacterDojangDTO
    {
        /// <summary>
        /// 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        /// </summary>
        [JsonProperty("date")]
        public override DateTimeOffset? Date
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
        public override string? CharacterClass { get; set; }

        /// <summary>
        /// 월드 명
        /// </summary>
        [JsonProperty("world_name")]
        public override string? WorldName { get; set; }

        /// <summary>
        /// 무릉도장 최고 기록 층수
        /// </summary>
        [JsonProperty("dojang_best_floor")]
        public override int? DojangBestFloor { get; set; }

        /// <summary>
        /// 무릉도장 최고 기록 달성 일 (KST)
        /// </summary>
        [JsonProperty("date_dojang_record")]
        public override DateTimeOffset? DateDojangRecord
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
        public override int? DojangBestTime { get; set; }
    }
}
