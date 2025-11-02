import os
import sys
import unittest
import pytest

from datetime import datetime
from dotenv import load_dotenv

sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '../')))

from maplestory_openapi.api.common import MapleStoryApiException
from maplestory_openapi.api.common.enum import CharacterImageAction, CharacterImageEmotion, CharacterImageWeaponMotion
from maplestory_openapi.api.kms import MapleStoryApi
from maplestory_openapi.api.kms.param.character_image_option import CharacterImageOption

load_dotenv()

api_key = os.environ['API_KEY_KMS'] # Your API Key
api = MapleStoryApi(api_key)

ocid = 'e0a4f439e53c369866b55297d2f5f4eb'

# Character Information Retrieval

class TestGetCharacter(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character(self):
        nickname = '아델'
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
        print(response)

    async def test_success_get_character_basic_with_date(self):
        response = await api.get_character_basic(ocid, date=datetime(2023, 12, 22))
        print(response)

    async def test_success_get_character_basic_on_date_with_no_data(self):
        ocid = 'b0187493ec48ddd7b1d304fe8982d0b0'
        with pytest.raises(Exception) as e:
            await api.get_character_basic(ocid, date=datetime(2025, 6, 18))
        print(e.value)

    async def test_fail_get_character_basic_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_basic(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_basic_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_basic(ocid, date=datetime(2023, 12, 20))
        assert 'You can only retrieve data after 2023-12-21' in str(e.value)
        print(e.value)


class TestGetCharacterImage(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_image(self):
        response = await api.get_character_image(ocid)
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
        print(response)

    async def test_success_get_character_image_with_date(self):
        response = await api.get_character_image(ocid, date=datetime(2023, 12, 22))
        print(response)

    async def test_fail_get_character_image_on_date_with_no_data(self):
        ocid='b0187493ec48ddd7b1d304fe8982d0b0'
        with pytest.raises(Exception) as e:
            await api.get_character_image(ocid, date=datetime(2025, 6, 18))
        print(e.value)

    async def test_fail_get_character_image_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_image(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_image_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_image(ocid, date=datetime(2023, 12, 20))
        assert 'You can only retrieve data after 2023-12-21' in str(e.value)
        print(e.value)


class TestGetCharacterPopularity(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_popularity(self):
        response = await api.get_character_popularity(ocid)
        print(response)

    async def test_success_get_character_popularity_with_date(self):
        response = await api.get_character_popularity(ocid, date=datetime(2023, 12, 22))
        print(response)

    async def test_success_get_character_popularity_on_date_with_no_data(self):
        ocid = 'b0187493ec48ddd7b1d304fe8982d0b0'
        response = await api.get_character_popularity(ocid, date=datetime(2025, 6, 18))
        assert response.date is not None
        assert response.popularity is None
        print(response)

    async def test_fail_get_character_popularity_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_popularity(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_popularity_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_popularity(ocid, date=datetime(2023, 12, 20))
        assert 'You can only retrieve data after 2023-12-21' in str(e.value)
        print(e.value)


class TestGetCharacterStat(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_stat(self):
        response = await api.get_character_stat(ocid)
        print(response)

    async def test_success_get_character_stat_with_date(self):
        response = await api.get_character_stat(ocid, date=datetime(2023, 12, 22))
        print(response)

    async def test_success_get_character_stat_on_date_with_no_data(self):
        ocid = 'b0187493ec48ddd7b1d304fe8982d0b0'
        response = await api.get_character_stat(ocid, date=datetime(2025, 6, 18))
        assert response.date is not None
        assert response.character_class is None
        assert response.final_stat == []
        assert response.remain_ap is None
        print(response)

    async def test_fail_get_character_stat_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_stat(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_stat_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_stat(ocid, date=datetime(2023, 12, 20))
        assert 'You can only retrieve data after 2023-12-21' in str(e.value)
        print(e.value)


class TestGetCharacterHyperStat(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_hyper_stat(self):
        response = await api.get_character_hyper_stat(ocid)
        print(response)

    async def test_success_get_character_hyper_stat_with_date(self):
        response = await api.get_character_hyper_stat(ocid, date=datetime(2023, 12, 22))
        print(response)

    async def test_success_get_character_hyper_stat_on_date_with_no_data(self):
        ocid = 'b0187493ec48ddd7b1d304fe8982d0b0'
        response = await api.get_character_hyper_stat(ocid, date=datetime(2025, 6, 18))
        assert response.date is not None
        assert response.character_class is None
        assert response.use_preset_no is None
        assert response.use_available_hyper_stat is None
        assert response.hyper_stat_preset_1 == []
        assert response.hyper_stat_preset_1_remain_point is None
        assert response.hyper_stat_preset_2 == []
        assert response.hyper_stat_preset_2_remain_point is None
        assert response.hyper_stat_preset_3 == []
        assert response.hyper_stat_preset_3_remain_point is None
        print(response)

    async def test_fail_get_character_hyper_stat_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_hyper_stat(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_hyper_stat_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_hyper_stat(ocid, date=datetime(2023, 12, 20))
        assert 'You can only retrieve data after 2023-12-21' in str(e.value)
        print(e.value)


class TestGetCharacterPropensity(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_propensity(self):
        response = await api.get_character_propensity(ocid)
        print(response)

    async def test_success_get_character_propensity_with_date(self):
        response = await api.get_character_propensity(ocid, date=datetime(2023, 12, 22))
        print(response)

    async def test_success_get_character_propensity_on_date_with_no_data(self):
        ocid = 'b0187493ec48ddd7b1d304fe8982d0b0'
        response = await api.get_character_propensity(ocid, date=datetime(2025, 6, 18))
        assert response.date is not None
        assert response.charisma_level is None
        assert response.sensibility_level is None
        assert response.insight_level is None
        assert response.willingness_level is None
        assert response.handicraft_level is None
        assert response.charm_level is None
        print(response)

    async def test_fail_get_character_propensity_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_propensity(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_propensity_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_propensity(ocid, date=datetime(2023, 12, 20))
        assert 'You can only retrieve data after 2023-12-21' in str(e.value)
        print(e.value)


class TestGetCharacterAbility(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_ability(self):
        response = await api.get_character_ability(ocid)
        print(response)

    async def test_success_get_character_ability_with_date(self):
        response = await api.get_character_ability(ocid, date=datetime(2023, 12, 22))
        print(response)

    async def test_success_get_character_ability_on_date_with_no_data(self):
        ocid = 'b0187493ec48ddd7b1d304fe8982d0b0'
        response = await api.get_character_ability(ocid, date=datetime(2025, 6, 18))
        assert response.date is not None
        assert response.ability_grade is None
        assert response.ability_info == []
        assert response.remain_fame is None
        assert response.preset_no is None
        assert response.ability_preset_1 is None
        assert response.ability_preset_2 is None
        assert response.ability_preset_3 is None
        print(response)

    async def test_fail_get_character_ability_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_ability(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_ability_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_ability(ocid, date=datetime(2023, 12, 20))
        assert 'You can only retrieve data after 2023-12-21' in str(e.value)
        print(e.value)


class TestGetCharacterItemEquipment(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_item_equipment(self):
        response = await api.get_character_item_equipment(ocid)
        print(response)

    async def test_success_get_character_item_equipment_with_date(self):
        response = await api.get_character_item_equipment(ocid, date=datetime(2023, 12, 22))
        print(response)

    async def test_success_get_character_item_equipment_on_date_with_no_data(self):
        ocid = 'b0187493ec48ddd7b1d304fe8982d0b0'
        response = await api.get_character_item_equipment(ocid, date=datetime(2025, 6, 18))
        assert response.date is not None
        assert response.character_gender is None
        assert response.character_class is None
        assert response.preset_no is None
        assert response.item_equipment == []
        assert response.item_equipment_preset_1 == []
        assert response.item_equipment_preset_2 == []
        assert response.item_equipment_preset_3 == []
        assert response.title is None
        assert response.medal_shape is None
        assert response.dragon_equipment == []
        assert response.mechanic_equipment == []
        print(response)

    async def test_fail_get_character_item_equipment_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_item_equipment(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_item_equipment_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_item_equipment(ocid, date=datetime(2023, 12, 20))
        assert 'You can only retrieve data after 2023-12-21' in str(e.value)
        print(e.value)


class TestGetCharacterCashItemEquipment(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_cashitem_equipment(self):
        response = await api.get_character_cashitem_equipment(ocid)
        print(response)

    async def test_success_get_character_cashitem_equipment_with_date(self):
        response = await api.get_character_cashitem_equipment(ocid, date=datetime(2023, 12, 22))
        print(response)

    async def test_success_get_character_cashitem_equipment_on_date_with_no_data(self):
        ocid = 'b0187493ec48ddd7b1d304fe8982d0b0'
        response = await api.get_character_cashitem_equipment(ocid, date=datetime(2025, 6, 18))
        assert response.date is not None
        assert response.character_gender is None
        assert response.character_class is None
        assert response.character_look_mode is None
        assert response.preset_no is None
        assert response.cash_item_equipment_base == []
        assert response.cash_item_equipment_preset_1 == []
        assert response.cash_item_equipment_preset_2 == []
        assert response.cash_item_equipment_preset_3 == []
        assert response.additional_cash_item_equipment_base == []
        assert response.additional_cash_item_equipment_preset_1 == []
        assert response.additional_cash_item_equipment_preset_2 == []
        assert response.additional_cash_item_equipment_preset_3 == []
        print(response)

    async def test_fail_get_character_cashitem_equipment_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_cashitem_equipment(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_cashitem_equipment_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_cashitem_equipment(ocid, date=datetime(2023, 12, 20))
        assert 'You can only retrieve data after 2023-12-21' in str(e.value)
        print(e.value)


class TestGetCharacterSymbolEquipment(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_symbol_equipment(self):
        response = await api.get_character_symbol_equipment(ocid)
        print(response)

    async def test_success_get_character_symbol_equipment_with_date(self):
        response = await api.get_character_symbol_equipment(ocid, date=datetime(2023, 12, 22))
        print(response)

    async def test_success_get_character_symbol_equipment_on_date_with_no_data(self):
        ocid = 'b0187493ec48ddd7b1d304fe8982d0b0'
        response = await api.get_character_symbol_equipment(ocid, date=datetime(2025, 6, 18))
        assert response.date is not None
        assert response.character_class is None
        assert response.symbol == []
        print(response)

    async def test_fail_get_character_symbol_equipment_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_symbol_equipment(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_symbol_equipment_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_symbol_equipment(ocid, date=datetime(2023, 12, 20))
        assert 'You can only retrieve data after 2023-12-21' in str(e.value)
        print(e.value)


class TestGetCharacterSetEffect(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_set_effect(self):
        response = await api.get_character_set_effect(ocid)
        print(response)

    async def test_success_get_character_set_effect_with_date(self):
        response = await api.get_character_set_effect(ocid, date=datetime(2023, 12, 22))
        print(response)

    async def test_success_get_character_set_effect_on_date_with_no_data(self):
        ocid = 'b0187493ec48ddd7b1d304fe8982d0b0'
        response = await api.get_character_set_effect(ocid, date=datetime(2025, 6, 18))
        assert response.date is not None
        assert response.set_effect == []
        print(response)

    async def test_fail_get_character_set_effect_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_set_effect(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_set_effect_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_set_effect(ocid, date=datetime(2023, 12, 20))
        assert 'You can only retrieve data after 2023-12-21' in str(e.value)
        print(e.value)


class TestGetCharacterBeautyEquipment(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_beauty_equipment(self):
        response = await api.get_character_beauty_equipment(ocid)
        print(response)

    async def test_success_get_character_beauty_equipment_with_date(self):
        response = await api.get_character_beauty_equipment(ocid, date=datetime(2023, 12, 22))
        print(response)

    async def test_success_get_character_beauty_equipment_on_date_with_no_data(self):
        ocid = 'b0187493ec48ddd7b1d304fe8982d0b0'
        response = await api.get_character_beauty_equipment(ocid, date=datetime(2025, 6, 18))
        assert response.date is not None
        assert response.character_gender is None
        assert response.character_class is None
        assert response.character_hair is None
        assert response.character_face is None
        assert response.character_skin is None
        assert response.additional_character_hair is None
        assert response.additional_character_face is None
        assert response.additional_character_skin is None
        print(response)

    async def test_fail_get_character_beauty_equipment_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_beauty_equipment(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_beauty_equipment_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_beauty_equipment(ocid, date=datetime(2023, 12, 20))
        assert 'You can only retrieve data after 2023-12-21' in str(e.value)
        print(e.value)


class TestGetCharacterAndroidEquipment(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_android_equipment(self):
        response = await api.get_character_android_equipment(ocid)
        print(response)

    async def test_success_get_character_android_equipment_with_date(self):
        response = await api.get_character_android_equipment(ocid, date=datetime(2023, 12, 22))
        print(response)

    async def test_success_get_character_android_equipment_on_date_with_no_data(self):
        ocid = 'b0187493ec48ddd7b1d304fe8982d0b0'
        response = await api.get_character_android_equipment(ocid, date=datetime(2025, 6, 18))
        assert response.date is not None
        assert response.android_name is None
        assert response.android_nickname is None
        assert response.android_icon is None
        assert response.android_description is None
        assert response.android_hair is None
        assert response.android_face is None
        assert response.android_skin is None
        assert response.android_cash_item_equipment == []
        assert response.android_ear_sensor_clip_flag is None
        assert response.android_gender is None
        assert response.android_grade is None
        assert response.android_non_humanoid_flag is None
        assert response.android_shop_usable_flag is None
        assert response.preset_no is None
        assert response.android_preset_1 is None
        assert response.android_preset_2 is None
        assert response.android_preset_3 is None
        print(response)

    async def test_fail_get_character_android_equipment_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_android_equipment(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_android_equipment_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_android_equipment(ocid, date=datetime(2023, 12, 20))
        assert 'You can only retrieve data after 2023-12-21' in str(e.value)
        print(e.value)


class TestGetCharacterPetEquipment(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_pet_equipment(self):
        response = await api.get_character_pet_equipment(ocid)
        print(response)

    async def test_success_get_character_pet_equipment_with_date(self):
        response = await api.get_character_pet_equipment(ocid, date=datetime(2023, 12, 22))
        print(response)

    async def test_success_get_character_pet_equipment_on_date_with_no_data(self):
        ocid = 'b0187493ec48ddd7b1d304fe8982d0b0'
        response = await api.get_character_pet_equipment(ocid, date=datetime(2025, 6, 18))
        assert response.date is not None
        assert response.pet_1_name is None
        assert response.pet_1_nickname is None
        assert response.pet_1_icon is None
        assert response.pet_1_description is None
        assert response.pet_1_equipment is None
        assert response.pet_1_auto_skill is None
        assert response.pet_1_pet_type is None
        assert response.pet_1_skill == []
        assert response.pet_1_date_expire is None
        assert response.pet_1_expired is None
        assert response.pet_1_appearance is None
        assert response.pet_1_appearance_icon is None
        assert response.pet_2_name is None
        assert response.pet_2_nickname is None
        assert response.pet_2_icon is None
        assert response.pet_2_description is None
        assert response.pet_2_equipment is None
        assert response.pet_2_auto_skill is None
        assert response.pet_2_pet_type is None
        assert response.pet_2_skill == []
        assert response.pet_2_date_expire is None
        assert response.pet_2_expired is None
        assert response.pet_2_appearance is None
        assert response.pet_2_appearance_icon is None
        assert response.pet_3_name is None
        assert response.pet_3_nickname is None
        assert response.pet_3_icon is None
        assert response.pet_3_description is None
        assert response.pet_3_equipment is None
        assert response.pet_3_auto_skill is None
        assert response.pet_3_pet_type is None
        assert response.pet_3_skill == []
        assert response.pet_3_date_expire is None
        assert response.pet_3_expired is None
        assert response.pet_3_appearance is None
        assert response.pet_3_appearance_icon is None
        print(response)

    async def test_fail_get_character_pet_equipment_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_pet_equipment(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_pet_equipment_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_pet_equipment(ocid, date=datetime(2023, 12, 20))
        assert 'You can only retrieve data after 2023-12-21' in str(e.value)
        print(e.value)


class TestGetCharacterSkill(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_skill_with_skill_grade(self):
        skill_grade = '6'
        response = await api.get_character_skill(ocid, skill_grade)
        print(response)

    async def test_success_get_character_skill_with_date(self):
        skill_grade = '6'
        response = await api.get_character_skill(ocid, skill_grade, date=datetime(2023, 12, 22))
        print(response)

    async def test_success_get_character_skill_on_date_with_no_data(self):
        ocid = 'b0187493ec48ddd7b1d304fe8982d0b0'
        response = await api.get_character_skill(ocid, '6', date=datetime(2025, 6, 18))
        assert response.date is not None
        assert response.character_class is None
        assert response.character_skill_grade is None
        assert response.character_skill == []
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
            await api.get_character_skill(ocid, skill_grade, date=datetime(2023, 12, 20))
        assert 'You can only retrieve data after 2023-12-21' in str(e.value)
        print(e.value)


class TestGetCharacterLinkSkill(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_link_skill(self):
        response = await api.get_character_link_skill(ocid)
        print(response)

    async def test_success_get_character_link_skill_with_date(self):
        response = await api.get_character_link_skill(ocid, date=datetime(2023, 12, 22))
        print(response)

    async def test_success_get_character_link_skill_on_date_with_no_data(self):
        ocid = 'b0187493ec48ddd7b1d304fe8982d0b0'
        response = await api.get_character_link_skill(ocid, date=datetime(2025, 6, 18))
        assert response.date is not None
        assert response.character_class is None
        assert response.character_link_skill == []
        assert response.character_link_skill_preset_1 == []
        assert response.character_link_skill_preset_2 == []
        assert response.character_link_skill_preset_3 == []
        assert response.character_owned_link_skill is None
        assert response.character_owned_link_skill_preset_1 is None
        assert response.character_owned_link_skill_preset_2 is None
        assert response.character_owned_link_skill_preset_3 is None
        print(response)

    async def test_fail_get_character_link_skill_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_link_skill(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_link_skill_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_link_skill(ocid, date=datetime(2023, 12, 20))
        assert 'You can only retrieve data after 2023-12-21' in str(e.value)
        print(e.value)


class TestGetCharacterVMatrix(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_vmatrix(self):
        response = await api.get_character_vmatrix(ocid)
        print(response)

    async def test_success_get_character_vmatrix_with_date(self):
        response = await api.get_character_vmatrix(ocid, date=datetime(2023, 12, 22))
        print(response)

    async def test_success_get_character_vmatrix_on_date_with_no_data(self):
        ocid = 'b0187493ec48ddd7b1d304fe8982d0b0'
        response = await api.get_character_vmatrix(ocid, date=datetime(2025, 6, 18))
        assert response.date is not None
        assert response.character_class is None
        assert response.character_v_core_equipment == []
        assert response.character_v_matrix_remain_slot_upgrade_point is None
        print(response)

    async def test_fail_get_character_vmatrix_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_vmatrix(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_vmatrix_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_vmatrix(ocid, date=datetime(2023, 12, 20))
        assert 'You can only retrieve data after 2023-12-21' in str(e.value)
        print(e.value)


class TestGetCharacterHexaMatrix(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_hexamatrix(self):
        response = await api.get_character_hexamatrix(ocid)
        print(response)

    async def test_success_get_character_hexamatrix_with_date(self):
        response = await api.get_character_hexamatrix(ocid, date=datetime(2023, 12, 22))
        print(response)

    async def test_success_get_character_hexamatrix_on_date_with_no_data(self):
        ocid = 'b0187493ec48ddd7b1d304fe8982d0b0'
        response = await api.get_character_hexamatrix(ocid, date=datetime(2025, 6, 18))
        assert response.date is not None
        assert response.character_hexa_core_equipment == []
        print(response)

    async def test_fail_get_character_hexamatrix_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_hexamatrix(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_hexamatrix_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_hexamatrix(ocid, date=datetime(2023, 12, 20))
        assert 'You can only retrieve data after 2023-12-21' in str(e.value)
        print(e.value)


class TestGetCharacterHexaMatrixStat(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_hexamatrix_stat(self):
        response = await api.get_character_hexamatrix_stat(ocid)
        print(response)

    async def test_success_get_character_hexamatrix_stat_with_date(self):
        response = await api.get_character_hexamatrix_stat(ocid, date=datetime(2023, 12, 22))
        print(response)

    async def test_success_get_character_hexamatrix_stat_on_date_with_no_data(self):
        ocid = 'b0187493ec48ddd7b1d304fe8982d0b0'
        response = await api.get_character_hexamatrix_stat(ocid, date=datetime(2025, 6, 18))
        assert response.date is not None
        assert response.character_class is None
        assert response.character_hexa_stat_core == []
        assert response.character_hexa_stat_core_2 == []
        assert response.character_hexa_stat_core_3 == []
        assert response.preset_hexa_stat_core == []
        assert response.preset_hexa_stat_core_2 == []
        assert response.preset_hexa_stat_core_3 == []
        print(response)

    async def test_fail_get_character_hexamatrix_stat_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_hexamatrix_stat(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_hexamatrix_stat_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_hexamatrix_stat(ocid, date=datetime(2023, 12, 20))
        assert 'You can only retrieve data after 2023-12-21' in str(e.value)
        print(e.value)


class TestGetCharacterDojang(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_dojang(self):
        response = await api.get_character_dojang(ocid)
        print(response)

    async def test_success_get_character_dojang_with_date(self):
        response = await api.get_character_dojang(ocid, date=datetime(2023, 12, 22))
        print(response)

    async def test_success_get_character_dojang_on_date_with_no_data(self):
        ocid = 'b0187493ec48ddd7b1d304fe8982d0b0'
        response = await api.get_character_dojang(ocid, date=datetime(2025, 6, 18))
        assert response.date is not None
        assert response.character_class is None
        assert response.world_name is None
        assert response.dojang_best_floor is None
        assert response.date_dojang_record is None
        assert response.dojang_best_time is None
        print(response)

    async def test_fail_get_character_dojang_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_dojang(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_dojang_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_dojang(ocid, date=datetime(2023, 12, 20))
        assert 'You can only retrieve data after 2023-12-21' in str(e.value)
        print(e.value)


class TestGetCharacterOtherStat(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_other_stat(self):
        response = await api.get_character_other_stat(ocid)
        print(response)

    async def test_success_get_character_other_stat_with_date(self):
        response = await api.get_character_other_stat(ocid, date=datetime(2025, 8, 21))
        print(response)

    async def test_success_get_character_other_stat_on_date_with_no_data(self):
        ocid = 'b0187493ec48ddd7b1d304fe8982d0b0'
        response = await api.get_character_other_stat(ocid, date=datetime(2025, 8, 21))
        assert response.date is not None
        assert response.other_stat == []
        print(response)

    async def test_fail_get_character_other_stat_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_other_stat(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_other_stat_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_other_stat(ocid, date=datetime(2025, 8, 20))
        assert 'You can only retrieve data after 2025-08-21' in str(e.value)
        print(e.value)


class TestGetCharacterRingExchangeSkillEquipment(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_ring_exchange_skill_equipment(self):
        response = await api.get_character_ring_exchange_skill_equipment(ocid)
        print(response)

    async def test_success_get_character_ring_exchange_skill_equipment_with_date(self):
        response = await api.get_character_ring_exchange_skill_equipment(ocid, date=datetime(2025, 8, 21))
        print(response)

    async def test_success_get_character_ring_exchange_skill_equipment_on_date_with_no_data(self):
        ocid = 'b0187493ec48ddd7b1d304fe8982d0b0'
        response = await api.get_character_ring_exchange_skill_equipment(ocid, date=datetime(2025, 8, 21))
        assert response.date is not None
        assert response.character_class is None
        assert response.special_ring_exchange_name is None
        assert response.special_ring_exchange_level is None
        assert response.special_ring_exchange_icon is None
        assert response.special_ring_exchange_description is None
        print(response)

    async def test_fail_get_character_ring_exchange_skill_equipment_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_character_ring_exchange_skill_equipment(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_character_ring_exchange_skill_equipment_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_character_ring_exchange_skill_equipment(ocid, date=datetime(2025, 8, 20))
        assert 'You can only retrieve data after 2025-08-21' in str(e.value)
        print(e.value)


if __name__ == '__main__':
    unittest.main()
