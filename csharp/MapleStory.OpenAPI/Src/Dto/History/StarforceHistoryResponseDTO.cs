using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 스타포스 히스토리 응답 정보
    /// </summary>
    public class StarforceHistoryResponseDTO
    {
        /// <summary>
        /// 결과 건 수
        /// </summary>
        [JsonProperty("count")]
        public int Count { get; set; }

        /// <summary>
        /// 스타포스 히스토리
        /// </summary>
        [JsonProperty("starforce_history")]
        public List<StarforceHistoryDTO> StarforceHistory { get; set; }

        /// <summary>
        /// 페이징 처리를 위한 cursor
        /// </summary>
        [JsonProperty("next_cursor")]
        public string? NextCursor { get; set; }
    }
}
