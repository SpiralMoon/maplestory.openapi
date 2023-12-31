from datetime import datetime
import os

from maplestory_openapi.api.maplestory_api import MapleStoryApi
from dotenv import load_dotenv

load_dotenv()

api = MapleStoryApi(
    api_key=os.environ.get('NEXON_API_KEY'), timeout=5000)
character_name = '아델'
ocid = api.get_character_id(character_name).ocid
basic = api.get_character_basic(ocid)

# popularity = api.get_character_popularity(ocid)
# stat = api.get_character_stat(ocid)
# hyper_stat = api.get_character_hyper_stat(ocid)
# propensity = api.get_character_propensity(ocid)
# ability = api.get_character_ability(ocid)
# equipment = api.get_character_item_equipment(ocid)
# cash_equipment = api.get_character_cashitem_equipment(ocid)
# symbol = api.get_character_symbol_equipment(ocid)
# set_effect = api.get_character_set_effect(ocid)
# beauty_equipment = api.get_character_beauty_equipment(ocid)
# android_equipment = api.get_character_android_equipment(ocid)
# pet_equipment = api.get_character_pet_equipment(ocid)
# skill = api.get_character_skill(ocid, '6')
# link_skill = api.get_character_link_skill(ocid)
# vmatrix = api.get_character_vmatrix(ocid)
# hexamatrix = api.get_character_hexamatrix(ocid)
# hexamatrix_stat = api.get_character_hexamatrix_stat(ocid)
# dojang = api.get_character_dojang(ocid)
# union = api.get_union(ocid)
# union_radar = api.get_union_raider(ocid)

oguild_id = api.get_guild_id(
    guild_name=basic.character_guild_name, world_name=basic.world_name).oguild_id
# guild = api.get_guild_basic(oguild_id)

# cube_history = api.get_cube_history(
#     count=10, date=datetime(2023, 7, 16), cursor=None)
# cube_history_next = api.get_cube_history(
#     count=10, date=None, cursor=cube_history.next_cursor)
# starforce_history = api.get_starforce_history(
#     count=10, date=datetime(2023, 12, 28), cursor=None)
# starforce_history_next = api.get_starforce_history(
#     count=10, cursor=starforce_history.next_cursor)

# overall_ranking = api.get_overall_ranking()
# union_ranking = api.get_union_ranking()
# guild_ranking = api.get_guild_ranking(ranking_type=1)
# dojang_ranking = api.get_dojang_ranking()
# theseed_ranking = api.get_theseed_ranking()
# achievement_ranking = api.get_achievement_ranking()

print(basic)
