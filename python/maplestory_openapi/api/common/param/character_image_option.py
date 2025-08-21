from pydantic import BaseModel

from maplestory_openapi.api.common.enum.character_image import CharacterImageAction, CharacterImageEmotion, CharacterImageWeaponMotion


class CharacterImageOption(BaseModel):
    action: CharacterImageAction
    emotion: CharacterImageEmotion
    wmotion: CharacterImageWeaponMotion
    action_frame: int
    emotion_frame: int
