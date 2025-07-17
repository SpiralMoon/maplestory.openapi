from abc import ABC, abstractmethod
from datetime import datetime


class CharacterBasic(ABC):
    date: datetime | None
    character_name: str
    world_name: str
    character_gender: str
    character_class: str
    character_class_level: str
    character_level: int
    character_exp: int
    character_exp_rate: str
    character_guild_name: str | None
    character_image: str
    character_date_create: datetime
    access_flag: str
    liberation_quest_clear_flag: str

    @property
    @abstractmethod
    def is_access_flag(self) -> bool:
        pass
