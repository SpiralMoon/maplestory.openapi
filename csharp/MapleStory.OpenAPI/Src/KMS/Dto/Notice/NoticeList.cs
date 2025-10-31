using Newtonsoft.Json;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 공지사항 목록
    /// </summary>
    public class NoticeListDTO
    {
        /// <summary>
        /// 공지 목록
        /// </summary>
        [JsonProperty("notice")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<NoticeListItemDTO> Notice { get; set; } = new();
    }

    /// <summary>
    /// 공지사항
    /// </summary>
    public class NoticeListItemDTO
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
        /// 공지 식별자
        /// </summary>
        [JsonProperty("notice_id")]
        public int NoticeId { get; set; }

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
    }
}
