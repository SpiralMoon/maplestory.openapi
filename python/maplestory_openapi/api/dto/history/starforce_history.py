from datetime import datetime
from pydantic import BaseModel


class StarforcHistoryeEvent(BaseModel):
    success_rate: str
    cost_discount_rate: str
    plus_value: str
    starforce_event_range: str


class StarforceHistoryInfo(BaseModel):
    id: str
    item_upgrade_result: str
    before_starforce_count: int
    after_starforce_count: int
    starcatch_result: str
    superior_item_flag: str
    destroy_defence: str
    chance_time: str
    event_field_flag: str
    upgrade_item: str
    protect_shield: str
    bonus_stat_upgrade: str
    character_name: str
    world_name: str
    target_item: str
    date_create: datetime
    starforce_event_list: list[StarforcHistoryeEvent] | None


class StarforceHistory(BaseModel):
    count: int
    next_cursor: str | None
    starforce_history: list[StarforceHistoryInfo]
