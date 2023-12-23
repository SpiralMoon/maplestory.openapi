using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 펫 장비 아이템 정보
    /// </summary>
    public class CharacterPetEquipmentItemDTO
    {
        /// <summary>
        /// 아이템 명
        /// </summary>
        [JsonProperty("item_name")]
        public string ItemName { get; set; }

        /// <summary>
        /// 아이템 아이콘
        /// </summary>
        [JsonProperty("item_icon")]
        public string ItemIcon { get; set; }

        /// <summary>
        /// 아이템 설명
        /// </summary>
        [JsonProperty("item_description")]
        public string ItemDescription { get; set; }

        /// <summary>
        /// 아이템 표기상 옵션
        /// </summary>
        [JsonProperty("item_option")]
        public List<CharacterPetEquipmentItemOptionDTO> ItemOption { get; set; }

        /// <summary>
        /// 업그레이드 횟수
        /// </summary>
        [JsonProperty("scroll_upgrade")]
        public long ScrollUpgrade { get; set; }

        /// <summary>
        /// 업그레이드 가능 횟수
        /// </summary>
        [JsonProperty("scroll_upgradeable")]
        public long ScrollUpgradeable { get; set; }
    }
}
