using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 유니온 아티팩트 효과 정보
    /// </summary>
    public class UnionArtifactEffectDTO
    {
        /// <summary>
        /// 아티팩트 효과 명
        /// </summary>
        [JsonProperty("name")]
        public string Name { get; set; }

        /// <summary>
        /// 아티팩트 효과 레벨
        /// </summary>
        [JsonProperty("level")]
        public int Level { get; set; }
    }
}
