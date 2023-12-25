from datetime import datetime
from pydantic import BaseModel


class CharacterPopularity(BaseModel):
    date: datetime
    popularity: int
