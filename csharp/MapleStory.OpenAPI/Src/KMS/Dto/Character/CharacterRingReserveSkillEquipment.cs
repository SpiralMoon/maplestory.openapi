using Newtonsoft.Json;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 캐릭터 예비 특수 반지 장착 정보
    /// </summary>
    public class CharacterRingReserveSkillEquipmentDTO
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
        /// 예비 특수 반지 슬롯에 장착한 특수 반지
        /// </summary>
        [JsonProperty("special_ring_reserve_name")]
        public string? SpecialRingReserveName { get; set; }

        /// <summary>
        /// 예비 특수 반지 슬롯에 장착한 특수 반지 레벨
        /// </summary>
        [JsonProperty("special_ring_reserve_level")]
        public int? SpecialRingReserveLevel { get; set; }

        /// <summary>
        /// 예비 특수 반지 슬롯에 장착한 특수 반지 아이콘
        /// </summary>
        [JsonProperty("special_ring_reserve_icon")]
        public string? SpecialRingReserveIcon { get; set; }

        /// <summary>
        /// 예비 특수 반지 슬롯에 장착한 특수 반지 설명
        /// </summary>
        [JsonProperty("special_ring_reserve_description")]
        public string? SpecialRingReserveDescription { get; set; }
    }
}
