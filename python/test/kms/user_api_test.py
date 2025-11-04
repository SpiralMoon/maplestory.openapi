import os
import sys
import unittest

from dotenv import load_dotenv

sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '../')))

from maplestory_openapi.api.kms import MapleStoryApi

load_dotenv()

api_key = os.environ['API_KEY_KMS'] # Your API Key
api = MapleStoryApi(api_key)

# User Information Retrieval

class TestGetCharacterList(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_character_list(self):
        response = await api.get_character_list()
        assert response is not None
        print(response)

class TestGetAchievement(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_achievement(self):
        response = await api.get_achievement()
        assert response is not None
        print(response)


if __name__ == '__main__':
    unittest.main()
