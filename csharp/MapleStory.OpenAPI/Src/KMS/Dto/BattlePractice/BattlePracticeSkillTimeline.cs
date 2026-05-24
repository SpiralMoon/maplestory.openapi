using Newtonsoft.Json;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 연무장 스킬 사용 내역
    /// </summary>
    public class BattlePracticeSkillTimelineDTO
    {
        /// <summary>
        /// 조회된 페이지 번호
        /// </summary>
        [JsonProperty("page_no")]
        public long PageNo { get; set; }

        /// <summary>
        /// 전체 페이지 번호
        /// </summary>
        [JsonProperty("total_page_no")]
        public long TotalPageNo { get; set; }

        /// <summary>
        /// 스킬 타임라인 정보
        /// </summary>
        [JsonProperty("skill_timeline")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<BattlePracticeSkillTimelineEventDTO> SkillTimeline { get; set; } = new();
    }

    /// <summary>
    /// 연무장 스킬 타임라인
    /// </summary>
    public class BattlePracticeSkillTimelineEventDTO
    {
        /// <summary>
        /// 연무 시작 후 경과 시간 (ms)
        /// </summary>
        [JsonProperty("elapse_time")]
        public long ElapseTime { get; set; }

        /// <summary>
        /// 사용한 스킬 명
        /// </summary>
        [JsonProperty("skill_name")]
        public string SkillName { get; set; }

        /// <summary>
        /// 헥사 스킬 특성 여부 (0:그 외 스킬, 1:오리진 스킬, 2:어센트 스킬)
        /// </summary>
        [JsonProperty("hexa_skill_specificity_flag")]
        public string HexaSkillSpecificityFlag { get; set; }

        /// <summary>
        /// 시퀀스 명
        /// </summary>
        [JsonProperty("sequence_name")]
        public string? SequenceName { get; set; }

        /// <summary>
        /// 시퀀스 키
        /// </summary>
        [JsonProperty("sequence_key")]
        public string? SequenceKey { get; set; }
    }
}
