import os
import sys
import unittest

sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '../')))

from maplestory_openapi.api.kms import MapleStoryApi

api_key = os.environ['API_KEY']  # Your API Key
api = MapleStoryApi(api_key)

ogid = 'f5992063d46d6f8718e514fca5428960'


# 길드 정보 조회
class GuildApi(unittest.IsolatedAsyncioTestCase):
    async def test_guild_id(self):
        guild_name = '붕붕'
        world_name = '크로아'
        response = await api.get_guild_id(guild_name, world_name)
        print(response)

    async def test_guild_basic(self):
        response = await api.get_guild_basic(ogid)
        print(response)


if __name__ == '__main__':
    unittest.main()
