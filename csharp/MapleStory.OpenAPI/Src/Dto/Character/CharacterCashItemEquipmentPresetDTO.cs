using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 프리셋 장착 캐시 장비 정보
    /// </summary>
    public class CharacterCashItemEquipmentPresetDTO
    {
        /// <summary>
        /// 캐시 장비 부위 명
        /// </summary>
        [JsonProperty("cash_item_equipment_part")]
        public string CashItemEquipmentPart { get; set; }

        /// <summary>
        /// 캐시 장비 슬롯 위치
        /// </summary>
        [JsonProperty("cash_item_equipment_slot")]
        public string CashItemEquipmentSlot { get; set; }

        /// <summary>
        /// 캐시 장비 명
        /// </summary>
        [JsonProperty("cash_item_name")]
        public string CashItemName { get; set; }

        /// <summary>
        /// 캐시 장비 아이콘
        /// </summary>
        [JsonProperty("cash_item_icon")]
        public string CashItemIcon { get; set; }

        /// <summary>
        /// 캐시 장비 설명
        /// </summary>
        [JsonProperty("cash_item_description")]
        public string? CashItemDescription { get; set; }

        /// <summary>
        /// 캐시 장비 옵션 목록
        /// </summary>
        [JsonProperty("cash_item_option")]
        public List<CharacterCashItemEquipmentOptionDTO> CashItemOption { get; set; }

        /// <summary>
        /// 캐시 장비 유효 기간 (KST)
        /// </summary>
        public DateTimeOffset? DateExpire
        {
            get
            {
                if (_dateExpire != null)
                {
                    return DateTimeOffset.Parse(_dateExpire).ToOffset(TimeSpan.FromHours(9));
                }

                return null;
            }
        }

        [JsonProperty("date_expire")]
        private string? _dateExpire { get; set; }

        /// <summary>
        /// 캐시 장비 옵션 유효 기간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
        /// </summary>
        public DateTimeOffset? DateOptionExpire
        {
            get
            {
                if (_dateOptionExpire != null && _dateOptionExpire != "expired")
                {
                    return DateTimeOffset.Parse(_dateOptionExpire).ToOffset(TimeSpan.FromHours(9));
                }

                return null;
            }
        }

        [JsonProperty("date_option_expire")]
        private string? _dateOptionExpire { get; set; }

        /// <summary>
        /// 캐시 장비 옵션 유효 기간 만료 여부
        /// </summary>
        public bool? IsOptionExpired
        {
            get
            {
                if (_dateOptionExpire == null)
                {
                    return null;
                }

                return _dateOptionExpire == "expired";
            }
        }

        /// <summary>
        /// 캐시 장비 라벨 정보
        /// </summary>
        [JsonProperty("cash_item_label")]
        public string? CashItemLabel { get; set; }

        /// <summary>
        /// 캐시 장비 컬러링프리즘 정보
        /// </summary>
        [JsonProperty("cash_item_coloring_prism")]
        public CharacterCashItemEquipmentColoringPrismDTO? CashItemColoringPrism { get; set; }

        /// <summary>
        /// 다른 프리셋에서 장비 추가 장착 없이 1번 프리셋의 장비 공유를 비활성화 했는지 여부
        /// </summary>
        [JsonProperty("base_preset_item_disable_flag")]
        public string BasePresetItemDisableFlag { get; set; }
    }
}
