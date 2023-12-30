from pydantic import BaseModel


class TheSeedRankingInfo(BaseModel):
    """더 시드 랭킹 상세 정보

    date(str): 랭킹 업데이트 일자 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
    ranking(int): 더 시드 랭킹 순위
    character_name(str): 캐릭터 명
    world_name(str): 월드 명
    class_name(str): 직업 명
    sub_class_name(str): 전직 직업 명
    character_level(int): 캐릭터 레벨
    theseed_floor(int): 더 시드 층수
    theseed_time_record(int): 더 시드 클리어 시간 기록 (초 단위)
    """
    date: str
    ranking: int
    character_name: str
    world_name: str
    class_name: str
    sub_class_name: str
    character_level: int
    theseed_floor: int
    theseed_time_record: int


class TheSeedRanking(BaseModel):
    """더 시드 랭킹 정보

    ranking(list[TheSeedRankingInfo]): 더 시드 랭킹 정보
    """
    ranking: list[TheSeedRankingInfo]
