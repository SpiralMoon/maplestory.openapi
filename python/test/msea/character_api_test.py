import os
import sys
import unittest
import pytest

from datetime import datetime
from dotenv import load_dotenv

sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '../')))

from maplestory_openapi.api.common import MapleStoryApiException
from maplestory_openapi.api.common.enum import CharacterImageAction, CharacterImageEmotion, CharacterImageWeaponMotion
from maplestory_openapi.api.msea import MapleStoryApi
from maplestory_openapi.api.msea.param.character_image_option import CharacterImageOption

load_dotenv()

api_key = os.environ['API_KEY_MSEA'] # Your API Key
api = MapleStoryApi(api_key)

ocid = 'caee7cf6ec6cb067c33b899f2779f3d1'

# Character Information Retrieval

class TestGetCharacter(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character(self):
        nickname = 'Arid'
        response = await api.get_character_id(nickname)
        print(response)

    async def test_fail_get_character_with_invalid_name_throw_OPENAPI00004(self):
        invalid_nickname = 'invalid_nickname_123_'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_id(invalid_nickname)
        assert e.value.error_code == 'OPENAPI00004'
        print(e.value.error_code, e.value.message)


class TestGetCharacterBasic(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_basic(self):
        response = await api.get_character_basic(ocid)
        assert response is not None
        print(response)

    async def test_success_get_character_basic_with_date(self):
        response = await api.get_character_basic(ocid, date=datetime(2025, 4, 20))
        assert response is not None
        print(response)

    async def test_fail_get_character_basic_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_basic(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_basic_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_basic(ocid, date=datetime(2025, 4, 19))
        assert 'You can only retrieve data after 2025-04-20' in str(e.value)
        print(e.value)


class TestGetCharacterImage(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_image(self):
        response = await api.get_character_image(ocid)
        assert response is not None
        print(response)

    async def test_success_get_character_image_with_options(self):
        response = await api.get_character_image(
            ocid,
            option=CharacterImageOption(
                action=CharacterImageAction.Jump,
                action_frame=0,
                emotion=CharacterImageEmotion.Chu,
                emotion_frame=0,
                wmotion=CharacterImageWeaponMotion.Nothing
            )
        )
        assert response is not None
        print(response)

    async def test_success_get_character_image_with_date(self):
        response = await api.get_character_image(ocid, date=datetime(2025, 4, 20))
        assert response is not None
        print(response)

    async def test_fail_get_character_image_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_image(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_image_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_image(ocid, date=datetime(2025, 4, 19))
        assert 'You can only retrieve data after 2025-04-20' in str(e.value)
        print(e.value)


class TestGetCharacterPopularity(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_popularity(self):
        response = await api.get_character_popularity(ocid)
        assert response is not None
        print(response)

    async def test_success_get_character_popularity_with_date(self):
        response = await api.get_character_popularity(ocid, date=datetime(2025, 4, 20))
        assert response is not None
        print(response)

    async def test_fail_get_character_popularity_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_popularity(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_popularity_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_popularity(ocid, date=datetime(2025, 4, 19))
        assert 'You can only retrieve data after 2025-04-20' in str(e.value)
        print(e.value)


class TestGetCharacterStat(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_stat(self):
        response = await api.get_character_stat(ocid)
        assert response is not None
        print(response)

    async def test_success_get_character_stat_with_date(self):
        response = await api.get_character_stat(ocid, date=datetime(2025, 4, 20))
        assert response is not None
        print(response)

    async def test_fail_get_character_stat_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_stat(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_stat_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_stat(ocid, date=datetime(2025, 4, 19))
        assert 'You can only retrieve data after 2025-04-20' in str(e.value)
        print(e.value)


class TestGetCharacterHyperStat(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_hyper_stat(self):
        response = await api.get_character_hyper_stat(ocid)
        assert response is not None
        print(response)

    async def test_success_get_character_hyper_stat_with_date(self):
        response = await api.get_character_hyper_stat(ocid, date=datetime(2025, 4, 20))
        assert response is not None
        print(response)

    async def test_fail_get_character_hyper_stat_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_hyper_stat(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_hyper_stat_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_hyper_stat(ocid, date=datetime(2025, 4, 19))
        assert 'You can only retrieve data after 2025-04-20' in str(e.value)
        print(e.value)


class TestGetCharacterPropensity(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_propensity(self):
        response = await api.get_character_propensity(ocid)
        assert response is not None
        print(response)

    async def test_success_get_character_propensity_with_date(self):
        response = await api.get_character_propensity(ocid, date=datetime(2025, 4, 20))
        assert response is not None
        print(response)

    async def test_fail_get_character_propensity_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_propensity(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_propensity_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_propensity(ocid, date=datetime(2025, 4, 19))
        assert 'You can only retrieve data after 2025-04-20' in str(e.value)
        print(e.value)


class TestGetCharacterAbility(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_ability(self):
        response = await api.get_character_ability(ocid)
        assert response is not None
        print(response)

    async def test_success_get_character_ability_with_date(self):
        response = await api.get_character_ability(ocid, date=datetime(2025, 4, 20))
        assert response is not None
        print(response)

    async def test_fail_get_character_ability_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_ability(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_ability_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_ability(ocid, date=datetime(2025, 4, 19))
        assert 'You can only retrieve data after 2025-04-20' in str(e.value)
        print(e.value)


class TestGetCharacterItemEquipment(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_item_equipment(self):
        response = await api.get_character_item_equipment(ocid)
        assert response is not None
        print(response)

    async def test_success_get_character_item_equipment_with_date(self):
        response = await api.get_character_item_equipment(ocid, date=datetime(2025, 4, 20))
        assert response is not None
        print(response)

    async def test_fail_get_character_item_equipment_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_item_equipment(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_item_equipment_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_item_equipment(ocid, date=datetime(2025, 4, 19))
        assert 'You can only retrieve data after 2025-04-20' in str(e.value)
        print(e.value)


class TestGetCharacterCashItemEquipment(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_cashitem_equipment(self):
        response = await api.get_character_cashitem_equipment(ocid)
        assert response is not None
        print(response)

    async def test_success_get_character_cashitem_equipment_with_date(self):
        response = await api.get_character_cashitem_equipment(ocid, date=datetime(2025, 4, 20))
        assert response is not None
        print(response)

    async def test_fail_get_character_cashitem_equipment_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_cashitem_equipment(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_cashitem_equipment_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_cashitem_equipment(ocid, date=datetime(2025, 4, 19))
        assert 'You can only retrieve data after 2025-04-20' in str(e.value)
        print(e.value)


class TestGetCharacterSymbolEquipment(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_symbol_equipment(self):
        response = await api.get_character_symbol_equipment(ocid)
        assert response is not None
        print(response)

    async def test_success_get_character_symbol_equipment_with_date(self):
        response = await api.get_character_symbol_equipment(ocid, date=datetime(2025, 4, 20))
        assert response is not None
        print(response)

    async def test_fail_get_character_symbol_equipment_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_symbol_equipment(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_symbol_equipment_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_symbol_equipment(ocid, date=datetime(2025, 4, 19))
        assert 'You can only retrieve data after 2025-04-20' in str(e.value)
        print(e.value)


class TestGetCharacterSetEffect(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_set_effect(self):
        response = await api.get_character_set_effect(ocid)
        # nothing to assert because some characters may not have set effects
        print(response)

    async def test_success_get_character_set_effect_with_date(self):
        response = await api.get_character_set_effect(ocid, date=datetime(2025, 4, 20))
        assert response is not None
        print(response)

    async def test_fail_get_character_set_effect_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_set_effect(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_set_effect_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_set_effect(ocid, date=datetime(2025, 4, 19))
        assert 'You can only retrieve data after 2025-04-20' in str(e.value)
        print(e.value)


class TestGetCharacterBeautyEquipment(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_beauty_equipment(self):
        response = await api.get_character_beauty_equipment(ocid)
        assert response is not None
        print(response)

    async def test_success_get_character_beauty_equipment_with_date(self):
        response = await api.get_character_beauty_equipment(ocid, date=datetime(2025, 4, 20))
        assert response is not None
        print(response)

    async def test_fail_get_character_beauty_equipment_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_beauty_equipment(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_beauty_equipment_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_beauty_equipment(ocid, date=datetime(2025, 4, 19))
        assert 'You can only retrieve data after 2025-04-20' in str(e.value)
        print(e.value)


class TestGetCharacterAndroidEquipment(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_android_equipment(self):
        response = await api.get_character_android_equipment(ocid)
        assert response is not None
        print(response)

    async def test_success_get_character_android_equipment_with_date(self):
        response = await api.get_character_android_equipment(ocid, date=datetime(2025, 4, 20))
        assert response is not None
        print(response)

    async def test_fail_get_character_android_equipment_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_android_equipment(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_android_equipment_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_android_equipment(ocid, date=datetime(2025, 4, 19))
        assert 'You can only retrieve data after 2025-04-20' in str(e.value)
        print(e.value)


class TestGetCharacterPetEquipment(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_pet_equipment(self):
        response = await api.get_character_pet_equipment(ocid)
        # nothing to assert because some characters may not have pets
        print(response)

    async def test_success_get_character_pet_equipment_with_date(self):
        response = await api.get_character_pet_equipment(ocid, date=datetime(2025, 4, 20))
        assert response is not None
        print(response)

    async def test_fail_get_character_pet_equipment_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_pet_equipment(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_pet_equipment_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_pet_equipment(ocid, date=datetime(2025, 4, 19))
        assert 'You can only retrieve data after 2025-04-20' in str(e.value)
        print(e.value)


class TestGetCharacterSkill(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_skill_with_skill_grade(self):
        skill_grade = '6'
        response = await api.get_character_skill(ocid, skill_grade)
        assert response is not None
        print(response)

    async def test_success_get_character_skill_with_date(self):
        skill_grade = '6'
        response = await api.get_character_skill(ocid, skill_grade, date=datetime(2025, 4, 20))
        assert response is not None
        print(response)

    async def test_fail_get_character_skill_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_skill(invalid_ocid, '6')
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_skill_with_invalid_date(self):
        skill_grade = '6'
        with pytest.raises(Exception) as e:
            await api.get_character_skill(ocid, skill_grade, date=datetime(2025, 4, 19))
        assert 'You can only retrieve data after 2025-04-20' in str(e.value)
        print(e.value)


class TestGetCharacterLinkSkill(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_link_skill(self):
        response = await api.get_character_link_skill(ocid)
        assert response is not None
        print(response)

    async def test_success_get_character_link_skill_with_date(self):
        response = await api.get_character_link_skill(ocid, date=datetime(2025, 4, 20))
        assert response is not None
        print(response)

    async def test_fail_get_character_link_skill_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_link_skill(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_link_skill_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_link_skill(ocid, date=datetime(2025, 4, 19))
        assert 'You can only retrieve data after 2025-04-20' in str(e.value)
        print(e.value)


class TestGetCharacterVMatrix(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_vmatrix(self):
        response = await api.get_character_vmatrix(ocid)
        # nothing to assert because some characters may not have v matrix
        print(response)

    async def test_success_get_character_vmatrix_with_date(self):
        response = await api.get_character_vmatrix(ocid, date=datetime(2025, 4, 20))
        assert response is not None
        print(response)

    async def test_fail_get_character_vmatrix_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_vmatrix(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_vmatrix_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_vmatrix(ocid, date=datetime(2025, 4, 19))
        assert 'You can only retrieve data after 2025-04-20' in str(e.value)
        print(e.value)


class TestGetCharacterHexaMatrix(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_hexamatrix(self):
        response = await api.get_character_hexamatrix(ocid)
        # nothing to assert because some characters may not have hexa matrix
        print(response)

    async def test_success_get_character_hexamatrix_with_date(self):
        response = await api.get_character_hexamatrix(ocid, date=datetime(2025, 4, 20))
        assert response is not None
        print(response)

    async def test_fail_get_character_hexamatrix_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_hexamatrix(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_hexamatrix_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_hexamatrix(ocid, date=datetime(2025, 4, 19))
        assert 'You can only retrieve data after 2025-04-20' in str(e.value)
        print(e.value)


class TestGetCharacterHexaMatrixStat(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_hexamatrix_stat(self):
        response = await api.get_character_hexamatrix_stat(ocid)
        assert response is not None
        print(response)

    async def test_success_get_character_hexamatrix_stat_with_date(self):
        response = await api.get_character_hexamatrix_stat(ocid, date=datetime(2025, 4, 20))
        assert response is not None
        print(response)

    async def test_fail_get_character_hexamatrix_stat_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_hexamatrix_stat(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_hexamatrix_stat_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_hexamatrix_stat(ocid, date=datetime(2025, 4, 19))
        assert 'You can only retrieve data after 2025-04-20' in str(e.value)
        print(e.value)


class TestGetCharacterDojang(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_dojang(self):
        response = await api.get_character_dojang(ocid)
        assert response is not None
        print(response)

    async def test_success_get_character_dojang_with_date(self):
        response = await api.get_character_dojang(ocid, date=datetime(2025, 4, 20))
        assert response is not None
        print(response)

    async def test_fail_get_character_dojang_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_dojang(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_dojang_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_dojang(ocid, date=datetime(2025, 4, 19))
        assert 'You can only retrieve data after 2025-04-20' in str(e.value)
        print(e.value)


if __name__ == '__main__':
    unittest.main()
