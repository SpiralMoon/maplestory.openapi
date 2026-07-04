from datetime import datetime
from pydantic import BaseModel, field_validator


class CharacterFamiliarInfoOption(BaseModel):
    """
    選項訊息

    Attributes:
        option_no (int): 選項號
        option_name (str): 選項名稱
        option_value (str): 選擇權價值
    """
    option_no: int
    option_name: str
    option_value: str


class CharacterFamiliarLinkSlot(BaseModel):
    """
    萌獸 鏈路插槽資訊

    Attributes:
        slot_id (str): 插槽標識符 (1~3, vip)
        familiar_name (str or None): 連結的 萌獸 名稱 (如果插槽中沒有任何關聯，則為 null)
        active_flag (str): 已啟用還是未啟用 (true, false)
        expire_date (datetime or None): 截止日期
    """
    slot_id: str
    familiar_name: str | None
    active_flag: str
    expire_date: datetime | None


class CharacterFamiliarInfo(BaseModel):
    """
    萌獸 細節

    Attributes:
        familiar_name (str): 萌獸 名稱
        familiar_nickname (str): 萌獸 暱稱
        familiar_special_flag (str): 特別與否
        familiar_state (str): 萌獸 情況
        familiar_level (int): 等級
        familiar_exp (int): 經驗
        skill_name (str or None): 具備的技能
        option_level (int): 選項等級
        option (list[CharacterFamiliarInfoOption]): 選項訊息
        familiar_grade (str): 等級
        look_name (str or None): 外觀名稱
        summoned_flag (str): 當前是否已被召喚
        slot_id (str): 連結槽索引 (1~3, vip, not link)
    """
    familiar_name: str
    familiar_nickname: str
    familiar_special_flag: str
    familiar_state: str
    familiar_level: int
    familiar_exp: int
    skill_name: str | None
    option_level: int
    option: list[CharacterFamiliarInfoOption]
    familiar_grade: str
    look_name: str | None
    summoned_flag: str
    slot_id: str

    @field_validator("option", mode="before")
    @classmethod
    def null_as_empty(cls, v):
        if v is None:
            return []
        return v


class CharacterFamiliar(BaseModel):
    """
    萌獸 資訊

    Attributes:
        date (datetime or None): 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
        familiar_link_slot (list[CharacterFamiliarLinkSlot]): 萌獸 鏈路插槽資訊
        familiar_info (list[CharacterFamiliarInfo]): 萌獸 細節
    """
    date: datetime | None
    familiar_link_slot: list[CharacterFamiliarLinkSlot]
    familiar_info: list[CharacterFamiliarInfo]

    @field_validator("familiar_link_slot", "familiar_info", mode="before")
    @classmethod
    def null_as_empty(cls, v):
        if v is None:
            return []
        return v
