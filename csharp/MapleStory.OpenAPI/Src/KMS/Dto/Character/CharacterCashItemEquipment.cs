using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 캐릭터 캐시 장비 아이템 정보
    /// </summary>
    public class CharacterCashItemEquipmentDTO : Base.CharacterCashItemEquipmentDTO<CharacterCashItemEquipmentPresetDTO>
    {
        /// <summary>
        /// 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        /// </summary>
        [JsonProperty("date")]
        public override DateTimeOffset? Date
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
        public override string? CharacterGender { get; set; }

        /// <summary>
        /// 캐릭터 직업
        /// </summary>
        [JsonProperty("character_class")]
        public override string? CharacterClass { get; set; }

        /// <summary>
        /// 캐릭터 외형 모드(0:일반 모드, 1:제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드)
        /// </summary>
        [JsonProperty("character_look_mode")]
        public override string? CharacterLookMode { get; set; }

        /// <summary>
        /// 적용 중인 캐시 장비 프리셋 번호
        /// </summary>
        [JsonProperty("preset_no")]
        public override int? PresetNo { get; set; }

        /// <summary>
        /// 장착 중인 캐시 장비
        /// </summary>
        [JsonProperty("cash_item_equipment_base")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterCashItemEquipmentPresetDTO> CashItemEquipmentBase { get; set; } = new();

        /// <summary>
        /// 1번 코디 프리셋
        /// </summary>
        [JsonProperty("cash_item_equipment_preset_1")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterCashItemEquipmentPresetDTO> CashItemEquipmentPreset1 { get; set; } = new();

        /// <summary>
        /// 2번 코디 프리셋
        /// </summary>
        [JsonProperty("cash_item_equipment_preset_2")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterCashItemEquipmentPresetDTO> CashItemEquipmentPreset2 { get; set; } = new();

        /// <summary>
        /// 3번 코디 프리셋
        /// </summary>
        [JsonProperty("cash_item_equipment_preset_3")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterCashItemEquipmentPresetDTO> CashItemEquipmentPreset3 { get; set; } = new();

        /// <summary>
        /// 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드에서 장착 중인 캐시 장비
        /// </summary>
        [JsonProperty("additional_cash_item_equipment_base")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterCashItemEquipmentPresetDTO> AdditionalCashItemEquipmentBase { get; set; } = new();

        /// <summary>
        /// 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드의 1번 코디 프리셋
        /// </summary>
        [JsonProperty("additional_cash_item_equipment_preset_1")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterCashItemEquipmentPresetDTO> AdditionalCashItemEquipmentPreset1 { get; set; } = new();

        /// <summary>
        /// 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드의 2번 코디 프리셋
        /// </summary>
        [JsonProperty("additional_cash_item_equipment_preset_2")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterCashItemEquipmentPresetDTO> AdditionalCashItemEquipmentPreset2 { get; set; } = new();

        /// <summary>
        /// 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드의 3번 코디 프리셋
        /// </summary>
        [JsonProperty("additional_cash_item_equipment_preset_3")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterCashItemEquipmentPresetDTO> AdditionalCashItemEquipmentPreset3 { get; set; } = new();
    }

    /// <summary>
    /// 캐릭터 캐시 장비 컬러링프리즘
    /// </summary>
    public class CharacterCashItemEquipmentColoringPrismDTO : Base.CharacterCashItemEquipmentColoringPrismDTO
    {
        /// <summary>
        /// 컬러링프리즘 색상 범위
        /// </summary>
        [JsonProperty("color_range")]
        public override string ColorRange { get; set; }

        /// <summary>
        /// 컬러링프리즘 색조
        /// </summary>
        [JsonProperty("hue")]
        public override long Hue { get; set; }

        /// <summary>
        /// 컬러링프리즘 채도
        /// </summary>
        [JsonProperty("saturation")]
        public override long Saturation { get; set; }

        /// <summary>
        /// 컬러링프리즘 명도
        /// </summary>
        [JsonProperty("value")]
        public override long Value { get; set; }
    }

    /// <summary>
    /// 캐릭터 캐시 장비 옵션
    /// </summary>
    public class CharacterCashItemEquipmentOptionDTO : Base.CharacterCashItemEquipmentOptionDTO
    {
        /// <summary>
        /// 옵션 타입
        /// </summary>
        [JsonProperty("option_type")]
        public override string OptionType { get; set; }

        /// <summary>
        /// 옵션 값
        /// </summary>
        [JsonProperty("option_value")]
        public override string OptionValue { get; set; }
    }

    /// <summary>
    /// 캐릭터 프리셋 장착 캐시 장비 정보
    /// </summary>
    public class CharacterCashItemEquipmentPresetDTO : Base.CharacterCashItemEquipmentPresetDTO<CharacterCashItemEquipmentOptionDTO, CharacterCashItemEquipmentColoringPrismDTO>
    {
        /// <summary>
        /// 캐시 장비 부위 명
        /// </summary>
        [JsonProperty("cash_item_equipment_part")]
        public override string CashItemEquipmentPart { get; set; }

        /// <summary>
        /// 캐시 장비 슬롯 위치
        /// </summary>
        [JsonProperty("cash_item_equipment_slot")]
        public override string CashItemEquipmentSlot { get; set; }

        /// <summary>
        /// 캐시 장비 명
        /// </summary>
        [JsonProperty("cash_item_name")]
        public override string CashItemName { get; set; }

        /// <summary>
        /// 캐시 장비 아이콘
        /// </summary>
        [JsonProperty("cash_item_icon")]
        public override string CashItemIcon { get; set; }

        /// <summary>
        /// 캐시 장비 설명
        /// </summary>
        [JsonProperty("cash_item_description")]
        public override string? CashItemDescription { get; set; }

        /// <summary>
        /// 캐시 장비 옵션 목록
        /// </summary>
        [JsonProperty("cash_item_option")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterCashItemEquipmentOptionDTO> CashItemOption { get; set; } = new();

        /// <summary>
        /// 캐시 장비 유효 기간 (KST)
        /// </summary>
        public override DateTimeOffset? DateExpire
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
        public override bool? IsExpired
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
        public override DateTimeOffset? DateOptionExpire
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
        public override bool? IsOptionExpired
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
        public override string? CashItemLabel { get; set; }

        /// <summary>
        /// 캐시 장비 컬러링프리즘 정보
        /// </summary>
        [JsonProperty("cash_item_coloring_prism")]
        public override CharacterCashItemEquipmentColoringPrismDTO? CashItemColoringPrism { get; set; }

        /// <summary>
        /// 아이템 장착 가능 성별
        /// </summary>
        [JsonProperty("item_gender")]
        public override string? ItemGender { get; set; }

        /// <summary>
        /// 스킬명
        /// </summary>
        [JsonProperty("skills")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<string> Skills { get; set; } = new();

        /// <summary>
        /// 프리스타일 쿠폰 적용 여부 (0:미적용, 1:적용)
        /// </summary>
        [JsonProperty("freestyle_flag")]
        public string? FreestyleFlag { get; set; }

        /// <summary>
        /// 프리스타일 쿠폰 적용 여부
        /// </summary>
        public bool IsFreestyleFlag
        {
            get => this.FreestyleFlag == "1";
        }
    }
}
