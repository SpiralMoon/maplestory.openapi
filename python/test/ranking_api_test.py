import os
import sys
import unittest

sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '../')))

from maplestory_openapi import MapleStoryApi

api_key = os.environ['API_KEY']  # Your API Key
api = MapleStoryApi(api_key)


# 랭킹 정보 조회
class RankingApi(unittest.TestCase):
    def test_overall_ranking(self):
        response = api.get_overall_ranking()
        print(response)

    def test_union_ranking(self):
        response = api.get_union_ranking()
        print(response)

    def test_guild_ranking(self):
        response = api.get_guild_ranking()
        print(response)

    def test_dojang_ranking(self):
        response = api.get_dojang_ranking()
        print(response)

    def test_seed_ranking(self):
        response = api.get_theseed_ranking()
        print(response)

    def test_achievement_ranking(self):
        response = api.get_achievement_ranking()
        print(response)


if __name__ == '__main__':
    unittest.main()
