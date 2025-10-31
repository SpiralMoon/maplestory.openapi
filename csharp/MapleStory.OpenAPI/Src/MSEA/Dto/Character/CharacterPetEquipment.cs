using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.MSEA.DTO
{
    /// <summary>
    /// Character equipped pet information
    /// </summary>
    public class CharacterPetEquipmentDTO : Base.CharacterPetEquipmentDTO<CharacterPetEquipmentItemDTO, CharacterPetEquipmentAutoSkillDTO>
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
        /// Name of pet 1
        /// </summary>
        [JsonProperty("pet_1_name")]
        public override string? Pet1Name { get; set; }

        /// <summary>
        /// Nickname of pet1
        /// </summary>
        [JsonProperty("pet_1_nickname")]
        public override string? Pet1Nickname { get; set; }

        /// <summary>
        /// Icon of pet 1
        /// </summary>
        [JsonProperty("pet_1_icon")]
        public override string? Pet1Icon { get; set; }

        /// <summary>
        /// Description of pet 1
        /// </summary>
        [JsonProperty("pet_1_description")]
        public override string? Pet1Description { get; set; }

        /// <summary>
        /// Equipment information for pet 1
        /// </summary>
        [JsonProperty("pet_1_equipment")]
        public override CharacterPetEquipmentItemDTO? Pet1Equipment { get; set; }

        /// <summary>
        /// Auto buff skill information for pet 1
        /// </summary>
        [JsonProperty("pet_1_auto_skill")]
        public override CharacterPetEquipmentAutoSkillDTO? Pet1AutoSkill { get; set; }

        /// <summary>
        /// Wonder pet type of pet 1
        /// </summary>
        [JsonProperty("pet_1_pet_type")]
        public override string? Pet1PetType { get; set; }

        /// <summary>
        /// Skills possessed by pet 2
        /// </summary>
        [JsonProperty("pet_1_skill")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<string> Pet1Skill { get; set; } = new();

        /// <summary>
        /// Magic time for pet 1 (SGT, data with minutes set to 0)
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
        /// Appearance of pet 1
        /// </summary>
        [JsonProperty("pet_1_appearance")]
        public override string? Pet1Appearance { get; set; }

        /// <summary>
        /// Appearance icon of pet 1
        /// </summary>
        [JsonProperty("pet_1_appearance_icon")]
        public override string? Pet1AppearanceIcon { get; set; }

        /// <summary>
        /// Name of pet 2
        /// </summary>
        [JsonProperty("pet_2_name")]
        public override string? Pet2Name { get; set; }

        /// <summary>
        /// Nickname of pet 2
        /// </summary>
        [JsonProperty("pet_2_nickname")]
        public override string? Pet2Nickname { get; set; }

        /// <summary>
        /// Icon of pet 2
        /// </summary>
        [JsonProperty("pet_2_icon")]
        public override string? Pet2Icon { get; set; }

        /// <summary>
        /// Description of pet 2
        /// </summary>
        [JsonProperty("pet_2_description")]
        public override string? Pet2Description { get; set; }

        /// <summary>
        /// Equipment information for pet 2
        /// </summary>
        [JsonProperty("pet_2_equipment")]
        public override CharacterPetEquipmentItemDTO? Pet2Equipment { get; set; }

        /// <summary>
        /// Auto buff skill information for pet 2
        /// </summary>
        [JsonProperty("pet_2_auto_skill")]
        public override CharacterPetEquipmentAutoSkillDTO? Pet2AutoSkill { get; set; }

        /// <summary>
        /// Wonder pet type of pet 2
        /// </summary>
        [JsonProperty("pet_2_pet_type")]
        public override string? Pet2PetType { get; set; }

        /// <summary>
        /// Skills possessed by pet 2
        /// </summary>
        [JsonProperty("pet_2_skill")]
        public override List<string> Pet2Skill { get; set; }

        /// <summary>
        /// Magic time for pet 2 (SGT, data with minutes set to 0)
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
        /// Appearance of pet 2
        /// </summary>
        [JsonProperty("pet_2_appearance")]
        public override string? Pet2Appearance { get; set; }

        /// <summary>
        /// Appearance icon of pet 2
        /// </summary>
        [JsonProperty("pet_2_appearance_icon")]
        public override string? Pet2AppearanceIcon { get; set; }

        /// <summary>
        /// Name of pet 3
        /// </summary>
        [JsonProperty("pet_3_name")]
        public override string? Pet3Name { get; set; }

        /// <summary>
        /// Nickname of pet 3
        /// </summary>
        [JsonProperty("pet_3_nickname")]
        public override string? Pet3Nickname { get; set; }

        /// <summary>
        /// Icon of pet 3
        /// </summary>
        [JsonProperty("pet_3_icon")]
        public override string? Pet3Icon { get; set; }

        /// <summary>
        /// Description of pet 3
        /// </summary>
        [JsonProperty("pet_3_description")]
        public override string? Pet3Description { get; set; }

        /// <summary>
        /// Equipment information for pet 3
        /// </summary>
        [JsonProperty("pet_3_equipment")]
        public override CharacterPetEquipmentItemDTO? Pet3Equipment { get; set; }

        /// <summary>
        /// Auto buff skill information for pet 3
        /// </summary>
        [JsonProperty("pet_3_auto_skill")]
        public override CharacterPetEquipmentAutoSkillDTO? Pet3AutoSkill { get; set; }

        /// <summary>
        /// Wonder pet type of pet 3
        /// </summary>
        [JsonProperty("pet_3_pet_type")]
        public override string? Pet3PetType { get; set; }

        /// <summary>
        /// Skills possessed by pet 3
        /// </summary>
        [JsonProperty("pet_3_skill")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<string> Pet3Skill { get; set; } = new();

        /// <summary>
        /// Magic time for pet 3 (SGT, data with minutes set to 0)
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
        /// Appearance of pet 3
        /// </summary>
        [JsonProperty("pet_3_appearance")]
        public override string? Pet3Appearance { get; set; }

        /// <summary>
        /// Appearance icon of pet 3
        /// </summary>
        [JsonProperty("pet_3_appearance_icon")]
        public override string? Pet3AppearanceIcon { get; set; }
    }

    /// <summary>
    /// Auto buff skill information for pet
    /// </summary>
    public class CharacterPetEquipmentAutoSkillDTO : Base.CharacterPetEquipmentAutoSkillDTO
    {
        /// <summary>
        /// Auto skill registered in the first slot
        /// </summary>
        [JsonProperty("skill_1")]
        public override string? Skill1 { get; set; }

        /// <summary>
        /// Icon for the auto skill in the first slot
        /// </summary>
        [JsonProperty("skill_1_icon")]
        public override string? Skill1Icon { get; set; }

        /// <summary>
        /// Auto skill registered in the second slot
        /// </summary>
        [JsonProperty("skill_2")]
        public override string? Skill2 { get; set; }

        /// <summary>
        /// Icon for the auto skill in the second slot
        /// </summary>
        [JsonProperty("skill_2_icon")]
        public override string? Skill2Icon { get; set; }
    }


    /// <summary>
    /// Displayed pet item options
    /// </summary>
    public class CharacterPetEquipmentItemOptionDTO : Base.CharacterPetEquipmentItemOptionDTO
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
    /// Equipment information for pet
    /// </summary>
    public class CharacterPetEquipmentItemDTO : Base.CharacterPetEquipmentItemDTO<CharacterPetEquipmentItemOptionDTO>
    {
        /// <summary>
        /// Item name
        /// </summary>
        [JsonProperty("item_name")]
        public override string? ItemName { get; set; }

        /// <summary>
        /// Item icon
        /// </summary>
        [JsonProperty("item_icon")]
        public override string? ItemIcon { get; set; }

        /// <summary>
        /// Item description
        /// </summary>
        [JsonProperty("item_description")]
        public override string? ItemDescription { get; set; }

        /// <summary>
        /// Displayed item options
        /// </summary>
        [JsonProperty("item_option")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterPetEquipmentItemOptionDTO> ItemOption { get; set; } = new();

        /// <summary>
        /// Number of upgrades
        /// </summary>
        [JsonProperty("scroll_upgrade")]
        public override int ScrollUpgrade { get; set; }

        /// <summary>
        /// Number of upgrades available
        /// </summary>
        [JsonProperty("scroll_upgradable")]
        public override int ScrollUpgradable { get; set; }

        /// <summary>
        /// Item appearance
        /// </summary>
        [JsonProperty("item_shape")]
        public override string? ItemShape { get; set; }

        /// <summary>
        /// Item appearance icon
        /// </summary>
        [JsonProperty("item_shape_icon")]
        public override string? ItemShapeIcon { get; set; }
    }

}
