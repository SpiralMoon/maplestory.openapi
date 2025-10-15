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
    Additional equipment options

    Attributes:
        str (str): STR
        dex (str): DEX
        int (str): INT
        luk (str): LUK
        max_hp (str): Max HP
        max_mp (str): Max MP
        attack_power (str): Attack Power
        magic_power (str): Magic ATT
        armor (str): Defense
        speed (str): Speed
        jump (str): Jump
        boss_damage (str): Boss Damage (%)
        damage (str): Damage (%)
        all_stat (str): All Stats (%)
        equipment_level_decrease (int): Equipment level decrease
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
    Basic equipment option information

    Attributes:
        str (str): STR
        dex (str): DEX
        int (str): INT
        luk (str): LUK
        max_hp (str): Max HP
        max_mp (str): Max MP
        attack_power (str): Attack Power
        magic_power (str): Magic ATT
        armor (str): Defense
        speed (str): Speed
        jump (str): Jump
        boss_damage (str): Boss Damage (%)
        ignore_monster_armor (str): Ignore Enemy Defense (%)
        all_stat (str): All Stats (%)
        max_hp_rate (str): Max HP (%)
        max_mp_rate (str): Max MP (%)
        base_equipment_level (int): Basic equipment level
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
    Miscellaneous equipment option information

    Attributes:
        str (str): STR
        dex (str): DEX
        int (str): INT
        luk (str): LUK
        max_hp (str): Max HP
        max_mp (str): Max MP
        attack_power (str): Attack Power
        magic_power (str): Magic ATT
        armor (str): Defense
        speed (str): Speed
        jump (str): Jump
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
    Exceptional equipment option information

    Attributes:
        str (str): STR
        dex (str): DEX
        int (str): INT
        luk (str): LUK
        max_hp (str): Max HP
        max_mp (str): Max MP
        attack_power (str): Attack Power
        magic_power (str): Magic ATT
        exceptional_upgrade (int): Number of exceptional boost applications
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
    Final equipment option information

    Attributes:
        str (str): STR
        int (str): INT
        dex (str): DEX
        luk (str): LUK
        max_hp (str): Max HP
        max_mp (str): Max MP
        attack_power (str): Attack Power
        magic_power (str): Magic ATT
        armor (str): Defense
        speed (str): Speed
        jump (str): Jump
        boss_damage (str): Boss Damage (%)
        ignore_monster_armor (str): Ignore Enemy Defense (%)
        all_stat (str): All Stats (%)
        damage (str): Damage (%)
        max_hp_rate (str): Max HP (%)
        max_mp_rate (str): Max MP (%)
        equipment_level_decrease (int): Equipment level decreases
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
    Equipment Star Force option information

    Attributes:
        str (str): STR
        dex (str): DEX
        int (str): INT
        luk (str): LUK
        max_hp (str): Max HP
        max_mp (str): Max MP
        attack_power (str): Attack Power
        magic_power (str): Magic ATT
        armor (str): Defense
        speed (str): Speed
        jump (str): Jump
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
    Equipment information

    Attributes:
        item_equipment_part (str): Equipment part name
        item_equipment_slot (str): Equipment slot position
        item_name (str): Equipment name
        item_icon (str): Equipment icon
        item_description (str or None): Equipment description
        item_shape_name (str): Equipment type
        item_shape_icon (str): Equipment type icon
        item_gender (str or None): Gender-specific equipment
        item_total_option (CharacterItemEquipmentTotalOption): Final equipment option information
        item_base_option (CharacterItemEquipmentBaseOption): Basic equipment option information
        potential_option_flag (str or None): Potential seal status (true:sealed, false:not sealed)
        additional_potential_option_flag (str or None): Additional potential seal status (true:sealed, false:not sealed)
        potential_option_grade (str or None): Potential grade
        additional_potential_option_grade (str or None): Additional potential grade
        potential_option_1 (str or None): First Potential option
        potential_option_2 (str or None): Second Potential option
        potential_option_3 (str or None): Third Potential option
        additional_potential_option_1 (str or None): First additional Potential option
        additional_potential_option_2 (str or None): Second additional Potential option
        additional_potential_option_3 (str or None): Third additional Potential option
        equipment_level_increase (int): Equipment level increase
        item_exceptional_option (CharacterItemEquipmentExceptionalOption): Exceptional equipment option information
        item_add_option (CharacterItemEquipmentAddOption): Additional equipment options
        growth_exp (int): Growth EXP
        growth_level (int): Growth level
        scroll_upgrade (str): Number of upgrade attempts
        cuttable_count (int): Number of scissors usage available (Untradable, 255 for equipment without scissors usage count)
        golden_hammer_flag (str): Golden Hammer refinement applied (true:applied, false:not applied)
        scroll_resilience_count (str): Number of restoration attempts available
        scroll_upgradeable_count (str): Number of upgrades available
        soul_name (str or None): Soul name
        soul_option (str or None): Soul option
        item_etc_option (CharacterItemEquipmentEtcOption): Miscellaneous equipment option information
        starforce (str): Enhancement level
        starforce_scroll_flag (str): Usage status of Miraculous Equip Enhancement Scroll (true:used, false:not used)
        item_starforce_option (CharacterItemEquipmentStarforceOption): Equipment Star Force option information
        special_ring_level (int): Special Skill Ring
        date_expire (datetime or None): Equipment expiration date (SGT)
        is_expired (bool or None): Whether the equipment is expired
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


class CharacterItemEquipmentDragonInfo(BaseModel, BaseCharacterItemEquipmentDragonInfo):
    """
    Even Dragon equipment information

    Attributes:
        item_equipment_part (str): Equipment part name
        item_equipment_slot (str): Equipment slot position
        item_name (str): Equipment name
        item_icon (str): Equipment icon
        item_description (str or None): Equipment description
        item_shape_name (str): Equipment type
        item_shape_icon (str): Equipment type icon
        item_gender (str or None): Gender-specific equipment
        item_total_option (CharacterItemEquipmentTotalOption): Final equipment option information
        item_base_option (CharacterItemEquipmentBaseOption): Basic equipment option information
        equipment_level_increase (int): Equipment level increases
        item_exceptional_option (CharacterItemEquipmentExceptionalOption): Exceptional equipment option information
        item_add_option (CharacterItemEquipmentAddOption): Additional equipment options
        growth_exp (int): Growth EXP
        growth_level (int): Growth level
        scroll_upgrade (str): Number of upgrades
        cuttable_count (int): Number of scissors usage available (Untradable, 255 for equipment without scissors usage count)
        golden_hammer_flag (str): Golden Hammer refinement applied (true: applied, false: not applied)
        scroll_resilience_count (str): Number of restoration attempts available
        scroll_upgradeable_count (str): Number of upgrades available
        soul_name (str or None): Soul name
        soul_option (str or None): Soul option
        item_etc_option (CharacterItemEquipmentEtcOption): Miscellaneous equipment option information
        starforce (str): Enhancement level
        starforce_scroll_flag (str): Usage status of Miraculous Equip Enhancement Scroll (true: used, false: not used)
        item_starforce_option (CharacterItemEquipmentExceptionalOption): Equipment Star Force option information
        special_ring_level (int): Special Skill Ring
        date_expire (datetime or None): Equipment expiration date (SGT)
        is_expired (bool): Whether the equipment is expired
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


class CharacterItemEquipmentMechanicInfo(BaseModel, BaseCharacterItemEquipmentMechanicInfo):
    """
    Mechanic equipment information

    Attributes:
        item_equipment_part (str): Equipment part name
        item_equipment_slot (str): Equipment slot position
        item_name (str): Equipment name
        item_icon (str): Equipment icon
        item_description (str or None): Equipment description
        item_shape_name (str): Equipment type
        item_shape_icon (str): Equipment type icon
        item_gender (str or None): Gender-specific equipment
        item_total_option (CharacterItemEquipmentTotalOption): Final equipment option information
        item_base_option (CharacterItemEquipmentBaseOption): Basic equipment option information
        equipment_level_increase (int): Equipment level increases
        item_exceptional_option (CharacterItemEquipmentExceptionalOption): Exceptional equipment option information
        item_add_option (CharacterItemEquipmentAddOption): Additional equipment options
        growth_exp (int): Growth EXP
        growth_level (int): Growth level
        scroll_upgrade (str): Number of upgrades
        cuttable_count (int): Number of scissors usage available (Untradable, 255 for equipment without scissors usage count)
        golden_hammer_flag (str): Golden Hammer refinement applied (true: applied, false: not applied)
        scroll_resilience_count (str): Number of restoration attempts available
        scroll_upgradeable_count (str): Number of upgrades available
        soul_name (str or None): Soul name
        soul_option (str or None): Soul option
        item_etc_option (CharacterItemEquipmentEtcOption): Miscellaneous equipment option information
        starforce (str): Enhancement level
        starforce_scroll_flag (str): Usage status of Miraculous Equip Enhancement Scroll (true: used, false: not used)
        item_starforce_option (CharacterItemEquipmentExceptionalOption): Equipment Star Force option information
        special_ring_level (int): Special Skill Ring
        date_expire (datetime or None): Equipment expiration date (SGT)
        is_expired (bool): Whether the equipment is expired
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


class CharacterItemEquipmentTitle(BaseModel, BaseCharacterItemEquipmentTitle):
    """
    Title information

    Attributes:
        title_name (str or None): Title name
        title_icon (str or None): Title icon
        title_description (str or None): Title description
        date_expire (datetime or None): Title validity period (SGT)
        is_expired (bool): Whether the title is expired
        date_option_expire (datetime or None): Title option validity period (expired:expired, null unlimited) (SGT)
        is_option_expired (bool): Whether the title option is expired
        title_shape_name (str or None): Title shape name
        title_shape_icon (str or None): Title shape icon
        title_shape_description (str or None): Title shape description
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


class CharacterItemEquipment(BaseModel, BaseCharacterItemEquipment):
    """
    Character equipped equipment information

    Attributes:
        date (datetime or None): Reference date for query (SGT, daily data with hours and minutes set to 0)
        character_gender (str or None): Character gender
        character_class (str or None): Character job
        preset_no (int or None): Active equipment preset number
        item_equipment (list[CharacterItemEquipmentInfo]): Equipment information
        item_equipment_preset_1 (list[CharacterItemEquipmentInfo] or None): Equipment information for Preset 1
        item_equipment_preset_2 (list[CharacterItemEquipmentInfo] or None): Equipment information for Preset 2
        item_equipment_preset_3 (list[CharacterItemEquipmentInfo] or None): Equipment information for Preset 3
        title (CharacterItemEquipmentTitle or None): Title information
        dragon_equipment (list[CharacterItemEquipmentDragonInfo]): Evan Dragon equipment information (response provided if the character is Evan)
        mechanic_equipment (list[CharacterItemEquipmentMechanicInfo]): Mechanic equipment information (response provided if the character is a Mechanic)
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
    dragon_equipment: list[CharacterItemEquipmentDragonInfo]
    mechanic_equipment: list[CharacterItemEquipmentMechanicInfo]
