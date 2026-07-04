import os
import sys
import unittest
import pytest

from datetime import datetime, timedelta, timezone
from dotenv import load_dotenv

sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '../')))

from maplestory_openapi.api.common import MapleStoryApiException
from maplestory_openapi.api.kms import MapleStoryApi

load_dotenv()

api_key = os.environ['API_KEY_KMS'] # Your API Key
api = MapleStoryApi(api_key)

class TestGetSchedulerCharacterState(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_scheduler_character_state(self):
        character_list = await api.get_character_list()
        ocid = character_list.account_list[0].character_list[0].ocid
        response = await api.get_scheduler_character_state(ocid)
        print(response)

    async def test_fail_get_scheduler_character_state_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_scheduler_character_state(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_success_get_scheduler_character_state_within_window(self):
        character_list = await api.get_character_list()
        ocid = character_list.account_list[0].character_list[0].ocid
        date = datetime.now(timezone(timedelta(hours=9))) - timedelta(days=13)
        response = await api.get_scheduler_character_state(ocid, date=date)
        print(response)

    async def test_fail_get_scheduler_character_state_outside_window_throw_OPENAPI00004(self):
        character_list = await api.get_character_list()
        ocid = character_list.account_list[0].character_list[0].ocid
        date = datetime.now(timezone(timedelta(hours=9))) - timedelta(days=14)
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_scheduler_character_state(ocid, date=date)
        assert e.value.error_code == 'OPENAPI00004'
        print(e.value.error_code, e.value.message)
