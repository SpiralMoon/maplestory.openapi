using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
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
        public List<UpdateNoticeListItemDTO> UpdateNotice { get; set; }
    }
}
