import os
import sys
import unittest

sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '../')))

from maplestory_openapi.api.kms import MapleStoryApi

api_key = os.environ['API_KEY']  # Your API Key
api = MapleStoryApi(api_key)

# 계정 정보 조회

class CharacterApi(unittest.IsolatedAsyncioTestCase):
    async def test_character_list(self):
        response = await api.get_character_list()
        print(response)

    async def test_achievement(self):
        response = await api.get_achievement()
        print(response)


if __name__ == '__main__':
    unittest.main()
