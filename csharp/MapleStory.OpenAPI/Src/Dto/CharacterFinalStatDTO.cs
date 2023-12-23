using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 최종 스탯 정보
    /// </summary>
    public class CharacterFinalStatDTO
    {
        /// <summary>
        /// 스탯 명
        /// </summary>
        [JsonProperty("stat_name")]
        public string StatName { get; set; }

        /// <summary>
        /// 스탯 값
        /// </summary>
        [JsonProperty("stat_value")]
        public string StatValue { get; set; }
    }
}
