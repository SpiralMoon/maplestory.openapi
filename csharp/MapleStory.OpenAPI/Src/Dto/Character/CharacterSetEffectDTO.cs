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
}
