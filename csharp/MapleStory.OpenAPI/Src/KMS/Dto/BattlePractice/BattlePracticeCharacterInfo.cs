using Newtonsoft.Json;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 연무장 입장 시 캐릭터 능력치 관련 정보
    /// </summary>
    public class BattlePracticeCharacterInfoDTO
    {
        /// <summary>
        /// 캐릭터 기본 정보
        /// </summary>
        [JsonProperty("basic_object")]
        public BattlePracticeCharacterBasicDTO? BasicObject { get; set; }

        /// <summary>
        /// 캐릭터 스탯 정보
        /// </summary>
        [JsonProperty("stat_object")]
        public BattlePracticeCharacterStatDTO? StatObject { get; set; }

        /// <summary>
        /// 캐릭터 하이퍼스탯 정보
        /// </summary>
        [JsonProperty("hyper_stat_object")]
        public BattlePracticeCharacterHyperStatObjectDTO? HyperStatObject { get; set; }

        /// <summary>
        /// 캐릭터 성향 정보
        /// </summary>
        [JsonProperty("propensity_object")]
        public BattlePracticeCharacterPropensityDTO? PropensityObject { get; set; }

        /// <summary>
        /// 캐릭터 어빌리티 정보
        /// </summary>
        [JsonProperty("ability_object")]
        public BattlePracticeCharacterAbilityObjectDTO? AbilityObject { get; set; }

        /// <summary>
        /// 캐릭터 장비 정보
        /// </summary>
        [JsonProperty("item_object")]
        public BattlePracticeCharacterItemObjectDTO? ItemObject { get; set; }

        /// <summary>
        /// 캐릭터 캐시 장비 정보
        /// </summary>
        [JsonProperty("cash_item_object")]
        public BattlePracticeCharacterCashItemObjectDTO? CashItemObject { get; set; }

        /// <summary>
        /// 캐릭터 펫 장비 정보
        /// </summary>
        [JsonProperty("pet_object")]
        public BattlePracticeCharacterPetObjectDTO? PetObject { get; set; }

        /// <summary>
        /// 캐릭터 스킬 정보
        /// </summary>
        [JsonProperty("skill_object")]
        public BattlePracticeCharacterSkillObjectDTO? SkillObject { get; set; }

        /// <summary>
        /// 캐릭터 링크 스킬 정보
        /// </summary>
        [JsonProperty("link_skill_object")]
        public BattlePracticeCharacterLinkSkillObjectDTO? LinkSkillObject { get; set; }

        /// <summary>
        /// 캐릭터 V매트릭스 정보
        /// </summary>
        [JsonProperty("v_matrix_object")]
        public BattlePracticeCharacterVMatrixObjectDTO? VMatrixObject { get; set; }

        /// <summary>
        /// 캐릭터 HEXA 매트릭스 정보
        /// </summary>
        [JsonProperty("hexa_matrix_object")]
        public BattlePracticeCharacterHexaMatrixObjectDTO? HexaMatrixObject { get; set; }

        /// <summary>
        /// 캐릭터 예비 특수 반지 장착 정보
        /// </summary>
        [JsonProperty("ring_reserve_skill_object")]
        public BattlePracticeCharacterRingReserveSkillObjectDTO? RingReserveSkillObject { get; set; }

        /// <summary>
        /// 유니온 공격대 정보
        /// </summary>
        [JsonProperty("union_raider_object")]
        public BattlePracticeUnionRaiderObjectDTO? UnionRaiderObject { get; set; }

        /// <summary>
        /// 유니온 아티팩트 정보
        /// </summary>
        [JsonProperty("union_artifact_object")]
        public BattlePracticeUnionArtifactObjectDTO? UnionArtifactObject { get; set; }

        /// <summary>
        /// 유니온 챔피언 정보
        /// </summary>
        [JsonProperty("union_champion_object")]
        public BattlePracticeUnionChampionObjectDTO? UnionChampionObject { get; set; }

        /// <summary>
        /// 길드 정보
        /// </summary>
        [JsonProperty("guild_object")]
        public BattlePracticeGuildObjectDTO? GuildObject { get; set; }
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 기본 정보
    /// </summary>
    public class BattlePracticeCharacterBasicDTO
    {
        /// <summary>
        /// 캐릭터 명
        /// </summary>
        [JsonProperty("character_name")]
        public string CharacterName { get; set; }

        /// <summary>
        /// 캐릭터 레벨
        /// </summary>
        [JsonProperty("character_level")]
        public long CharacterLevel { get; set; }

        /// <summary>
        /// 캐릭터 직업
        /// </summary>
        [JsonProperty("character_class")]
        public string CharacterClass { get; set; }

        /// <summary>
        /// 캐릭터 전직 차수
        /// </summary>
        [JsonProperty("character_class_level")]
        public string CharacterClassLevel { get; set; }

        /// <summary>
        /// 캐릭터 외형 이미지
        /// </summary>
        [JsonProperty("character_image")]
        public string CharacterImage { get; set; }
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 스탯 관련 정보
    /// </summary>
    public class BattlePracticeCharacterStatDTO
    {
        /// <summary>
        /// 스탯 정보
        /// </summary>
        [JsonProperty("basic_stat_object")]
        public BattlePracticeCharacterBasicStatDTO BasicStatObject { get; set; }

        /// <summary>
        /// 장착 심볼 정보
        /// </summary>
        [JsonProperty("symbol_stat_object")]
        public BattlePracticeCharacterSymbolStatDTO SymbolStatObject { get; set; }

        /// <summary>
        /// 기타 능력치 영향 요소
        /// </summary>
        [JsonProperty("other_stat_object")]
        public BattlePracticeCharacterOtherStatDTO OtherStatObject { get; set; }
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 스탯 정보
    /// </summary>
    public class BattlePracticeCharacterBasicStatDTO
    {
        /// <summary>
        /// 현재 스탯 정보
        /// </summary>
        [JsonProperty("final_stat")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<BattlePracticeCharacterFinalStatDTO> FinalStat { get; set; } = new();
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 현재 스탯 정보
    /// </summary>
    public class BattlePracticeCharacterFinalStatDTO
    {
        /// <summary>
        /// 스탯 명
        /// </summary>
        [JsonProperty("stat_name")]
        public string StatName { get; set; }

        /// <summary>
        /// 스탯 값
        /// </summary>
        [JsonProperty("stat_value")]
        public string StatValue { get; set; }
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 장착 심볼 스탯 정보
    /// </summary>
    public class BattlePracticeCharacterSymbolStatDTO
    {
        /// <summary>
        /// 심볼 정보
        /// </summary>
        [JsonProperty("symbol")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<BattlePracticeCharacterSymbolDTO> Symbol { get; set; } = new();
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 장착 심볼 정보
    /// </summary>
    public class BattlePracticeCharacterSymbolDTO
    {
        /// <summary>
        /// 심볼 명
        /// </summary>
        [JsonProperty("symbol_name")]
        public string SymbolName { get; set; }

        /// <summary>
        /// 심볼 아이콘
        /// </summary>
        [JsonProperty("symbol_icon")]
        public string SymbolIcon { get; set; }

        /// <summary>
        /// 심볼 설명
        /// </summary>
        [JsonProperty("symbol_description")]
        public string SymbolDescription { get; set; }

        /// <summary>
        /// 심볼 부가 효과 설명
        /// </summary>
        [JsonProperty("symbol_other_effect_description")]
        public string? SymbolOtherEffectDescription { get; set; }

        /// <summary>
        /// 심볼로 인한 증가 수치
        /// </summary>
        [JsonProperty("symbol_force")]
        public string SymbolForce { get; set; }

        /// <summary>
        /// 심볼 레벨
        /// </summary>
        [JsonProperty("symbol_level")]
        public long SymbolLevel { get; set; }

        /// <summary>
        /// 심볼로 증가한 힘
        /// </summary>
        [JsonProperty("symbol_str")]
        public string SymbolStr { get; set; }

        /// <summary>
        /// 심볼로 증가한 민첩
        /// </summary>
        [JsonProperty("symbol_dex")]
        public string SymbolDex { get; set; }

        /// <summary>
        /// 심볼로 증가한 지력
        /// </summary>
        [JsonProperty("symbol_int")]
        public string SymbolInt { get; set; }

        /// <summary>
        /// 심볼로 증가한 운
        /// </summary>
        [JsonProperty("symbol_luk")]
        public string SymbolLuk { get; set; }

        /// <summary>
        /// 심볼로 증가한 체력
        /// </summary>
        [JsonProperty("symbol_hp")]
        public string SymbolHp { get; set; }

        /// <summary>
        /// 심볼로 증가한 아이템 드롭률
        /// </summary>
        [JsonProperty("symbol_drop_rate")]
        public string SymbolDropRate { get; set; }

        /// <summary>
        /// 심볼로 증가한 메소 획득량
        /// </summary>
        [JsonProperty("symbol_meso_rate")]
        public string SymbolMesoRate { get; set; }

        /// <summary>
        /// 심볼로 증가한 경험치 획득량
        /// </summary>
        [JsonProperty("symbol_exp_rate")]
        public string SymbolExpRate { get; set; }

        /// <summary>
        /// 현재 보유 성장치
        /// </summary>
        [JsonProperty("symbol_growth_count")]
        public long SymbolGrowthCount { get; set; }

        /// <summary>
        /// 성장 시 필요한 성장치
        /// </summary>
        [JsonProperty("symbol_require_growth_count")]
        public long SymbolRequireGrowthCount { get; set; }
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 기타 능력치 영향 요소
    /// </summary>
    public class BattlePracticeCharacterOtherStatDTO
    {
        /// <summary>
        /// 능력치에 영향을 주는 요소 및 스탯 정보
        /// </summary>
        [JsonProperty("other_stat")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<BattlePracticeCharacterOtherStatDetailDTO> OtherStat { get; set; } = new();
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 능력치에 영향을 주는 요소 및 스탯 정보
    /// </summary>
    public class BattlePracticeCharacterOtherStatDetailDTO
    {
        /// <summary>
        /// 스탯 타입
        /// </summary>
        [JsonProperty("other_stat_type")]
        public string OtherStatType { get; set; }

        /// <summary>
        /// 스탯 정보
        /// </summary>
        [JsonProperty("stat_info")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<BattlePracticeCharacterOtherStatInfoDTO> StatInfo { get; set; } = new();
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 기타 스탯 정보
    /// </summary>
    public class BattlePracticeCharacterOtherStatInfoDTO
    {
        /// <summary>
        /// 스탯 명
        /// </summary>
        [JsonProperty("stat_name")]
        public string StatName { get; set; }

        /// <summary>
        /// 스탯 값
        /// </summary>
        [JsonProperty("stat_value")]
        public string StatValue { get; set; }
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 하이퍼 스탯 정보
    /// </summary>
    public class BattlePracticeCharacterHyperStatObjectDTO
    {
        /// <summary>
        /// 하이퍼 스탯 목록
        /// </summary>
        [JsonProperty("hyper_stat")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<BattlePracticeCharacterHyperStatDTO> HyperStat { get; set; } = new();
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 하이퍼 스탯 상세 정보
    /// </summary>
    public class BattlePracticeCharacterHyperStatDTO
    {
        /// <summary>
        /// 스탯 종류
        /// </summary>
        [JsonProperty("stat_type")]
        public string StatType { get; set; }

        /// <summary>
        /// 스탯 레벨
        /// </summary>
        [JsonProperty("stat_level")]
        public long StatLevel { get; set; }

        /// <summary>
        /// 스탯 상승량
        /// </summary>
        [JsonProperty("stat_increase")]
        public string StatIncrease { get; set; }
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 성향 정보
    /// </summary>
    public class BattlePracticeCharacterPropensityDTO
    {
        /// <summary>
        /// 카리스마 레벨
        /// </summary>
        [JsonProperty("charisma_level")]
        public long CharismaLevel { get; set; }

        /// <summary>
        /// 감성 레벨
        /// </summary>
        [JsonProperty("sensibility_level")]
        public long SensibilityLevel { get; set; }

        /// <summary>
        /// 통찰력 레벨
        /// </summary>
        [JsonProperty("insight_level")]
        public long InsightLevel { get; set; }

        /// <summary>
        /// 의지 레벨
        /// </summary>
        [JsonProperty("willingness_level")]
        public long WillingnessLevel { get; set; }

        /// <summary>
        /// 손재주 레벨
        /// </summary>
        [JsonProperty("handicraft_level")]
        public long HandicraftLevel { get; set; }

        /// <summary>
        /// 매력 레벨
        /// </summary>
        [JsonProperty("charm_level")]
        public long CharmLevel { get; set; }
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 어빌리티 정보
    /// </summary>
    public class BattlePracticeCharacterAbilityObjectDTO
    {
        /// <summary>
        /// 어빌리티 정보
        /// </summary>
        [JsonProperty("ability_info")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<BattlePracticeCharacterAbilityInfoDTO> AbilityInfo { get; set; } = new();
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 어빌리티 상세 정보
    /// </summary>
    public class BattlePracticeCharacterAbilityInfoDTO
    {
        /// <summary>
        /// 어빌리티 번호
        /// </summary>
        [JsonProperty("ability_no")]
        public string AbilityNo { get; set; }

        /// <summary>
        /// 어빌리티 등급
        /// </summary>
        [JsonProperty("ability_grade")]
        public string AbilityGrade { get; set; }

        /// <summary>
        /// 어빌리티 옵션 및 수치
        /// </summary>
        [JsonProperty("ability_value")]
        public string AbilityValue { get; set; }
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 장비(캐시 장비 제외) 정보
    /// </summary>
    public class BattlePracticeCharacterItemObjectDTO
    {
        /// <summary>
        /// 장착 장비 정보
        /// </summary>
        [JsonProperty("item_equipment_object")]
        public BattlePracticeCharacterItemEquipmentObjectDTO ItemEquipmentObject { get; set; }

        /// <summary>
        /// 적용 세트 효과 정보
        /// </summary>
        [JsonProperty("set_effect_object")]
        public BattlePracticeCharacterSetEffectObjectDTO SetEffectObject { get; set; }
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 장착 장비 정보
    /// </summary>
    public class BattlePracticeCharacterItemEquipmentObjectDTO
    {
        /// <summary>
        /// 장착 장비 정보
        /// </summary>
        [JsonProperty("item_equipment")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<BattlePracticeCharacterItemEquipmentDTO> ItemEquipment { get; set; } = new();

        /// <summary>
        /// 칭호 정보
        /// </summary>
        [JsonProperty("title")]
        public BattlePracticeCharacterItemTitleDTO? Title { get; set; }

        /// <summary>
        /// 에반 드래곤 장비 정보 (에반인 경우 응답)
        /// </summary>
        [JsonProperty("dragon_equipment")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<BattlePracticeCharacterItemDragonEquipmentDTO> DragonEquipment { get; set; } = new();

        /// <summary>
        /// 메카닉 장비 목록 (메카닉인 경우 응답)
        /// </summary>
        [JsonProperty("mechanic_equipment")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<BattlePracticeCharacterItemMechanicEquipmentDTO> MechanicEquipment { get; set; } = new();
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 장착 장비 정보
    /// </summary>
    public class BattlePracticeCharacterItemEquipmentDTO
    {
        /// <summary>
        /// 장비 부위 명
        /// </summary>
        [JsonProperty("item_equipment_part")]
        public string ItemEquipmentPart { get; set; }

        /// <summary>
        /// 장비 슬롯 위치
        /// </summary>
        [JsonProperty("item_equipment_slot")]
        public string ItemEquipmentSlot { get; set; }

        /// <summary>
        /// 장비 명
        /// </summary>
        [JsonProperty("item_name")]
        public string ItemName { get; set; }

        /// <summary>
        /// 장비 아이콘
        /// </summary>
        [JsonProperty("item_icon")]
        public string ItemIcon { get; set; }

        /// <summary>
        /// 장비 설명
        /// </summary>
        [JsonProperty("item_description")]
        public string? ItemDescription { get; set; }

        /// <summary>
        /// 장비 외형
        /// </summary>
        [JsonProperty("item_shape_name")]
        public string ItemShapeName { get; set; }

        /// <summary>
        /// 장비 외형 아이콘
        /// </summary>
        [JsonProperty("item_shape_icon")]
        public string ItemShapeIcon { get; set; }

        /// <summary>
        /// 전용 성별
        /// </summary>
        [JsonProperty("item_gender")]
        public string? ItemGender { get; set; }

        /// <summary>
        /// 장비 최종 옵션 정보
        /// </summary>
        [JsonProperty("item_total_option")]
        public BattlePracticeCharacterItemTotalOptionDTO ItemTotalOption { get; set; }

        /// <summary>
        /// 장비 기본 옵션 정보
        /// </summary>
        [JsonProperty("item_base_option")]
        public BattlePracticeCharacterItemBaseOptionDTO ItemBaseOption { get; set; }

        /// <summary>
        /// 잠재능력 봉인 여부 (true 봉인, false 봉인 없음)
        /// </summary>
        [JsonProperty("potential_option_flag")]
        public string? PotentialOptionFlag { get; set; }

        /// <summary>
        /// 에디셔널 잠재능력 개방 여부 (true 봉인, false 봉인 없음)
        /// </summary>
        [JsonProperty("additional_potential_option_flag")]
        public string? AdditionalPotentialOptionFlag { get; set; }

        /// <summary>
        /// 잠재능력 등급
        /// </summary>
        [JsonProperty("potential_option_grade")]
        public string? PotentialOptionGrade { get; set; }

        /// <summary>
        /// 에디셔널 잠재능력 등급
        /// </summary>
        [JsonProperty("additional_potential_option_grade")]
        public string? AdditionalPotentialOptionGrade { get; set; }

        /// <summary>
        /// 잠재능력 첫 번째 옵션
        /// </summary>
        [JsonProperty("potential_option_1")]
        public string? PotentialOption1 { get; set; }

        /// <summary>
        /// 잠재능력 두 번째 옵션
        /// </summary>
        [JsonProperty("potential_option_2")]
        public string? PotentialOption2 { get; set; }

        /// <summary>
        /// 잠재능력 세 번째 옵션
        /// </summary>
        [JsonProperty("potential_option_3")]
        public string? PotentialOption3 { get; set; }

        /// <summary>
        /// 에디셔널 잠재능력 첫 번째 옵션
        /// </summary>
        [JsonProperty("additional_potential_option_1")]
        public string? AdditionalPotentialOption1 { get; set; }

        /// <summary>
        /// 에디셔널 잠재능력 두 번째 옵션
        /// </summary>
        [JsonProperty("additional_potential_option_2")]
        public string? AdditionalPotentialOption2 { get; set; }

        /// <summary>
        /// 에디셔널 잠재능력 세 번째 옵션
        /// </summary>
        [JsonProperty("additional_potential_option_3")]
        public string? AdditionalPotentialOption3 { get; set; }

        /// <summary>
        /// 착용 레벨 증가
        /// </summary>
        [JsonProperty("equipment_level_increase")]
        public long EquipmentLevelIncrease { get; set; }

        /// <summary>
        /// 장비 특별 옵션 정보
        /// </summary>
        [JsonProperty("item_exceptional_option")]
        public BattlePracticeCharacterItemExceptionalOptionDTO ItemExceptionalOption { get; set; }

        /// <summary>
        /// 장비 추가 옵션 정보
        /// </summary>
        [JsonProperty("item_add_option")]
        public BattlePracticeCharacterItemAddOptionDTO ItemAddOption { get; set; }

        /// <summary>
        /// 성장 경험치
        /// </summary>
        [JsonProperty("growth_exp")]
        public long GrowthExp { get; set; }

        /// <summary>
        /// 성장 레벨
        /// </summary>
        [JsonProperty("growth_level")]
        public long GrowthLevel { get; set; }

        /// <summary>
        /// 주문서 횟수
        /// </summary>
        [JsonProperty("scroll_upgrade")]
        public string ScrollUpgrade { get; set; }

        /// <summary>
        /// 가위 사용 가능 횟수 (교환 불가 장비, 가위 횟수가 없는 교환 가능 장비는 255)
        /// </summary>
        [JsonProperty("cuttable_count")]
        public string CuttableCount { get; set; }

        /// <summary>
        /// 황금 망치 재련 적용 (1:적용, 이외 미 적용)
        /// </summary>
        [JsonProperty("golden_hammer_flag")]
        public string GoldenHammerFlag { get; set; }

        /// <summary>
        /// 복구 가능 횟수
        /// </summary>
        [JsonProperty("scroll_resilience_count")]
        public string ScrollResilienceCount { get; set; }

        /// <summary>
        /// 주문서 잔여 횟수
        /// </summary>
        [JsonProperty("scroll_upgrade_able_count")]
        public string ScrollUpgradeAbleCount { get; set; }

        /// <summary>
        /// 소울 명
        /// </summary>
        [JsonProperty("soul_name")]
        public string? SoulName { get; set; }

        /// <summary>
        /// 소울 옵션
        /// </summary>
        [JsonProperty("soul_option")]
        public string? SoulOption { get; set; }

        /// <summary>
        /// 장비 기타 옵션 정보
        /// </summary>
        [JsonProperty("item_etc_option")]
        public BattlePracticeCharacterItemEtcOptionDTO ItemEtcOption { get; set; }

        /// <summary>
        /// 강화 단계
        /// </summary>
        [JsonProperty("starforce")]
        public string Starforce { get; set; }

        /// <summary>
        /// 놀라운 장비 강화 주문서 사용 여부 (0:미사용, 1:사용)
        /// </summary>
        [JsonProperty("starforce_scroll_flag")]
        public string StarforceScrollFlag { get; set; }

        /// <summary>
        /// 장비 스타포스 옵션 정보
        /// </summary>
        [JsonProperty("item_starforce_option")]
        public BattlePracticeCharacterItemStarforceOptionDTO ItemStarforceOption { get; set; }

        /// <summary>
        /// 특수 반지 레벨
        /// </summary>
        [JsonProperty("special_ring_level")]
        public long SpecialRingLevel { get; set; }

        /// <summary>
        /// 장비 유효 기간 (KST)
        /// </summary>
        [JsonProperty("date_expire")]
        public DateTimeOffset? DateExpire
        {
            get
            {
                return _dateExpire?.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _dateExpire = value;
            }
        }

        private DateTimeOffset? _dateExpire;

        /// <summary>
        /// 프리스타일 쿠폰 적용 여부 (0:미적용, 1:적용)
        /// </summary>
        [JsonProperty("freestyle_flag")]
        public string? FreestyleFlag { get; set; }
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 에반 드래곤 장비
    /// </summary>
    public class BattlePracticeCharacterItemDragonEquipmentDTO
    {
        /// <summary>
        /// 장비 부위 명
        /// </summary>
        [JsonProperty("item_equipment_part")]
        public string ItemEquipmentPart { get; set; }

        /// <summary>
        /// 장비 슬롯 위치
        /// </summary>
        [JsonProperty("item_equipment_slot")]
        public string ItemEquipmentSlot { get; set; }

        /// <summary>
        /// 장비 명
        /// </summary>
        [JsonProperty("item_name")]
        public string ItemName { get; set; }

        /// <summary>
        /// 장비 아이콘
        /// </summary>
        [JsonProperty("item_icon")]
        public string ItemIcon { get; set; }

        /// <summary>
        /// 장비 설명
        /// </summary>
        [JsonProperty("item_description")]
        public string? ItemDescription { get; set; }

        /// <summary>
        /// 장비 외형
        /// </summary>
        [JsonProperty("item_shape_name")]
        public string ItemShapeName { get; set; }

        /// <summary>
        /// 장비 외형 아이콘
        /// </summary>
        [JsonProperty("item_shape_icon")]
        public string ItemShapeIcon { get; set; }

        /// <summary>
        /// 전용 성별
        /// </summary>
        [JsonProperty("item_gender")]
        public string? ItemGender { get; set; }

        /// <summary>
        /// 장비 최종 옵션 정보
        /// </summary>
        [JsonProperty("item_total_option")]
        public BattlePracticeCharacterItemTotalOptionDTO ItemTotalOption { get; set; }

        /// <summary>
        /// 장비 기본 옵션 정보
        /// </summary>
        [JsonProperty("item_base_option")]
        public BattlePracticeCharacterItemBaseOptionDTO ItemBaseOption { get; set; }

        /// <summary>
        /// 착용 레벨 증가
        /// </summary>
        [JsonProperty("equipment_level_increase")]
        public long EquipmentLevelIncrease { get; set; }

        /// <summary>
        /// 장비 특별 옵션 정보
        /// </summary>
        [JsonProperty("item_exceptional_option")]
        public BattlePracticeCharacterItemExceptionalOptionDTO ItemExceptionalOption { get; set; }

        /// <summary>
        /// 장비 추가 옵션 정보
        /// </summary>
        [JsonProperty("item_add_option")]
        public BattlePracticeCharacterItemAddOptionDTO ItemAddOption { get; set; }

        /// <summary>
        /// 성장 경험치
        /// </summary>
        [JsonProperty("growth_exp")]
        public long GrowthExp { get; set; }

        /// <summary>
        /// 성장 레벨
        /// </summary>
        [JsonProperty("growth_level")]
        public long GrowthLevel { get; set; }

        /// <summary>
        /// 주문서 횟수
        /// </summary>
        [JsonProperty("scroll_upgrade")]
        public string ScrollUpgrade { get; set; }

        /// <summary>
        /// 가위 사용 가능 횟수 (교환 불가 장비, 가위 횟수가 없는 교환 가능 장비는 255)
        /// </summary>
        [JsonProperty("cuttable_count")]
        public string CuttableCount { get; set; }

        /// <summary>
        /// 황금 망치 재련 적용 (1:적용, 이외 미 적용)
        /// </summary>
        [JsonProperty("golden_hammer_flag")]
        public string GoldenHammerFlag { get; set; }

        /// <summary>
        /// 복구 가능 횟수
        /// </summary>
        [JsonProperty("scroll_resilience_count")]
        public string ScrollResilienceCount { get; set; }

        /// <summary>
        /// 주문서 잔여 횟수
        /// </summary>
        [JsonProperty("scroll_upgrade_able_count")]
        public string ScrollUpgradeAbleCount { get; set; }

        /// <summary>
        /// 소울 명
        /// </summary>
        [JsonProperty("soul_name")]
        public string? SoulName { get; set; }

        /// <summary>
        /// 소울 옵션
        /// </summary>
        [JsonProperty("soul_option")]
        public string? SoulOption { get; set; }

        /// <summary>
        /// 장비 기타 옵션 정보
        /// </summary>
        [JsonProperty("item_etc_option")]
        public BattlePracticeCharacterItemEtcOptionDTO ItemEtcOption { get; set; }

        /// <summary>
        /// 강화 단계
        /// </summary>
        [JsonProperty("starforce")]
        public string Starforce { get; set; }

        /// <summary>
        /// 놀라운 장비 강화 주문서 사용 여부 (0:미사용, 1:사용)
        /// </summary>
        [JsonProperty("starforce_scroll_flag")]
        public string StarforceScrollFlag { get; set; }

        /// <summary>
        /// 장비 스타포스 옵션 정보
        /// </summary>
        [JsonProperty("item_starforce_option")]
        public BattlePracticeCharacterItemStarforceOptionDTO ItemStarforceOption { get; set; }

        /// <summary>
        /// 특수 반지 레벨
        /// </summary>
        [JsonProperty("special_ring_level")]
        public long SpecialRingLevel { get; set; }

        /// <summary>
        /// 장비 유효 기간 (KST)
        /// </summary>
        [JsonProperty("date_expire")]
        public DateTimeOffset? DateExpire
        {
            get
            {
                return _dateExpire?.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _dateExpire = value;
            }
        }

        private DateTimeOffset? _dateExpire;

        /// <summary>
        /// 프리스타일 쿠폰 적용 여부 (0:미적용, 1:적용)
        /// </summary>
        [JsonProperty("freestyle_flag")]
        public string? FreestyleFlag { get; set; }
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 메카닉 장비
    /// </summary>
    public class BattlePracticeCharacterItemMechanicEquipmentDTO
    {
        /// <summary>
        /// 장비 부위 명
        /// </summary>
        [JsonProperty("item_equipment_part")]
        public string ItemEquipmentPart { get; set; }

        /// <summary>
        /// 장비 슬롯 위치
        /// </summary>
        [JsonProperty("item_equipment_slot")]
        public string ItemEquipmentSlot { get; set; }

        /// <summary>
        /// 장비 명
        /// </summary>
        [JsonProperty("item_name")]
        public string ItemName { get; set; }

        /// <summary>
        /// 장비 아이콘
        /// </summary>
        [JsonProperty("item_icon")]
        public string ItemIcon { get; set; }

        /// <summary>
        /// 장비 설명
        /// </summary>
        [JsonProperty("item_description")]
        public string? ItemDescription { get; set; }

        /// <summary>
        /// 장비 외형
        /// </summary>
        [JsonProperty("item_shape_name")]
        public string ItemShapeName { get; set; }

        /// <summary>
        /// 장비 외형 아이콘
        /// </summary>
        [JsonProperty("item_shape_icon")]
        public string ItemShapeIcon { get; set; }

        /// <summary>
        /// 전용 성별
        /// </summary>
        [JsonProperty("item_gender")]
        public string? ItemGender { get; set; }

        /// <summary>
        /// 장비 최종 옵션 정보
        /// </summary>
        [JsonProperty("item_total_option")]
        public BattlePracticeCharacterItemTotalOptionDTO ItemTotalOption { get; set; }

        /// <summary>
        /// 장비 기본 옵션 정보
        /// </summary>
        [JsonProperty("item_base_option")]
        public BattlePracticeCharacterItemBaseOptionDTO ItemBaseOption { get; set; }

        /// <summary>
        /// 착용 레벨 증가
        /// </summary>
        [JsonProperty("equipment_level_increase")]
        public long EquipmentLevelIncrease { get; set; }

        /// <summary>
        /// 장비 특별 옵션 정보
        /// </summary>
        [JsonProperty("item_exceptional_option")]
        public BattlePracticeCharacterItemExceptionalOptionDTO ItemExceptionalOption { get; set; }

        /// <summary>
        /// 장비 추가 옵션 정보
        /// </summary>
        [JsonProperty("item_add_option")]
        public BattlePracticeCharacterItemAddOptionDTO ItemAddOption { get; set; }

        /// <summary>
        /// 성장 경험치
        /// </summary>
        [JsonProperty("growth_exp")]
        public long GrowthExp { get; set; }

        /// <summary>
        /// 성장 레벨
        /// </summary>
        [JsonProperty("growth_level")]
        public long GrowthLevel { get; set; }

        /// <summary>
        /// 주문서 횟수
        /// </summary>
        [JsonProperty("scroll_upgrade")]
        public string ScrollUpgrade { get; set; }

        /// <summary>
        /// 가위 사용 가능 횟수 (교환 불가 장비, 가위 횟수가 없는 교환 가능 장비는 255)
        /// </summary>
        [JsonProperty("cuttable_count")]
        public string CuttableCount { get; set; }

        /// <summary>
        /// 황금 망치 재련 적용 (1:적용, 이외 미 적용)
        /// </summary>
        [JsonProperty("golden_hammer_flag")]
        public string GoldenHammerFlag { get; set; }

        /// <summary>
        /// 복구 가능 횟수
        /// </summary>
        [JsonProperty("scroll_resilience_count")]
        public string ScrollResilienceCount { get; set; }

        /// <summary>
        /// 주문서 잔여 횟수
        /// </summary>
        [JsonProperty("scroll_upgrade_able_count")]
        public string ScrollUpgradeAbleCount { get; set; }

        /// <summary>
        /// 소울 명
        /// </summary>
        [JsonProperty("soul_name")]
        public string? SoulName { get; set; }

        /// <summary>
        /// 소울 옵션
        /// </summary>
        [JsonProperty("soul_option")]
        public string? SoulOption { get; set; }

        /// <summary>
        /// 장비 기타 옵션 정보
        /// </summary>
        [JsonProperty("item_etc_option")]
        public BattlePracticeCharacterItemEtcOptionDTO ItemEtcOption { get; set; }

        /// <summary>
        /// 강화 단계
        /// </summary>
        [JsonProperty("starforce")]
        public string Starforce { get; set; }

        /// <summary>
        /// 놀라운 장비 강화 주문서 사용 여부 (0:미사용, 1:사용)
        /// </summary>
        [JsonProperty("starforce_scroll_flag")]
        public string StarforceScrollFlag { get; set; }

        /// <summary>
        /// 장비 스타포스 옵션 정보
        /// </summary>
        [JsonProperty("item_starforce_option")]
        public BattlePracticeCharacterItemStarforceOptionDTO ItemStarforceOption { get; set; }

        /// <summary>
        /// 특수 반지 레벨
        /// </summary>
        [JsonProperty("special_ring_level")]
        public long SpecialRingLevel { get; set; }

        /// <summary>
        /// 장비 유효 기간 (KST)
        /// </summary>
        [JsonProperty("date_expire")]
        public DateTimeOffset? DateExpire
        {
            get
            {
                return _dateExpire?.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _dateExpire = value;
            }
        }

        private DateTimeOffset? _dateExpire;

        /// <summary>
        /// 프리스타일 쿠폰 적용 여부 (0:미적용, 1:적용)
        /// </summary>
        [JsonProperty("freestyle_flag")]
        public string? FreestyleFlag { get; set; }
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 장비 최종 옵션 정보
    /// </summary>
    public class BattlePracticeCharacterItemTotalOptionDTO
    {
        /// <summary>
        /// STR
        /// </summary>
        [JsonProperty("str")]
        public string Strength { get; set; }

        /// <summary>
        /// DEX
        /// </summary>
        [JsonProperty("dex")]
        public string Dexterity { get; set; }

        /// <summary>
        /// INT
        /// </summary>
        [JsonProperty("int")]
        public string Intelligence { get; set; }

        /// <summary>
        /// LUK
        /// </summary>
        [JsonProperty("luk")]
        public string Luck { get; set; }

        /// <summary>
        /// 최대 HP
        /// </summary>
        [JsonProperty("max_hp")]
        public string MaxHp { get; set; }

        /// <summary>
        /// 최대 MP
        /// </summary>
        [JsonProperty("max_mp")]
        public string MaxMp { get; set; }

        /// <summary>
        /// 공격력
        /// </summary>
        [JsonProperty("attack_power")]
        public string AttackPower { get; set; }

        /// <summary>
        /// 마력
        /// </summary>
        [JsonProperty("magic_power")]
        public string MagicPower { get; set; }

        /// <summary>
        /// 방어력
        /// </summary>
        [JsonProperty("armor")]
        public string Armor { get; set; }

        /// <summary>
        /// 이동속도
        /// </summary>
        [JsonProperty("speed")]
        public string Speed { get; set; }

        /// <summary>
        /// 점프력
        /// </summary>
        [JsonProperty("jump")]
        public string Jump { get; set; }

        /// <summary>
        /// 보스 몬스터 데미지 증가 (%)
        /// </summary>
        [JsonProperty("boss_damage")]
        public string BossDamage { get; set; }

        /// <summary>
        /// 몬스터 방어율 무시 (%)
        /// </summary>
        [JsonProperty("ignore_monster_armor")]
        public string IgnoreMonsterArmor { get; set; }

        /// <summary>
        /// 올스탯 (%)
        /// </summary>
        [JsonProperty("all_stat")]
        public string AllStat { get; set; }

        /// <summary>
        /// 데미지 (%)
        /// </summary>
        [JsonProperty("damage")]
        public string Damage { get; set; }

        /// <summary>
        /// 착용 레벨 감소
        /// </summary>
        [JsonProperty("equipment_level_decrease")]
        public long EquipmentLevelDecrease { get; set; }

        /// <summary>
        /// 최대 HP (%)
        /// </summary>
        [JsonProperty("max_hp_rate")]
        public string MaxHpRate { get; set; }

        /// <summary>
        /// 최대 MP (%)
        /// </summary>
        [JsonProperty("max_mp_rate")]
        public string MaxMpRate { get; set; }
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 장비 기본 옵션 정보
    /// </summary>
    public class BattlePracticeCharacterItemBaseOptionDTO
    {
        /// <summary>
        /// STR
        /// </summary>
        [JsonProperty("str")]
        public string Strength { get; set; }

        /// <summary>
        /// DEX
        /// </summary>
        [JsonProperty("dex")]
        public string Dexterity { get; set; }

        /// <summary>
        /// INT
        /// </summary>
        [JsonProperty("int")]
        public string Intelligence { get; set; }

        /// <summary>
        /// LUK
        /// </summary>
        [JsonProperty("luk")]
        public string Luck { get; set; }

        /// <summary>
        /// 최대 HP
        /// </summary>
        [JsonProperty("max_hp")]
        public string MaxHp { get; set; }

        /// <summary>
        /// 최대 MP
        /// </summary>
        [JsonProperty("max_mp")]
        public string MaxMp { get; set; }

        /// <summary>
        /// 공격력
        /// </summary>
        [JsonProperty("attack_power")]
        public string AttackPower { get; set; }

        /// <summary>
        /// 마력
        /// </summary>
        [JsonProperty("magic_power")]
        public string MagicPower { get; set; }

        /// <summary>
        /// 방어력
        /// </summary>
        [JsonProperty("armor")]
        public string Armor { get; set; }

        /// <summary>
        /// 이동속도
        /// </summary>
        [JsonProperty("speed")]
        public string Speed { get; set; }

        /// <summary>
        /// 점프력
        /// </summary>
        [JsonProperty("jump")]
        public string Jump { get; set; }

        /// <summary>
        /// 보스 몬스터 데미지 증가 (%)
        /// </summary>
        [JsonProperty("boss_damage")]
        public string BossDamage { get; set; }

        /// <summary>
        /// 몬스터 방어율 무시 (%)
        /// </summary>
        [JsonProperty("ignore_monster_armor")]
        public string IgnoreMonsterArmor { get; set; }

        /// <summary>
        /// 올스탯 (%)
        /// </summary>
        [JsonProperty("all_stat")]
        public string AllStat { get; set; }

        /// <summary>
        /// 최대 HP
        /// </summary>
        [JsonProperty("max_hp_rate")]
        public string MaxHpRate { get; set; }

        /// <summary>
        /// 최대 MP
        /// </summary>
        [JsonProperty("max_mp_rate")]
        public string MaxMpRate { get; set; }

        /// <summary>
        /// 기본 착용 레벨
        /// </summary>
        [JsonProperty("base_equipment_level")]
        public long BaseEquipmentLevel { get; set; }
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 장비 특별 옵션 정보
    /// </summary>
    public class BattlePracticeCharacterItemExceptionalOptionDTO
    {
        /// <summary>
        /// STR
        /// </summary>
        [JsonProperty("str")]
        public string Strength { get; set; }

        /// <summary>
        /// DEX
        /// </summary>
        [JsonProperty("dex")]
        public string Dexterity { get; set; }

        /// <summary>
        /// INT
        /// </summary>
        [JsonProperty("int")]
        public string Intelligence { get; set; }

        /// <summary>
        /// LUK
        /// </summary>
        [JsonProperty("luk")]
        public string Luck { get; set; }

        /// <summary>
        /// 최대 HP
        /// </summary>
        [JsonProperty("max_hp")]
        public string MaxHp { get; set; }

        /// <summary>
        /// 최대 MP
        /// </summary>
        [JsonProperty("max_mp")]
        public string MaxMp { get; set; }

        /// <summary>
        /// 공격력
        /// </summary>
        [JsonProperty("attack_power")]
        public string AttackPower { get; set; }

        /// <summary>
        /// 마력
        /// </summary>
        [JsonProperty("magic_power")]
        public string MagicPower { get; set; }

        /// <summary>
        /// 익셉서녈 강화 적용 횟수
        /// </summary>
        [JsonProperty("exceptional_upgrade")]
        public long ExceptionalUpgrade { get; set; }
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 장비 추가 옵션 정보
    /// </summary>
    public class BattlePracticeCharacterItemAddOptionDTO
    {
        /// <summary>
        /// STR
        /// </summary>
        [JsonProperty("str")]
        public string Strength { get; set; }

        /// <summary>
        /// DEX
        /// </summary>
        [JsonProperty("dex")]
        public string Dexterity { get; set; }

        /// <summary>
        /// INT
        /// </summary>
        [JsonProperty("int")]
        public string Intelligence { get; set; }

        /// <summary>
        /// LUK
        /// </summary>
        [JsonProperty("luk")]
        public string Luck { get; set; }

        /// <summary>
        /// 최대 HP
        /// </summary>
        [JsonProperty("max_hp")]
        public string MaxHp { get; set; }

        /// <summary>
        /// 최대 MP
        /// </summary>
        [JsonProperty("max_mp")]
        public string MaxMp { get; set; }

        /// <summary>
        /// 공격력
        /// </summary>
        [JsonProperty("attack_power")]
        public string AttackPower { get; set; }

        /// <summary>
        /// 마력
        /// </summary>
        [JsonProperty("magic_power")]
        public string MagicPower { get; set; }

        /// <summary>
        /// 방어력
        /// </summary>
        [JsonProperty("armor")]
        public string Armor { get; set; }

        /// <summary>
        /// 이동속도
        /// </summary>
        [JsonProperty("speed")]
        public string Speed { get; set; }

        /// <summary>
        /// 점프력
        /// </summary>
        [JsonProperty("jump")]
        public string Jump { get; set; }

        /// <summary>
        /// 보스 몬스터 데미지 증가 (%)
        /// </summary>
        [JsonProperty("boss_damage")]
        public string BossDamage { get; set; }

        /// <summary>
        /// 데미지 (%)
        /// </summary>
        [JsonProperty("damage")]
        public string Damage { get; set; }

        /// <summary>
        /// 올스탯 (%)
        /// </summary>
        [JsonProperty("all_stat")]
        public string AllStat { get; set; }

        /// <summary>
        /// 착용 레벨 감소
        /// </summary>
        [JsonProperty("equipment_level_decrease")]
        public long EquipmentLevelDecrease { get; set; }
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 장비 기타 옵션 정보
    /// </summary>
    public class BattlePracticeCharacterItemEtcOptionDTO
    {
        /// <summary>
        /// STR
        /// </summary>
        [JsonProperty("str")]
        public string Strength { get; set; }

        /// <summary>
        /// DEX
        /// </summary>
        [JsonProperty("dex")]
        public string Dexterity { get; set; }

        /// <summary>
        /// INT
        /// </summary>
        [JsonProperty("int")]
        public string Intelligence { get; set; }

        /// <summary>
        /// LUK
        /// </summary>
        [JsonProperty("luk")]
        public string Luck { get; set; }

        /// <summary>
        /// 최대 HP
        /// </summary>
        [JsonProperty("max_hp")]
        public string MaxHp { get; set; }

        /// <summary>
        /// 최대 MP
        /// </summary>
        [JsonProperty("max_mp")]
        public string MaxMp { get; set; }

        /// <summary>
        /// 공격력
        /// </summary>
        [JsonProperty("attack_power")]
        public string AttackPower { get; set; }

        /// <summary>
        /// 마력
        /// </summary>
        [JsonProperty("magic_power")]
        public string MagicPower { get; set; }

        /// <summary>
        /// 방어력
        /// </summary>
        [JsonProperty("armor")]
        public string Armor { get; set; }

        /// <summary>
        /// 이동속도
        /// </summary>
        [JsonProperty("speed")]
        public string Speed { get; set; }

        /// <summary>
        /// 점프력
        /// </summary>
        [JsonProperty("jump")]
        public string Jump { get; set; }
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 장비 스타포스 옵션 정보
    /// </summary>
    public class BattlePracticeCharacterItemStarforceOptionDTO
    {
        /// <summary>
        /// STR
        /// </summary>
        [JsonProperty("str")]
        public string Strength { get; set; }

        /// <summary>
        /// DEX
        /// </summary>
        [JsonProperty("dex")]
        public string Dexterity { get; set; }

        /// <summary>
        /// INT
        /// </summary>
        [JsonProperty("int")]
        public string Intelligence { get; set; }

        /// <summary>
        /// LUK
        /// </summary>
        [JsonProperty("luk")]
        public string Luck { get; set; }

        /// <summary>
        /// 최대 HP
        /// </summary>
        [JsonProperty("max_hp")]
        public string MaxHp { get; set; }

        /// <summary>
        /// 최대 MP
        /// </summary>
        [JsonProperty("max_mp")]
        public string MaxMp { get; set; }

        /// <summary>
        /// 공격력
        /// </summary>
        [JsonProperty("attack_power")]
        public string AttackPower { get; set; }

        /// <summary>
        /// 마력
        /// </summary>
        [JsonProperty("magic_power")]
        public string MagicPower { get; set; }

        /// <summary>
        /// 방어력
        /// </summary>
        [JsonProperty("armor")]
        public string Armor { get; set; }

        /// <summary>
        /// 이동속도
        /// </summary>
        [JsonProperty("speed")]
        public string Speed { get; set; }

        /// <summary>
        /// 점프력
        /// </summary>
        [JsonProperty("jump")]
        public string Jump { get; set; }
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 칭호 정보
    /// </summary>
    public class BattlePracticeCharacterItemTitleDTO
    {
        /// <summary>
        /// 칭호 장비 명
        /// </summary>
        [JsonProperty("title_name")]
        public string TitleName { get; set; }

        /// <summary>
        /// 칭호 아이콘
        /// </summary>
        [JsonProperty("title_icon")]
        public string TitleIcon { get; set; }

        /// <summary>
        /// 칭호 설명
        /// </summary>
        [JsonProperty("title_description")]
        public string TitleDescription { get; set; }

        /// <summary>
        /// 칭호 유효 기간 (KST)
        /// </summary>
        [JsonProperty("date_expire")]
        public DateTimeOffset? DateExpire
        {
            get
            {
                return _dateExpire?.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _dateExpire = value;
            }
        }

        private DateTimeOffset? _dateExpire;

        /// <summary>
        /// 칭호 옵션 유효 기간 (expired:만료, null:무제한) (KST)
        /// </summary>
        [JsonProperty("date_option_expire")]
        public DateTimeOffset? DateOptionExpire
        {
            get
            {
                return _dateOptionExpire?.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _dateOptionExpire = value;
            }
        }

        private DateTimeOffset? _dateOptionExpire;

        /// <summary>
        /// 외형 설정에 등록한 칭호 장비 명
        /// </summary>
        [JsonProperty("title_shape_name")]
        public string? TitleShapeName { get; set; }

        /// <summary>
        /// 외형 설정에 등록한 칭호 아이콘
        /// </summary>
        [JsonProperty("title_shape_icon")]
        public string? TitleShapeIcon { get; set; }

        /// <summary>
        /// 외형 설정에 등록한 칭호 설명
        /// </summary>
        [JsonProperty("title_shape_description")]
        public string? TitleShapeDescription { get; set; }
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 적용 세트 효과 정보
    /// </summary>
    public class BattlePracticeCharacterSetEffectObjectDTO
    {
        /// <summary>
        /// 세트 효과 정보
        /// </summary>
        [JsonProperty("set_effect")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<BattlePracticeCharacterSetEffectDTO> SetEffect { get; set; } = new();
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 세트 효과 정보
    /// </summary>
    public class BattlePracticeCharacterSetEffectDTO
    {
        /// <summary>
        /// 세트 효과 명
        /// </summary>
        [JsonProperty("set_name")]
        public string SetName { get; set; }

        /// <summary>
        /// 세트 개수 (럭키 아이템 포함)
        /// </summary>
        [JsonProperty("total_set_count")]
        public long TotalSetCount { get; set; }

        /// <summary>
        /// 적용 중인 세트 효과 정보
        /// </summary>
        [JsonProperty("set_effect_info")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<BattlePracticeCharacterSetEffectInfoDTO> SetEffectInfo { get; set; } = new();
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 적용 중인 세트 효과 정보
    /// </summary>
    public class BattlePracticeCharacterSetEffectInfoDTO
    {
        /// <summary>
        /// 세트 효과 레벨 (장비 수)
        /// </summary>
        [JsonProperty("set_count")]
        public long SetCount { get; set; }

        /// <summary>
        /// 세트 효과
        /// </summary>
        [JsonProperty("set_option")]
        public string SetOption { get; set; }
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 캐시 장비 정보
    /// </summary>
    public class BattlePracticeCharacterCashItemObjectDTO
    {
        /// <summary>
        /// 장착 중인 캐시 장비
        /// </summary>
        [JsonProperty("cash_item_equipment_base")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<BattlePracticeCharacterCashItemEquipmentDTO> CashItemEquipmentBase { get; set; } = new();

        /// <summary>
        /// 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드에서 장착 중인 캐시 장비
        /// </summary>
        [JsonProperty("additional_cash_item_equipment_base")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<BattlePracticeCharacterCashItemEquipmentDTO> AdditionalCashItemEquipmentBase { get; set; } = new();
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 장착 캐시 장비 정보
    /// </summary>
    public class BattlePracticeCharacterCashItemEquipmentDTO
    {
        /// <summary>
        /// 캐시 장비 부위 명
        /// </summary>
        [JsonProperty("cash_item_equipment_part")]
        public string CashItemEquipmentPart { get; set; }

        /// <summary>
        /// 캐시 장비 슬롯 위치
        /// </summary>
        [JsonProperty("cash_item_equipment_slot")]
        public string CashItemEquipmentSlot { get; set; }

        /// <summary>
        /// 캐시 장비 명
        /// </summary>
        [JsonProperty("cash_item_name")]
        public string CashItemName { get; set; }

        /// <summary>
        /// 캐시 장비 아이콘
        /// </summary>
        [JsonProperty("cash_item_icon")]
        public string CashItemIcon { get; set; }

        /// <summary>
        /// 캐시 장비 설명
        /// </summary>
        [JsonProperty("cash_item_description")]
        public string? CashItemDescription { get; set; }

        /// <summary>
        /// 캐시 장비 옵션 목록
        /// </summary>
        [JsonProperty("cash_item_option")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<BattlePracticeCharacterCashItemOptionDTO> CashItemOption { get; set; } = new();

        /// <summary>
        /// 캐시 장비 유효 기간 (KST)
        /// </summary>
        [JsonProperty("date_expire")]
        public DateTimeOffset? DateExpire
        {
            get
            {
                return _dateExpire?.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _dateExpire = value;
            }
        }

        private DateTimeOffset? _dateExpire;

        /// <summary>
        /// 캐시 장비 옵션 유효 기간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
        /// </summary>
        [JsonProperty("date_option_expire")]
        public DateTimeOffset? DateOptionExpire
        {
            get
            {
                return _dateOptionExpire?.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _dateOptionExpire = value;
            }
        }

        private DateTimeOffset? _dateOptionExpire;
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 캐시 장비 옵션
    /// </summary>
    public class BattlePracticeCharacterCashItemOptionDTO
    {
        /// <summary>
        /// 옵션 타입
        /// </summary>
        [JsonProperty("option_type")]
        public string OptionType { get; set; }

        /// <summary>
        /// 옵션 값
        /// </summary>
        [JsonProperty("option_value")]
        public string OptionValue { get; set; }
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 장착 펫 정보
    /// </summary>
    public class BattlePracticeCharacterPetObjectDTO
    {
        /// <summary>
        /// 펫1 명
        /// </summary>
        [JsonProperty("pet_1_name")]
        public string? Pet1Name { get; set; }

        /// <summary>
        /// 펫1 닉네임
        /// </summary>
        [JsonProperty("pet_1_nickname")]
        public string? Pet1Nickname { get; set; }

        /// <summary>
        /// 펫1 아이콘
        /// </summary>
        [JsonProperty("pet_1_icon")]
        public string? Pet1Icon { get; set; }

        /// <summary>
        /// 펫1 설명
        /// </summary>
        [JsonProperty("pet_1_description")]
        public string? Pet1Description { get; set; }

        /// <summary>
        /// 펫1 장착 정보
        /// </summary>
        [JsonProperty("pet_1_equipment")]
        public BattlePracticeCharacterPetEquipmentDTO? Pet1Equipment { get; set; }

        /// <summary>
        /// 펫1 버프 자동스킬 정보
        /// </summary>
        [JsonProperty("pet_1_auto_skill")]
        public BattlePracticeCharacterPetAutoSkillDTO? Pet1AutoSkill { get; set; }

        /// <summary>
        /// 펫1 원더 펫 종류
        /// </summary>
        [JsonProperty("pet_1_pet_type")]
        public string? Pet1PetType { get; set; }

        /// <summary>
        /// 펫1 펫 보유 스킬
        /// </summary>
        [JsonProperty("pet_1_skill")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<string> Pet1Skill { get; set; } = new();

        /// <summary>
        /// 펫1 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
        /// </summary>
        [JsonProperty("pet_1_date_expire")]
        public DateTimeOffset? Pet1DateExpire
        {
            get
            {
                return _pet1DateExpire?.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _pet1DateExpire = value;
            }
        }

        private DateTimeOffset? _pet1DateExpire;

        /// <summary>
        /// 펫2 명
        /// </summary>
        [JsonProperty("pet_2_name")]
        public string? Pet2Name { get; set; }

        /// <summary>
        /// 펫2 닉네임
        /// </summary>
        [JsonProperty("pet_2_nickname")]
        public string? Pet2Nickname { get; set; }

        /// <summary>
        /// 펫2 아이콘
        /// </summary>
        [JsonProperty("pet_2_icon")]
        public string? Pet2Icon { get; set; }

        /// <summary>
        /// 펫2 설명
        /// </summary>
        [JsonProperty("pet_2_description")]
        public string? Pet2Description { get; set; }

        /// <summary>
        /// 펫2 장착 정보
        /// </summary>
        [JsonProperty("pet_2_equipment")]
        public BattlePracticeCharacterPetEquipmentDTO? Pet2Equipment { get; set; }

        /// <summary>
        /// 펫2 버프 자동스킬 정보
        /// </summary>
        [JsonProperty("pet_2_auto_skill")]
        public BattlePracticeCharacterPetAutoSkillDTO? Pet2AutoSkill { get; set; }

        /// <summary>
        /// 펫2 원더 펫 종류
        /// </summary>
        [JsonProperty("pet_2_pet_type")]
        public string? Pet2PetType { get; set; }

        /// <summary>
        /// 펫2 펫 보유 스킬
        /// </summary>
        [JsonProperty("pet_2_skill")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<string> Pet2Skill { get; set; } = new();

        /// <summary>
        /// 펫2 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
        /// </summary>
        [JsonProperty("pet_2_date_expire")]
        public DateTimeOffset? Pet2DateExpire
        {
            get
            {
                return _pet2DateExpire?.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _pet2DateExpire = value;
            }
        }

        private DateTimeOffset? _pet2DateExpire;

        /// <summary>
        /// 펫3 명
        /// </summary>
        [JsonProperty("pet_3_name")]
        public string? Pet3Name { get; set; }

        /// <summary>
        /// 펫3 닉네임
        /// </summary>
        [JsonProperty("pet_3_nickname")]
        public string? Pet3Nickname { get; set; }

        /// <summary>
        /// 펫3 아이콘
        /// </summary>
        [JsonProperty("pet_3_icon")]
        public string? Pet3Icon { get; set; }

        /// <summary>
        /// 펫3 설명
        /// </summary>
        [JsonProperty("pet_3_description")]
        public string? Pet3Description { get; set; }

        /// <summary>
        /// 펫3 장착 정보
        /// </summary>
        [JsonProperty("pet_3_equipment")]
        public BattlePracticeCharacterPetEquipmentDTO? Pet3Equipment { get; set; }

        /// <summary>
        /// 펫3 버프 자동스킬 정보
        /// </summary>
        [JsonProperty("pet_3_auto_skill")]
        public BattlePracticeCharacterPetAutoSkillDTO? Pet3AutoSkill { get; set; }

        /// <summary>
        /// 펫3 원더 펫 종류
        /// </summary>
        [JsonProperty("pet_3_pet_type")]
        public string? Pet3PetType { get; set; }

        /// <summary>
        /// 펫3 펫 보유 스킬
        /// </summary>
        [JsonProperty("pet_3_skill")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<string> Pet3Skill { get; set; } = new();

        /// <summary>
        /// 펫3 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
        /// </summary>
        [JsonProperty("pet_3_date_expire")]
        public DateTimeOffset? Pet3DateExpire
        {
            get
            {
                return _pet3DateExpire?.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _pet3DateExpire = value;
            }
        }

        private DateTimeOffset? _pet3DateExpire;
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 펫 장착 정보
    /// </summary>
    public class BattlePracticeCharacterPetEquipmentDTO
    {
        /// <summary>
        /// 아이템 명
        /// </summary>
        [JsonProperty("item_name")]
        public string ItemName { get; set; }

        /// <summary>
        /// 아이템 아이콘
        /// </summary>
        [JsonProperty("item_icon")]
        public string ItemIcon { get; set; }

        /// <summary>
        /// 아이템 설명
        /// </summary>
        [JsonProperty("item_description")]
        public string? ItemDescription { get; set; }

        /// <summary>
        /// 아이템의 표기상 옵션
        /// </summary>
        [JsonProperty("item_option")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<BattlePracticeCharacterPetEquipmentItemOptionDTO> ItemOption { get; set; } = new();

        /// <summary>
        /// 주문서 횟수
        /// </summary>
        [JsonProperty("scroll_upgrade")]
        public long ScrollUpgrade { get; set; }

        /// <summary>
        /// 주문서 잔여 횟수
        /// </summary>
        [JsonProperty("scroll_upgradable")]
        public long ScrollUpgradable { get; set; }

        /// <summary>
        /// 아이템 외형
        /// </summary>
        [JsonProperty("item_shape")]
        public string? ItemShape { get; set; }

        /// <summary>
        /// 아이템 외형 아이콘
        /// </summary>
        [JsonProperty("item_shape_icon")]
        public string? ItemShapeIcon { get; set; }

        /// <summary>
        /// 아이템 만료 시간
        /// </summary>
        [JsonProperty("item_date_expire")]
        public DateTimeOffset? ItemDateExpire
        {
            get
            {
                return _itemDateExpire?.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _itemDateExpire = value;
            }
        }

        private DateTimeOffset? _itemDateExpire;
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 펫 장비 옵션
    /// </summary>
    public class BattlePracticeCharacterPetEquipmentItemOptionDTO
    {
        /// <summary>
        /// 옵션 타입
        /// </summary>
        [JsonProperty("option_type")]
        public string OptionType { get; set; }

        /// <summary>
        /// 옵션 값
        /// </summary>
        [JsonProperty("option_value")]
        public string OptionValue { get; set; }
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 펫 자동스킬 정보
    /// </summary>
    public class BattlePracticeCharacterPetAutoSkillDTO
    {
        /// <summary>
        /// 첫 번째 슬롯에 등록된 자동 스킬 명
        /// </summary>
        [JsonProperty("skill_1")]
        public string? Skill1 { get; set; }

        /// <summary>
        /// 첫 번째 슬롯에 등록된 자동 스킬 아이콘
        /// </summary>
        [JsonProperty("skill_1_icon")]
        public string? Skill1Icon { get; set; }

        /// <summary>
        /// 두 번째 슬롯에 등록된 자동 스킬 명
        /// </summary>
        [JsonProperty("skill_2")]
        public string? Skill2 { get; set; }

        /// <summary>
        /// 두 번째 슬롯에 등록된 자동 스킬 아이콘
        /// </summary>
        [JsonProperty("skill_2_icon")]
        public string? Skill2Icon { get; set; }
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 캐릭터 스킬 정보
    /// </summary>
    public class BattlePracticeCharacterSkillObjectDTO
    {
        /// <summary>
        /// 스킬 정보
        /// </summary>
        [JsonProperty("character_skill")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<BattlePracticeCharacterSkillInfoDTO> CharacterSkill { get; set; } = new();
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 스킬 정보
    /// </summary>
    public class BattlePracticeCharacterSkillInfoDTO
    {
        /// <summary>
        /// 스킬 명
        /// </summary>
        [JsonProperty("skill_name")]
        public string SkillName { get; set; }

        /// <summary>
        /// 스킬 설명
        /// </summary>
        [JsonProperty("skill_description")]
        public string SkillDescription { get; set; }

        /// <summary>
        /// 스킬 레벨
        /// </summary>
        [JsonProperty("skill_level")]
        public long SkillLevel { get; set; }

        /// <summary>
        /// 스킬 효과
        /// </summary>
        [JsonProperty("skill_effect")]
        public string? SkillEffect { get; set; }

        /// <summary>
        /// 스킬 아이콘
        /// </summary>
        [JsonProperty("skill_icon")]
        public string SkillIcon { get; set; }
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 링크 스킬 정보
    /// </summary>
    public class BattlePracticeCharacterLinkSkillObjectDTO
    {
        /// <summary>
        /// 링크 스킬 정보
        /// </summary>
        [JsonProperty("character_link_skill")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<BattlePracticeCharacterSkillInfoDTO> CharacterLinkSkill { get; set; } = new();

        /// <summary>
        /// 내 링크 스킬 정보
        /// </summary>
        [JsonProperty("character_owned_link_skill")]
        public BattlePracticeCharacterSkillInfoDTO? CharacterOwnedLinkSkill { get; set; }
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 V 매트릭스 정보
    /// </summary>
    public class BattlePracticeCharacterVMatrixObjectDTO
    {
        /// <summary>
        /// V 코어 정보
        /// </summary>
        [JsonProperty("character_v_core_equipment")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<BattlePracticeCharacterVCoreDTO> CharacterVCoreEquipment { get; set; } = new();
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 V 코어 정보
    /// </summary>
    public class BattlePracticeCharacterVCoreDTO
    {
        /// <summary>
        /// 슬롯 인덱스
        /// </summary>
        [JsonProperty("slot_id")]
        public string SlotId { get; set; }

        /// <summary>
        /// 슬롯 레벨
        /// </summary>
        [JsonProperty("slot_level")]
        public long SlotLevel { get; set; }

        /// <summary>
        /// 코어 명
        /// </summary>
        [JsonProperty("v_core_name")]
        public string VCoreName { get; set; }

        /// <summary>
        /// 코어 타입
        /// </summary>
        [JsonProperty("v_core_type")]
        public string VCoreType { get; set; }

        /// <summary>
        /// 코어의 레벨
        /// </summary>
        [JsonProperty("v_core_level")]
        public long VCoreLevel { get; set; }

        /// <summary>
        /// 코어에 해당하는 스킬 명
        /// </summary>
        [JsonProperty("v_core_skill_1")]
        public string? VCoreSkill1 { get; set; }

        /// <summary>
        /// (강화 코어인 경우) 코어에 해당하는 두 번째 스킬 명
        /// </summary>
        [JsonProperty("v_core_skill_2")]
        public string? VCoreSkill2 { get; set; }

        /// <summary>
        /// (강화 코어인 경우) 코어에 해당하는 세 번째 스킬 명
        /// </summary>
        [JsonProperty("v_core_skill_3")]
        public string? VCoreSkill3 { get; set; }
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 HEXA 매트릭스 정보
    /// </summary>
    public class BattlePracticeCharacterHexaMatrixObjectDTO
    {
        /// <summary>
        /// HEXA 코어 정보
        /// </summary>
        [JsonProperty("hexa_core_object")]
        public BattlePracticeCharacterHexaCoreObjectDTO HexaCoreObject { get; set; }

        /// <summary>
        /// HEXA 스탯 정보
        /// </summary>
        [JsonProperty("hexa_matrix_stat_object")]
        public BattlePracticeCharacterHexaMatrixStatObjectDTO HexaMatrixStatObject { get; set; }
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 HEXA 매트릭스 정보
    /// </summary>
    public class BattlePracticeCharacterHexaCoreObjectDTO
    {
        /// <summary>
        /// HEXA 매트릭스 코어 정보
        /// </summary>
        [JsonProperty("character_hexa_core_equipment")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<BattlePracticeCharacterHexaCoreEquipmentDTO> CharacterHexaCoreEquipment { get; set; } = new();
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 HEXA 매트릭스 코어 정보
    /// </summary>
    public class BattlePracticeCharacterHexaCoreEquipmentDTO
    {
        /// <summary>
        /// 코어 명
        /// </summary>
        [JsonProperty("hexa_core_name")]
        public string HexaCoreName { get; set; }

        /// <summary>
        ///  코어 레벨
        /// </summary>
        [JsonProperty("hexa_core_level")]
        public long HexaCoreLevel { get; set; }

        /// <summary>
        /// 코어 타입
        /// </summary>
        [JsonProperty("hexa_core_type")]
        public string HexaCoreType { get; set; }

        /// <summary>
        /// 연결된 스킬
        /// </summary>
        [JsonProperty("linked_skill")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<BattlePracticeCharacterHexaLinkedSkillDTO> LinkedSkill { get; set; } = new();
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 HEXA 매트릭스 코어에 연결된 스킬
    /// </summary>
    public class BattlePracticeCharacterHexaLinkedSkillDTO
    {
        /// <summary>
        /// HEXA 스킬 명
        /// </summary>
        [JsonProperty("hexa_skill_id")]
        public string HexaSkillId { get; set; }
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 HEXA 스탯 정보
    /// </summary>
    public class BattlePracticeCharacterHexaMatrixStatObjectDTO
    {
        /// <summary>
        /// HEXA 스탯 I 코어 정보
        /// </summary>
        [JsonProperty("character_hexa_stat_core")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<BattlePracticeCharacterHexaStatCoreDTO> CharacterHexaStatCore { get; set; } = new();

        /// <summary>
        /// HEXA 스탯 II 코어 정보
        /// </summary>
        [JsonProperty("character_hexa_stat_core_2")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<BattlePracticeCharacterHexaStatCoreDTO> CharacterHexaStatCore2 { get; set; } = new();

        /// <summary>
        /// HEXA 스탯 III 코어 정보
        /// </summary>
        [JsonProperty("character_hexa_stat_core_3")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<BattlePracticeCharacterHexaStatCoreDTO> CharacterHexaStatCore3 { get; set; } = new();
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 HEXA 스탯 코어 정보
    /// </summary>
    public class BattlePracticeCharacterHexaStatCoreDTO
    {
        /// <summary>
        /// 슬롯 인덱스
        /// </summary>
        [JsonProperty("slot_id")]
        public string SlotId { get; set; }

        /// <summary>
        /// 메인 스탯 명
        /// </summary>
        [JsonProperty("main_stat_name")]
        public string MainStatName { get; set; }

        /// <summary>
        /// 첫 번째 서브 명
        /// </summary>
        [JsonProperty("sub_stat_name_1")]
        public string SubStatName1 { get; set; }

        /// <summary>
        /// 두 번째 서브 명
        /// </summary>
        [JsonProperty("sub_stat_name_2")]
        public string SubStatName2 { get; set; }

        /// <summary>
        /// 메인 스탯 레벨
        /// </summary>
        [JsonProperty("main_stat_level")]
        public long MainStatLevel { get; set; }

        /// <summary>
        /// 첫 번째 서브 레벨
        /// </summary>
        [JsonProperty("sub_stat_level_1")]
        public long SubStatLevel1 { get; set; }

        /// <summary>
        /// 두 번째 서브 레벨
        /// </summary>
        [JsonProperty("sub_stat_level_2")]
        public long SubStatLevel2 { get; set; }

        /// <summary>
        /// 스탯 코어 등급
        /// </summary>
        [JsonProperty("stat_grade")]
        public long StatGrade { get; set; }
    }

    /// <summary>
    /// 연무장 입장 시 캐릭터 예비 특수 반지 슬롯에 장착한 특수 반지 정보
    /// </summary>
    public class BattlePracticeCharacterRingReserveSkillObjectDTO
    {
        /// <summary>
        /// 예비 특수 반지 슬롯에 장착한 특수 반지
        /// </summary>
        [JsonProperty("special_ring_reserve_name")]
        public string? SpecialRingReserveName { get; set; }

        /// <summary>
        /// 예비 특수 반지 슬롯에 장착한 특수 반지 레벨
        /// </summary>
        [JsonProperty("special_ring_reserve_level")]
        public long? SpecialRingReserveLevel { get; set; }

        /// <summary>
        /// 예비 특수 반지 슬롯에 장착한 특수 반지 아이콘
        /// </summary>
        [JsonProperty("special_ring_reserve_icon")]
        public string? SpecialRingReserveIcon { get; set; }

        /// <summary>
        /// 예비 특수 반지 슬롯에 장착한 특수 반지 설명
        /// </summary>
        [JsonProperty("special_ring_reserve_description")]
        public string? SpecialRingReserveDescription { get; set; }
    }

    /// <summary>
    /// 연무장 입장 시 유니온 공격대 정보
    /// </summary>
    public class BattlePracticeUnionRaiderObjectDTO
    {
        /// <summary>
        /// 유니온 공격대원 효과
        /// </summary>
        [JsonProperty("union_raider_stat")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<string> UnionRaiderStat { get; set; } = new();

        /// <summary>
        /// 유니온 공격대 점령 효과
        /// </summary>
        [JsonProperty("union_occupied_stat")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<string> UnionOccupiedStat { get; set; } = new();
    }

    /// <summary>
    /// 연무장 입장 시 유니온 아티팩트 정보
    /// </summary>
    public class BattlePracticeUnionArtifactObjectDTO
    {
        /// <summary>
        /// 아티팩트 효과 정보
        /// </summary>
        [JsonProperty("union_artifact_effect")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<BattlePracticeUnionArtifactEffectDTO> UnionArtifactEffect { get; set; } = new();
    }

    /// <summary>
    /// 연무장 입장 시 유니온 아티팩트 효과 정보
    /// </summary>
    public class BattlePracticeUnionArtifactEffectDTO
    {
        /// <summary>
        /// 아티팩트 효과 명
        /// </summary>
        [JsonProperty("name")]
        public string Name { get; set; }

        /// <summary>
        /// 아티팩트 효과 레벨
        /// </summary>
        [JsonProperty("level")]
        public long Level { get; set; }
    }

    /// <summary>
    /// 연무장 입장 시 유니온 챔피언 정보
    /// </summary>
    public class BattlePracticeUnionChampionObjectDTO
    {
        /// <summary>
        /// 유니온 챔피언 휘장
        /// </summary>
        [JsonProperty("champion_badge_total_info")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<BattlePracticeUnionChampionBadgeDTO> ChampionBadgeTotalInfo { get; set; } = new();
    }

    /// <summary>
    /// 연무장 입장 시 유니온 챔피언 휘장 정보
    /// </summary>
    public class BattlePracticeUnionChampionBadgeDTO
    {
        /// <summary>
        /// 유니온 챔피언 휘장 효과
        /// </summary>
        [JsonProperty("stat")]
        public string Stat { get; set; }
    }

    /// <summary>
    /// 연무장 입장 시 길드 정보
    /// </summary>
    public class BattlePracticeGuildObjectDTO
    {
        /// <summary>
        /// 길드 스킬 목록
        /// </summary>
        [JsonProperty("guild_skill")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<BattlePracticeGuildSkillDTO> GuildSkill { get; set; } = new();

        /// <summary>
        /// 노블레스 스킬 목록
        /// </summary>
        [JsonProperty("guild_noblesse_skill")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<BattlePracticeGuildSkillDTO> GuildNoblesseSkill { get; set; } = new();
    }

    /// <summary>
    /// 연무장 입장 시 길드 스킬
    /// </summary>
    public class BattlePracticeGuildSkillDTO
    {
        /// <summary>
        /// 스킬 명
        /// </summary>
        [JsonProperty("skill_name")]
        public string SkillName { get; set; }

        /// <summary>
        /// 스킬 설명
        /// </summary>
        [JsonProperty("skill_description")]
        public string SkillDescription { get; set; }

        /// <summary>
        /// 스킬 레벨
        /// </summary>
        [JsonProperty("skill_level")]
        public long SkillLevel { get; set; }

        /// <summary>
        /// 스킬 레벨별 효과
        /// </summary>
        [JsonProperty("skill_effect")]
        public string SkillEffect { get; set; }

        /// <summary>
        /// 스킬 아이콘
        /// </summary>
        [JsonProperty("skill_icon")]
        public string SkillIcon { get; set; }
    }
}
