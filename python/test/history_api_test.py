import os
import sys
import unittest

sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '../')))

from maplestory_openapi import MapleStoryApi

api_key = os.environ['API_KEY']  # Your API Key
api = MapleStoryApi(api_key)


# 확률 정보 조회
class HistoryApi(unittest.TestCase):
    def test_starforce_history(self):
        count = 1000
        response = api.get_starforce_history(count)
        print(response)

    def test_potential_history(self):
        count = 1000
        response = api.get_potential_history(count)
        print(response)

    def test_cube_history(self):
        count = 1000
        response = api.get_cube_history(count)
        print(response)


if __name__ == '__main__':
    unittest.main()
