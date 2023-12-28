from pydantic import BaseModel


class Character(BaseModel):
    """캐릭터 식별자(ocid)

    ocid(str): 캐릭터 식별자
    """
    ocid: str
