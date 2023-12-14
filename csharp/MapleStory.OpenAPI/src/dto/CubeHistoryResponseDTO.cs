using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 큐브 히스토리 응답 정보
    /// </summary>
    public class CubeHistoryResponseDTO
    {
        /// <summary>
        /// 결과 건 수
        /// </summary>
        [JsonProperty("count")]
        public int Count;

        /// <summary>
        /// 큐브 히스토리
        /// </summary>
        [JsonProperty("cube_history")]
        public List<CubeHistoryDTO> CubeHistory;

        /// <summary>
        /// 페이징 처리를 위한 cursor
        /// </summary>
        [JsonProperty("next_cursor")]
        public string  NextCursor;
    }
}
