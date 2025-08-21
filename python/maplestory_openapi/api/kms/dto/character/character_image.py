from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_image import CharacterImage as BaseCharacterImage
from maplestory_openapi.api.common.dto.character.character_image import CharacterImageAction, CharacterImageEmotion, CharacterImageWeaponMotion


class CharacterImage(BaseModel, BaseCharacterImage):
    """
    캐릭터 기본 정보

    Attributes:
        date (datetime or None): 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        origin_url (str): 캐릭터 외형 이미지 원본 (URL)
        origin_image (str): 캐릭터 외형 기본 이미지 (base64)
        image (str): 캐릭터 외형 이미지 (base64)
        action (CharacterImageAction): 캐릭터 액션
        emotion (CharacterImageEmotion): 캐릭터 감정표현
        wmotion (CharacterImageWeaponMotion): 캐릭터 무기 모션
        action_frame (int): 캐릭터 액션 프레임
        emotion_frame (int): 캐릭터 감정표현 프레임
        width (int): 가로 길이. 배경 크기에 해당함
        height (int): 세로 길이. 배경 크기에 해당함
        x (int or None): 캐릭터의 가로 좌표
        y (int or None): 캐릭터의 세로 좌표
    """
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


