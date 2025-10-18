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
    附加道具選項

    Attributes:
        str (str): 力量 (STR)
        dex (str): 敏捷 (DEX)
        int (str): 智力 (INT)
        luk (str): 幸運 (LUK)
        max_hp (str): 最大體力 (HP)
        max_mp (str): 最大 MP
        attack_power (str): 攻擊力
        magic_power (str): 魔力
        armor (str): 防禦力
        speed (str): 移動速度
        jump (str): 跳躍力
        boss_damage (str): 對首領傷害增加 (%)
        damage (str): 傷害 (%)
        all_stat (str): 全部能力值 (%)
        equipment_level_decrease (int): 裝備等級減少
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
    道具基本選項資訊

    Attributes:
        str (str): 力量 (STR)
        dex (str): 敏捷 (DEX)
        int (str): 智力 (INT)
        luk (str): 幸運 (LUK)
        max_hp (str): 最大體力 (HP)
        max_mp (str): 最大 MP
        attack_power (str): 攻擊力
        magic_power (str): 魔力
        armor (str): 防禦力
        speed (str): 移動速度
        jump (str): 跳躍力
        boss_damage (str): 對首領傷害增加 (%)
        ignore_monster_armor (str): 無視怪物防禦力 (%)
        all_stat (str): 全部能力值 (%)
        max_hp_rate (str): 最大體力 (HP) (%)
        max_mp_rate (str): 最大 MP (%)
        base_equipment_level (int): 裝備基本等級
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
    道具其他選項資訊

    Attributes:
        str (str): 力量 (STR)
        dex (str): 敏捷 (DEX)
        int (str): 智力 (INT)
        luk (str): 幸運 (LUK)
        max_hp (str): 最大體力 (HP)
        max_mp (str): 最大 MP
        attack_power (str): 攻擊力
        magic_power (str): 魔力
        armor (str): 防禦力
        speed (str): 移動速度
        jump (str): 跳躍力
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
    道具特殊選項資訊

    Attributes:
        str (str): 力量 (STR)
        dex (str): 敏捷 (DEX)
        int (str): 智力 (INT)
        luk (str): 幸運 (LUK)
        max_hp (str): 最大體力 (HP)
        max_mp (str): 最大 MP
        attack_power (str): 攻擊力
        magic_power (str): 魔力
        exceptional_upgrade (int): 已套用的卓越強化次數
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
    道具最終選項資訊

    Attributes:
        str (str): 力量 (STR)
        int (str): 智力 (INT)
        dex (str): 敏捷 (DEX)
        luk (str): 幸運 (LUK)
        max_hp (str): 最大體力 (HP)
        max_mp (str): 最大 MP
        attack_power (str): 攻擊力
        magic_power (str): 魔力
        armor (str): 防禦力
        speed (str): 移動速度
        jump (str): 跳躍力
        boss_damage (str): 對首領傷害增加 (%)
        ignore_monster_armor (str): 無視怪物防禦力 (%)
        all_stat (str): 全部能力值 (%)
        damage (str): 傷害 (%)
        max_hp_rate (str): 最大體力 (HP) (%)
        max_mp_rate (str): 最大 MP (%)
        equipment_level_decrease (int): 裝備等級減少
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
    道具星星力量資訊

    Attributes:
        str (str): 力量 (STR)
        dex (str): 敏捷 (DEX)
        int (str): 智力 (INT)
        luk (str): 幸運 (LUK)
        max_hp (str): 最大體力 (HP)
        max_mp (str): 最大 MP
        attack_power (str): 攻擊力
        magic_power (str): 魔力
        armor (str): 防禦力
        speed (str): 移動速度
        jump (str): 跳躍力
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
    道具資訊

    Attributes:
        item_equipment_part (str): 道具部位名稱
        item_equipment_slot (str): 道具欄位位置
        item_name (str): 道具名稱
        item_icon (str): 道具圖示
        item_description (str or None): 道具描述
        item_shape_name (str): 道具外型
        item_shape_icon (str): 道具外型圖示
        item_gender (str or None): 性別限定
        item_total_option (CharacterItemEquipmentTotalOption): 道具最終選項資訊
        item_base_option (CharacterItemEquipmentBaseOption): 道具基本選項資訊
        potential_option_flag (str or None): 潛在能力封印狀態 (true：已封印，false：未封印)
        additional_potential_option_flag (str or None): 附加潛在能力封印狀態 (true：已封印，false：未封印)
        potential_option_grade (str or None): 潛在能力階級
        additional_potential_option_grade (str or None): 附加潛在能力階級
        potential_option_1 (str or None): 第一潛在能力選項
        potential_option_2 (str or None): 第二潛在能力選項
        potential_option_3 (str or None): 第三潛在能力選項
        additional_potential_option_1 (str or None): 第一附加潛在能力選項
        additional_potential_option_2 (str or None): 第二附加潛在能力選項
        additional_potential_option_3 (str or None): 第三附加潛在能力選項
        equipment_level_increase (int): 裝備等級增加
        item_exceptional_option (CharacterItemEquipmentExceptionalOption): 道具特殊選項資訊
        item_add_option (CharacterItemEquipmentAddOption): 附加道具選項
        growth_exp (int): 成長經驗值
        growth_level (int): 成長等級
        scroll_upgrade (str): 強化次數
        cuttable_count (int): 可使用剪刀的次數 (不可交易道具、可交易但從未使用剪刀的道具：255)
        golden_hammer_flag (str): 黃金鐵鎚精煉 (true：已套用，false：未套用)
        scroll_resilience_count (str): 道具可復原次數
        scroll_upgradeable_count (str): 道具可升級次數
        soul_name (str or None): 靈魂名稱
        soul_option (str or None): 靈魂選項
        item_etc_option (CharacterItemEquipmentEtcOption): 道具其他選項資訊
        starforce (str): 強化階級
        starforce_scroll_flag (str): 驚奇裝備強化卷軸 (true：已使用，false：未使用)
        item_starforce_option (CharacterItemEquipmentStarforceOption): 道具星星力量資訊
        special_ring_level (int): 特殊戒指等級
        date_expire (datetime or None): 道具有效期間 (TST)
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
    龍魔導士的龍道具資訊

    Attributes:
        item_equipment_part (str): 道具部位名稱
        item_equipment_slot (str): 道具欄位位置
        item_name (str): 道具名稱
        item_icon (str): 道具圖示
        item_description (str or None): 道具描述
        item_shape_name (str): 道具外型
        item_shape_icon (str): 道具外型圖示
        item_gender (str or None): 性別限定
        item_total_option (CharacterItemEquipmentTotalOption): 道具最終選項資訊
        item_base_option (CharacterItemEquipmentBaseOption): 道具基本選項資訊
        equipment_level_increase (int): 裝備等級增加
        item_exceptional_option (CharacterItemEquipmentExceptionalOption): 道具特殊選項資訊
        item_add_option (CharacterItemEquipmentAddOption): 附加道具選項
        growth_exp (int): 成長經驗值
        growth_level (int): 成長等級
        scroll_upgrade (str): 強化次數
        cuttable_count (int): 可使用剪刀的次數 (不可交易道具、可交易但從未使用剪刀的道具：255)
        golden_hammer_flag (str): 黃金鐵鎚精煉 (true：已套用，false：未套用)
        scroll_resilience_count (str): 道具可復原次數
        scroll_upgradeable_count (str): 道具可升級次數
        soul_name (str or None): 靈魂名稱
        soul_option (str or None): 靈魂選項
        item_etc_option (CharacterItemEquipmentEtcOption): 道具其他選項資訊
        starforce (str): 強化階級
        starforce_scroll_flag (str): 驚異道具強化卷軸 (true：已使用，false：未使用)
        item_starforce_option (CharacterItemEquipmentStarforceOption): 道具星星力量資訊
        special_ring_level (int): 特殊戒指等級
        date_expire (datetime or None): 道具有效期間 (TST)
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
    機甲戰神道具資訊

    Attributes:
        item_equipment_part (str): 道具部位名稱
        item_equipment_slot (str): 道具欄位位置
        item_name (str): 道具名稱
        item_icon (str): 道具圖示
        item_description (str or None): 道具描述
        item_shape_name (str): 道具外型
        item_shape_icon (str): 道具外型圖示
        item_gender (str or None): 性別限定
        item_total_option (CharacterItemEquipmentTotalOption): 道具最終選項資訊
        item_base_option (CharacterItemEquipmentBaseOption): 道具基本選項資訊
        equipment_level_increase (int): 裝備等級增加
        item_exceptional_option (CharacterItemEquipmentExceptionalOption): 道具特殊選項資訊
        item_add_option (CharacterItemEquipmentAddOption): 附加道具選項
        growth_exp (int): 成長經驗值
        growth_level (int): 成長等級
        scroll_upgrade (str): 強化次數
        cuttable_count (int): 可使用剪刀的次數 (不可交易道具、可交易但從未使用剪刀的道具：255)
        golden_hammer_flag (str): 黃金鐵鎚精煉 (true：已套用，false：未套用)
        scroll_resilience_count (str): 道具可復原次數
        scroll_upgradeable_count (str): 道具可升級次數
        soul_name (str or None): 靈魂名稱
        soul_option (str or None): 靈魂選項
        item_etc_option (CharacterItemEquipmentEtcOption): 道具其他選項資訊
        starforce (str): 強化階級
        starforce_scroll_flag (str): 驚異道具強化卷軸 (true：已使用，false：未使用)
        item_starforce_option (CharacterItemEquipmentStarforceOption): 道具星星力量資訊
        special_ring_level (int): 特殊戒指等級
        date_expire (datetime or None): 道具有效期間 (TST)
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
    稱號資訊

    Attributes:
        title_name (str or None): 稱號道具名稱
        title_icon (str or None): 稱號圖示
        title_description (str or None): 稱號描述
        date_expire (datetime or None): 稱號有效期間 (TST)
        is_expired (bool): Whether the title is expired
        date_option_expire (datetime or None): 稱號選項有效期間 (expired：已到期，null：無限期) (TST)
        is_option_expired (bool): Whether the title option is expired
        title_shape_name (str or None): 外型設定中已登錄稱號的道具名稱
        title_shape_icon (str or None): 外型設定中已登錄稱號的圖示
        title_shape_description (str or None): 外型設定中已登錄稱號的描述
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
    角色已裝備道具資訊

    Attributes:
        date (datetime or None): 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
        character_gender (str or None): 角色性別
        character_class (str or None): 角色職業
        preset_no (int or None): 目前套用的道具預設編號
        item_equipment (list[CharacterItemEquipmentInfo]): 道具資訊
        item_equipment_preset_1 (list[CharacterItemEquipmentInfo] or None): 預設 1 的道具資訊
        item_equipment_preset_2 (list[CharacterItemEquipmentInfo] or None): 預設 2 的道具資訊
        item_equipment_preset_3 (list[CharacterItemEquipmentInfo] or None): 預設 3 的道具資訊
        title (CharacterItemEquipmentTitle or None): 稱號資訊
        dragon_equipment (list[CharacterItemEquipmentDragonInfo]): 龍魔導士的龍道具資訊 (僅在龍魔導士時回應)
        mechanic_equipment (list[CharacterItemEquipmentMechanicInfo]): 機甲戰神道具資訊 (僅在機甲戰神時回應)
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
