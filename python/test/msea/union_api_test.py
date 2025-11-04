import os
import sys
import unittest
import pytest

from datetime import datetime
from dotenv import load_dotenv

sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '../')))

from maplestory_openapi.api.common import MapleStoryApiException
from maplestory_openapi.api.msea import MapleStoryApi

load_dotenv()

api_key = os.environ['API_KEY_MSEA'] # Your API Key
api = MapleStoryApi(api_key)

ocid = 'caee7cf6ec6cb067c33b899f2779f3d1'

# Union Information Retrieval

class TestGetUnion(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_union(self):
        response = await api.get_union(ocid)
        # nothing to assert because some characters may not have union
        print(response)

    async def test_success_get_union_with_date(self):
        response = await api.get_union(ocid, date=datetime(2025, 4, 20))
        assert response is not None
        print(response)

    async def test_fail_get_union_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_union(ocid, date=datetime(2023, 4, 19))
        assert 'You can only retrieve data after 2025-04-20' in str(e.value)
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
        # nothing to assert because some characters may not have union raider
        print(response)

    async def test_success_get_union_raider_with_date(self):
        response = await api.get_union_raider(ocid, date=datetime(2025, 4, 20))
        assert response is not None
        print(response)

    async def test_fail_get_union_raider_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_union_raider(ocid, date=datetime(2023, 4, 19))
        assert 'You can only retrieve data after 2025-04-20' in str(e.value)
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
        # nothing to assert because some characters may not have union artifact
        print(response)

    async def test_success_get_union_artifact_with_date(self):
        response = await api.get_union_artifact(ocid, date=datetime(2025, 4, 20))
        assert response is not None
        print(response)

    async def test_fail_get_union_artifact_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_union_artifact(ocid, date=datetime(2023, 4, 19))
        assert 'You can only retrieve data after 2025-04-20' in str(e.value)
        print(e.value)

    async def test_fail_get_union_artifact_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_union_artifact(invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)


if __name__ == '__main__':
    unittest.main()
