from pydantic import BaseModel


class CharacterBasic(BaseModel):
    character_name: str
    world_name: str
    character_gender: str
    character_class: str
    character_level: int
    character_exp_rate: str
    character_guild_name: str
    character_image: str
