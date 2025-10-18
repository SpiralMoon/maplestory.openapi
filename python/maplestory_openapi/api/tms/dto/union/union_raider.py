from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.union.union_raider import UnionRaiderBlockPosition as BaseUnionRaiderBlockPosition
from maplestory_openapi.api.common.dto.union.union_raider import UnionRaiderBlockControlPoint as BaseUnionRaiderBlockControlPoint
from maplestory_openapi.api.common.dto.union.union_raider import UnionRaiderBlock as BaseUnionRaiderBlock
from maplestory_openapi.api.common.dto.union.union_raider import UnionRaiderInnerStat as BaseUnionRaiderInnerStat
from maplestory_openapi.api.common.dto.union.union_raider import UnionRaiderPreset as BaseUnionRaiderPreset
from maplestory_openapi.api.common.dto.union.union_raider import UnionRaider as BaseUnionRaider


class UnionRaiderBlockPosition(BaseModel, BaseUnionRaiderBlockPosition):
    """
    方塊佔領區域的座標

    Attributes:
        x (int): 方塊 x 座標
        y (int): 方塊 y 座標
    """
    x: int
    y: int


class UnionRaiderBlockControlPoint(BaseModel, BaseUnionRaiderBlockControlPoint):
    """
    方塊基準點座標
    - 四個中央方塊的右下角為位置 x : 0, y : 0
    - 向左移動一格，x 減少 1
    - 向右移動一格，x 增加 1
    - 向下移動一格，y 減少 1
    - 向上移動一格，y 增加 1

    Attributes:
        x (int): 方塊基準點 x 座標
        y (int): 方塊基準點 y 座標
    """
    x: int
    y: int


class UnionRaiderBlock(BaseModel, BaseUnionRaiderBlock):
    """
    聯盟方塊資訊

    Attributes:
        block_type (str): 方塊編制 (戰士、法師、弓箭手、盜賊、海盜、混合)
        block_class (str): 方塊角色職業
        block_level (str): 方塊角色等級
        block_control_point (UnionRaiderBlockControlPoint): 方塊基準點座標
        block_position (list[UnionRaiderBlockPosition] or None): 方塊佔領區域的座標 (null：未部署時)
    """
    block_type: str
    block_class: str
    block_level: str
    block_control_point: UnionRaiderBlockControlPoint
    block_position: list[UnionRaiderBlockPosition] | None


class UnionRaiderInnerStat(BaseModel, BaseUnionRaiderInnerStat):
    """
    戰地攻擊隊部署

    Attributes:
        stat_field_id (str): 攻擊單位部署位置 (以 11 點鐘方向為起點，順時針 0-7)
        stat_field_effect (str): 相關區域佔領效果
    """
    stat_field_id: str
    stat_field_effect: str


class UnionRaiderPreset(BaseModel, BaseUnionRaiderPreset):
    """
    聯盟預設 資訊

    Attributes:
        union_raider_stat (list[str]): 戰地攻擊隊員效果
        union_occupied_stat (list[str]): 戰地攻擊隊佔領效果
        union_inner_stat (list[UnionRaiderInnerStat]): 戰地攻擊隊部署
        union_block (list[UnionRaiderBlock]): 聯盟方塊資訊
    """
    union_raider_stat: list[str]
    union_occupied_stat: list[str]
    union_inner_stat: list[UnionRaiderInnerStat]
    union_block: list[UnionRaiderBlock]


class UnionRaider(BaseModel, BaseUnionRaider):
    """
    戰地攻擊隊資訊

    Attributes:
        date (datetime or None): 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
        union_raider_stat (list[str]): 戰地攻擊隊員效果
        union_occupied_stat (list[str]): 戰地攻擊隊佔領效果
        union_inner_stat (list[UnionRaiderInnerStat]): 戰地攻擊隊部署
        union_block (list[UnionRaiderBlock]): 聯盟方塊資訊
        use_preset_no (int): 目前套用的預設編號
        union_raider_preset_1 (UnionRaiderPreset or None): 聯盟預設 1 資訊
        union_raider_preset_2 (UnionRaiderPreset or None): 聯盟預設 2 資訊
        union_raider_preset_3 (UnionRaiderPreset or None): 聯盟預設 3 資訊
        union_raider_preset_4 (UnionRaiderPreset or None): 聯盟預設 4 資訊
        union_raider_preset_5 (UnionRaiderPreset or None): 聯盟預設 5 資訊
    """
    date: datetime | None
    union_raider_stat: list[str]
    union_occupied_stat: list[str]
    union_inner_stat: list[UnionRaiderInnerStat]
    union_block: list[UnionRaiderBlock]
    use_preset_no: int
    union_raider_preset_1: UnionRaiderPreset | None
    union_raider_preset_2: UnionRaiderPreset | None
    union_raider_preset_3: UnionRaiderPreset | None
    union_raider_preset_4: UnionRaiderPreset | None
    union_raider_preset_5: UnionRaiderPreset | None
