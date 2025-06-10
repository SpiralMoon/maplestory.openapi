from pydantic import BaseModel


class OverallRankingInfo(BaseModel):
    """종합 랭킹 상세 정보

    date(str): 랭킹 업데이트 일자 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
    ranking(int): 종합 랭킹 순위
    character_name(str): 캐릭터 명
    world_name(str): 월드 명
    class_name(str): 직업 명
    sub_class_name(str): 전직 직업 명
    character_level(int): 캐릭터 레벨
    character_exp(int): 캐릭터 경험치
    character_popularity(int): 캐릭터 인기도
    character_guildname(str): 길드 명
    """
    date: str
    ranking: int
    character_name: str
    world_name: str
    class_name: str
    sub_class_name: str
    character_level: int
    character_exp: int
    character_popularity: int
    character_guildname: str | None


class OverallRanking(BaseModel):
    """종합 랭킹 정보

    ranking(list[OverallRankingInfo]): 종합 랭킹 정보
    """
    ranking: list[OverallRankingInfo]
