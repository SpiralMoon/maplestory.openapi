using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.TMS.DTO
{
    /// <summary>
    /// 角色已裝備寵物資訊
    /// </summary>
    public class CharacterPetEquipmentDTO : Base.CharacterPetEquipmentDTO<CharacterPetEquipmentItemDTO, CharacterPetEquipmentAutoSkillDTO>
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
        /// 寵物 1 名稱
        /// </summary>
        [JsonProperty("pet_1_name")]
        public override string? Pet1Name { get; set; }

        /// <summary>
        /// 寵物 1 暱稱
        /// </summary>
        [JsonProperty("pet_1_nickname")]
        public override string? Pet1Nickname { get; set; }

        /// <summary>
        /// 寵物 1 圖示
        /// </summary>
        [JsonProperty("pet_1_icon")]
        public override string? Pet1Icon { get; set; }

        /// <summary>
        /// 寵物 1 描述
        /// </summary>
        [JsonProperty("pet_1_description")]
        public override string? Pet1Description { get; set; }

        /// <summary>
        /// 寵物 1 道具資訊
        /// </summary>
        [JsonProperty("pet_1_equipment")]
        public override CharacterPetEquipmentItemDTO? Pet1Equipment { get; set; }

        /// <summary>
        /// 寵物 1 的寵物自動加持技能資訊
        /// </summary>
        [JsonProperty("pet_1_auto_skill")]
        public override CharacterPetEquipmentAutoSkillDTO? Pet1AutoSkill { get; set; }

        /// <summary>
        /// 寵物 1 神奇寵物類型
        /// </summary>
        [JsonProperty("pet_1_pet_type")]
        public override string? Pet1PetType { get; set; }

        /// <summary>
        /// 寵物 1 技能
        /// </summary>
        [JsonProperty("pet_1_skill")]
        public override List<string> Pet1Skill { get; set; }

        /// <summary>
        /// 寵物 1 魔法時間 (TST，時間單位資料中的分鐘顯示為 0)
        /// </summary>
        public override DateTimeOffset? Pet1DateExpire
        {
            get
            {
                if (_pet1DateExpire != null && _pet1DateExpire != "expired")
                {
                    return DateTimeOffset.Parse(_pet1DateExpire).ToOffset(TimeSpan.FromHours(8));
                }

                return null;
            }
        }

        [JsonProperty("pet_1_date_expire")]
        private string? _pet1DateExpire;

        /// <summary>
        /// Whether the magic time for pet 1 is expired
        /// </summary>
        public override bool? Pet1Expired
        {
            get
            {
                if (_pet1DateExpire == null)
                {
                    return null;
                }

                return _pet1DateExpire == "expired";
            }
        }

        /// <summary>
        /// 寵物 1 外型
        /// </summary>
        [JsonProperty("pet_1_appearance")]
        public override string? Pet1Appearance { get; set; }

        /// <summary>
        /// 寵物 1 外型圖示
        /// </summary>
        [JsonProperty("pet_1_appearance_icon")]
        public override string? Pet1AppearanceIcon { get; set; }

        /// <summary>
        /// 寵物 2 名稱
        /// </summary>
        [JsonProperty("pet_2_name")]
        public override string? Pet2Name { get; set; }

        /// <summary>
        /// 寵物 2 暱稱
        /// </summary>
        [JsonProperty("pet_2_nickname")]
        public override string? Pet2Nickname { get; set; }

        /// <summary>
        /// 寵物 2 圖示
        /// </summary>
        [JsonProperty("pet_2_icon")]
        public override string? Pet2Icon { get; set; }

        /// <summary>
        /// 寵物 2 描述
        /// </summary>
        [JsonProperty("pet_2_description")]
        public override string? Pet2Description { get; set; }

        /// <summary>
        /// 寵物 2 道具資訊
        /// </summary>
        [JsonProperty("pet_2_equipment")]
        public override CharacterPetEquipmentItemDTO? Pet2Equipment { get; set; }

        /// <summary>
        /// 寵物 2 的寵物自動加持技能資訊
        /// </summary>
        [JsonProperty("pet_2_auto_skill")]
        public override CharacterPetEquipmentAutoSkillDTO? Pet2AutoSkill { get; set; }

        /// <summary>
        /// 寵物 2 神奇寵物類型
        /// </summary>
        [JsonProperty("pet_2_pet_type")]
        public override string? Pet2PetType { get; set; }

        /// <summary>
        /// 寵物 2 技能
        /// </summary>
        [JsonProperty("pet_2_skill")]
        public override List<string> Pet2Skill { get; set; }

        /// <summary>
        /// 寵物 2 魔法時間 (TST，時間單位資料中的分鐘顯示為 0)
        /// </summary>
        public override DateTimeOffset? Pet2DateExpire
        {
            get
            {
                if (_pet2DateExpire != null && _pet2DateExpire != "expired")
                {
                    return DateTimeOffset.Parse(_pet2DateExpire).ToOffset(TimeSpan.FromHours(8));
                }

                return null;
            }
        }

        [JsonProperty("pet_2_date_expire")]
        private string? _pet2DateExpire;

        /// <summary>
        /// Whether the magic time for pet 2 is expired
        /// </summary>
        public override bool? Pet2Expired
        {
            get
            {
                if (_pet2DateExpire == null)
                {
                    return null;
                }

                return _pet2DateExpire == "expired";
            }
        }

        /// <summary>
        /// 寵物 2 外型
        /// </summary>
        [JsonProperty("pet_2_appearance")]
        public override string? Pet2Appearance { get; set; }

        /// <summary>
        /// 寵物 2 外型圖示
        /// </summary>
        [JsonProperty("pet_2_appearance_icon")]
        public override string? Pet2AppearanceIcon { get; set; }

        /// <summary>
        /// 寵物 3 名稱
        /// </summary>
        [JsonProperty("pet_3_name")]
        public override string? Pet3Name { get; set; }

        /// <summary>
        /// 寵物 3 暱稱
        /// </summary>
        [JsonProperty("pet_3_nickname")]
        public override string? Pet3Nickname { get; set; }

        /// <summary>
        /// 寵物 3 圖示
        /// </summary>
        [JsonProperty("pet_3_icon")]
        public override string? Pet3Icon { get; set; }

        /// <summary>
        /// 寵物 3 描述
        /// </summary>
        [JsonProperty("pet_3_description")]
        public override string? Pet3Description { get; set; }

        /// <summary>
        /// 寵物 3 道具資訊
        /// </summary>
        [JsonProperty("pet_3_equipment")]
        public override CharacterPetEquipmentItemDTO? Pet3Equipment { get; set; }

        /// <summary>
        /// 寵物 3 的寵物自動加持技能資訊
        /// </summary>
        [JsonProperty("pet_3_auto_skill")]
        public override CharacterPetEquipmentAutoSkillDTO? Pet3AutoSkill { get; set; }

        /// <summary>
        /// 寵物 3 神奇寵物類型
        /// </summary>
        [JsonProperty("pet_3_pet_type")]
        public override string? Pet3PetType { get; set; }

        /// <summary>
        /// 寵物 3 技能
        /// </summary>
        [JsonProperty("pet_3_skill")]
        public override List<string> Pet3Skill { get; set; }

        /// <summary>
        /// 寵物 3 魔法時間 (TST，時間單位資料中的分鐘顯示為 0)
        /// </summary>
        public override DateTimeOffset? Pet3DateExpire
        {
            get
            {
                if (_pet3DateExpire != null && _pet3DateExpire != "expired")
                {
                    return DateTimeOffset.Parse(_pet3DateExpire).ToOffset(TimeSpan.FromHours(8));
                }

                return null;
            }
        }

        [JsonProperty("pet_3_date_expire")]
        private string? _pet3DateExpire;

        /// <summary>
        /// Whether the magic time for pet 3 is expired
        /// </summary>
        public override bool? Pet3Expired
        {
            get
            {
                if (_pet3DateExpire == null)
                {
                    return null;
                }

                return _pet3DateExpire == "expired";
            }
        }

        /// <summary>
        /// 寵物 3 外型
        /// </summary>
        [JsonProperty("pet_3_appearance")]
        public override string? Pet3Appearance { get; set; }

        /// <summary>
        /// 寵物 3 外型圖示
        /// </summary>
        [JsonProperty("pet_3_appearance_icon")]
        public override string? Pet3AppearanceIcon { get; set; }
    }

    /// <summary>
    /// 寵物的寵物自動加持技能資訊
    /// </summary>
    public class CharacterPetEquipmentAutoSkillDTO : Base.CharacterPetEquipmentAutoSkillDTO
    {
        /// <summary>
        /// 登錄於第一欄位的自動加持技能
        /// </summary>
        [JsonProperty("skill_1")]
        public override string? Skill1 { get; set; }

        /// <summary>
        /// 登錄於第一欄位的自動加持技能圖示
        /// </summary>
        [JsonProperty("skill_1_icon")]
        public override string? Skill1Icon { get; set; }

        /// <summary>
        /// 登錄於第二欄位的自動加持技能
        /// </summary>
        [JsonProperty("skill_2")]
        public override string? Skill2 { get; set; }

        /// <summary>
        /// 登錄於第二欄位的自動加持技能圖示
        /// </summary>
        [JsonProperty("skill_2_icon")]
        public override string? Skill2Icon { get; set; }
    }


    /// <summary>
    /// 道具顯示選項
    /// </summary>
    public class CharacterPetEquipmentItemOptionDTO : Base.CharacterPetEquipmentItemOptionDTO
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
    /// 寵物道具資訊
    /// </summary>
    public class CharacterPetEquipmentItemDTO : Base.CharacterPetEquipmentItemDTO<CharacterPetEquipmentItemOptionDTO>
    {
        /// <summary>
        /// 道具名稱
        /// </summary>
        [JsonProperty("item_name")]
        public override string? ItemName { get; set; }

        /// <summary>
        /// 道具圖示
        /// </summary>
        [JsonProperty("item_icon")]
        public override string? ItemIcon { get; set; }

        /// <summary>
        /// 道具描述
        /// </summary>
        [JsonProperty("item_description")]
        public override string? ItemDescription { get; set; }

        /// <summary>
        /// 道具顯示選項
        /// </summary>
        [JsonProperty("item_option")]
        public override List<CharacterPetEquipmentItemOptionDTO> ItemOption { get; set; }

        /// <summary>
        /// 強化次數
        /// </summary>
        [JsonProperty("scroll_upgrade")]
        public override int ScrollUpgrade { get; set; }

        /// <summary>
        /// 道具可升級次數
        /// </summary>
        [JsonProperty("scroll_upgradable")]
        public override int ScrollUpgradable { get; set; }

        /// <summary>
        /// 道具外型
        /// </summary>
        [JsonProperty("item_shape")]
        public override string? ItemShape { get; set; }

        /// <summary>
        /// 道具外型圖示
        /// </summary>
        [JsonProperty("item_shape_icon")]
        public override string? ItemShapeIcon { get; set; }
    }

}
