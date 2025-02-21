import os
import sys
import unittest

sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '../')))

from maplestory_openapi import MapleStoryApi

api_key = os.environ['API_KEY']  # Your API Key
api = MapleStoryApi(api_key)

ocid = 'e0a4f439e53c369866b55297d2f5f4eb'


# 유니온 정보 조회
class UnionApi(unittest.TestCase):
    def test_union(self):
        response = api.get_union(ocid)
        print(response)

    def test_union_raider(self):
        response = api.get_union_raider(ocid)
        print(response)

    def test_union_artifact(self):
        response = api.get_union_artifact(ocid)
        print(response)

    def test_union_champion(self):
        response = api.get_union_champion(ocid)
        print(response)


if __name__ == '__main__':
    unittest.main()
