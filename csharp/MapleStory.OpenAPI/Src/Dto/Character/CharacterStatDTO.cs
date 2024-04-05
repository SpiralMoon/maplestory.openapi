using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 스탯 정보
    /// </summary>
    public class CharacterStatDTO
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
        /// 캐릭터 직업
        /// </summary>
        [JsonProperty("character_class")]
        public string CharacterClass { get; set; }

        /// <summary>
        /// 현재 스탯 정보
        /// </summary>
        [JsonProperty("final_stat")]
        public List<CharacterFinalStatDTO> FinalStat { get; set; }

        /// <summary>
        /// 잔여 AP
        /// </summary>
        [JsonProperty("remain_ap")]
        public long RemainAp { get; set; }
    }
}
