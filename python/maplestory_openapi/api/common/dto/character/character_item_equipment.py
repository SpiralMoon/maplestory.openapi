from datetime import datetime
from pydantic import model_validator


class CharacterItemEquipmentAddOption:
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


class CharacterItemEquipmentBaseOption:
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


class CharacterItemEquipmentEtcOption:
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


class CharacterItemEquipmentExceptionalOption:
    str: str
    dex: str
    int: str
    luk: str
    max_hp: str
    max_mp: str
    attack_power: str
    magic_power: str
    exceptional_upgrade: int

    @model_validator(mode="before")
    @classmethod
    def set_default(cls, values):
        if values.get("exceptional_upgrade") is None:
            values["exceptional_upgrade"] = 0
        return values


class CharacterItemEquipmentTotalOption:
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


class CharacterItemEquipmentStarforceOption:
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


class CharacterItemEquipmentInfo:
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

    @model_validator(mode="before")
    @classmethod
    def set_default(cls, values):
        if values.get("date_expire") == 'expired':
            values["is_expired"] = True
            values["date_expire"] = None
        return values


class CharacterItemEquipmentDragonInfo:
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

    @model_validator(mode="before")
    @classmethod
    def set_default(cls, values):
        if values.get("date_expire") == 'expired':
            values["is_expired"] = True
            values["date_expire"] = None
        return values


class CharacterItemEquipmentMechanicInfo:
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

    @model_validator(mode="before")
    @classmethod
    def set_default(cls, values):
        if values.get("date_expire") == 'expired':
            values["is_expired"] = True
            values["date_expire"] = None
        return values


class CharacterItemEquipmentTitle:
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

    @model_validator(mode="before")
    @classmethod
    def set_default(cls, values):
        if values.get("date_expire") == 'expired':
            values["is_expired"] = True
            values["date_expire"] = None
        if values.get("date_option_expire") == 'expired':
            values["is_option_expired"] = True
            values["date_option_expire"] = None
        return values


class CharacterItemEquipment:
    date: datetime | None
    character_gender: str | None
    character_class: str | None
    preset_no: int | None
    item_equipment: list[CharacterItemEquipmentInfo]
    item_equipment_preset_1: list[CharacterItemEquipmentInfo] | None
    item_equipment_preset_2: list[CharacterItemEquipmentInfo] | None
    item_equipment_preset_3: list[CharacterItemEquipmentInfo] | None
    title: CharacterItemEquipmentTitle | None
    dragon_equipment: list[CharacterItemEquipmentDragonInfo]
    mechanic_equipment: list[CharacterItemEquipmentMechanicInfo]
