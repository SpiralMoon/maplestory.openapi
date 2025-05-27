import os
import sys
import unittest

sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '../')))

from maplestory_openapi import MapleStoryApi

api_key = 'live_d6144a2c50ace54e9775764d74f3218c721bc66b55c53c61e6d867a187d3257eefe8d04e6d233bd35cf2fabdeb93fb0d'
api = MapleStoryApi(api_key)

ocid = '84d3c6421c167fd10c146741ff1e3e5d'


# 유니온 정보 조회
class UnionApi(unittest.IsolatedAsyncioTestCase):
    async def test_union(self):
        response = await api.get_union(ocid)
        print(response)

    async def test_union_raider(self):
        response = await api.get_union_raider(ocid)
        print(response)

    async def test_union_artifact(self):
        response = await api.get_union_artifact(ocid)
        print(response)

    async def test_union_champion(self):
        response = await api.get_union_champion(ocid)
        print(response)


if __name__ == '__main__':
    unittest.main()
