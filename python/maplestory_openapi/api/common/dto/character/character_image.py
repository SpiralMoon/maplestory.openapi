from datetime import datetime

from maplestory_openapi.api.common.enum.character_image import CharacterImageAction, CharacterImageEmotion, CharacterImageWeaponMotion


class CharacterImage:
    date: datetime | None
    origin_url: str
    origin_image: str
    image: str
    action: CharacterImageAction
    emotion: CharacterImageEmotion
    wmotion: CharacterImageWeaponMotion
    action_frame: int
    emotion_frame: int
    width: int
    height: int
    x: int | None
    y: int | None


