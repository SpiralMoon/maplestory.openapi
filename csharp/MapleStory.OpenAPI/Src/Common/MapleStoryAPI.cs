using MapleStory.OpenAPI.Common.Param;
using Newtonsoft.Json;
using RestSharp;

namespace MapleStory.OpenAPI.Common
{
    /// <summary>
    /// MapleStory OpenAPI client.
    /// </summary>
    public abstract class MapleStoryAPI<
        TCharacter,
        TCharacterBasic,
        TCharacterImage,
        TCharacterPopularity,
        TCharacterStat,
        TCharacterHyperStat,
        TCharacterPropensity,
        TCharacterAbility,
        TCharacterItemEquipment,
        TCharacterCashItemEquipment,
        TCharacterSymbolEquipment,
        TCharacterSetEffect,
        TCharacterBeautyEquipment,
        TCharacterAndroidEquipment,
        TCharacterPetEquipment,
        TCharacterSkill,
        TCharacterLinkSkill,
        TCharacterVMatrix,
        TCharacterHexaMatrix,
        TCharacterHexaMatrixStat,
        TCharacterDojang,
        TUnion,
        TUnionRaider,
        TUnionArtifact,
        TGuild,
        TGuildBasic,
        PCharacterImageOption>
    {
        private readonly string apiKey;

        private readonly RestClient client;

        protected static readonly string BASE_URL = "https://open.api.nexon.com/";

        // in milliseconds
        protected int timeOut { get; set; }

        protected string subUrl;

        protected int timezoneOffset;

        public MapleStoryAPI (string apiKey, string subUrl, int timezoneOffset)
        {
            this.apiKey = apiKey;
            this.timeOut = 5000;
            this.client = new RestClient(options: new RestClientOptions(BASE_URL));
            this.subUrl = subUrl;
            this.timezoneOffset = timezoneOffset;
        }

        #region Character Information Retrieval

        public abstract Task<TCharacter> GetCharacter(string characterName);
        public abstract Task<TCharacterBasic> GetCharacterBasic(string ocid);
        public abstract Task<TCharacterBasic> GetCharacterBasic(string ocid, DateTimeOffset? dateTimeOffset);
        public abstract Task<TCharacterImage> GetCharacterImage(string ocid);
        public abstract Task<TCharacterImage> GetCharacterImage(string ocid, PCharacterImageOption imageOption);
        public abstract Task<TCharacterImage> GetCharacterImage(string ocid, PCharacterImageOption imageOption, DateTimeOffset? dateTimeOffset);
        protected async Task<string> urlImageToBase64(string path, Dictionary<string, string?>? query)
        {
            var response = await Get(path, query);

            var base64 = Convert.ToBase64String(response.RawBytes);
            var mimeType = response.ContentType;

            return $"data:{mimeType};base64,{base64}";
        }

        public abstract Task<TCharacterPopularity> GetCharacterPopularity(string ocid);
        public abstract Task<TCharacterPopularity> GetCharacterPopularity(string ocid, DateTimeOffset? dateTimeOffset);
        public abstract Task<TCharacterStat> GetCharacterStat(string ocid);
        public abstract Task<TCharacterStat> GetCharacterStat(string ocid, DateTimeOffset? dateTimeOffset);
        public abstract Task<TCharacterHyperStat> GetCharacterHyperStat(string ocid);
        public abstract Task<TCharacterHyperStat> GetCharacterHyperStat(string ocid, DateTimeOffset? dateTimeOffset);
        public abstract Task<TCharacterPropensity> GetCharacterPropensity(string ocid);
        public abstract Task<TCharacterPropensity> GetCharacterPropensity(string ocid, DateTimeOffset? dateTimeOffset);
        public abstract Task<TCharacterAbility> GetCharacterAbility(string ocid);
        public abstract Task<TCharacterAbility> GetCharacterAbility(string ocid, DateTimeOffset? dateTimeOffset);
        public abstract Task<TCharacterItemEquipment> GetCharacterItemEquipment(string ocid);
        public abstract Task<TCharacterItemEquipment> GetCharacterItemEquipment(string ocid, DateTimeOffset? dateTimeOffset);
        public abstract Task<TCharacterCashItemEquipment> GetCharacterCashItemEquipment(string ocid);
        public abstract Task<TCharacterCashItemEquipment> GetCharacterCashItemEquipment(string ocid, DateTimeOffset? dateTimeOffset);
        public abstract Task<TCharacterSymbolEquipment> GetCharacterSymbolEquipment(string ocid);
        public abstract Task<TCharacterSymbolEquipment> GetCharacterSymbolEquipment(string ocid, DateTimeOffset? dateTimeOffset);
        public abstract Task<TCharacterSetEffect> GetCharacterSetEffect(string ocid);
        public abstract Task<TCharacterSetEffect> GetCharacterSetEffect(string ocid, DateTimeOffset? dateTimeOffset);
        public abstract Task<TCharacterBeautyEquipment> GetCharacterBeautyEquipment(string ocid);
        public abstract Task<TCharacterBeautyEquipment> GetCharacterBeautyEquipment(string ocid, DateTimeOffset? dateTimeOffset);
        public abstract Task<TCharacterAndroidEquipment> GetCharacterAndroidEquipment(string ocid);
        public abstract Task<TCharacterAndroidEquipment> GetCharacterAndroidEquipment(string ocid, DateTimeOffset? dateTimeOffset);
        public abstract Task<TCharacterPetEquipment> GetCharacterPetEquipment(string ocid);
        public abstract Task<TCharacterPetEquipment> GetCharacterPetEquipment(string ocid, DateTimeOffset? dateTimeOffset);
        public abstract Task<TCharacterSkill> GetCharacterSkill(string ocid, string characterSkillGrade);
        public abstract Task<TCharacterSkill> GetCharacterSkill(string ocid, string characterSkillGrade, DateTimeOffset? dateTimeOffset);
        public abstract Task<TCharacterLinkSkill> GetCharacterLinkSkill(string ocid);
        public abstract Task<TCharacterLinkSkill> GetCharacterLinkSkill(string ocid, DateTimeOffset? dateTimeOffset);
        public abstract Task<TCharacterVMatrix> GetCharacterVMatrix(string ocid);
        public abstract Task<TCharacterVMatrix> GetCharacterVMatrix(string ocid, DateTimeOffset? dateTimeOffset);
        public abstract Task<TCharacterHexaMatrix> GetCharacterHexaMatrix(string ocid);
        public abstract Task<TCharacterHexaMatrix> GetCharacterHexaMatrix(string ocid, DateTimeOffset? dateTimeOffset);
        public abstract Task<TCharacterHexaMatrixStat> GetCharacterHexaMatrixStat(string ocid);
        public abstract Task<TCharacterHexaMatrixStat> GetCharacterHexaMatrixStat(string ocid, DateTimeOffset? dateTimeOffset);
        public abstract Task<TCharacterDojang> GetCharacterDojang(string ocid);
        public abstract Task<TCharacterDojang> GetCharacterDojang(string ocid, DateTimeOffset? dateTimeOffset);

        #endregion

        #region Union Information Retrieval

        public abstract Task<TUnion> GetUnion(string ocid);
        public abstract Task<TUnion> GetUnion(string ocid, DateTimeOffset? dateTimeOffset);
        public abstract Task<TUnionRaider> GetUnionRaider(string ocid);
        public abstract Task<TUnionRaider> GetUnionRaider(string ocid, DateTimeOffset? dateTimeOffset);
        public abstract Task<TUnionArtifact> GetUnionArtifact(string ocid);
        public abstract Task<TUnionArtifact> GetUnionArtifact(string ocid, DateTimeOffset? dateTimeOffset);

        #endregion

        #region Guild Information Retrieval

        public abstract Task<TGuild> GetGuild(string guildName, string wolrdName);
        public abstract Task<TGuildBasic> GetGuildBasic(string oGuildId);
        public abstract Task<TGuildBasic> GetGuildBasic(string oGuildId, DateTimeOffset? dateTimeOffset);

        #endregion

        private void SetClient(HttpClient client)
        {
            client.Timeout = TimeSpan.FromMilliseconds(this.timeOut);
            client.DefaultRequestHeaders.Add("x-nxopen-api-key", this.apiKey);
        }

        protected async Task<ResponseBody> Get<ResponseBody>(string path, Dictionary<string, string?>? query = null)
        {
            var request = new RestRequest(path);

            request.Timeout = TimeSpan.FromMilliseconds(this.timeOut);
            request.AddHeader("x-nxopen-api-key", this.apiKey);

            if (query != null)
            {
                foreach (var element in query)
                {
                    if (element.Value != null)
                    {
                        request.AddQueryParameter(element.Key, element.Value);
                    }
                }
            }

            var response = await this.client.ExecuteGetAsync(request);

            if (response.IsSuccessStatusCode)
            {
                return JsonConvert.DeserializeObject<ResponseBody>(response.Content!);
            }
            else
            {
                throw ParseError(response.Content!);
            }
        }

        protected async Task<RestResponse> Get(string path, Dictionary<string, string?>? query = null)
        {
            var request = new RestRequest(path);

            request.Timeout = TimeSpan.FromMilliseconds(this.timeOut);
            request.AddHeader("x-nxopen-api-key", this.apiKey);

            if (query != null)
            {
                foreach (var element in query)
                {
                    if (element.Value != null)
                    {
                        request.AddQueryParameter(element.Key, element.Value);
                    }
                }
            }

            var response = await this.client.ExecuteGetAsync(request);

            if (response.IsSuccessStatusCode)
            {
                return response;
            }
            else
            {
                throw ParseError(response.Content!);
            }
        }


        protected DateTimeOffset MinDate(int year, int month, int day)
        {
            return new DateTimeOffset(year, month, day, 0, 0, 0, TimeSpan.FromMinutes(this.timezoneOffset));
        }

        /// <summary>
        /// API 서버의 데이터 갱신 시간에 따라 데이터를 조회 가능한 최신 날짜를 반환합니다.
        /// </summary>
        /// <param name="option"></param>
        protected DateTimeOffset GetProperDefaultDateTimeOffset(LatestApiUpdateTimeOption option)
        {
            var utcNow = DateTimeOffset.UtcNow;
            var nowInTimezone = utcNow.ToOffset(TimeSpan.FromMinutes(this.timezoneOffset));

            var hour = option.Hour;
            var minute = option.Minute;
            var dateOffset = option.DateOffset;

            DateTimeOffset adjustedDateTimeOffset;

            if (nowInTimezone > nowInTimezone.Date.AddHours(hour).AddMinutes(minute))
            {
                adjustedDateTimeOffset = nowInTimezone;
            }
            else
            {
                adjustedDateTimeOffset = nowInTimezone.AddDays(-1);
            }

            return adjustedDateTimeOffset.AddDays(-dateOffset ?? 0);
        }

        /// <summary>
        /// 날짜 정보를 API 서버에서 요구하는 포맷으로 변환합니다.
        /// </summary>
        /// <param name="date">조회 하려는 날짜</param>
        /// <param name="minDate">API 호출 가능한 최소 날짜</param>
        protected static string ToDateString(DateTimeOffset date, DateTimeOffset minDate)
        {
            var minYear = minDate.Year;
            var minMonth = minDate.Month;
            var minDay = minDate.Day;

            var year = date.Year;
            var month = date.Month;
            var day = date.Day;

            if (year < minYear || (year == minYear && month < minMonth) || (year == minYear && month == minMonth && day < minDay))
            {
                throw new ArgumentException($"You can only retrieve data after {minYear}-{minMonth:D2}-{minDay:D2}.");
            }

            var yyyyMMdd = new DateTime(year, month, day).ToString("yyyy-MM-dd");

            return yyyyMMdd;
        }

        /// <summary>
        /// 날짜 정보를 API 서버에서 요구하는 포맷으로 변환합니다.
        /// </summary>
        /// <param name="date">조회 하려는 날짜</param>
        protected static string ToDateString(DateTimeOffset date)
        {
            var year = date.Year;
            var month = date.Month;
            var day = date.Day;
            var yyyyMMdd = new DateTime(year, month, day).ToString("yyyy-MM-dd");

            return yyyyMMdd;
        }

        private static MapleStoryAPIException ParseError(string body)
        {
            var error = JsonConvert.DeserializeObject<MapleStoryAPIErrorBody>(body);

            return new MapleStoryAPIException(error);
        }
    }
}
