using Newtonsoft.Json;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 업데이트 목록
    /// </summary>
    public class UpdateNoticeListDTO
    {
        /// <summary>
        /// 공지 목록
        /// </summary>
        [JsonProperty("update_notice")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<UpdateNoticeListItemDTO> UpdateNotice { get; set; } = new();
    }

    /// <summary>
    /// 업데이트 공지
    /// </summary>
    public class UpdateNoticeListItemDTO
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
