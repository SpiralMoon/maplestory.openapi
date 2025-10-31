using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 캐릭터 안드로이드 장비 정보
    /// </summary>
    public class CharacterAndroidEquipmentDTO : Base.CharacterAndroidEquipmentDTO<
        CharacterAndroidEquipmentHairDTO,
        CharacterAndroidEquipmentFaceDTO,
        CharacterAndroidEquipmentSkinDTO,
        CharacterAndroidCashItemEquipmentDTO,
        CharacterAndroidEquipmentPresetDTO>
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
        /// 안드로이드 명
        /// </summary>
        [JsonProperty("android_name")]
        public override string? AndroidName { get; set; }

        /// <summary>
        /// 안드로이드 닉네임
        /// </summary>
        [JsonProperty("android_nickname")]
        public override string? AndroidNickname { get; set; }

        /// <summary>
        /// 안드로이드 아이콘
        /// </summary>
        [JsonProperty("android_icon")]
        public override string? AndroidIcon { get; set; }

        /// <summary>
        /// 안드로이드 아이템 설명
        /// </summary>
        [JsonProperty("android_description")]
        public override string? AndroidDescription { get; set; }

        /// <summary>
        /// 안드로이드 헤어 정보
        /// </summary>
        [JsonProperty("android_hair")]
        public override CharacterAndroidEquipmentHairDTO? AndroidHair { get; set; }

        /// <summary>
        /// 안드로이드 성형 정보
        /// </summary>
        [JsonProperty("android_face")]
        public override CharacterAndroidEquipmentFaceDTO? AndroidFace { get; set; }

        /// <summary>
        /// 안드로이드 피부 정보
        /// </summary>
        [JsonProperty("android_skin")]
        public override CharacterAndroidEquipmentSkinDTO? AndroidSkin { get; set; }

        /// <summary>
        /// 안드로이드 캐시 아이템 장착 정보
        /// </summary>
        [JsonProperty("android_cash_item_equipment")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterAndroidCashItemEquipmentDTO> AndroidCashItemEquipment { get; set; } = new();

        /// <summary>
        /// 안드로이드 이어센서 클립 적용 여부
        /// </summary>
        [JsonProperty("android_ear_sensor_clip_flag")]
        public override string? AndroidEarSensorClipFlag { get; set; }

        /// <summary>
        /// 안드로이드 성별
        /// </summary>
        [JsonProperty("android_gender")]
        public override string? AndroidGender { get; set; }

        /// <summary>
        /// 안드로이드 등급
        /// </summary>
        [JsonProperty("android_grade")]
        public override string? AndroidGrade { get; set; }

        /// <summary>
        /// 비인간형 안드로이드 여부
        /// </summary>
        [JsonProperty("android_non_humanoid_flag")]
        public override string? AndroidNonHumanoidFlag { get; set; }

        /// <summary>
        /// 잡화상점 기능 이용 가능 여부
        /// </summary>
        [JsonProperty("android_shop_usable_flag")]
        public override string? AndroidShopUsableFlag { get; set; }

        /// <summary>
        /// 적용 중인 장비 프리셋 번호
        /// </summary>
        [JsonProperty("preset_no")]
        public override int? PresetNo { get; set; }

        /// <summary>
        /// 1번 프리셋 안드로이드 정보
        /// </summary>
        [JsonProperty("android_preset_1")]
        public override CharacterAndroidEquipmentPresetDTO? AndroidPreset1 { get; set; }

        /// <summary>
        /// 2번 프리셋 안드로이드 정보
        /// </summary>
        [JsonProperty("android_preset_2")]
        public override CharacterAndroidEquipmentPresetDTO? AndroidPreset2 { get; set; }

        /// <summary>
        /// 3번 프리셋 안드로이드 정보
        /// </summary>
        [JsonProperty("android_preset_3")]
        public override CharacterAndroidEquipmentPresetDTO? AndroidPreset3 { get; set; }
    }

    /// <summary>
    /// 캐릭터 안드로이드 헤어 정보
    /// </summary>
    public class CharacterAndroidEquipmentHairDTO : Base.CharacterAndroidEquipmentHairDTO
    {
        /// <summary>
        /// 안드로이드 헤어 명
        /// </summary>
        [JsonProperty("hair_name")]
        public override string? HairName { get; set; }

        /// <summary>
        /// 안드로이드 헤어 베이스 컬러
        /// </summary>
        [JsonProperty("base_color")]
        public override string? BaseColor { get; set; }

        /// <summary>
        /// 안드로이드 헤어 믹스 컬러
        /// </summary>
        [JsonProperty("mix_color")]
        public override string? MixColor { get; set; }

        /// <summary>
        /// 안드로이드 헤어 믹스 컬러의 염색 비율
        /// </summary>
        [JsonProperty("mix_rate")]
        public override string MixRate { get; set; }

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

    /// <summary>
    /// 캐릭터 안드로이드 성형 정보
    /// </summary>
    public class CharacterAndroidEquipmentFaceDTO : Base.CharacterAndroidEquipmentFaceDTO
    {
        /// <summary>
        /// 안드로이드 성형 명
        /// </summary>
        [JsonProperty("face_name")]
        public override string? FaceName { get; set; }

        /// <summary>
        /// 안드로이드 성형 베이스 컬러
        /// </summary>
        [JsonProperty("base_color")]
        public override string? BaseColor { get; set; }

        /// <summary>
        /// 안드로이드 성형 믹스 컬러
        /// </summary>
        [JsonProperty("mix_color")]
        public override string? MixColor { get; set; }

        /// <summary>
        /// 안드로이드 성형 믹스 컬러의 염색 비율
        /// </summary>
        [JsonProperty("mix_rate")]
        public override string MixRate { get; set; }

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

    /// <summary>
    /// 캐릭터 안드로이드 피부 정보
    /// </summary>
    public class CharacterAndroidEquipmentSkinDTO : Base.CharacterAndroidEquipmentSkinDTO
    {
        /// <summary>
        /// 피부 명
        /// </summary>
        [JsonProperty("skin_name")]
        public override string SkinName { get; set; }

        /// <summary>
        /// 색상 계열
        /// </summary>
        [JsonProperty("color_style")]
        public override string? ColorStyle { get; set; }

        /// <summary>
        /// 피부 색조
        /// </summary>
        [JsonProperty("hue")]
        public override int? Hue { get; set; }

        /// <summary>
        /// 피부 채도
        /// </summary>
        [JsonProperty("saturation")]
        public override int? Saturation { get; set; }

        /// <summary>
        /// 피부 명도
        /// </summary>
        [JsonProperty("brightness")]
        public override int? Brightness { get; set; }
    }

    /// <summary>
    /// 캐릭터 안드로이드 프리셋 정보
    /// </summary>
    public class CharacterAndroidEquipmentPresetDTO : Base.CharacterAndroidEquipmentPresetDTO<CharacterAndroidEquipmentHairDTO, CharacterAndroidEquipmentFaceDTO, CharacterAndroidEquipmentSkinDTO>
    {
        /// <summary>
        /// 안드로이드 명
        /// </summary>
        [JsonProperty("android_name")]
        public override string AndroidName { get; set; }

        /// <summary>
        /// 안드로이드 닉네임
        /// </summary>
        [JsonProperty("android_nickname")]
        public override string AndroidNickname { get; set; }

        /// <summary>
        /// 안드로이드 아이콘
        /// </summary>
        [JsonProperty("android_icon")]
        public override string AndroidIcon { get; set; }

        /// <summary>
        /// 안드로이드 아이템 설명
        /// </summary>
        [JsonProperty("android_description")]
        public override string AndroidDescription { get; set; }

        /// <summary>
        /// 안드로이드 성별
        /// </summary>
        [JsonProperty("android_gender")]
        public override string? AndroidGender { get; set; }

        /// <summary>
        /// 안드로이드 등급
        /// </summary>
        [JsonProperty("android_grade")]
        public override string AndroidGrade { get; set; }

        /// <summary>
        /// 안드로이드 헤어 정보
        /// </summary>
        [JsonProperty("android_hair")]
        public override CharacterAndroidEquipmentHairDTO AndroidHair { get; set; }

        /// <summary>
        /// 안드로이드 성형 정보
        /// </summary>
        [JsonProperty("android_face")]
        public override CharacterAndroidEquipmentFaceDTO AndroidFace { get; set; }

        /// <summary>
        /// 안드로이드 피부 정보
        /// </summary>
        [JsonProperty("android_skin")]
        public override CharacterAndroidEquipmentSkinDTO? AndroidSkin { get; set; }

        /// <summary>
        /// 안드로이드 이어센서 클립 적용 여부
        /// </summary>
        [JsonProperty("android_ear_sensor_clip_flag")]
        public override string AndroidEarSensorClipFlag { get; set; }

        /// <summary>
        /// 비인간형 안드로이드 여부
        /// </summary>
        [JsonProperty("android_non_humanoid_flag")]
        public override string AndroidNonHumanoidFlag { get; set; }

        /// <summary>
        /// 잡화상점 기능 이용 가능 여부
        /// </summary>
        [JsonProperty("android_shop_usable_flag")]
        public override string AndroidShopUsableFlag { get; set; }
    }

    /// <summary>
    /// 캐릭터 안드로이드 캐시 아이템 컬러링프리즘 정보
    /// </summary>
    public class CharacterAndroidCashItemEquipmentColoringPrismDTO : Base.CharacterAndroidCashItemEquipmentColoringPrismDTO
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
    /// 캐릭터 안드로이드 캐시 아이템 옵션 정보
    /// </summary>
    public class CharacterAndroidCashItemEquipmentOptionDTO : Base.CharacterAndroidCashItemEquipmentOptionDTO
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
    /// 캐릭터 안드로이드 캐시 아이템 장착 정보
    /// </summary>
    public class CharacterAndroidCashItemEquipmentDTO : Base.CharacterAndroidCashItemEquipmentDTO<CharacterAndroidCashItemEquipmentOptionDTO, CharacterAndroidCashItemEquipmentColoringPrismDTO>
    {
        /// <summary>
        /// 안드로이드 캐시 아이템 부위 명
        /// </summary>
        [JsonProperty("cash_item_equipment_part")]
        public override string CashItemEquipmentPart { get; set; }

        /// <summary>
        /// 안드로이드 캐시 아이템 슬롯 위치
        /// </summary>
        [JsonProperty("cash_item_equipment_slot")]
        public override string CashItemEquipmentSlot { get; set; }

        /// <summary>
        /// 안드로이드 캐시 아이템 명
        /// </summary>
        [JsonProperty("cash_item_name")]
        public override string CashItemName { get; set; }

        /// <summary>
        /// 안드로이드 캐시 아이템 아이콘
        /// </summary>
        [JsonProperty("cash_item_icon")]
        public override string CashItemIcon { get; set; }

        /// <summary>
        /// 안드로이드 캐시 아이템 설명
        /// </summary>
        [JsonProperty("cash_item_description")]
        public override string? CashItemDescription { get; set; }

        /// <summary>
        /// 안드로이드 캐시 아이템 옵션
        /// </summary>
        [JsonProperty("cash_item_option")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterAndroidCashItemEquipmentOptionDTO> CashItemOption { get; set; } = new();

        /// <summary>
        /// 안드로이드 캐시 아이템 유효 기간 (KST)
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
        /// 안드로이드 캐시 아이템 유효 기간 만료 여부
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
        /// 안드로이드 캐시 아이템 옵션 유효 기간 (KST)
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
        /// 안드로이드 캐시 아이템 옵션 유효 기간 만료 여부
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
        /// 안드로이드 캐시 아이템 라벨 정보 (스페셜라벨, 레드라벨, 블랙라벨, 마스터라벨)
        /// </summary>
        [JsonProperty("cash_item_label")]
        public override string? CashItemLabel { get; set; }

        /// <summary>
        /// 안드로이드 캐시 아이템 컬러링프리즘 정보
        /// </summary>
        [JsonProperty("cash_item_coloring_prism")]
        public override CharacterAndroidCashItemEquipmentColoringPrismDTO? CashItemColoringPrism { get; set; }

        /// <summary>
        /// 아이템 장착 가능 성별
        /// </summary>
        [JsonProperty("android_item_gender")]
        public override string? AndroidItemGender { get; set; }

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
