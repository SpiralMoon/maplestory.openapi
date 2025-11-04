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

# History Information Retrieval

class TestGetStarforceHistory(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_starforce_history(self):
        count = 1000
        response = await api.get_starforce_history(count)
        print(response)

    async def test_success_get_starforce_history_with_date(self):
        count = 1000
        response = await api.get_starforce_history(count, date=datetime(2025, 9, 21))
        print(response)

    async def test_success_get_starforce_history_with_cursor(self):
        count = 10
        response = await api.get_starforce_history(count, date=datetime(2025, 9, 21))
        next_cursor = response.next_cursor
        assert next_cursor is not None
        next_response = await api.get_starforce_history(count, cursor=next_cursor)
        print(next_response)

    async def test_fail_get_starforce_history_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_starforce_history(1000, date=datetime(2023, 12, 26))
        assert 'You can only retrieve data after 2023-12-27' in str(e.value)
        print(e.value)

    async def test_fail_get_starforce_history_with_invalid_cursor_throw_OPENAPI00003(self):
        invalid_cursor = 'invalid_cursor_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_starforce_history(1000, cursor=invalid_cursor)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_starforce_history_with_excessive_count_throw_OPENAPI00004(self):
        count = 9999
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_starforce_history(count)
        assert e.value.error_code == 'OPENAPI00004'
        print(e.value.error_code, e.value.message)


class TestGetPotentialHistory(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_potential_history(self):
        count = 1000
        response = await api.get_potential_history(count)
        print(response)

    async def test_success_get_potential_history_with_date(self):
        count = 1000
        response = await api.get_potential_history(count, date=datetime(2025, 7, 31))
        print(response)

    async def test_success_get_potential_history_with_cursor(self):
        count = 10
        response = await api.get_potential_history(count, date=datetime(2025, 7, 31))
        next_cursor = response.next_cursor
        assert next_cursor is not None
        next_response = await api.get_potential_history(count, cursor=next_cursor)
        print(next_response)

    async def test_fail_get_potential_history_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_potential_history(1000, date=datetime(2024, 1, 24))
        assert 'You can only retrieve data after 2024-01-25' in str(e.value)
        print(e.value)

    async def test_fail_get_potential_history_with_invalid_cursor_throw_OPENAPI00003(self):
        invalid_cursor = 'invalid_cursor_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_potential_history(1000, cursor=invalid_cursor)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_potential_history_with_excessive_count_throw_OPENAPI00004(self):
        count = 9999
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_potential_history(count)
        assert e.value.error_code == 'OPENAPI00004'
        print(e.value.error_code, e.value.message)


class TestGetCubeHistory(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_cube_history(self):
        count = 1000
        response = await api.get_cube_history(count)
        print(response)

    async def test_success_get_cube_history_with_date(self):
        count = 1000
        response = await api.get_cube_history(count, date=datetime(2025, 10, 23))
        print(response)

    async def test_success_get_cube_history_with_cursor(self):
        count = 10
        response = await api.get_cube_history(count, date=datetime(2025, 10, 23))
        next_cursor = response.next_cursor
        assert next_cursor is not None
        next_response = await api.get_cube_history(count, cursor=next_cursor)
        print(next_response)

    async def test_fail_get_cube_history_with_invalid_cursor_throw_OPENAPI00003(self):
        invalid_cursor = 'invalid_cursor_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_cube_history(1000, cursor=invalid_cursor)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)

    async def test_fail_get_cube_history_with_excessive_count_throw_OPENAPI00004(self):
        count = 9999
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_potential_history(count)
        assert e.value.error_code == 'OPENAPI00004'
        print(e.value.error_code, e.value.message)


if __name__ == '__main__':
    unittest.main()
