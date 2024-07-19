using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐시샵 공지 목록
    /// </summary>
    public class CashshopNoticeListDTO
    {
        /// <summary>
        /// 공지 목록
        /// </summary>
        [JsonProperty("cashshop_notice")]
        public List<CashshopNoticeListItemDTO> CashshopNotice { get; set; }
    }
}
