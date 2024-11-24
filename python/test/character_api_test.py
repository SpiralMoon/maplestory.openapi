import os
import sys
import unittest

sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '../')))

from maplestory_openapi import MapleStoryApi

api_key = os.environ['API_KEY']  # Your API Key
api = MapleStoryApi(api_key)

ocid = 'e0a4f439e53c369866b55297d2f5f4eb'


# 캐릭터 정보 조회
class CharacterApi(unittest.TestCase):
    def test_character(self):
        nickname = '아델'
        response = api.get_character_id(nickname)
        print(response)

    def test_character_list(self):
        response = api.get_character_list()
        print(response)

    def test_character_basic(self):
        response = api.get_character_basic(ocid)
        print(response)

    def test_character_image(self):
        response = api.get_character_image(ocid)
        print(response)

    def test_character_popularity(self):
        response = api.get_character_popularity(ocid)
        print(response)

    def test_character_stat(self):
        response = api.get_character_stat(ocid)
        print(response)

    def test_character_hyper_stat(self):
        response = api.get_character_hyper_stat(ocid)
        print(response)

    def test_character_propensity(self):
        response = api.get_character_propensity(ocid)
        print(response)

    def test_character_ability(self):
        response = api.get_character_ability(ocid)
        print(response)

    def test_character_item_equipment(self):
        response = api.get_character_item_equipment(ocid)
        print(response)

    def test_character_cashitem_equipment(self):
        response = api.get_character_cashitem_equipment(ocid)
        print(response)

    def test_character_symbol_equipment(self):
        response = api.get_character_symbol_equipment(ocid)
        print(response)

    def test_character_set_effect(self):
        response = api.get_character_set_effect(ocid)
        print(response)

    def test_character_beauty_equipment(self):
        response = api.get_character_beauty_equipment(ocid)
        print(response)

    def test_character_android_equipment(self):
        response = api.get_character_android_equipment(ocid)
        print(response)

    def test_character_pet_equipment(self):
        response = api.get_character_pet_equipment(ocid)
        print(response)

    def test_character_skill(self):
        skill_grade = '0'
        response = api.get_character_skill(ocid, skill_grade)
        print(response)

    def test_character_link_skill(self):
        response = api.get_character_link_skill(ocid)
        print(response)

    def test_character_v_matrix(self):
        response = api.get_character_vmatrix(ocid)
        print(response)

    def test_character_hexa_matrix(self):
        response = api.get_character_hexamatrix(ocid)
        print(response)

    def test_character_hexa_matrix_stat(self):
        response = api.get_character_hexamatrix_stat(ocid)
        print(response)

    def test_character_dojang(self):
        response = api.get_character_dojang(ocid)
        print(response)


if __name__ == '__main__':
    unittest.main()
