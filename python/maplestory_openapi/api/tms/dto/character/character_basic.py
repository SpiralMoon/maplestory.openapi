from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_basic import CharacterBasic as BaseCharacterBasic


class CharacterBasic(BaseModel, BaseCharacterBasic):
    """
    角色基本資訊

    Attributes:
        date (datetime or None): 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
        character_name (str): 角色名稱
        world_name (str): 世界名稱
        character_gender (str): 角色性別
        character_class (str): 角色職業
        character_class_level (str): 角色轉職次數
        character_level (int): 角色等級
        character_exp (int): 當前等級的經驗值
        character_exp_rate (str): 當前等級的經驗值百分比
        character_guild_name (str or None): 角色所屬公會的名稱
        character_image (str): 角色外型圖片
        character_date_create (datetime): 角色建立日期 (TST，每日資料中的小時與分鐘將顯示為 0)
        access_flag (str): 過去 7 天的登入狀態 (true：已登入，false：未登入)
        liberation_quest_clear (str): 解放任務完成狀態 (0：未完成，1：創世武器已解放)
    """

    date: datetime | None
    character_name: str
    world_name: str
    character_gender: str
    character_class: str
    character_class_level: str
    character_level: int
    character_exp: int
    character_exp_rate: str
    character_guild_name: str | None
    character_image: str
    character_date_create: datetime
    access_flag: str
    liberation_quest_clear: str

    @property
    def is_access_flag(self) -> bool:
        """
        過去 7 天的登入狀態 (true：已登入，false：未登入)
        """
        return self.access_flag == 'true'
