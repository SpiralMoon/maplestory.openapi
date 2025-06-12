using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.MSEA.DTO
{
    /// <summary>
    /// Character cash item equipment information
    /// </summary>
    public class CharacterCashItemEquipmentDTO : Base.CharacterCashItemEquipmentDTO<CharacterCashItemEquipmentPresetDTO>
    {
        /// <summary>
        /// Reference date for query (SGT, daily data with hours and minutes set to 0)
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
        /// Character gender
        /// </summary>
        [JsonProperty("character_gender")]
        public override string? CharacterGender { get; set; }

        /// <summary>
        /// Character job
        /// </summary>
        [JsonProperty("character_class")]
        public override string? CharacterClass { get; set; }

        /// <summary>
        /// Character look mode (0: Normal mode, 1: Beta for Zero or Dress-Up mode for Angelic Buster)
        /// </summary>
        [JsonProperty("character_look_mode")]
        public override string? CharacterLookMode { get; set; }

        /// <summary>
        /// Active cash equipment preset number
        /// </summary>
        [JsonProperty("preset_no")]
        public override int? PresetNo { get; set; }

        /// <summary>
        /// Currently equipped cash items
        /// </summary>
        [JsonProperty("cash_item_equipment_base")]
        public override List<CharacterCashItemEquipmentPresetDTO> CashItemEquipmentBase { get; set; }

        /// <summary>
        /// Cash item preset 1
        /// </summary>
        [JsonProperty("cash_item_equipment_preset_1")]
        public override List<CharacterCashItemEquipmentPresetDTO> CashItemEquipmentPreset1 { get; set; }

        /// <summary>
        /// Cash item preset 2
        /// </summary>
        [JsonProperty("cash_item_equipment_preset_2")]
        public override List<CharacterCashItemEquipmentPresetDTO> CashItemEquipmentPreset2 { get; set; }

        /// <summary>
        /// Cash item preset 3
        /// </summary>
        [JsonProperty("cash_item_equipment_preset_3")]
        public override List<CharacterCashItemEquipmentPresetDTO> CashItemEquipmentPreset3 { get; set; }

        /// <summary>
        /// Currently equipped cash items in Beta (Zero) or Dress-Up (Angelic Buster) mode
        /// </summary>
        [JsonProperty("additional_cash_item_equipment_base")]
        public override List<CharacterCashItemEquipmentPresetDTO> AdditionalCashItemEquipmentBase { get; set; }

        /// <summary>
        /// Cash item preset 1 for Beta (Zero) or Dress-Up (Angelic Buster) mode
        /// </summary>
        [JsonProperty("additional_cash_item_equipment_preset_1")]
        public override List<CharacterCashItemEquipmentPresetDTO> AdditionalCashItemEquipmentPreset1 { get; set; }

        /// <summary>
        /// Cash item preset 2 for Beta (Zero) or Dress-Up (Angelic Buster) mode
        /// </summary>
        [JsonProperty("additional_cash_item_equipment_preset_2")]
        public override List<CharacterCashItemEquipmentPresetDTO> AdditionalCashItemEquipmentPreset2 { get; set; }

        /// <summary>
        /// Cash item preset 3 for Beta (Zero) or Dress-Up (Angelic Buster) mode
        /// </summary>
        [JsonProperty("additional_cash_item_equipment_preset_3")]
        public override List<CharacterCashItemEquipmentPresetDTO> AdditionalCashItemEquipmentPreset3 { get; set; }
    }

    /// <summary>
    /// Cash equipment coloring prism information
    /// </summary>
    public class CharacterCashItemEquipmentColoringPrismDTO : Base.CharacterCashItemEquipmentColoringPrismDTO
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
    /// Cash equipment option
    /// </summary>
    public class CharacterCashItemEquipmentOptionDTO : Base.CharacterCashItemEquipmentOptionDTO
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
    /// Equipped cash item preset information
    /// </summary>
    public class CharacterCashItemEquipmentPresetDTO : Base.CharacterCashItemEquipmentPresetDTO<CharacterCashItemEquipmentOptionDTO, CharacterCashItemEquipmentColoringPrismDTO>
    {
        /// <summary>
        /// Cash equipment part name
        /// </summary>
        [JsonProperty("cash_item_equipment_part")]
        public override string CashItemEquipmentPart { get; set; }

        /// <summary>
        /// Cash equipment slot position
        /// </summary>
        [JsonProperty("cash_item_equipment_slot")]
        public override string CashItemEquipmentSlot { get; set; }

        /// <summary>
        /// Cash equipment name
        /// </summary>
        [JsonProperty("cash_item_name")]
        public override string CashItemName { get; set; }

        /// <summary>
        /// Cash equipment icon
        /// </summary>
        [JsonProperty("cash_item_icon")]
        public override string CashItemIcon { get; set; }

        /// <summary>
        /// Cash equipment description
        /// </summary>
        [JsonProperty("cash_item_description")]
        public override string? CashItemDescription { get; set; }

        /// <summary>
        /// Cash equipment option
        /// </summary>
        [JsonProperty("cash_item_option")]
        public override List<CharacterCashItemEquipmentOptionDTO> CashItemOption { get; set; }

        /// <summary>
        /// Cash equipment validity period (SGT)
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
        /// Cash equipment option validity period (SGT, data with minutes set to 0)
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
        /// Cash equipment label information
        /// </summary>
        [JsonProperty("cash_item_label")]
        public override string? CashItemLabel { get; set; }

        /// <summary>
        /// Cash equipment coloring prism information
        /// </summary>
        [JsonProperty("cash_item_coloring_prism")]
        public override CharacterCashItemEquipmentColoringPrismDTO? CashItemColoringPrism { get; set; }

        /// <summary>
        /// Gender compatibility for item equipment
        /// </summary>
        [JsonProperty("item_gender")]
        public override string? ItemGender { get; set; }
    }

}
