using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 캐릭터 장비 아이템 정보
    /// </summary>
    public class CharacterItemEquipmentDTO : Base.CharacterItemEquipmentDTO<
        CharacterItemEquipmentInfoDTO,
        CharacterItemEquipmentTitleDTO,
        CharacterItemEquipmentMedalShapeDTO,
        CharacterItemEquipmentDragonInfoDTO,
        CharacterItemEquipmentMechanicInfoDTO>
    {
        /// <summary>
        /// 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        /// </summary>
        [JsonProperty("date")]
        public override DateTimeOffset? Date
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
        /// 캐릭터 성별
        /// </summary>
        [JsonProperty("character_gender")]
        public override string CharacterGender { get; set; }

        /// <summary>
        /// 캐릭터 직업
        /// </summary>
        [JsonProperty("character_class")]
        public override string CharacterClass { get; set; }

        /// <summary>
        /// 적용 중인 장비 프리셋 번호
        /// </summary>
        [JsonProperty("preset_no")]
        public override int? PresetNo { get; set; }

        /// <summary>
        /// 장비 정보
        /// </summary>
        [JsonProperty("item_equipment")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterItemEquipmentInfoDTO> ItemEquipment { get; set; } = new();

        /// <summary>
        /// 1번 프리셋 장비 정보
        /// </summary>
        [JsonProperty("item_equipment_preset_1")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterItemEquipmentInfoDTO> ItemEquipmentPreset1 { get; set; } = new();

        /// <summary>
        /// 2번 프리셋 장비 정보
        /// </summary>
        [JsonProperty("item_equipment_preset_2")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterItemEquipmentInfoDTO> ItemEquipmentPreset2 { get; set; } = new();

        /// <summary>
        /// 3번 프리셋 장비 정보
        /// </summary>
        [JsonProperty("item_equipment_preset_3")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterItemEquipmentInfoDTO> ItemEquipmentPreset3 { get; set; } = new();

        /// <summary>
        /// 칭호 정보
        /// </summary>
        [JsonProperty("title")]
        public override CharacterItemEquipmentTitleDTO? Title { get; set; }

        /// <summary>
        /// 외형 설정에 등록한 훈장 외형 정보
        /// </summary>
        [JsonProperty("medal_shape")]
        public override CharacterItemEquipmentMedalShapeDTO? MedalShape { get; set; }

        /// <summary>
        /// 에반 드래곤 장비 정보 (에반인 경우 응답)
        /// </summary>
        [JsonProperty("dragon_equipment")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterItemEquipmentDragonInfoDTO> DragonEquipment { get; set; } = new();

        /// <summary>
        /// 메카닉 장비 정보 (메카닉인 경우 응답)
        /// </summary>
        [JsonProperty("mechanic_equipment")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterItemEquipmentMechanicInfoDTO> MechanicEquipment { get; set; } = new();
    }

    /// <summary>
    /// 캐릭터 칭호 아이템 정보
    /// </summary>
    public class CharacterItemEquipmentTitleDTO : Base.CharacterItemEquipmentTitleDTO
    {
        /// <summary>
        /// 칭호 장비 명
        /// </summary>
        [JsonProperty("title_name")]
        public override string? TitleName { get; set; }

        /// <summary>
        /// 칭호 아이콘
        /// </summary>
        [JsonProperty("title_icon")]
        public override string? TitleIcon { get; set; }

        /// <summary>
        /// 칭호 설명
        /// </summary>
        [JsonProperty("title_description")]
        public override string? TitleDescription { get; set; }

        /// <summary>
        /// 칭호 유효 기간 (KST)
        /// </summary>
        public override DateTimeOffset? DateExpire
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
        /// 칭호 유효 기간 만료 여부
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
        /// 칭호 옵션 유효 기간 (KST)
        /// </summary>
        public override DateTimeOffset? DateOptionExpire
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
        /// 칭호 옵션 유효 기간 만료 여부
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
        /// 외형 설정에 등록한 칭호 장비 명
        /// </summary>
        [JsonProperty("title_shape_name")]
        public override string? TitleShapeName { get; set; }

        /// <summary>
        /// 외형 설정에 등록한 칭호 아이콘
        /// </summary>
        [JsonProperty("title_shape_icon")]
        public override string? TitleShapeIcon { get; set; }

        /// <summary>
        /// 외형 설정에 등록한 칭호 설명
        /// </summary>
        [JsonProperty("title_shape_description")]
        public override string? TitleShapeDescription { get; set; }
    }

    /// <summary>
    /// 캐릭터 외형 설정에 등록한 훈장 외형 정보
    /// </summary>
    public class CharacterItemEquipmentMedalShapeDTO : Base.CharacterItemEquipmentMedalShapeDTO
    {
        /// <summary>
        /// 외형 설정에 등록한 훈장 장비 명
        /// </summary>
        [JsonProperty("medal_shape_name")]
        public override string MedalShapeName { get; set; }

        /// <summary>
        /// 외형 설정에 등록한 훈장 아이콘
        /// </summary>
        [JsonProperty("medal_shape_icon")]
        public override string MedalShapeIcon { get; set; }

        /// <summary>
        /// 외형 설정에 등록한 훈장 설명
        /// </summary>
        [JsonProperty("medal_shape_description")]
        public override string MedalShapeDescription { get; set; }

        /// <summary>
        /// 외형 설정에 등록한 훈장의 모루 적용 장비 명
        /// </summary>
        [JsonProperty("medal_shape_changed_name")]
        public override string MedalShapeChangedName { get; set; }

        /// <summary>
        /// 외형 설정에 등록한 훈장의 모루 적용 아이콘
        /// </summary>
        [JsonProperty("medal_shape_changed_icon")]
        public override string MedalShapeChangedIcon { get; set; }

        /// <summary>
        /// 외형 설정에 등록한 훈장의 모루 적용 훈장 설명
        /// </summary>
        [JsonProperty("medal_shape_changed_description")]
        public override string MedalShapeChangedDescription { get; set; }
    }

    /// <summary>
    /// 캐릭터 장비 추가 옵션 정보
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
        /// 최대 HP
        /// </summary>
        [JsonProperty("max_hp")]
        public override string MaxHp { get; set; }

        /// <summary>
        /// 최대 MP
        /// </summary>
        [JsonProperty("max_mp")]
        public override string MaxMp { get; set; }

        /// <summary>
        /// 공격력
        /// </summary>
        [JsonProperty("attack_power")]
        public override string AttackPower { get; set; }

        /// <summary>
        /// 마력
        /// </summary>
        [JsonProperty("magic_power")]
        public override string MagicPower { get; set; }

        /// <summary>
        /// 방어력
        /// </summary>
        [JsonProperty("armor")]
        public override string Armor { get; set; }

        /// <summary>
        /// 이동속도
        /// </summary>
        [JsonProperty("speed")]
        public override string Speed { get; set; }

        /// <summary>
        /// 점프력
        /// </summary>
        [JsonProperty("jump")]
        public override string Jump { get; set; }

        /// <summary>
        /// 보스 공격 시 데미지 증가(%)
        /// </summary>
        [JsonProperty("boss_damage")]
        public override string BossDamage { get; set; }

        /// <summary>
        /// 데미지(%)
        /// </summary>
        public override string Damage { get; set; }

        /// <summary>
        /// 올스탯(%)
        /// </summary>
        [JsonProperty("all_stat")]
        public override string AllStat { get; set; }

        /// <summary>
        /// 착용 레벨 감소
        /// </summary>
        [JsonProperty("equipment_level_decrease")]
        public override long EquipmentLevelDecrease { get; set; }
    }

    /// <summary>
    /// 캐릭터 장비 기본 옵션 정보
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
        /// 최대 HP
        /// </summary>
        [JsonProperty("max_hp")]
        public override string MaxHp { get; set; }

        /// <summary>
        /// 최대 MP
        /// </summary>
        [JsonProperty("max_mp")]
        public override string MaxMp { get; set; }

        /// <summary>
        /// 공격력
        /// </summary>
        [JsonProperty("attack_power")]
        public override string AttackPower { get; set; }

        /// <summary>
        /// 마력
        /// </summary>
        [JsonProperty("magic_power")]
        public override string MagicPower { get; set; }

        /// <summary>
        /// 방어력
        /// </summary>
        [JsonProperty("armor")]
        public override string Armor { get; set; }

        /// <summary>
        /// 이동속도
        /// </summary>
        [JsonProperty("speed")]
        public override string Speed { get; set; }

        /// <summary>
        /// 점프력
        /// </summary>
        [JsonProperty("jump")]
        public override string Jump { get; set; }

        /// <summary>
        /// 보스 공격 시 데미지 증가(%)
        /// </summary>
        [JsonProperty("boss_damage")]
        public override string BossDamage { get; set; }

        /// <summary>
        /// 몬스터 방어율 무시(%)
        /// </summary>
        [JsonProperty("ignore_monster_armor")]
        public override string IgnoreMonsterArmor { get; set; }

        /// <summary>
        /// 올스탯(%)
        /// </summary>
        [JsonProperty("all_stat")]
        public override string AllStat { get; set; }

        /// <summary>
        /// 최대 HP(%)
        /// </summary>
        [JsonProperty("max_hp_rate")]
        public override string MaxHpRate { get; set; }

        /// <summary>
        /// 최대 MP(%)
        /// </summary>
        [JsonProperty("max_mp_rate")]
        public override string MaxMpRate { get; set; }

        /// <summary>
        /// 착용 레벨 감소
        /// </summary>
        [JsonProperty("base_equipment_level")]
        public override long BaseEquipmentLevel { get; set; }
    }

    /// <summary>
    /// 캐릭터 장비 기타 옵션 정보
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
        /// 최대 HP
        /// </summary>
        [JsonProperty("max_hp")]
        public override string MaxHp { get; set; }

        /// <summary>
        /// 최대 MP
        /// </summary>
        [JsonProperty("max_mp")]
        public override string MaxMp { get; set; }

        /// <summary>
        /// 공격력
        /// </summary>
        [JsonProperty("attack_power")]
        public override string AttackPower { get; set; }

        /// <summary>
        /// 마력
        /// </summary>
        [JsonProperty("magic_power")]
        public override string MagicPower { get; set; }

        /// <summary>
        /// 방어력
        /// </summary>
        [JsonProperty("armor")]
        public override string Armor { get; set; }

        /// <summary>
        /// 이동속도
        /// </summary>
        [JsonProperty("speed")]
        public override string Speed { get; set; }

        /// <summary>
        /// 점프력
        /// </summary>
        [JsonProperty("jump")]
        public override string Jump { get; set; }
    }

    /// <summary>
    /// 캐릭터 장비 특별 옵션 정보
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
        /// 최대 HP
        /// </summary>
        [JsonProperty("max_hp")]
        public override string MaxHp { get; set; }

        /// <summary>
        /// 최대 MP
        /// </summary>
        [JsonProperty("max_mp")]
        public override string MaxMp { get; set; }

        /// <summary>
        /// 공격력
        /// </summary>
        [JsonProperty("attack_power")]
        public override string AttackPower { get; set; }

        /// <summary>
        /// 마력
        /// </summary>
        [JsonProperty("magic_power")]
        public override string MagicPower { get; set; }

        /// <summary>
        /// 익셉셔널 강화 적용 횟수
        /// </summary>
        [JsonProperty("exceptional_upgrade")]
        [JsonConverter(typeof(DefaultValueConverter<int>), 0)]
        public override int ExceptionalUpgrade { get; set; }
    }

    /// <summary>
    /// 캐릭터 장비 스타포스 옵션 정보
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
        /// 최대 HP
        /// </summary>
        [JsonProperty("max_hp")]
        public override string MaxHp { get; set; }

        /// <summary>
        /// 최대 MP
        /// </summary>
        [JsonProperty("max_mp")]
        public override string MaxMp { get; set; }

        /// <summary>
        /// 공격력
        /// </summary>
        [JsonProperty("attack_power")]
        public override string AttackPower { get; set; }

        /// <summary>
        /// 마력
        /// </summary>
        [JsonProperty("magic_power")]
        public override string MagicPower { get; set; }

        /// <summary>
        /// 방어력
        /// </summary>
        [JsonProperty("armor")]
        public override string Armor { get; set; }

        /// <summary>
        /// 이동속도
        /// </summary>
        [JsonProperty("speed")]
        public override string Speed { get; set; }

        /// <summary>
        /// 점프력
        /// </summary>
        [JsonProperty("jump")]
        public override string Jump { get; set; }
    }

    /// <summary>
    /// 캐릭터 장비 최종 옵션 정보
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
        /// 최대 HP
        /// </summary>
        [JsonProperty("max_hp")]
        public override string MaxHp { get; set; }

        /// <summary>
        /// 최대 MP
        /// </summary>
        [JsonProperty("max_mp")]
        public override string MaxMp { get; set; }

        /// <summary>
        /// 공격력
        /// </summary>
        [JsonProperty("attack_power")]
        public override string AttackPower { get; set; }

        /// <summary>
        /// 마력
        /// </summary>
        [JsonProperty("magic_power")]
        public override string MagicPower { get; set; }

        /// <summary>
        /// 방어력
        /// </summary>
        [JsonProperty("armor")]
        public override string Armor { get; set; }

        /// <summary>
        /// 이동속도
        /// </summary>
        [JsonProperty("speed")]
        public override string Speed { get; set; }

        /// <summary>
        /// 점프력
        /// </summary>
        [JsonProperty("jump")]
        public override string Jump { get; set; }

        /// <summary>
        /// 보스 공격 시 데미지 증가(%)
        /// </summary>
        [JsonProperty("boss_damage")]
        public override string BossDamage { get; set; }

        /// <summary>
        /// 몬스터 방어율 무시(%)
        /// </summary>
        [JsonProperty("ignore_monster_armor")]
        public override string IgnoreMonsterArmor { get; set; }

        /// <summary>
        /// 올스탯(%)
        /// </summary>
        [JsonProperty("all_stat")]
        public override string AllStat { get; set; }

        /// <summary>
        /// 데미지(%)
        /// </summary>
        public override string Damage { get; set; }

        /// <summary>
        /// 착용 레벨 감소
        /// </summary>
        [JsonProperty("equipment_level_decrease")]
        public override long EquipmentLevelDecrease { get; set; }

        /// <summary>
        /// 최대 HP(%)
        /// </summary>
        [JsonProperty("max_hp_rate")]
        public override string MaxHpRate { get; set; }

        /// <summary>
        /// 최대 MP(%)
        /// </summary>
        [JsonProperty("max_mp_rate")]
        public override string MaxMpRate { get; set; }
    }

    /// <summary>
    /// 에반 드래곤 장비 정보
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
        /// 장비 부위 명
        /// </summary>
        [JsonProperty("item_equipment_part")]
        public override string ItemEquipmentPart { get; set; }

        /// <summary>
        /// 장비 슬롯 위치
        /// </summary>
        [JsonProperty("item_equipment_slot")]
        public override string ItemEquipmentSlot { get; set; }

        /// <summary>
        /// 장비 명
        /// </summary>
        [JsonProperty("item_name")]
        public override string ItemName { get; set; }

        /// <summary>
        /// 장비 아이콘
        /// </summary>
        [JsonProperty("item_icon")]
        public override string ItemIcon { get; set; }

        /// <summary>
        /// 장비 설명
        /// </summary>
        [JsonProperty("item_description")]
        public override string? ItemDescription { get; set; }

        /// <summary>
        /// 장비 외형
        /// </summary>
        [JsonProperty("item_shape_name")]
        public override string ItemShapeName { get; set; }

        /// <summary>
        /// 장비 외형 아이콘
        /// </summary>
        [JsonProperty("item_shape_icon")]
        public override string ItemShapeIcon { get; set; }

        /// <summary>
        /// 전용 성별
        /// </summary>
        [JsonProperty("item_gender")]
        public override string? ItemGender { get; set; }

        /// <summary>
        /// 장비 최종 옵션 정보
        /// </summary>
        [JsonProperty("item_total_option")]
        public override CharacterItemEquipmentTotalOptionDTO ItemTotalOption { get; set; }

        /// <summary>
        /// 장비 기본 옵션 정보
        /// </summary>
        [JsonProperty("item_base_option")]
        public override CharacterItemEquipmentBaseOptionDTO ItemBaseOption { get; set; }

        /// <summary>
        /// 착용 레벨 증가
        /// </summary>
        [JsonProperty("equipment_level_increase")]
        public override long EquipmentLevelIncrease { get; set; }

        /// <summary>
        /// 장비 특별 옵션 정보
        /// </summary>
        [JsonProperty("item_exceptional_option")]
        public override CharacterItemEquipmentExceptionalOptionDTO ItemExceptionalOption { get; set; }

        /// <summary>
        /// 장비 추가 옵션 정보
        /// </summary>
        [JsonProperty("item_add_option")]
        public override CharacterItemEquipmentAddOptionDTO ItemAddOption { get; set; }

        /// <summary>
        /// 성장 경험치
        /// </summary>
        [JsonProperty("growth_exp")]
        public override long GrowthExp { get; set; }

        /// <summary>
        /// 성장 레벨
        /// </summary>
        [JsonProperty("growth_level")]
        public override long GrowthLevel { get; set; }

        /// <summary>
        /// 업그레이드 횟수
        /// </summary>
        [JsonProperty("scroll_upgrade")]
        public override string ScrollUpgrade { get; set; }

        /// <summary>
        /// 가위 사용 가능 횟수 (교환 불가 장비, 가위 횟수가 없는 교환 가능 장비는 255)
        /// </summary>
        [JsonProperty("cuttable_count")]
        public override string CuttableCount { get; set; }

        /// <summary>
        /// 황금 망치 재련 적용 (1:적용, 이외 미 적용)
        /// </summary>
        [JsonProperty("golden_hammer_flag")]
        public override string GoldenHammerFlag { get; set; }

        /// <summary>
        /// 복구 가능 횟수
        /// </summary>
        [JsonProperty("scroll_resilience_count")]
        public override string ScrollResilienceCount { get; set; }

        /// <summary>
        /// 업그레이드 가능 횟수
        /// </summary>
        [JsonProperty("scroll_upgradeable_count")]
        public override string ScrollUpgradeableCount { get; set; }

        /// <summary>
        /// 소울 명
        /// </summary>
        [JsonProperty("soul_name")]
        public override string? SoulName { get; set; }

        /// <summary>
        /// 소울 옵션
        /// </summary>
        [JsonProperty("soul_option")]
        public override string? SoulOption { get; set; }

        /// <summary>
        /// 장비 기타 옵션 정보
        /// </summary>
        [JsonProperty("item_etc_option")]
        public override CharacterItemEquipmentEtcOptionDTO ItemEtcOption { get; set; }

        /// <summary>
        /// 강화 단계
        /// </summary>
        [JsonProperty("starforce")]
        public override string Starforce { get; set; }

        /// <summary>
        /// 놀라운 장비 강화 주문서 사용 여부 (0:미사용, 1:사용)
        /// </summary>
        [JsonProperty("starforce_scroll_flag")]
        public override string StarforceScrollFlag { get; set; }

        /// <summary>
        /// 장비 스타포스 옵션 정보
        /// </summary>
        [JsonProperty("item_starforce_option")]
        public override CharacterItemEquipmentStarforceOptionDTO ItemStarforceOption { get; set; }

        /// <summary>
        /// 특수 반지 레벨
        /// </summary>
        [JsonProperty("special_ring_level")]
        public override long SpecialRingLevel { get; set; }

        /// <summary>
        /// 장비 유효 기간 (KST)
        /// </summary>
        public override DateTimeOffset? DateExpire
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
        private string? _dateExpire;

        /// <summary>
        /// 장비 유효 기간 만료 여부
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
        /// 프리스타일 쿠폰 적용 여부 (0:미적용, 1:적용)
        /// </summary>
        [JsonProperty("freestyle_flag")]
        public override string? FreestyleFlag { get; set; }

        /// <summary>
        /// 프리스타일 쿠폰 적용 여부
        /// </summary>
        public bool IsFreestyleFlag
        {
            get => this.FreestyleFlag == "1";
        }
    }

    /// <summary>
    /// 메카닉 장비 정보
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
        /// 장비 부위 명
        /// </summary>
        [JsonProperty("item_equipment_part")]
        public override string ItemEquipmentPart { get; set; }

        /// <summary>
        /// 장비 슬롯 위치
        /// </summary>
        [JsonProperty("item_equipment_slot")]
        public override string ItemEquipmentSlot { get; set; }

        /// <summary>
        /// 장비 명
        /// </summary>
        [JsonProperty("item_name")]
        public override string ItemName { get; set; }

        /// <summary>
        /// 장비 아이콘
        /// </summary>
        [JsonProperty("item_icon")]
        public override string ItemIcon { get; set; }

        /// <summary>
        /// 장비 설명
        /// </summary>
        [JsonProperty("item_description")]
        public override string? ItemDescription { get; set; }

        /// <summary>
        /// 장비 외형
        /// </summary>
        [JsonProperty("item_shape_name")]
        public override string ItemShapeName { get; set; }

        /// <summary>
        /// 장비 외형 아이콘
        /// </summary>
        [JsonProperty("item_shape_icon")]
        public override string ItemShapeIcon { get; set; }

        /// <summary>
        /// 전용 성별
        /// </summary>
        [JsonProperty("item_gender")]
        public override string? ItemGender { get; set; }

        /// <summary>
        /// 장비 최종 옵션 정보
        /// </summary>
        [JsonProperty("item_total_option")]
        public override CharacterItemEquipmentTotalOptionDTO ItemTotalOption { get; set; }

        /// <summary>
        /// 장비 기본 옵션 정보
        /// </summary>
        [JsonProperty("item_base_option")]
        public override CharacterItemEquipmentBaseOptionDTO ItemBaseOption { get; set; }

        /// <summary>
        /// 착용 레벨 증가
        /// </summary>
        [JsonProperty("equipment_level_increase")]
        public override long EquipmentLevelIncrease { get; set; }

        /// <summary>
        /// 장비 특별 옵션 정보
        /// </summary>
        [JsonProperty("item_exceptional_option")]
        public override CharacterItemEquipmentExceptionalOptionDTO ItemExceptionalOption { get; set; }

        /// <summary>
        /// 장비 추가 옵션 정보
        /// </summary>
        [JsonProperty("item_add_option")]
        public override CharacterItemEquipmentAddOptionDTO ItemAddOption { get; set; }

        /// <summary>
        /// 성장 경험치
        /// </summary>
        [JsonProperty("growth_exp")]
        public override long GrowthExp { get; set; }

        /// <summary>
        /// 성장 레벨
        /// </summary>
        [JsonProperty("growth_level")]
        public override long GrowthLevel { get; set; }

        /// <summary>
        /// 업그레이드 횟수
        /// </summary>
        [JsonProperty("scroll_upgrade")]
        public override string ScrollUpgrade { get; set; }

        /// <summary>
        /// 가위 사용 가능 횟수 (교환 불가 장비, 가위 횟수가 없는 교환 가능 장비는 255)
        /// </summary>
        [JsonProperty("cuttable_count")]
        public override string CuttableCount { get; set; }

        /// <summary>
        /// 황금 망치 재련 적용 (1:적용, 이외 미 적용)
        /// </summary>
        [JsonProperty("golden_hammer_flag")]
        public override string GoldenHammerFlag { get; set; }

        /// <summary>
        /// 복구 가능 횟수
        /// </summary>
        [JsonProperty("scroll_resilience_count")]
        public override string ScrollResilienceCount { get; set; }

        /// <summary>
        /// 업그레이드 가능 횟수
        /// </summary>
        [JsonProperty("scroll_upgradeable_count")]
        public override string ScrollUpgradeableCount { get; set; }

        /// <summary>
        /// 소울 명
        /// </summary>
        [JsonProperty("soul_name")]
        public override string? SoulName { get; set; }

        /// <summary>
        /// 소울 옵션
        /// </summary>
        [JsonProperty("soul_option")]
        public override string? SoulOption { get; set; }

        /// <summary>
        /// 장비 기타 옵션 정보
        /// </summary>
        [JsonProperty("item_etc_option")]
        public override CharacterItemEquipmentEtcOptionDTO ItemEtcOption { get; set; }

        /// <summary>
        /// 강화 단계
        /// </summary>
        [JsonProperty("starforce")]
        public override string Starforce { get; set; }

        /// <summary>
        /// 놀라운 장비 강화 주문서 사용 여부 (0:미사용, 1:사용)
        /// </summary>
        [JsonProperty("starforce_scroll_flag")]
        public override string StarforceScrollFlag { get; set; }

        /// <summary>
        /// 장비 스타포스 옵션 정보
        /// </summary>
        [JsonProperty("item_starforce_option")]
        public override CharacterItemEquipmentStarforceOptionDTO ItemStarforceOption { get; set; }

        /// <summary>
        /// 특수 반지 레벨
        /// </summary>
        [JsonProperty("special_ring_level")]
        public override long SpecialRingLevel { get; set; }

        /// <summary>
        /// 장비 유효 기간 (KST)
        /// </summary>
        public override DateTimeOffset? DateExpire
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
        private string? _dateExpire;

        /// <summary>
        /// 장비 유효 기간 만료 여부
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
        /// 프리스타일 쿠폰 적용 여부 (0:미적용, 1:적용)
        /// </summary>
        [JsonProperty("freestyle_flag")]
        public override string? FreestyleFlag { get; set; }

        /// <summary>
        /// 프리스타일 쿠폰 적용 여부
        /// </summary>
        public bool IsFreestyleFlag
        {
            get => this.FreestyleFlag == "1";
        }
    }

    /// <summary>
    /// 캐릭터 장비 아이템 상세 정보
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
        /// 장비 부위 명
        /// </summary>
        [JsonProperty("item_equipment_part")]
        public override string ItemEquipmentPart { get; set; }

        /// <summary>
        /// 장비 슬롯 위치
        /// </summary>
        [JsonProperty("item_equipment_slot")]
        public override string ItemEquipmentSlot { get; set; }

        /// <summary>
        /// 장비 명
        /// </summary>
        [JsonProperty("item_name")]
        public override string ItemName { get; set; }

        /// <summary>
        /// 장비 아이콘
        /// </summary>
        [JsonProperty("item_icon")]
        public override string ItemIcon { get; set; }

        /// <summary>
        /// 장비 설명
        /// </summary>
        [JsonProperty("item_description")]
        public override string? ItemDescription { get; set; }

        /// <summary>
        /// 장비 외형
        /// </summary>
        [JsonProperty("item_shape_name")]
        public override string ItemShapeName { get; set; }

        /// <summary>
        /// 장비 외형 아이콘
        /// </summary>
        [JsonProperty("item_shape_icon")]
        public override string ItemShapeIcon { get; set; }

        /// <summary>
        /// 전용 성별
        /// </summary>
        [JsonProperty("item_gender")]
        public override string? ItemGender { get; set; }

        /// <summary>
        /// 장비 최종 옵션 정보
        /// </summary>
        [JsonProperty("item_total_option")]
        public override CharacterItemEquipmentTotalOptionDTO ItemTotalOption { get; set; }

        /// <summary>
        /// 장비 기본 옵션 정보
        /// </summary>
        [JsonProperty("item_base_option")]
        public override CharacterItemEquipmentBaseOptionDTO ItemBaseOption { get; set; }

        /// <summary>
        /// 잠재능력 봉인 여부 (true 봉인, false 봉인 없음)
        /// </summary>
        [JsonProperty("potential_option_flag")]
        public override string? PotentialOptionFlag { get; set; }

        /// <summary>
        /// 에디셔널 잠재능력 봉인 여부 (true 봉인, false 봉인 없음)
        /// </summary>
        [JsonProperty("additional_potential_option_flag")]
        public override string? AdditionalPotentialOptionFlag { get; set; }

        /// <summary>
        /// 잠재능력 등급
        /// </summary>
        [JsonProperty("potential_option_grade")]
        public override string? PotentialOptionGrade { get; set; }

        /// <summary>
        /// 에디셔널 잠재능력 등급
        /// </summary>
        [JsonProperty("additional_potential_option_grade")]
        public override string? AdditionalPotentialOptionGrade { get; set; }

        /// <summary>
        /// 잠재능력 첫 번째 옵션
        /// </summary>
        [JsonProperty("potential_option_1")]
        public override string? PotentialOption1 { get; set; }

        /// <summary>
        /// 잠재능력 두 번째 옵션
        /// </summary>
        [JsonProperty("potential_option_2")]
        public override string? PotentialOption2 { get; set; }

        /// <summary>
        /// 잠재능력 세 번째 옵션
        /// </summary>
        [JsonProperty("potential_option_3")]
        public override string? PotentialOption3 { get; set; }

        /// <summary>
        /// 에디셔널 잠재능력 첫 번째 옵션
        /// </summary>
        [JsonProperty("additional_potential_option_1")]
        public override string? AdditionalPotentialOption1 { get; set; }

        /// <summary>
        /// 에디셔널 잠재능력 두 번째 옵션
        /// </summary>
        [JsonProperty("additional_potential_option_2")]
        public override string? AdditionalPotentialOption2 { get; set; }

        /// <summary>
        /// 에디셔널 잠재능력  세 번째 옵션
        /// </summary>
        [JsonProperty("additional_potential_option_3")]
        public override string? AdditionalPotentialOption3 { get; set; }

        /// <summary>
        /// 착용 레벨 증가
        /// </summary>
        [JsonProperty("equipment_level_increase")]
        public override long EquipmentLevelIncrease { get; set; }

        /// <summary>
        /// 장비 특별 옵션 정보
        /// </summary>
        [JsonProperty("item_exceptional_option")]
        public override CharacterItemEquipmentExceptionalOptionDTO ItemExceptionalOption { get; set; }

        /// <summary>
        /// 장비 추가 옵션 정보
        /// </summary>
        [JsonProperty("item_add_option")]
        public override CharacterItemEquipmentAddOptionDTO ItemAddOption { get; set; }

        /// <summary>
        /// 성장 경험치
        /// </summary>
        [JsonProperty("growth_exp")]
        public override long GrowthExp { get; set; }

        /// <summary>
        /// 성장 레벨
        /// </summary>
        [JsonProperty("growth_level")]
        public override long GrowthLevel { get; set; }

        /// <summary>
        /// 업그레이드 횟수
        /// </summary>
        [JsonProperty("scroll_upgrade")]
        public override string ScrollUpgrade { get; set; }

        /// <summary>
        /// 가위 사용 가능 횟수 (교환 불가 장비, 가위 횟수가 없는 교환 가능 장비는 255)
        /// </summary>
        [JsonProperty("cuttable_count")]
        public override string CuttableCount { get; set; }

        /// <summary>
        /// 황금 망치 재련 적용 (1:적용, 이외 미 적용)
        /// </summary>
        [JsonProperty("golden_hammer_flag")]
        public override string GoldenHammerFlag { get; set; }

        /// <summary>
        /// 복구 가능 횟수
        /// </summary>
        [JsonProperty("scroll_resilience_count")]
        public override string ScrollResilienceCount { get; set; }

        /// <summary>
        /// 업그레이드 가능 횟수
        /// </summary>
        [JsonProperty("scroll_upgradeable_count")]
        public override string ScrollUpgradeableCount { get; set; }

        /// <summary>
        /// 소울 명
        /// </summary>
        [JsonProperty("soul_name")]
        public override string? SoulName { get; set; }

        /// <summary>
        /// 소울 옵션
        /// </summary>
        [JsonProperty("soul_option")]
        public override string? SoulOption { get; set; }

        /// <summary>
        /// 장비 기타 옵션 정보
        /// </summary>
        [JsonProperty("item_etc_option")]
        public override CharacterItemEquipmentEtcOptionDTO ItemEtcOption { get; set; }

        /// <summary>
        /// 강화 단계
        /// </summary>
        [JsonProperty("starforce")]
        public override string Starforce { get; set; }

        /// <summary>
        /// 놀라운 장비 강화 주문서 사용 여부 (0:미사용, 1:사용)
        /// </summary>
        [JsonProperty("starforce_scroll_flag")]
        public override string StarforceScrollFlag { get; set; }

        /// <summary>
        /// 장비 스타포스 옵션 정보
        /// </summary>
        [JsonProperty("item_starforce_option")]
        public override CharacterItemEquipmentStarforceOptionDTO ItemStarforceOption { get; set; }

        /// <summary>
        /// 특수 반지 레벨
        /// </summary>
        [JsonProperty("special_ring_level")]
        public override long SpecialRingLevel { get; set; }

        /// <summary>
        /// 장비 유효 기간 (KST)
        /// </summary>
        public override DateTimeOffset? DateExpire
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
        private string? _dateExpire;

        /// <summary>
        /// 장비 유효 기간 만료 여부
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
        /// 프리스타일 쿠폰 적용 여부 (0:미적용, 1:적용)
        /// </summary>
        [JsonProperty("freestyle_flag")]
        public override string? FreestyleFlag { get; set; }

        /// <summary>
        /// 프리스타일 쿠폰 적용 여부
        /// </summary>
        public bool IsFreestyleFlag
        {
            get => this.FreestyleFlag == "1";
        }
    }
}
