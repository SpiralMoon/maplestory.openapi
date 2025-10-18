from maplestory_openapi.api.common.enum.character_image import CharacterImageAction, CharacterImageEmotion, CharacterImageWeaponMotion
from maplestory_openapi.api.common.param.character_image_option import CharacterImageOption as BaseCharacterImageOption

class CharacterImageOption(BaseCharacterImageOption):
    """
    Attributes:
        action(str): 角色動作
        emotion(str): 角色表情
        wmotion(str): 角色武器動作
        action_frame(int): 角色動作影格
        emotion_frame(int): 角色表情影格
        width(int): 寬度 (對應背景大小，96 (預設) 至 1000)
        height(int): 高度 (對應背景大小，96 (預設) 至 1000)
        x(int or None): 角色的水平座標 (座標範圍 0 < x < 寬度，0 對應至最左起點)
        y(int or None): 角色的垂直座標 (座標範圍 0 < y < 高度，0 對應至最上方起點)
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
