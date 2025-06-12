using Newtonsoft.Json;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 진행 중 이벤트 상세
    /// </summary>
    public class EventNoticeDetailDTO
    {
        /// <summary>
        /// 공지 제목
        /// </summary>
        [JsonProperty("title")]
        public string Title { get; set; }

        /// <summary>
        /// 공지 링크
        /// </summary>
        [JsonProperty("url")]
        public string Url { get; set; }

        /// <summary>
        /// 공지 본문
        /// </summary>
        [JsonProperty("contents")]
        public string Contents { get; set; }

        /// <summary>
        /// 공지 등록일
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
        /// 이벤트 시작일
        /// </summary>
        [JsonProperty("date_event_start")]
        public DateTimeOffset DateEventStart
        {
            get
            {
                return _dateEventStart.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _dateEventStart = value;
            }
        }

        private DateTimeOffset _dateEventStart;

        /// <summary>
        /// 이벤트 종료일
        /// </summary>
        [JsonProperty("date_event_end")]
        public DateTimeOffset DateEventEnd
        {
            get
            {
                return _dateEventEnd.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _dateEventEnd = value;
            }
        }

        private DateTimeOffset _dateEventEnd;
    }
}
