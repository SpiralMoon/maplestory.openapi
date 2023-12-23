using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 장비 아이템 상세 정보
    /// </summary>
    public class CharacterItemEquipmentInfoDTO
    {
        /// <summary>
        /// 장비 부위 명
        /// </summary>
        [JsonProperty("item_equipment_part")]
        public string ItemEquipmentPart { get; set; }

        /// <summary>
        /// 장비 슬롯 위치
        /// </summary>
        [JsonProperty("equipment_slot")]
        public string EquipmentSlot { get; set; }

        /// <summary>
        /// 장비 명
        /// </summary>
        [JsonProperty("item_name")]
        public string ItemName { get; set; }

        /// <summary>
        /// 장비 아이콘
        /// </summary>
        [JsonProperty("item_icon")]
        public string ItemIcon { get; set; }

        /// <summary>
        /// 장비 설명
        /// </summary>
        [JsonProperty("item_description")]
        public string ItemDescription { get; set; }

        /// <summary>
        /// 장비 외형
        /// </summary>
        [JsonProperty("item_shape_name")]
        public string ItemShapeName { get; set; }

        /// <summary>
        /// 장비 외형 아이콘
        /// </summary>
        [JsonProperty("item_shape_icon")]
        public string ItemShapeIcon { get; set; }

        /// <summary>
        /// 전용 성별
        /// </summary>
        [JsonProperty("gender")]
        public string Gender { get; set; }

        /// <summary>
        /// 장비 최종 옵션 정보
        /// </summary>
        [JsonProperty("item_total_option")]
        public CharacterItemEquipmentTotalOptionDTO ItemTotalOption { get; set; }

        /// <summary>
        /// 장비 기본 옵션 정보
        /// </summary>
        [JsonProperty("item_base_option")]
        public CharacterItemEquipmentBaseOptionDTO ItemBaseOption { get; set; }

        /// <summary>
        /// 착용 레벨 증가
        /// </summary>
        [JsonProperty("equipment_level_increase")]
        public long EquipmentLevelIncrease { get; set; }

        /// <summary>
        /// 장비 특별 옵션 정보
        /// </summary>
        [JsonProperty("item_exceptional_option")]
        public CharacterItemEquipmentExceptionalOptionDTO ItemExceptionalOption { get; set; }

        /// <summary>
        /// 장비 추가 옵션 정보
        /// </summary>
        [JsonProperty("item_add_option")]
        public CharacterItemEquipmentAddOptionDTO ItemAddOption { get; set; }

        /// <summary>
        /// 성장 경험치
        /// </summary>
        [JsonProperty("growth_exp")]
        public long GrowthExp { get; set; }

        /// <summary>
        /// 성장 레벨
        /// </summary>
        [JsonProperty("growth_level")]
        public long GrowthLevel { get; set; }

        /// <summary>
        /// 업그레이드 횟수
        /// </summary>
        [JsonProperty("scroll_upgrade")]
        public string ScrollUpgrade { get; set; }

        /// <summary>
        /// 가위 사용 가능 횟수 (교환 불가 장비, 가위 횟수가 없는 교환 가능 장비는 255)
        /// </summary>
        [JsonProperty("cuttable_count")]
        public string CuttableCount { get; set; }

        /// <summary>
        /// 황금 망치 재련 적용 (1:적용, 이외 미 적용)
        /// </summary>
        [JsonProperty("golden_hammer_flag")]
        public string GoldenHammerFlag { get; set; }

        /// <summary>
        /// 복구 가능 횟수
        /// </summary>
        [JsonProperty("scroll_resilience_count")]
        public string ScrollResilienceCount { get; set; }

        /// <summary>
        /// 업그레이드 가능 횟수
        /// </summary>
        [JsonProperty("scroll_upgradeable_count")]
        public string ScrollUpgradeableCount { get; set; }

        /// <summary>
        /// 소울 명
        /// </summary>
        [JsonProperty("soul_name")]
        public string SoulName { get; set; }

        /// <summary>
        /// 소울 옵션
        /// </summary>
        [JsonProperty("soul_option")]
        public string SoulOption { get; set; }

        /// <summary>
        /// 장비 기타 옵션 정보
        /// </summary>
        [JsonProperty("item_etc_option")]
        public CharacterItemEquipmentEtcOptionDTO ItemEtcOption { get; set; }

        /// <summary>
        /// 강화 단계
        /// </summary>
        [JsonProperty("starforce")]
        public string Starforce { get; set; }

        /// <summary>
        /// 놀라운 장비 강화 주문서 사용 여부 (0:미사용, 1:사용)
        /// </summary>
        [JsonProperty("starforce_scroll_flag")]
        public string StarforceScrollFlag { get; set; }

        /// <summary>
        /// 장비 스타포스 옵션 정보
        /// </summary>
        [JsonProperty("item_starforce_option")]
        public CharacterItemEquipmentStarforceOptionDTO ItemStarforceOption { get; set; }

        /// <summary>
        /// 특수 반지 레벨
        /// </summary>
        [JsonProperty("special_ring_level")]
        public long SpecialRingLevel { get; set; }

        /// <summary>
        /// 장비 유효 기간(KST)
        /// </summary>
        [JsonProperty("date_expire")]
        public string DateExpire { get; set; }
    }
}
