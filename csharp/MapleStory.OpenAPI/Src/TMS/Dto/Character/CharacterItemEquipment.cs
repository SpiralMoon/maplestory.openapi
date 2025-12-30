using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.TMS.DTO
{
    /// <summary>
    /// 角色已裝備道具資訊
    /// </summary>
    public class CharacterItemEquipmentDTO : Base.CharacterItemEquipmentDTO<
        CharacterItemEquipmentInfoDTO,
        CharacterItemEquipmentTitleDTO,
        CharacterItemEquipmentMedalShapeDTO,
        CharacterItemEquipmentDragonInfoDTO,
        CharacterItemEquipmentMechanicInfoDTO>
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
        /// 目前套用的道具預設編號
        /// </summary>
        [JsonProperty("preset_no")]
        public override int? PresetNo { get; set; }

        /// <summary>
        /// 道具資訊
        /// </summary>
        [JsonProperty("item_equipment")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterItemEquipmentInfoDTO> ItemEquipment { get; set; } = new();

        /// <summary>
        /// 預設 1 的道具資訊
        /// </summary>
        [JsonProperty("item_equipment_preset_1")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterItemEquipmentInfoDTO> ItemEquipmentPreset1 { get; set; } = new();

        /// <summary>
        /// 預設 2 的道具資訊
        /// </summary>
        [JsonProperty("item_equipment_preset_2")]
        public override List<CharacterItemEquipmentInfoDTO>? ItemEquipmentPreset2 { get; set; }

        /// <summary>
        /// 預設 3 的道具資訊
        /// </summary>
        [JsonProperty("item_equipment_preset_3")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterItemEquipmentInfoDTO> ItemEquipmentPreset3 { get; set; } = new();

        /// <summary>
        /// 稱號資訊
        /// </summary>
        [JsonProperty("title")]
        public override CharacterItemEquipmentTitleDTO? Title { get; set; }

        /// <summary>
        /// 外型設定中已登錄勳章的外型資訊
        /// </summary>
        [JsonProperty("medal_shape")]
        public override CharacterItemEquipmentMedalShapeDTO? MedalShape { get; set; }

        /// <summary>
        /// 龍魔導士的龍道具資訊 (僅在龍魔導士時回應)
        /// </summary>
        [JsonProperty("dragon_equipment")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterItemEquipmentDragonInfoDTO> DragonEquipment { get; set; } = new();

        /// <summary>
        /// 機甲戰神道具資訊 (僅在機甲戰神時回應)
        /// </summary>
        [JsonProperty("mechanic_equipment")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterItemEquipmentMechanicInfoDTO> MechanicEquipment { get; set; } = new();
    }

    /// <summary>
    /// 稱號資訊
    /// </summary>
    public class CharacterItemEquipmentTitleDTO : Base.CharacterItemEquipmentTitleDTO
    {
        /// <summary>
        /// 稱號道具名稱
        /// </summary>
        [JsonProperty("title_name")]
        public override string? TitleName { get; set; }

        /// <summary>
        /// 稱號圖示
        /// </summary>
        [JsonProperty("title_icon")]
        public override string? TitleIcon { get; set; }

        /// <summary>
        /// 稱號描述
        /// </summary>
        [JsonProperty("title_description")]
        public override string? TitleDescription { get; set; }

        /// <summary>
        /// 稱號有效期間 (TST)
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
        /// 稱號選項有效期間 (expired：已到期，null：無限期) (TST)
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
        /// 外型設定中已登錄稱號的道具名稱
        /// </summary>
        [JsonProperty("title_shape_name")]
        public override string? TitleShapeName { get; set; }

        /// <summary>
        /// 外型設定中已登錄稱號的圖示
        /// </summary>
        [JsonProperty("title_shape_icon")]
        public override string? TitleShapeIcon { get; set; }

        /// <summary>
        /// 外型設定中已登錄稱號的描述
        /// </summary>
        [JsonProperty("title_shape_description")]
        public override string? TitleShapeDescription { get; set; }
    }

    /// <summary>
    /// 外型設定中已登錄勳章的外型資訊
    /// </summary>
    public class CharacterItemEquipmentMedalShapeDTO : Base.CharacterItemEquipmentMedalShapeDTO
    {
        /// <summary>
        /// 外型設定中已登錄勳章的道具名稱
        /// </summary>
        [JsonProperty("medal_shape_name")]
        public override string MedalShapeName { get; set; }

        /// <summary>
        /// 外型設定中已登錄勳章的圖示
        /// </summary>
        [JsonProperty("medal_shape_icon")]
        public override string MedalShapeIcon { get; set; }

        /// <summary>
        /// 外型設定中已登錄勳章的描述
        /// </summary>
        [JsonProperty("medal_shape_description")]
        public override string MedalShapeDescription { get; set; }

        /// <summary>
        /// 外型設定中已登錄勳章的鐵砧套用道具名稱
        /// </summary>
        [JsonProperty("medal_shape_changed_name")]
        public override string MedalShapeChangedName { get; set; }

        /// <summary>
        /// 外型設定中已登錄勳章的鐵砧套用圖示
        /// </summary>
        [JsonProperty("medal_shape_changed_icon")]
        public override string MedalShapeChangedIcon { get; set; }

        /// <summary>
        /// 外型設定中已登錄勳章的鐵砧套用勳章說明
        /// </summary>
        [JsonProperty("medal_shape_changed_description")]
        public override string MedalShapeChangedDescription { get; set; }
    }

    /// <summary>
    /// 附加道具選項
    /// </summary>
    public class CharacterItemEquipmentAddOptionDTO : Base.CharacterItemEquipmentAddOptionDTO
    {
        /// <summary>
        /// 力量 (STR)
        /// </summary>
        [JsonProperty("str")]
        public override string Strength { get; set; }

        /// <summary>
        /// 敏捷 (DEX)
        /// </summary>
        [JsonProperty("dex")]
        public override string Dexterity { get; set; }

        /// <summary>
        /// 敏捷 (DEX)
        /// </summary>
        [JsonProperty("int")]
        public override string Intelligence { get; set; }

        /// <summary>
        /// 幸運 (LUK)
        /// </summary>
        [JsonProperty("luk")]
        public override string Luck { get; set; }

        /// <summary>
        /// 最大體力 (HP)
        /// </summary>
        [JsonProperty("max_hp")]
        public override string MaxHp { get; set; }

        /// <summary>
        /// 最大 MP
        /// </summary>
        [JsonProperty("max_mp")]
        public override string MaxMp { get; set; }

        /// <summary>
        /// 攻擊力
        /// </summary>
        [JsonProperty("attack_power")]
        public override string AttackPower { get; set; }

        /// <summary>
        /// 魔力
        /// </summary>
        [JsonProperty("magic_power")]
        public override string MagicPower { get; set; }

        /// <summary>
        /// 防禦力
        /// </summary>
        [JsonProperty("armor")]
        public override string Armor { get; set; }

        /// <summary>
        /// 移動速度
        /// </summary>
        [JsonProperty("speed")]
        public override string Speed { get; set; }

        /// <summary>
        /// 跳躍力
        /// </summary>
        [JsonProperty("jump")]
        public override string Jump { get; set; }

        /// <summary>
        /// 對首領傷害增加 (%)
        /// </summary>
        [JsonProperty("boss_damage")]
        public override string BossDamage { get; set; }

        /// <summary>
        /// 傷害 (%)
        /// </summary>
        [JsonProperty("damage")]
        public override string Damage { get; set; }

        /// <summary>
        /// 全部能力值 (%)
        /// </summary>
        [JsonProperty("all_stat")]
        public override string AllStat { get; set; }

        /// <summary>
        /// 裝備等級減少
        /// </summary>
        [JsonProperty("equipment_level_decrease")]
        public override long EquipmentLevelDecrease { get; set; }
    }

    /// <summary>
    /// 道具基本選項資訊
    /// </summary>
    public class CharacterItemEquipmentBaseOptionDTO : Base.CharacterItemEquipmentBaseOptionDTO
    {
        /// <summary>
        /// 力量 (STR)
        /// </summary>
        [JsonProperty("str")]
        public override string Strength { get; set; }

        /// <summary>
        /// 敏捷 (DEX)
        /// </summary>
        [JsonProperty("dex")]
        public override string Dexterity { get; set; }

        /// <summary>
        /// 敏捷 (DEX)
        /// </summary>
        [JsonProperty("int")]
        public override string Intelligence { get; set; }

        /// <summary>
        /// 幸運 (LUK)
        /// </summary>
        [JsonProperty("luk")]
        public override string Luck { get; set; }

        /// <summary>
        /// 最大體力 (HP)
        /// </summary>
        [JsonProperty("max_hp")]
        public override string MaxHp { get; set; }

        /// <summary>
        /// 最大 MP
        /// </summary>
        [JsonProperty("max_mp")]
        public override string MaxMp { get; set; }

        /// <summary>
        /// 攻擊力
        /// </summary>
        [JsonProperty("attack_power")]
        public override string AttackPower { get; set; }

        /// <summary>
        /// 魔力
        /// </summary>
        [JsonProperty("magic_power")]
        public override string MagicPower { get; set; }

        /// <summary>
        /// 防禦力
        /// </summary>
        [JsonProperty("armor")]
        public override string Armor { get; set; }

        /// <summary>
        /// 移動速度
        /// </summary>
        [JsonProperty("speed")]
        public override string Speed { get; set; }

        /// <summary>
        /// 跳躍力
        /// </summary>
        [JsonProperty("jump")]
        public override string Jump { get; set; }

        /// <summary>
        /// 對首領傷害增加 (%)
        /// </summary>
        [JsonProperty("boss_damage")]
        public override string BossDamage { get; set; }

        /// <summary>
        /// 無視怪物防禦力 (%)
        /// </summary>
        [JsonProperty("ignore_monster_armor")]
        public override string IgnoreMonsterArmor { get; set; }

        /// <summary>
        /// 全部能力值 (%)
        /// </summary>
        [JsonProperty("all_stat")]
        public override string AllStat { get; set; }

        /// <summary>
        /// 最大體力 (HP) (%)
        /// </summary>
        [JsonProperty("max_hp_rate")]
        public override string MaxHpRate { get; set; }

        /// <summary>
        /// 最大 MP (%)
        /// </summary>
        [JsonProperty("max_mp_rate")]
        public override string MaxMpRate { get; set; }

        /// <summary>
        ///裝備基本等級
        /// </summary>
        [JsonProperty("base_equipment_level")]
        public override long BaseEquipmentLevel { get; set; }
    }

    /// <summary>
    /// 道具其他選項資訊
    /// </summary>
    public class CharacterItemEquipmentEtcOptionDTO : Base.CharacterItemEquipmentEtcOptionDTO
    {
        /// <summary>
        /// 力量 (STR)
        /// </summary>
        [JsonProperty("str")]
        public override string Strength { get; set; }

        /// <summary>
        /// 敏捷 (DEX)
        /// </summary>
        [JsonProperty("dex")]
        public override string Dexterity { get; set; }

        /// <summary>
        /// 敏捷 (DEX)
        /// </summary>
        [JsonProperty("int")]
        public override string Intelligence { get; set; }

        /// <summary>
        /// 幸運 (LUK)
        /// </summary>
        [JsonProperty("luk")]
        public override string Luck { get; set; }

        /// <summary>
        /// 最大體力 (HP)
        /// </summary>
        [JsonProperty("max_hp")]
        public override string MaxHp { get; set; }

        /// <summary>
        /// 最大 MP
        /// </summary>
        [JsonProperty("max_mp")]
        public override string MaxMp { get; set; }

        /// <summary>
        /// 攻擊力
        /// </summary>
        [JsonProperty("attack_power")]
        public override string AttackPower { get; set; }

        /// <summary>
        /// 魔力
        /// </summary>
        [JsonProperty("magic_power")]
        public override string MagicPower { get; set; }

        /// <summary>
        /// 防禦力
        /// </summary>
        [JsonProperty("armor")]
        public override string Armor { get; set; }

        /// <summary>
        /// 移動速度
        /// </summary>
        [JsonProperty("speed")]
        public override string Speed { get; set; }

        /// <summary>
        /// 跳躍力
        /// </summary>
        [JsonProperty("jump")]
        public override string Jump { get; set; }
    }

    /// <summary>
    /// 道具特殊選項資訊
    /// </summary>
    public class CharacterItemEquipmentExceptionalOptionDTO : Base.CharacterItemEquipmentExceptionalOptionDTO
    {
        /// <summary>
        /// 力量 (STR)
        /// </summary>
        [JsonProperty("str")]
        public override string Strength { get; set; }

        /// <summary>
        /// 敏捷 (DEX)
        /// </summary>
        [JsonProperty("dex")]
        public override string Dexterity { get; set; }

        /// <summary>
        /// 敏捷 (DEX)
        /// </summary>
        [JsonProperty("int")]
        public override string Intelligence { get; set; }

        /// <summary>
        /// 幸運 (LUK)
        /// </summary>
        [JsonProperty("luk")]
        public override string Luck { get; set; }

        /// <summary>
        /// 最大體力 (HP)
        /// </summary>
        [JsonProperty("max_hp")]
        public override string MaxHp { get; set; }

        /// <summary>
        /// 最大 MP
        /// </summary>
        [JsonProperty("max_mp")]
        public override string MaxMp { get; set; }

        /// <summary>
        /// 攻擊力
        /// </summary>
        [JsonProperty("attack_power")]
        public override string AttackPower { get; set; }

        /// <summary>
        /// 魔力
        /// </summary>
        [JsonProperty("magic_power")]
        public override string MagicPower { get; set; }

        /// <summary>
        /// 已套用的卓越強化次數
        /// </summary>
        [JsonProperty("exceptional_upgrade")]
        [JsonConverter(typeof(DefaultValueConverter<int>), 0)]
        public override int ExceptionalUpgrade { get; set; } = 0;
    }

    /// <summary>
    /// 道具星星力量資訊
    /// </summary>
    public class CharacterItemEquipmentStarforceOptionDTO : Base.CharacterItemEquipmentStarforceOptionDTO
    {
        /// <summary>
        /// 力量 (STR)
        /// </summary>
        [JsonProperty("str")]
        public override string Strength { get; set; }

        /// <summary>
        /// 敏捷 (DEX)
        /// </summary>
        [JsonProperty("dex")]
        public override string Dexterity { get; set; }

        /// <summary>
        /// 敏捷 (DEX)
        /// </summary>
        [JsonProperty("int")]
        public override string Intelligence { get; set; }

        /// <summary>
        /// 幸運 (LUK)
        /// </summary>
        [JsonProperty("luk")]
        public override string Luck { get; set; }

        /// <summary>
        /// 最大體力 (HP)
        /// </summary>
        [JsonProperty("max_hp")]
        public override string MaxHp { get; set; }

        /// <summary>
        /// 最大 MP
        /// </summary>
        [JsonProperty("max_mp")]
        public override string MaxMp { get; set; }

        /// <summary>
        /// 攻擊力
        /// </summary>
        [JsonProperty("attack_power")]
        public override string AttackPower { get; set; }

        /// <summary>
        /// 魔力
        /// </summary>
        [JsonProperty("magic_power")]
        public override string MagicPower { get; set; }

        /// <summary>
        /// 防禦力
        /// </summary>
        [JsonProperty("armor")]
        public override string Armor { get; set; }

        /// <summary>
        /// 移動速度
        /// </summary>
        [JsonProperty("speed")]
        public override string Speed { get; set; }

        /// <summary>
        /// 跳躍力
        /// </summary>
        [JsonProperty("jump")]
        public override string Jump { get; set; }
    }

    /// <summary>
    /// 道具最終選項資訊
    /// </summary>
    public class CharacterItemEquipmentTotalOptionDTO : Base.CharacterItemEquipmentTotalOptionDTO
    {
        /// <summary>
        /// 力量 (STR)
        /// </summary>
        [JsonProperty("str")]
        public override string Strength { get; set; }

        /// <summary>
        /// 敏捷 (DEX)
        /// </summary>
        [JsonProperty("dex")]
        public override string Dexterity { get; set; }

        /// <summary>
        /// 敏捷 (DEX)
        /// </summary>
        [JsonProperty("int")]
        public override string Intelligence { get; set; }

        /// <summary>
        /// 幸運 (LUK)
        /// </summary>
        [JsonProperty("luk")]
        public override string Luck { get; set; }

        /// <summary>
        /// 最大體力 (HP)
        /// </summary>
        [JsonProperty("max_hp")]
        public override string MaxHp { get; set; }

        /// <summary>
        /// 最大 MP
        /// </summary>
        [JsonProperty("max_mp")]
        public override string MaxMp { get; set; }

        /// <summary>
        /// 攻擊力
        /// </summary>
        [JsonProperty("attack_power")]
        public override string AttackPower { get; set; }

        /// <summary>
        /// 魔力
        /// </summary>
        [JsonProperty("magic_power")]
        public override string MagicPower { get; set; }

        /// <summary>
        /// 防禦力
        /// </summary>
        [JsonProperty("armor")]
        public override string Armor { get; set; }

        /// <summary>
        /// 移動速度
        /// </summary>
        [JsonProperty("speed")]
        public override string Speed { get; set; }

        /// <summary>
        /// 跳躍力
        /// </summary>
        [JsonProperty("jump")]
        public override string Jump { get; set; }

        /// <summary>
        /// 對首領傷害增加 (%)
        /// </summary>
        [JsonProperty("boss_damage")]
        public override string BossDamage { get; set; }

        /// <summary>
        /// 無視怪物防禦力 (%)
        /// </summary>
        [JsonProperty("ignore_monster_armor")]
        public override string IgnoreMonsterArmor { get; set; }

        /// <summary>
        /// 全部能力值 (%)
        /// </summary>
        [JsonProperty("all_stat")]
        public override string AllStat { get; set; }

        /// <summary>
        /// 傷害 (%)
        /// </summary>
        public override string Damage { get; set; }

        /// <summary>
        /// 裝備等級減少s
        /// </summary>
        [JsonProperty("equipment_level_decrease")]
        public override long EquipmentLevelDecrease { get; set; }

        /// <summary>
        /// 最大體力 (HP) (%)
        /// </summary>
        [JsonProperty("max_hp_rate")]
        public override string MaxHpRate { get; set; }

        /// <summary>
        /// 最大 MP (%)
        /// </summary>
        [JsonProperty("max_mp_rate")]
        public override string MaxMpRate { get; set; }
    }

    /// <summary>
    /// 龍魔導士的龍道具資訊 (僅在龍魔導士時回應)
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
        /// 道具部位名稱
        /// </summary>
        [JsonProperty("item_equipment_part")]
        public override string ItemEquipmentPart { get; set; }

        /// <summary>
        /// 道具欄位位置
        /// </summary>
        [JsonProperty("item_equipment_slot")]
        public override string ItemEquipmentSlot { get; set; }

        /// <summary>
        /// 道具名稱
        /// </summary>
        [JsonProperty("item_name")]
        public override string ItemName { get; set; }

        /// <summary>
        /// 道具圖示
        /// </summary>
        [JsonProperty("item_icon")]
        public override string ItemIcon { get; set; }

        /// <summary>
        /// 道具描述
        /// </summary>
        [JsonProperty("item_description")]
        public override string? ItemDescription { get; set; }

        /// <summary>
        /// 道具外型
        /// </summary>
        [JsonProperty("item_shape_name")]
        public override string ItemShapeName { get; set; }

        /// <summary>
        /// 道具外型圖示
        /// </summary>
        [JsonProperty("item_shape_icon")]
        public override string ItemShapeIcon { get; set; }

        /// <summary>
        /// 性別限定
        /// </summary>
        [JsonProperty("item_gender")]
        public override string? ItemGender { get; set; }

        /// <summary>
        /// 道具最終選項資訊
        /// </summary>
        [JsonProperty("item_total_option")]
        public override CharacterItemEquipmentTotalOptionDTO ItemTotalOption { get; set; }

        /// <summary>
        /// 道具基本選項資訊
        /// </summary>
        [JsonProperty("item_base_option")]
        public override CharacterItemEquipmentBaseOptionDTO ItemBaseOption { get; set; }

        /// <summary>
        /// 裝備等級增加
        /// </summary>
        [JsonProperty("equipment_level_increase")]
        public override long EquipmentLevelIncrease { get; set; }

        /// <summary>
        /// 道具特殊選項資訊
        /// </summary>
        [JsonProperty("item_exceptional_option")]
        public override CharacterItemEquipmentExceptionalOptionDTO ItemExceptionalOption { get; set; }

        /// <summary>
        /// 附加道具選項
        /// </summary>
        [JsonProperty("item_add_option")]
        public override CharacterItemEquipmentAddOptionDTO ItemAddOption { get; set; }

        /// <summary>
        /// 成長經驗值
        /// </summary>
        [JsonProperty("growth_exp")]
        public override long GrowthExp { get; set; }

        /// <summary>
        /// 成長等級
        /// </summary>
        [JsonProperty("growth_level")]
        public override long GrowthLevel { get; set; }

        /// <summary>
        /// 強化次數
        /// </summary>
        [JsonProperty("scroll_upgrade")]
        public override string ScrollUpgrade { get; set; }

        /// <summary>
        /// 可使用剪刀的次數 (不可交易道具、可交易但從未使用剪刀的道具：255)
        /// </summary>
        [JsonProperty("cuttable_count")]
        public override string CuttableCount { get; set; }

        /// <summary>
        /// 黃金鐵鎚精煉 (true：已套用，false：未套用)
        /// </summary>
        [JsonProperty("golden_hammer_flag")]
        public override string GoldenHammerFlag { get; set; }

        /// <summary>
        /// 道具可復原次數
        /// </summary>
        [JsonProperty("scroll_resilience_count")]
        public override string ScrollResilienceCount { get; set; }

        /// <summary>
        /// 道具可升級次數
        /// </summary>
        [JsonProperty("scroll_upgradeable_count")]
        public override string ScrollUpgradeableCount { get; set; }

        /// <summary>
        /// 靈魂名稱
        /// </summary>
        [JsonProperty("soul_name")]
        public override string? SoulName { get; set; }

        /// <summary>
        /// 靈魂選項
        /// </summary>
        [JsonProperty("soul_option")]
        public override string? SoulOption { get; set; }

        /// <summary>
        /// 道具其他選項資訊
        /// </summary>
        [JsonProperty("item_etc_option")]
        public override CharacterItemEquipmentEtcOptionDTO ItemEtcOption { get; set; }

        /// <summary>
        /// 強化階級
        /// </summary>
        [JsonProperty("starforce")]
        public override string Starforce { get; set; }

        /// <summary>
        /// 驚異道具強化卷軸 (true：已使用，false：未使用)
        /// </summary>
        [JsonProperty("starforce_scroll_flag")]
        public override string StarforceScrollFlag { get; set; }

        /// <summary>
        /// 道具星星力量資訊
        /// </summary>
        [JsonProperty("item_starforce_option")]
        public override CharacterItemEquipmentStarforceOptionDTO ItemStarforceOption { get; set; }

        /// <summary>
        /// 特殊戒指等級
        /// </summary>
        [JsonProperty("special_ring_level")]
        public override long SpecialRingLevel { get; set; }

        /// <summary>
        /// 道具有效期間 (TST)
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
        /// 自由造型券 使用狀態（0：未使用，1：已使用）
        /// </summary>
        [JsonProperty("freestyle_flag")]
        public override string? FreestyleFlag { get; set; }

        /// <summary>
        /// 自由造型券 使用狀態
        /// </summary>
        public bool IsFreestyleFlag
        {
            get => this.FreestyleFlag == "1";
        }
    }


    /// <summary>
    /// 機甲戰神道具資訊
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
        /// 道具部位名稱
        /// </summary>
        [JsonProperty("item_equipment_part")]
        public override string ItemEquipmentPart { get; set; }

        /// <summary>
        /// 道具欄位位置
        /// </summary>
        [JsonProperty("item_equipment_slot")]
        public override string ItemEquipmentSlot { get; set; }

        /// <summary>
        /// 道具名稱
        /// </summary>
        [JsonProperty("item_name")]
        public override string ItemName { get; set; }

        /// <summary>
        /// 道具圖示
        /// </summary>
        [JsonProperty("item_icon")]
        public override string ItemIcon { get; set; }

        /// <summary>
        /// 道具描述
        /// </summary>
        [JsonProperty("item_description")]
        public override string? ItemDescription { get; set; }

        /// <summary>
        /// 道具外型
        /// </summary>
        [JsonProperty("item_shape_name")]
        public override string ItemShapeName { get; set; }

        /// <summary>
        /// 道具外型圖示
        /// </summary>
        [JsonProperty("item_shape_icon")]
        public override string ItemShapeIcon { get; set; }

        /// <summary>
        /// 性別限定
        /// </summary>
        [JsonProperty("item_gender")]
        public override string? ItemGender { get; set; }

        /// <summary>
        /// 道具最終選項資訊
        /// </summary>
        [JsonProperty("item_total_option")]
        public override CharacterItemEquipmentTotalOptionDTO ItemTotalOption { get; set; }

        /// <summary>
        /// 道具基本選項資訊
        /// </summary>
        [JsonProperty("item_base_option")]
        public override CharacterItemEquipmentBaseOptionDTO ItemBaseOption { get; set; }

        /// <summary>
        /// 裝備等級增加
        /// </summary>
        [JsonProperty("equipment_level_increase")]
        public override long EquipmentLevelIncrease { get; set; }

        /// <summary>
        /// 道具特殊選項資訊
        /// </summary>
        [JsonProperty("item_exceptional_option")]
        public override CharacterItemEquipmentExceptionalOptionDTO ItemExceptionalOption { get; set; }

        /// <summary>
        /// 附加道具選項
        /// </summary>
        [JsonProperty("item_add_option")]
        public override CharacterItemEquipmentAddOptionDTO ItemAddOption { get; set; }

        /// <summary>
        /// 成長經驗值
        /// </summary>
        [JsonProperty("growth_exp")]
        public override long GrowthExp { get; set; }

        /// <summary>
        /// 成長等級
        /// </summary>
        [JsonProperty("growth_level")]
        public override long GrowthLevel { get; set; }

        /// <summary>
        /// 強化次數
        /// </summary>
        [JsonProperty("scroll_upgrade")]
        public override string ScrollUpgrade { get; set; }

        /// <summary>
        /// 可使用剪刀的次數 (不可交易道具、可交易但從未使用剪刀的道具：255)
        /// </summary>
        [JsonProperty("cuttable_count")]
        public override string CuttableCount { get; set; }

        /// <summary>
        /// 黃金鐵鎚精煉 (true：已套用，false：未套用)
        /// </summary>
        [JsonProperty("golden_hammer_flag")]
        public override string GoldenHammerFlag { get; set; }

        /// <summary>
        /// 道具可復原次數
        /// </summary>
        [JsonProperty("scroll_resilience_count")]
        public override string ScrollResilienceCount { get; set; }

        /// <summary>
        /// 道具可升級次數
        /// </summary>
        [JsonProperty("scroll_upgradeable_count")]
        public override string ScrollUpgradeableCount { get; set; }

        /// <summary>
        /// 靈魂名稱
        /// </summary>
        [JsonProperty("soul_name")]
        public override string? SoulName { get; set; }

        /// <summary>
        /// 靈魂選項
        /// </summary>
        [JsonProperty("soul_option")]
        public override string? SoulOption { get; set; }

        /// <summary>
        /// 道具其他選項資訊
        /// </summary>
        [JsonProperty("item_etc_option")]
        public override CharacterItemEquipmentEtcOptionDTO ItemEtcOption { get; set; }

        /// <summary>
        /// 強化階級
        /// </summary>
        [JsonProperty("starforce")]
        public override string Starforce { get; set; }

        /// <summary>
        /// 驚異道具強化卷軸 (true：已使用，false：未使用)
        /// </summary>
        [JsonProperty("starforce_scroll_flag")]
        public override string StarforceScrollFlag { get; set; }

        /// <summary>
        /// 道具星星力量資訊
        /// </summary>
        [JsonProperty("item_starforce_option")]
        public override CharacterItemEquipmentStarforceOptionDTO ItemStarforceOption { get; set; }

        /// <summary>
        /// 特殊戒指等級
        /// </summary>
        [JsonProperty("special_ring_level")]
        public override long SpecialRingLevel { get; set; }

        /// <summary>
        /// 道具有效期間 (TST)
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
        /// 自由造型券 使用狀態（0：未使用，1：已使用）
        /// </summary>
        [JsonProperty("freestyle_flag")]
        public override string? FreestyleFlag { get; set; }

        /// <summary>
        /// 自由造型券 使用狀態
        /// </summary>
        public bool IsFreestyleFlag
        {
            get => this.FreestyleFlag == "1";
        }
    }

    /// <summary>
    /// 道具資訊
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
        /// 道具部位名稱
        /// </summary>
        [JsonProperty("item_equipment_part")]
        public override string ItemEquipmentPart { get; set; }

        /// <summary>
        /// 道具欄位位置
        /// </summary>
        [JsonProperty("item_equipment_slot")]
        public override string ItemEquipmentSlot { get; set; }

        /// <summary>
        /// 道具名稱
        /// </summary>
        [JsonProperty("item_name")]
        public override string ItemName { get; set; }

        /// <summary>
        /// 道具圖示
        /// </summary>
        [JsonProperty("item_icon")]
        public override string ItemIcon { get; set; }

        /// <summary>
        /// 道具描述
        /// </summary>
        [JsonProperty("item_description")]
        public override string? ItemDescription { get; set; }

        /// <summary>
        /// 道具外型
        /// </summary>
        [JsonProperty("item_shape_name")]
        public override string ItemShapeName { get; set; }

        /// <summary>
        /// 道具外型圖示
        /// </summary>
        [JsonProperty("item_shape_icon")]
        public override string ItemShapeIcon { get; set; }

        /// <summary>
        /// 性別限定
        /// </summary>
        [JsonProperty("item_gender")]
        public override string? ItemGender { get; set; }

        /// <summary>
        /// 道具最終選項資訊
        /// </summary>
        [JsonProperty("item_total_option")]
        public override CharacterItemEquipmentTotalOptionDTO ItemTotalOption { get; set; }

        /// <summary>
        /// 道具基本選項資訊
        /// </summary>
        [JsonProperty("item_base_option")]
        public override CharacterItemEquipmentBaseOptionDTO ItemBaseOption { get; set; }

        /// <summary>
        /// 潛在能力封印狀態 (true：已封印，false：未封印)
        /// </summary>
        [JsonProperty("potential_option_flag")]
        public override string? PotentialOptionFlag { get; set; }

        /// <summary>
        /// 附加潛在能力封印狀態 (true：已封印，false：未封印)
        /// </summary>
        [JsonProperty("additional_potential_option_flag")]
        public override string? AdditionalPotentialOptionFlag { get; set; }

        /// <summary>
        /// 潛在能力階級
        /// </summary>
        [JsonProperty("potential_option_grade")]
        public override string? PotentialOptionGrade { get; set; }

        /// <summary>
        /// 附加潛在能力階級
        /// </summary>
        [JsonProperty("additional_potential_option_grade")]
        public override string? AdditionalPotentialOptionGrade { get; set; }

        /// <summary>
        /// 第一潛在能力選項
        /// </summary>
        [JsonProperty("potential_option_1")]
        public override string? PotentialOption1 { get; set; }

        /// <summary>
        /// 第二潛在能力選項
        /// </summary>
        [JsonProperty("potential_option_2")]
        public override string? PotentialOption2 { get; set; }

        /// <summary>
        /// 第三潛在能力選項
        /// </summary>
        [JsonProperty("potential_option_3")]
        public override string? PotentialOption3 { get; set; }

        /// <summary>
        /// 第一附加潛在能力選項
        /// </summary>
        [JsonProperty("additional_potential_option_1")]
        public override string? AdditionalPotentialOption1 { get; set; }

        /// <summary>
        /// 第二附加潛在能力選項
        /// </summary>
        [JsonProperty("additional_potential_option_2")]
        public override string? AdditionalPotentialOption2 { get; set; }

        /// <summary>
        /// 第三附加潛在能力選項
        /// </summary>
        [JsonProperty("additional_potential_option_3")]
        public override string? AdditionalPotentialOption3 { get; set; }

        /// <summary>
        /// 裝備等級增加
        /// </summary>
        [JsonProperty("equipment_level_increase")]
        public override long EquipmentLevelIncrease { get; set; }

        /// <summary>
        /// 道具特殊選項資訊
        /// </summary>
        [JsonProperty("item_exceptional_option")]
        public override CharacterItemEquipmentExceptionalOptionDTO ItemExceptionalOption { get; set; }

        /// <summary>
        /// 附加道具選項
        /// </summary>
        [JsonProperty("item_add_option")]
        public override CharacterItemEquipmentAddOptionDTO ItemAddOption { get; set; }

        /// <summary>
        /// 成長經驗值
        /// </summary>
        [JsonProperty("growth_exp")]
        public override long GrowthExp { get; set; }

        /// <summary>
        /// 成長等級
        /// </summary>
        [JsonProperty("growth_level")]
        public override long GrowthLevel { get; set; }

        /// <summary>
        /// 強化次數
        /// </summary>
        [JsonProperty("scroll_upgrade")]
        public override string ScrollUpgrade { get; set; }

        /// <summary>
        /// 可使用剪刀的次數 (不可交易道具、可交易但從未使用剪刀的道具：255)
        /// </summary>
        [JsonProperty("cuttable_count")]
        public override string CuttableCount { get; set; }

        /// <summary>
        /// 黃金鐵鎚精煉 (true：已套用，false：未套用)
        /// </summary>
        [JsonProperty("golden_hammer_flag")]
        public override string GoldenHammerFlag { get; set; }

        /// <summary>
        /// 道具可復原次數
        /// </summary>
        [JsonProperty("scroll_resilience_count")]
        public override string ScrollResilienceCount { get; set; }

        /// <summary>
        /// 道具可升級次數
        /// </summary>
        [JsonProperty("scroll_upgradeable_count")]
        public override string ScrollUpgradeableCount { get; set; }

        /// <summary>
        /// 靈魂名稱
        /// </summary>
        [JsonProperty("soul_name")]
        public override string? SoulName { get; set; }

        /// <summary>
        /// 靈魂選項
        /// </summary>
        [JsonProperty("soul_option")]
        public override string? SoulOption { get; set; }

        /// <summary>
        /// 道具其他選項資訊
        /// </summary>
        [JsonProperty("item_etc_option")]
        public override CharacterItemEquipmentEtcOptionDTO ItemEtcOption { get; set; }

        /// <summary>
        /// 強化階級
        /// </summary>
        [JsonProperty("starforce")]
        public override string Starforce { get; set; }

        /// <summary>
        /// 驚異道具強化卷軸 (true：已使用，false：未使用)
        /// </summary>
        [JsonProperty("starforce_scroll_flag")]
        public override string StarforceScrollFlag { get; set; }

        /// <summary>
        /// 道具星星力量資訊
        /// </summary>
        [JsonProperty("item_starforce_option")]
        public override CharacterItemEquipmentStarforceOptionDTO ItemStarforceOption { get; set; }

        /// <summary>
        /// 特殊戒指等級
        /// </summary>
        [JsonProperty("special_ring_level")]
        public override long SpecialRingLevel { get; set; }

        /// <summary>
        /// 道具有效期間 (TST)
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
        /// 自由造型券 使用狀態（0：未使用，1：已使用）
        /// </summary>
        [JsonProperty("freestyle_flag")]
        public override string? FreestyleFlag { get; set; }

        /// <summary>
        /// 自由造型券 使用狀態
        /// </summary>
        public bool IsFreestyleFlag
        {
            get => this.FreestyleFlag == "1";
        }
    }
}
