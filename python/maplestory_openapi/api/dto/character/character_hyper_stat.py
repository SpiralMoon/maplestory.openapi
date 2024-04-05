from datetime import datetime
from pydantic import BaseModel


class CharacterHyperStatPreset(BaseModel):
    """캐릭터 하이퍼스탯 프리셋 정보

    stat_type(str): 스탯 종류
    stat_point(int): 스탯 투자 포인트
    stat_level(int): 스탯 레벨
    stat_increase(str): 스탯 상승량
    """
    stat_type: str
    stat_point: int | None
    stat_level: int | None
    stat_increase: str | None


class CharacterHyperStat(BaseModel):
    """캐릭터 하이퍼스탯 정보

    date(datetime): 조회 기준일
    character_class(str): 캐릭터 직업
    use_preset_no(str): 적용 중인 프리셋 번호
    use_available_hyper_stat(int): 사용 가능한 최대 하이퍼스탯 포인트
    hyper_stat_preset_1(list[CharacterHyperStatPreset]): 프리셋 1번 하이퍼 스탯 정보
    hyper_stat_preset_1_remain_point(int): 프리셋 1번 하이퍼 스탯 잔여 포인트
    hyper_stat_preset_2(list[CharacterHyperStatPreset]): 프리셋 2번 하이퍼 스탯 정보
    hyper_stat_preset_2_remain_point(int): 프리셋 2번 하이퍼 스탯 잔여 포인트
    hyper_stat_preset_3(list[CharacterHyperStatPreset]): 프리셋 3번 하이퍼 스탯 정보
    hyper_stat_preset_3_remain_point(int): 프리셋 3번 하이퍼 스탯 잔여 포인트
    """
    date: datetime | None
    character_class: str
    use_preset_no: str
    use_available_hyper_stat: int
    hyper_stat_preset_1: list[CharacterHyperStatPreset]
    hyper_stat_preset_1_remain_point: int
    hyper_stat_preset_2: list[CharacterHyperStatPreset]
    hyper_stat_preset_2_remain_point: int
    hyper_stat_preset_3: list[CharacterHyperStatPreset]
    hyper_stat_preset_3_remain_point: int
