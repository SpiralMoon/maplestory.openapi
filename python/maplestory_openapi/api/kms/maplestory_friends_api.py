from datetime import datetime

from maplestory_openapi.api.kms.dto.user.achievement import Achievement
from maplestory_openapi.api.kms.dto.user.character_list import CharacterList

from maplestory_openapi.api.kms.dto.history.cube_history import CubeHistory
from maplestory_openapi.api.kms.dto.history.potential_history import PotentialHistory
from maplestory_openapi.api.kms.dto.history.starforce_history import StarforceHistory

from maplestory_openapi.api.common.maplestory_friends_api import MapleStoryFriendsApi as BaseMapleStoryFriendsApi


class MapleStoryFriendsApi(BaseMapleStoryFriendsApi):

    def __init__(self, access_token: str, timeout: int = 5000):
        super().__init__(
            access_token=access_token,
            timezone='Asia/Seoul',
            sub_url='maplestory',
            timeout=timeout,
        )

    #region 계정 정보 조회

    async def get_character_list(self) -> CharacterList:
        """
        계정의 보유 캐릭터 목록을 조회합니다.

        - 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '캐릭터 목록'을 활용 데이터 항목으로 선택해주세요.
        - 이후 자세한 데이터 호출 및 활용 방법은 NEXON Open ID 개발 가이드 문서(https://openapi.nexon.com/ko/open-id/development-guide/)를 참조해주세요.
        """

        path = self.sub_url + '/v1/character/list'
        query = {}
        r = await self.fetch(path, query)
        return CharacterList(**r)

    async def get_achievement(self) -> Achievement:
        """
        계정의 업적 정보를 조회합니다.

        - 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '업적 정보'를 활용 데이터 항목으로 선택해주세요.
        - 이후 자세한 데이터 호출 및 활용 방법은 NEXON Open ID 개발 가이드 문서(https://openapi.nexon.com/ko/open-id/development-guide/)를 참조해주세요.
        """

        path = self.sub_url + '/v1/user/achievement'
        query = {}
        r = await self.fetch(path, query)
        return Achievement(**r)

    #endregion

    #region 확률 정보 조회

    async def get_starforce_history(self, count: int, date: datetime | None = None, cursor: str | None = None) -> StarforceHistory:
        """
        스타포스 강화 결과를 조회합니다.

        - 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '스타포스 강화 결과'를 활용 데이터 항목으로 선택해주세요.
        - 이후 자세한 데이터 호출 및 활용 방법은 NEXON Open ID 개발 가이드 문서(https://openapi.nexon.com/ko/open-id/development-guide/)를 참조해주세요.
        - 스타포스 확률 정보는 최대 5분 후 확인 가능합니다.
        - 스타포스 강화 결과는 2023년 12월 27일 데이터부터 조회 가능하며, 최대 2년동안의 데이터만 제공됩니다.

        Args:
            count(int): 한번에 가져오려는 결과의 갯수(최소 10, 최대 1000)
            date(datetime or None): 조회 기준일 (KST) (cursor가 없는 경우 필수이며 cursor와 함께 사용 불가)
            cursor(str or None): 페이징 처리를 위한 cursor (date가 없는 경우 필수이며 date와 함께 사용 불가)
        """
        path = self.sub_url + '/v1/history/starforce'
        query = {
            'count': count,
        }

        if cursor is None:
            query['date'] = self._to_date_string(self._get_proper_default_datetime(day_offset=0) if date is None else date, datetime(2023, 12, 27)) ,
        else:
            query['cursor'] = cursor

        r = await self.fetch(path, query)
        return StarforceHistory(**r)

    async def get_cube_history(self, count: int, date: datetime | None = None, cursor: str | None = None) -> CubeHistory:
        """
        큐브 사용 결과를 조회합니다.

        - 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '큐브 사용 결과'를 활용 데이터 항목으로 선택해주세요.
        - 이후 자세한 데이터 호출 및 활용 방법은 <a href="https://openapi.nexon.com/ko/open-id/development-guide/">NEXON Open ID 개발 가이드 문서</a>를 참조해주세요.
        - 큐브 확률 정보는 최대 30분 후 확인 가능합니다.
        - 큐브 사용 결과는 최근 2년 데이터만 조회 가능합니다.

        Args:
            count(int): 한번에 가져오려는 결과의 갯수(최소 10, 최대 1000). 옵션 재설정을 3회 진행한 결과가 포함될 경우 입력한 count보다 적은 수로 조회될 수 있습니다.
            date(datetime or None): 조회 기준일 (KST) (cursor가 없는 경우 필수이며 cursor와 함께 사용 불가)
            cursor(str or None): 페이징 처리를 위한 cursor (date가 없는 경우 필수이며 date와 함께 사용 불가)
        """
        path = self.sub_url + '/v1/history/cube'
        query = {
            'count': count,
        }

        if cursor is None:
            query['date'] = self._to_date_string(self._get_proper_default_datetime(day_offset=0, update_hour=0) if date is None else date)
        else:
            query['cursor'] = cursor

        r = await self.fetch(path, query)
        return CubeHistory(**r)

    async def get_potential_history(self, count: int, date: datetime | None = None, cursor: str | None = None) -> PotentialHistory:
        """
        잠재능력 재설정 이용 결과를 조회합니다.

        - 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '잠재능력 재설정 이용 결과'를 활용 데이터 항목으로 선택해주세요.
        - 이후 자세한 데이터 호출 및 활용 방법은 <a href="https://openapi.nexon.com/ko/open-id/development-guide/">NEXON Open ID 개발 가이드 문서</a>를 참조해주세요.
        - 잠재능력 재설정 정보는 최대 30분 후 확인 가능합니다.
        - 잠재능력 재설정 이용 결과는 2024년 01월 25일 데이터부터 조회 가능하며, 최대 2년동안의 데이터만 제공됩니다.

        Args:
            count(int): 한번에 가져오려는 결과의 갯수(최소 10, 최대 1000). 옵션 재설정을 3회 진행한 결과가 포함될 경우 입력한 count보다 적은 수로 조회될 수 있습니다.
            date(datetime or None): 조회 기준일 (KST) (cursor가 없는 경우 필수이며 cursor와 함께 사용 불가)
            cursor(str or None): 페이징 처리를 위한 cursor (date가 없는 경우 필수이며 date와 함께 사용 불가)
        """
        path = self.sub_url + '/v1/history/potential'
        query = {
            'count': count,
        }

        if cursor is None:
            query['date'] = self._to_date_string(self._get_proper_default_datetime(day_offset=0, update_hour=0) if date is None else date, datetime(2024, 1, 25)) ,
        else:
            query['cursor'] = cursor

        r = await self.fetch(path, query)
        return PotentialHistory(**r)

    #endregion
