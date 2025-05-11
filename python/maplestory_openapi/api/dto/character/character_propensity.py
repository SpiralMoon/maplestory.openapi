from datetime import datetime
from pydantic import BaseModel


class CharacterPropensity(BaseModel):
    """캐릭터 성향 정보

    date(datetime): 조회 기준일
    charisma_level(int): 카리스마 레벨
    sensibility_level(int): 감성 레벨
    insight_level(int): 통찰력 레벨
    willingness_level(int): 의지 레벨
    handicraft_level(int): 손재주 레벨
    charm_level(int): 매력 레벨
    """
    date: datetime | None
    charisma_level: int | None
    sensibility_level: int | None
    insight_level: int | None
    willingness_level: int | None
    handicraft_level: int | None
    charm_level: int | None
