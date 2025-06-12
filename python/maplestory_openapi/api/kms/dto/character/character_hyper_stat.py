from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_hyper_stat import CharacterHyperStatPreset as BaseCharacterHyperStatPreset
from maplestory_openapi.api.common.dto.character.character_hyper_stat import CharacterHyperStat as BaseCharacterHyperStat


class CharacterHyperStatPreset(BaseModel, BaseCharacterHyperStatPreset):
    """
    캐릭터 하이퍼스탯 프리셋 정보

    Attributes:
        stat_type (str): 스탯 종류
        stat_point (int or None): 스탯 투자 포인트
        stat_level (int or None): 스탯 레벨
        stat_increase (str or None): 스탯 상승량
    """
    stat_type: str
    stat_point: int | None
    stat_level: int | None
    stat_increase: str | None


class CharacterHyperStat(BaseModel, BaseCharacterHyperStat):
    """
    캐릭터 하이퍼스탯 정보

    Attributes:
        date (datetime or None): 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        character_class (str or None): 캐릭터 직업
        use_preset_no (str or None): 적용 중인 프리셋 번호
        use_available_hyper_stat (int or None): 사용 가능한 최대 하이퍼스탯 포인트
        hyper_stat_preset_1 (list[CharacterHyperStatPreset]): 프리셋 1번 하이퍼 스탯 정보
        hyper_stat_preset_1_remain_point (int or None): 프리셋 1번 하이퍼 스탯 잔여 포인트
        hyper_stat_preset_2 (list[CharacterHyperStatPreset]): 프리셋 2번 하이퍼 스탯 정보
        hyper_stat_preset_2_remain_point (int or None): 프리셋 2번 하이퍼 스탯 잔여 포인트
        hyper_stat_preset_3 (list[CharacterHyperStatPreset]): 프리셋 3번 하이퍼 스탯 정보
        hyper_stat_preset_3_remain_point (int or None): 프리셋 3번 하이퍼 스탯 잔여 포인트
    """
    date: datetime | None
    character_class: str | None
    use_preset_no: str | None
    use_available_hyper_stat: int | None
    hyper_stat_preset_1: list[CharacterHyperStatPreset]
    hyper_stat_preset_1_remain_point: int | None
    hyper_stat_preset_2: list[CharacterHyperStatPreset]
    hyper_stat_preset_2_remain_point: int | None
    hyper_stat_preset_3: list[CharacterHyperStatPreset]
    hyper_stat_preset_3_remain_point: int | None
