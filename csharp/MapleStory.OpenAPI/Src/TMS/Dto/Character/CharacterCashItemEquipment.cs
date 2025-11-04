using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.TMS.DTO
{
    /// <summary>
    /// 角色已裝備現金道具資訊
    /// </summary>
    public class CharacterCashItemEquipmentDTO : Base.CharacterCashItemEquipmentDTO<CharacterCashItemEquipmentPresetDTO>
    {
        /// <summary>
        /// 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
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
        /// 角色性別
        /// </summary>
        [JsonProperty("character_gender")]
        public override string CharacterGender { get; set; }

        /// <summary>
        /// 角色職業
        /// </summary>
        [JsonProperty("character_class")]
        public override string CharacterClass { get; set; }

        /// <summary>
        /// 角色外型模式 (0：一般模式，1：神之子為 Beta、天使破壞者為變裝模式時)
        /// </summary>
        [JsonProperty("character_look_mode")]
        public override string? CharacterLookMode { get; set; }

        /// <summary>
        /// 目前套用的現金道具預設編號
        /// </summary>
        [JsonProperty("preset_no")]
        public override int PresetNo { get; set; }

        /// <summary>
        /// 目前已裝備的現金道具
        /// </summary>
        [JsonProperty("cash_item_equipment_base")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterCashItemEquipmentPresetDTO> CashItemEquipmentBase { get; set; } = new();

        /// <summary>
        /// 外型預設 1
        /// </summary>
        [JsonProperty("cash_item_equipment_preset_1")]
        public override List<CharacterCashItemEquipmentPresetDTO> CashItemEquipmentPreset1 { get; set; }

        /// <summary>
        /// 外型預設 2
        /// </summary>
        [JsonProperty("cash_item_equipment_preset_2")]
        public override List<CharacterCashItemEquipmentPresetDTO> CashItemEquipmentPreset2 { get; set; }

        /// <summary>
        /// 外型預設 3
        /// </summary>
        [JsonProperty("cash_item_equipment_preset_3")]
        public override List<CharacterCashItemEquipmentPresetDTO> CashItemEquipmentPreset3 { get; set; }

        /// <summary>
        /// 神之子為 Beta 及天使破壞者為變裝模式時的目前已裝備現金道具
        /// </summary>
        [JsonProperty("additional_cash_item_equipment_base")]
        public override List<CharacterCashItemEquipmentPresetDTO> AdditionalCashItemEquipmentBase { get; set; }

        /// <summary>
        /// 神之子為 Beta 及天使破壞者為變裝模式時的外型預設 1
        /// </summary>
        [JsonProperty("additional_cash_item_equipment_preset_1")]
        public override List<CharacterCashItemEquipmentPresetDTO> AdditionalCashItemEquipmentPreset1 { get; set; }

        /// <summary>
        /// 神之子為 Beta 及天使破壞者為變裝模式時的外型預設 2
        /// </summary>
        [JsonProperty("additional_cash_item_equipment_preset_2")]
        public override List<CharacterCashItemEquipmentPresetDTO> AdditionalCashItemEquipmentPreset2 { get; set; }

        /// <summary>
        /// 神之子為 Beta 及天使破壞者為變裝模式時的外型預設 3
        /// </summary>
        [JsonProperty("additional_cash_item_equipment_preset_3")]
        public override List<CharacterCashItemEquipmentPresetDTO> AdditionalCashItemEquipmentPreset3 { get; set; }
    }

    /// <summary>
    /// 現金道具彩色稜鏡資訊
    /// </summary>
    public class CharacterCashItemEquipmentColoringPrismDTO : Base.CharacterCashItemEquipmentColoringPrismDTO
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
    /// 現金道具選項
    /// </summary>
    public class CharacterCashItemEquipmentOptionDTO : Base.CharacterCashItemEquipmentOptionDTO
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
    /// 外型預設
    /// </summary>
    public class CharacterCashItemEquipmentPresetDTO : Base.CharacterCashItemEquipmentPresetDTO<CharacterCashItemEquipmentOptionDTO, CharacterCashItemEquipmentColoringPrismDTO>
    {
        /// <summary>
        /// 現金道具部位名稱
        /// </summary>
        [JsonProperty("cash_item_equipment_part")]
        public override string CashItemEquipmentPart { get; set; }

        /// <summary>
        /// 現金道具欄位位置
        /// </summary>
        [JsonProperty("cash_item_equipment_slot")]
        public override string CashItemEquipmentSlot { get; set; }

        /// <summary>
        /// 現金道具名稱
        /// </summary>
        [JsonProperty("cash_item_name")]
        public override string CashItemName { get; set; }

        /// <summary>
        /// 現金道具圖示
        /// </summary>
        [JsonProperty("cash_item_icon")]
        public override string CashItemIcon { get; set; }

        /// <summary>
        /// 現金道具描述
        /// </summary>
        [JsonProperty("cash_item_description")]
        public override string? CashItemDescription { get; set; }

        /// <summary>
        /// 現金道具選項
        /// </summary>
        [JsonProperty("cash_item_option")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterCashItemEquipmentOptionDTO> CashItemOption { get; set; } = new();

        /// <summary>
        /// 現金道具有效期間 (TST)
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
        /// Whether the cash equipment is expired
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
        /// 現金道具選項有效期間 (TST，時間單位資料中的分鐘顯示為 0)
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
        /// Whether the cash equipment option is expired
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
        /// 現金道具等級資訊
        /// </summary>
        [JsonProperty("cash_item_label")]
        public override string? CashItemLabel { get; set; }

        /// <summary>
        /// 現金道具彩色稜鏡資訊
        /// </summary>
        [JsonProperty("cash_item_coloring_prism")]
        public override CharacterCashItemEquipmentColoringPrismDTO? CashItemColoringPrism { get; set; }

        /// <summary>
        /// 道具可裝備性別
        /// </summary>
        [JsonProperty("item_gender")]
        public override string? ItemGender { get; set; }

        /// <summary>
        /// 技能名稱
        /// </summary>
        [JsonProperty("skills")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<string> Skills { get; set; } = new();
    }

}
