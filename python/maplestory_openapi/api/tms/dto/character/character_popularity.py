from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_popularity import CharacterPopularity as BaseCharacterPopularity


class CharacterPopularity(BaseModel, BaseCharacterPopularity):
    """
    角色名聲資訊

    Attributes:
        date (datetime or None): 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
        popularity (int): 角色名聲
    """
    date: datetime | None
    popularity: int
