from pydantic import BaseModel


class Guild(BaseModel):
    """
    길드 식별자 정보

    Attributes:
        oguild_id (str): 길드 식별자
    """
    oguild_id: str
