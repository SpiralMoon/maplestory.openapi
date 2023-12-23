using MapleStory.OpenAPI.Dto;
using Newtonsoft.Json;
using System.Web;
using System.Text;

namespace MapleStory.OpenAPI
{
    /// <summary>
    /// MapleStory OpenAPI client.
    /// <para>This is an implementation of <a href="https://openapi.nexon.com/game/maplestory">MapleStory API</a></para>
    /// </summary>
    public class MapleStoryAPI
    {
        private readonly string apiKey;

        private static readonly string BASE_URL = "https://open.api.nexon.com/";

        // in milliseconds
        private long timeOut { get; set; }

        private DateTimeOffset now
        {
            get
            {
                var utcNow = DateTimeOffset.UtcNow;
                var kstNow = utcNow.ToOffset(TimeSpan.FromHours(9));

                return kstNow;
            }
        }

        public MapleStoryAPI (string apiKey)
        {
            this.apiKey = apiKey;
            this.timeOut = 5000;
        }

        #region 캐릭터 정보 조회

        /// <summary>
        /// 캐릭터 식별자(ocid)를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="characterName">캐릭터 명</param>
        public async Task<CharacterDTO> GetCharacter(string characterName)
        {
            using (var client = new HttpClient())
            {
                var path = "maplestory/v1/id";
                var uriBuilder = new UriBuilder($"{BASE_URL}{path}");

                var query = HttpUtility.ParseQueryString(uriBuilder.Query);
                query["character_name"] = characterName;

                uriBuilder.Query = query.ToString();

                this.SetClient(client);

                var response = await client.GetAsync(uriBuilder.Uri);
                var body = await response.Content.ReadAsStringAsync();

                if (response.IsSuccessStatusCode)
                {
                    var result = JsonConvert.DeserializeObject<CharacterDTO>(body);

                    return result;
                }
                else
                {
                    throw ParseError(body);
                }
            }
        }

        /// <summary>
        /// 기본 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="characterName">캐릭터 식별자</param>
        public Task<CharacterBasicDTO> GetCharacterBasic(string ocid)
        {
            return GetCharacterBasic(ocid, now);
        }

        /// <summary>
        /// 기본 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="characterName">캐릭터 식별자</param>
        /// <param name="characterName">조회 기준일 (KST)</param>
        public async Task<CharacterBasicDTO> GetCharacterBasic(string ocid, DateTimeOffset dateTimeOffset)
        {
            using (var client = new HttpClient())
            {
                var path = "maplestory/v1/id";
                var uriBuilder = new UriBuilder($"{BASE_URL}{path}");

                var date = ToDateString(MinDate(2023, 12, 21), dateTimeOffset);

                var query = HttpUtility.ParseQueryString(uriBuilder.Query);
                query["ocid"] = ocid;
                query["date"] = date;

                uriBuilder.Query = query.ToString();

                this.SetClient(client);

                var response = await client.GetAsync(uriBuilder.Uri);
                var body = await response.Content.ReadAsStringAsync();

                if (response.IsSuccessStatusCode)
                {
                    var result = JsonConvert.DeserializeObject<CharacterBasicDTO>(body);

                    return result;
                }
                else
                {
                    throw ParseError(body);
                }
            }
        }

        /// <summary>
        /// 인기도 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<CharacterPopularityDTO> GetCharacterPopularity(string ocid)
        {
            return GetCharacterPopularity(ocid, now);
        }

        /// <summary>
        /// 인기도 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<CharacterPopularityDTO> GetCharacterPopularity(string ocid, DateTimeOffset dateTimeOffset)
        {
            using (var client = new HttpClient())
            {
                var path = "maplestory/v1/character/popularity";
                var uriBuilder = new UriBuilder($"{BASE_URL}{path}");

                var date = ToDateString(MinDate(2023, 12, 21), dateTimeOffset);

                var query = HttpUtility.ParseQueryString(uriBuilder.Query);
                query["ocid"] = ocid;
                query["date"] = date;

                uriBuilder.Query = query.ToString();

                SetClient(client);

                var response = await client.GetAsync(uriBuilder.Uri);
                var body = await response.Content.ReadAsStringAsync();

                if (response.IsSuccessStatusCode)
                {
                    var result = JsonConvert.DeserializeObject<CharacterPopularityDTO>(body);

                    return result;
                }
                else
                {
                    throw ParseError(body);
                }
            }
        }

        /// <summary>
        /// 종합 능력치 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        public Task<CharacterStatDTO> GetCharacterStat(string ocid)
        {
            return GetCharacterStat(ocid, now);
        }

        /// <summary>
        /// 종합 능력치 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<CharacterStatDTO> GetCharacterStat(string ocid, DateTimeOffset dateTimeOffset)
        {
            using (var client = new HttpClient())
            {
                var path = "maplestory/v1/character/stat";
                var uriBuilder = new UriBuilder($"{BASE_URL}{path}");

                var date = ToDateString(MinDate(2023, 12, 21), dateTimeOffset);

                var query = HttpUtility.ParseQueryString(uriBuilder.Query);
                query["ocid"] = ocid;
                query["date"] = date;

                uriBuilder.Query = query.ToString();

                SetClient(client);

                var response = await client.GetAsync(uriBuilder.Uri);
                var body = await response.Content.ReadAsStringAsync();

                if (response.IsSuccessStatusCode)
                {
                    var result = JsonConvert.DeserializeObject<CharacterStatDTO>(body);

                    return result;
                }
                else
                {
                    throw ParseError(body);
                }
            }
        }

        /// <summary>
        /// 하이퍼스탯 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<CharacterHyperStatDTO> GetCharacterHyperStat(string ocid)
        {
            return GetCharacterHyperStat(ocid, now);
        }

        /// <summary>
        /// 하이퍼스탯 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<CharacterHyperStatDTO> GetCharacterHyperStat(string ocid, DateTimeOffset dateTimeOffset)
        {
            using (var client = new HttpClient())
            {
                var path = "maplestory/v1/character/hyper-stat";
                var uriBuilder = new UriBuilder($"{BASE_URL}{path}");

                var date = ToDateString(MinDate(2023, 12, 21), dateTimeOffset);

                var query = HttpUtility.ParseQueryString(uriBuilder.Query);
                query["ocid"] = ocid;
                query["date"] = date;

                uriBuilder.Query = query.ToString();

                SetClient(client);

                var response = await client.GetAsync(uriBuilder.Uri);
                var body = await response.Content.ReadAsStringAsync();

                if (response.IsSuccessStatusCode)
                {
                    var result = JsonConvert.DeserializeObject<CharacterHyperStatDTO>(body);

                    return result;
                }
                else
                {
                    throw ParseError(body);
                }
            }
        }

        /// <summary>
        /// 성향 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<CharacterPropensityDTO> GetCharacterPropensity(string ocid)
        {
            return GetCharacterPropensity(ocid, now);
        }

        /// <summary>
        /// 성향 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<CharacterPropensityDTO> GetCharacterPropensity(string ocid, DateTimeOffset dateTimeOffset)
        {
            using (var client = new HttpClient())
            {
                var path = "maplestory/v1/character/propensity";
                var uriBuilder = new UriBuilder($"{BASE_URL}{path}");

                var date = ToDateString(MinDate(2023, 12, 21), dateTimeOffset);

                var query = HttpUtility.ParseQueryString(uriBuilder.Query);
                query["ocid"] = ocid;
                query["date"] = date;

                uriBuilder.Query = query.ToString();

                SetClient(client);

                var response = await client.GetAsync(uriBuilder.Uri);
                var body = await response.Content.ReadAsStringAsync();

                if (response.IsSuccessStatusCode)
                {
                    var result = JsonConvert.DeserializeObject<CharacterPropensityDTO>(body);

                    return result;
                }
                else
                {
                    throw ParseError(body);
                }
            }
        }

        /// <summary>
        /// 어빌리티 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<CharacterAbilityDTO> GetCharacterAbility(string ocid)
        {
            return GetCharacterAbility(ocid, now);
        }

        /// <summary>
        /// 어빌리티 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<CharacterAbilityDTO> GetCharacterAbility(string ocid, DateTimeOffset dateTimeOffset)
        {
            using (var client = new HttpClient())
            {
                var path = "maplestory/v1/character/ability";
                var uriBuilder = new UriBuilder($"{BASE_URL}{path}");

                var date = ToDateString(MinDate(2023, 12, 21), dateTimeOffset);

                var query = HttpUtility.ParseQueryString(uriBuilder.Query);
                query["ocid"] = ocid;
                query["date"] = date;

                uriBuilder.Query = query.ToString();

                SetClient(client);

                var response = await client.GetAsync(uriBuilder.Uri);
                var body = await response.Content.ReadAsStringAsync();

                if (response.IsSuccessStatusCode)
                {
                    var result = JsonConvert.DeserializeObject<CharacterAbilityDTO>(body);

                    return result;
                }
                else
                {
                    throw ParseError(body);
                }
            }
        }

        /// <summary>
        /// 장착한 장비 중 캐시 장비를 제외한 나머지 장비 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<CharacterItemEquipmentDTO> GetCharacterItemEquipment(string ocid)
        {
            return GetCharacterItemEquipment(ocid, now);
        }

        /// <summary>
        /// 장착한 장비 중 캐시 장비를 제외한 나머지 장비 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<CharacterItemEquipmentDTO> GetCharacterItemEquipment(string ocid, DateTimeOffset dateTimeOffset)
        {
            using (var client = new HttpClient())
            {
                var path = "maplestory/v1/character/item-equipment";
                var uriBuilder = new UriBuilder($"{BASE_URL}{path}");

                var date = ToDateString(MinDate(2023, 12, 21), dateTimeOffset);

                var query = HttpUtility.ParseQueryString(uriBuilder.Query);
                query["ocid"] = ocid;
                query["date"] = date;

                uriBuilder.Query = query.ToString();

                SetClient(client);

                var response = await client.GetAsync(uriBuilder.Uri);
                var body = await response.Content.ReadAsStringAsync();

                if (response.IsSuccessStatusCode)
                {
                    var result = JsonConvert.DeserializeObject<CharacterItemEquipmentDTO>(body);

                    return result;
                }
                else
                {
                    throw ParseError(body);
                }
            }
        }

        /// <summary>
        /// 장착한 캐시 장비 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<CharacterAndroidCashItemEquipmentDTO> GetCharacterCashItemEquipment(string ocid)
        {
            return GetCharacterCashItemEquipment(ocid, now);
        }

        /// <summary>
        /// 장착한 캐시 장비 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<CharacterAndroidCashItemEquipmentDTO> GetCharacterCashItemEquipment(string ocid, DateTimeOffset dateTimeOffset)
        {
            using (var client = new HttpClient())
            {
                var path = "maplestory/v1/character/cashiteme-quipment";
                var uriBuilder = new UriBuilder($"{BASE_URL}{path}");

                var date = ToDateString(MinDate(2023, 12, 21), dateTimeOffset);

                var query = HttpUtility.ParseQueryString(uriBuilder.Query);
                query["ocid"] = ocid;
                query["date"] = date;

                uriBuilder.Query = query.ToString();

                SetClient(client);

                var response = await client.GetAsync(uriBuilder.Uri);
                var body = await response.Content.ReadAsStringAsync();

                if (response.IsSuccessStatusCode)
                {
                    var result = JsonConvert.DeserializeObject<CharacterAndroidCashItemEquipmentDTO>(body);

                    return result;
                }
                else
                {
                    throw ParseError(body);
                }
            }
        }

        /// <summary>
        /// 장착한 심볼 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<CharacterSymbolEquipmentDTO> GetCharacterSymbolEquipment(string ocid)
        {
            return GetCharacterSymbolEquipment(ocid, now);
        }

        /// <summary>
        /// 장착한 심볼 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<CharacterSymbolEquipmentDTO> GetCharacterSymbolEquipment(string ocid, DateTimeOffset dateTimeOffset)
        {
            using (var client = new HttpClient())
            {
                var path = "maplestory/v1/character/symbol-equipment";
                var uriBuilder = new UriBuilder($"{BASE_URL}{path}");

                var date = ToDateString(MinDate(2023, 12, 21), dateTimeOffset);

                var query = HttpUtility.ParseQueryString(uriBuilder.Query);
                query["ocid"] = ocid;
                query["date"] = date;

                uriBuilder.Query = query.ToString();

                SetClient(client);

                var response = await client.GetAsync(uriBuilder.Uri);
                var body = await response.Content.ReadAsStringAsync();

                if (response.IsSuccessStatusCode)
                {
                    var result = JsonConvert.DeserializeObject<CharacterSymbolEquipmentDTO>(body);

                    return result;
                }
                else
                {
                    throw ParseError(body);
                }
            }
        }

        /// <summary>
        /// 적용받고 있는 세트 효과 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<CharacterSetEffectDTO> GetCharacterSetEffectAsync(string ocid)
        {
            return GetCharacterSetEffectAsync(ocid, now);
        }

        /// <summary>
        /// 적용받고 있는 세트 효과 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<CharacterSetEffectDTO> GetCharacterSetEffectAsync(string ocid, DateTimeOffset dateTimeOffset)
        {
            using (var client = new HttpClient())
            {
                var path = "maplestory/v1/character/set-effect";
                var uriBuilder = new UriBuilder($"{BASE_URL}{path}");

                var date = ToDateString(MinDate(2023, 12, 21), dateTimeOffset);

                var query = HttpUtility.ParseQueryString(uriBuilder.Query);
                query["ocid"] = ocid;
                query["date"] = date;

                uriBuilder.Query = query.ToString();

                SetClient(client);

                var response = await client.GetAsync(uriBuilder.Uri);
                var body = await response.Content.ReadAsStringAsync();

                if (response.IsSuccessStatusCode)
                {
                    var result = JsonConvert.DeserializeObject<CharacterSetEffectDTO>(body);

                    return result;
                }
                else
                {
                    throw ParseError(body);
                }
            }
        }

        /// <summary>
        /// 장착 중인 헤어, 성형, 피부 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<CharacterBeautyEquipmentDTO> GetCharacterBeautyEquipment(string ocid)
        {
            return GetCharacterBeautyEquipment(ocid, now);
        }

        /// <summary>
        /// 장착 중인 헤어, 성형, 피부 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<CharacterBeautyEquipmentDTO> GetCharacterBeautyEquipment(string ocid, DateTimeOffset dateTimeOffset)
        {
            using (var client = new HttpClient())
            {
                var path = "maplestory/v1/character/beauty-equipment";
                var uriBuilder = new UriBuilder($"{BASE_URL}{path}");

                var date = ToDateString(MinDate(2023, 12, 21), dateTimeOffset);

                var query = HttpUtility.ParseQueryString(uriBuilder.Query);
                query["ocid"] = ocid;
                query["date"] = date;

                uriBuilder.Query = query.ToString();

                SetClient(client);

                var response = await client.GetAsync(uriBuilder.Uri);
                var body = await response.Content.ReadAsStringAsync();

                if (response.IsSuccessStatusCode)
                {
                    var result = JsonConvert.DeserializeObject<CharacterBeautyEquipmentDTO>(body);

                    return result;
                }
                else
                {
                    throw ParseError(body);
                }
            }
        }

        /// <summary>
        /// 장착한 안드로이드 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<CharacterAndroidEquipmentDTO> GetCharacterAndroidEquipment(string ocid)
        {
            return GetCharacterAndroidEquipment(ocid, now);
        }

        /// <summary>
        /// 장착한 안드로이드 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<CharacterAndroidEquipmentDTO> GetCharacterAndroidEquipment(string ocid, DateTimeOffset dateTimeOffset)
        {
            using (var client = new HttpClient())
            {
                var path = "maplestory/v1/character/android-equipment";
                var uriBuilder = new UriBuilder($"{BASE_URL}{path}");

                var date = ToDateString(MinDate(2023, 12, 21), dateTimeOffset);

                var query = HttpUtility.ParseQueryString(uriBuilder.Query);
                query["ocid"] = ocid;
                query["date"] = date;

                uriBuilder.Query = query.ToString();

                SetClient(client);

                var response = await client.GetAsync(uriBuilder.Uri);
                var body = await response.Content.ReadAsStringAsync();

                if (response.IsSuccessStatusCode)
                {
                    var result = JsonConvert.DeserializeObject<CharacterAndroidEquipmentDTO>(body);

                    return result;
                }
                else
                {
                    throw ParseError(body);
                }
            }
        }

        /// <summary>
        /// 장착한 펫 및 펫 스킬, 장비 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<CharacterPetEquipmentDTO> GetCharacterPetEquipment(string ocid)
        {
            return GetCharacterPetEquipment(ocid, now);
        }

        /// <summary>
        /// 장착한 펫 및 펫 스킬, 장비 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<CharacterPetEquipmentDTO> GetCharacterPetEquipment(string ocid, DateTimeOffset dateTimeOffset)
        {
            using (var client = new HttpClient())
            {
                var path = "maplestory/v1/character/pet-equipment"; 
                var uriBuilder = new UriBuilder($"{BASE_URL}{path}");

                var date = ToDateString(MinDate(2023, 12, 21), dateTimeOffset);

                var query = HttpUtility.ParseQueryString(uriBuilder.Query);
                query["ocid"] = ocid;
                query["date"] = date;

                uriBuilder.Query = query.ToString();

                SetClient(client);

                var response = await client.GetAsync(uriBuilder.Uri);
                var body = await response.Content.ReadAsStringAsync();

                if (response.IsSuccessStatusCode)
                {
                    var result = JsonConvert.DeserializeObject<CharacterPetEquipmentDTO>(body);

                    return result;
                }
                else
                {
                    throw ParseError(body);
                }
            }
        }

        /// <summary>
        /// 캐릭터 스킬과 하이퍼 스킬 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="characterSkillGrade">조회하고자 하는 전직 차수
        /// <para>0: 0차 스킬 및 제로 공용스킬</para>
        /// <para>1: 1차 스킬</para>
        /// <para>1.5: 1.5차 스킬</para>
        /// <para>2: 2차 스킬</para>
        /// <para>2.5: 2.5차 스킬</para>
        /// <para>3: 3차 스킬</para>
        /// <para>4: 4차 스킬 및 제로 알파/베타 스킬</para>
        /// <para>hyperpassive: 하이퍼 패시브 스킬</para>
        /// <para>hyperactive: 하이퍼 액티브 스킬</para>
        /// <para>5: 5차 스킬</para>
        /// <para>6: 6차 스킬</para>
        /// </param>
        public Task<CharacterSkillDTO> GetCharacterSkill(string ocid, string characterSkillGrade)
        {
            return GetCharacterSkill(ocid, characterSkillGrade, now);
        }

        /// <summary>
        /// 캐릭터 스킬과 하이퍼 스킬 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="characterSkillGrade">조회하고자 하는 전직 차수
        /// <para>0: 0차 스킬 및 제로 공용스킬</para>
        /// <para>1: 1차 스킬</para>
        /// <para>1.5: 1.5차 스킬</para>
        /// <para>2: 2차 스킬</para>
        /// <para>2.5: 2.5차 스킬</para>
        /// <para>3: 3차 스킬</para>
        /// <para>4: 4차 스킬 및 제로 알파/베타 스킬</para>
        /// <para>hyperpassive: 하이퍼 패시브 스킬</para>
        /// <para>hyperactive: 하이퍼 액티브 스킬</para>
        /// <para>5: 5차 스킬</para>
        /// <para>6: 6차 스킬</para>
        /// </param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>

        public async Task<CharacterSkillDTO> GetCharacterSkill(string ocid, string characterSkillGrade, DateTimeOffset dateTimeOffset)
        {
            using (var client = new HttpClient())
            {
                var path = "maplestory/v1/character/skill";
                var uriBuilder = new UriBuilder($"{BASE_URL}{path}");

                var date = ToDateString(MinDate(2023, 12, 21), dateTimeOffset);

                var query = HttpUtility.ParseQueryString(uriBuilder.Query);
                query["ocid"] = ocid;
                query["date"] = date;
                query["character_skill_grade"] = characterSkillGrade;

                uriBuilder.Query = query.ToString();

                SetClient(client);

                var response = await client.GetAsync(uriBuilder.Uri);
                var body = await response.Content.ReadAsStringAsync();

                if (response.IsSuccessStatusCode)
                {
                    var result = JsonConvert.DeserializeObject<CharacterSkillDTO>(body);

                    return result;
                }
                else
                {
                    throw ParseError(body);
                }
            }
        }

        /// <summary>
        /// 장착 링크 스킬 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<CharacterLinkSkillDTO> GetCharacterLinkSkill(string ocid)
        {
            return GetCharacterLinkSkill(ocid, now);
        }

        /// <summary>
        /// 장착 링크 스킬 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<CharacterLinkSkillDTO> GetCharacterLinkSkill(string ocid, DateTimeOffset dateTimeOffset)
        {
            using (var client = new HttpClient())
            {
                var path = "maplestory/v1/character/link-skill";
                var uriBuilder = new UriBuilder($"{BASE_URL}{path}");

                var date = ToDateString(MinDate(2023, 12, 21), dateTimeOffset);

                var query = HttpUtility.ParseQueryString(uriBuilder.Query);
                query["ocid"] = ocid;
                query["date"] = date;

                uriBuilder.Query = query.ToString();

                SetClient(client);

                var response = await client.GetAsync(uriBuilder.Uri);
                var body = await response.Content.ReadAsStringAsync();

                if (response.IsSuccessStatusCode)
                {
                    var result = JsonConvert.DeserializeObject<CharacterLinkSkillDTO>(body);

                    return result;
                }
                else
                {
                    throw ParseError(body);
                }
            }
        }

        /// <summary>
        /// V매트릭스 슬롯 정보와 장착한 V코어 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<CharacterVMatrixDTO> GetCharacterVMatrix(string ocid)
        {
            return GetCharacterVMatrix(ocid, now);
        }

        /// <summary>
        /// V매트릭스 슬롯 정보와 장착한 V코어 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<CharacterVMatrixDTO> GetCharacterVMatrix(string ocid, DateTimeOffset dateTimeOffset)
        {
            using (var client = new HttpClient())
            {
                var path = "maplestory/v1/character/vmatrix";
                var uriBuilder = new UriBuilder($"{BASE_URL}{path}");

                var date = ToDateString(MinDate(2023, 12, 21), dateTimeOffset);

                var query = HttpUtility.ParseQueryString(uriBuilder.Query);
                query["ocid"] = ocid;
                query["date"] = date;

                uriBuilder.Query = query.ToString();

                SetClient(client);

                var response = await client.GetAsync(uriBuilder.Uri);
                var body = await response.Content.ReadAsStringAsync();

                if (response.IsSuccessStatusCode)
                {
                    var result = JsonConvert.DeserializeObject<CharacterVMatrixDTO>(body);

                    return result;
                }
                else
                {
                    throw ParseError(body);
                }
            }
        }

        /// <summary>
        /// HEXA 매트릭스에 장착한 HEXA 코어 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<CharacterHexaMatrixDTO> GetCharacterHexaMatrix(string ocid)
        {
            return GetCharacterHexaMatrix(ocid, now);
        }

        /// <summary>
        /// HEXA 매트릭스에 장착한 HEXA 코어 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<CharacterHexaMatrixDTO> GetCharacterHexaMatrix(string ocid, DateTimeOffset dateTimeOffset)
        {
            using (var client = new HttpClient())
            {
                var path = "maplestory/v1/character/hexamatrix";
                var uriBuilder = new UriBuilder($"{BASE_URL}{path}");

                var date = ToDateString(MinDate(2023, 12, 21), dateTimeOffset);

                var query = HttpUtility.ParseQueryString(uriBuilder.Query);
                query["ocid"] = ocid;
                query["date"] = date;

                uriBuilder.Query = query.ToString();

                SetClient(client);

                var response = await client.GetAsync(uriBuilder.Uri);
                var body = await response.Content.ReadAsStringAsync();

                if (response.IsSuccessStatusCode)
                {
                    var result = JsonConvert.DeserializeObject<CharacterHexaMatrixDTO>(body);

                    return result;
                }
                else
                {
                    throw ParseError(body);
                }
            }
        }

        /// <summary>
        /// HEXA 매트릭스에 설정한 HEXA 스탯 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<CharacterHexaMatrixStatDTO> GetCharacterHexaMatrixStat(string ocid)
        {
            return GetCharacterHexaMatrixStat(ocid, now);
        }

        /// <summary>
        /// HEXA 매트릭스에 설정한 HEXA 스탯 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<CharacterHexaMatrixStatDTO> GetCharacterHexaMatrixStat(string ocid, DateTimeOffset dateTimeOffset)
        {
            using (var client = new HttpClient())
            {
                var path = "maplestory/v1/character/hexamatrix-stat";
                var uriBuilder = new UriBuilder($"{BASE_URL}{path}");

                var date = ToDateString(MinDate(2023, 12, 21), dateTimeOffset);

                var query = HttpUtility.ParseQueryString(uriBuilder.Query);
                query["ocid"] = ocid;
                query["date"] = date;

                uriBuilder.Query = query.ToString();

                SetClient(client);

                var response = await client.GetAsync(uriBuilder.Uri);
                var body = await response.Content.ReadAsStringAsync();

                if (response.IsSuccessStatusCode)
                {
                    var result = JsonConvert.DeserializeObject<CharacterHexaMatrixStatDTO>(body);

                    return result;
                }
                else
                {
                    throw ParseError(body);
                }
            }
        }

        /// <summary>
        /// 캐릭터 무릉도장 최고 기록 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<CharacterDojangDTO> GetCharacterDojang(string ocid)
        {
            return GetCharacterDojang(ocid, now);
        }

        /// <summary>
        /// 캐릭터 무릉도장 최고 기록 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<CharacterDojangDTO> GetCharacterDojang(string ocid, DateTimeOffset dateTimeOffset)
        {
            using (var client = new HttpClient())
            {
                var path = "maplestory/v1/character/dojang";
                var uriBuilder = new UriBuilder($"{BASE_URL}{path}");

                var date = ToDateString(MinDate(2023, 12, 21), dateTimeOffset);

                var query = HttpUtility.ParseQueryString(uriBuilder.Query);
                query["ocid"] = ocid;
                query["date"] = date;

                uriBuilder.Query = query.ToString();

                SetClient(client);

                var response = await client.GetAsync(uriBuilder.Uri);
                var body = await response.Content.ReadAsStringAsync();

                if (response.IsSuccessStatusCode)
                {
                    var result = JsonConvert.DeserializeObject<CharacterDojangDTO>(body);

                    return result;
                }
                else
                {
                    throw ParseError(body);
                }
            }
        }

        #endregion

        #region 유니온 정보 조회

        /// <summary>
        /// 유니온 레벨 및 유니온 등급 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<UnionDTO> GetUnion(string ocid)
        {
            return GetUnion(ocid, now);
        }

        /// <summary>
        /// 유니온 레벨 및 유니온 등급 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<UnionDTO> GetUnion(string ocid, DateTimeOffset dateTimeOffset)
        {
            using (var client = new HttpClient())
            {
                var path = "maplestory/v1/union";
                var uriBuilder = new UriBuilder($"{BASE_URL}{path}");

                var date = ToDateString(MinDate(2023, 12, 21), dateTimeOffset);

                var query = HttpUtility.ParseQueryString(uriBuilder.Query);
                query["ocid"] = ocid;
                query["date"] = date;

                uriBuilder.Query = query.ToString();

                this.SetClient(client);

                var response = await client.GetAsync(uriBuilder.Uri);
                var body = await response.Content.ReadAsStringAsync();

                if (response.IsSuccessStatusCode)
                {
                    var result = JsonConvert.DeserializeObject<UnionDTO>(body);
                    return result;
                }
                else
                {
                    throw ParseError(body);
                }
            }
        }

        /// <summary>
        /// 유니온에 배치된 공격대원 효과 및 공격대 점령 효과 등 상세 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<UnionRaiderDTO> GetUnionRaider(string ocid)
        {
            return GetUnionRaider(ocid, now);
        }

        /// <summary>
        /// 유니온에 배치된 공격대원 효과 및 공격대 점령 효과 등 상세 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<UnionRaiderDTO> GetUnionRaider(string ocid, DateTimeOffset dateTimeOffset)
        {
            using (var client = new HttpClient())
            {
                var path = "maplestory/v1/union-raider";
                var uriBuilder = new UriBuilder($"{BASE_URL}{path}");

                var date = ToDateString(MinDate(2023, 12, 21), dateTimeOffset);

                var query = HttpUtility.ParseQueryString(uriBuilder.Query);
                query["ocid"] = ocid;
                query["date"] = date;

                uriBuilder.Query = query.ToString();

                this.SetClient(client);

                var response = await client.GetAsync(uriBuilder.Uri);
                var body = await response.Content.ReadAsStringAsync();

                if (response.IsSuccessStatusCode)
                {
                    var result = JsonConvert.DeserializeObject<UnionRaiderDTO>(body);
                    return result;
                }
                else
                {
                    throw ParseError(body);
                }
            }
        }

        #endregion

        /// <summary>
        /// 오늘 날짜의 큐브 사용 결과를 조회합니다.
        /// <para>큐브 사용 결과 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.</para>
        /// <para>큐브 사용 결과 데이터는 2022년 11월 25일부터 조회할 수 있습니다.</para>
        /// <para>e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.</para>
        /// </summary>
        /// <param name="count">한번에 가져오려는 결과의 개수(최소 10, 최대 1000)</param>
        public Task<CubeHistoryResponseDTO> GetCubeResult(int count)
        {
            var utcNow = DateTimeOffset.UtcNow;
            var kstNow = utcNow.ToOffset(TimeSpan.FromHours(9));
            
            return GetCubeResult(count, kstNow.Year, kstNow.Month, kstNow.Day);
        }

        /// <summary>
        /// 지목한 날짜의 큐브 사용 결과를 조회합니다.
        /// <para>큐브 사용 결과 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.</para>
        /// <para>큐브 사용 결과 데이터는 2022년 11월 25일부터 조회할 수 있습니다.</para>
        /// <para>e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.</para>
        /// </summary>
        /// <param name="count">한번에 가져오려는 결과의 개수(최소 10, 최대 1000)</param>
        /// <param name="year">조회 기준일 (KST) 연도</param>
        /// <param name="month">조회 기준일 (KST) 월</param>
        /// <param name="day">조회 기준일 (KST) 월의 날짜</param>
        public async Task<CubeHistoryResponseDTO> GetCubeResult(int count, int year, int month, int day)
        {
            if (year <= 2022 && month <= 11 && day < 25)
            {
                throw new ArgumentException("You can only retrieve data after 2022-11-25.");
            }

            using (var client = new HttpClient())
            {
                var path = "maplestory/v1/history/cube";
                var uriBuilder = new UriBuilder($"{BASE_URL}{path}");

                var query = HttpUtility.ParseQueryString(uriBuilder.Query);
                query["count"] = count.ToString();
                query["date_kst"] = new DateTime(year, month, day).ToString("yyyyMMdd");

                uriBuilder.Query = query.ToString();

                this.SetClient(client);

                var response = await client.GetAsync(uriBuilder.Uri);
                var body = await response.Content.ReadAsStringAsync();

                if (response.IsSuccessStatusCode)
                {
                    var result = JsonConvert.DeserializeObject<CubeHistoryResponseDTO>(body);

                    return result;
                }
                else
                {
                    throw ParseError(body);
                }
            }
        }

        /// <summary>
        /// 지목한 날짜의 큐브 사용 결과를 조회합니다.
        /// <para>큐브 사용 결과 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.</para>
        /// <para>큐브 사용 결과 데이터는 2022년 11월 25일부터 조회할 수 있습니다.</para>
        /// <para>e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.</para>
        /// </summary>
        /// <param name="count">한번에 가져오려는 결과의 개수(최소 10, 최대 1000)</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public Task<CubeHistoryResponseDTO> GetCubeResult(int count, DateTimeOffset dateTimeOffset)
        {
            var kstDate = dateTimeOffset.ToOffset(TimeSpan.FromHours(9));

            return GetCubeResult(count, kstDate.Year, kstDate.Month, kstDate.Day);
        }

        /// <summary>
        /// 큐브 사용 결과를 조회합니다.
        /// <para>큐브 사용 결과 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.</para>
        /// <para>큐브 사용 결과 데이터는 2022년 11월 25일부터 조회할 수 있습니다.</para>
        /// <para>e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.</para>
        /// </summary>
        /// <param name="count">한번에 가져오려는 결과의 개수(최소 10, 최대 1000)</param>
        /// <param name="cursor">페이징 처리를 위한 cursor</param>
        public async Task<CubeHistoryResponseDTO> GetCubeResult(int count, string cursor)
        {
            using (var client = new HttpClient())
            {
                var path = "maplestory/v1/history/cube";
                var uriBuilder = new UriBuilder($"{BASE_URL}{path}");

                var query = HttpUtility.ParseQueryString(uriBuilder.Query);
                query["count"] = count.ToString();
                query["cursor"] = cursor;

                uriBuilder.Query = query.ToString();

                this.SetClient(client);

                var response = await client.GetAsync(uriBuilder.Uri);
                var body = await response.Content.ReadAsStringAsync();

                if (response.IsSuccessStatusCode)
                {
                    var result = JsonConvert.DeserializeObject<CubeHistoryResponseDTO>(body);

                    return result;
                }
                else
                {
                    throw ParseError(body);
                }
            }
        }

        /// <summary>
        /// 서버 점검 정보를 조회합니다.
        /// </summary>
        public async Task<InspectionInfoDTO> GetInspectionInfo()
        {
            using (var client = new HttpClient())
            {
                var baseUrl = "https://api.maplestory.nexon.com/";
                var path = "soap/maplestory.asmx";
                var uriBuilder = new UriBuilder($"{baseUrl}{path}");

                client.DefaultRequestHeaders.Add("SOAPAction", "https://api.maplestory.nexon.com/soap/GetInspectionInfo");
                client.Timeout = TimeSpan.FromMilliseconds(this.timeOut);

                var soapEnvelop =
                "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "  <soap:Body>\n" +
                "    <GetInspectionInfo xmlns=\"https://api.maplestory.nexon.com/soap/\" />\n" +
                "  </soap:Body>\n" +
                "</soap:Envelope>";
                var body = new StringContent(soapEnvelop, Encoding.UTF8, "text/xml");

                var response = await client.PostAsync(uriBuilder.Uri, body);

                if (response.IsSuccessStatusCode)
                {
                    var responseBody = await response.Content.ReadAsStringAsync();

                    return new InspectionInfoDTO(responseBody);
                }
                else
                {
                    throw new MapleStoryAPIException(MapleStoryAPIErrorCode.OPENAPI00003, "Bad Request");
                }
            }
        }

        private void SetClient(HttpClient client)
        {
            client.Timeout = TimeSpan.FromMilliseconds(this.timeOut);
            client.DefaultRequestHeaders.Add("x-nxopen-api-key", this.apiKey);
        }

        private static DateTimeOffset MinDate(int year, int month, int day)
        {
            return new DateTimeOffset(year, month, day, 0, 0, 0, TimeSpan.FromHours(9));
        }

        private static string ToDateString(DateTimeOffset minDate, DateTimeOffset date)
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

        private static MapleStoryAPIException ParseError(string body)
        {
            var error = JsonConvert.DeserializeObject<MapleStoryAPIErrorBody>(body);

            return new MapleStoryAPIException(error);
        }
    }
}