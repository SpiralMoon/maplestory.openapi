using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.TMS.DTO
{
    /// <summary>
    /// 角色已裝備機器人資訊
    /// </summary>
    public class CharacterAndroidEquipmentDTO : Base.CharacterAndroidEquipmentDTO<
        CharacterAndroidEquipmentHairDTO,
        CharacterAndroidEquipmentFaceDTO,
        CharacterAndroidEquipmentSkinDTO,
        CharacterAndroidCashItemEquipmentDTO,
        CharacterAndroidEquipmentPresetDTO>
    {
        /// <summary>
        /// 要搜尋的日期 (TST)
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
        /// 機器人名稱
        /// </summary>
        [JsonProperty("android_name")]
        public override string? AndroidName { get; set; }

        /// <summary>
        /// 機器人暱稱
        /// </summary>
        [JsonProperty("android_nickname")]
        public override string? AndroidNickname { get; set; }

        /// <summary>
        /// 機器人圖示
        /// </summary>
        [JsonProperty("android_icon")]
        public override string? AndroidIcon { get; set; }

        /// <summary>
        /// 機器人道具描述
        /// </summary>
        [JsonProperty("android_description")]
        public override string? AndroidDescription { get; set; }

        /// <summary>
        /// 機器人髮型資訊
        /// </summary>
        [JsonProperty("android_hair")]
        public override CharacterAndroidEquipmentHairDTO? AndroidHair { get; set; }

        /// <summary>
        /// 機器人臉型資訊
        /// </summary>
        [JsonProperty("android_face")]
        public override CharacterAndroidEquipmentFaceDTO? AndroidFace { get; set; }

        /// <summary>
        /// 機器人膚色資訊
        /// </summary>
        [JsonProperty("android_skin")]
        public override CharacterAndroidEquipmentSkinDTO? AndroidSkin { get; set; }

        /// <summary>
        /// 機器人的已裝備現金道具資訊
        /// </summary>
        [JsonProperty("android_cash_item_equipment")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterAndroidCashItemEquipmentDTO> AndroidCashItemEquipment { get; set; } = new();

        /// <summary>
        /// 機器人耳飾感應器
        /// </summary>
        [JsonProperty("android_ear_sensor_clip_flag")]
        public override string? AndroidEarSensorClipFlag { get; set; }

        /// <summary>
        /// 機器人性別
        /// </summary>
        [JsonProperty("android_gender")]
        public override string? AndroidGender { get; set; }

        /// <summary>
        /// 機器人階級
        /// </summary>
        [JsonProperty("android_grade")]
        public override string? AndroidGrade { get; set; }

        /// <summary>
        /// 非人型機器人
        /// </summary>
        [JsonProperty("android_non_humanoid_flag")]
        public override string? AndroidNonHumanoidFlag { get; set; }

        /// <summary>
        /// 是否具備雜貨店功能
        /// </summary>
        [JsonProperty("android_shop_usable_flag")]
        public override string? AndroidShopUsableFlag { get; set; }

        /// <summary>
        /// 目前套用的道具預設編號
        /// </summary>
        [JsonProperty("preset_no")]
        public override int? PresetNo { get; set; }

        /// <summary>
        /// 預設 1 的機器人資訊
        /// </summary>
        [JsonProperty("android_preset_1")]
        public override CharacterAndroidEquipmentPresetDTO? AndroidPreset1 { get; set; }

        /// <summary>
        /// 預設 2 的機器人資訊
        /// </summary>
        [JsonProperty("android_preset_2")]
        public override CharacterAndroidEquipmentPresetDTO? AndroidPreset2 { get; set; }

        /// <summary>
        /// 預設 3 的機器人資訊
        /// </summary>
        [JsonProperty("android_preset_3")]
        public override CharacterAndroidEquipmentPresetDTO? AndroidPreset3 { get; set; }
    }

    /// <summary>
    /// 機器人髮型資訊
    /// </summary>
    public class CharacterAndroidEquipmentHairDTO : Base.CharacterAndroidEquipmentHairDTO
    {
        /// <summary>
        /// 機器人髮型名稱
        /// </summary>
        [JsonProperty("hair_name")]
        public override string? HairName { get; set; }

        /// <summary>
        /// 機器人髮型基本顏色
        /// </summary>
        [JsonProperty("base_color")]
        public override string? BaseColor { get; set; }

        /// <summary>
        /// 機器人髮型混染顏色
        /// </summary>
        [JsonProperty("mix_color")]
        public override string? MixColor { get; set; }

        /// <summary>
        /// 機器人髮型混染顏色比例
        /// </summary>
        [JsonProperty("mix_rate")]
        public override string MixRate { get; set; }
    }

    /// <summary>
    /// 機器人臉型資訊
    /// </summary>
    public class CharacterAndroidEquipmentFaceDTO : Base.CharacterAndroidEquipmentFaceDTO
    {
        /// <summary>
        /// 機器人臉型名稱
        /// </summary>
        [JsonProperty("face_name")]
        public override string? FaceName { get; set; }

        /// <summary>
        /// 機器人臉型基本顏色
        /// </summary>
        [JsonProperty("base_color")]
        public override string? BaseColor { get; set; }

        /// <summary>
        /// 機器人臉型混染顏色
        /// </summary>
        [JsonProperty("mix_color")]
        public override string? MixColor { get; set; }

        /// <summary>
        /// 機器人臉型混染顏色比例
        /// </summary>
        [JsonProperty("mix_rate")]
        public override string MixRate { get; set; }
    }

    /// <summary>
    /// 機器人膚色資訊
    /// </summary>
    public class CharacterAndroidEquipmentSkinDTO : Base.CharacterAndroidEquipmentSkinDTO
    {
        /// <summary>
        /// 膚色名稱
        /// </summary>
        [JsonProperty("skin_name")]
        public override string SkinName { get; set; }

        /// <summary>
        /// 色系
        /// </summary>
        [JsonProperty("color_style")]
        public override string? ColorStyle { get; set; }

        /// <summary>
        /// 膚色色調
        /// </summary>
        [JsonProperty("hue")]
        public override int? Hue { get; set; }

        /// <summary>
        /// 膚色彩度
        /// </summary>
        [JsonProperty("saturation")]
        public override int? Saturation { get; set; }

        /// <summary>
        /// 膚色明度
        /// </summary>
        [JsonProperty("brightness")]
        public override int? Brightness { get; set; }
    }

    /// <summary>
    /// 預設的機器人資訊
    /// </summary>
    public class CharacterAndroidEquipmentPresetDTO : Base.CharacterAndroidEquipmentPresetDTO<CharacterAndroidEquipmentHairDTO, CharacterAndroidEquipmentFaceDTO, CharacterAndroidEquipmentSkinDTO>
    {
        /// <summary>
        /// 機器人名稱
        /// </summary>
        [JsonProperty("android_name")]
        public override string AndroidName { get; set; }

        /// <summary>
        /// 機器人暱稱
        /// </summary>
        [JsonProperty("android_nickname")]
        public override string AndroidNickname { get; set; }

        /// <summary>
        /// 機器人圖示
        /// </summary>
        [JsonProperty("android_icon")]
        public override string AndroidIcon { get; set; }

        /// <summary>
        /// 機器人道具描述
        /// </summary>
        [JsonProperty("android_description")]
        public override string AndroidDescription { get; set; }

        /// <summary>
        /// 機器人性別
        /// </summary>
        [JsonProperty("android_gender")]
        public override string? AndroidGender { get; set; }

        /// <summary>
        /// 機器人階級
        /// </summary>
        [JsonProperty("android_grade")]
        public override string AndroidGrade { get; set; }

        /// <summary>
        /// 機器人髮型資訊
        /// </summary>
        [JsonProperty("android_hair")]
        public override CharacterAndroidEquipmentHairDTO AndroidHair { get; set; }

        /// <summary>
        /// 機器人臉型資訊
        /// </summary>
        [JsonProperty("android_face")]
        public override CharacterAndroidEquipmentFaceDTO AndroidFace { get; set; }

        /// <summary>
        /// 機器人膚色資訊
        /// </summary>
        [JsonProperty("android_skin")]
        public override CharacterAndroidEquipmentSkinDTO? AndroidSkin { get; set; }

        /// <summary>
        /// 機器人耳飾感應器
        /// </summary>
        [JsonProperty("android_ear_sensor_clip_flag")]
        public override string AndroidEarSensorClipFlag { get; set; }

        /// <summary>
        /// 非人型機器人
        /// </summary>
        [JsonProperty("android_non_humanoid_flag")]
        public override string AndroidNonHumanoidFlag { get; set; }

        /// <summary>
        /// 是否具備雜貨店功能
        /// </summary>
        [JsonProperty("android_shop_usable_flag")]
        public override string AndroidShopUsableFlag { get; set; }
    }

    /// <summary>
    /// 機器人現金道具彩色稜鏡資訊
    /// </summary>
    public class CharacterAndroidCashItemEquipmentColoringPrismDTO : Base.CharacterAndroidCashItemEquipmentColoringPrismDTO
    {
        /// <summary>
        /// 彩色稜鏡顏色範圍
        /// </summary>
        [JsonProperty("color_range")]
        public override string ColorRange { get; set; }

        /// <summary>
        /// 彩色稜鏡色調
        /// </summary>
        [JsonProperty("hue")]
        public override long Hue { get; set; }

        /// <summary>
        /// 彩色稜鏡彩度
        /// </summary>
        [JsonProperty("saturation")]
        public override long Saturation { get; set; }

        /// <summary>
        /// 彩色稜鏡明度
        /// </summary>
        [JsonProperty("value")]
        public override long Value { get; set; }
    }

    /// <summary>
    /// 機器人現金道具選項
    /// </summary>
    public class CharacterAndroidCashItemEquipmentOptionDTO : Base.CharacterAndroidCashItemEquipmentOptionDTO
    {
        /// <summary>
        /// 選項類型
        /// </summary>
        [JsonProperty("option_type")]
        public override string OptionType { get; set; }

        /// <summary>
        /// 選項數值
        /// </summary>
        [JsonProperty("option_value")]
        public override string OptionValue { get; set; }
    }

    /// <summary>
    /// 機器人的已裝備現金道具資訊
    /// </summary>
    public class CharacterAndroidCashItemEquipmentDTO : Base.CharacterAndroidCashItemEquipmentDTO<CharacterAndroidCashItemEquipmentOptionDTO, CharacterAndroidCashItemEquipmentColoringPrismDTO>
    {
        /// <summary>
        /// 機器人現金道具部位名稱
        /// </summary>
        [JsonProperty("cash_item_equipment_part")]
        public override string CashItemEquipmentPart { get; set; }

        /// <summary>
        /// 機器人現金道具欄位位置
        /// </summary>
        [JsonProperty("cash_item_equipment_slot")]
        public override string CashItemEquipmentSlot { get; set; }

        /// <summary>
        /// 機器人現金道具名稱
        /// </summary>
        [JsonProperty("cash_item_name")]
        public override string CashItemName { get; set; }

        /// <summary>
        /// 機器人現金道具圖示
        /// </summary>
        [JsonProperty("cash_item_icon")]
        public override string CashItemIcon { get; set; }

        /// <summary>
        /// 機器人現金道具描述
        /// </summary>
        [JsonProperty("cash_item_description")]
        public override string? CashItemDescription { get; set; }

        /// <summary>
        /// 機器人現金道具選項
        /// </summary>
        [JsonProperty("cash_item_option")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterAndroidCashItemEquipmentOptionDTO> CashItemOption { get; set; } = new();

        /// <summary>
        /// 機器人現金道具有效期間 (TST)
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
        /// 機器人現金道具選項有效期間 (TST)
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
        /// 機器人現金道具標籤資訊 (特殊標籤、紅標籤、黑標籤、大師標籤)
        /// </summary>
        [JsonProperty("cash_item_label")]
        public override string? CashItemLabel { get; set; }

        /// <summary>
        /// 機器人現金道具彩色稜鏡資訊
        /// </summary>
        [JsonProperty("cash_item_coloring_prism")]
        public override CharacterAndroidCashItemEquipmentColoringPrismDTO? CashItemColoringPrism { get; set; }

        /// <summary>
        /// 道具可裝備性別
        /// </summary>
        [JsonProperty("android_item_gender")]
        public override string? AndroidItemGender { get; set; }
    }
}
