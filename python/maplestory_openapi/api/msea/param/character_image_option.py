from maplestory_openapi.api.common.enum.character_image import CharacterImageAction, CharacterImageEmotion, CharacterImageWeaponMotion
from maplestory_openapi.api.common.param.character_image_option import CharacterImageOption as BaseCharacterImageOption

class CharacterImageOption(BaseCharacterImageOption):
    """
    Attributes:
        action(str): Character action
        emotion(str): Character emotion
        wmotion(str): Character weapon motion
        action_frame(int): Character action frame
        emotion_frame(int): Character emotion frame
        width(int): Horizontal length (corresponding to the background size, 96 (default) ~ 1000)
        height(int): Vertical length (corresponding to the background size, 96 (default) ~ 1000)
        x(int or None): Horizontal coordinate of the character (coordinate range 0 < x < width, 0 is the left starting point)
        y(int or None): Vertical coordinate of the character (coordinate range 0 < y < height, 0 is the top starting point)
    """
    action: CharacterImageAction = CharacterImageAction.Stand1
    emotion: CharacterImageEmotion = CharacterImageEmotion.Default
    wmotion: CharacterImageWeaponMotion = CharacterImageWeaponMotion.Default
    action_frame: int = 0
    emotion_frame: int = 0
    width: int = 96
    height: int = 96
    x: int | None = None
    y: int | None = None
