namespace MapleStory.OpenAPI.Common.DTO
{
    public abstract class CharacterItemEquipmentDTO<TCharacterItemEquipmentInfo, TCharacterItemEquipmentTitle, TCharacterItemEquipmentMedalShape, TCharacterItemEquipmentDragonInfo, TCharacterItemEquipmentMechanicInfo>
    {
        public abstract DateTimeOffset? Date { get; set; }
        public abstract string CharacterGender { get; set; }
        public abstract string CharacterClass { get; set; }
        public abstract int? PresetNo { get; set; }
        public abstract List<TCharacterItemEquipmentInfo> ItemEquipment { get; set; }
        public abstract List<TCharacterItemEquipmentInfo>? ItemEquipmentPreset1 { get; set; }
        public abstract List<TCharacterItemEquipmentInfo>? ItemEquipmentPreset2 { get; set; }
        public abstract List<TCharacterItemEquipmentInfo>? ItemEquipmentPreset3 { get; set; }
        public abstract TCharacterItemEquipmentTitle? Title { get; set; }
        public abstract TCharacterItemEquipmentMedalShape? MedalShape { get; set; }
        public abstract List<TCharacterItemEquipmentDragonInfo> DragonEquipment { get; set; }
        public abstract List<TCharacterItemEquipmentMechanicInfo> MechanicEquipment { get; set; }
    }

    public abstract class CharacterItemEquipmentDTO : CharacterItemEquipmentDTO<CharacterItemEquipmentInfoDTO, CharacterItemEquipmentTitleDTO, CharacterItemEquipmentMedalShapeDTO, CharacterItemEquipmentDragonInfoDTO, CharacterItemEquipmentMechanicInfoDTO>
    {

    }

    public abstract class CharacterItemEquipmentTitleDTO
    {
        public abstract string? TitleName { get; set; }
        public abstract string? TitleIcon { get; set; }
        public abstract string? TitleDescription { get; set; }
        public abstract DateTimeOffset? DateExpire { get; }
        public abstract bool? IsExpired { get; }
        public abstract DateTimeOffset? DateOptionExpire { get; }
        public abstract bool? IsOptionExpired { get; }
        public abstract string? TitleShapeName { get; set; }
        public abstract string? TitleShapeIcon { get; set; }
        public abstract string? TitleShapeDescription { get; set; }
    }

    public abstract class CharacterItemEquipmentMedalShapeDTO
    {
        public abstract string MedalShapeName { get; set; }
        public abstract string MedalShapeIcon { get; set; }
        public abstract string MedalShapeDescription { get; set; }
        public abstract string MedalShapeChangedName { get; set; }
        public abstract string MedalShapeChangedIcon { get; set; }
        public abstract string MedalShapeChangedDescription { get; set; }
    }

    public abstract class CharacterItemEquipmentAddOptionDTO
    {
        public abstract string Strength { get; set; }
        public abstract string Dexterity { get; set; }
        public abstract string Intelligence { get; set; }
        public abstract string Luck { get; set; }
        public abstract string MaxHp { get; set; }
        public abstract string MaxMp { get; set; }
        public abstract string AttackPower { get; set; }
        public abstract string MagicPower { get; set; }
        public abstract string Armor { get; set; }
        public abstract string Speed { get; set; }
        public abstract string Jump { get; set; }
        public abstract string BossDamage { get; set; }
        public abstract string Damage { get; set; }
        public abstract string AllStat { get; set; }
        public abstract long EquipmentLevelDecrease { get; set; }
    }


    public abstract class CharacterItemEquipmentBaseOptionDTO
    {
        public abstract string Strength { get; set; }
        public abstract string Dexterity { get; set; }
        public abstract string Intelligence { get; set; }
        public abstract string Luck { get; set; }
        public abstract string MaxHp { get; set; }
        public abstract string MaxMp { get; set; }
        public abstract string AttackPower { get; set; }
        public abstract string MagicPower { get; set; }
        public abstract string Armor { get; set; }
        public abstract string Speed { get; set; }
        public abstract string Jump { get; set; }
        public abstract string BossDamage { get; set; }
        public abstract string IgnoreMonsterArmor { get; set; }
        public abstract string AllStat { get; set; }
        public abstract string MaxHpRate { get; set; }
        public abstract string MaxMpRate { get; set; }
        public abstract long BaseEquipmentLevel { get; set; }
    }


    public abstract class CharacterItemEquipmentEtcOptionDTO
    {
        public abstract string Strength { get; set; }
        public abstract string Dexterity { get; set; }
        public abstract string Intelligence { get; set; }
        public abstract string Luck { get; set; }
        public abstract string MaxHp { get; set; }
        public abstract string MaxMp { get; set; }
        public abstract string AttackPower { get; set; }
        public abstract string MagicPower { get; set; }
        public abstract string Armor { get; set; }
        public abstract string Speed { get; set; }
        public abstract string Jump { get; set; }
    }


    public abstract class CharacterItemEquipmentExceptionalOptionDTO
    {
        public abstract string Strength { get; set; }
        public abstract string Dexterity { get; set; }
        public abstract string Intelligence { get; set; }
        public abstract string Luck { get; set; }
        public abstract string MaxHp { get; set; }
        public abstract string MaxMp { get; set; }
        public abstract string AttackPower { get; set; }
        public abstract string MagicPower { get; set; }
        public abstract int ExceptionalUpgrade { get; set; }
    }


    public abstract class CharacterItemEquipmentStarforceOptionDTO
    {
        public abstract string Strength { get; set; }
        public abstract string Dexterity { get; set; }
        public abstract string Intelligence { get; set; }
        public abstract string Luck { get; set; }
        public abstract string MaxHp { get; set; }
        public abstract string MaxMp { get; set; }
        public abstract string AttackPower { get; set; }
        public abstract string MagicPower { get; set; }
        public abstract string Armor { get; set; }
        public abstract string Speed { get; set; }
        public abstract string Jump { get; set; }
    }


    public abstract class CharacterItemEquipmentTotalOptionDTO
    {
        public abstract string Strength { get; set; }
        public abstract string Dexterity { get; set; }
        public abstract string Intelligence { get; set; }
        public abstract string Luck { get; set; }
        public abstract string MaxHp { get; set; }
        public abstract string MaxMp { get; set; }
        public abstract string AttackPower { get; set; }
        public abstract string MagicPower { get; set; }
        public abstract string Armor { get; set; }
        public abstract string Speed { get; set; }
        public abstract string Jump { get; set; }
        public abstract string BossDamage { get; set; }
        public abstract string IgnoreMonsterArmor { get; set; }
        public abstract string AllStat { get; set; }
        public abstract string Damage { get; set; }
        public abstract long EquipmentLevelDecrease { get; set; }
        public abstract string MaxHpRate { get; set; }
        public abstract string MaxMpRate { get; set; }
    }


    public abstract class CharacterItemEquipmentDragonInfoDTO<TCharacterItemEquipmentTotalOption, TCharacterItemEquipmentBaseOption, TCharacterItemEquipmentExceptionalOption, TCharacterItemEquipmentAddOption, TCharacterItemEquipmentEtcOption, TCharacterItemEquipmentStarforceOption>
    {
        public abstract string ItemEquipmentPart { get; set; }
        public abstract string ItemEquipmentSlot { get; set; }
        public abstract string ItemName { get; set; }
        public abstract string ItemIcon { get; set; }
        public abstract string? ItemDescription { get; set; }
        public abstract string ItemShapeName { get; set; }
        public abstract string ItemShapeIcon { get; set; }
        public abstract string? ItemGender { get; set; }
        public abstract TCharacterItemEquipmentTotalOption ItemTotalOption { get; set; }
        public abstract TCharacterItemEquipmentBaseOption ItemBaseOption { get; set; }
        public abstract long EquipmentLevelIncrease { get; set; }
        public abstract TCharacterItemEquipmentExceptionalOption ItemExceptionalOption { get; set; }
        public abstract TCharacterItemEquipmentAddOption ItemAddOption { get; set; }
        public abstract long GrowthExp { get; set; }
        public abstract long GrowthLevel { get; set; }
        public abstract string ScrollUpgrade { get; set; }
        public abstract string CuttableCount { get; set; }
        public abstract string GoldenHammerFlag { get; set; }
        public abstract string ScrollResilienceCount { get; set; }
        public abstract string ScrollUpgradeableCount { get; set; }
        public abstract string? SoulName { get; set; }
        public abstract string? SoulOption { get; set; }
        public abstract TCharacterItemEquipmentEtcOption ItemEtcOption { get; set; }
        public abstract string Starforce { get; set; }
        public abstract string StarforceScrollFlag { get; set; }
        public abstract TCharacterItemEquipmentStarforceOption ItemStarforceOption { get; set; }
        public abstract long SpecialRingLevel { get; set; }
        public abstract DateTimeOffset? DateExpire { get; }
        public abstract bool? IsExpired { get; }
    }

    public abstract class CharacterItemEquipmentDragonInfoDTO : CharacterItemEquipmentDragonInfoDTO<CharacterItemEquipmentTotalOptionDTO, CharacterItemEquipmentBaseOptionDTO, CharacterItemEquipmentExceptionalOptionDTO, CharacterItemEquipmentAddOptionDTO, CharacterItemEquipmentEtcOptionDTO, CharacterItemEquipmentStarforceOptionDTO>
    {

    }


    public abstract class CharacterItemEquipmentMechanicInfoDTO<TCharacterItemEquipmentTotalOption, TCharacterItemEquipmentBaseOption, TCharacterItemEquipmentExceptionalOption, TCharacterItemEquipmentAddOption, TCharacterItemEquipmentEtcOption, TCharacterItemEquipmentStarforceOption>
    {
        public abstract string ItemEquipmentPart { get; set; }
        public abstract string ItemEquipmentSlot { get; set; }
        public abstract string ItemName { get; set; }
        public abstract string ItemIcon { get; set; }
        public abstract string? ItemDescription { get; set; }
        public abstract string ItemShapeName { get; set; }
        public abstract string ItemShapeIcon { get; set; }
        public abstract string? ItemGender { get; set; }
        public abstract TCharacterItemEquipmentTotalOption ItemTotalOption { get; set; }
        public abstract TCharacterItemEquipmentBaseOption ItemBaseOption { get; set; }
        public abstract long EquipmentLevelIncrease { get; set; }
        public abstract TCharacterItemEquipmentExceptionalOption ItemExceptionalOption { get; set; }
        public abstract TCharacterItemEquipmentAddOption ItemAddOption { get; set; }
        public abstract long GrowthExp { get; set; }
        public abstract long GrowthLevel { get; set; }
        public abstract string ScrollUpgrade { get; set; }
        public abstract string CuttableCount { get; set; }
        public abstract string GoldenHammerFlag { get; set; }
        public abstract string ScrollResilienceCount { get; set; }
        public abstract string ScrollUpgradeableCount { get; set; }
        public abstract string? SoulName { get; set; }
        public abstract string? SoulOption { get; set; }
        public abstract TCharacterItemEquipmentEtcOption ItemEtcOption { get; set; }
        public abstract string Starforce { get; set; }
        public abstract string StarforceScrollFlag { get; set; }
        public abstract TCharacterItemEquipmentStarforceOption ItemStarforceOption { get; set; }
        public abstract long SpecialRingLevel { get; set; }
        public abstract DateTimeOffset? DateExpire { get; }
        public abstract bool? IsExpired { get; }
    }


    public abstract class CharacterItemEquipmentMechanicInfoDTO : CharacterItemEquipmentMechanicInfoDTO<CharacterItemEquipmentTotalOptionDTO, CharacterItemEquipmentBaseOptionDTO, CharacterItemEquipmentExceptionalOptionDTO, CharacterItemEquipmentAddOptionDTO, CharacterItemEquipmentEtcOptionDTO, CharacterItemEquipmentStarforceOptionDTO>
    {

    }

    public abstract class CharacterItemEquipmentInfoDTO<TCharacterItemEquipmentTotalOption, TCharacterItemEquipmentBaseOption, TCharacterItemEquipmentExceptionalOption, TCharacterItemEquipmentAddOption, TCharacterItemEquipmentEtcOption, TCharacterItemEquipmentStarforceOption>
    {
        public abstract string ItemEquipmentPart { get; set; }
        public abstract string ItemEquipmentSlot { get; set; }
        public abstract string ItemName { get; set; }
        public abstract string ItemIcon { get; set; }
        public abstract string? ItemDescription { get; set; }
        public abstract string ItemShapeName { get; set; }
        public abstract string ItemShapeIcon { get; set; }
        public abstract string? ItemGender { get; set; }
        public abstract TCharacterItemEquipmentTotalOption ItemTotalOption { get; set; }
        public abstract TCharacterItemEquipmentBaseOption ItemBaseOption { get; set; }
        public abstract string? PotentialOptionFlag { get; set; }
        public abstract string? AdditionalPotentialOptionFlag { get; set; }
        public abstract string? PotentialOptionGrade { get; set; }
        public abstract string? AdditionalPotentialOptionGrade { get; set; }
        public abstract string? PotentialOption1 { get; set; }
        public abstract string? PotentialOption2 { get; set; }
        public abstract string? PotentialOption3 { get; set; }
        public abstract string? AdditionalPotentialOption1 { get; set; }
        public abstract string? AdditionalPotentialOption2 { get; set; }
        public abstract string? AdditionalPotentialOption3 { get; set; }
        public abstract long EquipmentLevelIncrease { get; set; }
        public abstract TCharacterItemEquipmentExceptionalOption ItemExceptionalOption { get; set; }
        public abstract TCharacterItemEquipmentAddOption ItemAddOption { get; set; }
        public abstract long GrowthExp { get; set; }
        public abstract long GrowthLevel { get; set; }
        public abstract string ScrollUpgrade { get; set; }
        public abstract string CuttableCount { get; set; }
        public abstract string GoldenHammerFlag { get; set; }
        public abstract string ScrollResilienceCount { get; set; }
        public abstract string ScrollUpgradeableCount { get; set; }
        public abstract string? SoulName { get; set; }
        public abstract string? SoulOption { get; set; }
        public abstract TCharacterItemEquipmentEtcOption ItemEtcOption { get; set; }
        public abstract string Starforce { get; set; }
        public abstract string StarforceScrollFlag { get; set; }
        public abstract TCharacterItemEquipmentStarforceOption ItemStarforceOption { get; set; }
        public abstract long SpecialRingLevel { get; set; }
        public abstract DateTimeOffset? DateExpire { get; }
        public abstract bool? IsExpired { get; }
    }

    public abstract class CharacterItemEquipmentInfoDTO : CharacterItemEquipmentInfoDTO<CharacterItemEquipmentTotalOptionDTO, CharacterItemEquipmentBaseOptionDTO, CharacterItemEquipmentExceptionalOptionDTO, CharacterItemEquipmentAddOptionDTO, CharacterItemEquipmentEtcOptionDTO, CharacterItemEquipmentStarforceOptionDTO>
    {

    }
}
