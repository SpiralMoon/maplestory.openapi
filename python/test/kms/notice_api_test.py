import os
import sys
import unittest
import pytest

from dotenv import load_dotenv

sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '../')))

from maplestory_openapi.api.common import MapleStoryApiException
from maplestory_openapi.api.kms import MapleStoryApi

load_dotenv()

api_key = os.environ['API_KEY_KMS'] # Your API Key
api = MapleStoryApi(api_key)

# Notice Information Retrieval

class TestGetNoticeList(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_notice_list(self):
        response = await api.get_notice_list()
        print(response)


class TestGetNoticeDetail(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_notice_detail(self):
        notice_list = await api.get_notice_list()

        if len(notice_list.notice) == 0:
            raise Exception('Notice must be not empty.')

        notice_id = notice_list.notice[0].notice_id
        response = await api.get_notice_detail(notice_id)
        print(response)

    async def test_fail_get_notice_detail_with_invalid_notice_id_throw_OPENAPI00004(self):
        invalid_notice_id = -1
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_notice_detail(invalid_notice_id)
        assert e.value.error_code == 'OPENAPI00004'
        print(e.value.error_code, e.value.message)


class TestGetUpdateNoticeList(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_update_notice_list(self):
        response = await api.get_update_notice_list()
        print(response)


class TestGetUpdateNoticeDetail(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_update_notice_detail(self):
        update_notice_list = await api.get_update_notice_list()

        if len(update_notice_list.update_notice) == 0:
            raise Exception('Notice must be not empty.')

        notice_id = update_notice_list.update_notice[0].notice_id
        response = await api.get_update_notice_detail(notice_id)
        print(response)

    async def test_fail_get_update_notice_detail_with_invalid_notice_id_throw_OPENAPI00004(self):
        invalid_notice_id = -1
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_update_notice_detail(invalid_notice_id)
        assert e.value.error_code == 'OPENAPI00004'
        print(e.value.error_code, e.value.message)


class TestGetEventNoticeList(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_event_notice_list(self):
        response = await api.get_event_notice_list()
        print(response)


class TestGetEventNoticeDetail(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_event_notice_detail(self):
        event_notice_list = await api.get_event_notice_list()

        if len(event_notice_list.event_notice) == 0:
            raise Exception('Notice must be not empty.')

        notice_id = event_notice_list.event_notice[0].notice_id
        response = await api.get_event_notice_detail(notice_id)
        print(response)

    async def test_fail_get_event_notice_detail_with_invalid_notice_id_throw_OPENAPI00004(self):
        invalid_notice_id = -1
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_event_notice_detail(invalid_notice_id)
        assert e.value.error_code == 'OPENAPI00004'
        print(e.value.error_code, e.value.message)


if __name__ == '__main__':
    unittest.main()
