from pydantic import BaseModel


class CharacterListAccountCharacter(BaseModel):
    """
    캐릭터 정보

    Attributes:
        ocid (str): 캐릭터 식별자
        character_name (str): 캐릭터 명
        world_name (str): 월드 명
        character_class (str): 캐릭터 직업
        character_level (int): 캐릭터 레벨
    """
    ocid: str
    character_name: str
    world_name: str
    character_class: str
    character_level: int


class CharacterListAccount(BaseModel):
    """
    메이플스토리 계정

    Attributes:
        account_id (str): 메이플스토리 계정 식별자
        character_list (list[CharacterListAccountCharacter]): 캐릭터 목록
    """
    account_id: str
    character_list: list[CharacterListAccountCharacter]


class CharacterList(BaseModel):
    """
    계정의 보유 캐릭터 목록

    Attributes:
        account_list (list[CharacterListAccount]): 메이플스토리 계정 목록
    """
    account_list: list[CharacterListAccount]
