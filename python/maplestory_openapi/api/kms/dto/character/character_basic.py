from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_basic import CharacterBasic as BaseCharacterBasic


class CharacterBasic(BaseModel, BaseCharacterBasic):
    """
    캐릭터 기본 정보

    Attributes:
        date (datetime or None): 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        character_name (str): 캐릭터 명
        world_name (str): 월드 명
        character_gender (str): 캐릭터 성별
        character_class (str): 캐릭터 직업
        character_class_level (str): 캐릭터 직업 차수
        character_level (int): 캐릭터 레벨
        character_exp (int): 현재 레벨에서 보유한 경험치
        character_exp_rate (str): 현재 레벨에서 경험치 퍼센트
        character_guild_name (str or None): 캐릭터 소속 길드 명
        character_image (str): 캐릭터 외형 이미지
        character_date_create (datetime): 캐릭터 생성일
        access_flag (str): 최근 7일간 접속 여부 (문자열 'true' 또는 'false')
        liberation_quest_clear (str): 해방 퀘스트 완료 여부 (0:미완료, 1:제네시스 무기 해방, 2:데스티니 무기 1차 해방)
    """

    date: datetime | None
    character_name: str
    world_name: str
    character_gender: str
    character_class: str
    character_class_level: str
    character_level: int
    character_exp: int
    character_exp_rate: str
    character_guild_name: str | None
    character_image: str
    character_date_create: datetime
    access_flag: str
    liberation_quest_clear: str

    @property
    def is_access_flag(self) -> bool:
        """
        최근 7일간 접속 여부
        """
        return self.access_flag == 'true'
