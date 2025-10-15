from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_item_equipment import CharacterItemEquipmentAddOption as BaseCharacterItemEquipmentAddOption
from maplestory_openapi.api.common.dto.character.character_item_equipment import CharacterItemEquipmentBaseOption as BaseCharacterItemEquipmentBaseOption
from maplestory_openapi.api.common.dto.character.character_item_equipment import CharacterItemEquipmentEtcOption as BaseCharacterItemEquipmentEtcOption
from maplestory_openapi.api.common.dto.character.character_item_equipment import CharacterItemEquipmentExceptionalOption as BaseCharacterItemEquipmentExceptionalOption
from maplestory_openapi.api.common.dto.character.character_item_equipment import CharacterItemEquipmentTotalOption as BaseCharacterItemEquipmentTotalOption
from maplestory_openapi.api.common.dto.character.character_item_equipment import CharacterItemEquipmentStarforceOption as BaseCharacterItemEquipmentStarforceOption
from maplestory_openapi.api.common.dto.character.character_item_equipment import CharacterItemEquipmentInfo as BaseCharacterItemEquipmentInfo
from maplestory_openapi.api.common.dto.character.character_item_equipment import CharacterItemEquipmentDragonInfo as BaseCharacterItemEquipmentDragonInfo
from maplestory_openapi.api.common.dto.character.character_item_equipment import CharacterItemEquipmentMechanicInfo as BaseCharacterItemEquipmentMechanicInfo
from maplestory_openapi.api.common.dto.character.character_item_equipment import CharacterItemEquipmentTitle as BaseCharacterItemEquipmentTitle
from maplestory_openapi.api.common.dto.character.character_item_equipment import CharacterItemEquipment as BaseCharacterItemEquipment

class CharacterItemEquipmentAddOption(BaseModel, BaseCharacterItemEquipmentAddOption):
    """
    캐릭터 장비 추가 옵션 정보

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
        boss_damage (str): 보스 몬스터 공격 시 데미지(%)
        damage (str): 데미지(%)
        all_stat (str): 올스탯(%)
        equipment_level_decrease (int): 장비 레벨 감소
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


class CharacterItemEquipmentBaseOption(BaseModel, BaseCharacterItemEquipmentBaseOption):
    """
    캐릭터 장비 기본 옵션 정보

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
        boss_damage (str): 보스 몬스터 공격 시 데미지(%)
        ignore_monster_armor (str): 몬스터방어율 무시(%)
        all_stat (str): 올스탯(%)
        max_hp_rate (str): 최대 HP(%)
        max_mp_rate (str): 최대 MP(%)
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


class CharacterItemEquipmentEtcOption(BaseModel, BaseCharacterItemEquipmentEtcOption):
    """
    캐릭터 장비 기타 옵션 정보

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


class CharacterItemEquipmentExceptionalOption(BaseModel, BaseCharacterItemEquipmentExceptionalOption):
    """
    캐릭터 장비 특별 옵션 정보

    Attributes:
        str(str): STR
        dex(str): DEX
        int(str): INT
        luk(str): LUK
        max_hp(str): 최대 HP
        max_mp(str): 최대 MP
        attack_power(str): 공격력
        magic_power(str): 마력
        exceptional_upgrade(int): 익셉셔널 강화 적용 횟수
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


class CharacterItemEquipmentTotalOption(BaseModel, BaseCharacterItemEquipmentTotalOption):
    """
    캐릭터 장비 최종 옵션 정보

    Attributes:
        str(str): STR
        int(str): INT
        dex(str): DEX
        luk(str): LUK
        max_hp(str): 최대 HP
        max_mp(str): 최대 MP
        attack_power(str): 공격력
        magic_power(str): 마력
        armor(str): 방어력
        speed(str): 이동속도
        jump(str): 점프력
        boss_damage(str): 보스 몬스터 공격 시 데미지(%)
        ignore_monster_armor(str): 몬스터방어율 무시(%)
        all_stat(str): 올스탯(%)
        damage(str): 데미지(%)
        max_hp_rate(str): 최대 HP(%)
        max_mp_rate(str): 최대 MP(%)
        equipment_level_decrease(int): 장비 레벨 감소
    """
    str: str
    int: str
    dex: str
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
    max_hp_rate: str
    max_mp_rate: str
    equipment_level_decrease: int


class CharacterItemEquipmentStarforceOption(BaseModel, BaseCharacterItemEquipmentStarforceOption):
    """
    캐릭터 장비 스타포스 옵션 정보

    Attributes:
        str(str): STR
        dex(str): DEX
        int(str): INT
        luk(str): LUK
        max_hp(str): 최대 HP
        max_mp(str): 최대 MP
        attack_power(str): 공격력
        magic_power(str): 마력
        armor(str): 방어력
        speed(str): 이동속도
        jump(str): 점프력
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


class CharacterItemEquipmentInfo(BaseModel, BaseCharacterItemEquipmentInfo):
    """
    캐릭터 장비 아이템 상세 정보

    Attributes:
        item_equipment_part(str): 장비 부위 명
        item_equipment_slot(str): 장비 슬롯 위치
        item_name(str): 장비 명
        item_icon(str): 장비 아이콘
        item_description(str or None): 장비 설명
        item_shape_name(str): 장비 외형
        item_shape_icon(str): 장비 외형 아이콘
        item_gender(str or None): 장비 전용 성별
        item_total_option(CharacterItemEquipmentTotalOption): 장비 최종 옵션
        item_base_option(CharacterItemEquipmentBaseOption): 장비 기본 옵션
        potential_option_flag(str or None): 잠재능력 봉인 여부 (true 봉인, false 봉인 없음)
        additional_potential_option_flag(str or None): 에디셔널 잠재능력 봉인 여부 (true 봉인, false 봉인 없음)
        potential_option_grade(str or None): 잠재능력 등급
        additional_potential_option_grade(str or None): 에디셔널 잠재능력 등급
        potential_option_1(str or None): 잠재능력 첫번째 옵션
        potential_option_2(str or None): 잠재능력 두번째 옵션
        potential_option_3(str or None): 잠재능력 세번째 옵션
        additional_potential_option_1(str or None): 에디셔널 잠재능력 첫번째 옵션
        additional_potential_option_2(str or None): 에디셔널 잠재능력 두번째 옵션
        additional_potential_option_3(str or None): 에디셔널 잠재능력 세번째 옵션
        equipment_level_increase(int): 장비 레벨 증가
        item_exceptional_option(CharacterItemEquipmentExceptionalOption): 장비 특별 옵션 정보
        item_add_option(CharacterItemEquipmentAddOption): 장비 추가 옵션
        growth_exp(int): 성장 경험치
        growth_level(int): 성장 레벨
        scroll_upgrade(str): 업그레이드 횟수
        cuttable_count(int): 가위 사용 가능 횟수 (교환 불가 장비, 가위 횟수가 없는 교환 가능 장비는 255)
        golden_hammer_flag(str): 황금 망치 재련 적용 (1:적용, 이외 미 적용)
        scroll_resilience_count(str): 복구 가능 횟수
        scroll_upgradeable_count(str): 업그레이드 가능 횟수
        soul_name(str or None): 소울 명
        soul_option(str or None): 소울 옵션
        item_etc_option(CharacterItemEquipmentEtcOption): 장비 기타 옵션
        starforce(str): 스타포스 강화 단계
        starforce_scroll_flag(str): 놀라운 장비 강화 주문서 사용 여부 (0:미사용, 1:사용)
        item_starforce_option(CharacterItemEquipmentStarforceOption): 장비 스타포스 옵션
        special_ring_level(int): 특수 반지 레벨
        date_expire(datetime or None): 장비 유효 기간
        is_expired(bool): 장비 유효 기간 만료 여부
        freestyle_flag(str or None): 프리스타일 쿠폰 적용 여부 (0:미적용, 1:적용)
    """
    item_equipment_part: str
    item_equipment_slot: str
    item_name: str
    item_icon: str
    item_description: str | None
    item_shape_name: str
    item_shape_icon: str
    item_gender: str | None
    item_total_option: CharacterItemEquipmentTotalOption
    item_base_option: CharacterItemEquipmentBaseOption
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
    item_exceptional_option: CharacterItemEquipmentExceptionalOption
    item_add_option: CharacterItemEquipmentAddOption
    growth_exp: int
    growth_level: int
    scroll_upgrade: str
    cuttable_count: int
    golden_hammer_flag: str
    scroll_resilience_count: str
    scroll_upgradeable_count: str
    soul_name: str | None
    soul_option: str | None
    item_etc_option: CharacterItemEquipmentEtcOption
    starforce: str
    starforce_scroll_flag: str
    item_starforce_option: CharacterItemEquipmentStarforceOption
    special_ring_level: int
    date_expire: datetime | None
    is_expired: bool = False
    freestyle_flag: str | None

    @property
    def is_freestyle_flag(self) -> bool:
        """
        프리스타일 쿠폰 적용 여부
        """
        return self.freestyle_flag == '1'


class CharacterItemEquipmentDragonInfo(BaseModel, BaseCharacterItemEquipmentDragonInfo):
    """
    에반 드래곤 장비 정보

    Attributes:
        item_equipment_part(str): 장비 부위 명
        item_equipment_slot(str): 장비 슬롯 위치
        item_name(str): 장비 명
        item_icon(str): 장비 아이콘
        item_description(str or None): 장비 설명
        item_shape_name(str): 장비 외형
        item_shape_icon(str): 장비 외형 아이콘
        item_gender(str or None): 장비 전용 성별
        item_total_option(CharacterItemEquipmentTotalOption): 장비 최종 옵션
        item_base_option(CharacterItemEquipmentBaseOption): 장비 기본 옵션
        equipment_level_increase(int): 장비 레벨 증가
        item_exceptional_option(CharacterItemEquipmentExceptionalOption): 장비 익셉셔널 옵션
        item_add_option(CharacterItemEquipmentAddOption): 장비 추가 옵션
        growth_exp(int): 성장 경험치
        growth_level(int): 성장 레벨
        scroll_upgrade(str): 업그레이드 횟수
        cuttable_count(int): 가위 사용 가능 횟수 (교환 불가 장비, 가위 횟수가 없는 교환 가능 장비는 255)
        golden_hammer_flag(str): 황금 망치 재련 적용 (1:적용, 이외 미 적용)
        scroll_resilience_count(str): 복구 가능 횟수
        scroll_upgradeable_count(str): 업그레이드 가능 횟수
        soul_name(str or None): 소울 명
        soul_option(str or None): 소울 옵션
        item_etc_option(CharacterItemEquipmentEtcOption): 장비 기타 옵션
        starforce(str): 스타포스 강화 단계
        starforce_scroll_flag(str): 놀라운 장비 강화 주문서 사용 여부 (0:미사용, 1:사용)
        item_starforce_option(CharacterItemEquipmentStarforceOption): 장비 스타포스 옵션
        special_ring_level(int): 특수 반지 레벨
        date_expire(datetime or None): 장비 유효 기간
        is_expired(bool): 장비 유효 기간 만료 여부
        freestyle_flag(str or None): 프리스타일 쿠폰 적용 여부 (0:미적용, 1:적용)
    """
    item_equipment_part: str
    item_equipment_slot: str
    item_name: str
    item_icon: str
    item_description: str | None
    item_shape_name: str
    item_shape_icon: str
    item_gender: str | None
    item_total_option: CharacterItemEquipmentTotalOption
    item_base_option: CharacterItemEquipmentBaseOption
    equipment_level_increase: int
    item_exceptional_option: CharacterItemEquipmentExceptionalOption
    item_add_option: CharacterItemEquipmentAddOption
    growth_exp: int
    growth_level: int
    scroll_upgrade: str
    cuttable_count: int
    golden_hammer_flag: str
    scroll_resilience_count: str
    scroll_upgradeable_count: str
    soul_name: str | None
    soul_option: str | None
    item_etc_option: CharacterItemEquipmentEtcOption
    starforce: str
    starforce_scroll_flag: str
    item_starforce_option: CharacterItemEquipmentStarforceOption
    special_ring_level: int
    date_expire: datetime | None
    is_expired: bool = False
    freestyle_flag: str | None

    @property
    def is_freestyle_flag(self) -> bool:
        """
        프리스타일 쿠폰 적용 여부
        """
        return self.freestyle_flag == '1'


class CharacterItemEquipmentMechanicInfo(BaseModel, BaseCharacterItemEquipmentMechanicInfo):
    """
    메카닉 장비 정보

    Attributes:
        item_equipment_part(str): 장비 부위 명
        item_equipment_slot(str): 장비 슬롯 위치
        item_name(str): 장비 명
        item_icon(str): 장비 아이콘
        item_description(str or None): 장비 설명
        item_shape_name(str): 장비 외형
        item_shape_icon(str): 장비 외형 아이콘
        item_gender(str or None): 장비 전용 성별
        item_total_option(CharacterItemEquipmentTotalOption): 장비 최종 옵션
        item_base_option(CharacterItemEquipmentBaseOption): 장비 기본 옵션
        equipment_level_increase(int): 장비 레벨 증가
        item_exceptional_option(CharacterItemEquipmentExceptionalOption): 장비 익셉셔널 옵션
        item_add_option(CharacterItemEquipmentAddOption): 장비 추가 옵션
        growth_exp(int): 성장 경험치
        growth_level(int): 성장 레벨
        scroll_upgrade(str): 업그레이드 횟수
        cuttable_count(int): 가위 사용 가능 횟수 (교환 불가 장비, 가위 횟수가 없는 교환 가능 장비는 255)
        golden_hammer_flag(str): 황금 망치 재련 적용 (1:적용, 이외 미 적용)
        scroll_resilience_count(str): 복구 가능 횟수
        scroll_upgradeable_count(str): 업그레이드 가능 횟수
        soul_name(str or None): 소울 명
        soul_option(str or None): 소울 옵션
        item_etc_option(CharacterItemEquipmentEtcOption): 장비 기타 옵션
        starforce(str): 스타포스 강화 단계
        starforce_scroll_flag(str): 놀라운 장비 강화 주문서 사용 여부 (0:미사용, 1:사용)
        item_starforce_option(CharacterItemEquipmentStarforceOption): 장비 스타포스 옵션
        special_ring_level(int): 특수 반지 레벨
        date_expire(datetime or None): 장비 유효 기간
        is_expired(bool): 장비 유효 기간 만료 여부
        freestyle_flag(str or None): 프리스타일 쿠폰 적용 여부 (0:미적용, 1:적용)
    """
    item_equipment_part: str
    item_equipment_slot: str
    item_name: str
    item_icon: str
    item_description: str | None
    item_shape_name: str
    item_shape_icon: str
    item_gender: str | None
    item_total_option: CharacterItemEquipmentTotalOption
    item_base_option: CharacterItemEquipmentBaseOption
    equipment_level_increase: int
    item_exceptional_option: CharacterItemEquipmentExceptionalOption
    item_add_option: CharacterItemEquipmentAddOption
    growth_exp: int
    growth_level: int
    scroll_upgrade: str
    cuttable_count: int
    golden_hammer_flag: str
    scroll_resilience_count: str
    scroll_upgradeable_count: str
    soul_name: str | None
    soul_option: str | None
    item_etc_option: CharacterItemEquipmentEtcOption
    starforce: str
    starforce_scroll_flag: str
    item_starforce_option: CharacterItemEquipmentStarforceOption
    special_ring_level: int
    date_expire: datetime | None
    is_expired: bool = False
    freestyle_flag: str | None

    @property
    def is_freestyle_flag(self) -> bool:
        """
        프리스타일 쿠폰 적용 여부
        """
        return self.freestyle_flag == '1'


class CharacterItemEquipmentTitle(BaseModel, BaseCharacterItemEquipmentTitle):
    """
    캐릭터 칭호 아이템 정보

    Attributes:
        title_name(str or None): 칭호 명
        title_icon(str or None): 칭호 아이콘
        title_description(str or None): 칭호 설명
        date_expire(datetime or None): 칭호 유효 기간
        is_expired(bool): 칭호 유효 기간 만료 여부
        date_option_expire(datetime or None): 칭호 옵션 유효 기간
        is_option_expired(bool): 칭호 옵션 유효 기간 만료 여부
        title_shape_name(str or None): 외형 설정에 등록한 칭호 장비 명
        title_shape_icon(str or None): 외형 설정에 등록한 칭호 아이콘
        title_shape_description(str or None): 외형 설정에 등록한 칭호 설명
    """
    title_name: str | None
    title_icon: str | None
    title_description: str | None
    date_expire: datetime | None
    is_expired: bool = False
    date_option_expire: datetime | None
    is_option_expired: bool = False
    title_shape_name: str | None
    title_shape_icon: str | None
    title_shape_description: str | None


class CharacterItemEquipmentMedalShape(BaseModel):
    """
    캐릭터 외형 설정에 등록한 훈장 외형 정보

    Attributes:
        medal_shape_name(str): 외형 설정에 등록한 훈장 장비 명
        medal_shape_icon(str): 외형 설정에 등록한 훈장 아이콘
        medal_shape_description(str): 외형 설정에 등록한 훈장 설명
        medal_shape_changed_name(str): 외형 설정에 등록한 훈장의 모루 적용 장비 명
        medal_shape_changed_icon(str): 외형 설정에 등록한 훈장의 모루 적용 아이콘
        medal_shape_changed_description(str): 외형 설정에 등록한 훈장의 모루 적용 훈장 설명
    """
    medal_shape_name: str
    medal_shape_icon: str
    medal_shape_description: str
    medal_shape_changed_name: str
    medal_shape_changed_icon: str
    medal_shape_changed_description: str


class CharacterItemEquipment(BaseModel, BaseCharacterItemEquipment):
    """
    캐릭터 장비 정보

    Attributes:
        date(datetime or None): 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        character_gender(str or None): 캐릭터 성별
        character_class(str or None): 캐릭터 직업
        preset_no(int or None): 적용 중인 장비 프리셋 번호
        item_equipment(list[CharacterItemEquipmentInfo]): 장비 정보
        item_equipment_preset_1(list[CharacterItemEquipmentInfo] or None): 1번 프리셋 장비 정보
        item_equipment_preset_2(list[CharacterItemEquipmentInfo] or None): 2번 프리셋 장비 정보
        item_equipment_preset_3(list[CharacterItemEquipmentInfo] or None): 3번 프리셋 장비 정보
        title(CharacterItemEquipmentTitle or None): 칭호 정보
        medal_shape(CharacterItemEquipmentMedalShape or None): 캐릭터 외형 설정에 등록한 훈장 외형 정보
        dragon_equipment(list[CharacterItemEquipmentInfo]): 에반 드래곤 장비 정보 (에반인 경우 응답)
        mechanic_equipment(list[CharacterItemEquipmentInfo]): 메카닉 장비 정보 (메카닉인 경우 응답)
    """
    date: datetime | None
    character_gender: str | None
    character_class: str | None
    preset_no: int | None
    item_equipment: list[CharacterItemEquipmentInfo]
    item_equipment_preset_1: list[CharacterItemEquipmentInfo] | None
    item_equipment_preset_2: list[CharacterItemEquipmentInfo] | None
    item_equipment_preset_3: list[CharacterItemEquipmentInfo] | None
    title: CharacterItemEquipmentTitle | None
    medal_shape: CharacterItemEquipmentMedalShape | None
    dragon_equipment: list[CharacterItemEquipmentDragonInfo]
    mechanic_equipment: list[CharacterItemEquipmentMechanicInfo]
