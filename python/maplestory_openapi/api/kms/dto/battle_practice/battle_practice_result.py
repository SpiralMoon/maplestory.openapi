from datetime import datetime
from pydantic import BaseModel


class BattlePracticeSkillStatistic(BaseModel):
    """
    연무장 스킬 단위 전투 분석 정보

    Attributes:
        skill_name (str): 스킬 명
        damage (int): 누적 데미지
        damage_percent (str): 데미지 점유율
        dps (int): 초당 평균 데미지
        use_count (int): 사용 횟수
        damage_per_use (int): 1회당 평균 데미지
        attack_count (int): 공격 횟수
        max_damage (int): 최대 데미지 (1타)
        min_damage (int): 최소 데미지 (1타)
    """
    skill_name: str
    damage: int
    damage_percent: str
    dps: int
    use_count: int
    damage_per_use: int
    attack_count: int
    max_damage: int
    min_damage: int


class BattlePracticeResult(BaseModel):
    """
    연무장 측정 결과 정보

    Attributes:
        register_date (datetime): 리플레이 등록 일시 (KST)
        total_play_time (int): 총 연무 시간 (ms)
        total_damage (int): 총합 데미지
        total_dps (int): 초당 평균 데미지
        end_type (str): 종료 타입 (1:자동 종료, 2:수동 종료, 3:시간 초과, 9:기타 종료)
        like_count (int): 리플레이 추천 수
        skill_statistic (list[BattlePracticeSkillStatistic]): 스킬 단위 전투 분석 정보
    """
    register_date: datetime
    total_play_time: int
    total_damage: int
    total_dps: int
    end_type: str
    like_count: int
    skill_statistic: list[BattlePracticeSkillStatistic]
