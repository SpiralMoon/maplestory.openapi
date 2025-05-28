using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 안드로이드 장비 정보
    /// </summary>
    public class CharacterAndroidEquipmentDTO
    {
        /// <summary>
        /// 조회 기준일 (KST)
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
        /// 안드로이드 명
        /// </summary>
        [JsonProperty("android_name")]
        public string? AndroidName { get; set; }

        /// <summary>
        /// 안드로이드 닉네임
        /// </summary>
        [JsonProperty("android_nickname")]
        public string? AndroidNickname { get; set; }

        /// <summary>
        /// 안드로이드 아이콘
        /// </summary>
        [JsonProperty("android_icon")]
        public string? AndroidIcon { get; set; }

        /// <summary>
        /// 안드로이드 아이템 설명
        /// </summary>
        [JsonProperty("android_description")]
        public string? AndroidDescription { get; set; }

        /// <summary>
        /// 안드로이드 헤어 정보
        /// </summary>
        [JsonProperty("android_hair")]
        public CharacterAndroidEquipmentHairDTO? AndroidHair { get; set; }

        /// <summary>
        /// 안드로이드 성형 정보
        /// </summary>
        [JsonProperty("android_face")]
        public CharacterAndroidEquipmentFaceDTO? AndroidFace { get; set; }

        /// <summary>
        /// 안드로이드 피부 정보
        /// </summary>
        [JsonProperty("android_skin")]
        public CharacterAndroidEquipmentSkinDTO? AndroidSkin { get; set; }

        /// <summary>
        /// 안드로이드 캐시 아이템 장착 정보
        /// </summary>
        [JsonProperty("android_cash_item_equipment")]
        public List<CharacterAndroidCashItemEquipmentDTO> AndroidCashItemEquipment { get; set; }

        /// <summary>
        /// 안드로이드 이어센서 클립 적용 여부
        /// </summary>
        [JsonProperty("android_ear_sensor_clip_flag")]
        public string? AndroidEarSensorClipFlag { get; set; }

        /// <summary>
        /// 안드로이드 성별
        /// </summary>
        [JsonProperty("android_gender")]
        public string? AndroidGender { get; set; }

        /// <summary>
        /// 안드로이드 등급
        /// </summary>
        [JsonProperty("android_grade")]
        public string? AndroidGrade { get; set; }

        /// <summary>
        /// 비인간형 안드로이드 여부
        /// </summary>
        [JsonProperty("android_non_humanoid_flag")]
        public string? AndroidNonHumanoidFlag { get; set; }

        /// <summary>
        /// 잡화상점 기능 이용 가능 여부
        /// </summary>
        [JsonProperty("android_shop_usable_flag")]
        public string? AndroidShopUsableFlag { get; set; }

        /// <summary>
        /// 적용 중인 장비 프리셋 번호
        /// </summary>
        [JsonProperty("preset_no")]
        public int? PresetNo { get; set; }

        /// <summary>
        /// 1번 프리셋 안드로이드 정보
        /// </summary>
        [JsonProperty("android_preset_1")]
        public CharacterAndroidEquipmentPresetDTO? AndroidPreset1 { get; set; }

        /// <summary>
        /// 2번 프리셋 안드로이드 정보
        /// </summary>
        [JsonProperty("android_preset_2")]
        public CharacterAndroidEquipmentPresetDTO? AndroidPreset2 { get; set; }

        /// <summary>
        /// 3번 프리셋 안드로이드 정보
        /// </summary>
        [JsonProperty("android_preset_3")]
        public CharacterAndroidEquipmentPresetDTO? AndroidPreset3 { get; set; }
    }

    /// <summary>
    /// 캐릭터 안드로이드 성형 정보
    /// </summary>
    public class CharacterAndroidEquipmentFaceDTO
    {
        /// <summary>
        /// 안드로이드 성형 명
        /// </summary>
        [JsonProperty("face_name")]
        public string? FaceName { get; set; }

        /// <summary>
        /// 안드로이드 성형 베이스 컬러
        /// </summary>
        [JsonProperty("base_color")]
        public string? BaseColor { get; set; }

        /// <summary>
        /// 안드로이드 성형 믹스 컬러
        /// </summary>
        [JsonProperty("mix_color")]
        public string? MixColor { get; set; }

        /// <summary>
        /// 안드로이드 성형 믹스 컬러의 염색 비율
        /// </summary>
        [JsonProperty("mix_rate")]
        public string MixRate { get; set; }
    }

    /// <summary>
    /// 캐릭터 안드로이드 헤어 정보
    /// </summary>
    public class CharacterAndroidEquipmentHairDTO
    {
        /// <summary>
        /// 안드로이드 헤어 명
        /// </summary>
        [JsonProperty("hair_name")]
        public string? HairName { get; set; }

        /// <summary>
        /// 안드로이드 헤어 베이스 컬러
        /// </summary>
        [JsonProperty("base_color")]
        public string? BaseColor { get; set; }

        /// <summary>
        /// 안드로이드 헤어 믹스 컬러
        /// </summary>
        [JsonProperty("mix_color")]
        public string? MixColor { get; set; }

        /// <summary>
        /// 안드로이드 헤어 믹스 컬러의 염색 비율
        /// </summary>
        [JsonProperty("mix_rate")]
        public string MixRate { get; set; }
    }

    /// <summary>
    /// 캐릭터 안드로이드 피부 정보
    /// </summary>
    public class CharacterAndroidEquipmentSkinDTO
    {
        /// <summary>
        /// 피부 명
        /// </summary>
        [JsonProperty("skin_name")]
        public string SkinName { get; set; }

        /// <summary>
        /// 색상 계열
        /// </summary>
        [JsonProperty("color_style")]
        public string? ColorStyle { get; set; }

        /// <summary>
        /// 피부 색조
        /// </summary>
        [JsonProperty("hue")]
        public int? Hue { get; set; }

        /// <summary>
        /// 피부 채도
        /// </summary>
        [JsonProperty("saturation")]
        public int? Saturation { get; set; }

        /// <summary>
        /// 피부 명도
        /// </summary>
        [JsonProperty("brightness")]
        public int? Brightness { get; set; }
    }

    /// <summary>
    /// 캐릭터 안드로이드 프리셋 정보
    /// </summary>
    public class CharacterAndroidEquipmentPresetDTO
    {
        /// <summary>
        /// 안드로이드 명
        /// </summary>
        [JsonProperty("android_name")]
        public string AndroidName { get; set; }

        /// <summary>
        /// 안드로이드 닉네임
        /// </summary>
        [JsonProperty("android_nickname")]
        public string AndroidNickname { get; set; }

        /// <summary>
        /// 안드로이드 아이콘
        /// </summary>
        [JsonProperty("android_icon")]
        public string AndroidIcon { get; set; }

        /// <summary>
        /// 안드로이드 아이템 설명
        /// </summary>
        [JsonProperty("android_description")]
        public string AndroidDescription { get; set; }

        /// <summary>
        /// 안드로이드 성별
        /// </summary>
        [JsonProperty("android_gender")]
        public string? AndroidGender { get; set; }

        /// <summary>
        /// 안드로이드 등급
        /// </summary>
        [JsonProperty("android_grade")]
        public string AndroidGrade { get; set; }

        /// <summary>
        /// 안드로이드 헤어 정보
        /// </summary>
        [JsonProperty("android_hair")]
        public CharacterAndroidEquipmentHairDTO AndroidHair { get; set; }

        /// <summary>
        /// 안드로이드 성형 정보
        /// </summary>
        [JsonProperty("android_face")]
        public CharacterAndroidEquipmentFaceDTO AndroidFace { get; set; }

        /// <summary>
        /// 안드로이드 피부 정보
        /// </summary>
        [JsonProperty("android_skin")]
        public CharacterAndroidEquipmentSkinDTO? AndroidSkin { get; set; }

        /// <summary>
        /// 안드로이드 이어센서 클립 적용 여부
        /// </summary>
        [JsonProperty("android_ear_sensor_clip_flag")]
        public string AndroidEarSensorClipFlag { get; set; }

        /// <summary>
        /// 비인간형 안드로이드 여부
        /// </summary>
        [JsonProperty("android_non_humanoid_flag")]
        public string AndroidNonHumanoidFlag { get; set; }

        /// <summary>
        /// 잡화상점 기능 이용 가능 여부
        /// </summary>
        [JsonProperty("android_shop_usable_flag")]
        public string AndroidShopUsableFlag { get; set; }
    }

    /// <summary>
    /// 캐릭터 안드로이드 캐시 아이템 컬러링프리즘 정보
    /// </summary>
    public class CharacterAndroidCashItemEquipmentColoringPrismDTO
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
    /// 캐릭터 안드로이드 캐시 아이템 옵션 정보
    /// </summary>
    public class CharacterAndroidCashItemEquipmentOptionDTO
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
        /// 안드로이드 캐시 아이템 유효 기간 만료 여부
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
        /// 안드로이드 캐시 아이템 옵션 유효 기간 (KST)
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
        /// 안드로이드 캐시 아이템 옵션 유효 기간 만료 여부
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
