using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.MSEA.DTO
{
    /// <summary>
    /// Character android equipment information
    /// </summary>
    public class CharacterAndroidEquipmentDTO : Base.CharacterAndroidEquipmentDTO<
        CharacterAndroidEquipmentHairDTO,
        CharacterAndroidEquipmentFaceDTO,
        CharacterAndroidEquipmentSkinDTO,
        CharacterAndroidCashItemEquipmentDTO,
        CharacterAndroidEquipmentPresetDTO>
    {
        /// <summary>
        /// Reference date for query (SGT)
        /// </summary>
        [JsonProperty("date")]
        public override DateTimeOffset? Date
        {
            get
            {
                return _date?.ToOffset(TimeSpan.FromHours(8));
            }
            set
            {
                _date = value;
            }
        }

        private DateTimeOffset? _date;

        /// <summary>
        /// Android name
        /// </summary>
        [JsonProperty("android_name")]
        public override string? AndroidName { get; set; }

        /// <summary>
        /// Android nickname
        /// </summary>
        [JsonProperty("android_nickname")]
        public override string? AndroidNickname { get; set; }

        /// <summary>
        /// Android icon
        /// </summary>
        [JsonProperty("android_icon")]
        public override string? AndroidIcon { get; set; }

        /// <summary>
        /// Android item description
        /// </summary>
        [JsonProperty("android_description")]
        public override string? AndroidDescription { get; set; }

        /// <summary>
        /// Android hair information
        /// </summary>
        [JsonProperty("android_hair")]
        public override CharacterAndroidEquipmentHairDTO? AndroidHair { get; set; }

        /// <summary>
        /// Android face information
        /// </summary>
        [JsonProperty("android_face")]
        public override CharacterAndroidEquipmentFaceDTO? AndroidFace { get; set; }

        /// <summary>
        /// Android skin information
        /// </summary>
        [JsonProperty("android_skin")]
        public override CharacterAndroidEquipmentSkinDTO? AndroidSkin { get; set; }

        /// <summary>
        /// Android cash item equipment information
        /// </summary>
        [JsonProperty("android_cash_item_equipment")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterAndroidCashItemEquipmentDTO> AndroidCashItemEquipment { get; set; } = new();

        /// <summary>
        /// Whether the Android has an ear sensor clip applied
        /// </summary>
        [JsonProperty("android_ear_sensor_clip_flag")]
        public override string? AndroidEarSensorClipFlag { get; set; }

        /// <summary>
        /// Android gender
        /// </summary>
        [JsonProperty("android_gender")]
        public override string? AndroidGender { get; set; }

        /// <summary>
        /// Android grade
        /// </summary>
        [JsonProperty("android_grade")]
        public override string? AndroidGrade { get; set; }

        /// <summary>
        /// Whether the Android is non-humanoid
        /// </summary>
        [JsonProperty("android_non_humanoid_flag")]
        public override string? AndroidNonHumanoidFlag { get; set; }

        /// <summary>
        /// Whether the Android can use shop functions
        /// </summary>
        [JsonProperty("android_shop_usable_flag")]
        public override string? AndroidShopUsableFlag { get; set; }

        /// <summary>
        /// Active equipment preset number
        /// </summary>
        [JsonProperty("preset_no")]
        public override int? PresetNo { get; set; }

        /// <summary>
        /// Android preset information for preset 1
        /// </summary>
        [JsonProperty("android_preset_1")]
        public override CharacterAndroidEquipmentPresetDTO? AndroidPreset1 { get; set; }

        /// <summary>
        /// Android preset information for preset 2
        /// </summary>
        [JsonProperty("android_preset_2")]
        public override CharacterAndroidEquipmentPresetDTO? AndroidPreset2 { get; set; }

        /// <summary>
        /// Android preset information for preset 3
        /// </summary>
        [JsonProperty("android_preset_3")]
        public override CharacterAndroidEquipmentPresetDTO? AndroidPreset3 { get; set; }
    }

    /// <summary>
    /// Android hair information
    /// </summary>
    public class CharacterAndroidEquipmentHairDTO : Base.CharacterAndroidEquipmentHairDTO
    {
        /// <summary>
        /// Android hair name
        /// </summary>
        [JsonProperty("hair_name")]
        public override string? HairName { get; set; }

        /// <summary>
        /// Android hair base color
        /// </summary>
        [JsonProperty("base_color")]
        public override string? BaseColor { get; set; }

        /// <summary>
        /// Android hair mix color
        /// </summary>
        [JsonProperty("mix_color")]
        public override string? MixColor { get; set; }

        /// <summary>
        /// Dyeing ratio of the Android hair mix color
        /// </summary>
        [JsonProperty("mix_rate")]
        public override string MixRate { get; set; }

        /// <summary>
        /// Freestyle Coupon application status (0:not applied, 1:applied)
        /// </summary>
        [JsonProperty("freestyle_flag")]
        public override string? FreestyleFlag { get; set; }

        /// <summary>
        /// Freestyle Coupon application status
        /// </summary>
        public bool IsFreestyleFlag
        {
            get => this.FreestyleFlag == "1";
        }
    }

    /// <summary>
    /// Android face information
    /// </summary>
    public class CharacterAndroidEquipmentFaceDTO : Base.CharacterAndroidEquipmentFaceDTO
    {
        /// <summary>
        /// Android face name
        /// </summary>
        [JsonProperty("face_name")]
        public override string? FaceName { get; set; }

        /// <summary>
        /// Android face base color
        /// </summary>
        [JsonProperty("base_color")]
        public override string? BaseColor { get; set; }

        /// <summary>
        /// Android face mix color
        /// </summary>
        [JsonProperty("mix_color")]
        public override string? MixColor { get; set; }

        /// <summary>
        /// Dyeing ratio of the Android face mix color
        /// </summary>
        [JsonProperty("mix_rate")]
        public override string MixRate { get; set; }

        /// <summary>
        /// Freestyle Coupon application status (0:not applied, 1:applied)
        /// </summary>
        [JsonProperty("freestyle_flag")]
        public override string? FreestyleFlag { get; set; }

        /// <summary>
        /// Freestyle Coupon application status
        /// </summary>
        public bool IsFreestyleFlag
        {
            get => this.FreestyleFlag == "1";
        }
    }

    /// <summary>
    /// Android skin information
    /// </summary>
    public class CharacterAndroidEquipmentSkinDTO : Base.CharacterAndroidEquipmentSkinDTO
    {
        /// <summary>
        /// Skin name
        /// </summary>
        [JsonProperty("skin_name")]
        public override string SkinName { get; set; }

        /// <summary>
        /// Color style
        /// </summary>
        [JsonProperty("color_style")]
        public override string? ColorStyle { get; set; }

        /// <summary>
        /// Skin hue
        /// </summary>
        [JsonProperty("hue")]
        public override int? Hue { get; set; }

        /// <summary>
        /// Skin saturation
        /// </summary>
        [JsonProperty("saturation")]
        public override int? Saturation { get; set; }

        /// <summary>
        /// Skin brightness
        /// </summary>
        [JsonProperty("brightness")]
        public override int? Brightness { get; set; }
    }

    /// <summary>
    /// Android preset information
    /// </summary>
    public class CharacterAndroidEquipmentPresetDTO : Base.CharacterAndroidEquipmentPresetDTO<CharacterAndroidEquipmentHairDTO, CharacterAndroidEquipmentFaceDTO, CharacterAndroidEquipmentSkinDTO>
    {
        /// <summary>
        /// Android name
        /// </summary>
        [JsonProperty("android_name")]
        public override string AndroidName { get; set; }

        /// <summary>
        /// Android nickname
        /// </summary>
        [JsonProperty("android_nickname")]
        public override string AndroidNickname { get; set; }

        /// <summary>
        /// Android icon
        /// </summary>
        [JsonProperty("android_icon")]
        public override string AndroidIcon { get; set; }

        /// <summary>
        /// Android item description
        /// </summary>
        [JsonProperty("android_description")]
        public override string AndroidDescription { get; set; }

        /// <summary>
        /// Android gender
        /// </summary>
        [JsonProperty("android_gender")]
        public override string? AndroidGender { get; set; }

        /// <summary>
        /// Android grade
        /// </summary>
        [JsonProperty("android_grade")]
        public override string AndroidGrade { get; set; }

        /// <summary>
        /// Android hair information
        /// </summary>
        [JsonProperty("android_hair")]
        public override CharacterAndroidEquipmentHairDTO AndroidHair { get; set; }

        /// <summary>
        /// Android face information
        /// </summary>
        [JsonProperty("android_face")]
        public override CharacterAndroidEquipmentFaceDTO AndroidFace { get; set; }

        /// <summary>
        /// Android skin information
        /// </summary>
        [JsonProperty("android_skin")]
        public override CharacterAndroidEquipmentSkinDTO? AndroidSkin { get; set; }

        /// <summary>
        /// Whether the Android has an ear sensor clip applied
        /// </summary>
        [JsonProperty("android_ear_sensor_clip_flag")]
        public override string AndroidEarSensorClipFlag { get; set; }

        /// <summary>
        /// Whether the Android is non-humanoid
        /// </summary>
        [JsonProperty("android_non_humanoid_flag")]
        public override string AndroidNonHumanoidFlag { get; set; }

        /// <summary>
        /// Whether the Android can use shop functions
        /// </summary>
        [JsonProperty("android_shop_usable_flag")]
        public override string AndroidShopUsableFlag { get; set; }
    }

    /// <summary>
    /// Android cash item coloring prism information
    /// </summary>
    public class CharacterAndroidCashItemEquipmentColoringPrismDTO : Base.CharacterAndroidCashItemEquipmentColoringPrismDTO
    {
        /// <summary>
        /// Coloring prism color range
        /// </summary>
        [JsonProperty("color_range")]
        public override string ColorRange { get; set; }

        /// <summary>
        /// Coloring prism hue
        /// </summary>
        [JsonProperty("hue")]
        public override long Hue { get; set; }

        /// <summary>
        /// Coloring prism saturation
        /// </summary>
        [JsonProperty("saturation")]
        public override long Saturation { get; set; }

        /// <summary>
        /// Coloring prism brightness
        /// </summary>
        [JsonProperty("value")]
        public override long Value { get; set; }
    }

    /// <summary>
    /// Android cash item option information
    /// </summary>
    public class CharacterAndroidCashItemEquipmentOptionDTO : Base.CharacterAndroidCashItemEquipmentOptionDTO
    {
        /// <summary>
        /// Option type
        /// </summary>
        [JsonProperty("option_type")]
        public override string OptionType { get; set; }

        /// <summary>
        /// Option value
        /// </summary>
        [JsonProperty("option_value")]
        public override string OptionValue { get; set; }
    }

    /// <summary>
    /// Android cash item equipment information
    /// </summary>
    public class CharacterAndroidCashItemEquipmentDTO : Base.CharacterAndroidCashItemEquipmentDTO<CharacterAndroidCashItemEquipmentOptionDTO, CharacterAndroidCashItemEquipmentColoringPrismDTO>
    {
        /// <summary>
        /// Android cash item part name
        /// </summary>
        [JsonProperty("cash_item_equipment_part")]
        public override string CashItemEquipmentPart { get; set; }

        /// <summary>
        /// Android cash item slot position
        /// </summary>
        [JsonProperty("cash_item_equipment_slot")]
        public override string CashItemEquipmentSlot { get; set; }

        /// <summary>
        /// Android cash item name
        /// </summary>
        [JsonProperty("cash_item_name")]
        public override string CashItemName { get; set; }

        /// <summary>
        /// Android cash item icon
        /// </summary>
        [JsonProperty("cash_item_icon")]
        public override string CashItemIcon { get; set; }

        /// <summary>
        /// Android cash item description
        /// </summary>
        [JsonProperty("cash_item_description")]
        public override string? CashItemDescription { get; set; }

        /// <summary>
        /// Android cash item options
        /// </summary>
        [JsonProperty("cash_item_option")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterAndroidCashItemEquipmentOptionDTO> CashItemOption { get; set; } = new();

        /// <summary>
        /// Android cash item validity period (SGT)
        /// </summary>
        public override DateTimeOffset? DateExpire
        {
            get
            {
                if (_dateExpire != null && _dateExpire != "expired")
                {
                    return DateTimeOffset.Parse(_dateExpire).ToOffset(TimeSpan.FromHours(8));
                }
                return null;
            }
        }

        [JsonProperty("date_expire")]
        private string? _dateExpire { get; set; }

        /// <summary>
        /// Whether the Android cash item is expired
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
        /// Android cash item option validity period (SGT)
        /// </summary>
        public override DateTimeOffset? DateOptionExpire
        {
            get
            {
                if (_dateOptionExpire != null && _dateOptionExpire != "expired")
                {
                    return DateTimeOffset.Parse(_dateOptionExpire).ToOffset(TimeSpan.FromHours(8));
                }
                return null;
            }
        }

        [JsonProperty("date_option_expire")]
        private string? _dateOptionExpire { get; set; }

        /// <summary>
        /// Whether the Android cash item option is expired
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
        /// Android cash item label information (e.g., Special Label, Red Label, Black Label, Master Label)
        /// </summary>
        [JsonProperty("cash_item_label")]
        public override string? CashItemLabel { get; set; }

        /// <summary>
        /// Android cash item coloring prism information
        /// </summary>
        [JsonProperty("cash_item_coloring_prism")]
        public override CharacterAndroidCashItemEquipmentColoringPrismDTO? CashItemColoringPrism { get; set; }

        /// <summary>
        /// Gender compatibility for item equipment
        /// </summary>
        [JsonProperty("android_item_gender")]
        public override string? AndroidItemGender { get; set; }

        /// <summary>
        /// Freestyle Coupon application status (0:not applied, 1:applied)
        /// </summary>
        [JsonProperty("freestyle_flag")]
        public override string? FreestyleFlag { get; set; }

        /// <summary>
        /// Freestyle Coupon application status
        /// </summary>
        public bool IsFreestyleFlag
        {
            get => this.FreestyleFlag == "1";
        }
    }
}
