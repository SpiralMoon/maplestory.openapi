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

ocid = 'e0a4f439e53c369866b55297d2f5f4eb'


class TestGetUnion(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_union(self):
        response = await api.get_union(ocid)
        print(response)

    async def test_success_get_union_with_date(self):
        response = await api.get_union(ocid, date=datetime(2023, 12, 22))
        print(response)

    async def test_fail_get_union_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_union(ocid, date=datetime(2023, 12, 20))
        assert 'You can only retrieve data after 2023-12-21' in str(e.value)
        print(e.value)

    async def test_fail_get_union_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_union(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)


class TestGetUnionRaider(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_union_raider(self):
        response = await api.get_union_raider(ocid)
        print(response)

    async def test_success_get_union_raider_with_date(self):
        response = await api.get_union_raider(ocid, date=datetime(2023, 12, 22))
        print(response)

    async def test_fail_get_union_raider_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_union_raider(ocid, date=datetime(2023, 12, 20))
        assert 'You can only retrieve data after 2023-12-21' in str(e.value)
        print(e.value)

    async def test_fail_get_union_raider_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_union_raider(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)


class TestGetUnionArtifact(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_union_artifact(self):
        response = await api.get_union_artifact(ocid)
        print(response)

    async def test_success_get_union_artifact_with_date(self):
        response = await api.get_union_artifact(ocid, date=datetime(2023, 12, 22))
        print(response)

    async def test_fail_get_union_artifact_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_union_artifact(ocid, date=datetime(2023, 12, 20))
        assert 'You can only retrieve data after 2023-12-21' in str(e.value)
        print(e.value)

    async def test_fail_get_union_artifact_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_union_artifact(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)


class TestGetUnionChampion(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_union_champion(self):
        response = await api.get_union_champion(ocid)
        print(response)

    async def test_success_get_union_champion_with_date(self):
        response = await api.get_union_champion(ocid, date=datetime(2023, 12, 22))
        print(response)

    async def test_fail_get_union_champion_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_union_champion(ocid, date=datetime(2023, 12, 20))
        assert 'You can only retrieve data after 2023-12-21' in str(e.value)
        print(e.value)

    async def test_fail_get_union_champion_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_union_champion(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)


if __name__ == '__main__':
    unittest.main()
