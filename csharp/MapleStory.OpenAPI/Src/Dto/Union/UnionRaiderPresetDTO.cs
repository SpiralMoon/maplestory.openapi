using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 유니온 프리셋 정보
    /// </summary>
    public class UnionRaiderPresetDTO
    {
        /// <summary>
        /// 유니온 공격대원 효과
        /// </summary>
        [JsonProperty("union_raider_stat")]
        public List<string> UnionRaiderStat { get; set; }

        /// <summary>
        /// 유니온 공격대 점령 효과
        /// </summary>
        [JsonProperty("union_occupied_stat")]
        public List<string> UnionOccupiedStat { get; set; }

        /// <summary>
        /// 유니온 공격대 배치
        /// </summary>
        [JsonProperty("union_inner_stat")]
        public List<UnionRaiderInnerStatDTO> UnionInnerStat { get; set; }

        /// <summary>
        /// 유니온 블록 정보
        /// </summary>
        [JsonProperty("union_block")]
        public List<UnionRaiderBlockDTO> UnionBlock { get; set; }
    }
}
