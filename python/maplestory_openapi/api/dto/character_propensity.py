from datetime import datetime
from pydantic import BaseModel


class CharacterPropensity(BaseModel):
    date: datetime
    charisma_level: int
    sensibility_level: int
    insight_level: int
    willingness_level: int
    handicraft_level: int
    charm_level: int
