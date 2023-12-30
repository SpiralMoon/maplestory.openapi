using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 안드로이드 캐시 아이템 장착 정보
    /// </summary>
    public class CharacterAndroidCashItemEquipmentDTO
    {
        /// <summary>
        /// 안드로이드 캐시 아이템 부위 명
        /// </summary>
        [JsonProperty("cash_item_equipment_part")]
        public string CashItemEquipmentPart { get; set; }

        /// <summary>
        /// 안드로이드 캐시 아이템 슬롯 위치
        /// </summary>
        [JsonProperty("cash_item_equipment_slot")]
        public string CashItemEquipmentSlot { get; set; }

        /// <summary>
        /// 안드로이드 캐시 아이템 명
        /// </summary>
        [JsonProperty("cash_item_name")]
        public string CashItemName { get; set; }

        /// <summary>
        /// 안드로이드 캐시 아이템 아이콘
        /// </summary>
        [JsonProperty("cash_item_icon")]
        public string CashItemIcon { get; set; }

        /// <summary>
        /// 안드로이드 캐시 아이템 설명
        /// </summary>
        [JsonProperty("cash_item_description")]
        public string? CashItemDescription { get; set; }

        /// <summary>
        /// 안드로이드 캐시 아이템 옵션
        /// </summary>
        [JsonProperty("cash_item_option")]
        public List<CharacterAndroidCashItemEquipmentOptionDTO> CashItemOption { get; set; }

        /// <summary>
        /// 안드로이드 캐시 아이템 유효 기간 (KST)
        /// </summary>
        [JsonProperty("date_expire")]
        public string? DateExpire { get; set; }

        /// <summary>
        /// 안드로이드 캐시 아이템 옵션 유효 기간 (KST)
        /// </summary>
        [JsonProperty("date_option_expire")]
        public string? DateOptionExpire { get; set; }

        /// <summary>
        /// 안드로이드 캐시 아이템 라벨 정보 (스페셜라벨, 레드라벨, 블랙라벨, 마스터라벨)
        /// </summary>
        [JsonProperty("cash_item_label")]
        public string? CashItemLabel { get; set; }

        /// <summary>
        /// 안드로이드 캐시 아이템 컬러링프리즘 정보
        /// </summary>
        [JsonProperty("cash_item_coloring_prism")]
        public CharacterAndroidCashItemEquipmentColoringPrismDTO? CashItemColoringPrism { get; set; }
    }
}
