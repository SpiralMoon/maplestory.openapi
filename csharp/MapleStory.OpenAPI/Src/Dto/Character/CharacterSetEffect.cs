using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 세트 효과 정보
    /// </summary>
    public class CharacterSetEffectDTO
    {
        /// <summary>
        /// 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        /// </summary>
        [JsonProperty("date")]
        public DateTimeOffset? Date
        {
            get
            {
                return _date?.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _date = value;
            }
        }

        private DateTimeOffset? _date;

        /// <summary>
        /// 세트 효과 정보 목록
        /// </summary>
        [JsonProperty("set_effect")]
        public List<CharacterSetEffectSetDTO> SetEffect { get; set; }
    }

    /// <summary>
    /// 적용 중인 세트 효과 정보
    /// </summary>
    public class CharacterSetEffectInfoDTO
    {
        /// <summary>
        /// 세트 효과 레벨 (장비 수)
        /// </summary>
        [JsonProperty("set_count")]
        public int SetCount { get; set; }

        /// <summary>
        /// 세트 효과
        /// </summary>
        [JsonProperty("set_option")]
        public string SetOption { get; set; }
    }

    /// <summary>
    /// 모든 세트 효과 정보
    /// </summary>
    public class CharacterSetEffectOptionFullDTO
    {
        /// <summary>
        /// 세트 효과 레벨 (장비 수)
        /// </summary>
        [JsonProperty("set_count")]
        public int SetCount { get; set; }

        /// <summary>
        /// 세트 효과
        /// </summary>
        [JsonProperty("set_option")]
        public string SetOption { get; set; }
    }

    /// <summary>
    /// 캐릭터 세트 효과 정보
    /// </summary>
    public class CharacterSetEffectSetDTO
    {
        /// <summary>
        /// 세트 효과 명
        /// </summary>
        [JsonProperty("set_name")]
        public string SetName { get; set; }

        /// <summary>
        /// 세트 개수 (럭키 아이템 포함)
        /// </summary>
        [JsonProperty("total_set_count")]
        public long TotalSetCount { get; set; }

        /// <summary>
        /// 적용 중인 세트 효과 정보
        /// </summary>
        [JsonProperty("set_effect_info")]
        public List<CharacterSetEffectInfoDTO> SetEffectInfo { get; set; }

        /// <summary>
        /// 모든 세트 효과 정보
        /// </summary>
        [JsonProperty("set_option_full")]
        public List<CharacterSetEffectOptionFullDTO> SetOptionFull { get; set; }
    }
}
