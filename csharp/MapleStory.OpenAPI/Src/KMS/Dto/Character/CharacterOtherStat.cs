using Newtonsoft.Json;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 캐릭터 기타 능력치 영향 요소 정보
    /// </summary>
    public class CharacterOtherStatDTO
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
        /// 능력치에 영향을 주는 요소 및 스탯 정보
        /// </summary>
        [JsonProperty("other_stat")]
        public List<CharacterOtherStatDetailDTO> OtherStat { get; set; } = new List<CharacterOtherStatDetailDTO>();
    }

    /// <summary>
    /// 능력치에 영향을 주는 요소 및 스탯 정보
    /// </summary>
    public class CharacterOtherStatDetailDTO
    {
        /// <summary>
        /// 스탯 타입
        /// </summary>
        [JsonProperty("other_stat_type")]
        public string OtherStatType { get; set; }

        /// <summary>
        /// 스탯 정보
        /// </summary>
        [JsonProperty("stat_info")]
        public List<CharacterOtherStatInfoDTO> StatInfo { get; set; } = new List<CharacterOtherStatInfoDTO>();
    }

    /// <summary>
    /// 스탯 정보
    /// </summary>
    public class CharacterOtherStatInfoDTO
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