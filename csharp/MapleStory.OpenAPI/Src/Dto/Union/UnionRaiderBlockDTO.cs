using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 유니온 블록 정보
    /// </summary>
    public class UnionRaiderBlockDTO
    {
        /// <summary>
        /// 블록 모양 (전사, 마법사, 궁수, 도적, 해적, 메이플m, 하이브리드)
        /// </summary>
        [JsonProperty("block_type")]
        public string BlockType { get; set; }

        /// <summary>
        /// 블록 해당 캐릭터 직업
        /// </summary>
        [JsonProperty("block_class")]
        public string BlockClass { get; set; }

        /// <summary>
        /// 블록 해당 캐릭터 레벨
        /// </summary>
        [JsonProperty("block_level")]
        public string BlockLevel { get; set; }

        /// <summary>
        /// 블록 기준점 좌표
        /// </summary>
        [JsonProperty("block_control_point")]
        public UnionRaiderBlockControlPointDTO BlockControlPoint { get; set; }

        /// <summary>
        /// 블록이 차지하고 있는 영역 좌표들 (null:미 배치 시)
        /// </summary>
        [JsonProperty("block_position")]
        public List<UnionRaiderBlockPositionDTO> BlockPosition { get; set; }
    }
}
