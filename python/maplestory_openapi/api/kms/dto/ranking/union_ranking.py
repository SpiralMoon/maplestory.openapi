from pydantic import BaseModel


class UnionRankingInfo(BaseModel):
    """유니온 랭킹 상세 정보

    date(str): 랭킹 업데이트 일자 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
    ranking(int): 유니온 랭킹 순위
    character_name(str): 캐릭터 명
    world_name(str): 월드 명
    class_name(str): 직업 명
    sub_class_name(str): 전직 직업 명
    union_level(int): 유니온 레벨
    union_power(int): 유니온 파워
    """
    date: str
    ranking: int
    character_name: str
    world_name: str
    class_name: str
    sub_class_name: str
    union_level: int
    union_power: int


class UnionRanking(BaseModel):
    """유니온 랭킹 정보

    ranking(list[UnionRankingInfo]): 유니온 랭킹 정보
    """
    ranking: list[UnionRankingInfo]
