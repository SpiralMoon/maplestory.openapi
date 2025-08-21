from maplestory_openapi.api.common.enum.character_image import CharacterImageAction, CharacterImageEmotion, CharacterImageWeaponMotion
from maplestory_openapi.api.common.param.character_image_option import CharacterImageOption as BaseCharacterImageOption

class CharacterImageOption(BaseCharacterImageOption):
    """
    Attributes:
        action(str): 캐릭터 액션
        emotion(str): 캐릭터 감정표현
        wmotion(str): 캐릭터 무기 모션
        action_frame(int): 캐릭터 액션 프레임
        emotion_frame(int): 캐릭터 감정표현 프레임
    """
    action: CharacterImageAction = CharacterImageAction.Stand1
    emotion: CharacterImageEmotion = CharacterImageEmotion.Default
    wmotion: CharacterImageWeaponMotion = CharacterImageWeaponMotion.Default
    action_frame: int = 0
    emotion_frame: int = 0
