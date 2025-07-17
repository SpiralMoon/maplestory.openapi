using MapleStory.OpenAPI.Common;
using MapleStory.OpenAPI.Common.Param;
using MapleStory.OpenAPI.KMS.DTO;
using RestSharp;
using Base = MapleStory.OpenAPI.Common;

namespace MapleStory.OpenAPI.KMS
{
    /// <summary>
    /// MapleStory OpenAPI client for KMS.
    /// <para>This is an implementation of <a href="https://openapi.nexon.com/game/maplestory">MapleStory API</a></para>
    /// </summary>
    public class MapleStoryAPI : MapleStoryAPIInherit
    {
        public MapleStoryAPI(string apiKey): base(apiKey, "maplestory", 540)
        {

        }

        #region 계정 정보 조회

        /// <summary>
        /// 계정의 보유 캐릭터 목록을 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        public async Task<CharacterListDTO> GetCharacterList()
        {
            var path = $"{subUrl}/v1/character/list";

            return await Get<CharacterListDTO>(path);
        }

        /// <summary>
        /// 계정의 업적 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        public async Task<AchievementDTO> GetAchievement()
        {
            var path = $"{subUrl}/v1/user/achievement";

            return await Get<AchievementDTO>(path);
        }

        #endregion

        #region 캐릭터 정보 조회

        /// <summary>
        /// 캐릭터 식별자(ocid)를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="characterName">캐릭터 명</param>
        public override async Task<CharacterDTO> GetCharacter(string characterName)
        {
            var path = $"{subUrl}/v1/id";
            var query = new Dictionary<string, string?>()
            {
                { "character_name", characterName }
            };

            return await Get<CharacterDTO>(path, query);
        }

        /// <summary>
        /// 기본 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public override Task<CharacterBasicDTO> GetCharacterBasic(string ocid)
        {
            return GetCharacterBasic(ocid, null);
        }

        /// <summary>
        /// 기본 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public override async Task<CharacterBasicDTO> GetCharacterBasic(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/basic";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2023, 12, 21))
                : null;

            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterBasicDTO>(path, query);
        }

        /// <summary>
        /// 캐릭터 외형 이미지 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public override Task<CharacterImageDTO> GetCharacterImage(string ocid)
        {
            return GetCharacterImage(ocid, new CharacterImageOption(), null);
        }

        /// <summary>
        /// 캐릭터 외형 이미지 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="imageOption">캐릭터 외형 파라미터</param>
        public override Task<CharacterImageDTO> GetCharacterImage(string ocid, CharacterImageOption imageOption)
        {
            return GetCharacterImage(ocid, imageOption, null);
        }

        /// <summary>
        /// 캐릭터 외형 이미지 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="imageOption">캐릭터 외형 파라미터</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public override async Task<CharacterImageDTO> GetCharacterImage(string ocid, CharacterImageOption imageOption, DateTimeOffset? dateTimeOffset)
        {
            var basic = await GetCharacterBasic(ocid, dateTimeOffset);

            var action = imageOption.Action;
            var emotion = imageOption.Emotion;
            var wmotion = imageOption.Wmotion;
            var actionFrame = imageOption.ActionFrame;
            var emotionFrame = imageOption.EmotionFrame;
            var width = imageOption.Width;
            var height = imageOption.Height;
            var x = imageOption.X;
            var y = imageOption.Y;

            var path = basic.CharacterImage.Replace(BASE_URL, "");
            var query = new Dictionary<string, string?>()
            {
                { "action", $"{action.GetValue()}.{actionFrame}" },
                { "emotion", $"{emotion.GetValue()}.{emotionFrame}" },
                { "wmotion", wmotion.GetValue() },
                { "width", width.ToString() },
                { "height", height.ToString() },
                { "x", x?.ToString() },
                { "y", y?.ToString() },
            };

            var tasks = await Task.WhenAll(new List<Task<string>>()
            {
                urlImageToBase64(path, null),
                urlImageToBase64(path, query),
            });
            var (originImage, image) = (tasks[0], tasks[1]);

            return new CharacterImageDTO
            {
                Date = basic.Date,
                OriginUrl = basic.CharacterImage,
                OriginImage = originImage,
                Image = image,
                Action = action,
                Emotion = emotion,
                Wmotion = wmotion,
                ActionFrame = actionFrame,
                EmotionFrame = emotionFrame,
                Width = width,
                Height = height,
                X = x,
                Y = y,
            };
        }

        /// <summary>
        /// 인기도 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public override Task<CharacterPopularityDTO> GetCharacterPopularity(string ocid)
        {
            return GetCharacterPopularity(ocid, null);
        }

        /// <summary>
        /// 인기도 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public override async Task<CharacterPopularityDTO> GetCharacterPopularity(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/popularity";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2023, 12, 21))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterPopularityDTO>(path, query);
        }

        /// <summary>
        /// 종합 능력치 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        public override Task<CharacterStatDTO> GetCharacterStat(string ocid)
        {
            return GetCharacterStat(ocid, null);
        }

        /// <summary>
        /// 종합 능력치 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public override async Task<CharacterStatDTO> GetCharacterStat(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/stat";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2023, 12, 21))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterStatDTO>(path, query);
        }

        /// <summary>
        /// 하이퍼스탯 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public override Task<CharacterHyperStatDTO> GetCharacterHyperStat(string ocid)
        {
            return GetCharacterHyperStat(ocid, null);
        }

        /// <summary>
        /// 하이퍼스탯 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public override async Task<CharacterHyperStatDTO> GetCharacterHyperStat(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/hyper-stat";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2023, 12, 21))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterHyperStatDTO>(path, query);
        }

        /// <summary>
        /// 성향 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public override Task<CharacterPropensityDTO> GetCharacterPropensity(string ocid)
        {
            return GetCharacterPropensity(ocid, null);
        }

        /// <summary>
        /// 성향 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public override async Task<CharacterPropensityDTO> GetCharacterPropensity(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/propensity";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2023, 12, 21))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterPropensityDTO>(path, query);
        }

        /// <summary>
        /// 어빌리티 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public override Task<CharacterAbilityDTO> GetCharacterAbility(string ocid)
        {
            return GetCharacterAbility(ocid, null);
        }

        /// <summary>
        /// 어빌리티 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public override async Task<CharacterAbilityDTO> GetCharacterAbility(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/ability";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2023, 12, 21))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterAbilityDTO>(path, query);
        }

        /// <summary>
        /// 장착한 장비 중 캐시 장비를 제외한 나머지 장비 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public override Task<CharacterItemEquipmentDTO> GetCharacterItemEquipment(string ocid)
        {
            return GetCharacterItemEquipment(ocid, null);
        }

        /// <summary>
        /// 장착한 장비 중 캐시 장비를 제외한 나머지 장비 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public override async Task<CharacterItemEquipmentDTO> GetCharacterItemEquipment(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/item-equipment";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2023, 12, 21))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterItemEquipmentDTO>(path, query);
        }

        /// <summary>
        /// 장착한 캐시 장비 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public override Task<CharacterCashItemEquipmentDTO> GetCharacterCashItemEquipment(string ocid)
        {
            return GetCharacterCashItemEquipment(ocid, null);
        }

        /// <summary>
        /// 장착한 캐시 장비 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public override async Task<CharacterCashItemEquipmentDTO> GetCharacterCashItemEquipment(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/cashitem-equipment";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2023, 12, 21))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterCashItemEquipmentDTO>(path, query);
        }

        /// <summary>
        /// 장착한 심볼 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public override Task<CharacterSymbolEquipmentDTO> GetCharacterSymbolEquipment(string ocid)
        {
            return GetCharacterSymbolEquipment(ocid, null);
        }

        /// <summary>
        /// 장착한 심볼 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public override async Task<CharacterSymbolEquipmentDTO> GetCharacterSymbolEquipment(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/symbol-equipment";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2023, 12, 21))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterSymbolEquipmentDTO>(path, query);
        }

        /// <summary>
        /// 적용받고 있는 세트 효과 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public override Task<CharacterSetEffectDTO> GetCharacterSetEffect(string ocid)
        {
            return GetCharacterSetEffect(ocid, null);
        }

        /// <summary>
        /// 적용받고 있는 세트 효과 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public override async Task<CharacterSetEffectDTO> GetCharacterSetEffect(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/set-effect";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2023, 12, 21))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterSetEffectDTO>(path, query);
        }

        /// <summary>
        /// 장착 중인 헤어, 성형, 피부 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public override Task<CharacterBeautyEquipmentDTO> GetCharacterBeautyEquipment(string ocid)
        {
            return GetCharacterBeautyEquipment(ocid, null);
        }

        /// <summary>
        /// 장착 중인 헤어, 성형, 피부 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public override async Task<CharacterBeautyEquipmentDTO> GetCharacterBeautyEquipment(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/beauty-equipment";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2023, 12, 21))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterBeautyEquipmentDTO>(path, query);
        }

        /// <summary>
        /// 장착한 안드로이드 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public override Task<CharacterAndroidEquipmentDTO> GetCharacterAndroidEquipment(string ocid)
        {
            return GetCharacterAndroidEquipment(ocid, null);
        }

        /// <summary>
        /// 장착한 안드로이드 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public override async Task<CharacterAndroidEquipmentDTO> GetCharacterAndroidEquipment(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/android-equipment";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2023, 12, 21))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterAndroidEquipmentDTO>(path, query);
        }

        /// <summary>
        /// 장착한 펫 및 펫 스킬, 장비 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public override Task<CharacterPetEquipmentDTO> GetCharacterPetEquipment(string ocid)
        {
            return GetCharacterPetEquipment(ocid, null);
        }

        /// <summary>
        /// 장착한 펫 및 펫 스킬, 장비 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public override async Task<CharacterPetEquipmentDTO> GetCharacterPetEquipment(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/pet-equipment";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2023, 12, 21))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterPetEquipmentDTO>(path, query);
        }

        /// <summary>
        /// 캐릭터 스킬과 하이퍼 스킬 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="characterSkillGrade">조회하고자 하는 전직 차수 <a href="https://openapi.nexon.com/ko/game/maplestory/?id=14">Available values</a></param>
        public override Task<CharacterSkillDTO> GetCharacterSkill(string ocid, string characterSkillGrade)
        {
            return GetCharacterSkill(ocid, characterSkillGrade, null);
        }

        /// <summary>
        /// 캐릭터 스킬과 하이퍼 스킬 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="characterSkillGrade">조회하고자 하는 전직 차수 <a href="https://openapi.nexon.com/ko/game/maplestory/?id=14">Available values</a></param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>

        public override async Task<CharacterSkillDTO> GetCharacterSkill(string ocid, string characterSkillGrade, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/skill";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2023, 12, 21))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date },
                { "character_skill_grade", characterSkillGrade }
            };

            return await Get<CharacterSkillDTO>(path, query);
        }

        /// <summary>
        /// 장착 링크 스킬 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public override Task<CharacterLinkSkillDTO> GetCharacterLinkSkill(string ocid)
        {
            return GetCharacterLinkSkill(ocid, null);
        }

        /// <summary>
        /// 장착 링크 스킬 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public override async Task<CharacterLinkSkillDTO> GetCharacterLinkSkill(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/link-skill";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2023, 12, 21))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterLinkSkillDTO>(path, query);
        }

        /// <summary>
        /// V매트릭스 슬롯 정보와 장착한 V코어 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public override Task<CharacterVMatrixDTO> GetCharacterVMatrix(string ocid)
        {
            return GetCharacterVMatrix(ocid, null);
        }

        /// <summary>
        /// V매트릭스 슬롯 정보와 장착한 V코어 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public override async Task<CharacterVMatrixDTO> GetCharacterVMatrix(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/vmatrix";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2023, 12, 21))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterVMatrixDTO>(path, query);
        }

        /// <summary>
        /// HEXA 매트릭스에 장착한 HEXA 코어 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public override Task<CharacterHexaMatrixDTO> GetCharacterHexaMatrix(string ocid)
        {
            return GetCharacterHexaMatrix(ocid, null);
        }

        /// <summary>
        /// HEXA 매트릭스에 장착한 HEXA 코어 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public override async Task<CharacterHexaMatrixDTO> GetCharacterHexaMatrix(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/hexamatrix";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2023, 12, 21))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterHexaMatrixDTO>(path, query);
        }

        /// <summary>
        /// HEXA 매트릭스에 설정한 HEXA 스탯 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public override Task<CharacterHexaMatrixStatDTO> GetCharacterHexaMatrixStat(string ocid)
        {
            return GetCharacterHexaMatrixStat(ocid, null);
        }

        /// <summary>
        /// HEXA 매트릭스에 설정한 HEXA 스탯 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public override async Task<CharacterHexaMatrixStatDTO> GetCharacterHexaMatrixStat(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/hexamatrix-stat";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2023, 12, 21))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterHexaMatrixStatDTO>(path, query);
        }

        /// <summary>
        /// 캐릭터 무릉도장 최고 기록 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public override Task<CharacterDojangDTO> GetCharacterDojang(string ocid)
        {
            return GetCharacterDojang(ocid, null);
        }

        /// <summary>
        /// 캐릭터 무릉도장 최고 기록 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public override async Task<CharacterDojangDTO> GetCharacterDojang(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/character/dojang";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2023, 12, 21))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<CharacterDojangDTO>(path, query);
        }

        #endregion

        #region 유니온 정보 조회

        /// <summary>
        /// 유니온 레벨 및 유니온 등급 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public override Task<UnionDTO> GetUnion(string ocid)
        {
            return GetUnion(ocid, null);
        }

        /// <summary>
        /// 유니온 레벨 및 유니온 등급 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public override async Task<UnionDTO> GetUnion(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/user/union";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2023, 12, 21))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<UnionDTO>(path, query);
        }

        /// <summary>
        /// 유니온에 배치된 공격대원 효과 및 공격대 점령 효과 등 상세 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public override Task<UnionRaiderDTO> GetUnionRaider(string ocid)
        {
            return GetUnionRaider(ocid, null);
        }

        /// <summary>
        /// 유니온에 배치된 공격대원 효과 및 공격대 점령 효과 등 상세 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public override async Task<UnionRaiderDTO> GetUnionRaider(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/user/union-raider";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2023, 12, 21))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<UnionRaiderDTO>(path, query);
        }

        /// <summary>
        /// 유니온 아티팩트 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public override Task<UnionArtifactDTO> GetUnionArtifact(string ocid)
        {
            return GetUnionArtifact(ocid, null);
        }

        /// <summary>
        /// 유니온 아티팩트 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public override async Task<UnionArtifactDTO> GetUnionArtifact(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/user/union-artifact";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2023, 12, 21))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<UnionArtifactDTO>(path, query);
        }

        /// <summary>
        /// 유니온 챔피언 정보를 조회합니다.
        /// 유니온 챔피언 정보는 2025년 2월 20일 메이플스토리 점검 이후 데이터부터 조회 가능합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<UnionChampionDTO> GetUnionChampion(string ocid)
        {
            return GetUnionChampion(ocid, null);
        }

        /// <summary>
        /// 유니온 챔피언 정보를 조회합니다.
        /// 유니온 챔피언 정보는 2025년 2월 20일 메이플스토리 점검 이후 데이터부터 조회 가능합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<UnionChampionDTO> GetUnionChampion(string ocid, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/user/union-champion";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2023, 12, 21))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", date }
            };

            return await Get<UnionChampionDTO>(path, query);
        }

        #endregion

        #region 길드 정보 조회

        /// <summary>
        /// 길드 식별자(oguild_id) 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="guildName">길드 명</param>
        /// <param name="wolrdName">월드 명 <a href="https://openapi.nexon.com/ko/game/maplestory/?id=16">Available values</a></param>
        public override async Task<GuildDTO> GetGuild(string guildName, string wolrdName)
        {
            var path = $"{subUrl}/v1/guild/id";
            var query = new Dictionary<string, string?>()
            {
                { "guild_name", guildName },
                { "world_name", wolrdName }
            };

            return await Get<GuildDTO>(path, query);
        }

        /// <summary>
        /// 길드 기본 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="oGuildId">길드 식별자</param>
        public override Task<GuildBasicDTO> GetGuildBasic(string oGuildId)
        {
            return GetGuildBasic(oGuildId, null);
        }

        /// <summary>
        /// 길드 기본 정보를 조회합니다.
        /// <para>- 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.</para>
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// <para>- 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.</para>
        /// </summary>
        /// <param name="oGuildId">길드 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        /// <returns>길드 기본 정보</returns>
        public override async Task<GuildBasicDTO> GetGuildBasic(string oGuildId, DateTimeOffset? dateTimeOffset)
        {
            var path = $"{subUrl}/v1/guild/basic";
            var date = dateTimeOffset != null
                ? ToDateString((DateTimeOffset) dateTimeOffset, MinDate(2023, 12, 21))
                : null;
            var query = new Dictionary<string, string?>()
            {
                { "oguild_id", oGuildId },
                { "date", date }
            };

            return await Get<GuildBasicDTO>(path, query);
        }

        #endregion

        #region 확률 정보 조회

        /// <summary>
        /// 스타포스 강화 결과를 조회합니다.
        /// <para>스타포스 확률 정보는 최대 5분 후 확인 가능합니다.</para>
        /// <para>2023년 12월 27일 데이터부터 조회할 수 있습니다.</para>
        /// </summary>
        /// <param name="count">한번에 가져오려는 결과의 개수(최소 10, 최대 1000)</param>
        public Task<StarforceHistoryResponseDTO> GetStarforceHistory(int count)
        {
            return GetStarforceHistory(count, GetProperDefaultDateTimeOffset(new LatestApiUpdateTimeOption
            {
                Hour = 0,
                Minute = 0,
                DateOffset = 0
            }));
        }

        /// <summary>
        /// 지목한 날짜의 스타포스 강화 결과를 조회합니다.
        /// <para>스타포스 확률 정보는 최대 5분 후 확인 가능합니다.</para>
        /// <para>2023년 12월 27일 데이터부터 조회할 수 있습니다.</para>
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
        /// <para>스타포스 확률 정보는 최대 5분 후 확인 가능합니다.</para>
        /// <para>2023년 12월 27일 데이터부터 조회할 수 있습니다.</para>
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
        /// <para>큐브 확률 정보는 최대 30분 후 확인 가능합니다.</para>
        /// <para>큐브 사용 결과는 최근 2년 데이터만 조회 가능합니다.</para>
        /// </summary>
        /// <param name="count">한번에 가져오려는 결과의 개수(최소 10, 최대 1000)</param>
        public Task<CubeHistoryResponseDTO> GetCubeHistory(int count)
        {
            return GetCubeHistory(count, GetProperDefaultDateTimeOffset(new LatestApiUpdateTimeOption
            {
                Hour = 0,
                Minute = 0,
                DateOffset = 0
            }));
        }

        /// <summary>
        /// 지목한 날짜의 큐브 사용 결과를 조회합니다.
        /// <para>큐브 확률 정보는 최대 30분 후 확인 가능합니다.</para>
        /// <para>큐브 사용 결과는 최근 2년 데이터만 조회 가능합니다.</para>
        /// </summary>
        /// <param name="count">한번에 가져오려는 결과의 개수(최소 10, 최대 1000)</param>
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
        /// <para>큐브 확률 정보는 최대 30분 후 확인 가능합니다.</para>
        /// <para>큐브 사용 결과는 최근 2년 데이터만 조회 가능합니다.</para>
        /// </summary>
        /// <param name="count">한번에 가져오려는 결과의 개수(최소 10, 최대 1000)</param>
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
        /// <para>잠재능력 재설정 정보는 최대 30분 후 확인 가능합니다.</para>
        /// <para>잠재능력 재설정 이용 결과는 2024년 01월 25일 데이터부터 조회 가능하며, 최대 2년동안의 데이터만 제공됩니다.</para>
        /// </summary>
        /// <param name="count">한번에 가져오려는 결과의 개수(최소 10, 최대 1000)</param>
        public Task<PotentialHistoryResponseDTO> GetPotentialHistory(int count)
        {
            return GetPotentialHistory(count, GetProperDefaultDateTimeOffset(new LatestApiUpdateTimeOption
            {
                Hour = 0,
                Minute = 0,
                DateOffset = 0
            }));
        }

        /// <summary>
        /// 지목한 날짜의 잠재능력 재설정 이용 결과를 조회합니다.
        /// <para>잠재능력 재설정 정보는 최대 30분 후 확인 가능합니다.</para>
        /// <para>잠재능력 재설정 이용 결과는 2024년 01월 25일 데이터부터 조회 가능하며, 최대 2년동안의 데이터만 제공됩니다.</para>
        /// </summary>
        /// <param name="count">한번에 가져오려는 결과의 개수(최소 10, 최대 1000)</param>
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
        /// <para>잠재능력 재설정 정보는 최대 30분 후 확인 가능합니다.</para>
        /// <para>잠재능력 재설정 이용 결과는 2024년 01월 25일 데이터부터 조회 가능하며, 최대 2년동안의 데이터만 제공됩니다.</para>
        /// </summary>
        /// <param name="count">한번에 가져오려는 결과의 개수(최소 10, 최대 1000)</param>
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

        #region 랭킹 정보 조회

        /// <summary>
        /// 종합 랭킹 정보를 조회합니다.
        /// <para>- 2023년 12월 22일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="worldName">월드 명 <a href="https://openapi.nexon.com/ko/game/maplestory/?id=18">Available values</a></param>
        /// <param name="worldType">월드 타입 (0:일반, 1:에오스,헬리오스) (기본 값은 0이며, worldName 입력 시 미 반영)</param>
        /// <param name="characterClass">직업 및 전직 <a href="https://openapi.nexon.com/ko/game/maplestory/?id=18">Available values</a></param>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="page">페이지 번호</param>
        public Task<OverallRankingResponseDTO> GetOverallRanking(string? worldName, int? worldType, string? characterClass, string? ocid, int? page)
        {
            return GetOverallRanking(worldName, worldType, characterClass, ocid, page, GetProperDefaultDateTimeOffset(new LatestApiUpdateTimeOption
            {
                Hour = 8,
                Minute = 30,
                DateOffset = 0
            }));
        }

        /// <summary>
        /// 종합 랭킹 정보를 조회합니다.
        /// <para>- 2023년 12월 22일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="worldName">월드 명 <a href="https://openapi.nexon.com/ko/game/maplestory/?id=18">Available values</a></param>
        /// <param name="worldType">월드 타입 (0:일반, 1:에오스,헬리오스) (기본 값은 0이며, worldName 입력 시 미 반영)</param>
        /// <param name="characterClass">직업 및 전직 <a href="https://openapi.nexon.com/ko/game/maplestory/?id=18">Available values</a></param>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="page">페이지 번호</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<OverallRankingResponseDTO> GetOverallRanking(string? worldName, int? worldType, string? characterClass, string? ocid, int? page, DateTimeOffset dateTimeOffset)
        {
            var path = $"{subUrl}/v1/ranking/overall";
            var query = new Dictionary<string, string?>()
            {
                { "date", ToDateString(dateTimeOffset, MinDate(2023, 12, 22)) },
                { "world_name", worldName },
                { "world_type", worldType?.ToString() },
                { "class", characterClass },
                { "ocid", ocid },
                { "page", page?.ToString() }
            };

            return await Get<OverallRankingResponseDTO>(path, query);
        }

        /// <summary>
        /// 유니온 랭킹 정보를 조회합니다.
        /// <para>- 2023년 12월 22일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="worldName">월드 명 <a href="https://openapi.nexon.com/ko/game/maplestory/?id=18">Available values</a></param>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="page">페이지 번호</param>
        public Task<UnionRankingResponseDTO> GetUnionRanking(string? worldName, string? ocid, int? page)
        {
            return GetUnionRanking(worldName, ocid, page, GetProperDefaultDateTimeOffset(new LatestApiUpdateTimeOption
            {
                Hour = 8,
                Minute = 30,
                DateOffset = 0
            }));
        }

        /// <summary>
        /// 유니온 랭킹 정보를 조회합니다.
        /// <para>- 2023년 12월 22일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="worldName">월드 명 <a href="https://openapi.nexon.com/ko/game/maplestory/?id=18">Available values</a></param>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="page">페이지 번호</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<UnionRankingResponseDTO> GetUnionRanking(string? worldName, string? ocid, int? page, DateTimeOffset dateTimeOffset)
        {
            var path = $"{subUrl}/v1/ranking/union";
            var query = new Dictionary<string, string?>()
            {
                { "date", ToDateString(dateTimeOffset, MinDate(2023, 12, 22)) },
                { "world_name", worldName },
                { "ocid", ocid },
                { "page", page?.ToString() }
            };

            return await Get<UnionRankingResponseDTO>(path, query);
        }

        /// <summary>
        /// 길드 랭킹 정보를 조회합니다.
        /// <para>- 2023년 12월 22일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="worldName">월드 명 <a href="https://openapi.nexon.com/ko/game/maplestory/?id=18">Available values</a></param>
        /// <param name="rankingType">랭킹 타입 (0:주간 명성치, 1:플래그 레이스, 2:지하 수로)</param>
        /// <param name="guildName">길드 명</param>
        /// <param name="page">페이지 번호</param>
        public Task<GuildRankingResponseDTO> GetGuildRanking(string? worldName, int rankingType, string? guildName, int? page)
        {
            return GetGuildRanking(worldName, rankingType, guildName, page, GetProperDefaultDateTimeOffset(new LatestApiUpdateTimeOption
            {
                Hour = 8,
                Minute = 30,
                DateOffset = 0
            }));
        }

        /// <summary>
        /// 길드 랭킹 정보를 조회합니다.
        /// <para>- 2023년 12월 22일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="worldName">월드 명 <a href="https://openapi.nexon.com/ko/game/maplestory/?id=18">Available values</a></param>
        /// <param name="rankingType">랭킹 타입 (0:주간 명성치, 1:플래그 레이스, 2:지하 수로)</param>
        /// <param name="guildName">길드 명</param>
        /// <param name="page">페이지 번호</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<GuildRankingResponseDTO> GetGuildRanking(string? worldName, int rankingType, string? guildName, int? page, DateTimeOffset dateTimeOffset)
        {
            var path = $"{subUrl}/v1/ranking/guild";
            var query = new Dictionary<string, string?>()
            {
                { "date", ToDateString(dateTimeOffset, MinDate(2023, 12, 22)) },
                { "ranking_type", rankingType.ToString() },
                { "world_name", worldName },
                { "guild_name", guildName },
                { "page", page?.ToString() }
            };

            return await Get<GuildRankingResponseDTO>(path, query);
        }

        /// <summary>
        /// 무릉도장 랭킹 정보를 조회합니다.
        /// <para>- 2023년 12월 22일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="worldName">월드 명 <a href="https://openapi.nexon.com/ko/game/maplestory/?id=18">Available values</a></param>
        /// <param name="difficulty">구간 (0:일반, 1:통달)</param>
        /// <param name="characterClass">직업 및 전직 <a href="https://openapi.nexon.com/ko/game/maplestory/?id=18">Available values</a></param>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="page">페이지 번호</param>
        public Task<DojangRankingResponseDTO> GetDojangRanking(string? worldName, int difficulty, string? characterClass, string ocid, int? page)
        {
            return GetDojangRanking(worldName, difficulty, characterClass, ocid, page, GetProperDefaultDateTimeOffset(new LatestApiUpdateTimeOption
            {
                Hour = 8,
                Minute = 30,
                DateOffset = 0
            }));
        }

        /// <summary>
        /// 무릉도장 랭킹 정보를 조회합니다.
        /// <para>- 2023년 12월 22일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="worldName">월드 명 <a href="https://openapi.nexon.com/ko/game/maplestory/?id=18">Available values</a></param>
        /// <param name="difficulty">구간 (0:일반, 1:통달)</param>
        /// <param name="characterClass">직업 및 전직 <a href="https://openapi.nexon.com/ko/game/maplestory/?id=18">Available values</a></param>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="page">페이지 번호</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<DojangRankingResponseDTO> GetDojangRanking(string? worldName, int difficulty, string? characterClass, string? ocid, int? page, DateTimeOffset dateTimeOffset)
        {
            var path = $"{subUrl}/v1/ranking/dojang";
            var query = new Dictionary<string, string?>()
            {
                { "date", ToDateString(dateTimeOffset, MinDate(2023, 12, 22)) },
                { "difficulty", difficulty.ToString() },
                { "world_name", worldName },
                { "class", characterClass },
                { "ocid", ocid },
                { "page", page?.ToString() }
            };

            return await Get<DojangRankingResponseDTO>(path, query);
        }

        /// <summary>
        /// 더 시드 랭킹 정보를 조회합니다.
        /// <para>- 2023년 12월 22일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="worldName">월드 명 <a href="https://openapi.nexon.com/ko/game/maplestory/?id=18">Available values</a></param>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="page">페이지 번호</param>
        public Task<TheSeedRankingResponseDTO> GetTheSeedRanking(string? worldName, string? ocid, int? page)
        {
            return GetTheSeedRanking(worldName, ocid, page, GetProperDefaultDateTimeOffset(new LatestApiUpdateTimeOption
            {
                Hour = 8,
                Minute = 30,
                DateOffset = 0
            }));
        }

        /// <summary>
        /// 더 시드 랭킹 정보를 조회합니다.
        /// <para>- 2023년 12월 22일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="worldName">월드 명
        /// <para>스카니아</para> <a href="https://openapi.nexon.com/ko/game/maplestory/?id=18">Available values</a></param>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="page">페이지 번호</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<TheSeedRankingResponseDTO> GetTheSeedRanking(string? worldName, string? ocid, int? page, DateTimeOffset dateTimeOffset)
        {
            var path = $"{subUrl}/v1/ranking/theseed";
            var query = new Dictionary<string, string?>()
            {
                { "date", ToDateString(dateTimeOffset, MinDate(2023, 12, 22)) },
                { "world_name", worldName },
                { "ocid", ocid },
                { "page", page?.ToString() }

            };

            return await Get<TheSeedRankingResponseDTO>(path, query);
        }

        /// <summary>
        /// 업적 랭킹 정보를 조회합니다.
        /// <para>- 2023년 12월 22일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="page">페이지 번호</param>
        public Task<AchievementRankingResponseDTO> GetAchievementRanking(string? ocid, int? page)
        {
            return GetAchievementRanking(ocid, page, GetProperDefaultDateTimeOffset(new LatestApiUpdateTimeOption
            {
                Hour = 8,
                Minute = 30,
                DateOffset = 0
            }));
        }

        /// <summary>
        /// 업적 랭킹 정보를 조회합니다.
        /// <para>- 2023년 12월 22일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="page">페이지 번호</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<AchievementRankingResponseDTO> GetAchievementRanking(string? ocid, int? page, DateTimeOffset dateTimeOffset)
        {
            var path = $"{subUrl}/v1/ranking/achievement";
            var query = new Dictionary<string, string?>()
            {
                { "date", ToDateString(dateTimeOffset, MinDate(2023, 12, 22)) },
                { "ocid", ocid },
                { "page", page?.ToString() }
            };

            return await Get<AchievementRankingResponseDTO>(path, query);
        }

        #endregion

        #region 공지 정보 조회

        /// <summary>
        /// 메이플스토리 공지사항에 최근 등록된 게시글 20개를 조회합니다.
        /// <para>- 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.</para>
        /// <para>- 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.</para>
        /// </summary>
        public async Task<NoticeListDTO> GetNoticeList()
        {
            var path = $"{subUrl}/v1/notice";

            return await Get<NoticeListDTO>(path);
        }

        /// <summary>
        /// 메이플스토리 공지사항 게시글 세부 사항을 조회합니다.
        /// <para>- 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.</para>
        /// <para>- 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.</para>
        /// </summary>
        /// <param name="noticeId">공지 식별자</param>
        public async Task<NoticeDetailDTO> GetNoticeDetail(int noticeId)
        {
            var path = $"{subUrl}/v1/notice/detail";
            var query = new Dictionary<string, string?>()
            {
                { "notice_id", noticeId.ToString() },
            };

            return await Get<NoticeDetailDTO>(path, query);
        }

        /// <summary>
        /// 메이플스토리 업데이트에 최근 등록된 게시글 20개를 조회합니다.
        /// <para>- 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.</para>
        /// <para>- 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.</para>
        /// </summary>
        public async Task<UpdateNoticeListDTO> GetUpdateNoticeList()
        {
            var path = $"{subUrl}/v1/notice-update";

            return await Get<UpdateNoticeListDTO>(path);
        }

        /// <summary>
        /// 메이플스토리 업데이트 게시글 세부 사항을 조회합니다.
        /// <para>- 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.</para>
        /// <para>- 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.</para>
        /// </summary>
        /// <param name="noticeId">공지 식별자</param>
        public async Task<UpdateNoticeDetailDTO> GetUpdateNoticeDetail(int noticeId)
        {
            var path = $"{subUrl}/v1/notice-update/detail";
            var query = new Dictionary<string, string?>()
            {
                { "notice_id", noticeId.ToString() },
            };

            return await Get<UpdateNoticeDetailDTO>(path, query);
        }

        /// <summary>
        /// 메이플스토리 진행 중 이벤트에 최근 등록된 게시글 20개를 조회합니다.
        /// <para>- 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.</para>
        /// <para>- 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.</para>
        /// </summary>
        public async Task<EventNoticeListDTO> GetEventNoticeList()
        {
            var path = $"{subUrl}/v1/notice-event";

            return await Get<EventNoticeListDTO>(path);
        }

        /// <summary>
        /// 메이플스토리 진행 중 이벤트 게시글 세부 사항을 조회합니다.
        /// <para>- 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.</para>
        /// <para>- 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.</para>
        /// </summary>
        /// <param name="noticeId">공지 식별자</param>
        public async Task<EventNoticeDetailDTO> GetEventNoticeDetail(int noticeId)
        {
            var path = $"{subUrl}/v1/notice-event/detail";
            var query = new Dictionary<string, string?>()
            {
                { "notice_id", noticeId.ToString() },
            };

            return await Get<EventNoticeDetailDTO>(path, query);
        }

        /// <summary>
        /// 메이플스토리 캐시샵 공지에 최근 등록된 게시글 20개를 조회합니다.
        /// <para>- 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.</para>
        /// <para>- 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.</para>
        /// </summary>
        public async Task<CashshopNoticeListDTO> GetCashshopNoticeList()
        {
            var path = $"{subUrl}/v1/notice-cashshop";

            return await Get<CashshopNoticeListDTO>(path);
        }

        /// <summary>
        /// 메이플스토리 캐시샵 공지 게시글 세부 사항을 조회합니다.
        /// <para>- 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.</para>
        /// <para>- 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.</para>
        /// </summary>
        /// <param name="noticeId">공지 식별자</param>
        public async Task<CashshopNoticeDetailDTO> GetCashshopNoticeDetail(int noticeId)
        {
            var path = $"{subUrl}/v1/notice-cashshop/detail";
            var query = new Dictionary<string, string?>()
            {
                { "notice_id", noticeId.ToString() },
            };

            return await Get<CashshopNoticeDetailDTO>(path, query);
        }

        #endregion

        /// <summary>
        /// 서버 점검 정보를 조회합니다.
        /// </summary>
        public async Task<InspectionInfoDTO> GetInspectionInfo()
        {
            var client = new RestClient(options: new RestClientOptions("https://api.maplestory.nexon.com/"));
            var path = "soap/maplestory.asmx";
            var soapEnvelop =
                "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "  <soap:Body>\n" +
                "    <GetInspectionInfo xmlns=\"https://api.maplestory.nexon.com/soap/\" />\n" +
                "  </soap:Body>\n" +
                "</soap:Envelope>";

            var request = new RestRequest(path);

            request.Timeout = TimeSpan.FromMilliseconds(this.timeOut);
            request.AddHeader("SOAPAction", "https://api.maplestory.nexon.com/soap/GetInspectionInfo");
            request.AddHeader("content-type", "text/xml; charset=utf-8");
            request.AddStringBody(soapEnvelop, ContentType.Xml);

            var response = await client.PostAsync(request);

            if (response.IsSuccessStatusCode)
            {
                return new InspectionInfoDTO(response.Content!);
            }
            else
            {
                throw new MapleStoryAPIException(MapleStoryAPIErrorCode.OPENAPI00003, "Bad Request");
            }
        }
    }

    public abstract class MapleStoryAPIInherit : Base.MapleStoryAPI<
        CharacterDTO,
        CharacterBasicDTO,
        CharacterImageDTO,
        CharacterPopularityDTO,
        CharacterStatDTO,
        CharacterHyperStatDTO,
        CharacterPropensityDTO,
        CharacterAbilityDTO,
        CharacterItemEquipmentDTO,
        CharacterCashItemEquipmentDTO,
        CharacterSymbolEquipmentDTO,
        CharacterSetEffectDTO,
        CharacterBeautyEquipmentDTO,
        CharacterAndroidEquipmentDTO,
        CharacterPetEquipmentDTO,
        CharacterSkillDTO,
        CharacterLinkSkillDTO,
        CharacterVMatrixDTO,
        CharacterHexaMatrixDTO,
        CharacterHexaMatrixStatDTO,
        CharacterDojangDTO,
        UnionDTO,
        UnionRaiderDTO,
        UnionArtifactDTO,
        GuildDTO,
        GuildBasicDTO>
    {
        public MapleStoryAPIInherit(string apiKey, string subUrl, int timezoneOffset) : base(apiKey, subUrl, timezoneOffset)
        {

        }
    }
}
