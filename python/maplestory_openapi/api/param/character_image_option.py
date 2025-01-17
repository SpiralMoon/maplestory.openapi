from pydantic import BaseModel

from maplestory_openapi.api.dto.character.character_image import CharacterImageAction, CharacterImageEmotion, CharacterImageWeaponMotion


class CharacterImageOption(BaseModel):
    """캐릭터 외형 이미지 파라미터

    action(str): 캐릭터 액션
    emotion(str): 캐릭터 감정표현
    wmotion(str): 캐릭터 무기 모션
    action_frame(int): 캐릭터 액션 프레임
    emotion_frame(int): 캐릭터 감정표현 프레임
    width(int): 가로 길이. 배경 크기에 해당함, 96 (default) ~ 1000
    height(int): 세로 길이. 배경 크기에 해당함, 96 (default) ~ 1000
    x(int): 캐릭터의 가로 좌표
    y(int): 캐릭터의 세로 좌표
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
