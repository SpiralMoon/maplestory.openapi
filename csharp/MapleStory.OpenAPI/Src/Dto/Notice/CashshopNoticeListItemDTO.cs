using Newtonsoft.Json;
using System.Text.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐시샵 공지
    /// </summary>
    public class CashshopNoticeListItemDTO
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

        /// <summary>
        /// 판매 시작일
        /// </summary>
        [JsonProperty("date_sale_start")]
        public DateTimeOffset? DateSaleStart
        {
            get
            {
                return _dateSaleStart?.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _dateSaleStart = value;
            }
        }

        private DateTimeOffset? _dateSaleStart;

        /// <summary>
        /// 판매 종료일
        /// </summary>
        [JsonProperty("date_sale_end")]
        public DateTimeOffset? DateSaleEnd
        {
            get
            {
                return _dateSaleEnd?.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _dateSaleEnd = value;
            }
        }

        private DateTimeOffset? _dateSaleEnd;

        /// <summary>
        /// 상시 판매 여부 (true - 상시)
        /// </summary>
        [JsonProperty("ongoing_flag")]
        public string OnGoingFlag { get; set; }

        /// <summary>
        /// 상시 판매 여부 (true - 상시)
        /// </summary>
        public bool IsOnGoing
        {
            get
            {
                return OnGoingFlag == "true";
            }
        }
    }
}
