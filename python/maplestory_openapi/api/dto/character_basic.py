from pydantic import BaseModel


class CharacterBasic(BaseModel):
    """캐릭터 기본 정보

    character_name(str): 캐릭터 명
    world_name(str): 월드 명
    character_gender(str): 캐릭터 성별
    character_class(str): 캐릭터 직업
    character_class_level(str): 캐릭터 직업 차수
    character_level(int): 캐릭터 레벨
    character_exp(int): 현재 레벨에서 보유한 경험치
    character_exp_rate(str): 현재 레벨에서 경험치 퍼센트
    character_guild_name(str): 캐릭터 소속 길드 명
    character_image(str): 캐릭터 외형 이미지
    """
    character_name: str
    world_name: str
    character_gender: str
    character_class: str
    character_class_level: str
    character_level: int
    character_exp: int
    character_exp_rate: str
    character_guild_name: str
    character_image: str
