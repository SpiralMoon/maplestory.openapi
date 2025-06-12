from pydantic import BaseModel


class GuildRankingInfo(BaseModel):
    """유니온 랭킹 상세 정보

    date(str): 랭킹 업데이트 일자 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
    ranking(int): 길드 랭킹 순위
    guild_name(str): 길드 명
    world_name(str): 월드 명
    guild_level(int): 길드 레벨
    guild_master_name(str): 길드 마스터 캐릭터 명
    guild_mark(str): 길드 마크
    guild_point(int): 길드 포인트
    """
    date: str
    ranking: int
    guild_name: str
    world_name: str
    guild_level: int
    guild_master_name: str
    guild_mark: str
    guild_point: int


class GuildRanking(BaseModel):
    """길드 랭킹 정보

    ranking(list[GuildRankingInfo]): 길드 랭킹 정보
    """
    ranking: list[GuildRankingInfo]
