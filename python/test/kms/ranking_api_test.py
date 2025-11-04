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

# Ranking Information Retrieval

class TestGetOverallRanking(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_overall_ranking(self):
        response = await api.get_overall_ranking()
        print(response)

    async def test_success_get_overall_ranking_with_paging(self):
        response = await api.get_overall_ranking(page=2)
        print(response)

    async def test_success_get_overall_ranking_with_ocid(self):
        response = await api.get_overall_ranking(ocid=ocid)
        print(response)

    async def test_success_get_overall_ranking_with_specific_job(self):
        response = await api.get_overall_ranking(class_name='전사-히어로')
        print(response)

    async def test_success_get_overall_ranking_with_job_group(self):
        response = await api.get_overall_ranking(class_name='전사-전체 전직')
        print(response)

    async def test_success_get_overall_ranking_with_world_name(self):
        response = await api.get_overall_ranking(world_name='스카니아')
        print(response)

    async def test_success_get_overall_ranking_with_world_type(self):
        response = await api.get_overall_ranking(world_type=0)
        print(response)

    async def test_success_get_overall_ranking_with_world_and_job(self):
        response = await api.get_overall_ranking(world_name='스카니아', class_name='아델-전체 전직')
        print(response)

    async def test_success_get_overall_ranking_with_date(self):
        response = await api.get_overall_ranking(date=datetime(2023, 12, 23))
        print(response)

    async def test_fail_get_overall_ranking_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_overall_ranking(date=datetime(2023, 12, 21))
        assert 'You can only retrieve data after 2023-12-22' in str(e.value)
        print(e.value)

    async def test_fail_get_overall_ranking_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_overall_ranking(ocid=invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)


class TestGetUnionRanking(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_union_ranking(self):
        response = await api.get_union_ranking()
        print(response)

    async def test_success_get_union_ranking_with_paging(self):
        response = await api.get_union_ranking(page=2)
        print(response)

    async def test_success_get_union_ranking_with_ocid(self):
        response = await api.get_union_ranking(ocid=ocid)
        assert len(response.ranking) == 1
        print(response)

    async def test_success_get_union_ranking_with_world_name(self):
        response = await api.get_union_ranking(world_name='스카니아')
        assert len(response.ranking) > 0
        print(response)

    async def test_success_get_union_ranking_with_date(self):
        response = await api.get_union_ranking(date=datetime(2023, 12, 23))
        print(response)

    async def test_fail_get_union_ranking_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_union_ranking(date=datetime(2023, 12, 21))
        assert 'You can only retrieve data after 2023-12-22' in str(e.value)
        print(e.value)

    async def test_fail_get_union_ranking_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_union_ranking(ocid=invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)


class TestGetGuildRanking(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_guild_ranking(self):
        response = await api.get_guild_ranking()
        print(response)

    async def test_success_get_guild_ranking_with_paging(self):
        response = await api.get_guild_ranking(ranking_type=0, page=2)
        print(response)

    async def test_success_get_guild_ranking_with_guild_name(self):
        response = await api.get_guild_ranking(ranking_type=0, guild_name='리더')
        assert len(response.ranking) > 0
        print(response)

    async def test_success_get_guild_ranking_with_world_name(self):
        response = await api.get_guild_ranking(ranking_type=0, world_name='스카니아')
        assert len(response.ranking) > 0
        print(response)

    async def test_success_get_guild_ranking_with_world_and_guild_name(self):
        response = await api.get_guild_ranking(ranking_type=0, world_name='스카니아', guild_name='리더')
        assert len(response.ranking) <= 1
        print(response)

    async def test_success_get_guild_ranking_with_date(self):
        response = await api.get_guild_ranking(date=datetime(2023, 12, 23))
        print(response)

    async def test_fail_get_guild_ranking_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_guild_ranking(date=datetime(2023, 12, 21))
        assert 'You can only retrieve data after 2023-12-22' in str(e.value)
        print(e.value)

    async def test_success_get_guild_ranking_with_invalid_guild_name(self):
        invalid_guild_name = 'invalid_guild_name_123'
        response = await api.get_guild_ranking(ranking_type=0, guild_name=invalid_guild_name)
        assert len(response.ranking) == 0
        print(response)

    async def test_fail_get_guild_ranking_with_invalid_ranking_type_throw_OPENAPI00004(self):
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_guild_ranking(ranking_type=-1)
        assert e.value.error_code == 'OPENAPI00004'
        print(e.value.error_code, e.value.message)


class TestGetDojangRanking(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_dojang_ranking(self):
        response = await api.get_dojang_ranking()
        print(response)

    async def test_success_get_dojang_ranking_with_paging(self):
        response = await api.get_dojang_ranking(difficulty=1, page=2)
        print(response)

    async def test_success_get_dojang_ranking_with_ocid(self):
        response = await api.get_dojang_ranking(difficulty=1, ocid=ocid)
        assert len(response.ranking) >= 0
        print(response)

    async def test_success_get_dojang_ranking_with_world_name(self):
        response = await api.get_dojang_ranking(difficulty=1, world_name='스카니아')
        print(response)

    async def test_success_get_dojang_ranking_with_specific_job(self):
        response = await api.get_dojang_ranking(difficulty=1, class_name='전사-히어로')
        print(response)

    async def test_success_get_dojang_ranking_with_date(self):
        response = await api.get_dojang_ranking(date=datetime(2023, 12, 23))
        print(response)

    async def test_fail_get_dojang_ranking_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_dojang_ranking(date=datetime(2023, 12, 21))
        assert 'You can only retrieve data after 2023-12-22' in str(e.value)
        print(e.value)

    async def test_fail_get_dojang_ranking_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_dojang_ranking(difficulty=1, ocid=invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)


class TestGetTheSeedRanking(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_theseed_ranking(self):
        response = await api.get_theseed_ranking()
        print(response)

    async def test_success_get_theseed_ranking_with_paging(self):
        response = await api.get_theseed_ranking(page=2)
        print(response)

    async def test_success_get_theseed_ranking_with_ocid(self):
        response = await api.get_theseed_ranking(ocid=ocid)
        assert len(response.ranking) >= 0
        print(response)

    async def test_success_get_theseed_ranking_with_world_name(self):
        response = await api.get_theseed_ranking(world_name='스카니아')
        assert len(response.ranking) > 0
        print(response)

    async def test_success_get_theseed_ranking_with_date(self):
        response = await api.get_theseed_ranking(date=datetime(2023, 12, 23))
        print(response)

    async def test_fail_get_theseed_ranking_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_theseed_ranking(date=datetime(2023, 12, 21))
        assert 'You can only retrieve data after 2023-12-22' in str(e.value)
        print(e.value)

    async def test_fail_get_theseed_ranking_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_theseed_ranking(ocid=invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)


class TestGetAchievementRanking(unittest.IsolatedAsyncioTestCase):
    async def test_success_get_achievement_ranking(self):
        response = await api.get_achievement_ranking()
        print(response)

    async def test_success_get_achievement_ranking_with_paging(self):
        response = await api.get_achievement_ranking(page=2)
        print(response)

    async def test_success_get_achievement_ranking_with_ocid(self):
        response = await api.get_achievement_ranking(ocid=ocid)
        assert len(response.ranking) >= 0
        print(response)

    async def test_success_get_achievement_ranking_with_date(self):
        response = await api.get_achievement_ranking(date=datetime(2023, 12, 23))
        print(response)

    async def test_fail_get_achievement_ranking_with_invalid_date(self):
        with pytest.raises(Exception) as e:
            await api.get_achievement_ranking(date=datetime(2023, 12, 21))
        assert 'You can only retrieve data after 2023-12-22' in str(e.value)
        print(e.value)

    async def test_fail_get_achievement_ranking_with_invalid_ocid_throw_OPENAPI00003(self):
        invalid_ocid = 'invalid_ocid_123'
        with pytest.raises(MapleStoryApiException) as e:
            await api.get_achievement_ranking(ocid=invalid_ocid)
        assert e.value.error_code == 'OPENAPI00003'
        print(e.value.error_code, e.value.message)


if __name__ == '__main__':
    unittest.main()
