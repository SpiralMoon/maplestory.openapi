using Newtonsoft.Json;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 캐릭터 링 익스체인지 스킬 등록 장비 정보
    /// </summary>
    public class CharacterRingExchangeSkillEquipmentDTO
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
        public string? CharacterClass { get; set; }

        /// <summary>
        /// 링 익스체인지에 등록된 특수 반지
        /// </summary>
        [JsonProperty("special_ring_exchange_name")]
        public string? SpecialRingExchangeName { get; set; }

        /// <summary>
        /// 링 익스체인지에 등록된 특수 반지 레벨
        /// </summary>
        [JsonProperty("special_ring_exchange_level")]
        public int? SpecialRingExchangeLevel { get; set; }

        /// <summary>
        /// 링 익스체인지에 등록된 특수 반지 아이콘
        /// </summary>
        [JsonProperty("special_ring_exchange_icon")]
        public string? SpecialRingExchangeIcon { get; set; }

        /// <summary>
        /// 링 익스체인지에 등록된 특수 반지 설명
        /// </summary>
        [JsonProperty("special_ring_exchange_description")]
        public string? SpecialRingExchangeDescription { get; set; }
    }
}
