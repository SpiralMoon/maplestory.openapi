from pydantic import BaseModel


class DojangRankingInfo(BaseModel):
    """무릉도장 랭킹 상세 정보

    date(str): 랭킹 업데이트 일자 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
    ranking(int): 무릉도장 랭킹 순위
    character_name(str): 캐릭터 명
    world_name(str): 월드 명
    class_name(str): 직업 명
    sub_class_name(str): 전직 직업 명
    character_level(int): 캐릭터 레벨
    dojang_floor(int): 무릉도장 층수
    dojang_time_record(int): 무릉도장 클리어 시간 기록 (초 단위)
    """
    date: str
    ranking: int
    character_name: str
    world_name: str
    class_name: str
    sub_class_name: str
    character_level: int
    dojang_floor: int
    dojang_time_record: int


class DojangRanking(BaseModel):
    """무릉도장 랭킹 정보

    ranking(list[DojangRankingInfo]): 무릉도장 랭킹 정보
    """
    ranking: list[DojangRankingInfo]
