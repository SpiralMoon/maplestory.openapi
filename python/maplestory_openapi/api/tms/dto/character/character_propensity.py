from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_propensity import CharacterPropensity as BaseCharacterPropensity


class CharacterPropensity(BaseModel, BaseCharacterPropensity):
    """
    角色性向資訊

    Attributes:
        date (datetime or None): 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
        charisma_level (int): 領導力等級
        sensibility_level (int): 感性等級
        insight_level (int): 洞察力等級
        willingness_level (int): 意志等級
        handicraft_level (int): 手藝等級
        charm_level (int): 魅力等級
    """
    date: datetime | None
    charisma_level: int
    sensibility_level: int
    insight_level: int
    willingness_level: int
    handicraft_level: int
    charm_level: int
