import os

from maplestory_openapi.api.maplestory_api import MapleStoryApi
from dotenv import load_dotenv

load_dotenv()

api = MapleStoryApi(
    api_key=os.environ.get('NEXON_API_KEY'), timeout=5000)
ocid = api.get_character_id('아델')
basic = api.get_character_basic(ocid)
ability = api.get_character_ability(ocid)
equipment = api.get_character_item_equipment(ocid)
symbol = api.get_character_symbol_equipment(ocid)

print(basic, ability, equipment, symbol)
