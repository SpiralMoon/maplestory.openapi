using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 캐시 장비 아이템 정보
    /// </summary>
    public class CharacterCashItemEquipmentDTO
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
        /// 캐릭터 성별
        /// </summary>
        [JsonProperty("character_gender")]
        public string? CharacterGender { get; set; }

        /// <summary>
        /// 캐릭터 직업
        /// </summary>
        [JsonProperty("character_class")]
        public string? CharacterClass { get; set; }

        /// <summary>
        /// 캐릭터 외형 모드(0:일반 모드, 1:제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드)
        /// </summary>
        [JsonProperty("character_look_mode")]
        public string? CharacterLookMode { get; set; }

        /// <summary>
        /// 적용 중인 캐시 장비 프리셋 번호
        /// </summary>
        [JsonProperty("preset_no")]
        public int? PresetNo { get; set; }

        /// <summary>
        /// 장착 중인 캐시 장비
        /// </summary>
        [JsonProperty("cash_item_equipment_base")]
        public List<CharacterCashItemEquipmentPresetDTO> CashItemEquipmentBase { get; set; }

        /// <summary>
        /// 1번 코디 프리셋
        /// </summary>
        [JsonProperty("cash_item_equipment_preset_1")]
        public List<CharacterCashItemEquipmentPresetDTO> CashItemEquipmentPreset1 { get; set; }

        /// <summary>
        /// 2번 코디 프리셋
        /// </summary>
        [JsonProperty("cash_item_equipment_preset_2")]
        public List<CharacterCashItemEquipmentPresetDTO> CashItemEquipmentPreset2 { get; set; }

        /// <summary>
        /// 3번 코디 프리셋
        /// </summary>
        [JsonProperty("cash_item_equipment_preset_3")]
        public List<CharacterCashItemEquipmentPresetDTO> CashItemEquipmentPreset3 { get; set; }

        /// <summary>
        /// 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드에서 장착 중인 캐시 장비
        /// </summary>
        [JsonProperty("additional_cash_item_equipment_base")]
        public List<CharacterCashItemEquipmentPresetDTO> AdditionalCashItemEquipmentBase { get; set; }

        /// <summary>
        /// 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드의 1번 코디 프리셋
        /// </summary>
        [JsonProperty("additional_cash_item_equipment_preset_1")]
        public List<CharacterCashItemEquipmentPresetDTO> AdditionalCashItemEquipmentPreset1 { get; set; }

        /// <summary>
        /// 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드의 2번 코디 프리셋
        /// </summary>
        [JsonProperty("additional_cash_item_equipment_preset_2")]
        public List<CharacterCashItemEquipmentPresetDTO> AdditionalCashItemEquipmentPreset2 { get; set; }

        /// <summary>
        /// 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드의 3번 코디 프리셋
        /// </summary>
        [JsonProperty("additional_cash_item_equipment_preset_3")]
        public List<CharacterCashItemEquipmentPresetDTO> AdditionalCashItemEquipmentPreset3 { get; set; }
    }

    /// <summary>
    /// 캐릭터 캐시 장비 컬러링프리즘
    /// </summary>
    public class CharacterCashItemEquipmentColoringPrismDTO
    {
        /// <summary>
        /// 컬러링프리즘 색상 범위
        /// </summary>
        [JsonProperty("color_range")]
        public string ColorRange { get; set; }

        /// <summary>
        /// 컬러링프리즘 색조
        /// </summary>
        [JsonProperty("hue")]
        public long Hue { get; set; }

        /// <summary>
        /// 컬러링프리즘 채도
        /// </summary>
        [JsonProperty("saturation")]
        public long Saturation { get; set; }

        /// <summary>
        /// 컬러링프리즘 명도
        /// </summary>
        [JsonProperty("value")]
        public long Value { get; set; }
    }

    /// <summary>
    /// 캐릭터 캐시 장비 옵션
    /// </summary>
    public class CharacterCashItemEquipmentOptionDTO
    {
        /// <summary>
        /// 옵션 타입
        /// </summary>
        [JsonProperty("option_type")]
        public string OptionType { get; set; }

        /// <summary>
        /// 옵션 값
        /// </summary>
        [JsonProperty("option_value")]
        public string OptionValue { get; set; }
    }

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
                if (_dateExpire != null && _dateExpire != "expired")
                {
                    return DateTimeOffset.Parse(_dateExpire).ToOffset(TimeSpan.FromHours(9));
                }

                return null;
            }
        }

        [JsonProperty("date_expire")]
        private string? _dateExpire { get; set; }

        /// <summary>
        /// 캐시 장비 유효 기간 만료 여부
        /// </summary>
        public bool? IsExpired
        {
            get
            {
                if (_dateExpire == null)
                {
                    return null;
                }

                return _dateExpire == "expired";
            }
        }

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
        /// 아이템 장착 가능 성별
        /// </summary>
        [JsonProperty("item_gender")]
        public string? ItemGender { get; set; }

        /// <summary>
        /// 스킬명
        /// </summary>
        [JsonProperty("skills")]
        public List<string> Skills { get; set; }
    }
}
