using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
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
        public List<NoticeListItemDTO> Notice { get; set; }
    }
}
