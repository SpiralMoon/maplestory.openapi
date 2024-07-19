using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 진행 중 이벤트 목록
    /// </summary>
    public class EventNoticeListDTO
    {
        /// <summary>
        /// 공지 목록
        /// </summary>
        [JsonProperty("event_notice")]
        public List<EventNoticeListItemDTO> EventNotice { get; set; }
    }
}
