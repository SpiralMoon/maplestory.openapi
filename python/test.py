import os

from maplestory_openapi.api.maplestory_api import MapleStoryApi
from dotenv import load_dotenv

load_dotenv()

api = MapleStoryApi(
    api_key=os.environ.get('NEXON_API_KEY'), timeout=5000)
ocid = api.get_character_id('아델')
# basic = api.get_character_basic(ocid)
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
link_skill = api.get_character_link_skill(ocid)

print(link_skill)
