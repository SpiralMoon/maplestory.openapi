using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 어빌리티 정보
    /// </summary>
    public class CharacterAbilityDTO
    {
        /// <summary>
        /// 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        /// </summary>
        [JsonProperty("date")]
        public DateTimeOffset Date
        {
            get
            {
                return _date.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _date = value;
            }
        }

        private DateTimeOffset _date;

        /// <summary>
        /// 어빌리티 등급
        /// </summary>
        [JsonProperty("ability_grade")]
        public string AbilityGrade { get; set; }

        /// <summary>
        /// 어빌리티 정보 리스트
        /// </summary>
        [JsonProperty("ability_info")]
        public List<CharacterAbilityInfoDTO> AbilityInfo { get; set; }

        /// <summary>
        /// 보유 명성치
        /// </summary>
        [JsonProperty("remain_fame")]
        public long RemainFame { get; set; }
    }
}
