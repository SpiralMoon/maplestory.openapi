import {
  BattlePracticeCharacterAbilityInfoBody,
  BattlePracticeCharacterAbilityObjectBody,
  BattlePracticeCharacterBasicBody,
  BattlePracticeCharacterBasicStatBody,
  BattlePracticeCharacterCashItemEquipmentBody,
  BattlePracticeCharacterCashItemObjectBody,
  BattlePracticeCharacterCashItemOptionBody,
  BattlePracticeCharacterInfoBody,
  BattlePracticeCharacterFinalStatBody,
  BattlePracticeGuildObjectBody,
  BattlePracticeGuildSkillBody,
  BattlePracticeCharacterHexaCoreEquipmentBody,
  BattlePracticeCharacterHexaCoreObjectBody,
  BattlePracticeCharacterHexaLinkedSkillBody,
  BattlePracticeCharacterHexaMatrixObjectBody,
  BattlePracticeCharacterHexaMatrixStatObjectBody,
  BattlePracticeCharacterHexaStatCoreBody,
  BattlePracticeCharacterHyperStatBody,
  BattlePracticeCharacterHyperStatObjectBody,
  BattlePracticeCharacterItemAddOptionBody,
  BattlePracticeCharacterItemBaseOptionBody,
  BattlePracticeCharacterItemDragonEquipmentBody,
  BattlePracticeCharacterItemEquipmentBody,
  BattlePracticeCharacterItemEquipmentObjectBody,
  BattlePracticeCharacterItemEtcOptionBody,
  BattlePracticeCharacterItemExceptionalOptionBody,
  BattlePracticeCharacterItemMechanicEquipmentBody,
  BattlePracticeCharacterItemObjectBody,
  BattlePracticeCharacterItemStarforceOptionBody,
  BattlePracticeCharacterItemTitleBody,
  BattlePracticeCharacterItemTotalOptionBody,
  BattlePracticeCharacterLinkSkillObjectBody,
  BattlePracticeCharacterOtherStatBody,
  BattlePracticeCharacterOtherStatDetailBody,
  BattlePracticeCharacterOtherStatInfoBody,
  BattlePracticeCharacterPetAutoSkillBody,
  BattlePracticeCharacterPetEquipmentBody,
  BattlePracticeCharacterPetEquipmentOptionBody,
  BattlePracticeCharacterPetiteLunaPetSkillBody,
  BattlePracticeCharacterPetObjectBody,
  BattlePracticeCharacterPropensityBody,
  BattlePracticeCharacterRingReserveSkillObjectBody,
  BattlePracticeCharacterSetEffectBody,
  BattlePracticeCharacterSetEffectInfoBody,
  BattlePracticeCharacterSetEffectObjectBody,
  BattlePracticeCharacterSkillInfoBody,
  BattlePracticeCharacterSkillObjectBody,
  BattlePracticeCharacterStatBody,
  BattlePracticeCharacterSymbolBody,
  BattlePracticeCharacterSymbolStatBody,
  BattlePracticeUnionArtifactEffectBody,
  BattlePracticeUnionArtifactObjectBody,
  BattlePracticeUnionChampionBadgeBody,
  BattlePracticeUnionChampionObjectBody,
  BattlePracticeUnionRaiderObjectBody,
  BattlePracticeCharacterVCoreBody,
  BattlePracticeCharacterVMatrixObjectBody,
} from '../../response/battlePractice/battlePracticeCharacterInfoBody';

/**
 * 연무장 입장 시 캐릭터 능력치 관련 정보
 */
export class BattlePracticeCharacterInfoDto {
  /**
   * 캐릭터 기본 정보
   */
  public basicObject: BattlePracticeCharacterBasicDto | null;

  /**
   * 캐릭터 스탯 정보
   */
  public statObject: BattlePracticeCharacterStatDto | null;

  /**
   * 캐릭터 하이퍼스탯 정보
   */
  public hyperStatObject: BattlePracticeCharacterHyperStatObjectDto | null;

  /**
   * 캐릭터 성향 정보
   */
  public propensityObject: BattlePracticeCharacterPropensityDto | null;

  /**
   * 캐릭터 어빌리티 정보
   */
  public abilityObject: BattlePracticeCharacterAbilityObjectDto | null;

  /**
   * 캐릭터 장비 정보
   */
  public itemObject: BattlePracticeCharacterItemObjectDto | null;

  /**
   * 캐릭터 캐시 장비 정보
   */
  public cashItemObject: BattlePracticeCharacterCashItemObjectDto | null;

  /**
   * 캐릭터 펫 장비 정보
   */
  public petObject: BattlePracticeCharacterPetObjectDto | null;

  /**
   * 캐릭터 스킬 정보
   */
  public skillObject: BattlePracticeCharacterSkillObjectDto | null;

  /**
   * 캐릭터 링크 스킬 정보
   */
  public linkSkillObject: BattlePracticeCharacterLinkSkillObjectDto | null;

  /**
   * 캐릭터 V매트릭스 정보
   */
  public vMatrixObject: BattlePracticeCharacterVMatrixObjectDto | null;

  /**
   * 캐릭터 HEXA 매트릭스 정보
   */
  public hexaMatrixObject: BattlePracticeCharacterHexaMatrixObjectDto | null;

  /**
   * 캐릭터 예비 특수 반지 장착 정보
   */
  public ringReserveSkillObject: BattlePracticeCharacterRingReserveSkillObjectDto | null;

  /**
   * 유니온 공격대 정보
   */
  public unionRaiderObject: BattlePracticeUnionRaiderObjectDto | null;

  /**
   * 유니온 아티팩트 정보
   */
  public unionArtifactObject: BattlePracticeUnionArtifactObjectDto | null;

  /**
   * 유니온 챔피언 정보
   */
  public unionChampionObject: BattlePracticeUnionChampionObjectDto | null;

  /**
   * 길드 정보
   */
  public guildObject: BattlePracticeGuildObjectDto | null;

  constructor(obj: BattlePracticeCharacterInfoBody) {
    this.basicObject = obj.basic_object
      ? new BattlePracticeCharacterBasicDto(obj.basic_object)
      : null;
    this.statObject = obj.stat_object
      ? new BattlePracticeCharacterStatDto(obj.stat_object)
      : null;
    this.hyperStatObject = obj.hyper_stat_object
      ? new BattlePracticeCharacterHyperStatObjectDto(obj.hyper_stat_object)
      : null;
    this.propensityObject = obj.propensity_object
      ? new BattlePracticeCharacterPropensityDto(obj.propensity_object)
      : null;
    this.abilityObject = obj.ability_object
      ? new BattlePracticeCharacterAbilityObjectDto(obj.ability_object)
      : null;
    this.itemObject = obj.item_object
      ? new BattlePracticeCharacterItemObjectDto(obj.item_object)
      : null;
    this.cashItemObject = obj.cash_item_object
      ? new BattlePracticeCharacterCashItemObjectDto(obj.cash_item_object)
      : null;
    this.petObject = obj.pet_object
      ? new BattlePracticeCharacterPetObjectDto(obj.pet_object)
      : null;
    this.skillObject = obj.skill_object
      ? new BattlePracticeCharacterSkillObjectDto(obj.skill_object)
      : null;
    this.linkSkillObject = obj.link_skill_object
      ? new BattlePracticeCharacterLinkSkillObjectDto(obj.link_skill_object)
      : null;
    this.vMatrixObject = obj.v_matrix_object
      ? new BattlePracticeCharacterVMatrixObjectDto(obj.v_matrix_object)
      : null;
    this.hexaMatrixObject = obj.hexa_matrix_object
      ? new BattlePracticeCharacterHexaMatrixObjectDto(obj.hexa_matrix_object)
      : null;
    this.ringReserveSkillObject = obj.ring_reserve_skill_object
      ? new BattlePracticeCharacterRingReserveSkillObjectDto(obj.ring_reserve_skill_object)
      : null;
    this.unionRaiderObject = obj.union_raider_object
      ? new BattlePracticeUnionRaiderObjectDto(obj.union_raider_object)
      : null;
    this.unionArtifactObject = obj.union_artifact_object
      ? new BattlePracticeUnionArtifactObjectDto(obj.union_artifact_object)
      : null;
    this.unionChampionObject = obj.union_champion_object
      ? new BattlePracticeUnionChampionObjectDto(obj.union_champion_object)
      : null;
    this.guildObject = obj.guild_object
      ? new BattlePracticeGuildObjectDto(obj.guild_object)
      : null;
  }
}

/**
 * 연무장 입장 시 캐릭터 기본 정보
 */
export class BattlePracticeCharacterBasicDto {
  /**
   * 캐릭터 명
   */
  public characterName: string;

  /**
   * 캐릭터 레벨
   */
  public characterLevel: number;

  /**
   * 캐릭터 직업
   */
  public characterClass: string;

  /**
   * 캐릭터 전직 차수
   */
  public characterClassLevel: string;

  /**
   * 캐릭터 외형 이미지
   */
  public characterImage: string;

  constructor(obj: BattlePracticeCharacterBasicBody) {
    this.characterName = obj.character_name;
    this.characterLevel = obj.character_level;
    this.characterClass = obj.character_class;
    this.characterClassLevel = obj.character_class_level;
    this.characterImage = obj.character_image;
  }
}

/**
 * 연무장 입장 시 캐릭터 스탯 관련 정보
 */
export class BattlePracticeCharacterStatDto {
  /**
   * 스탯 정보
   */
  public basicStatObject: BattlePracticeCharacterBasicStatDto;

  /**
   * 장착 심볼 정보
   */
  public symbolStatObject: BattlePracticeCharacterSymbolStatDto;

  /**
   * 기타 능력치 영향 요소
   */
  public otherStatObject: BattlePracticeCharacterOtherStatDto;

  constructor(obj: BattlePracticeCharacterStatBody) {
    this.basicStatObject = new BattlePracticeCharacterBasicStatDto(obj.basic_stat_object);
    this.symbolStatObject = new BattlePracticeCharacterSymbolStatDto(obj.symbol_stat_object);
    this.otherStatObject = new BattlePracticeCharacterOtherStatDto(obj.other_stat_object);
  }
}

/**
 * 연무장 입장 시 캐릭터 스탯 정보
 */
export class BattlePracticeCharacterBasicStatDto {
  /**
   * 현재 스탯 정보
   */
  public finalStat: BattlePracticeCharacterFinalStatDto[];

  constructor(obj: BattlePracticeCharacterBasicStatBody) {
    this.finalStat = obj.final_stat.map((s) => new BattlePracticeCharacterFinalStatDto(s));
  }
}

/**
 * 연무장 입장 시 캐릭터 현재 스탯 정보
 */
export class BattlePracticeCharacterFinalStatDto {
  /**
   * 스탯 명
   */
  public statName: string;

  /**
   * 스탯 값
   */
  public statValue: string;

  constructor(obj: BattlePracticeCharacterFinalStatBody) {
    this.statName = obj.stat_name;
    this.statValue = obj.stat_value;
  }
}

/**
 * 연무장 입장 시 캐릭터 장착 심볼 스탯 정보
 */
export class BattlePracticeCharacterSymbolStatDto {
  /**
   * 심볼 정보
   */
  public symbol: BattlePracticeCharacterSymbolDto[];

  constructor(obj: BattlePracticeCharacterSymbolStatBody) {
    this.symbol = obj.symbol.map((s) => new BattlePracticeCharacterSymbolDto(s));
  }
}

/**
 * 연무장 입장 시 캐릭터 장착 심볼 정보
 */
export class BattlePracticeCharacterSymbolDto {
  /**
   * 심볼 명
   */
  public symbolName: string;

  /**
   * 심볼 아이콘
   */
  public symbolIcon: string;

  /**
   * 심볼 설명
   */
  public symbolDescription: string;

  /**
   * 심볼 부가 효과 설명
   */
  public symbolOtherEffectDescription: string | null;

  /**
   * 심볼로 인한 증가 수치
   */
  public symbolForce: string;

  /**
   * 심볼 레벨
   */
  public symbolLevel: number;

  /**
   * 심볼로 증가한 힘
   */
  public symbolStr: string;

  /**
   * 심볼로 증가한 민첩
   */
  public symbolDex: string;

  /**
   * 심볼로 증가한 지력
   */
  public symbolInt: string;

  /**
   * 심볼로 증가한 운
   */
  public symbolLuk: string;

  /**
   * 심볼로 증가한 체력
   */
  public symbolHp: string;

  /**
   * 심볼로 증가한 아이템 드롭률
   */
  public symbolDropRate: string;

  /**
   * 심볼로 증가한 메소 획득량
   */
  public symbolMesoRate: string;

  /**
   * 심볼로 증가한 경험치 획득량
   */
  public symbolExpRate: string;

  /**
   * 현재 보유 성장치
   */
  public symbolGrowthCount: number;

  /**
   * 성장 시 필요한 성장치
   */
  public symbolRequireGrowthCount: number;

  constructor(obj: BattlePracticeCharacterSymbolBody) {
    this.symbolName = obj.symbol_name;
    this.symbolIcon = obj.symbol_icon;
    this.symbolDescription = obj.symbol_description;
    this.symbolOtherEffectDescription = obj.symbol_other_effect_description;
    this.symbolForce = obj.symbol_force;
    this.symbolLevel = obj.symbol_level;
    this.symbolStr = obj.symbol_str;
    this.symbolDex = obj.symbol_dex;
    this.symbolInt = obj.symbol_int;
    this.symbolLuk = obj.symbol_luk;
    this.symbolHp = obj.symbol_hp;
    this.symbolDropRate = obj.symbol_drop_rate;
    this.symbolMesoRate = obj.symbol_meso_rate;
    this.symbolExpRate = obj.symbol_exp_rate;
    this.symbolGrowthCount = obj.symbol_growth_count;
    this.symbolRequireGrowthCount = obj.symbol_require_growth_count;
  }
}

/**
 * 연무장 입장 시 캐릭터 기타 능력치 영향 요소
 */
export class BattlePracticeCharacterOtherStatDto {
  /**
   * 능력치에 영향을 주는 요소 및 스탯 정보
   */
  public otherStat: BattlePracticeCharacterOtherStatDetailDto[];

  constructor(obj: BattlePracticeCharacterOtherStatBody) {
    this.otherStat = obj.other_stat.map(
      (s) => new BattlePracticeCharacterOtherStatDetailDto(s),
    );
  }
}

/**
 * 연무장 입장 시 캐릭터 능력치에 영향을 주는 요소 및 스탯 정보
 */
export class BattlePracticeCharacterOtherStatDetailDto {
  /**
   * 스탯 타입
   */
  public otherStatType: string;

  /**
   * 스탯 정보
   */
  public statInfo: BattlePracticeCharacterOtherStatInfoDto[];

  constructor(obj: BattlePracticeCharacterOtherStatDetailBody) {
    this.otherStatType = obj.other_stat_type;
    this.statInfo = obj.stat_info.map(
      (s) => new BattlePracticeCharacterOtherStatInfoDto(s),
    );
  }
}

/**
 * 연무장 입장 시 캐릭터 기타 스탯 정보
 */
export class BattlePracticeCharacterOtherStatInfoDto {
  /**
   * 스탯 명
   */
  public statName: string;

  /**
   * 스탯 값
   */
  public statValue: string;

  constructor(obj: BattlePracticeCharacterOtherStatInfoBody) {
    this.statName = obj.stat_name;
    this.statValue = obj.stat_value;
  }
}

/**
 * 연무장 입장 시 캐릭터 하이퍼 스탯 정보
 */
export class BattlePracticeCharacterHyperStatObjectDto {
  /**
   * 하이퍼 스탯 목록
   */
  public hyperStat: BattlePracticeCharacterHyperStatDto[];

  constructor(obj: BattlePracticeCharacterHyperStatObjectBody) {
    this.hyperStat = obj.hyper_stat.map((s) => new BattlePracticeCharacterHyperStatDto(s));
  }
}

/**
 * 연무장 입장 시 캐릭터 하이퍼 스탯 상세 정보
 */
export class BattlePracticeCharacterHyperStatDto {
  /**
   * 스탯 종류
   */
  public statType: string;

  /**
   * 스탯 레벨
   */
  public statLevel: number;

  /**
   * 스탯 상승량
   */
  public statIncrease: string;

  constructor(obj: BattlePracticeCharacterHyperStatBody) {
    this.statType = obj.stat_type;
    this.statLevel = obj.stat_level;
    this.statIncrease = obj.stat_increase;
  }
}

/**
 * 연무장 입장 시 캐릭터 성향 정보
 */
export class BattlePracticeCharacterPropensityDto {
  /**
   * 카리스마 레벨
   */
  public charismaLevel: number;

  /**
   * 감성 레벨
   */
  public sensibilityLevel: number;

  /**
   * 통찰력 레벨
   */
  public insightLevel: number;

  /**
   * 의지 레벨
   */
  public willingnessLevel: number;

  /**
   * 손재주 레벨
   */
  public handicraftLevel: number;

  /**
   * 매력 레벨
   */
  public charmLevel: number;

  constructor(obj: BattlePracticeCharacterPropensityBody) {
    this.charismaLevel = obj.charisma_level;
    this.sensibilityLevel = obj.sensibility_level;
    this.insightLevel = obj.insight_level;
    this.willingnessLevel = obj.willingness_level;
    this.handicraftLevel = obj.handicraft_level;
    this.charmLevel = obj.charm_level;
  }
}

/**
 * 연무장 입장 시 캐릭터 어빌리티 정보
 */
export class BattlePracticeCharacterAbilityObjectDto {
  /**
   * 어빌리티 정보
   */
  public abilityInfo: BattlePracticeCharacterAbilityInfoDto[];

  constructor(obj: BattlePracticeCharacterAbilityObjectBody) {
    this.abilityInfo = obj.ability_info.map(
      (a) => new BattlePracticeCharacterAbilityInfoDto(a),
    );
  }
}

/**
 * 연무장 입장 시 캐릭터 어빌리티 상세 정보
 */
export class BattlePracticeCharacterAbilityInfoDto {
  /**
   * 어빌리티 번호
   */
  public abilityNo: string;

  /**
   * 어빌리티 등급
   */
  public abilityGrade: string;

  /**
   * 어빌리티 옵션 및 수치
   */
  public abilityValue: string;

  constructor(obj: BattlePracticeCharacterAbilityInfoBody) {
    this.abilityNo = obj.ability_no;
    this.abilityGrade = obj.ability_grade;
    this.abilityValue = obj.ability_value;
  }
}

/**
 * 연무장 입장 시 캐릭터 장비(캐시 장비 제외) 정보
 */
export class BattlePracticeCharacterItemObjectDto {
  /**
   * 장착 장비 정보
   */
  public itemEquipmentObject: BattlePracticeCharacterItemEquipmentObjectDto;

  /**
   * 적용 세트 효과 정보
   */
  public setEffectObject: BattlePracticeCharacterSetEffectObjectDto;

  constructor(obj: BattlePracticeCharacterItemObjectBody) {
    this.itemEquipmentObject = new BattlePracticeCharacterItemEquipmentObjectDto(
      obj.item_equipment_object,
    );
    this.setEffectObject = new BattlePracticeCharacterSetEffectObjectDto(
      obj.set_effect_object,
    );
  }
}

/**
 * 연무장 입장 시 캐릭터 장착 장비 정보
 */
export class BattlePracticeCharacterItemEquipmentObjectDto {
  /**
   * 장착 장비 정보
   */
  public itemEquipment: BattlePracticeCharacterItemEquipmentDto[];

  /**
   * 칭호 정보
   */
  public title: BattlePracticeCharacterItemTitleDto | null;

  /**
   * 에반 드래곤 장비 정보 (에반인 경우 응답)
   */
  public dragonEquipment: BattlePracticeCharacterItemDragonEquipmentDto[];

  /**
   * 메카닉 장비 목록 (메카닉인 경우 응답)
   */
  public mechanicEquipment: BattlePracticeCharacterItemMechanicEquipmentDto[];

  constructor(obj: BattlePracticeCharacterItemEquipmentObjectBody) {
    this.itemEquipment = obj.item_equipment.map(
      (i) => new BattlePracticeCharacterItemEquipmentDto(i),
    );
    this.title = obj.title ? new BattlePracticeCharacterItemTitleDto(obj.title) : null;
    this.dragonEquipment = obj.dragon_equipment.map(
      (i) => new BattlePracticeCharacterItemDragonEquipmentDto(i),
    );
    this.mechanicEquipment = obj.mechanic_equipment.map(
      (i) => new BattlePracticeCharacterItemMechanicEquipmentDto(i),
    );
  }
}

/**
 * 연무장 입장 시 캐릭터 장착 장비 정보
 */
export class BattlePracticeCharacterItemEquipmentDto {
  /**
   * 장비 부위 명
   */
  public itemEquipmentPart: string;

  /**
   * 장비 슬롯 위치
   */
  public itemEquipmentSlot: string;

  /**
   * 장비 명
   */
  public itemName: string;

  /**
   * 장비 아이콘
   */
  public itemIcon: string;

  /**
   * 장비 설명
   */
  public itemDescription: string | null;

  /**
   * 장비 외형
   */
  public itemShapeName: string;

  /**
   * 장비 외형 아이콘
   */
  public itemShapeIcon: string;

  /**
   * 전용 성별
   */
  public itemGender: string | null;

  /**
   * 장비 최종 옵션 정보
   */
  public itemTotalOption: BattlePracticeCharacterItemTotalOptionDto;

  /**
   * 장비 기본 옵션 정보
   */
  public itemBaseOption: BattlePracticeCharacterItemBaseOptionDto;

  /**
   * 잠재능력 봉인 여부 (true 봉인, false 봉인 없음)
   */
  public potentialOptionFlag: string | null;

  /**
   * 에디셔널 잠재능력 개방 여부 (true 봉인, false 봉인 없음)
   */
  public additionalPotentialOptionFlag: string | null;

  /**
   * 잠재능력 등급
   */
  public potentialOptionGrade: string | null;

  /**
   * 에디셔널 잠재능력 등급
   */
  public additionalPotentialOptionGrade: string | null;

  /**
   * 잠재능력 첫 번째 옵션
   */
  public potentialOption1: string | null;

  /**
   * 잠재능력 두 번째 옵션
   */
  public potentialOption2: string | null;

  /**
   * 잠재능력 세 번째 옵션
   */
  public potentialOption3: string | null;

  /**
   * 에디셔널 잠재능력 첫 번째 옵션
   */
  public additionalPotentialOption1: string | null;

  /**
   * 에디셔널 잠재능력 두 번째 옵션
   */
  public additionalPotentialOption2: string | null;

  /**
   * 에디셔널 잠재능력 세 번째 옵션
   */
  public additionalPotentialOption3: string | null;

  /**
   * 착용 레벨 증가
   */
  public equipmentLevelIncrease: number;

  /**
   * 장비 특별 옵션 정보
   */
  public itemExceptionalOption: BattlePracticeCharacterItemExceptionalOptionDto;

  /**
   * 장비 추가 옵션 정보
   */
  public itemAddOption: BattlePracticeCharacterItemAddOptionDto;

  /**
   * 성장 경험치
   */
  public growthExp: number;

  /**
   * 성장 레벨
   */
  public growthLevel: number;

  /**
   * 주문서 횟수
   */
  public scrollUpgrade: string;

  /**
   * 가위 사용 가능 횟수 (교환 불가 장비, 가위 횟수가 없는 교환 가능 장비는 255)
   */
  public cuttableCount: string;

  /**
   * 황금 망치 재련 적용 (1:적용, 이외 미 적용)
   */
  public goldenHammerFlag: string;

  /**
   * 복구 가능 횟수
   */
  public scrollResilienceCount: string;

  /**
   * 주문서 잔여 횟수
   */
  public scrollUpgradeAbleCount: string;

  /**
   * 소울 명
   */
  public soulName: string | null;

  /**
   * 소울 옵션
   */
  public soulOption: string | null;

  /**
   * 장비 기타 옵션 정보
   */
  public itemEtcOption: BattlePracticeCharacterItemEtcOptionDto;

  /**
   * 강화 단계
   */
  public starforce: string;

  /**
   * 놀라운 장비 강화 주문서 사용 여부 (0:미사용, 1:사용)
   */
  public starforceScrollFlag: string;

  /**
   * 장비 스타포스 옵션 정보
   */
  public itemStarforceOption: BattlePracticeCharacterItemStarforceOptionDto;

  /**
   * 특수 반지 레벨
   */
  public specialRingLevel: number;

  /**
   * 장비 유효 기간 (KST)
   */
  public dateExpire: Date | null;

  /**
   * 프리스타일 쿠폰 적용 여부 (0:미적용, 1:적용)
   */
  public freestyleFlag: string | null;

  constructor(obj: BattlePracticeCharacterItemEquipmentBody) {
    this.itemEquipmentPart = obj.item_equipment_part;
    this.itemEquipmentSlot = obj.item_equipment_slot;
    this.itemName = obj.item_name;
    this.itemIcon = obj.item_icon;
    this.itemDescription = obj.item_description;
    this.itemShapeName = obj.item_shape_name;
    this.itemShapeIcon = obj.item_shape_icon;
    this.itemGender = obj.item_gender;
    this.itemTotalOption = new BattlePracticeCharacterItemTotalOptionDto(
      obj.item_total_option,
    );
    this.itemBaseOption = new BattlePracticeCharacterItemBaseOptionDto(
      obj.item_base_option,
    );
    this.potentialOptionFlag = obj.potential_option_flag;
    this.additionalPotentialOptionFlag = obj.additional_potential_option_flag;
    this.potentialOptionGrade = obj.potential_option_grade;
    this.additionalPotentialOptionGrade = obj.additional_potential_option_grade;
    this.potentialOption1 = obj.potential_option_1;
    this.potentialOption2 = obj.potential_option_2;
    this.potentialOption3 = obj.potential_option_3;
    this.additionalPotentialOption1 = obj.additional_potential_option_1;
    this.additionalPotentialOption2 = obj.additional_potential_option_2;
    this.additionalPotentialOption3 = obj.additional_potential_option_3;
    this.equipmentLevelIncrease = obj.equipment_level_increase;
    this.itemExceptionalOption =
      new BattlePracticeCharacterItemExceptionalOptionDto(
        obj.item_exceptional_option,
      );
    this.itemAddOption = new BattlePracticeCharacterItemAddOptionDto(
      obj.item_add_option,
    );
    this.growthExp = obj.growth_exp;
    this.growthLevel = obj.growth_level;
    this.scrollUpgrade = obj.scroll_upgrade;
    this.cuttableCount = obj.cuttable_count;
    this.goldenHammerFlag = obj.golden_hammer_flag;
    this.scrollResilienceCount = obj.scroll_resilience_count;
    this.scrollUpgradeAbleCount = obj.scroll_upgrade_able_count;
    this.soulName = obj.soul_name;
    this.soulOption = obj.soul_option;
    this.itemEtcOption = new BattlePracticeCharacterItemEtcOptionDto(
      obj.item_etc_option,
    );
    this.starforce = obj.starforce;
    this.starforceScrollFlag = obj.starforce_scroll_flag;
    this.itemStarforceOption =
      new BattlePracticeCharacterItemStarforceOptionDto(
        obj.item_starforce_option,
      );
    this.specialRingLevel = obj.special_ring_level;
    this.dateExpire = obj.date_expire ? new Date(obj.date_expire) : null;
    this.freestyleFlag = obj.freestyle_flag;
  }
}

/**
 * 연무장 입장 시 캐릭터 에반 드래곤 장비
 */
export class BattlePracticeCharacterItemDragonEquipmentDto {
  /**
   * 장비 부위 명
   */
  public itemEquipmentPart: string;

  /**
   * 장비 슬롯 위치
   */
  public itemEquipmentSlot: string;

  /**
   * 장비 명
   */
  public itemName: string;

  /**
   * 장비 아이콘
   */
  public itemIcon: string;

  /**
   * 장비 설명
   */
  public itemDescription: string | null;

  /**
   * 장비 외형
   */
  public itemShapeName: string;

  /**
   * 장비 외형 아이콘
   */
  public itemShapeIcon: string;

  /**
   * 전용 성별
   */
  public itemGender: string | null;

  /**
   * 장비 최종 옵션 정보
   */
  public itemTotalOption: BattlePracticeCharacterItemTotalOptionDto;

  /**
   * 장비 기본 옵션 정보
   */
  public itemBaseOption: BattlePracticeCharacterItemBaseOptionDto;

  /**
   * 착용 레벨 증가
   */
  public equipmentLevelIncrease: number;

  /**
   * 장비 특별 옵션 정보
   */
  public itemExceptionalOption: BattlePracticeCharacterItemExceptionalOptionDto;

  /**
   * 장비 추가 옵션 정보
   */
  public itemAddOption: BattlePracticeCharacterItemAddOptionDto;

  /**
   * 성장 경험치
   */
  public growthExp: number;

  /**
   * 성장 레벨
   */
  public growthLevel: number;

  /**
   * 주문서 횟수
   */
  public scrollUpgrade: string;

  /**
   * 가위 사용 가능 횟수 (교환 불가 장비, 가위 횟수가 없는 교환 가능 장비는 255)
   */
  public cuttableCount: string;

  /**
   * 황금 망치 재련 적용 (1:적용, 이외 미 적용)
   */
  public goldenHammerFlag: string;

  /**
   * 복구 가능 횟수
   */
  public scrollResilienceCount: string;

  /**
   * 주문서 잔여 횟수
   */
  public scrollUpgradeAbleCount: string;

  /**
   * 소울 명
   */
  public soulName: string | null;

  /**
   * 소울 옵션
   */
  public soulOption: string | null;

  /**
   * 장비 기타 옵션 정보
   */
  public itemEtcOption: BattlePracticeCharacterItemEtcOptionDto;

  /**
   * 강화 단계
   */
  public starforce: string;

  /**
   * 놀라운 장비 강화 주문서 사용 여부 (0:미사용, 1:사용)
   */
  public starforceScrollFlag: string;

  /**
   * 장비 스타포스 옵션 정보
   */
  public itemStarforceOption: BattlePracticeCharacterItemStarforceOptionDto;

  /**
   * 특수 반지 레벨
   */
  public specialRingLevel: number;

  /**
   * 장비 유효 기간 (KST)
   */
  public dateExpire: Date | null;

  /**
   * 프리스타일 쿠폰 적용 여부 (0:미적용, 1:적용)
   */
  public freestyleFlag: string | null;

  constructor(obj: BattlePracticeCharacterItemDragonEquipmentBody) {
    this.itemEquipmentPart = obj.item_equipment_part;
    this.itemEquipmentSlot = obj.item_equipment_slot;
    this.itemName = obj.item_name;
    this.itemIcon = obj.item_icon;
    this.itemDescription = obj.item_description;
    this.itemShapeName = obj.item_shape_name;
    this.itemShapeIcon = obj.item_shape_icon;
    this.itemGender = obj.item_gender;
    this.itemTotalOption = new BattlePracticeCharacterItemTotalOptionDto(
      obj.item_total_option,
    );
    this.itemBaseOption = new BattlePracticeCharacterItemBaseOptionDto(
      obj.item_base_option,
    );
    this.equipmentLevelIncrease = obj.equipment_level_increase;
    this.itemExceptionalOption =
      new BattlePracticeCharacterItemExceptionalOptionDto(
        obj.item_exceptional_option,
      );
    this.itemAddOption = new BattlePracticeCharacterItemAddOptionDto(
      obj.item_add_option,
    );
    this.growthExp = obj.growth_exp;
    this.growthLevel = obj.growth_level;
    this.scrollUpgrade = obj.scroll_upgrade;
    this.cuttableCount = obj.cuttable_count;
    this.goldenHammerFlag = obj.golden_hammer_flag;
    this.scrollResilienceCount = obj.scroll_resilience_count;
    this.scrollUpgradeAbleCount = obj.scroll_upgrade_able_count;
    this.soulName = obj.soul_name;
    this.soulOption = obj.soul_option;
    this.itemEtcOption = new BattlePracticeCharacterItemEtcOptionDto(
      obj.item_etc_option,
    );
    this.starforce = obj.starforce;
    this.starforceScrollFlag = obj.starforce_scroll_flag;
    this.itemStarforceOption =
      new BattlePracticeCharacterItemStarforceOptionDto(
        obj.item_starforce_option,
      );
    this.specialRingLevel = obj.special_ring_level;
    this.dateExpire = obj.date_expire ? new Date(obj.date_expire) : null;
    this.freestyleFlag = obj.freestyle_flag;
  }
}

/**
 * 연무장 입장 시 캐릭터 메카닉 장비
 */
export class BattlePracticeCharacterItemMechanicEquipmentDto {
  /**
   * 장비 부위 명
   */
  public itemEquipmentPart: string;

  /**
   * 장비 슬롯 위치
   */
  public itemEquipmentSlot: string;

  /**
   * 장비 명
   */
  public itemName: string;

  /**
   * 장비 아이콘
   */
  public itemIcon: string;

  /**
   * 장비 설명
   */
  public itemDescription: string | null;

  /**
   * 장비 외형
   */
  public itemShapeName: string;

  /**
   * 장비 외형 아이콘
   */
  public itemShapeIcon: string;

  /**
   * 전용 성별
   */
  public itemGender: string | null;

  /**
   * 장비 최종 옵션 정보
   */
  public itemTotalOption: BattlePracticeCharacterItemTotalOptionDto;

  /**
   * 장비 기본 옵션 정보
   */
  public itemBaseOption: BattlePracticeCharacterItemBaseOptionDto;

  /**
   * 착용 레벨 증가
   */
  public equipmentLevelIncrease: number;

  /**
   * 장비 특별 옵션 정보
   */
  public itemExceptionalOption: BattlePracticeCharacterItemExceptionalOptionDto;

  /**
   * 장비 추가 옵션 정보
   */
  public itemAddOption: BattlePracticeCharacterItemAddOptionDto;

  /**
   * 성장 경험치
   */
  public growthExp: number;

  /**
   * 성장 레벨
   */
  public growthLevel: number;

  /**
   * 주문서 횟수
   */
  public scrollUpgrade: string;

  /**
   * 가위 사용 가능 횟수 (교환 불가 장비, 가위 횟수가 없는 교환 가능 장비는 255)
   */
  public cuttableCount: string;

  /**
   * 황금 망치 재련 적용 (1:적용, 이외 미 적용)
   */
  public goldenHammerFlag: string;

  /**
   * 복구 가능 횟수
   */
  public scrollResilienceCount: string;

  /**
   * 주문서 잔여 횟수
   */
  public scrollUpgradeAbleCount: string;

  /**
   * 소울 명
   */
  public soulName: string | null;

  /**
   * 소울 옵션
   */
  public soulOption: string | null;

  /**
   * 장비 기타 옵션 정보
   */
  public itemEtcOption: BattlePracticeCharacterItemEtcOptionDto;

  /**
   * 강화 단계
   */
  public starforce: string;

  /**
   * 놀라운 장비 강화 주문서 사용 여부 (0:미사용, 1:사용)
   */
  public starforceScrollFlag: string;

  /**
   * 장비 스타포스 옵션 정보
   */
  public itemStarforceOption: BattlePracticeCharacterItemStarforceOptionDto;

  /**
   * 특수 반지 레벨
   */
  public specialRingLevel: number;

  /**
   * 장비 유효 기간 (KST)
   */
  public dateExpire: Date | null;

  /**
   * 프리스타일 쿠폰 적용 여부 (0:미적용, 1:적용)
   */
  public freestyleFlag: string | null;

  constructor(obj: BattlePracticeCharacterItemMechanicEquipmentBody) {
    this.itemEquipmentPart = obj.item_equipment_part;
    this.itemEquipmentSlot = obj.item_equipment_slot;
    this.itemName = obj.item_name;
    this.itemIcon = obj.item_icon;
    this.itemDescription = obj.item_description;
    this.itemShapeName = obj.item_shape_name;
    this.itemShapeIcon = obj.item_shape_icon;
    this.itemGender = obj.item_gender;
    this.itemTotalOption = new BattlePracticeCharacterItemTotalOptionDto(
      obj.item_total_option,
    );
    this.itemBaseOption = new BattlePracticeCharacterItemBaseOptionDto(
      obj.item_base_option,
    );
    this.equipmentLevelIncrease = obj.equipment_level_increase;
    this.itemExceptionalOption =
      new BattlePracticeCharacterItemExceptionalOptionDto(
        obj.item_exceptional_option,
      );
    this.itemAddOption = new BattlePracticeCharacterItemAddOptionDto(
      obj.item_add_option,
    );
    this.growthExp = obj.growth_exp;
    this.growthLevel = obj.growth_level;
    this.scrollUpgrade = obj.scroll_upgrade;
    this.cuttableCount = obj.cuttable_count;
    this.goldenHammerFlag = obj.golden_hammer_flag;
    this.scrollResilienceCount = obj.scroll_resilience_count;
    this.scrollUpgradeAbleCount = obj.scroll_upgrade_able_count;
    this.soulName = obj.soul_name;
    this.soulOption = obj.soul_option;
    this.itemEtcOption = new BattlePracticeCharacterItemEtcOptionDto(
      obj.item_etc_option,
    );
    this.starforce = obj.starforce;
    this.starforceScrollFlag = obj.starforce_scroll_flag;
    this.itemStarforceOption =
      new BattlePracticeCharacterItemStarforceOptionDto(
        obj.item_starforce_option,
      );
    this.specialRingLevel = obj.special_ring_level;
    this.dateExpire = obj.date_expire ? new Date(obj.date_expire) : null;
    this.freestyleFlag = obj.freestyle_flag;
  }
}

/**
 * 연무장 입장 시 캐릭터 장비 최종 옵션 정보
 */
export class BattlePracticeCharacterItemTotalOptionDto {
  /**
   * STR
   */
  public str: string;

  /**
   * DEX
   */
  public dex: string;

  /**
   * INT
   */
  public int: string;

  /**
   * LUK
   */
  public luk: string;

  /**
   * 최대 HP
   */
  public maxHp: string;

  /**
   * 최대 MP
   */
  public maxMp: string;

  /**
   * 공격력
   */
  public attackPower: string;

  /**
   * 마력
   */
  public magicPower: string;

  /**
   * 방어력
   */
  public armor: string;

  /**
   * 이동속도
   */
  public speed: string;

  /**
   * 점프력
   */
  public jump: string;

  /**
   * 보스 몬스터 데미지 증가 (%)
   */
  public bossDamage: string;

  /**
   * 몬스터 방어율 무시 (%)
   */
  public ignoreMonsterArmor: string;

  /**
   * 올스탯 (%)
   */
  public allStat: string;

  /**
   * 데미지 (%)
   */
  public damage: string;

  /**
   * 착용 레벨 감소
   */
  public equipmentLevelDecrease: number;

  /**
   * 최대 HP (%)
   */
  public maxHpRate: string;

  /**
   * 최대 MP (%)
   */
  public maxMpRate: string;

  constructor(obj: BattlePracticeCharacterItemTotalOptionBody) {
    this.str = obj.str;
    this.dex = obj.dex;
    this.int = obj.int;
    this.luk = obj.luk;
    this.maxHp = obj.max_hp;
    this.maxMp = obj.max_mp;
    this.attackPower = obj.attack_power;
    this.magicPower = obj.magic_power;
    this.armor = obj.armor;
    this.speed = obj.speed;
    this.jump = obj.jump;
    this.bossDamage = obj.boss_damage;
    this.ignoreMonsterArmor = obj.ignore_monster_armor;
    this.allStat = obj.all_stat;
    this.damage = obj.damage;
    this.equipmentLevelDecrease = obj.equipment_level_decrease;
    this.maxHpRate = obj.max_hp_rate;
    this.maxMpRate = obj.max_mp_rate;
  }
}

/**
 * 연무장 입장 시 캐릭터 장비 기본 옵션 정보
 */
export class BattlePracticeCharacterItemBaseOptionDto {
  /**
   * STR
   */
  public str: string;

  /**
   * DEX
   */
  public dex: string;

  /**
   * INT
   */
  public int: string;

  /**
   * LUK
   */
  public luk: string;

  /**
   * 최대 HP
   */
  public maxHp: string;

  /**
   * 최대 MP
   */
  public maxMp: string;

  /**
   * 공격력
   */
  public attackPower: string;

  /**
   * 마력
   */
  public magicPower: string;

  /**
   * 방어력
   */
  public armor: string;

  /**
   * 이동속도
   */
  public speed: string;

  /**
   * 점프력
   */
  public jump: string;

  /**
   * 보스 몬스터 데미지 증가 (%)
   */
  public bossDamage: string;

  /**
   * 몬스터 방어율 무시 (%)
   */
  public ignoreMonsterArmor: string;

  /**
   * 올스탯 (%)
   */
  public allStat: string;

  /**
   * 최대 HP
   */
  public maxHpRate: string;

  /**
   * 최대 MP
   */
  public maxMpRate: string;

  /**
   * 기본 착용 레벨
   */
  public baseEquipmentLevel: number;

  constructor(obj: BattlePracticeCharacterItemBaseOptionBody) {
    this.str = obj.str;
    this.dex = obj.dex;
    this.int = obj.int;
    this.luk = obj.luk;
    this.maxHp = obj.max_hp;
    this.maxMp = obj.max_mp;
    this.attackPower = obj.attack_power;
    this.magicPower = obj.magic_power;
    this.armor = obj.armor;
    this.speed = obj.speed;
    this.jump = obj.jump;
    this.bossDamage = obj.boss_damage;
    this.ignoreMonsterArmor = obj.ignore_monster_armor;
    this.allStat = obj.all_stat;
    this.maxHpRate = obj.max_hp_rate;
    this.maxMpRate = obj.max_mp_rate;
    this.baseEquipmentLevel = obj.base_equipment_level;
  }
}

/**
 * 연무장 입장 시 캐릭터 장비 특별 옵션 정보
 */
export class BattlePracticeCharacterItemExceptionalOptionDto {
  /**
   * STR
   */
  public str: string;

  /**
   * DEX
   */
  public dex: string;

  /**
   * INT
   */
  public int: string;

  /**
   * LUK
   */
  public luk: string;

  /**
   * 최대 HP
   */
  public maxHp: string;

  /**
   * 최대 MP
   */
  public maxMp: string;

  /**
   * 공격력
   */
  public attackPower: string;

  /**
   * 마력
   */
  public magicPower: string;

  /**
   * 익셉서녈 강화 적용 횟수
   */
  public exceptionalUpgrade: number;

  constructor(obj: BattlePracticeCharacterItemExceptionalOptionBody) {
    this.str = obj.str;
    this.dex = obj.dex;
    this.int = obj.int;
    this.luk = obj.luk;
    this.maxHp = obj.max_hp;
    this.maxMp = obj.max_mp;
    this.attackPower = obj.attack_power;
    this.magicPower = obj.magic_power;
    this.exceptionalUpgrade = obj.exceptional_upgrade;
  }
}

/**
 * 연무장 입장 시 캐릭터 장비 추가 옵션 정보
 */
export class BattlePracticeCharacterItemAddOptionDto {
  /**
   * STR
   */
  public str: string;

  /**
   * DEX
   */
  public dex: string;

  /**
   * INT
   */
  public int: string;

  /**
   * LUK
   */
  public luk: string;

  /**
   * 최대 HP
   */
  public maxHp: string;

  /**
   * 최대 MP
   */
  public maxMp: string;

  /**
   * 공격력
   */
  public attackPower: string;

  /**
   * 마력
   */
  public magicPower: string;

  /**
   * 방어력
   */
  public armor: string;

  /**
   * 이동속도
   */
  public speed: string;

  /**
   * 점프력
   */
  public jump: string;

  /**
   * 보스 몬스터 데미지 증가 (%)
   */
  public bossDamage: string;

  /**
   * 데미지 (%)
   */
  public damage: string;

  /**
   * 올스탯 (%)
   */
  public allStat: string;

  /**
   * 착용 레벨 감소
   */
  public equipmentLevelDecrease: number;

  constructor(obj: BattlePracticeCharacterItemAddOptionBody) {
    this.str = obj.str;
    this.dex = obj.dex;
    this.int = obj.int;
    this.luk = obj.luk;
    this.maxHp = obj.max_hp;
    this.maxMp = obj.max_mp;
    this.attackPower = obj.attack_power;
    this.magicPower = obj.magic_power;
    this.armor = obj.armor;
    this.speed = obj.speed;
    this.jump = obj.jump;
    this.bossDamage = obj.boss_damage;
    this.damage = obj.damage;
    this.allStat = obj.all_stat;
    this.equipmentLevelDecrease = obj.equipment_level_decrease;
  }
}

/**
 * 연무장 입장 시 캐릭터 장비 기타 옵션 정보
 */
export class BattlePracticeCharacterItemEtcOptionDto {
  /**
   * STR
   */
  public str: string;

  /**
   * DEX
   */
  public dex: string;

  /**
   * INT
   */
  public int: string;

  /**
   * LUK
   */
  public luk: string;

  /**
   * 최대 HP
   */
  public maxHp: string;

  /**
   * 최대 MP
   */
  public maxMp: string;

  /**
   * 공격력
   */
  public attackPower: string;

  /**
   * 마력
   */
  public magicPower: string;

  /**
   * 방어력
   */
  public armor: string;

  /**
   * 이동속도
   */
  public speed: string;

  /**
   * 점프력
   */
  public jump: string;

  constructor(obj: BattlePracticeCharacterItemEtcOptionBody) {
    this.str = obj.str;
    this.dex = obj.dex;
    this.int = obj.int;
    this.luk = obj.luk;
    this.maxHp = obj.max_hp;
    this.maxMp = obj.max_mp;
    this.attackPower = obj.attack_power;
    this.magicPower = obj.magic_power;
    this.armor = obj.armor;
    this.speed = obj.speed;
    this.jump = obj.jump;
  }
}

/**
 * 연무장 입장 시 캐릭터 장비 스타포스 옵션 정보
 */
export class BattlePracticeCharacterItemStarforceOptionDto {
  /**
   * STR
   */
  public str: string;

  /**
   * DEX
   */
  public dex: string;

  /**
   * INT
   */
  public int: string;

  /**
   * LUK
   */
  public luk: string;

  /**
   * 최대 HP
   */
  public maxHp: string;

  /**
   * 최대 MP
   */
  public maxMp: string;

  /**
   * 공격력
   */
  public attackPower: string;

  /**
   * 마력
   */
  public magicPower: string;

  /**
   * 방어력
   */
  public armor: string;

  /**
   * 이동속도
   */
  public speed: string;

  /**
   * 점프력
   */
  public jump: string;

  constructor(obj: BattlePracticeCharacterItemStarforceOptionBody) {
    this.str = obj.str;
    this.dex = obj.dex;
    this.int = obj.int;
    this.luk = obj.luk;
    this.maxHp = obj.max_hp;
    this.maxMp = obj.max_mp;
    this.attackPower = obj.attack_power;
    this.magicPower = obj.magic_power;
    this.armor = obj.armor;
    this.speed = obj.speed;
    this.jump = obj.jump;
  }
}

/**
 * 연무장 입장 시 캐릭터 칭호 정보
 */
export class BattlePracticeCharacterItemTitleDto {
  /**
   * 칭호 장비 명
   */
  public titleName: string;

  /**
   * 칭호 아이콘
   */
  public titleIcon: string;

  /**
   * 칭호 설명
   */
  public titleDescription: string;

  /**
   * 칭호 유효 기간 (KST)
   */
  public dateExpire: Date | null;

  /**
   * 칭호 옵션 유효 기간 (expired:만료, null:무제한) (KST)
   */
  public dateOptionExpire: Date | null;

  /**
   * 외형 설정에 등록한 칭호 장비 명
   */
  public titleShapeName: string | null;

  /**
   * 외형 설정에 등록한 칭호 아이콘
   */
  public titleShapeIcon: string | null;

  /**
   * 외형 설정에 등록한 칭호 설명
   */
  public titleShapeDescription: string | null;

  constructor(obj: BattlePracticeCharacterItemTitleBody) {
    this.titleName = obj.title_name;
    this.titleIcon = obj.title_icon;
    this.titleDescription = obj.title_description;
    this.dateExpire = obj.date_expire ? new Date(obj.date_expire) : null;
    this.dateOptionExpire = obj.date_option_expire
      ? new Date(obj.date_option_expire)
      : null;
    this.titleShapeName = obj.title_shape_name;
    this.titleShapeIcon = obj.title_shape_icon;
    this.titleShapeDescription = obj.title_shape_description;
  }
}

/**
 * 연무장 입장 시 캐릭터 적용 세트 효과 정보
 */
export class BattlePracticeCharacterSetEffectObjectDto {
  /**
   * 세트 효과 정보
   */
  public setEffect: BattlePracticeCharacterSetEffectDto[];

  constructor(obj: BattlePracticeCharacterSetEffectObjectBody) {
    this.setEffect = obj.set_effect.map((s) => new BattlePracticeCharacterSetEffectDto(s));
  }
}

/**
 * 연무장 입장 시 캐릭터 세트 효과 정보
 */
export class BattlePracticeCharacterSetEffectDto {
  /**
   * 세트 효과 명
   */
  public setName: string;

  /**
   * 세트 개수 (럭키 아이템 포함)
   */
  public totalSetCount: number;

  /**
   * 적용 중인 세트 효과 정보
   */
  public setEffectInfo: BattlePracticeCharacterSetEffectInfoDto[];

  constructor(obj: BattlePracticeCharacterSetEffectBody) {
    this.setName = obj.set_name;
    this.totalSetCount = obj.total_set_count;
    this.setEffectInfo = obj.set_effect_info.map(
      (s) => new BattlePracticeCharacterSetEffectInfoDto(s),
    );
  }
}

/**
 * 연무장 입장 시 캐릭터 적용 중인 세트 효과 정보
 */
export class BattlePracticeCharacterSetEffectInfoDto {
  /**
   * 세트 효과 레벨 (장비 수)
   */
  public setCount: number;

  /**
   * 세트 효과
   */
  public setOption: string;

  constructor(obj: BattlePracticeCharacterSetEffectInfoBody) {
    this.setCount = obj.set_count;
    this.setOption = obj.set_option;
  }
}

/**
 * 연무장 입장 시 캐릭터 캐시 장비 정보
 */
export class BattlePracticeCharacterCashItemObjectDto {
  /**
   * 장착 중인 캐시 장비
   */
  public cashItemEquipmentBase: BattlePracticeCharacterCashItemEquipmentDto[];

  /**
   * 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드에서 장착 중인 캐시 장비
   */
  public additionalCashItemEquipmentBase: BattlePracticeCharacterCashItemEquipmentDto[];

  constructor(obj: BattlePracticeCharacterCashItemObjectBody) {
    this.cashItemEquipmentBase = obj.cash_item_equipment_base.map(
      (i) => new BattlePracticeCharacterCashItemEquipmentDto(i),
    );
    this.additionalCashItemEquipmentBase =
      obj.additional_cash_item_equipment_base.map(
        (i) => new BattlePracticeCharacterCashItemEquipmentDto(i),
      );
  }
}

/**
 * 연무장 입장 시 캐릭터 장착 캐시 장비 정보
 */
export class BattlePracticeCharacterCashItemEquipmentDto {
  /**
   * 캐시 장비 부위 명
   */
  public cashItemEquipmentPart: string;

  /**
   * 캐시 장비 슬롯 위치
   */
  public cashItemEquipmentSlot: string;

  /**
   * 캐시 장비 명
   */
  public cashItemName: string;

  /**
   * 캐시 장비 아이콘
   */
  public cashItemIcon: string;

  /**
   * 캐시 장비 설명
   */
  public cashItemDescription: string | null;

  /**
   * 캐시 장비 옵션 목록
   */
  public cashItemOption: BattlePracticeCharacterCashItemOptionDto[];

  /**
   * 캐시 장비 유효 기간 (KST)
   */
  public dateExpire: Date | null;

  /**
   * 캐시 장비 옵션 유효 기간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
   */
  public dateOptionExpire: Date | null;

  constructor(obj: BattlePracticeCharacterCashItemEquipmentBody) {
    this.cashItemEquipmentPart = obj.cash_item_equipment_part;
    this.cashItemEquipmentSlot = obj.cash_item_equipment_slot;
    this.cashItemName = obj.cash_item_name;
    this.cashItemIcon = obj.cash_item_icon;
    this.cashItemDescription = obj.cash_item_description;
    this.cashItemOption = obj.cash_item_option.map(
      (o) => new BattlePracticeCharacterCashItemOptionDto(o),
    );
    this.dateExpire = obj.date_expire ? new Date(obj.date_expire) : null;
    this.dateOptionExpire = obj.date_option_expire
      ? new Date(obj.date_option_expire)
      : null;
  }
}

/**
 * 연무장 입장 시 캐릭터 캐시 장비 옵션
 */
export class BattlePracticeCharacterCashItemOptionDto {
  /**
   * 옵션 타입
   */
  public optionType: string;

  /**
   * 옵션 값
   */
  public optionValue: string;

  constructor(obj: BattlePracticeCharacterCashItemOptionBody) {
    this.optionType = obj.option_type;
    this.optionValue = obj.option_value;
  }
}

/**
 * 연무장 입장 시 캐릭터 장착 펫 정보
 */
export class BattlePracticeCharacterPetObjectDto {
  /**
   * 활성화된 펫 유형 (0:캐릭터 펫, 1:월드 공유 펫)
   */
  public petActivateFlag: string | null;

  /**
   * 펫1 명
   */
  public pet1Name: string | null;

  /**
   * 펫1 닉네임
   */
  public pet1Nickname: string | null;

  /**
   * 펫1 아이콘
   */
  public pet1Icon: string | null;

  /**
   * 펫1 설명
   */
  public pet1Description: string | null;

  /**
   * 펫1 장착 정보
   */
  public pet1Equipment: BattlePracticeCharacterPetEquipmentDto | null;

  /**
   * 펫1 버프 자동스킬 정보
   */
  public pet1AutoSkill: BattlePracticeCharacterPetAutoSkillDto | null;

  /**
   * 펫1 원더 펫 종류
   */
  public pet1PetType: string | null;

  /**
   * 펫1 펫 보유 스킬
   */
  public pet1Skill: string[];

  /**
   * 펫1 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
   */
  public pet1DateExpire: Date | null;

  /**
   * 펫2 명
   */
  public pet2Name: string | null;

  /**
   * 펫2 닉네임
   */
  public pet2Nickname: string | null;

  /**
   * 펫2 아이콘
   */
  public pet2Icon: string | null;

  /**
   * 펫2 설명
   */
  public pet2Description: string | null;

  /**
   * 펫2 장착 정보
   */
  public pet2Equipment: BattlePracticeCharacterPetEquipmentDto | null;

  /**
   * 펫2 버프 자동스킬 정보
   */
  public pet2AutoSkill: BattlePracticeCharacterPetAutoSkillDto | null;

  /**
   * 펫2 원더 펫 종류
   */
  public pet2PetType: string | null;

  /**
   * 펫2 펫 보유 스킬
   */
  public pet2Skill: string[];

  /**
   * 펫2 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
   */
  public pet2DateExpire: Date | null;

  /**
   * 펫3 명
   */
  public pet3Name: string | null;

  /**
   * 펫3 닉네임
   */
  public pet3Nickname: string | null;

  /**
   * 펫3 아이콘
   */
  public pet3Icon: string | null;

  /**
   * 펫3 설명
   */
  public pet3Description: string | null;

  /**
   * 펫3 장착 정보
   */
  public pet3Equipment: BattlePracticeCharacterPetEquipmentDto | null;

  /**
   * 펫3 버프 자동스킬 정보
   */
  public pet3AutoSkill: BattlePracticeCharacterPetAutoSkillDto | null;

  /**
   * 펫3 원더 펫 종류
   */
  public pet3PetType: string | null;

  /**
   * 펫3 펫 보유 스킬
   */
  public pet3Skill: string[];

  /**
   * 펫3 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
   */
  public pet3DateExpire: Date | null;

  /**
   * 월드 공유 펫1 명
   */
  public worldSharePet1Name: string | null;

  /**
   * 월드 공유 펫1 닉네임
   */
  public worldSharePet1Nickname: string | null;

  /**
   * 월드 공유 펫1 아이콘
   */
  public worldSharePet1Icon: string | null;

  /**
   * 월드 공유 펫1 설명
   */
  public worldSharePet1Description: string | null;

  /**
   * 월드 공유 펫1 원더 펫 종류
   */
  public worldSharePet1PetType: string | null;

  /**
   * 월드 공유 펫1 장착 정보
   */
  public worldSharePet1Equipment: BattlePracticeCharacterPetEquipmentDto | null;

  /**
   * 월드 공유 펫1 버프 자동스킬 정보
   */
  public worldSharePet1AutoSkill: BattlePracticeCharacterPetAutoSkillDto | null;

  /**
   * 월드 공유 펫1 펫 보유 스킬
   */
  public worldSharePet1Skill: string[];

  /**
   * 월드 공유 펫1 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
   */
  public worldSharePet1DateExpire: Date | null;

  /**
   * 월드 공유 펫2 명
   */
  public worldSharePet2Name: string | null;

  /**
   * 월드 공유 펫2 닉네임
   */
  public worldSharePet2Nickname: string | null;

  /**
   * 월드 공유 펫2 아이콘
   */
  public worldSharePet2Icon: string | null;

  /**
   * 월드 공유 펫2 설명
   */
  public worldSharePet2Description: string | null;

  /**
   * 월드 공유 펫2 원더 펫 종류
   */
  public worldSharePet2PetType: string | null;

  /**
   * 월드 공유 펫2 장착 정보
   */
  public worldSharePet2Equipment: BattlePracticeCharacterPetEquipmentDto | null;

  /**
   * 월드 공유 펫2 버프 자동스킬 정보
   */
  public worldSharePet2AutoSkill: BattlePracticeCharacterPetAutoSkillDto | null;

  /**
   * 월드 공유 펫2 펫 보유 스킬
   */
  public worldSharePet2Skill: string[];

  /**
   * 월드 공유 펫2 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
   */
  public worldSharePet2DateExpire: Date | null;

  /**
   * 월드 공유 펫3 명
   */
  public worldSharePet3Name: string | null;

  /**
   * 월드 공유 펫3 닉네임
   */
  public worldSharePet3Nickname: string | null;

  /**
   * 월드 공유 펫3 아이콘
   */
  public worldSharePet3Icon: string | null;

  /**
   * 월드 공유 펫3 설명
   */
  public worldSharePet3Description: string | null;

  /**
   * 월드 공유 펫3 원더 펫 종류
   */
  public worldSharePet3PetType: string | null;

  /**
   * 월드 공유 펫3 장착 정보
   */
  public worldSharePet3Equipment: BattlePracticeCharacterPetEquipmentDto | null;

  /**
   * 월드 공유 펫3 버프 자동스킬 정보
   */
  public worldSharePet3AutoSkill: BattlePracticeCharacterPetAutoSkillDto | null;

  /**
   * 월드 공유 펫3 펫 보유 스킬
   */
  public worldSharePet3Skill: string[];

  /**
   * 월드 공유 펫3 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
   */
  public worldSharePet3DateExpire: Date | null;

  /**
   * 루나 쁘띠 펫 스킬 정보
   */
  public petiteLunaPetSkill: BattlePracticeCharacterPetiteLunaPetSkillDto[];

  constructor(obj: BattlePracticeCharacterPetObjectBody) {
    this.petActivateFlag = obj.pet_activate_flag ?? null;
    this.pet1Name = obj.pet_1_name;
    this.pet1Nickname = obj.pet_1_nickname;
    this.pet1Icon = obj.pet_1_icon;
    this.pet1Description = obj.pet_1_description;
    this.pet1Equipment = obj.pet_1_equipment
      ? new BattlePracticeCharacterPetEquipmentDto(obj.pet_1_equipment)
      : null;
    this.pet1AutoSkill = obj.pet_1_auto_skill
      ? new BattlePracticeCharacterPetAutoSkillDto(obj.pet_1_auto_skill)
      : null;
    this.pet1PetType = obj.pet_1_pet_type;
    this.pet1Skill = obj.pet_1_skill;
    this.pet1DateExpire = obj.pet_1_date_expire
      ? new Date(obj.pet_1_date_expire)
      : null;
    this.pet2Name = obj.pet_2_name;
    this.pet2Nickname = obj.pet_2_nickname;
    this.pet2Icon = obj.pet_2_icon;
    this.pet2Description = obj.pet_2_description;
    this.pet2Equipment = obj.pet_2_equipment
      ? new BattlePracticeCharacterPetEquipmentDto(obj.pet_2_equipment)
      : null;
    this.pet2AutoSkill = obj.pet_2_auto_skill
      ? new BattlePracticeCharacterPetAutoSkillDto(obj.pet_2_auto_skill)
      : null;
    this.pet2PetType = obj.pet_2_pet_type;
    this.pet2Skill = obj.pet_2_skill;
    this.pet2DateExpire = obj.pet_2_date_expire
      ? new Date(obj.pet_2_date_expire)
      : null;
    this.pet3Name = obj.pet_3_name;
    this.pet3Nickname = obj.pet_3_nickname;
    this.pet3Icon = obj.pet_3_icon;
    this.pet3Description = obj.pet_3_description;
    this.pet3Equipment = obj.pet_3_equipment
      ? new BattlePracticeCharacterPetEquipmentDto(obj.pet_3_equipment)
      : null;
    this.pet3AutoSkill = obj.pet_3_auto_skill
      ? new BattlePracticeCharacterPetAutoSkillDto(obj.pet_3_auto_skill)
      : null;
    this.pet3PetType = obj.pet_3_pet_type;
    this.pet3Skill = obj.pet_3_skill;
    this.pet3DateExpire = obj.pet_3_date_expire
      ? new Date(obj.pet_3_date_expire)
      : null;
    this.worldSharePet1Name = obj.world_share_pet_1_name ?? null;
    this.worldSharePet1Nickname = obj.world_share_pet_1_nickname ?? null;
    this.worldSharePet1Icon = obj.world_share_pet_1_icon ?? null;
    this.worldSharePet1Description = obj.world_share_pet_1_description ?? null;
    this.worldSharePet1PetType = obj.world_share_pet_1_pet_type ?? null;
    this.worldSharePet1Equipment = obj.world_share_pet_1_equipment
      ? new BattlePracticeCharacterPetEquipmentDto(obj.world_share_pet_1_equipment)
      : null;
    this.worldSharePet1AutoSkill = obj.world_share_pet_1_auto_skill
      ? new BattlePracticeCharacterPetAutoSkillDto(obj.world_share_pet_1_auto_skill)
      : null;
    this.worldSharePet1Skill = obj.world_share_pet_1_skill ?? [];
    this.worldSharePet1DateExpire = obj.world_share_pet_1_date_expire
      ? new Date(obj.world_share_pet_1_date_expire)
      : null;
    this.worldSharePet2Name = obj.world_share_pet_2_name ?? null;
    this.worldSharePet2Nickname = obj.world_share_pet_2_nickname ?? null;
    this.worldSharePet2Icon = obj.world_share_pet_2_icon ?? null;
    this.worldSharePet2Description = obj.world_share_pet_2_description ?? null;
    this.worldSharePet2PetType = obj.world_share_pet_2_pet_type ?? null;
    this.worldSharePet2Equipment = obj.world_share_pet_2_equipment
      ? new BattlePracticeCharacterPetEquipmentDto(obj.world_share_pet_2_equipment)
      : null;
    this.worldSharePet2AutoSkill = obj.world_share_pet_2_auto_skill
      ? new BattlePracticeCharacterPetAutoSkillDto(obj.world_share_pet_2_auto_skill)
      : null;
    this.worldSharePet2Skill = obj.world_share_pet_2_skill ?? [];
    this.worldSharePet2DateExpire = obj.world_share_pet_2_date_expire
      ? new Date(obj.world_share_pet_2_date_expire)
      : null;
    this.worldSharePet3Name = obj.world_share_pet_3_name ?? null;
    this.worldSharePet3Nickname = obj.world_share_pet_3_nickname ?? null;
    this.worldSharePet3Icon = obj.world_share_pet_3_icon ?? null;
    this.worldSharePet3Description = obj.world_share_pet_3_description ?? null;
    this.worldSharePet3PetType = obj.world_share_pet_3_pet_type ?? null;
    this.worldSharePet3Equipment = obj.world_share_pet_3_equipment
      ? new BattlePracticeCharacterPetEquipmentDto(obj.world_share_pet_3_equipment)
      : null;
    this.worldSharePet3AutoSkill = obj.world_share_pet_3_auto_skill
      ? new BattlePracticeCharacterPetAutoSkillDto(obj.world_share_pet_3_auto_skill)
      : null;
    this.worldSharePet3Skill = obj.world_share_pet_3_skill ?? [];
    this.worldSharePet3DateExpire = obj.world_share_pet_3_date_expire
      ? new Date(obj.world_share_pet_3_date_expire)
      : null;
    this.petiteLunaPetSkill = (obj.petite_luna_pet_skill ?? []).map(
      (s) => new BattlePracticeCharacterPetiteLunaPetSkillDto(s),
    );
  }
}

/**
 * 연무장 입장 시 캐릭터 펫 장착 정보
 */
export class BattlePracticeCharacterPetEquipmentDto {
  /**
   * 아이템 명
   */
  public itemName: string;

  /**
   * 아이템 아이콘
   */
  public itemIcon: string;

  /**
   * 아이템 설명
   */
  public itemDescription: string | null;

  /**
   * 아이템의 표기상 옵션
   */
  public itemOption: BattlePracticeCharacterPetEquipmentItemOptionDto[];

  /**
   * 주문서 횟수
   */
  public scrollUpgrade: number;

  /**
   * 주문서 잔여 횟수
   */
  public scrollUpgradable: number;

  /**
   * 아이템 외형
   */
  public itemShape: string | null;

  /**
   * 아이템 외형 아이콘
   */
  public itemShapeIcon: string | null;

  /**
   * 아이템 만료 시간
   */
  public itemDateExpire: Date | null;

  constructor(obj: BattlePracticeCharacterPetEquipmentBody) {
    this.itemName = obj.item_name;
    this.itemIcon = obj.item_icon;
    this.itemDescription = obj.item_description;
    this.itemOption = obj.item_option.map(
      (o) => new BattlePracticeCharacterPetEquipmentItemOptionDto(o),
    );
    this.scrollUpgrade = obj.scroll_upgrade;
    this.scrollUpgradable = obj.scroll_upgradable;
    this.itemShape = obj.item_shape;
    this.itemShapeIcon = obj.item_shape_icon;
    this.itemDateExpire = obj.item_date_expire
      ? new Date(obj.item_date_expire)
      : null;
  }
}

/**
 * 연무장 입장 시 캐릭터 펫 장비 옵션
 */
export class BattlePracticeCharacterPetEquipmentItemOptionDto {
  /**
   * 옵션 타입
   */
  public optionType: string;

  /**
   * 옵션 값
   */
  public optionValue: string;

  constructor(obj: BattlePracticeCharacterPetEquipmentOptionBody) {
    this.optionType = obj.option_type;
    this.optionValue = obj.option_value;
  }
}

/**
 * 연무장 입장 시 캐릭터 펫 자동스킬 정보
 */
export class BattlePracticeCharacterPetAutoSkillDto {
  /**
   * 첫 번째 슬롯에 등록된 자동 스킬 명
   */
  public skill1: string | null;

  /**
   * 첫 번째 슬롯에 등록된 자동 스킬 아이콘
   */
  public skill1Icon: string | null;

  /**
   * 두 번째 슬롯에 등록된 자동 스킬 명
   */
  public skill2: string | null;

  /**
   * 두 번째 슬롯에 등록된 자동 스킬 아이콘
   */
  public skill2Icon: string | null;

  constructor(obj: BattlePracticeCharacterPetAutoSkillBody) {
    this.skill1 = obj.skill_1;
    this.skill1Icon = obj.skill_1_icon;
    this.skill2 = obj.skill_2;
    this.skill2Icon = obj.skill_2_icon;
  }
}

/**
 * 연무장 입장 시 루나 쁘띠 펫 스킬 정보
 */
export class BattlePracticeCharacterPetiteLunaPetSkillDto {
  /**
   * 스킬 명
   */
  public skillName: string | null;

  /**
   * 스킬 설명
   */
  public skillDescription: string | null;

  /**
   * 스킬 효과 설명
   */
  public skillEffect: string | null;

  /**
   * 스킬 아이콘
   */
  public skillIcon: string | null;

  constructor(obj: BattlePracticeCharacterPetiteLunaPetSkillBody) {
    this.skillName = obj.skill_name;
    this.skillDescription = obj.skill_description;
    this.skillEffect = obj.skill_effect;
    this.skillIcon = obj.skill_icon;
  }
}

/**
 * 연무장 입장 시 캐릭터 캐릭터 스킬 정보
 */
export class BattlePracticeCharacterSkillObjectDto {
  /**
   * 스킬 정보
   */
  public characterSkill: BattlePracticeCharacterSkillInfoDto[];

  constructor(obj: BattlePracticeCharacterSkillObjectBody) {
    this.characterSkill = obj.character_skill.map(
      (s) => new BattlePracticeCharacterSkillInfoDto(s),
    );
  }
}

/**
 * 연무장 입장 시 캐릭터 스킬 정보
 */
export class BattlePracticeCharacterSkillInfoDto {
  /**
   * 스킬 명
   */
  public skillName: string;

  /**
   * 스킬 설명
   */
  public skillDescription: string;

  /**
   * 스킬 레벨
   */
  public skillLevel: number;

  /**
   * 스킬 효과
   */
  public skillEffect: string | null;

  /**
   * 스킬 아이콘
   */
  public skillIcon: string;

  constructor(obj: BattlePracticeCharacterSkillInfoBody) {
    this.skillName = obj.skill_name;
    this.skillDescription = obj.skill_description;
    this.skillLevel = obj.skill_level;
    this.skillEffect = obj.skill_effect;
    this.skillIcon = obj.skill_icon;
  }
}

/**
 * 연무장 입장 시 캐릭터 링크 스킬 정보
 */
export class BattlePracticeCharacterLinkSkillObjectDto {
  /**
   * 링크 스킬 정보
   */
  public characterLinkSkill: BattlePracticeCharacterSkillInfoDto[];

  /**
   * 내 링크 스킬 정보
   */
  public characterOwnedLinkSkill: BattlePracticeCharacterSkillInfoDto | null;

  constructor(obj: BattlePracticeCharacterLinkSkillObjectBody) {
    this.characterLinkSkill = obj.character_link_skill.map(
      (s) => new BattlePracticeCharacterSkillInfoDto(s),
    );
    this.characterOwnedLinkSkill = obj.character_owned_link_skill
      ? new BattlePracticeCharacterSkillInfoDto(obj.character_owned_link_skill)
      : null;
  }
}

/**
 * 연무장 입장 시 캐릭터 V 매트릭스 정보
 */
export class BattlePracticeCharacterVMatrixObjectDto {
  /**
   * V 코어 정보
   */
  public characterVCoreEquipment: BattlePracticeCharacterVCoreDto[];

  constructor(obj: BattlePracticeCharacterVMatrixObjectBody) {
    this.characterVCoreEquipment = obj.character_v_core_equipment.map(
      (v) => new BattlePracticeCharacterVCoreDto(v),
    );
  }
}

/**
 * 연무장 입장 시 캐릭터 V 코어 정보
 */
export class BattlePracticeCharacterVCoreDto {
  /**
   * 슬롯 인덱스
   */
  public slotId: string;

  /**
   * 슬롯 레벨
   */
  public slotLevel: number;

  /**
   * 코어 명
   */
  public vCoreName: string;

  /**
   * 코어 타입
   */
  public vCoreType: string;

  /**
   * 코어의 레벨
   */
  public vCoreLevel: number;

  /**
   * 코어에 해당하는 스킬 명
   */
  public vCoreSkill1: string | null;

  /**
   * (강화 코어인 경우) 코어에 해당하는 두 번째 스킬 명
   */
  public vCoreSkill2: string | null;

  /**
   * (강화 코어인 경우) 코어에 해당하는 세 번째 스킬 명
   */
  public vCoreSkill3: string | null;

  constructor(obj: BattlePracticeCharacterVCoreBody) {
    this.slotId = obj.slot_id;
    this.slotLevel = obj.slot_level;
    this.vCoreName = obj.v_core_name;
    this.vCoreType = obj.v_core_type;
    this.vCoreLevel = obj.v_core_level;
    this.vCoreSkill1 = obj.v_core_skill_1;
    this.vCoreSkill2 = obj.v_core_skill_2;
    this.vCoreSkill3 = obj.v_core_skill_3;
  }
}

/**
 * 연무장 입장 시 캐릭터 HEXA 매트릭스 정보
 */
export class BattlePracticeCharacterHexaMatrixObjectDto {
  /**
   * HEXA 코어 정보
   */
  public hexaCoreObject: BattlePracticeCharacterHexaCoreObjectDto;

  /**
   * HEXA 스탯 정보
   */
  public hexaMatrixStatObject: BattlePracticeCharacterHexaMatrixStatObjectDto;

  constructor(obj: BattlePracticeCharacterHexaMatrixObjectBody) {
    this.hexaCoreObject = new BattlePracticeCharacterHexaCoreObjectDto(obj.hexa_core_object);
    this.hexaMatrixStatObject = new BattlePracticeCharacterHexaMatrixStatObjectDto(
      obj.hexa_matrix_stat_object,
    );
  }
}

/**
 * 연무장 입장 시 캐릭터 HEXA 매트릭스 정보
 */
export class BattlePracticeCharacterHexaCoreObjectDto {
  /**
   * HEXA 매트릭스 코어 정보
   */
  public characterHexaCoreEquipment: BattlePracticeCharacterHexaCoreEquipmentDto[];

  constructor(obj: BattlePracticeCharacterHexaCoreObjectBody) {
    this.characterHexaCoreEquipment = obj.character_hexa_core_equipment.map(
      (c) => new BattlePracticeCharacterHexaCoreEquipmentDto(c),
    );
  }
}

/**
 * 연무장 입장 시 캐릭터 HEXA 매트릭스 코어 정보
 */
export class BattlePracticeCharacterHexaCoreEquipmentDto {
  /**
   * 코어 명
   */
  public hexaCoreName: string;

  /**
   *  코어 레벨
   */
  public hexaCoreLevel: number;

  /**
   * 코어 타입
   */
  public hexaCoreType: string;

  /**
   * 연결된 스킬
   */
  public linkedSkill: BattlePracticeCharacterHexaLinkedSkillDto[];

  constructor(obj: BattlePracticeCharacterHexaCoreEquipmentBody) {
    this.hexaCoreName = obj.hexa_core_name;
    this.hexaCoreLevel = obj.hexa_core_level;
    this.hexaCoreType = obj.hexa_core_type;
    this.linkedSkill = obj.linked_skill.map(
      (s) => new BattlePracticeCharacterHexaLinkedSkillDto(s),
    );
  }
}

/**
 * 연무장 입장 시 캐릭터 HEXA 매트릭스 코어에 연결된 스킬
 */
export class BattlePracticeCharacterHexaLinkedSkillDto {
  /**
   * HEXA 스킬 명
   */
  public hexaSkillId: string;

  constructor(obj: BattlePracticeCharacterHexaLinkedSkillBody) {
    this.hexaSkillId = obj.hexa_skill_id;
  }
}

/**
 * 연무장 입장 시 캐릭터 HEXA 스탯 정보
 */
export class BattlePracticeCharacterHexaMatrixStatObjectDto {
  /**
   * HEXA 스탯 I 코어 정보
   */
  public characterHexaStatCore: BattlePracticeCharacterHexaStatCoreDto[];

  /**
   * HEXA 스탯 II 코어 정보
   */
  public characterHexaStatCore2: BattlePracticeCharacterHexaStatCoreDto[];

  /**
   * HEXA 스탯 III 코어 정보
   */
  public characterHexaStatCore3: BattlePracticeCharacterHexaStatCoreDto[];

  constructor(obj: BattlePracticeCharacterHexaMatrixStatObjectBody) {
    this.characterHexaStatCore = obj.character_hexa_stat_core.map(
      (core) => new BattlePracticeCharacterHexaStatCoreDto(core),
    );
    this.characterHexaStatCore2 = obj.character_hexa_stat_core_2.map(
      (core) => new BattlePracticeCharacterHexaStatCoreDto(core),
    );
    this.characterHexaStatCore3 = obj.character_hexa_stat_core_3.map(
      (core) => new BattlePracticeCharacterHexaStatCoreDto(core),
    );
  }
}

/**
 * 연무장 입장 시 캐릭터 HEXA 스탯 코어 정보
 */
export class BattlePracticeCharacterHexaStatCoreDto {
  /**
   * 슬롯 인덱스
   */
  public slotId: string;

  /**
   * 메인 스탯 명
   */
  public mainStatName: string;

  /**
   * 첫 번째 서브 명
   */
  public subStatName1: string;

  /**
   * 두 번째 서브 명
   */
  public subStatName2: string;

  /**
   * 메인 스탯 레벨
   */
  public mainStatLevel: number;

  /**
   * 첫 번째 서브 레벨
   */
  public subStatLevel1: number;

  /**
   * 두 번째 서브 레벨
   */
  public subStatLevel2: number;

  /**
   * 스탯 코어 등급
   */
  public statGrade: number;

  constructor(obj: BattlePracticeCharacterHexaStatCoreBody) {
    this.slotId = obj.slot_id;
    this.mainStatName = obj.main_stat_name;
    this.subStatName1 = obj.sub_stat_name_1;
    this.subStatName2 = obj.sub_stat_name_2;
    this.mainStatLevel = obj.main_stat_level;
    this.subStatLevel1 = obj.sub_stat_level_1;
    this.subStatLevel2 = obj.sub_stat_level_2;
    this.statGrade = obj.stat_grade;
  }
}

/**
 * 연무장 입장 시 캐릭터 예비 특수 반지 슬롯에 장착한 특수 반지 정보
 */
export class BattlePracticeCharacterRingReserveSkillObjectDto {
  /**
   * 예비 특수 반지 슬롯에 장착한 특수 반지
   */
  public specialRingReserveName: string | null;

  /**
   * 예비 특수 반지 슬롯에 장착한 특수 반지 레벨
   */
  public specialRingReserveLevel: number | null;

  /**
   * 예비 특수 반지 슬롯에 장착한 특수 반지 아이콘
   */
  public specialRingReserveIcon: string | null;

  /**
   * 예비 특수 반지 슬롯에 장착한 특수 반지 설명
   */
  public specialRingReserveDescription: string | null;

  constructor(obj: BattlePracticeCharacterRingReserveSkillObjectBody) {
    this.specialRingReserveName = obj.special_ring_reserve_name;
    this.specialRingReserveLevel = obj.special_ring_reserve_level;
    this.specialRingReserveIcon = obj.special_ring_reserve_icon;
    this.specialRingReserveDescription = obj.special_ring_reserve_description;
  }
}

/**
 * 연무장 입장 시 유니온 공격대 정보
 */
export class BattlePracticeUnionRaiderObjectDto {
  /**
   * 유니온 공격대원 효과
   */
  public unionRaiderStat: string[];

  /**
   * 유니온 공격대 점령 효과
   */
  public unionOccupiedStat: string[];

  /**
   * 적용 중인 유니온 스탯 효과
   */
  public unionStateStat: string[];

  constructor(obj: BattlePracticeUnionRaiderObjectBody) {
    this.unionRaiderStat = obj.union_raider_stat;
    this.unionOccupiedStat = obj.union_occupied_stat;
    this.unionStateStat = obj.union_state_stat ?? [];
  }
}

/**
 * 연무장 입장 시 유니온 아티팩트 정보
 */
export class BattlePracticeUnionArtifactObjectDto {
  /**
   * 아티팩트 효과 정보
   */
  public unionArtifactEffect: BattlePracticeUnionArtifactEffectDto[];

  constructor(obj: BattlePracticeUnionArtifactObjectBody) {
    this.unionArtifactEffect = obj.union_artifact_effect.map(
      (e) => new BattlePracticeUnionArtifactEffectDto(e),
    );
  }
}

/**
 * 연무장 입장 시 유니온 아티팩트 효과 정보
 */
export class BattlePracticeUnionArtifactEffectDto {
  /**
   * 아티팩트 효과 명
   */
  public name: string;

  /**
   * 아티팩트 효과 레벨
   */
  public level: number;

  constructor(obj: BattlePracticeUnionArtifactEffectBody) {
    this.name = obj.name;
    this.level = obj.level;
  }
}

/**
 * 연무장 입장 시 유니온 챔피언 정보
 */
export class BattlePracticeUnionChampionObjectDto {
  /**
   * 유니온 챔피언 휘장
   */
  public championBadgeTotalInfo: BattlePracticeUnionChampionBadgeDto[];

  constructor(obj: BattlePracticeUnionChampionObjectBody) {
    this.championBadgeTotalInfo = obj.champion_badge_total_info.map(
      (b) => new BattlePracticeUnionChampionBadgeDto(b),
    );
  }
}

/**
 * 연무장 입장 시 유니온 챔피언 휘장 정보
 */
export class BattlePracticeUnionChampionBadgeDto {
  /**
   * 유니온 챔피언 휘장 효과
   */
  public stat: string;

  constructor(obj: BattlePracticeUnionChampionBadgeBody) {
    this.stat = obj.stat;
  }
}

/**
 * 연무장 입장 시 길드 정보
 */
export class BattlePracticeGuildObjectDto {
  /**
   * 길드 스킬 목록
   */
  public guildSkill: BattlePracticeGuildSkillDto[];

  /**
   * 노블레스 스킬 목록
   */
  public guildNoblesseSkill: BattlePracticeGuildSkillDto[];

  constructor(obj: BattlePracticeGuildObjectBody) {
    this.guildSkill = obj.guild_skill.map((s) => new BattlePracticeGuildSkillDto(s));
    this.guildNoblesseSkill = obj.guild_noblesse_skill.map(
      (s) => new BattlePracticeGuildSkillDto(s),
    );
  }
}

/**
 * 연무장 입장 시 길드 스킬
 */
export class BattlePracticeGuildSkillDto {
  /**
   * 스킬 명
   */
  public skillName: string;

  /**
   * 스킬 설명
   */
  public skillDescription: string;

  /**
   * 스킬 레벨
   */
  public skillLevel: number;

  /**
   * 스킬 레벨별 효과
   */
  public skillEffect: string;

  /**
   * 스킬 아이콘
   */
  public skillIcon: string;

  constructor(obj: BattlePracticeGuildSkillBody) {
    this.skillName = obj.skill_name;
    this.skillDescription = obj.skill_description;
    this.skillLevel = obj.skill_level;
    this.skillEffect = obj.skill_effect;
    this.skillIcon = obj.skill_icon;
  }
}
