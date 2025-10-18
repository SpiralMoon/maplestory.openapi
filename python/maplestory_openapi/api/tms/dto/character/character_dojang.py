from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_dojang import CharacterDojang as BaseCharacterDojang


class CharacterDojang(BaseModel, BaseCharacterDojang):
    """
    角色在武陵道場的最高紀錄資訊

    Attributes:
        date (datetime or None): 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
        character_class (str or None): 角色職業
        world_name (str or None): 世界名稱
        dojang_best_floor (int or None): 武陵道場最高紀錄層數
        date_dojang_record (datetime or None): 達成武陵道場最高紀錄的日期 (TST，每日資料的小時與分鐘顯示為 0)
        dojang_best_time (int or None): 通關武陵道場最高樓層所花費的時間 (秒)
    """
    date: datetime | None
    character_class: str | None
    world_name: str | None
    dojang_best_floor: int | None
    date_dojang_record: datetime | None
    dojang_best_time: int | None
