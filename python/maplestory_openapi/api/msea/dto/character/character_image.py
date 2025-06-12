from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_image import CharacterImage as BaseCharacterImage
from maplestory_openapi.api.common.dto.character.character_image import CharacterImageAction, CharacterImageEmotion, CharacterImageWeaponMotion


class CharacterImage(BaseModel, BaseCharacterImage):
    """
    Character image information

    Attributes:
        date (datetime or None): Reference date for query (SGT, daily data with hours and minutes set to 0)
        origin_url (str): Character image original (URL)
        origin_image (str): Character image original (base64)
        image (str): Character image (base64)
        action (CharacterImageAction): Character action
        emotion (CharacterImageEmotion): Character emotion
        wmotion (CharacterImageWeaponMotion): Character weapon motion
        action_frame (int or None): Character action frame
        emotion_frame (int or None): Character emotion frame
        width (int): Horizontal length (corresponding to the background size, 96 (default) ~ 1000)
        height (int): Vertical length (corresponding to the background size, 96 (default) ~ 1000)
        x (int or None): Horizontal coordinate of the character
        y (int or None): Vertical coordinate of the character
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
