import os
import sys
import unittest

sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '../')))

from maplestory_openapi.api.kms import MapleStoryApi

api_key = os.environ['API_KEY']  # Your API Key
api = MapleStoryApi(api_key)


# 공지 정보 조회
class NoticeApi(unittest.IsolatedAsyncioTestCase):
    async def test_notice_list(self):
        response = await api.get_notice_list()
        print(response)

    async def test_notice_detail(self):
        list = await api.get_notice_list()

        if len(list.notice) == 0:
            raise Exception('Notice muse be not empty.')

        notice_id = list.notice[0].notice_id
        response = await api.get_notice_detail(notice_id)
        print(response)

    async def test_update_notice_list(self):
        response = await api.get_update_notice_list()
        print(response)

    async def test_update_notice_detail(self):
        list = await api.get_update_notice_list()

        if len(list.update_notice) == 0:
            raise Exception('Notice muse be not empty.')

        notice_id = list.update_notice[0].notice_id
        response = await api.get_update_notice_detail(notice_id)
        print(response)

    async def test_event_notice_list(self):
        response = await api.get_event_notice_list()
        print(response)

    async def test_event_notice_detail(self):
        list = await api.get_event_notice_list()

        if len(list.event_notice) == 0:
            raise Exception('Notice muse be not empty.')

        notice_id = list.event_notice[0].notice_id
        response = await api.get_event_notice_detail(notice_id)
        print(response)

    async def test_cashshop_notice_list(self):
        response = await api.get_cashshop_notice_list()
        print(response)

    async def test_cashshop_notice_detail(self):
        list = await api.get_cashshop_notice_list()

        if len(list.cashshop_notice) == 0:
            raise Exception('Notice muse be not empty.')

        notice_id = list.cashshop_notice[0].notice_id
        response = await api.get_cashshop_notice_detail(notice_id)
        print(response)
