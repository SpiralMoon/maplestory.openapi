using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.MSEA.DTO
{
    /// <summary>
    /// Character equipped equipment information
    /// </summary>
    public class CharacterItemEquipmentDTO : Base.CharacterItemEquipmentDTO<
        CharacterItemEquipmentInfoDTO,
        CharacterItemEquipmentTitleDTO,
        CharacterItemEquipmentMedalShapeDTO,
        CharacterItemEquipmentDragonInfoDTO,
        CharacterItemEquipmentMechanicInfoDTO>
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
        public override string CharacterGender { get; set; }

        /// <summary>
        /// Character job
        /// </summary>
        [JsonProperty("character_class")]
        public override string CharacterClass { get; set; }

        /// <summary>
        /// Active equipment preset number
        /// </summary>
        [JsonProperty("preset_no")]
        public override int? PresetNo { get; set; }

        /// <summary>
        /// Equipment information
        /// </summary>
        [JsonProperty("item_equipment")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterItemEquipmentInfoDTO> ItemEquipment { get; set; } = new();

        /// <summary>
        /// Equipment information for Preset 1
        /// </summary>
        [JsonProperty("item_equipment_preset_1")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterItemEquipmentInfoDTO> ItemEquipmentPreset1 { get; set; } = new();

        /// <summary>
        /// Equipment information for Preset 2
        /// </summary>
        [JsonProperty("item_equipment_preset_2")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterItemEquipmentInfoDTO> ItemEquipmentPreset2 { get; set; } = new();

        /// <summary>
        /// Equipment information for Preset 3
        /// </summary>
        [JsonProperty("item_equipment_preset_3")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterItemEquipmentInfoDTO> ItemEquipmentPreset3 { get; set; } = new();

        /// <summary>
        /// Title information
        /// </summary>
        [JsonProperty("title")]
        public override CharacterItemEquipmentTitleDTO? Title { get; set; }

        /// <summary>
        /// Medal appearance information registered in the appearance settings
        /// </summary>
        [JsonProperty("medal_shape")]
        public override CharacterItemEquipmentMedalShapeDTO? MedalShape { get; set; }

        /// <summary>
        /// Evan Dragon equipment information (response provided if the character is Evan)
        /// </summary>
        [JsonProperty("dragon_equipment")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterItemEquipmentDragonInfoDTO> DragonEquipment { get; set; } = new();

        /// <summary>
        /// Mechanic equipment information (response provided if the character is a Mechanic)
        /// </summary>
        [JsonProperty("mechanic_equipment")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterItemEquipmentMechanicInfoDTO> MechanicEquipment { get; set; } = new();
    }

    /// <summary>
    /// Title information
    /// </summary>
    public class CharacterItemEquipmentTitleDTO : Base.CharacterItemEquipmentTitleDTO
    {
        /// <summary>
        /// Title name
        /// </summary>
        [JsonProperty("title_name")]
        public override string? TitleName { get; set; }

        /// <summary>
        /// Title icon
        /// </summary>
        [JsonProperty("title_icon")]
        public override string? TitleIcon { get; set; }

        /// <summary>
        /// Title description
        /// </summary>
        [JsonProperty("title_description")]
        public override string? TitleDescription { get; set; }

        /// <summary>
        /// Title validity period (SGT)
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
        /// Whether the title is expired
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
        /// Title option validity period (expired:expired, null unlimited) (SGT)
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
        /// Whether the title option is expired
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
        /// Title equipment name registered in the appearance settings
        /// </summary>
        [JsonProperty("title_shape_name")]
        public override string? TitleShapeName { get; set; }

        /// <summary>
        /// Title icon registered in the appearance settings
        /// </summary>
        [JsonProperty("title_shape_icon")]
        public override string? TitleShapeIcon { get; set; }

        /// <summary>
        /// Title description registered in the appearance settings
        /// </summary>
        [JsonProperty("title_shape_description")]
        public override string? TitleShapeDescription { get; set; }
    }

    /// <summary>
    /// Medal appearance information
    /// </summary>
    public class CharacterItemEquipmentMedalShapeDTO : Base.CharacterItemEquipmentMedalShapeDTO
    {
        /// <summary>
        /// Medal equipment name registered in the appearance settings
        /// </summary>
        [JsonProperty("medal_shape_name")]
        public override string MedalShapeName { get; set; }

        /// <summary>
        /// Medal icon registered in the appearance settings
        /// </summary>
        [JsonProperty("medal_shape_icon")]
        public override string MedalShapeIcon { get; set; }

        /// <summary>
        /// Medal description registered in the appearance settings
        /// </summary>
        [JsonProperty("medal_shape_description")]
        public override string MedalShapeDescription { get; set; }

        /// <summary>
        /// Fusion Anvil-applied medal equipment name registered in the appearance settings
        /// </summary>
        [JsonProperty("medal_shape_changed_name")]
        public override string MedalShapeChangedName { get; set; }

        /// <summary>
        /// Fusion Anvil-applied medal icon registered in the appearance settings
        /// </summary>
        [JsonProperty("medal_shape_changed_icon")]
        public override string MedalShapeChangedIcon { get; set; }

        /// <summary>
        /// Fusion Anvil-applied medal description registered in the appearance settings
        /// </summary>
        [JsonProperty("medal_shape_changed_description")]
        public override string MedalShapeChangedDescription { get; set; }
    }

    /// <summary>
    /// Additional equipment options
    /// </summary>
    public class CharacterItemEquipmentAddOptionDTO : Base.CharacterItemEquipmentAddOptionDTO
    {
        /// <summary>
        /// STR
        /// </summary>
        [JsonProperty("str")]
        public override string Strength { get; set; }

        /// <summary>
        /// DEX
        /// </summary>
        [JsonProperty("dex")]
        public override string Dexterity { get; set; }

        /// <summary>
        /// INT
        /// </summary>
        [JsonProperty("int")]
        public override string Intelligence { get; set; }

        /// <summary>
        /// LUK
        /// </summary>
        [JsonProperty("luk")]
        public override string Luck { get; set; }

        /// <summary>
        /// Max HP
        /// </summary>
        [JsonProperty("max_hp")]
        public override string MaxHp { get; set; }

        /// <summary>
        /// Max MP
        /// </summary>
        [JsonProperty("max_mp")]
        public override string MaxMp { get; set; }

        /// <summary>
        /// Attack Power
        /// </summary>
        [JsonProperty("attack_power")]
        public override string AttackPower { get; set; }

        /// <summary>
        /// Magic ATT
        /// </summary>
        [JsonProperty("magic_power")]
        public override string MagicPower { get; set; }

        /// <summary>
        /// Defense
        /// </summary>
        [JsonProperty("armor")]
        public override string Armor { get; set; }

        /// <summary>
        /// Speed
        /// </summary>
        [JsonProperty("speed")]
        public override string Speed { get; set; }

        /// <summary>
        /// Jump
        /// </summary>
        [JsonProperty("jump")]
        public override string Jump { get; set; }

        /// <summary>
        /// Boss Damage (%)
        /// </summary>
        [JsonProperty("boss_damage")]
        public override string BossDamage { get; set; }

        /// <summary>
        /// Damage (%)
        /// </summary>
        [JsonProperty("damage")]
        public override string Damage { get; set; }

        /// <summary>
        /// All Stats (%)
        /// </summary>
        [JsonProperty("all_stat")]
        public override string AllStat { get; set; }

        /// <summary>
        /// Equipment level decrease
        /// </summary>
        [JsonProperty("equipment_level_decrease")]
        public override long EquipmentLevelDecrease { get; set; }
    }

    /// <summary>
    /// Basic equipment option information
    /// </summary>
    public class CharacterItemEquipmentBaseOptionDTO : Base.CharacterItemEquipmentBaseOptionDTO
    {
        /// <summary>
        /// STR
        /// </summary>
        [JsonProperty("str")]
        public override string Strength { get; set; }

        /// <summary>
        /// DEX
        /// </summary>
        [JsonProperty("dex")]
        public override string Dexterity { get; set; }

        /// <summary>
        /// INT
        /// </summary>
        [JsonProperty("int")]
        public override string Intelligence { get; set; }

        /// <summary>
        /// LUK
        /// </summary>
        [JsonProperty("luk")]
        public override string Luck { get; set; }

        /// <summary>
        /// Max HP
        /// </summary>
        [JsonProperty("max_hp")]
        public override string MaxHp { get; set; }

        /// <summary>
        /// Max MP
        /// </summary>
        [JsonProperty("max_mp")]
        public override string MaxMp { get; set; }

        /// <summary>
        /// Attack Power
        /// </summary>
        [JsonProperty("attack_power")]
        public override string AttackPower { get; set; }

        /// <summary>
        /// Magic ATT
        /// </summary>
        [JsonProperty("magic_power")]
        public override string MagicPower { get; set; }

        /// <summary>
        /// Defense
        /// </summary>
        [JsonProperty("armor")]
        public override string Armor { get; set; }

        /// <summary>
        /// Speed
        /// </summary>
        [JsonProperty("speed")]
        public override string Speed { get; set; }

        /// <summary>
        /// Jump
        /// </summary>
        [JsonProperty("jump")]
        public override string Jump { get; set; }

        /// <summary>
        /// Boss Damage (%)
        /// </summary>
        [JsonProperty("boss_damage")]
        public override string BossDamage { get; set; }

        /// <summary>
        /// Ignore Enemy Defense (%)
        /// </summary>
        [JsonProperty("ignore_monster_armor")]
        public override string IgnoreMonsterArmor { get; set; }

        /// <summary>
        /// All Stats (%)
        /// </summary>
        [JsonProperty("all_stat")]
        public override string AllStat { get; set; }

        /// <summary>
        /// Max HP (%)
        /// </summary>
        [JsonProperty("max_hp_rate")]
        public override string MaxHpRate { get; set; }

        /// <summary>
        /// Max MP (%)
        /// </summary>
        [JsonProperty("max_mp_rate")]
        public override string MaxMpRate { get; set; }

        /// <summary>
        /// Basic equipment level
        /// </summary>
        [JsonProperty("base_equipment_level")]
        public override long BaseEquipmentLevel { get; set; }
    }

    /// <summary>
    /// Miscellaneous equipment option information
    /// </summary>
    public class CharacterItemEquipmentEtcOptionDTO : Base.CharacterItemEquipmentEtcOptionDTO
    {
        /// <summary>
        /// STR
        /// </summary>
        [JsonProperty("str")]
        public override string Strength { get; set; }

        /// <summary>
        /// DEX
        /// </summary>
        [JsonProperty("dex")]
        public override string Dexterity { get; set; }

        /// <summary>
        /// INT
        /// </summary>
        [JsonProperty("int")]
        public override string Intelligence { get; set; }

        /// <summary>
        /// LUK
        /// </summary>
        [JsonProperty("luk")]
        public override string Luck { get; set; }

        /// <summary>
        /// Max HP
        /// </summary>
        [JsonProperty("max_hp")]
        public override string MaxHp { get; set; }

        /// <summary>
        /// Max MP
        /// </summary>
        [JsonProperty("max_mp")]
        public override string MaxMp { get; set; }

        /// <summary>
        /// Attack Power
        /// </summary>
        [JsonProperty("attack_power")]
        public override string AttackPower { get; set; }

        /// <summary>
        /// Magic ATT
        /// </summary>
        [JsonProperty("magic_power")]
        public override string MagicPower { get; set; }

        /// <summary>
        /// Defense
        /// </summary>
        [JsonProperty("armor")]
        public override string Armor { get; set; }

        /// <summary>
        /// Speed
        /// </summary>
        [JsonProperty("speed")]
        public override string Speed { get; set; }

        /// <summary>
        /// Jump
        /// </summary>
        [JsonProperty("jump")]
        public override string Jump { get; set; }
    }

    /// <summary>
    /// Exceptional equipment option information
    /// </summary>
    public class CharacterItemEquipmentExceptionalOptionDTO : Base.CharacterItemEquipmentExceptionalOptionDTO
    {
        /// <summary>
        /// STR
        /// </summary>
        [JsonProperty("str")]
        public override string Strength { get; set; }

        /// <summary>
        /// DEX
        /// </summary>
        [JsonProperty("dex")]
        public override string Dexterity { get; set; }

        /// <summary>
        /// INT
        /// </summary>
        [JsonProperty("int")]
        public override string Intelligence { get; set; }

        /// <summary>
        /// LUK
        /// </summary>
        [JsonProperty("luk")]
        public override string Luck { get; set; }

        /// <summary>
        /// Max HP
        /// </summary>
        [JsonProperty("max_hp")]
        public override string MaxHp { get; set; }

        /// <summary>
        /// Max MP
        /// </summary>
        [JsonProperty("max_mp")]
        public override string MaxMp { get; set; }

        /// <summary>
        /// Attack Power
        /// </summary>
        [JsonProperty("attack_power")]
        public override string AttackPower { get; set; }

        /// <summary>
        /// Magic ATT
        /// </summary>
        [JsonProperty("magic_power")]
        public override string MagicPower { get; set; }

        /// <summary>
        /// Number of exceptional boost applications
        /// </summary>
        [JsonProperty("exceptional_upgrade")]
        [JsonConverter(typeof(DefaultValueConverter<int>), 0)]
        public override int ExceptionalUpgrade { get; set; }
    }

    /// <summary>
    /// Equipment Star Force option information
    /// </summary>
    public class CharacterItemEquipmentStarforceOptionDTO : Base.CharacterItemEquipmentStarforceOptionDTO
    {
        /// <summary>
        /// STR
        /// </summary>
        [JsonProperty("str")]
        public override string Strength { get; set; }

        /// <summary>
        /// DEX
        /// </summary>
        [JsonProperty("dex")]
        public override string Dexterity { get; set; }

        /// <summary>
        /// INT
        /// </summary>
        [JsonProperty("int")]
        public override string Intelligence { get; set; }

        /// <summary>
        /// LUK
        /// </summary>
        [JsonProperty("luk")]
        public override string Luck { get; set; }

        /// <summary>
        /// Max HP
        /// </summary>
        [JsonProperty("max_hp")]
        public override string MaxHp { get; set; }

        /// <summary>
        /// Max MP
        /// </summary>
        [JsonProperty("max_mp")]
        public override string MaxMp { get; set; }

        /// <summary>
        /// Attack Power
        /// </summary>
        [JsonProperty("attack_power")]
        public override string AttackPower { get; set; }

        /// <summary>
        /// Magic ATT
        /// </summary>
        [JsonProperty("magic_power")]
        public override string MagicPower { get; set; }

        /// <summary>
        /// Defense
        /// </summary>
        [JsonProperty("armor")]
        public override string Armor { get; set; }

        /// <summary>
        /// Speed
        /// </summary>
        [JsonProperty("speed")]
        public override string Speed { get; set; }

        /// <summary>
        /// Jump
        /// </summary>
        [JsonProperty("jump")]
        public override string Jump { get; set; }
    }

    /// <summary>
    /// Final equipment option information
    /// </summary>
    public class CharacterItemEquipmentTotalOptionDTO : Base.CharacterItemEquipmentTotalOptionDTO
    {
        /// <summary>
        /// STR
        /// </summary>
        [JsonProperty("str")]
        public override string Strength { get; set; }

        /// <summary>
        /// DEX
        /// </summary>
        [JsonProperty("dex")]
        public override string Dexterity { get; set; }

        /// <summary>
        /// INT
        /// </summary>
        [JsonProperty("int")]
        public override string Intelligence { get; set; }

        /// <summary>
        /// LUK
        /// </summary>
        [JsonProperty("luk")]
        public override string Luck { get; set; }

        /// <summary>
        /// Max HP
        /// </summary>
        [JsonProperty("max_hp")]
        public override string MaxHp { get; set; }

        /// <summary>
        /// Max MP
        /// </summary>
        [JsonProperty("max_mp")]
        public override string MaxMp { get; set; }

        /// <summary>
        /// Attack Power
        /// </summary>
        [JsonProperty("attack_power")]
        public override string AttackPower { get; set; }

        /// <summary>
        /// Magic ATT
        /// </summary>
        [JsonProperty("magic_power")]
        public override string MagicPower { get; set; }

        /// <summary>
        /// Defense
        /// </summary>
        [JsonProperty("armor")]
        public override string Armor { get; set; }

        /// <summary>
        /// Speed
        /// </summary>
        [JsonProperty("speed")]
        public override string Speed { get; set; }

        /// <summary>
        /// Jump
        /// </summary>
        [JsonProperty("jump")]
        public override string Jump { get; set; }

        /// <summary>
        /// Boss Damage (%)
        /// </summary>
        [JsonProperty("boss_damage")]
        public override string BossDamage { get; set; }

        /// <summary>
        /// Ignore Enemy Defense (%)
        /// </summary>
        [JsonProperty("ignore_monster_armor")]
        public override string IgnoreMonsterArmor { get; set; }

        /// <summary>
        /// All Stats (%)
        /// </summary>
        [JsonProperty("all_stat")]
        public override string AllStat { get; set; }

        /// <summary>
        /// Damage (%)
        /// </summary>
        public override string Damage { get; set; }

        /// <summary>
        /// Equipment level decreases
        /// </summary>
        [JsonProperty("equipment_level_decrease")]
        public override long EquipmentLevelDecrease { get; set; }

        /// <summary>
        /// Max HP (%)
        /// </summary>
        [JsonProperty("max_hp_rate")]
        public override string MaxHpRate { get; set; }

        /// <summary>
        /// Max MP (%)
        /// </summary>
        [JsonProperty("max_mp_rate")]
        public override string MaxMpRate { get; set; }
    }

    /// <summary>
    /// Evan Dragon equipment information
    /// </summary>
    public class CharacterItemEquipmentDragonInfoDTO : Base.CharacterItemEquipmentDragonInfoDTO<
        CharacterItemEquipmentTotalOptionDTO,
        CharacterItemEquipmentBaseOptionDTO,
        CharacterItemEquipmentExceptionalOptionDTO,
        CharacterItemEquipmentAddOptionDTO,
        CharacterItemEquipmentEtcOptionDTO,
        CharacterItemEquipmentStarforceOptionDTO>
    {
        /// <summary>
        /// Equipment part name
        /// </summary>
        [JsonProperty("item_equipment_part")]
        public override string ItemEquipmentPart { get; set; }

        /// <summary>
        /// Equipment slot position
        /// </summary>
        [JsonProperty("item_equipment_slot")]
        public override string ItemEquipmentSlot { get; set; }

        /// <summary>
        /// Equipment name
        /// </summary>
        [JsonProperty("item_name")]
        public override string ItemName { get; set; }

        /// <summary>
        /// Equipment icon
        /// </summary>
        [JsonProperty("item_icon")]
        public override string ItemIcon { get; set; }

        /// <summary>
        /// Equipment description
        /// </summary>
        [JsonProperty("item_description")]
        public override string? ItemDescription { get; set; }

        /// <summary>
        /// Equipment type
        /// </summary>
        [JsonProperty("item_shape_name")]
        public override string ItemShapeName { get; set; }

        /// <summary>
        /// Equipment type icon
        /// </summary>
        [JsonProperty("item_shape_icon")]
        public override string ItemShapeIcon { get; set; }

        /// <summary>
        /// Gender-specific equipment
        /// </summary>
        [JsonProperty("item_gender")]
        public override string? ItemGender { get; set; }

        /// <summary>
        /// Final equipment option information
        /// </summary>
        [JsonProperty("item_total_option")]
        public override CharacterItemEquipmentTotalOptionDTO ItemTotalOption { get; set; }

        /// <summary>
        /// Basic equipment option information
        /// </summary>
        [JsonProperty("item_base_option")]
        public override CharacterItemEquipmentBaseOptionDTO ItemBaseOption { get; set; }

        /// <summary>
        /// Equipment level increases
        /// </summary>
        [JsonProperty("equipment_level_increase")]
        public override long EquipmentLevelIncrease { get; set; }

        /// <summary>
        /// Exceptional equipment option information
        /// </summary>
        [JsonProperty("item_exceptional_option")]
        public override CharacterItemEquipmentExceptionalOptionDTO ItemExceptionalOption { get; set; }

        /// <summary>
        /// Additional equipment options
        /// </summary>
        [JsonProperty("item_add_option")]
        public override CharacterItemEquipmentAddOptionDTO ItemAddOption { get; set; }

        /// <summary>
        /// Growth EXP
        /// </summary>
        [JsonProperty("growth_exp")]
        public override long GrowthExp { get; set; }

        /// <summary>
        /// Growth level
        /// </summary>
        [JsonProperty("growth_level")]
        public override long GrowthLevel { get; set; }

        /// <summary>
        /// Number of upgrades
        /// </summary>
        [JsonProperty("scroll_upgrade")]
        public override string ScrollUpgrade { get; set; }

        /// <summary>
        /// Number of scissors usage available (Untradable, 255 for equipment without scissors usage count)
        /// </summary>
        [JsonProperty("cuttable_count")]
        public override string CuttableCount { get; set; }

        /// <summary>
        /// Golden Hammer refinement applied (true:applied, false:not applied)
        /// </summary>
        [JsonProperty("golden_hammer_flag")]
        public override string GoldenHammerFlag { get; set; }

        /// <summary>
        /// Number of restoration attempts available
        /// </summary>
        [JsonProperty("scroll_resilience_count")]
        public override string ScrollResilienceCount { get; set; }

        /// <summary>
        /// Number of upgrades available
        /// </summary>
        [JsonProperty("scroll_upgradeable_count")]
        public override string ScrollUpgradeableCount { get; set; }

        /// <summary>
        /// Soul name
        /// </summary>
        [JsonProperty("soul_name")]
        public override string? SoulName { get; set; }

        /// <summary>
        /// Soul option
        /// </summary>
        [JsonProperty("soul_option")]
        public override string? SoulOption { get; set; }

        /// <summary>
        /// Miscellaneous equipment option information
        /// </summary>
        [JsonProperty("item_etc_option")]
        public override CharacterItemEquipmentEtcOptionDTO ItemEtcOption { get; set; }

        /// <summary>
        /// Enhancement level
        /// </summary>
        [JsonProperty("starforce")]
        public override string Starforce { get; set; }

        /// <summary>
        /// Usage status of Miraculous Equip Enhancement Scroll (true:used, false:not used)
        /// </summary>
        [JsonProperty("starforce_scroll_flag")]
        public override string StarforceScrollFlag { get; set; }

        /// <summary>
        /// Equipment Star Force option information
        /// </summary>
        [JsonProperty("item_starforce_option")]
        public override CharacterItemEquipmentStarforceOptionDTO ItemStarforceOption { get; set; }

        /// <summary>
        /// Special Skill Ring
        /// </summary>
        [JsonProperty("special_ring_level")]
        public override long SpecialRingLevel { get; set; }

        /// <summary>
        /// Equipment expiration date (SGT)
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
        private string? _dateExpire;

        /// <summary>
        /// Whether the equipment is expired
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
    /// Mechanic equipment information
    /// </summary>
    public class CharacterItemEquipmentMechanicInfoDTO : Base.CharacterItemEquipmentMechanicInfoDTO<
        CharacterItemEquipmentTotalOptionDTO,
        CharacterItemEquipmentBaseOptionDTO,
        CharacterItemEquipmentExceptionalOptionDTO,
        CharacterItemEquipmentAddOptionDTO,
        CharacterItemEquipmentEtcOptionDTO,
        CharacterItemEquipmentStarforceOptionDTO>
    {
        /// <summary>
        /// Equipment part name
        /// </summary>
        [JsonProperty("item_equipment_part")]
        public override string ItemEquipmentPart { get; set; }

        /// <summary>
        /// Equipment slot position
        /// </summary>
        [JsonProperty("item_equipment_slot")]
        public override string ItemEquipmentSlot { get; set; }

        /// <summary>
        /// Equipment name
        /// </summary>
        [JsonProperty("item_name")]
        public override string ItemName { get; set; }

        /// <summary>
        /// Equipment icon
        /// </summary>
        [JsonProperty("item_icon")]
        public override string ItemIcon { get; set; }

        /// <summary>
        /// Equipment description
        /// </summary>
        [JsonProperty("item_description")]
        public override string? ItemDescription { get; set; }

        /// <summary>
        /// Equipment type
        /// </summary>
        [JsonProperty("item_shape_name")]
        public override string ItemShapeName { get; set; }

        /// <summary>
        /// Equipment type icon
        /// </summary>
        [JsonProperty("item_shape_icon")]
        public override string ItemShapeIcon { get; set; }

        /// <summary>
        /// Gender-specific equipment
        /// </summary>
        [JsonProperty("item_gender")]
        public override string? ItemGender { get; set; }

        /// <summary>
        /// Final equipment option information
        /// </summary>
        [JsonProperty("item_total_option")]
        public override CharacterItemEquipmentTotalOptionDTO ItemTotalOption { get; set; }

        /// <summary>
        /// Basic equipment option information
        /// </summary>
        [JsonProperty("item_base_option")]
        public override CharacterItemEquipmentBaseOptionDTO ItemBaseOption { get; set; }

        /// <summary>
        /// Equipment level increases
        /// </summary>
        [JsonProperty("equipment_level_increase")]
        public override long EquipmentLevelIncrease { get; set; }

        /// <summary>
        /// Exceptional equipment option information
        /// </summary>
        [JsonProperty("item_exceptional_option")]
        public override CharacterItemEquipmentExceptionalOptionDTO ItemExceptionalOption { get; set; }

        /// <summary>
        /// Additional equipment options
        /// </summary>
        [JsonProperty("item_add_option")]
        public override CharacterItemEquipmentAddOptionDTO ItemAddOption { get; set; }

        /// <summary>
        /// Growth EXP
        /// </summary>
        [JsonProperty("growth_exp")]
        public override long GrowthExp { get; set; }

        /// <summary>
        /// Growth level
        /// </summary>
        [JsonProperty("growth_level")]
        public override long GrowthLevel { get; set; }

        /// <summary>
        /// Number of upgrades
        /// </summary>
        [JsonProperty("scroll_upgrade")]
        public override string ScrollUpgrade { get; set; }

        /// <summary>
        /// Number of scissors usage available (Untradable, 255 for equipment without scissors usage count)
        /// </summary>
        [JsonProperty("cuttable_count")]
        public override string CuttableCount { get; set; }

        /// <summary>
        /// Golden Hammer refinement applied (true:applied, false:not applied)
        /// </summary>
        [JsonProperty("golden_hammer_flag")]
        public override string GoldenHammerFlag { get; set; }

        /// <summary>
        /// Number of restoration attempts available
        /// </summary>
        [JsonProperty("scroll_resilience_count")]
        public override string ScrollResilienceCount { get; set; }

        /// <summary>
        /// Number of upgrades available
        /// </summary>
        [JsonProperty("scroll_upgradeable_count")]
        public override string ScrollUpgradeableCount { get; set; }

        /// <summary>
        /// Soul name
        /// </summary>
        [JsonProperty("soul_name")]
        public override string? SoulName { get; set; }

        /// <summary>
        /// Soul option
        /// </summary>
        [JsonProperty("soul_option")]
        public override string? SoulOption { get; set; }

        /// <summary>
        /// Miscellaneous equipment option information
        /// </summary>
        [JsonProperty("item_etc_option")]
        public override CharacterItemEquipmentEtcOptionDTO ItemEtcOption { get; set; }

        /// <summary>
        /// Enhancement level
        /// </summary>
        [JsonProperty("starforce")]
        public override string Starforce { get; set; }

        /// <summary>
        /// Usage status of Miraculous Equip Enhancement Scroll (true:used, false:not used)
        /// </summary>
        [JsonProperty("starforce_scroll_flag")]
        public override string StarforceScrollFlag { get; set; }

        /// <summary>
        /// Equipment Star Force option information
        /// </summary>
        [JsonProperty("item_starforce_option")]
        public override CharacterItemEquipmentStarforceOptionDTO ItemStarforceOption { get; set; }

        /// <summary>
        /// Special Skill Ring
        /// </summary>
        [JsonProperty("special_ring_level")]
        public override long SpecialRingLevel { get; set; }

        /// <summary>
        /// Equipment expiration date (SGT)
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
        private string? _dateExpire;

        /// <summary>
        /// Whether the equipment is expired
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
    /// Equipment information
    /// </summary>
    public class CharacterItemEquipmentInfoDTO : Base.CharacterItemEquipmentInfoDTO<
        CharacterItemEquipmentTotalOptionDTO,
        CharacterItemEquipmentBaseOptionDTO,
        CharacterItemEquipmentExceptionalOptionDTO,
        CharacterItemEquipmentAddOptionDTO,
        CharacterItemEquipmentEtcOptionDTO,
        CharacterItemEquipmentStarforceOptionDTO>
    {
        /// <summary>
        /// Equipment part name
        /// </summary>
        [JsonProperty("item_equipment_part")]
        public override string ItemEquipmentPart { get; set; }

        /// <summary>
        /// Equipment slot position
        /// </summary>
        [JsonProperty("item_equipment_slot")]
        public override string ItemEquipmentSlot { get; set; }

        /// <summary>
        /// Equipment name
        /// </summary>
        [JsonProperty("item_name")]
        public override string ItemName { get; set; }

        /// <summary>
        /// Equipment icon
        /// </summary>
        [JsonProperty("item_icon")]
        public override string ItemIcon { get; set; }

        /// <summary>
        /// Equipment description
        /// </summary>
        [JsonProperty("item_description")]
        public override string? ItemDescription { get; set; }

        /// <summary>
        /// Equipment type
        /// </summary>
        [JsonProperty("item_shape_name")]
        public override string ItemShapeName { get; set; }

        /// <summary>
        /// Equipment type icon
        /// </summary>
        [JsonProperty("item_shape_icon")]
        public override string ItemShapeIcon { get; set; }

        /// <summary>
        /// Gender-specific equipment
        /// </summary>
        [JsonProperty("item_gender")]
        public override string? ItemGender { get; set; }

        /// <summary>
        /// Final equipment option information
        /// </summary>
        [JsonProperty("item_total_option")]
        public override CharacterItemEquipmentTotalOptionDTO ItemTotalOption { get; set; }

        /// <summary>
        /// Basic equipment option information
        /// </summary>
        [JsonProperty("item_base_option")]
        public override CharacterItemEquipmentBaseOptionDTO ItemBaseOption { get; set; }

        /// <summary>
        /// Potential seal status (true:sealed, false:not sealed)
        /// </summary>
        [JsonProperty("potential_option_flag")]
        public override string? PotentialOptionFlag { get; set; }

        /// <summary>
        /// Additional potential seal status (true:sealed, false:not sealed)
        /// </summary>
        [JsonProperty("additional_potential_option_flag")]
        public override string? AdditionalPotentialOptionFlag { get; set; }

        /// <summary>
        /// Potential grade
        /// </summary>
        [JsonProperty("potential_option_grade")]
        public override string? PotentialOptionGrade { get; set; }

        /// <summary>
        /// Additional potential grade
        /// </summary>
        [JsonProperty("additional_potential_option_grade")]
        public override string? AdditionalPotentialOptionGrade { get; set; }

        /// <summary>
        /// First Potential option
        /// </summary>
        [JsonProperty("potential_option_1")]
        public override string? PotentialOption1 { get; set; }

        /// <summary>
        /// Second Potential option
        /// </summary>
        [JsonProperty("potential_option_2")]
        public override string? PotentialOption2 { get; set; }

        /// <summary>
        /// Third Potential option
        /// </summary>
        [JsonProperty("potential_option_3")]
        public override string? PotentialOption3 { get; set; }

        /// <summary>
        /// First additional Potential option
        /// </summary>
        [JsonProperty("additional_potential_option_1")]
        public override string? AdditionalPotentialOption1 { get; set; }

        /// <summary>
        /// Second additional Potential option
        /// </summary>
        [JsonProperty("additional_potential_option_2")]
        public override string? AdditionalPotentialOption2 { get; set; }

        /// <summary>
        /// Third additional Potential option
        /// </summary>
        [JsonProperty("additional_potential_option_3")]
        public override string? AdditionalPotentialOption3 { get; set; }

        /// <summary>
        /// Equipment level increase
        /// </summary>
        [JsonProperty("equipment_level_increase")]
        public override long EquipmentLevelIncrease { get; set; }

        /// <summary>
        /// Exceptional equipment option information
        /// </summary>
        [JsonProperty("item_exceptional_option")]
        public override CharacterItemEquipmentExceptionalOptionDTO ItemExceptionalOption { get; set; }

        /// <summary>
        /// Additional equipment options
        /// </summary>
        [JsonProperty("item_add_option")]
        public override CharacterItemEquipmentAddOptionDTO ItemAddOption { get; set; }

        /// <summary>
        /// Growth EXP
        /// </summary>
        [JsonProperty("growth_exp")]
        public override long GrowthExp { get; set; }

        /// <summary>
        /// Growth level
        /// </summary>
        [JsonProperty("growth_level")]
        public override long GrowthLevel { get; set; }

        /// <summary>
        /// Number of upgrade attempts
        /// </summary>
        [JsonProperty("scroll_upgrade")]
        public override string ScrollUpgrade { get; set; }

        /// <summary>
        /// Number of scissors usage available (Untradable, 255 for equipment without scissors usage count)
        /// </summary>
        [JsonProperty("cuttable_count")]
        public override string CuttableCount { get; set; }

        /// <summary>
        /// Golden Hammer refinement applied (true:applied, false:not applied)
        /// </summary>
        [JsonProperty("golden_hammer_flag")]
        public override string GoldenHammerFlag { get; set; }

        /// <summary>
        /// Number of restoration attempts available
        /// </summary>
        [JsonProperty("scroll_resilience_count")]
        public override string ScrollResilienceCount { get; set; }

        /// <summary>
        /// Number of upgrades available
        /// </summary>
        [JsonProperty("scroll_upgradeable_count")]
        public override string ScrollUpgradeableCount { get; set; }

        /// <summary>
        /// Soul name
        /// </summary>
        [JsonProperty("soul_name")]
        public override string? SoulName { get; set; }

        /// <summary>
        /// Soul option
        /// </summary>
        [JsonProperty("soul_option")]
        public override string? SoulOption { get; set; }

        /// <summary>
        /// Miscellaneous equipment option information
        /// </summary>
        [JsonProperty("item_etc_option")]
        public override CharacterItemEquipmentEtcOptionDTO ItemEtcOption { get; set; }

        /// <summary>
        /// Enhancement level
        /// </summary>
        [JsonProperty("starforce")]
        public override string Starforce { get; set; }

        /// <summary>
        /// Usage status of Miraculous Equip Enhancement Scroll (true:used, false:not used)
        /// </summary>
        [JsonProperty("starforce_scroll_flag")]
        public override string StarforceScrollFlag { get; set; }

        /// <summary>
        /// Equipment Star Force option information
        /// </summary>
        [JsonProperty("item_starforce_option")]
        public override CharacterItemEquipmentStarforceOptionDTO ItemStarforceOption { get; set; }

        /// <summary>
        /// Special Skill Ring
        /// </summary>
        [JsonProperty("special_ring_level")]
        public override long SpecialRingLevel { get; set; }

        /// <summary>
        /// Equipment expiration date (SGT)
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
        private string? _dateExpire;

        /// <summary>
        /// Whether the equipment is expired
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
