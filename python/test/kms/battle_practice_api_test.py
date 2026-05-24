import os
import sys
import unittest
import pytest

from dotenv import load_dotenv

sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '../')))

from maplestory_openapi.api.common import MapleStoryApiException
from maplestory_openapi.api.kms import MapleStoryApi

load_dotenv()

api_key = os.environ['API_KEY_KMS'] # Your API Key
api = MapleStoryApi(api_key)

ocid = 'e0a4f439e53c369866b55297d2f5f4eb'
replay_id = '8ac5ac350d67765e4c49db94cc61f83d'

# Battle Practice Information Retrieval

class TestGetBattlePracticeReplayId(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_battle_practice_replay_id(self):
        response = await api.get_battle_practice_replay_id(ocid)
        assert response is not None
        print(response)

    async def test_fail_get_battle_practice_replay_id_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_battle_practice_replay_id(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)


class TestGetBattlePracticeResult(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_battle_practice_result(self):
        response = await api.get_battle_practice_result(replay_id)
        assert response is not None
        print(response)

    async def test_fail_get_battle_practice_result_with_invalid_replay_id(self):
        invalid_replay_id = 'invalid_replay_id_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_battle_practice_result(invalid_replay_id)
        print(e.value.error_code, e.value.message)


class TestGetBattlePracticeSkillTimeline(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_battle_practice_skill_timeline(self):
        response = await api.get_battle_practice_skill_timeline(replay_id)
        assert response is not None
        print(response)

    async def test_success_get_battle_practice_skill_timeline_with_page_no(self):
        response = await api.get_battle_practice_skill_timeline(replay_id, page_no=1)
        assert response is not None
        print(response)

    async def test_fail_get_battle_practice_skill_timeline_with_invalid_replay_id(self):
        invalid_replay_id = 'invalid_replay_id_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_battle_practice_skill_timeline(invalid_replay_id)
        print(e.value.error_code, e.value.message)


class TestGetBattlePracticeCharacterInfo(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_battle_practice_character_info(self):
        response = await api.get_battle_practice_character_info(replay_id)
        assert response is not None
        print(response)

    async def test_fail_get_battle_practice_character_info_with_invalid_replay_id(self):
        invalid_replay_id = 'invalid_replay_id_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_battle_practice_character_info(invalid_replay_id)
        print(e.value.error_code, e.value.message)
