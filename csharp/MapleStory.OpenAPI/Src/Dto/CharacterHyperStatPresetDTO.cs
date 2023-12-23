using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 하이퍼 스탯 프리셋 정보
    /// </summary>
    public class CharacterHyperStatPresetDTO
    {
        /// <summary>
        /// 스탯 종류
        /// </summary>
        [JsonProperty("stat_type")]
        public string StatType { get; set; }

        /// <summary>
        /// 스탯 투자 포인트
        /// </summary>
        [JsonProperty("stat_point")]
        public long StatPoint { get; set; }

        /// <summary>
        /// 스탯 레벨
        /// </summary>
        [JsonProperty("stat_level")]
        public long StatLevel { get; set; }

        /// <summary>
        /// 스탯 상승량
        /// </summary>
        [JsonProperty("stat_increase")]
        public string StatIncrease { get; set; }
    }
}
