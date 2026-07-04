from datetime import datetime
from pydantic import BaseModel, field_validator


class BattlePracticeCharacterBasic(BaseModel):
    """
    연무장 입장 시 캐릭터 기본 정보

    Attributes:
        character_name (str): 캐릭터 명
        character_level (int): 캐릭터 레벨
        character_class (str): 캐릭터 직업
        character_class_level (str): 캐릭터 전직 차수
        character_image (str): 캐릭터 외형 이미지
    """
    character_name: str
    character_level: int
    character_class: str
    character_class_level: str
    character_image: str


class BattlePracticeCharacterFinalStat(BaseModel):
    """
    연무장 입장 시 캐릭터 현재 스탯 정보

    Attributes:
        stat_name (str): 스탯 명
        stat_value (str): 스탯 값
    """
    stat_name: str
    stat_value: str


class BattlePracticeCharacterBasicStat(BaseModel):
    """
    연무장 입장 시 캐릭터 스탯 정보

    Attributes:
        final_stat (list[BattlePracticeCharacterFinalStat]): 현재 스탯 정보
    """
    final_stat: list[BattlePracticeCharacterFinalStat]


class BattlePracticeCharacterSymbol(BaseModel):
    """
    연무장 입장 시 캐릭터 장착 심볼 정보

    Attributes:
        symbol_name (str): 심볼 명
        symbol_icon (str): 심볼 아이콘
        symbol_description (str): 심볼 설명
        symbol_other_effect_description (str or None): 심볼 부가 효과 설명
        symbol_force (str): 심볼로 인한 증가 수치
        symbol_level (int): 심볼 레벨
        symbol_str (str): 심볼로 증가한 힘
        symbol_dex (str): 심볼로 증가한 민첩
        symbol_int (str): 심볼로 증가한 지력
        symbol_luk (str): 심볼로 증가한 운
        symbol_hp (str): 심볼로 증가한 체력
        symbol_drop_rate (str): 심볼로 증가한 아이템 드롭률
        symbol_meso_rate (str): 심볼로 증가한 메소 획득량
        symbol_exp_rate (str): 심볼로 증가한 경험치 획득량
        symbol_growth_count (int): 현재 보유 성장치
        symbol_require_growth_count (int): 성장 시 필요한 성장치
    """
    symbol_name: str
    symbol_icon: str
    symbol_description: str
    symbol_other_effect_description: str | None
    symbol_force: str
    symbol_level: int
    symbol_str: str
    symbol_dex: str
    symbol_int: str
    symbol_luk: str
    symbol_hp: str
    symbol_drop_rate: str
    symbol_meso_rate: str
    symbol_exp_rate: str
    symbol_growth_count: int
    symbol_require_growth_count: int


class BattlePracticeCharacterSymbolStat(BaseModel):
    """
    연무장 입장 시 캐릭터 장착 심볼 스탯 정보

    Attributes:
        symbol (list[BattlePracticeCharacterSymbol]): 심볼 정보
    """
    symbol: list[BattlePracticeCharacterSymbol]


class BattlePracticeCharacterOtherStatInfo(BaseModel):
    """
    연무장 입장 시 캐릭터 기타 스탯 정보

    Attributes:
        stat_name (str): 스탯 명
        stat_value (str): 스탯 값
    """
    stat_name: str
    stat_value: str


class BattlePracticeCharacterOtherStatDetail(BaseModel):
    """
    연무장 입장 시 캐릭터 능력치에 영향을 주는 요소 및 스탯 정보

    Attributes:
        other_stat_type (str): 스탯 타입
        stat_info (list[BattlePracticeCharacterOtherStatInfo]): 스탯 정보
    """
    other_stat_type: str
    stat_info: list[BattlePracticeCharacterOtherStatInfo]


class BattlePracticeCharacterOtherStat(BaseModel):
    """
    연무장 입장 시 캐릭터 기타 능력치 영향 요소

    Attributes:
        other_stat (list[BattlePracticeCharacterOtherStatDetail]): 능력치에 영향을 주는 요소 및 스탯 정보
    """
    other_stat: list[BattlePracticeCharacterOtherStatDetail]


class BattlePracticeCharacterStat(BaseModel):
    """
    연무장 입장 시 캐릭터 스탯 관련 정보

    Attributes:
        basic_stat_object (BattlePracticeCharacterBasicStat): 스탯 정보
        symbol_stat_object (BattlePracticeCharacterSymbolStat): 장착 심볼 정보
        other_stat_object (BattlePracticeCharacterOtherStat): 기타 능력치 영향 요소
    """
    basic_stat_object: BattlePracticeCharacterBasicStat
    symbol_stat_object: BattlePracticeCharacterSymbolStat
    other_stat_object: BattlePracticeCharacterOtherStat


class BattlePracticeCharacterHyperStat(BaseModel):
    """
    연무장 입장 시 캐릭터 하이퍼 스탯 상세 정보

    Attributes:
        stat_type (str): 스탯 종류
        stat_level (int): 스탯 레벨
        stat_increase (str): 스탯 상승량
    """
    stat_type: str
    stat_level: int
    stat_increase: str


class BattlePracticeCharacterHyperStatObject(BaseModel):
    """
    연무장 입장 시 캐릭터 하이퍼 스탯 정보

    Attributes:
        hyper_stat (list[BattlePracticeCharacterHyperStat]): 하이퍼 스탯 목록
    """
    hyper_stat: list[BattlePracticeCharacterHyperStat]


class BattlePracticeCharacterPropensity(BaseModel):
    """
    연무장 입장 시 캐릭터 성향 정보

    Attributes:
        charisma_level (int): 카리스마 레벨
        sensibility_level (int): 감성 레벨
        insight_level (int): 통찰력 레벨
        willingness_level (int): 의지 레벨
        handicraft_level (int): 손재주 레벨
        charm_level (int): 매력 레벨
    """
    charisma_level: int
    sensibility_level: int
    insight_level: int
    willingness_level: int
    handicraft_level: int
    charm_level: int


class BattlePracticeCharacterAbilityInfo(BaseModel):
    """
    연무장 입장 시 캐릭터 어빌리티 상세 정보

    Attributes:
        ability_no (str): 어빌리티 번호
        ability_grade (str): 어빌리티 등급
        ability_value (str): 어빌리티 옵션 및 수치
    """
    ability_no: str
    ability_grade: str
    ability_value: str


class BattlePracticeCharacterAbilityObject(BaseModel):
    """
    연무장 입장 시 캐릭터 어빌리티 정보

    Attributes:
        ability_info (list[BattlePracticeCharacterAbilityInfo]): 어빌리티 정보
    """
    ability_info: list[BattlePracticeCharacterAbilityInfo]


class BattlePracticeCharacterItemTotalOption(BaseModel):
    """
    연무장 입장 시 캐릭터 장비 최종 옵션 정보

    Attributes:
        str (str): STR
        dex (str): DEX
        int (str): INT
        luk (str): LUK
        max_hp (str): 최대 HP
        max_mp (str): 최대 MP
        attack_power (str): 공격력
        magic_power (str): 마력
        armor (str): 방어력
        speed (str): 이동속도
        jump (str): 점프력
        boss_damage (str): 보스 몬스터 데미지 증가 (%)
        ignore_monster_armor (str): 몬스터 방어율 무시 (%)
        all_stat (str): 올스탯 (%)
        damage (str): 데미지 (%)
        equipment_level_decrease (int): 착용 레벨 감소
        max_hp_rate (str): 최대 HP (%)
        max_mp_rate (str): 최대 MP (%)
    """
    str: str
    dex: str
    int: str
    luk: str
    max_hp: str
    max_mp: str
    attack_power: str
    magic_power: str
    armor: str
    speed: str
    jump: str
    boss_damage: str
    ignore_monster_armor: str
    all_stat: str
    damage: str
    equipment_level_decrease: int
    max_hp_rate: str
    max_mp_rate: str


class BattlePracticeCharacterItemBaseOption(BaseModel):
    """
    연무장 입장 시 캐릭터 장비 기본 옵션 정보

    Attributes:
        str (str): STR
        dex (str): DEX
        int (str): INT
        luk (str): LUK
        max_hp (str): 최대 HP
        max_mp (str): 최대 MP
        attack_power (str): 공격력
        magic_power (str): 마력
        armor (str): 방어력
        speed (str): 이동속도
        jump (str): 점프력
        boss_damage (str): 보스 몬스터 데미지 증가 (%)
        ignore_monster_armor (str): 몬스터 방어율 무시 (%)
        all_stat (str): 올스탯 (%)
        max_hp_rate (str): 최대 HP
        max_mp_rate (str): 최대 MP
        base_equipment_level (int): 기본 착용 레벨
    """
    str: str
    dex: str
    int: str
    luk: str
    max_hp: str
    max_mp: str
    attack_power: str
    magic_power: str
    armor: str
    speed: str
    jump: str
    boss_damage: str
    ignore_monster_armor: str
    all_stat: str
    max_hp_rate: str
    max_mp_rate: str
    base_equipment_level: int


class BattlePracticeCharacterItemExceptionalOption(BaseModel):
    """
    연무장 입장 시 캐릭터 장비 특별 옵션 정보

    Attributes:
        str (str): STR
        dex (str): DEX
        int (str): INT
        luk (str): LUK
        max_hp (str): 최대 HP
        max_mp (str): 최대 MP
        attack_power (str): 공격력
        magic_power (str): 마력
        exceptional_upgrade (int): 익셉서녈 강화 적용 횟수
    """
    str: str
    dex: str
    int: str
    luk: str
    max_hp: str
    max_mp: str
    attack_power: str
    magic_power: str
    exceptional_upgrade: int


class BattlePracticeCharacterItemAddOption(BaseModel):
    """
    연무장 입장 시 캐릭터 장비 추가 옵션 정보

    Attributes:
        str (str): STR
        dex (str): DEX
        int (str): INT
        luk (str): LUK
        max_hp (str): 최대 HP
        max_mp (str): 최대 MP
        attack_power (str): 공격력
        magic_power (str): 마력
        armor (str): 방어력
        speed (str): 이동속도
        jump (str): 점프력
        boss_damage (str): 보스 몬스터 데미지 증가 (%)
        damage (str): 데미지 (%)
        all_stat (str): 올스탯 (%)
        equipment_level_decrease (int): 착용 레벨 감소
    """
    str: str
    dex: str
    int: str
    luk: str
    max_hp: str
    max_mp: str
    attack_power: str
    magic_power: str
    armor: str
    speed: str
    jump: str
    boss_damage: str
    damage: str
    all_stat: str
    equipment_level_decrease: int


class BattlePracticeCharacterItemEtcOption(BaseModel):
    """
    연무장 입장 시 캐릭터 장비 기타 옵션 정보

    Attributes:
        str (str): STR
        dex (str): DEX
        int (str): INT
        luk (str): LUK
        max_hp (str): 최대 HP
        max_mp (str): 최대 MP
        attack_power (str): 공격력
        magic_power (str): 마력
        armor (str): 방어력
        speed (str): 이동속도
        jump (str): 점프력
    """
    str: str
    dex: str
    int: str
    luk: str
    max_hp: str
    max_mp: str
    attack_power: str
    magic_power: str
    armor: str
    speed: str
    jump: str


class BattlePracticeCharacterItemStarforceOption(BaseModel):
    """
    연무장 입장 시 캐릭터 장비 스타포스 옵션 정보

    Attributes:
        str (str): STR
        dex (str): DEX
        int (str): INT
        luk (str): LUK
        max_hp (str): 최대 HP
        max_mp (str): 최대 MP
        attack_power (str): 공격력
        magic_power (str): 마력
        armor (str): 방어력
        speed (str): 이동속도
        jump (str): 점프력
    """
    str: str
    dex: str
    int: str
    luk: str
    max_hp: str
    max_mp: str
    attack_power: str
    magic_power: str
    armor: str
    speed: str
    jump: str


class BattlePracticeCharacterItemEquipment(BaseModel):
    """
    연무장 입장 시 캐릭터 장착 장비 정보

    Attributes:
        item_equipment_part (str): 장비 부위 명
        item_equipment_slot (str): 장비 슬롯 위치
        item_name (str): 장비 명
        item_icon (str): 장비 아이콘
        item_description (str or None): 장비 설명
        item_shape_name (str): 장비 외형
        item_shape_icon (str): 장비 외형 아이콘
        item_gender (str or None): 전용 성별
        item_total_option (BattlePracticeCharacterItemTotalOption): 장비 최종 옵션 정보
        item_base_option (BattlePracticeCharacterItemBaseOption): 장비 기본 옵션 정보
        potential_option_flag (str or None): 잠재능력 봉인 여부 (true 봉인, false 봉인 없음)
        additional_potential_option_flag (str or None): 에디셔널 잠재능력 개방 여부 (true 봉인, false 봉인 없음)
        potential_option_grade (str or None): 잠재능력 등급
        additional_potential_option_grade (str or None): 에디셔널 잠재능력 등급
        potential_option_1 (str or None): 잠재능력 첫 번째 옵션
        potential_option_2 (str or None): 잠재능력 두 번째 옵션
        potential_option_3 (str or None): 잠재능력 세 번째 옵션
        additional_potential_option_1 (str or None): 에디셔널 잠재능력 첫 번째 옵션
        additional_potential_option_2 (str or None): 에디셔널 잠재능력 두 번째 옵션
        additional_potential_option_3 (str or None): 에디셔널 잠재능력 세 번째 옵션
        equipment_level_increase (int): 착용 레벨 증가
        item_exceptional_option (BattlePracticeCharacterItemExceptionalOption): 장비 특별 옵션 정보
        item_add_option (BattlePracticeCharacterItemAddOption): 장비 추가 옵션 정보
        growth_exp (int): 성장 경험치
        growth_level (int): 성장 레벨
        scroll_upgrade (str): 주문서 횟수
        cuttable_count (str): 가위 사용 가능 횟수 (교환 불가 장비, 가위 횟수가 없는 교환 가능 장비는 255)
        golden_hammer_flag (str): 황금 망치 재련 적용 (1:적용, 이외 미 적용)
        scroll_resilience_count (str): 복구 가능 횟수
        scroll_upgrade_able_count (str): 주문서 잔여 횟수
        soul_name (str or None): 소울 명
        soul_option (str or None): 소울 옵션
        item_etc_option (BattlePracticeCharacterItemEtcOption): 장비 기타 옵션 정보
        starforce (str): 강화 단계
        starforce_scroll_flag (str): 놀라운 장비 강화 주문서 사용 여부 (0:미사용, 1:사용)
        item_starforce_option (BattlePracticeCharacterItemStarforceOption): 장비 스타포스 옵션 정보
        special_ring_level (int): 특수 반지 레벨
        date_expire (datetime or None): 장비 유효 기간 (KST)
        freestyle_flag (str or None): 프리스타일 쿠폰 적용 여부 (0:미적용, 1:적용)
    """
    item_equipment_part: str
    item_equipment_slot: str
    item_name: str
    item_icon: str
    item_description: str | None
    item_shape_name: str
    item_shape_icon: str
    item_gender: str | None
    item_total_option: BattlePracticeCharacterItemTotalOption
    item_base_option: BattlePracticeCharacterItemBaseOption
    potential_option_flag: str | None
    additional_potential_option_flag: str | None
    potential_option_grade: str | None
    additional_potential_option_grade: str | None
    potential_option_1: str | None
    potential_option_2: str | None
    potential_option_3: str | None
    additional_potential_option_1: str | None
    additional_potential_option_2: str | None
    additional_potential_option_3: str | None
    equipment_level_increase: int
    item_exceptional_option: BattlePracticeCharacterItemExceptionalOption
    item_add_option: BattlePracticeCharacterItemAddOption
    growth_exp: int
    growth_level: int
    scroll_upgrade: str
    cuttable_count: str
    golden_hammer_flag: str
    scroll_resilience_count: str
    scroll_upgrade_able_count: str
    soul_name: str | None
    soul_option: str | None
    item_etc_option: BattlePracticeCharacterItemEtcOption
    starforce: str
    starforce_scroll_flag: str
    item_starforce_option: BattlePracticeCharacterItemStarforceOption
    special_ring_level: int
    date_expire: datetime | None
    freestyle_flag: str | None


class BattlePracticeCharacterItemDragonEquipment(BaseModel):
    """
    연무장 입장 시 캐릭터 에반 드래곤 장비

    Attributes:
        item_equipment_part (str): 장비 부위 명
        item_equipment_slot (str): 장비 슬롯 위치
        item_name (str): 장비 명
        item_icon (str): 장비 아이콘
        item_description (str or None): 장비 설명
        item_shape_name (str): 장비 외형
        item_shape_icon (str): 장비 외형 아이콘
        item_gender (str or None): 전용 성별
        item_total_option (BattlePracticeCharacterItemTotalOption): 장비 최종 옵션 정보
        item_base_option (BattlePracticeCharacterItemBaseOption): 장비 기본 옵션 정보
        equipment_level_increase (int): 착용 레벨 증가
        item_exceptional_option (BattlePracticeCharacterItemExceptionalOption): 장비 특별 옵션 정보
        item_add_option (BattlePracticeCharacterItemAddOption): 장비 추가 옵션 정보
        growth_exp (int): 성장 경험치
        growth_level (int): 성장 레벨
        scroll_upgrade (str): 주문서 횟수
        cuttable_count (str): 가위 사용 가능 횟수 (교환 불가 장비, 가위 횟수가 없는 교환 가능 장비는 255)
        golden_hammer_flag (str): 황금 망치 재련 적용 (1:적용, 이외 미 적용)
        scroll_resilience_count (str): 복구 가능 횟수
        scroll_upgrade_able_count (str): 주문서 잔여 횟수
        soul_name (str or None): 소울 명
        soul_option (str or None): 소울 옵션
        item_etc_option (BattlePracticeCharacterItemEtcOption): 장비 기타 옵션 정보
        starforce (str): 강화 단계
        starforce_scroll_flag (str): 놀라운 장비 강화 주문서 사용 여부 (0:미사용, 1:사용)
        item_starforce_option (BattlePracticeCharacterItemStarforceOption): 장비 스타포스 옵션 정보
        special_ring_level (int): 특수 반지 레벨
        date_expire (datetime or None): 장비 유효 기간 (KST)
        freestyle_flag (str or None): 프리스타일 쿠폰 적용 여부 (0:미적용, 1:적용)
    """
    item_equipment_part: str
    item_equipment_slot: str
    item_name: str
    item_icon: str
    item_description: str | None
    item_shape_name: str
    item_shape_icon: str
    item_gender: str | None
    item_total_option: BattlePracticeCharacterItemTotalOption
    item_base_option: BattlePracticeCharacterItemBaseOption
    equipment_level_increase: int
    item_exceptional_option: BattlePracticeCharacterItemExceptionalOption
    item_add_option: BattlePracticeCharacterItemAddOption
    growth_exp: int
    growth_level: int
    scroll_upgrade: str
    cuttable_count: str
    golden_hammer_flag: str
    scroll_resilience_count: str
    scroll_upgrade_able_count: str
    soul_name: str | None
    soul_option: str | None
    item_etc_option: BattlePracticeCharacterItemEtcOption
    starforce: str
    starforce_scroll_flag: str
    item_starforce_option: BattlePracticeCharacterItemStarforceOption
    special_ring_level: int
    date_expire: datetime | None
    freestyle_flag: str | None


class BattlePracticeCharacterItemMechanicEquipment(BaseModel):
    """
    연무장 입장 시 캐릭터 메카닉 장비

    Attributes:
        item_equipment_part (str): 장비 부위 명
        item_equipment_slot (str): 장비 슬롯 위치
        item_name (str): 장비 명
        item_icon (str): 장비 아이콘
        item_description (str or None): 장비 설명
        item_shape_name (str): 장비 외형
        item_shape_icon (str): 장비 외형 아이콘
        item_gender (str or None): 전용 성별
        item_total_option (BattlePracticeCharacterItemTotalOption): 장비 최종 옵션 정보
        item_base_option (BattlePracticeCharacterItemBaseOption): 장비 기본 옵션 정보
        equipment_level_increase (int): 착용 레벨 증가
        item_exceptional_option (BattlePracticeCharacterItemExceptionalOption): 장비 특별 옵션 정보
        item_add_option (BattlePracticeCharacterItemAddOption): 장비 추가 옵션 정보
        growth_exp (int): 성장 경험치
        growth_level (int): 성장 레벨
        scroll_upgrade (str): 주문서 횟수
        cuttable_count (str): 가위 사용 가능 횟수 (교환 불가 장비, 가위 횟수가 없는 교환 가능 장비는 255)
        golden_hammer_flag (str): 황금 망치 재련 적용 (1:적용, 이외 미 적용)
        scroll_resilience_count (str): 복구 가능 횟수
        scroll_upgrade_able_count (str): 주문서 잔여 횟수
        soul_name (str or None): 소울 명
        soul_option (str or None): 소울 옵션
        item_etc_option (BattlePracticeCharacterItemEtcOption): 장비 기타 옵션 정보
        starforce (str): 강화 단계
        starforce_scroll_flag (str): 놀라운 장비 강화 주문서 사용 여부 (0:미사용, 1:사용)
        item_starforce_option (BattlePracticeCharacterItemStarforceOption): 장비 스타포스 옵션 정보
        special_ring_level (int): 특수 반지 레벨
        date_expire (datetime or None): 장비 유효 기간 (KST)
        freestyle_flag (str or None): 프리스타일 쿠폰 적용 여부 (0:미적용, 1:적용)
    """
    item_equipment_part: str
    item_equipment_slot: str
    item_name: str
    item_icon: str
    item_description: str | None
    item_shape_name: str
    item_shape_icon: str
    item_gender: str | None
    item_total_option: BattlePracticeCharacterItemTotalOption
    item_base_option: BattlePracticeCharacterItemBaseOption
    equipment_level_increase: int
    item_exceptional_option: BattlePracticeCharacterItemExceptionalOption
    item_add_option: BattlePracticeCharacterItemAddOption
    growth_exp: int
    growth_level: int
    scroll_upgrade: str
    cuttable_count: str
    golden_hammer_flag: str
    scroll_resilience_count: str
    scroll_upgrade_able_count: str
    soul_name: str | None
    soul_option: str | None
    item_etc_option: BattlePracticeCharacterItemEtcOption
    starforce: str
    starforce_scroll_flag: str
    item_starforce_option: BattlePracticeCharacterItemStarforceOption
    special_ring_level: int
    date_expire: datetime | None
    freestyle_flag: str | None


class BattlePracticeCharacterItemTitle(BaseModel):
    """
    연무장 입장 시 캐릭터 칭호 정보

    Attributes:
        title_name (str): 칭호 장비 명
        title_icon (str): 칭호 아이콘
        title_description (str): 칭호 설명
        date_expire (datetime or None): 칭호 유효 기간 (KST)
        date_option_expire (datetime or None): 칭호 옵션 유효 기간 (expired:만료, null:무제한) (KST)
        title_shape_name (str or None): 외형 설정에 등록한 칭호 장비 명
        title_shape_icon (str or None): 외형 설정에 등록한 칭호 아이콘
        title_shape_description (str or None): 외형 설정에 등록한 칭호 설명
    """
    title_name: str
    title_icon: str
    title_description: str
    date_expire: datetime | None
    date_option_expire: datetime | None
    title_shape_name: str | None
    title_shape_icon: str | None
    title_shape_description: str | None


class BattlePracticeCharacterItemEquipmentObject(BaseModel):
    """
    연무장 입장 시 캐릭터 장착 장비 정보

    Attributes:
        item_equipment (list[BattlePracticeCharacterItemEquipment]): 장착 장비 정보
        title (BattlePracticeCharacterItemTitle or None): 칭호 정보
        dragon_equipment (list[BattlePracticeCharacterItemDragonEquipment]): 에반 드래곤 장비 정보 (에반인 경우 응답)
        mechanic_equipment (list[BattlePracticeCharacterItemMechanicEquipment]): 메카닉 장비 목록 (메카닉인 경우 응답)
    """
    item_equipment: list[BattlePracticeCharacterItemEquipment]
    title: BattlePracticeCharacterItemTitle | None
    dragon_equipment: list[BattlePracticeCharacterItemDragonEquipment]
    mechanic_equipment: list[BattlePracticeCharacterItemMechanicEquipment]


class BattlePracticeCharacterSetEffectInfo(BaseModel):
    """
    연무장 입장 시 캐릭터 적용 중인 세트 효과 정보

    Attributes:
        set_count (int): 세트 효과 레벨 (장비 수)
        set_option (str): 세트 효과
    """
    set_count: int
    set_option: str


class BattlePracticeCharacterSetEffect(BaseModel):
    """
    연무장 입장 시 캐릭터 세트 효과 정보

    Attributes:
        set_name (str): 세트 효과 명
        total_set_count (int): 세트 개수 (럭키 아이템 포함)
        set_effect_info (list[BattlePracticeCharacterSetEffectInfo]): 적용 중인 세트 효과 정보
    """
    set_name: str
    total_set_count: int
    set_effect_info: list[BattlePracticeCharacterSetEffectInfo]


class BattlePracticeCharacterSetEffectObject(BaseModel):
    """
    연무장 입장 시 캐릭터 적용 세트 효과 정보

    Attributes:
        set_effect (list[BattlePracticeCharacterSetEffect]): 세트 효과 정보
    """
    set_effect: list[BattlePracticeCharacterSetEffect]


class BattlePracticeCharacterItemObject(BaseModel):
    """
    연무장 입장 시 캐릭터 장비(캐시 장비 제외) 정보

    Attributes:
        item_equipment_object (BattlePracticeCharacterItemEquipmentObject): 장착 장비 정보
        set_effect_object (BattlePracticeCharacterSetEffectObject): 적용 세트 효과 정보
    """
    item_equipment_object: BattlePracticeCharacterItemEquipmentObject
    set_effect_object: BattlePracticeCharacterSetEffectObject


class BattlePracticeCharacterCashItemOption(BaseModel):
    """
    연무장 입장 시 캐릭터 캐시 장비 옵션

    Attributes:
        option_type (str): 옵션 타입
        option_value (str): 옵션 값
    """
    option_type: str
    option_value: str


class BattlePracticeCharacterCashItemEquipment(BaseModel):
    """
    연무장 입장 시 캐릭터 장착 캐시 장비 정보

    Attributes:
        cash_item_equipment_part (str): 캐시 장비 부위 명
        cash_item_equipment_slot (str): 캐시 장비 슬롯 위치
        cash_item_name (str): 캐시 장비 명
        cash_item_icon (str): 캐시 장비 아이콘
        cash_item_description (str or None): 캐시 장비 설명
        cash_item_option (list[BattlePracticeCharacterCashItemOption]): 캐시 장비 옵션 목록
        date_expire (datetime or None): 캐시 장비 유효 기간 (KST)
        date_option_expire (datetime or None): 캐시 장비 옵션 유효 기간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
    """
    cash_item_equipment_part: str
    cash_item_equipment_slot: str
    cash_item_name: str
    cash_item_icon: str
    cash_item_description: str | None
    cash_item_option: list[BattlePracticeCharacterCashItemOption]
    date_expire: datetime | None
    date_option_expire: datetime | None


class BattlePracticeCharacterCashItemObject(BaseModel):
    """
    연무장 입장 시 캐릭터 캐시 장비 정보

    Attributes:
        cash_item_equipment_base (list[BattlePracticeCharacterCashItemEquipment]): 장착 중인 캐시 장비
        additional_cash_item_equipment_base (list[BattlePracticeCharacterCashItemEquipment]): 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드에서 장착 중인 캐시 장비
    """
    cash_item_equipment_base: list[BattlePracticeCharacterCashItemEquipment]
    additional_cash_item_equipment_base: list[BattlePracticeCharacterCashItemEquipment]


class BattlePracticeCharacterPetEquipmentItemOption(BaseModel):
    """
    연무장 입장 시 캐릭터 펫 장비 옵션

    Attributes:
        option_type (str): 옵션 타입
        option_value (str): 옵션 값
    """
    option_type: str
    option_value: str


class BattlePracticeCharacterPetEquipment(BaseModel):
    """
    연무장 입장 시 캐릭터 펫 장착 정보

    Attributes:
        item_name (str): 아이템 명
        item_icon (str): 아이템 아이콘
        item_description (str or None): 아이템 설명
        item_option (list[BattlePracticeCharacterPetEquipmentItemOption]): 아이템의 표기상 옵션
        scroll_upgrade (int): 주문서 횟수
        scroll_upgradable (int): 주문서 잔여 횟수
        item_shape (str or None): 아이템 외형
        item_shape_icon (str or None): 아이템 외형 아이콘
        item_date_expire (datetime or None): 아이템 만료 시간
    """
    item_name: str
    item_icon: str
    item_description: str | None
    item_option: list[BattlePracticeCharacterPetEquipmentItemOption]
    scroll_upgrade: int
    scroll_upgradable: int
    item_shape: str | None
    item_shape_icon: str | None
    item_date_expire: datetime | None


class BattlePracticeCharacterPetAutoSkill(BaseModel):
    """
    연무장 입장 시 캐릭터 펫 자동스킬 정보

    Attributes:
        skill_1 (str or None): 첫 번째 슬롯에 등록된 자동 스킬 명
        skill_1_icon (str or None): 첫 번째 슬롯에 등록된 자동 스킬 아이콘
        skill_2 (str or None): 두 번째 슬롯에 등록된 자동 스킬 명
        skill_2_icon (str or None): 두 번째 슬롯에 등록된 자동 스킬 아이콘
    """
    skill_1: str | None
    skill_1_icon: str | None
    skill_2: str | None
    skill_2_icon: str | None


class BattlePracticeCharacterPetiteLunaPetSkill(BaseModel):
    """
    연무장 입장 시 루나 쁘띠 펫 스킬 정보

    Attributes:
        skill_name (str or None): 스킬 명
        skill_description (str or None): 스킬 설명
        skill_effect (str or None): 스킬 효과 설명
        skill_icon (str or None): 스킬 아이콘
    """
    skill_name: str | None
    skill_description: str | None
    skill_effect: str | None
    skill_icon: str | None


class BattlePracticeCharacterPetObject(BaseModel):
    """
    연무장 입장 시 캐릭터 장착 펫 정보

    Attributes:
        pet_activate_flag (str or None): 활성화된 펫 유형 (0:캐릭터 펫, 1:월드 공유 펫)
        pet_1_name (str or None): 펫1 명
        pet_1_nickname (str or None): 펫1 닉네임
        pet_1_icon (str or None): 펫1 아이콘
        pet_1_description (str or None): 펫1 설명
        pet_1_equipment (BattlePracticeCharacterPetEquipment or None): 펫1 장착 정보
        pet_1_auto_skill (BattlePracticeCharacterPetAutoSkill or None): 펫1 버프 자동스킬 정보
        pet_1_pet_type (str or None): 펫1 원더 펫 종류
        pet_1_skill (list[str]): 펫1 펫 보유 스킬
        pet_1_date_expire (datetime or None): 펫1 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
        pet_2_name (str or None): 펫2 명
        pet_2_nickname (str or None): 펫2 닉네임
        pet_2_icon (str or None): 펫2 아이콘
        pet_2_description (str or None): 펫2 설명
        pet_2_equipment (BattlePracticeCharacterPetEquipment or None): 펫2 장착 정보
        pet_2_auto_skill (BattlePracticeCharacterPetAutoSkill or None): 펫2 버프 자동스킬 정보
        pet_2_pet_type (str or None): 펫2 원더 펫 종류
        pet_2_skill (list[str]): 펫2 펫 보유 스킬
        pet_2_date_expire (datetime or None): 펫2 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
        pet_3_name (str or None): 펫3 명
        pet_3_nickname (str or None): 펫3 닉네임
        pet_3_icon (str or None): 펫3 아이콘
        pet_3_description (str or None): 펫3 설명
        pet_3_equipment (BattlePracticeCharacterPetEquipment or None): 펫3 장착 정보
        pet_3_auto_skill (BattlePracticeCharacterPetAutoSkill or None): 펫3 버프 자동스킬 정보
        pet_3_pet_type (str or None): 펫3 원더 펫 종류
        pet_3_skill (list[str]): 펫3 펫 보유 스킬
        pet_3_date_expire (datetime or None): 펫3 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
        world_share_pet_1_name (str or None): 월드 공유 펫1 명
        world_share_pet_1_nickname (str or None): 월드 공유 펫1 닉네임
        world_share_pet_1_icon (str or None): 월드 공유 펫1 아이콘
        world_share_pet_1_description (str or None): 월드 공유 펫1 설명
        world_share_pet_1_pet_type (str or None): 월드 공유 펫1 원더 펫 종류
        world_share_pet_1_equipment (BattlePracticeCharacterPetEquipment or None): 월드 공유 펫1 장착 정보
        world_share_pet_1_auto_skill (BattlePracticeCharacterPetAutoSkill or None): 월드 공유 펫1 버프 자동스킬 정보
        world_share_pet_1_skill (list[str]): 월드 공유 펫1 펫 보유 스킬
        world_share_pet_1_date_expire (datetime or None): 월드 공유 펫1 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
        world_share_pet_2_name (str or None): 월드 공유 펫2 명
        world_share_pet_2_nickname (str or None): 월드 공유 펫2 닉네임
        world_share_pet_2_icon (str or None): 월드 공유 펫2 아이콘
        world_share_pet_2_description (str or None): 월드 공유 펫2 설명
        world_share_pet_2_pet_type (str or None): 월드 공유 펫2 원더 펫 종류
        world_share_pet_2_equipment (BattlePracticeCharacterPetEquipment or None): 월드 공유 펫2 장착 정보
        world_share_pet_2_auto_skill (BattlePracticeCharacterPetAutoSkill or None): 월드 공유 펫2 버프 자동스킬 정보
        world_share_pet_2_skill (list[str]): 월드 공유 펫2 펫 보유 스킬
        world_share_pet_2_date_expire (datetime or None): 월드 공유 펫2 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
        world_share_pet_3_name (str or None): 월드 공유 펫3 명
        world_share_pet_3_nickname (str or None): 월드 공유 펫3 닉네임
        world_share_pet_3_icon (str or None): 월드 공유 펫3 아이콘
        world_share_pet_3_description (str or None): 월드 공유 펫3 설명
        world_share_pet_3_pet_type (str or None): 월드 공유 펫3 원더 펫 종류
        world_share_pet_3_equipment (BattlePracticeCharacterPetEquipment or None): 월드 공유 펫3 장착 정보
        world_share_pet_3_auto_skill (BattlePracticeCharacterPetAutoSkill or None): 월드 공유 펫3 버프 자동스킬 정보
        world_share_pet_3_skill (list[str]): 월드 공유 펫3 펫 보유 스킬
        world_share_pet_3_date_expire (datetime or None): 월드 공유 펫3 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
        petite_luna_pet_skill (list[BattlePracticeCharacterPetiteLunaPetSkill]): 루나 쁘띠 펫 스킬 정보
    """
    pet_activate_flag: str | None = None
    pet_1_name: str | None
    pet_1_nickname: str | None
    pet_1_icon: str | None
    pet_1_description: str | None
    pet_1_equipment: BattlePracticeCharacterPetEquipment | None
    pet_1_auto_skill: BattlePracticeCharacterPetAutoSkill | None
    pet_1_pet_type: str | None
    pet_1_skill: list[str]
    pet_1_date_expire: datetime | None
    pet_2_name: str | None
    pet_2_nickname: str | None
    pet_2_icon: str | None
    pet_2_description: str | None
    pet_2_equipment: BattlePracticeCharacterPetEquipment | None
    pet_2_auto_skill: BattlePracticeCharacterPetAutoSkill | None
    pet_2_pet_type: str | None
    pet_2_skill: list[str]
    pet_2_date_expire: datetime | None
    pet_3_name: str | None
    pet_3_nickname: str | None
    pet_3_icon: str | None
    pet_3_description: str | None
    pet_3_equipment: BattlePracticeCharacterPetEquipment | None
    pet_3_auto_skill: BattlePracticeCharacterPetAutoSkill | None
    pet_3_pet_type: str | None
    pet_3_skill: list[str]
    pet_3_date_expire: datetime | None
    world_share_pet_1_name: str | None = None
    world_share_pet_1_nickname: str | None = None
    world_share_pet_1_icon: str | None = None
    world_share_pet_1_description: str | None = None
    world_share_pet_1_pet_type: str | None = None
    world_share_pet_1_equipment: BattlePracticeCharacterPetEquipment | None = None
    world_share_pet_1_auto_skill: BattlePracticeCharacterPetAutoSkill | None = None
    world_share_pet_1_skill: list[str] = []
    world_share_pet_1_date_expire: datetime | None = None
    world_share_pet_2_name: str | None = None
    world_share_pet_2_nickname: str | None = None
    world_share_pet_2_icon: str | None = None
    world_share_pet_2_description: str | None = None
    world_share_pet_2_pet_type: str | None = None
    world_share_pet_2_equipment: BattlePracticeCharacterPetEquipment | None = None
    world_share_pet_2_auto_skill: BattlePracticeCharacterPetAutoSkill | None = None
    world_share_pet_2_skill: list[str] = []
    world_share_pet_2_date_expire: datetime | None = None
    world_share_pet_3_name: str | None = None
    world_share_pet_3_nickname: str | None = None
    world_share_pet_3_icon: str | None = None
    world_share_pet_3_description: str | None = None
    world_share_pet_3_pet_type: str | None = None
    world_share_pet_3_equipment: BattlePracticeCharacterPetEquipment | None = None
    world_share_pet_3_auto_skill: BattlePracticeCharacterPetAutoSkill | None = None
    world_share_pet_3_skill: list[str] = []
    world_share_pet_3_date_expire: datetime | None = None
    petite_luna_pet_skill: list[BattlePracticeCharacterPetiteLunaPetSkill] = []

    @field_validator(
        'pet_1_skill',
        'pet_2_skill',
        'pet_3_skill',
        'world_share_pet_1_skill',
        'world_share_pet_2_skill',
        'world_share_pet_3_skill',
        'petite_luna_pet_skill',
        mode='before',
    )
    @classmethod
    def null_as_empty(cls, v):
        return v if v is not None else []


class BattlePracticeCharacterSkillInfo(BaseModel):
    """
    연무장 입장 시 캐릭터 스킬 정보

    Attributes:
        skill_name (str): 스킬 명
        skill_description (str): 스킬 설명
        skill_level (int): 스킬 레벨
        skill_effect (str or None): 스킬 효과
        skill_icon (str): 스킬 아이콘
    """
    skill_name: str
    skill_description: str
    skill_level: int
    skill_effect: str | None
    skill_icon: str


class BattlePracticeCharacterSkillObject(BaseModel):
    """
    연무장 입장 시 캐릭터 캐릭터 스킬 정보

    Attributes:
        character_skill (list[BattlePracticeCharacterSkillInfo]): 스킬 정보
    """
    character_skill: list[BattlePracticeCharacterSkillInfo]


class BattlePracticeCharacterLinkSkillObject(BaseModel):
    """
    연무장 입장 시 캐릭터 링크 스킬 정보

    Attributes:
        character_link_skill (list[BattlePracticeCharacterSkillInfo]): 링크 스킬 정보
        character_owned_link_skill (BattlePracticeCharacterSkillInfo or None): 내 링크 스킬 정보
    """
    character_link_skill: list[BattlePracticeCharacterSkillInfo]
    character_owned_link_skill: BattlePracticeCharacterSkillInfo | None


class BattlePracticeCharacterVCore(BaseModel):
    """
    연무장 입장 시 캐릭터 V 코어 정보

    Attributes:
        slot_id (str): 슬롯 인덱스
        slot_level (int): 슬롯 레벨
        v_core_name (str): 코어 명
        v_core_type (str): 코어 타입
        v_core_level (int): 코어의 레벨
        v_core_skill_1 (str or None): 코어에 해당하는 스킬 명
        v_core_skill_2 (str or None): (강화 코어인 경우) 코어에 해당하는 두 번째 스킬 명
        v_core_skill_3 (str or None): (강화 코어인 경우) 코어에 해당하는 세 번째 스킬 명
    """
    slot_id: str
    slot_level: int
    v_core_name: str
    v_core_type: str
    v_core_level: int
    v_core_skill_1: str | None
    v_core_skill_2: str | None
    v_core_skill_3: str | None


class BattlePracticeCharacterVMatrixObject(BaseModel):
    """
    연무장 입장 시 캐릭터 V 매트릭스 정보

    Attributes:
        character_v_core_equipment (list[BattlePracticeCharacterVCore]): V 코어 정보
    """
    character_v_core_equipment: list[BattlePracticeCharacterVCore]


class BattlePracticeCharacterHexaLinkedSkill(BaseModel):
    """
    연무장 입장 시 캐릭터 HEXA 매트릭스 코어에 연결된 스킬

    Attributes:
        hexa_skill_id (str): HEXA 스킬 명
    """
    hexa_skill_id: str


class BattlePracticeCharacterHexaCoreEquipment(BaseModel):
    """
    연무장 입장 시 캐릭터 HEXA 매트릭스 코어 정보

    Attributes:
        hexa_core_name (str): 코어 명
        hexa_core_level (int):  코어 레벨
        hexa_core_type (str): 코어 타입
        linked_skill (list[BattlePracticeCharacterHexaLinkedSkill]): 연결된 스킬
    """
    hexa_core_name: str
    hexa_core_level: int
    hexa_core_type: str
    linked_skill: list[BattlePracticeCharacterHexaLinkedSkill]


class BattlePracticeCharacterHexaCoreObject(BaseModel):
    """
    연무장 입장 시 캐릭터 HEXA 매트릭스 정보

    Attributes:
        character_hexa_core_equipment (list[BattlePracticeCharacterHexaCoreEquipment]): HEXA 매트릭스 코어 정보
    """
    character_hexa_core_equipment: list[BattlePracticeCharacterHexaCoreEquipment]


class BattlePracticeCharacterHexaStatCore(BaseModel):
    """
    연무장 입장 시 캐릭터 HEXA 스탯 코어 정보

    Attributes:
        slot_id (str): 슬롯 인덱스
        main_stat_name (str): 메인 스탯 명
        sub_stat_name_1 (str): 첫 번째 서브 명
        sub_stat_name_2 (str): 두 번째 서브 명
        main_stat_level (int): 메인 스탯 레벨
        sub_stat_level_1 (int): 첫 번째 서브 레벨
        sub_stat_level_2 (int): 두 번째 서브 레벨
        stat_grade (int): 스탯 코어 등급
    """
    slot_id: str
    main_stat_name: str
    sub_stat_name_1: str
    sub_stat_name_2: str
    main_stat_level: int
    sub_stat_level_1: int
    sub_stat_level_2: int
    stat_grade: int


class BattlePracticeCharacterHexaMatrixStatObject(BaseModel):
    """
    연무장 입장 시 캐릭터 HEXA 스탯 정보

    Attributes:
        character_hexa_stat_core (list[BattlePracticeCharacterHexaStatCore]): HEXA 스탯 I 코어 정보
        character_hexa_stat_core_2 (list[BattlePracticeCharacterHexaStatCore]): HEXA 스탯 II 코어 정보
        character_hexa_stat_core_3 (list[BattlePracticeCharacterHexaStatCore]): HEXA 스탯 III 코어 정보
    """
    character_hexa_stat_core: list[BattlePracticeCharacterHexaStatCore]
    character_hexa_stat_core_2: list[BattlePracticeCharacterHexaStatCore]
    character_hexa_stat_core_3: list[BattlePracticeCharacterHexaStatCore]


class BattlePracticeCharacterHexaMatrixObject(BaseModel):
    """
    연무장 입장 시 캐릭터 HEXA 매트릭스 정보

    Attributes:
        hexa_core_object (BattlePracticeCharacterHexaCoreObject): HEXA 코어 정보
        hexa_matrix_stat_object (BattlePracticeCharacterHexaMatrixStatObject): HEXA 스탯 정보
    """
    hexa_core_object: BattlePracticeCharacterHexaCoreObject
    hexa_matrix_stat_object: BattlePracticeCharacterHexaMatrixStatObject


class BattlePracticeCharacterRingReserveSkillObject(BaseModel):
    """
    연무장 입장 시 캐릭터 예비 특수 반지 슬롯에 장착한 특수 반지 정보

    Attributes:
        special_ring_reserve_name (str or None): 예비 특수 반지 슬롯에 장착한 특수 반지
        special_ring_reserve_level (int or None): 예비 특수 반지 슬롯에 장착한 특수 반지 레벨
        special_ring_reserve_icon (str or None): 예비 특수 반지 슬롯에 장착한 특수 반지 아이콘
        special_ring_reserve_description (str or None): 예비 특수 반지 슬롯에 장착한 특수 반지 설명
    """
    special_ring_reserve_name: str | None
    special_ring_reserve_level: int | None
    special_ring_reserve_icon: str | None
    special_ring_reserve_description: str | None


class BattlePracticeUnionRaiderObject(BaseModel):
    """
    연무장 입장 시 유니온 공격대 정보

    Attributes:
        union_raider_stat (list[str]): 유니온 공격대원 효과
        union_occupied_stat (list[str]): 유니온 공격대 점령 효과
        union_state_stat (list[str]): 적용 중인 유니온 스탯 효과
    """
    union_raider_stat: list[str]
    union_occupied_stat: list[str]
    union_state_stat: list[str] = []

    @field_validator(
        'union_raider_stat',
        'union_occupied_stat',
        'union_state_stat',
        mode='before',
    )
    @classmethod
    def null_as_empty(cls, v):
        return v if v is not None else []


class BattlePracticeUnionArtifactEffect(BaseModel):
    """
    연무장 입장 시 유니온 아티팩트 효과 정보

    Attributes:
        name (str): 아티팩트 효과 명
        level (int): 아티팩트 효과 레벨
    """
    name: str
    level: int


class BattlePracticeUnionArtifactObject(BaseModel):
    """
    연무장 입장 시 유니온 아티팩트 정보

    Attributes:
        union_artifact_effect (list[BattlePracticeUnionArtifactEffect]): 아티팩트 효과 정보
    """
    union_artifact_effect: list[BattlePracticeUnionArtifactEffect]


class BattlePracticeUnionChampionBadge(BaseModel):
    """
    연무장 입장 시 유니온 챔피언 휘장 정보

    Attributes:
        stat (str): 유니온 챔피언 휘장 효과
    """
    stat: str


class BattlePracticeUnionChampionObject(BaseModel):
    """
    연무장 입장 시 유니온 챔피언 정보

    Attributes:
        champion_badge_total_info (list[BattlePracticeUnionChampionBadge]): 유니온 챔피언 휘장
    """
    champion_badge_total_info: list[BattlePracticeUnionChampionBadge]


class BattlePracticeGuildSkill(BaseModel):
    """
    연무장 입장 시 길드 스킬

    Attributes:
        skill_name (str): 스킬 명
        skill_description (str): 스킬 설명
        skill_level (int): 스킬 레벨
        skill_effect (str): 스킬 레벨별 효과
        skill_icon (str): 스킬 아이콘
    """
    skill_name: str
    skill_description: str
    skill_level: int
    skill_effect: str
    skill_icon: str


class BattlePracticeGuildObject(BaseModel):
    """
    연무장 입장 시 길드 정보

    Attributes:
        guild_skill (list[BattlePracticeGuildSkill]): 길드 스킬 목록
        guild_noblesse_skill (list[BattlePracticeGuildSkill]): 노블레스 스킬 목록
    """
    guild_skill: list[BattlePracticeGuildSkill]
    guild_noblesse_skill: list[BattlePracticeGuildSkill]


class BattlePracticeCharacterInfo(BaseModel):
    """
    연무장 입장 시 캐릭터 능력치 관련 정보

    Attributes:
        basic_object (BattlePracticeCharacterBasic or None): 캐릭터 기본 정보
        stat_object (BattlePracticeCharacterStat or None): 캐릭터 스탯 정보
        hyper_stat_object (BattlePracticeCharacterHyperStatObject or None): 캐릭터 하이퍼스탯 정보
        propensity_object (BattlePracticeCharacterPropensity or None): 캐릭터 성향 정보
        ability_object (BattlePracticeCharacterAbilityObject or None): 캐릭터 어빌리티 정보
        item_object (BattlePracticeCharacterItemObject or None): 캐릭터 장비 정보
        cash_item_object (BattlePracticeCharacterCashItemObject or None): 캐릭터 캐시 장비 정보
        pet_object (BattlePracticeCharacterPetObject or None): 캐릭터 펫 장비 정보
        skill_object (BattlePracticeCharacterSkillObject or None): 캐릭터 스킬 정보
        link_skill_object (BattlePracticeCharacterLinkSkillObject or None): 캐릭터 링크 스킬 정보
        v_matrix_object (BattlePracticeCharacterVMatrixObject or None): 캐릭터 V매트릭스 정보
        hexa_matrix_object (BattlePracticeCharacterHexaMatrixObject or None): 캐릭터 HEXA 매트릭스 정보
        ring_reserve_skill_object (BattlePracticeCharacterRingReserveSkillObject or None): 캐릭터 예비 특수 반지 장착 정보
        union_raider_object (BattlePracticeUnionRaiderObject or None): 유니온 공격대 정보
        union_artifact_object (BattlePracticeUnionArtifactObject or None): 유니온 아티팩트 정보
        union_champion_object (BattlePracticeUnionChampionObject or None): 유니온 챔피언 정보
        guild_object (BattlePracticeGuildObject or None): 길드 정보
    """
    basic_object: BattlePracticeCharacterBasic | None
    stat_object: BattlePracticeCharacterStat | None
    hyper_stat_object: BattlePracticeCharacterHyperStatObject | None
    propensity_object: BattlePracticeCharacterPropensity | None
    ability_object: BattlePracticeCharacterAbilityObject | None
    item_object: BattlePracticeCharacterItemObject | None
    cash_item_object: BattlePracticeCharacterCashItemObject | None
    pet_object: BattlePracticeCharacterPetObject | None
    skill_object: BattlePracticeCharacterSkillObject | None
    link_skill_object: BattlePracticeCharacterLinkSkillObject | None
    v_matrix_object: BattlePracticeCharacterVMatrixObject | None
    hexa_matrix_object: BattlePracticeCharacterHexaMatrixObject | None
    ring_reserve_skill_object: BattlePracticeCharacterRingReserveSkillObject | None
    union_raider_object: BattlePracticeUnionRaiderObject | None
    union_artifact_object: BattlePracticeUnionArtifactObject | None
    union_champion_object: BattlePracticeUnionChampionObject | None
    guild_object: BattlePracticeGuildObject | None
