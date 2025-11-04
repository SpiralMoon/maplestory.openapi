import os
import sys
import unittest
import pytest

from datetime import datetime
from dotenv import load_dotenv

sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '../')))

from maplestory_openapi.api.common import MapleStoryApiException
from maplestory_openapi.api.kms import MapleStoryApi

load_dotenv()

api_key = os.environ['API_KEY_KMS'] # Your API Key
api = MapleStoryApi(api_key)

ogid = 'f5992063d46d6f8718e514fca5428960'

# Guild Information Retrieval

class TestGetGuild(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_guild(self):
        guild_name = '붕붕'
        world_name = '크로아'
        response = await api.get_guild_id(guild_name, world_name)
        assert response is not None
        assert response.oguild_id == ogid
        print(response)

    async def test_fail_get_guild_with_invalid_world_name(self):
        guild_name = '붕붕'
        world_name = '_InvalidWorld'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_guild_id(guild_name, world_name)
        assert e.value.error_code == 'OPENAPI00004'
        print(e.value.error_code, e.value.message)

    async def test_success_get_guild_with_invalid_guild_name(self):
        guild_name = '_InvalidGuild'
        world_name = '크로아'
        response = await api.get_guild_id(guild_name, world_name)
        assert response is None


class TestGetGuildBasic(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_guild_basic(self):
        response = await api.get_guild_basic(ogid)
        assert response is not None
        print(response)

    async def test_success_get_guild_basic_with_date(self):
        response = await api.get_guild_basic(ogid, date=datetime(2023, 12, 22))
        assert response is not None
        print(response)

    async def test_fail_get_guild_basic_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_guild_basic(ogid, date=datetime(2023, 12, 20))
        assert 'You can only retrieve data after 2023-12-21' in str(e.value)
        print(e.value)

    async def test_fail_get_guild_basic_with_invalid_ogid_throw_OPENAPI00003(self):
        invalid_ogid = 'invalid_ogid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_guild_basic(invalid_ogid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)


if __name__ == '__main__':
    unittest.main()
