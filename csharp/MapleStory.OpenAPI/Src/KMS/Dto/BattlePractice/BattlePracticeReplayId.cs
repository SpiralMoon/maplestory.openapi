using Newtonsoft.Json;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 연무장 리플레이 식별자 목록
    /// </summary>
    public class BattlePracticeReplayIdDTO
    {
        /// <summary>
        /// 리플레이 목록
        /// </summary>
        [JsonProperty("replay_list")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<BattlePracticeReplayIdInfoDTO> ReplayList { get; set; } = new();
    }

    /// <summary>
    /// 연무장 리플레이 식별자 상세 정보
    /// </summary>
    public class BattlePracticeReplayIdInfoDTO
    {
        /// <summary>
        /// 기간 번호 (연무장 초기화 시마다 1씩 증가됩니다.)
        /// </summary>
        [JsonProperty("period_no")]
        public int PeriodNo { get; set; }

        /// <summary>
        /// 리플레이 등록 일시 (KST)
        /// </summary>
        [JsonProperty("register_date")]
        public DateTimeOffset RegisterDate
        {
            get
            {
                return _registerDate.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _registerDate = value;
            }
        }

        private DateTimeOffset _registerDate;

        /// <summary>
        /// 연무장 리플레이 고유 식별자
        /// </summary>
        [JsonProperty("replay_id")]
        public string ReplayId { get; set; }
    }
}
