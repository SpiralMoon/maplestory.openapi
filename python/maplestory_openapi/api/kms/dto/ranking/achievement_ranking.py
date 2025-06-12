from pydantic import BaseModel


class AchievementRankingInfo(BaseModel):
    """업적 랭킹 상세 정보

    date(str): 랭킹 업데이트 일자 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
    ranking(int): 업적 랭킹 순위
    character_name(str): 캐릭터 명
    world_name(str): 월드 명
    class_name(str): 직업 명
    sub_class_name(str): 전직 직업 명
    trophy_grade(str): 업적 등급
    trophy_score(int): 업적 점수
    """
    date: str
    ranking: int
    character_name: str
    world_name: str
    class_name: str
    sub_class_name: str
    trophy_grade: str
    trophy_score: int


class AchievementRanking(BaseModel):
    """업적 랭킹 정보

    ranking(list[AchievementRankingInfo]): 업적 랭킹 정보
    """
    ranking: list[AchievementRankingInfo]
