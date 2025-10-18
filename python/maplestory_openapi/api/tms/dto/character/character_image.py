from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_image import CharacterImage as BaseCharacterImage
from maplestory_openapi.api.common.dto.character.character_image import CharacterImageAction, CharacterImageEmotion, CharacterImageWeaponMotion


class CharacterImage(BaseModel, BaseCharacterImage):
    """
    角色外型圖片資訊

    Attributes:
        date (datetime or None): 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
        origin_url (str): 角色外型圖片原始 (URL)
        origin_image (str): 角色外型圖片原始 (base64)
        image (str): 角色外型圖片 (base64)
        action (CharacterImageAction): 角色動作
        emotion (CharacterImageEmotion): 角色表情
        wmotion (CharacterImageWeaponMotion): 角色武器動作
        action_frame (int or None): 角色動作影格
        emotion_frame (int or None): 角色表情影格
        width (int): 寬度 (對應背景大小，96 (預設) 至 1000)
        height (int): 高度 (對應背景大小，96 (預設) 至 1000)
        x (int or None): 角色的水平座標 (座標範圍 0 < x < 寬度，0 對應至最左起點)
        y (int or None): 角色的垂直座標 (座標範圍 0 < y < 高度，0 對應至最上方起點)
    """
    date: datetime | None
    origin_url: str
    origin_image: str
    image: str
    action: CharacterImageAction
    emotion: CharacterImageEmotion
    wmotion: CharacterImageWeaponMotion
    action_frame: int | None
    emotion_frame: int | None
    width: int
    height: int
    x: int | None
    y: int | None
