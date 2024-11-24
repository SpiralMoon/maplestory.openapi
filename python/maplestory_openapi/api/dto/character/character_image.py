from datetime import datetime
from pydantic import BaseModel
from enum import Enum

class CharacterImageAction(Enum):
    """
    캐릭터 액션
    """
    Stand1 = 'A00'
    Stand2 = 'A01'
    Walk1 = 'A02'
    Walk2 = 'A03'
    Prone = 'A04'
    Fly = 'A05'
    Jump = 'A06'
    Sit = 'A07'

class CharacterImageEmotion(Enum):
    """
    캐릭터 감정표현
    """
    Default = 'E00'
    Wink = 'E01'
    Smile = 'E02'
    Cry = 'E03'
    Angry = 'E04'
    Bewildered = 'E05'

class CharacterImageWeaponMotion(Enum):
    """
    캐릭터 무기 모션
    """
    Default = 'W00'
    OneHand = 'W01'
    TwoHands = 'W02'
    Gun = 'W03'

class CharacterImage(BaseModel):
    """캐릭터 기본 정보

    date(datetime): 조회 기준일 (KST)
    origin_url(str): 캐릭터 외형 이미지 원본 (URL)
    origin_image(str): 캐릭터 외형 기본 이미지 (base64)
    image(str): 캐릭터 외형 이미지 (base64)
    action(str): 캐릭터 액션
    emotion(str): 캐릭터 감정표현
    wmotion(str): 캐릭터 무기 모션
    width(int): 가로 길이. 배경 크기에 해당함, 96 (default) ~ 1000
    height(int): 세로 길이. 배경 크기에 해당함, 96 (default) ~ 1000
    x(int): 캐릭터의 가로 좌표
    y(int): 캐릭터의 세로 좌표
    """
    date: datetime | None
    origin_url: str
    origin_image: str
    image: str
    action: CharacterImageAction
    emotion: CharacterImageEmotion
    wmotion: CharacterImageWeaponMotion
    width: int
    height: int
    x: int | None
    y: int | None


