using MapleStory.OpenAPI.KMS.DTO;
using Base = MapleStory.OpenAPI.Common;

namespace MapleStory.OpenAPI.KMS
{
    /// <summary>
    /// MapleStory Friends API client for KMS
    /// <para>This is an implementation of <a href="https://openapi.nexon.com/ko/friends/maplestory/?id=36">MapleStory Friends API</a></para>
    /// </summary>
    public class MapleStoryFriendsAPI : Base.MapleStoryFriendsAPI
    {
        public MapleStoryFriendsAPI(string accessToken) : base(accessToken, "maplestory", 540)
        {

        }

        #region 계정 정보 조회

        /// <summary>
        /// 계정의 보유 캐릭터 목록을 조회합니다.
        /// <para>- 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '캐릭터 목록'을 활용 데이터 항목으로 선택해주세요.</para>
        /// <para>- 이후 자세한 데이터 호출 및 활용 방법은 <a href="https://openapi.nexon.com/ko/open-id/development-guide/">NEXON Open ID 개발 가이드 문서</a>를 참조해주세요.</para>
        /// </summary>
        public async Task<CharacterListDTO> GetCharacterList()
        {
            var path = $"{subUrl}/v1/character/list";

            return await Get<CharacterListDTO>(path);
        }

        /// <summary>
        /// 계정의 업적 정보를 조회합니다.
        /// <para>- 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '업정 정보'를 활용 데이터 항목으로 선택해주세요.</para>
        /// <para>- 이후 자세한 데이터 호출 및 활용 방법은 <a href="https://openapi.nexon.com/ko/open-id/development-guide/">NEXON Open ID 개발 가이드 문서</a>를 참조해주세요.</para>
        /// </summary>
        public async Task<AchievementDTO> GetAchievement()
        {
            var path = $"{subUrl}/v1/user/achievement";

            return await Get<AchievementDTO>(path);
        }

        #endregion

        #region 확률 정보 조회

        /// <summary>
        /// 스타포스 강화 결과를 조회합니다.
        /// <para>- 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '스타포스 강화 결과'를 활용 데이터 항목으로 선택해주세요.</para>
        /// <para>- 이후 자세한 데이터 호출 및 활용 방법은 <a href="https://openapi.nexon.com/ko/open-id/development-guide/">NEXON Open ID 개발 가이드 문서</a>를 참조해주세요.</para>
        /// <para>- 스타포스 확률 정보는 최대 5분 후 확인 가능합니다.</para>
        /// <para>- 스타포스 강화 결과는 2023년 12월 27일 데이터부터 조회 가능하며, 최대 2년동안의 데이터만 제공됩니다.</para>
        /// </summary>
        /// <param name="count">한번에 가져오려는 결과의 개수(최소 10, 최대 1000)</param>
        public Task<StarforceHistoryResponseDTO> GetStarforceHistory(int count)
        {
            return GetStarforceHistory(count, GetProperDefaultDateTimeOffset(new Base.Param.LatestApiUpdateTimeOption
            {
                Hour = 0,
                Minute = 0,
                DateOffset = 0
            }));
        }

        /// <summary>
        /// 지목한 날짜의 스타포스 강화 결과를 조회합니다.
        /// <para>- 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '스타포스 강화 결과'를 활용 데이터 항목으로 선택해주세요.</para>
        /// <para>- 이후 자세한 데이터 호출 및 활용 방법은 <a href="https://openapi.nexon.com/ko/open-id/development-guide/">NEXON Open ID 개발 가이드 문서</a>를 참조해주세요.</para>
        /// <para>- 스타포스 확률 정보는 최대 5분 후 확인 가능합니다.</para>
        /// <para>- 스타포스 강화 결과는 2023년 12월 27일 데이터부터 조회 가능하며, 최대 2년동안의 데이터만 제공됩니다.</para>
        /// </summary>
        /// <param name="count">한번에 가져오려는 결과의 개수(최소 10, 최대 1000)</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<StarforceHistoryResponseDTO> GetStarforceHistory(int count, DateTimeOffset dateTimeOffset)
        {
            var path = $"{subUrl}/v1/history/starforce";
            var query = new Dictionary<string, string?>()
            {
                { "count", count.ToString() },
                { "date", ToDateString(dateTimeOffset, MinDate(2023, 12, 27)) }
            };

            return await Get<StarforceHistoryResponseDTO>(path, query);
        }

        /// <summary>
        /// 스타포스 강화 결과를 조회합니다.
        /// <para>- 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '스타포스 강화 결과'를 활용 데이터 항목으로 선택해주세요.</para>
        /// <para>- 이후 자세한 데이터 호출 및 활용 방법은 <a href="https://openapi.nexon.com/ko/open-id/development-guide/">NEXON Open ID 개발 가이드 문서</a>를 참조해주세요.</para>
        /// <para>- 스타포스 확률 정보는 최대 5분 후 확인 가능합니다.</para>
        /// <para>- 스타포스 강화 결과는 2023년 12월 27일 데이터부터 조회 가능하며, 최대 2년동안의 데이터만 제공됩니다.</para>
        /// </summary>
        /// <param name="count">한번에 가져오려는 결과의 개수(최소 10, 최대 1000)</param>
        /// <param name="cursor">페이징 처리를 위한 cursor</param>
        public async Task<StarforceHistoryResponseDTO> GetStarforceHistory(int count, string cursor)
        {
            var path = $"{subUrl}/v1/history/starforce";
            var query = new Dictionary<string, string?>()
            {
                { "count", count.ToString() },
                { "cursor", cursor }
            };

            return await Get<StarforceHistoryResponseDTO>(path, query);
        }

        /// <summary>
        /// 큐브 사용 결과를 조회합니다.
        /// <para>- 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '큐브 사용 결과'를 활용 데이터 항목으로 선택해주세요.</para>
        /// <para>- 이후 자세한 데이터 호출 및 활용 방법은 <a href="https://openapi.nexon.com/ko/open-id/development-guide/">NEXON Open ID 개발 가이드 문서</a>를 참조해주세요.</para>
        /// <para>- 큐브 확률 정보는 최대 30분 후 확인 가능합니다.</para>
        /// <para>- 큐브 사용 결과는 최근 2년 데이터만 조회 가능합니다.</para>
        /// </summary>
        /// <param name="count">한번에 가져오려는 결과의 개수(최소 10, 최대 1000). 옵션 재설정을 3회 진행한 결과가 포함될 경우 입력한 count보다 적은 수로 조회될 수 있습니다.</param>
        public Task<CubeHistoryResponseDTO> GetCubeHistory(int count)
        {
            return GetCubeHistory(count, GetProperDefaultDateTimeOffset(new Base.Param.LatestApiUpdateTimeOption
            {
                Hour = 0,
                Minute = 0,
                DateOffset = 0
            }));
        }

        /// <summary>
        /// 지목한 날짜의 큐브 사용 결과를 조회합니다.
        /// <para>- 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '큐브 사용 결과'를 활용 데이터 항목으로 선택해주세요.</para>
        /// <para>- 이후 자세한 데이터 호출 및 활용 방법은 <a href="https://openapi.nexon.com/ko/open-id/development-guide/">NEXON Open ID 개발 가이드 문서</a>를 참조해주세요.</para>
        /// <para>- 큐브 확률 정보는 최대 30분 후 확인 가능합니다.</para>
        /// <para>- 큐브 사용 결과는 최근 2년 데이터만 조회 가능합니다.</para>
        /// </summary>
        /// <param name="count">한번에 가져오려는 결과의 개수(최소 10, 최대 1000). 옵션 재설정을 3회 진행한 결과가 포함될 경우 입력한 count보다 적은 수로 조회될 수 있습니다.</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<CubeHistoryResponseDTO> GetCubeHistory(int count, DateTimeOffset dateTimeOffset)
        {
            var path = $"{subUrl}/v1/history/cube";
            var query = new Dictionary<string, string?>()
            {
                { "count", count.ToString() },
                { "date", ToDateString(dateTimeOffset) }
            };

            return await Get<CubeHistoryResponseDTO>(path, query);
        }

        /// <summary>
        /// 큐브 사용 결과를 조회합니다.
        /// <para>- 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '큐브 사용 결과'를 활용 데이터 항목으로 선택해주세요.</para>
        /// <para>- 이후 자세한 데이터 호출 및 활용 방법은 <a href="https://openapi.nexon.com/ko/open-id/development-guide/">NEXON Open ID 개발 가이드 문서</a>를 참조해주세요.</para>
        /// <para>- 큐브 확률 정보는 최대 30분 후 확인 가능합니다.</para>
        /// <para>- 큐브 사용 결과는 최근 2년 데이터만 조회 가능합니다.</para>
        /// </summary>
        /// <param name="count">한번에 가져오려는 결과의 개수(최소 10, 최대 1000). 옵션 재설정을 3회 진행한 결과가 포함될 경우 입력한 count보다 적은 수로 조회될 수 있습니다.</param>
        /// <param name="cursor">페이징 처리를 위한 cursor</param>
        public async Task<CubeHistoryResponseDTO> GetCubeHistory(int count, string cursor)
        {
            var path = $"{subUrl}/v1/history/cube";
            var query = new Dictionary<string, string?>()
            {
                { "count", count.ToString() },
                { "cursor", cursor }
            };

            return await Get<CubeHistoryResponseDTO>(path, query);
        }

        /// <summary>
        /// 잠재능력 재설정 이용 결과를 조회합니다.
        /// <para>- 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '잠재능력 재설정 이용 결과'를 활용 데이터 항목으로 선택해주세요.</para>
        /// <para>- 이후 자세한 데이터 호출 및 활용 방법은 <a href="https://openapi.nexon.com/ko/open-id/development-guide/">NEXON Open ID 개발 가이드 문서</a>를 참조해주세요.</para>
        /// <para>- 잠재능력 재설정 정보는 최대 30분 후 확인 가능합니다.</para>
        /// <para>- 잠재능력 재설정 이용 결과는 2024년 01월 25일 데이터부터 조회 가능하며, 최대 2년동안의 데이터만 제공됩니다.</para>
        /// </summary>
        /// <param name="count">한번에 가져오려는 결과의 개수(최소 10, 최대 1000). 옵션 재설정을 3회 진행한 결과가 포함될 경우 입력한 count보다 적은 수로 조회될 수 있습니다.</param>
        public Task<PotentialHistoryResponseDTO> GetPotentialHistory(int count)
        {
            return GetPotentialHistory(count, GetProperDefaultDateTimeOffset(new Base.Param.LatestApiUpdateTimeOption
            {
                Hour = 0,
                Minute = 0,
                DateOffset = 0
            }));
        }

        /// <summary>
        /// 지목한 날짜의 잠재능력 재설정 이용 결과를 조회합니다.
        /// <para>- 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '잠재능력 재설정 이용 결과'를 활용 데이터 항목으로 선택해주세요.</para>
        /// <para>- 이후 자세한 데이터 호출 및 활용 방법은 <a href="https://openapi.nexon.com/ko/open-id/development-guide/">NEXON Open ID 개발 가이드 문서</a>를 참조해주세요.</para>
        /// <para>- 잠재능력 재설정 정보는 최대 30분 후 확인 가능합니다.</para>
        /// <para>- 잠재능력 재설정 이용 결과는 2024년 01월 25일 데이터부터 조회 가능하며, 최대 2년동안의 데이터만 제공됩니다.</para>
        /// </summary>
        /// <param name="count">한번에 가져오려는 결과의 개수(최소 10, 최대 1000). 옵션 재설정을 3회 진행한 결과가 포함될 경우 입력한 count보다 적은 수로 조회될 수 있습니다.</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<PotentialHistoryResponseDTO> GetPotentialHistory(int count, DateTimeOffset dateTimeOffset)
        {
            var path = $"{subUrl}/v1/history/potential";
            var query = new Dictionary<string, string?>()
            {
                { "count", count.ToString() },
                { "date", ToDateString(dateTimeOffset, MinDate(2024, 1, 25)) }
            };

            return await Get<PotentialHistoryResponseDTO>(path, query);
        }

        /// <summary>
        /// 잠재능력 재설정 이용 결과를 조회합니다.
        /// <para>- 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '잠재능력 재설정 이용 결과'를 활용 데이터 항목으로 선택해주세요.</para>
        /// <para>- 이후 자세한 데이터 호출 및 활용 방법은 <a href="https://openapi.nexon.com/ko/open-id/development-guide/">NEXON Open ID 개발 가이드 문서</a>를 참조해주세요.</para>
        /// <para>- 잠재능력 재설정 정보는 최대 30분 후 확인 가능합니다.</para>
        /// <para>- 잠재능력 재설정 이용 결과는 2024년 01월 25일 데이터부터 조회 가능하며, 최대 2년동안의 데이터만 제공됩니다.</para>
        /// </summary>
        /// <param name="count">한번에 가져오려는 결과의 개수(최소 10, 최대 1000). 옵션 재설정을 3회 진행한 결과가 포함될 경우 입력한 count보다 적은 수로 조회될 수 있습니다.</param>
        /// <param name="cursor">페이징 처리를 위한 cursor</param>
        public async Task<PotentialHistoryResponseDTO> GetPotentialHistory(int count, string cursor)
        {
            var path = $"{subUrl}/v1/history/potential";
            var query = new Dictionary<string, string?>()
            {
                { "count", count.ToString() },
                { "cursor", cursor }
            };

            return await Get<PotentialHistoryResponseDTO>(path, query);
        }

        #endregion
    }
}
