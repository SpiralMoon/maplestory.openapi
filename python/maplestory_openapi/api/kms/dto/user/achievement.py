from pydantic import BaseModel


class AchievementAchieve(BaseModel):
    """
    달성 업적 정보

    Attributes:
        achievement_name (str): 업적 명
        achievement_description (str): 업적 설명
    """
    achievement_name: str
    achievement_description: str


class AchievementAccountList(BaseModel):
    """
    메이플스토리 계정

    Attributes:
        account_id (str): 메이플스토리 계정 식별자
        achievement_achieve (list[AchievementAchieve]): 달성 업적 정보
    """
    account_id: str
    achievement_achieve: list[AchievementAchieve]

class Achievement(BaseModel):
    """
    계정의 업적 목록

    Attributes:
        account_list (list[AchievementAccountList]): 메이플스토리 계정
    """
    account_list: list[AchievementAccountList]
