using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 잠재능력 재설정 히스토리 응답 정보
    /// </summary>
    public class PotentialHistoryResponseDTO
    {
        /// <summary>
        /// 결과 건 수
        /// </summary>
        [JsonProperty("count")]
        public int Count;

        /// <summary>
        /// 잠재능력 재설정 히스토리
        /// </summary>
        [JsonProperty("potential_history")]
        public List<PotentialHistoryDTO> PotentialHistory;

        /// <summary>
        /// 페이징 처리를 위한 cursor
        /// </summary>
        [JsonProperty("next_cursor")]
        public string?  NextCursor;
    }
}
