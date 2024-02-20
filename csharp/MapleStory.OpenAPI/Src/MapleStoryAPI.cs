using MapleStory.OpenAPI.Dto;
using Newtonsoft.Json;
using MapleStory.OpenAPI.Src.Dto.Union;
using RestSharp;

namespace MapleStory.OpenAPI
{
    /// <summary>
    /// MapleStory OpenAPI client.
    /// <para>This is an implementation of <a href="https://openapi.nexon.com/game/maplestory">MapleStory API</a></para>
    /// </summary>
    public class MapleStoryAPI
    {
        private readonly string apiKey;

        private readonly RestClient client;

        private static readonly string BASE_URL = "https://open.api.nexon.com/";

        // in milliseconds
        private int timeOut { get; set; }

        public MapleStoryAPI (string apiKey)
        {
            this.apiKey = apiKey;
            this.timeOut = 5000;
            this.client = new RestClient(options: new RestClientOptions(BASE_URL));
        }

        #region 캐릭터 정보 조회

        /// <summary>
        /// 캐릭터 식별자(ocid)를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="characterName">캐릭터 명</param>
        public async Task<CharacterDTO> GetCharacter(string characterName)
        {
            var path = "maplestory/v1/id";
            var query = new Dictionary<string, string?>()
            {
                { "character_name", characterName }
            };

            return await Get<CharacterDTO>(path, query);
        }

        /// <summary>
        /// 기본 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="characterName">캐릭터 식별자</param>
        public Task<CharacterBasicDTO> GetCharacterBasic(string ocid)
        {
            return GetCharacterBasic(ocid, GetProperDefaultDateTimeOffset(new LatestApiUpdateTimeOption
            {
                Hour = 1,
                Minute = 0,
                DateOffset = 1
            }));
        }

        /// <summary>
        /// 기본 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="characterName">캐릭터 식별자</param>
        /// <param name="characterName">조회 기준일 (KST)</param>
        public async Task<CharacterBasicDTO> GetCharacterBasic(string ocid, DateTimeOffset dateTimeOffset)
        {
            var path = "maplestory/v1/character/basic";
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", ToDateString(MinDate(2023, 12, 21), dateTimeOffset) }
            };

            return await Get<CharacterBasicDTO>(path, query);
        }

        /// <summary>
        /// 인기도 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<CharacterPopularityDTO> GetCharacterPopularity(string ocid)
        {
            return GetCharacterPopularity(ocid, GetProperDefaultDateTimeOffset(new LatestApiUpdateTimeOption
            {
                Hour = 1,
                Minute = 0,
                DateOffset = 1
            }));
        }

        /// <summary>
        /// 인기도 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<CharacterPopularityDTO> GetCharacterPopularity(string ocid, DateTimeOffset dateTimeOffset)
        {
            var path = "maplestory/v1/character/popularity";
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", ToDateString(MinDate(2023, 12, 21), dateTimeOffset) }
            };

            return await Get<CharacterPopularityDTO>(path, query);
        }

        /// <summary>
        /// 종합 능력치 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        public Task<CharacterStatDTO> GetCharacterStat(string ocid)
        {
            return GetCharacterStat(ocid, GetProperDefaultDateTimeOffset(new LatestApiUpdateTimeOption
            {
                Hour = 1,
                Minute = 0,
                DateOffset = 1
            }));
        }

        /// <summary>
        /// 종합 능력치 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<CharacterStatDTO> GetCharacterStat(string ocid, DateTimeOffset dateTimeOffset)
        {
            var path = "maplestory/v1/character/stat";
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", ToDateString(MinDate(2023, 12, 21), dateTimeOffset) }
            };

            return await Get<CharacterStatDTO>(path, query);
        }

        /// <summary>
        /// 하이퍼스탯 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<CharacterHyperStatDTO> GetCharacterHyperStat(string ocid)
        {
            return GetCharacterHyperStat(ocid, GetProperDefaultDateTimeOffset(new LatestApiUpdateTimeOption
            {
                Hour = 1,
                Minute = 0,
                DateOffset = 1
            }));
        }

        /// <summary>
        /// 하이퍼스탯 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<CharacterHyperStatDTO> GetCharacterHyperStat(string ocid, DateTimeOffset dateTimeOffset)
        {
            var path = "maplestory/v1/character/hyper-stat";
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", ToDateString(MinDate(2023, 12, 21), dateTimeOffset) }
            };

            return await Get<CharacterHyperStatDTO>(path, query);
        }

        /// <summary>
        /// 성향 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<CharacterPropensityDTO> GetCharacterPropensity(string ocid)
        {
            return GetCharacterPropensity(ocid, GetProperDefaultDateTimeOffset(new LatestApiUpdateTimeOption
            {
                Hour = 1,
                Minute = 0,
                DateOffset = 1
            }));
        }

        /// <summary>
        /// 성향 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<CharacterPropensityDTO> GetCharacterPropensity(string ocid, DateTimeOffset dateTimeOffset)
        {
            var path = "maplestory/v1/character/propensity";
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", ToDateString(MinDate(2023, 12, 21), dateTimeOffset) }
            };

            return await Get<CharacterPropensityDTO>(path, query);
        }

        /// <summary>
        /// 어빌리티 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<CharacterAbilityDTO> GetCharacterAbility(string ocid)
        {
            return GetCharacterAbility(ocid, GetProperDefaultDateTimeOffset(new LatestApiUpdateTimeOption
            {
                Hour = 1,
                Minute = 0,
                DateOffset = 1
            }));
        }

        /// <summary>
        /// 어빌리티 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<CharacterAbilityDTO> GetCharacterAbility(string ocid, DateTimeOffset dateTimeOffset)
        {
            var path = "maplestory/v1/character/ability";
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", ToDateString(MinDate(2023, 12, 21), dateTimeOffset) }
            };

            return await Get<CharacterAbilityDTO>(path, query);
        }

        /// <summary>
        /// 장착한 장비 중 캐시 장비를 제외한 나머지 장비 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<CharacterItemEquipmentDTO> GetCharacterItemEquipment(string ocid)
        {
            return GetCharacterItemEquipment(ocid, GetProperDefaultDateTimeOffset(new LatestApiUpdateTimeOption
            {
                Hour = 1,
                Minute = 0,
                DateOffset = 1
            }));
        }

        /// <summary>
        /// 장착한 장비 중 캐시 장비를 제외한 나머지 장비 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<CharacterItemEquipmentDTO> GetCharacterItemEquipment(string ocid, DateTimeOffset dateTimeOffset)
        {
            var path = "maplestory/v1/character/item-equipment";
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", ToDateString(MinDate(2023, 12, 21), dateTimeOffset) }
            };

            return await Get<CharacterItemEquipmentDTO>(path, query);
        }

        /// <summary>
        /// 장착한 캐시 장비 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<CharacterCashItemEquipmentDTO> GetCharacterCashItemEquipment(string ocid)
        {
            return GetCharacterCashItemEquipment(ocid, GetProperDefaultDateTimeOffset(new LatestApiUpdateTimeOption
            {
                Hour = 1,
                Minute = 0,
                DateOffset = 1
            }));
        }

        /// <summary>
        /// 장착한 캐시 장비 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<CharacterCashItemEquipmentDTO> GetCharacterCashItemEquipment(string ocid, DateTimeOffset dateTimeOffset)
        {
            var path = "maplestory/v1/character/cashitem-equipment";
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", ToDateString(MinDate(2023, 12, 21), dateTimeOffset) }
            };

            return await Get<CharacterCashItemEquipmentDTO>(path, query);
        }

        /// <summary>
        /// 장착한 심볼 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<CharacterSymbolEquipmentDTO> GetCharacterSymbolEquipment(string ocid)
        {
            return GetCharacterSymbolEquipment(ocid, GetProperDefaultDateTimeOffset(new LatestApiUpdateTimeOption
            {
                Hour = 1,
                Minute = 0,
                DateOffset = 1
            }));
        }

        /// <summary>
        /// 장착한 심볼 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<CharacterSymbolEquipmentDTO> GetCharacterSymbolEquipment(string ocid, DateTimeOffset dateTimeOffset)
        {
            var path = "maplestory/v1/character/symbol-equipment";
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", ToDateString(MinDate(2023, 12, 21), dateTimeOffset) }
            };

            return await Get<CharacterSymbolEquipmentDTO>(path, query);
        }

        /// <summary>
        /// 적용받고 있는 세트 효과 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<CharacterSetEffectDTO> GetCharacterSetEffectAsync(string ocid)
        {
            return GetCharacterSetEffectAsync(ocid, GetProperDefaultDateTimeOffset(new LatestApiUpdateTimeOption
            {
                Hour = 1,
                Minute = 0,
                DateOffset = 1
            }));
        }

        /// <summary>
        /// 적용받고 있는 세트 효과 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<CharacterSetEffectDTO> GetCharacterSetEffectAsync(string ocid, DateTimeOffset dateTimeOffset)
        {
            var path = "maplestory/v1/character/set-effect";
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", ToDateString(MinDate(2023, 12, 21), dateTimeOffset) }
            };

            return await Get<CharacterSetEffectDTO>(path, query);
        }

        /// <summary>
        /// 장착 중인 헤어, 성형, 피부 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<CharacterBeautyEquipmentDTO> GetCharacterBeautyEquipment(string ocid)
        {
            return GetCharacterBeautyEquipment(ocid, GetProperDefaultDateTimeOffset(new LatestApiUpdateTimeOption
            {
                Hour = 1,
                Minute = 0,
                DateOffset = 1
            }));
        }

        /// <summary>
        /// 장착 중인 헤어, 성형, 피부 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<CharacterBeautyEquipmentDTO> GetCharacterBeautyEquipment(string ocid, DateTimeOffset dateTimeOffset)
        {
            var path = "maplestory/v1/character/beauty-equipment";
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", ToDateString(MinDate(2023, 12, 21), dateTimeOffset) }
            };

            return await Get<CharacterBeautyEquipmentDTO>(path, query);
        }

        /// <summary>
        /// 장착한 안드로이드 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<CharacterAndroidEquipmentDTO> GetCharacterAndroidEquipment(string ocid)
        {
            return GetCharacterAndroidEquipment(ocid, GetProperDefaultDateTimeOffset(new LatestApiUpdateTimeOption
            {
                Hour = 1,
                Minute = 0,
                DateOffset = 1
            }));
        }

        /// <summary>
        /// 장착한 안드로이드 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<CharacterAndroidEquipmentDTO> GetCharacterAndroidEquipment(string ocid, DateTimeOffset dateTimeOffset)
        {
            var path = "maplestory/v1/character/android-equipment";
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", ToDateString(MinDate(2023, 12, 21), dateTimeOffset) }
            };

            return await Get<CharacterAndroidEquipmentDTO>(path, query);
        }

        /// <summary>
        /// 장착한 펫 및 펫 스킬, 장비 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<CharacterPetEquipmentDTO> GetCharacterPetEquipment(string ocid)
        {
            return GetCharacterPetEquipment(ocid, GetProperDefaultDateTimeOffset(new LatestApiUpdateTimeOption
            {
                Hour = 1,
                Minute = 0,
                DateOffset = 1
            }));
        }

        /// <summary>
        /// 장착한 펫 및 펫 스킬, 장비 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<CharacterPetEquipmentDTO> GetCharacterPetEquipment(string ocid, DateTimeOffset dateTimeOffset)
        {
            var path = "maplestory/v1/character/pet-equipment";
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", ToDateString(MinDate(2023, 12, 21), dateTimeOffset) }
            };

            return await Get<CharacterPetEquipmentDTO>(path, query);
        }

        /// <summary>
        /// 캐릭터 스킬과 하이퍼 스킬 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
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
            return GetCharacterSkill(ocid, characterSkillGrade, GetProperDefaultDateTimeOffset(new LatestApiUpdateTimeOption
            {
                Hour = 1,
                Minute = 0,
                DateOffset = 1
            }));
        }

        /// <summary>
        /// 캐릭터 스킬과 하이퍼 스킬 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
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
            var path = "maplestory/v1/character/skill";
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", ToDateString(MinDate(2023, 12, 21), dateTimeOffset) },
                { "character_skill_grade", characterSkillGrade }
            };

            return await Get<CharacterSkillDTO>(path, query);
        }

        /// <summary>
        /// 장착 링크 스킬 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<CharacterLinkSkillDTO> GetCharacterLinkSkill(string ocid)
        {
            return GetCharacterLinkSkill(ocid, GetProperDefaultDateTimeOffset(new LatestApiUpdateTimeOption
            {
                Hour = 1,
                Minute = 0,
                DateOffset = 1
            }));
        }

        /// <summary>
        /// 장착 링크 스킬 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<CharacterLinkSkillDTO> GetCharacterLinkSkill(string ocid, DateTimeOffset dateTimeOffset)
        {
            var path = "maplestory/v1/character/link-skill";
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", ToDateString(MinDate(2023, 12, 21), dateTimeOffset) }
            };

            return await Get<CharacterLinkSkillDTO>(path, query);
        }

        /// <summary>
        /// V매트릭스 슬롯 정보와 장착한 V코어 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<CharacterVMatrixDTO> GetCharacterVMatrix(string ocid)
        {
            return GetCharacterVMatrix(ocid, GetProperDefaultDateTimeOffset(new LatestApiUpdateTimeOption
            {
                Hour = 1,
                Minute = 0,
                DateOffset = 1
            }));
        }

        /// <summary>
        /// V매트릭스 슬롯 정보와 장착한 V코어 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<CharacterVMatrixDTO> GetCharacterVMatrix(string ocid, DateTimeOffset dateTimeOffset)
        {
            var path = "maplestory/v1/character/vmatrix";
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", ToDateString(MinDate(2023, 12, 21), dateTimeOffset) }
            };

            return await Get<CharacterVMatrixDTO>(path, query);
        }

        /// <summary>
        /// HEXA 매트릭스에 장착한 HEXA 코어 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<CharacterHexaMatrixDTO> GetCharacterHexaMatrix(string ocid)
        {
            return GetCharacterHexaMatrix(ocid, GetProperDefaultDateTimeOffset(new LatestApiUpdateTimeOption
            {
                Hour = 1,
                Minute = 0,
                DateOffset = 1
            }));
        }

        /// <summary>
        /// HEXA 매트릭스에 장착한 HEXA 코어 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<CharacterHexaMatrixDTO> GetCharacterHexaMatrix(string ocid, DateTimeOffset dateTimeOffset)
        {
            var path = "maplestory/v1/character/hexamatrix";
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", ToDateString(MinDate(2023, 12, 21), dateTimeOffset) }
            };

            return await Get<CharacterHexaMatrixDTO>(path, query);
        }

        /// <summary>
        /// HEXA 매트릭스에 설정한 HEXA 스탯 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<CharacterHexaMatrixStatDTO> GetCharacterHexaMatrixStat(string ocid)
        {
            return GetCharacterHexaMatrixStat(ocid, GetProperDefaultDateTimeOffset(new LatestApiUpdateTimeOption
            {
                Hour = 1,
                Minute = 0,
                DateOffset = 1
            }));
        }

        /// <summary>
        /// HEXA 매트릭스에 설정한 HEXA 스탯 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<CharacterHexaMatrixStatDTO> GetCharacterHexaMatrixStat(string ocid, DateTimeOffset dateTimeOffset)
        {
            var path = "maplestory/v1/character/hexamatrix-stat";
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", ToDateString(MinDate(2023, 12, 21), dateTimeOffset) }
            };

            return await Get<CharacterHexaMatrixStatDTO>(path, query);
        }

        /// <summary>
        /// 캐릭터 무릉도장 최고 기록 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<CharacterDojangDTO> GetCharacterDojang(string ocid)
        {
            return GetCharacterDojang(ocid, GetProperDefaultDateTimeOffset(new LatestApiUpdateTimeOption
            {
                Hour = 1,
                Minute = 0,
                DateOffset = 1
            }));
        }

        /// <summary>
        /// 캐릭터 무릉도장 최고 기록 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<CharacterDojangDTO> GetCharacterDojang(string ocid, DateTimeOffset dateTimeOffset)
        {
            var path = "maplestory/v1/character/dojang";
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", ToDateString(MinDate(2023, 12, 21), dateTimeOffset) }
            };

            return await Get<CharacterDojangDTO>(path, query);
        }

        #endregion

        #region 유니온 정보 조회

        /// <summary>
        /// 유니온 레벨 및 유니온 등급 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 유니온 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<UnionDTO> GetUnion(string ocid)
        {
            return GetUnion(ocid, GetProperDefaultDateTimeOffset(new LatestApiUpdateTimeOption
            {
                Hour = 1,
                Minute = 0,
                DateOffset = 1
            }));
        }

        /// <summary>
        /// 유니온 레벨 및 유니온 등급 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 유니온 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<UnionDTO> GetUnion(string ocid, DateTimeOffset dateTimeOffset)
        {
            var path = "maplestory/v1/user/union";
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", ToDateString(MinDate(2023, 12, 21), dateTimeOffset) }
            };

            return await Get<UnionDTO>(path, query);
        }

        /// <summary>
        /// 유니온에 배치된 공격대원 효과 및 공격대 점령 효과 등 상세 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 유니온 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<UnionRaiderDTO> GetUnionRaider(string ocid)
        {
            return GetUnionRaider(ocid, GetProperDefaultDateTimeOffset(new LatestApiUpdateTimeOption
            {
                Hour = 1,
                Minute = 0,
                DateOffset = 1
            }));
        }

        /// <summary>
        /// 유니온에 배치된 공격대원 효과 및 공격대 점령 효과 등 상세 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 유니온 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<UnionRaiderDTO> GetUnionRaider(string ocid, DateTimeOffset dateTimeOffset)
        {
            var path = "maplestory/v1/user/union-raider";
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", ToDateString(MinDate(2023, 12, 21), dateTimeOffset) }
            };

            return await Get<UnionRaiderDTO>(path, query);
        }

        /// <summary>
        /// 유니온 아티팩트 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 유니온 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        public Task<UnionArtifactDTO> GetUnionArtifact(string ocid)
        {
            return GetUnionArtifact(ocid, GetProperDefaultDateTimeOffset(new LatestApiUpdateTimeOption
            {
                Hour = 1,
                Minute = 0,
                DateOffset = 1
            }));
        }

        /// <summary>
        /// 유니온 아티팩트 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 유니온 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<UnionArtifactDTO> GetUnionArtifact(string ocid, DateTimeOffset dateTimeOffset)
        {
            var path = "maplestory/v1/user/union-artifact";
            var query = new Dictionary<string, string?>()
            {
                { "ocid", ocid },
                { "date", ToDateString(MinDate(2023, 12, 21), dateTimeOffset) }
            };

            return await Get<UnionArtifactDTO>(path, query);
        }

        #endregion

        #region 길드 정보 조회

        /// <summary>
        /// 길드 식별자(oguild_id) 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="guildName">길드 명</param>
        /// <param name="wolrdName">월드 명
        /// <para>스카니아</para>
        /// <para>베라</para>
        /// <para>루나</para>
        /// <para>제니스</para>
        /// <para>크로아</para>
        /// <para>유니온</para>
        /// <para>엘리시움</para>
        /// <para>이노시스</para>
        /// <para>레드</para>
        /// <para>오로라</para>
        /// <para>아케인</para>
        /// <para>노바</para>
        /// <para>리부트</para>
        /// <para>리부트2</para>
        /// <para>버닝</para>
        /// <para>버닝2</para>
        /// <para>버닝3</para>
        /// </param>
        public async Task<GuildDTO> GetGuild(string guildName, string wolrdName)
        {
            var path = "maplestory/v1/guild/id";
            var query = new Dictionary<string, string?>()
            {
                { "guild_name", guildName },
                { "world_name", wolrdName }
            };

            return await Get<GuildDTO>(path, query);
        }

        /// <summary>
        /// 길드 기본 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="oGuildId">길드 식별자</param>
        public Task<GuildBasicDTO> GetGuildBasic(string oGuildId)
        {
            return GetGuildBasic(oGuildId, GetProperDefaultDateTimeOffset(new LatestApiUpdateTimeOption
            {
                Hour = 1,
                Minute = 0,
                DateOffset = 1
            }));
        }

        /// <summary>
        /// 길드 기본 정보를 조회합니다.
        /// <para>- 2023년 12월 21일 데이터부터 조회할 수 있습니다.</para>
        /// <para>- 오전 1시부터 전일 데이터 조회가 가능합니다</para>
        /// <para>- 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.</para>
        /// </summary>
        /// <param name="oGuildId">길드 식별자</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        /// <returns>길드 기본 정보</returns>
        public async Task<GuildBasicDTO> GetGuildBasic(string oGuildId, DateTimeOffset dateTimeOffset)
        {
            var path = "maplestory/v1/guild/basic";
            var query = new Dictionary<string, string?>()
            {
                { "oguild_id", oGuildId },
                { "date", ToDateString(MinDate(2023, 12, 21), dateTimeOffset) }
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
            var path = "maplestory/v1/history/starforce";
            var query = new Dictionary<string, string?>()
            {
                { "count", count.ToString() },
                { "date", ToDateString(MinDate(2023, 12, 27), dateTimeOffset) }
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
            var path = "maplestory/v1/history/starforce";
            var query = new Dictionary<string, string?>()
            {
                { "count", count.ToString() },
                { "cursor", cursor }
            };

            return await Get<StarforceHistoryResponseDTO>(path, query);
        }

        /// <summary>
        /// 큐브 사용 결과를 조회합니다.
        /// <para>데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.</para>
        /// <para>e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.</para>
        /// <para>2022년 11월 25일 데이터부터 조회할 수 있습니다.</para>
        /// </summary>
        /// <param name="count">한번에 가져오려는 결과의 개수(최소 10, 최대 1000)</param>
        public Task<CubeHistoryResponseDTO> GetCubeHistory(int count)
        {
            return GetCubeHistory(count, GetProperDefaultDateTimeOffset(new LatestApiUpdateTimeOption
            {
                Hour = 4,
                Minute = 0,
                DateOffset = 1
            }));
        }

        /// <summary>
        /// 지목한 날짜의 큐브 사용 결과를 조회합니다.
        /// <para>데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.</para>
        /// <para>e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.</para>
        /// <para>2022년 11월 25일 데이터부터 조회할 수 있습니다.</para>
        /// </summary>
        /// <param name="count">한번에 가져오려는 결과의 개수(최소 10, 최대 1000)</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<CubeHistoryResponseDTO> GetCubeHistory(int count, DateTimeOffset dateTimeOffset)
        {
            var path = "maplestory/v1/history/cube";
            var query = new Dictionary<string, string?>()
            {
                { "count", count.ToString() },
                { "date", ToDateString(MinDate(2022, 11, 25), dateTimeOffset) }
            };

            return await Get<CubeHistoryResponseDTO>(path, query);
        }

        /// <summary>
        /// 큐브 사용 결과를 조회합니다.
        /// <para>데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.</para>
        /// <para>e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.</para>
        /// <para>2022년 11월 25일 데이터부터 조회할 수 있습니다.</para>
        /// </summary>
        /// <param name="count">한번에 가져오려는 결과의 개수(최소 10, 최대 1000)</param>
        /// <param name="cursor">페이징 처리를 위한 cursor</param>
        public async Task<CubeHistoryResponseDTO> GetCubeHistory(int count, string cursor)
        {
            var path = "maplestory/v1/history/cube";
            var query = new Dictionary<string, string?>()
            {
                { "count", count.ToString() },
                { "cursor", cursor }
            };

            return await Get<CubeHistoryResponseDTO>(path, query);
        }

        /// <summary>
        /// 잠재능력 재설정 이용 결과를 조회합니다.
        /// <para>데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.</para>
        /// <para>e.g. 오늘 오후 3시 5분 잠재능력 재설정 정보 조회 시, 어제의 잠재능력 재설정 정보 데이터를 조회할 수 있습니다.</para>
        /// <para>2024년 1월 25일 데이터부터 조회할 수 있습니다.</para>
        /// </summary>
        /// <param name="count">한번에 가져오려는 결과의 개수(최소 10, 최대 1000)</param>
        public Task<PotentialHistoryResponseDTO> GetPotentialHistory(int count)
        {
            return GetPotentialHistory(count, GetProperDefaultDateTimeOffset(new LatestApiUpdateTimeOption
            {
                Hour = 4,
                Minute = 0,
                DateOffset = 1
            }));
        }

        /// <summary>
        /// 지목한 날짜의 잠재능력 재설정 이용 결과를 조회합니다.
        /// <para>데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.</para>
        /// <para>e.g. 오늘 오후 3시 5분 잠재능력 재설정 정보 조회 시, 어제의 잠재능력 재설정 정보 데이터를 조회할 수 있습니다.</para>
        /// <para>2024년 1월 25일 데이터부터 조회할 수 있습니다.</para>
        /// </summary>
        /// <param name="count">한번에 가져오려는 결과의 개수(최소 10, 최대 1000)</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<PotentialHistoryResponseDTO> GetPotentialHistory(int count, DateTimeOffset dateTimeOffset)
        {
            var path = "maplestory/v1/history/potential";
            var query = new Dictionary<string, string?>()
            {
                { "count", count.ToString() },
                { "date", ToDateString(MinDate(2024, 1, 25), dateTimeOffset) }
            };

            return await Get<PotentialHistoryResponseDTO>(path, query);
        }

        /// <summary>
        /// 잠재능력 재설정 이용 결과를 조회합니다.
        /// <para>데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.</para>
        /// <para>e.g. 오늘 오후 3시 5분 잠재능력 재설정 정보 조회 시, 어제의 잠재능력 재설정 정보 데이터를 조회할 수 있습니다.</para>
        /// <para>2024년 1월 25일 데이터부터 조회할 수 있습니다.</para>
        /// </summary>
        /// <param name="count">한번에 가져오려는 결과의 개수(최소 10, 최대 1000)</param>
        /// <param name="cursor">페이징 처리를 위한 cursor</param>
        public async Task<PotentialHistoryResponseDTO> GetPotentialHistory(int count, string cursor)
        {
            var path = "maplestory/v1/history/potential";
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
        /// <param name="worldName">월드 명
        /// <para>스카니아</para>
        /// <para>베라</para>
        /// <para>루나</para>
        /// <para>제니스</para>
        /// <para>크로아</para>
        /// <para>유니온</para>
        /// <para>엘리시움</para>
        /// <para>이노시스</para>
        /// <para>레드</para>
        /// <para>오로라</para>
        /// <para>아케인</para>
        /// <para>노바</para>
        /// <para>리부트</para>
        /// <para>리부트2</para>
        /// <para>버닝</para>
        /// <para>버닝2</para>
        /// <para>버닝3</para>
        /// </param>
        /// <param name="worldType">월드 타입 (0:일반, 1:리부트) (기본 값은 0이며, worldName 입력 시 미 반영)</param>
        /// <param name="characterClass">직업 및 전직
        /// <para>초보자-전체 전직</para>
        /// <para>전사-전체 전직</para>
        /// <para>전사-검사</para>
        /// <para>전사-파이터</para>
        /// <para>전사-페이지</para>
        /// <para>전사-스피어맨</para>
        /// <para>전사-크루세이더</para>
        /// <para>전사-나이트</para>
        /// <para>전사-버서커</para>
        /// <para>전사-히어로</para>
        /// <para>전사-팔라딘</para>
        /// <para>전사-다크나이트</para>
        /// <para>마법사-전체 전직</para>
        /// <para>마법사-매지션</para>
        /// <para>마법사-위자드(불,독)</para>
        /// <para>마법사-위자드(썬,콜)</para>
        /// <para>마법사-클레릭</para>
        /// <para>마법사-메이지(불,독)</para>
        /// <para>마법사-메이지(썬,콜)</para>
        /// <para>마법사-프리스트</para>
        /// <para>마법사-아크메이지(불,독)</para>
        /// <para>마법사-아크메이지(썬,콜)</para>
        /// <para>마법사-비숍</para>
        /// <para>궁수-전체 전직</para>
        /// <para>궁수-아처</para>
        /// <para>궁수-헌터</para>
        /// <para>궁수-사수</para>
        /// <para>궁수-레인저</para>
        /// <para>궁수-저격수</para>
        /// <para>궁수-보우마스터</para>
        /// <para>궁수-신궁</para>
        /// <para>궁수-아처(패스파인더)</para>
        /// <para>궁수-에인션트아처</para>
        /// <para>궁수-체이서</para>
        /// <para>궁수-패스파인더</para>
        /// <para>도적-전체 전직</para>
        /// <para>도적-로그</para>
        /// <para>도적-어쌔신</para>
        /// <para>도적-시프</para>
        /// <para>도적-허밋</para>
        /// <para>도적-시프마스터</para>
        /// <para>도적-나이트로드</para>
        /// <para>도적-섀도어</para>
        /// <para>도적-세미듀어러</para>
        /// <para>도적-듀어러</para>
        /// <para>도적-듀얼마스터</para>
        /// <para>도적-슬래셔</para>
        /// <para>도적-듀얼블레이더</para>
        /// <para>해적-전체 전직</para>
        /// <para>해적-해적</para>
        /// <para>해적-인파이터</para>
        /// <para>해적-건슬링거</para>
        /// <para>해적-캐논슈터</para>
        /// <para>해적-버커니어</para>
        /// <para>해적-발키리</para>
        /// <para>해적-캐논블래스터</para>
        /// <para>해적-바이퍼</para>
        /// <para>해적-캡틴</para>
        /// <para>해적-캐논마스터</para>
        /// <para>기사단-전체 전직</para>
        /// <para>기사단-노블레스</para>
        /// <para>기사단-소울마스터</para>
        /// <para>기사단-플레임위자드</para>
        /// <para>기사단-윈드브레이커</para>
        /// <para>기사단-나이트워커</para>
        /// <para>기사단-스트라이커</para>
        /// <para>기사단-미하일</para>
        /// <para>아란-전체 전직</para>
        /// <para>에반-전체 전직</para>
        /// <para>레지스탕스-전체 전직</para>
        /// <para>레지스탕스-시티즌</para>
        /// <para>레지스탕스-배틀메이지</para>
        /// <para>레지스탕스-와일드헌터</para>
        /// <para>레지스탕스-메카닉</para>
        /// <para>레지스탕스-데몬슬레이어</para>
        /// <para>레지스탕스-데몬어벤져</para>
        /// <para>레지스탕스-제논</para>
        /// <para>레지스탕스-블래스터</para>
        /// <para>메르세데스-전체 전직</para>
        /// <para>팬텀-전체 전직</para>
        /// <para>루미너스-전체 전직</para>
        /// <para>카이저-전체 전직</para>
        /// <para>엔젤릭버스터-전체 전직</para>
        /// <para>초월자-전체 전직</para>
        /// <para>초월자-제로</para>
        /// <para>은월-전체 전직</para>
        /// <para>프렌즈 월드-전체 전직</para>
        /// <para>프렌즈 월드-키네시스</para>
        /// <para>카데나-전체 전직</para>
        /// <para>일리움-전체 전직</para>
        /// <para>아크-전체 전직</para>
        /// <para>호영-전체 전직</para>
        /// <para>아델-전체 전직</para>
        /// <para>카인-전체 전직</para>
        /// <para>라라-전체 전직</para>
        /// <para>칼리-전체 전직</para>
        /// </param>
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
        /// <param name="worldName">월드 명
        /// <para>스카니아</para>
        /// <para>베라</para>
        /// <para>루나</para>
        /// <para>제니스</para>
        /// <para>크로아</para>
        /// <para>유니온</para>
        /// <para>엘리시움</para>
        /// <para>이노시스</para>
        /// <para>레드</para>
        /// <para>오로라</para>
        /// <para>아케인</para>
        /// <para>노바</para>
        /// <para>리부트</para>
        /// <para>리부트2</para>
        /// <para>버닝</para>
        /// <para>버닝2</para>
        /// <para>버닝3</para>
        /// </param>
        /// <param name="worldType">월드 타입 (0:일반, 1:리부트) (기본 값은 0이며, worldName 입력 시 미 반영)</param>
        /// <param name="characterClass">직업 및 전직
        /// <para>초보자-전체 전직</para>
        /// <para>전사-전체 전직</para>
        /// <para>전사-검사</para>
        /// <para>전사-파이터</para>
        /// <para>전사-페이지</para>
        /// <para>전사-스피어맨</para>
        /// <para>전사-크루세이더</para>
        /// <para>전사-나이트</para>
        /// <para>전사-버서커</para>
        /// <para>전사-히어로</para>
        /// <para>전사-팔라딘</para>
        /// <para>전사-다크나이트</para>
        /// <para>마법사-전체 전직</para>
        /// <para>마법사-매지션</para>
        /// <para>마법사-위자드(불,독)</para>
        /// <para>마법사-위자드(썬,콜)</para>
        /// <para>마법사-클레릭</para>
        /// <para>마법사-메이지(불,독)</para>
        /// <para>마법사-메이지(썬,콜)</para>
        /// <para>마법사-프리스트</para>
        /// <para>마법사-아크메이지(불,독)</para>
        /// <para>마법사-아크메이지(썬,콜)</para>
        /// <para>마법사-비숍</para>
        /// <para>궁수-전체 전직</para>
        /// <para>궁수-아처</para>
        /// <para>궁수-헌터</para>
        /// <para>궁수-사수</para>
        /// <para>궁수-레인저</para>
        /// <para>궁수-저격수</para>
        /// <para>궁수-보우마스터</para>
        /// <para>궁수-신궁</para>
        /// <para>궁수-아처(패스파인더)</para>
        /// <para>궁수-에인션트아처</para>
        /// <para>궁수-체이서</para>
        /// <para>궁수-패스파인더</para>
        /// <para>도적-전체 전직</para>
        /// <para>도적-로그</para>
        /// <para>도적-어쌔신</para>
        /// <para>도적-시프</para>
        /// <para>도적-허밋</para>
        /// <para>도적-시프마스터</para>
        /// <para>도적-나이트로드</para>
        /// <para>도적-섀도어</para>
        /// <para>도적-세미듀어러</para>
        /// <para>도적-듀어러</para>
        /// <para>도적-듀얼마스터</para>
        /// <para>도적-슬래셔</para>
        /// <para>도적-듀얼블레이더</para>
        /// <para>해적-전체 전직</para>
        /// <para>해적-해적</para>
        /// <para>해적-인파이터</para>
        /// <para>해적-건슬링거</para>
        /// <para>해적-캐논슈터</para>
        /// <para>해적-버커니어</para>
        /// <para>해적-발키리</para>
        /// <para>해적-캐논블래스터</para>
        /// <para>해적-바이퍼</para>
        /// <para>해적-캡틴</para>
        /// <para>해적-캐논마스터</para>
        /// <para>기사단-전체 전직</para>
        /// <para>기사단-노블레스</para>
        /// <para>기사단-소울마스터</para>
        /// <para>기사단-플레임위자드</para>
        /// <para>기사단-윈드브레이커</para>
        /// <para>기사단-나이트워커</para>
        /// <para>기사단-스트라이커</para>
        /// <para>기사단-미하일</para>
        /// <para>아란-전체 전직</para>
        /// <para>에반-전체 전직</para>
        /// <para>레지스탕스-전체 전직</para>
        /// <para>레지스탕스-시티즌</para>
        /// <para>레지스탕스-배틀메이지</para>
        /// <para>레지스탕스-와일드헌터</para>
        /// <para>레지스탕스-메카닉</para>
        /// <para>레지스탕스-데몬슬레이어</para>
        /// <para>레지스탕스-데몬어벤져</para>
        /// <para>레지스탕스-제논</para>
        /// <para>레지스탕스-블래스터</para>
        /// <para>메르세데스-전체 전직</para>
        /// <para>팬텀-전체 전직</para>
        /// <para>루미너스-전체 전직</para>
        /// <para>카이저-전체 전직</para>
        /// <para>엔젤릭버스터-전체 전직</para>
        /// <para>초월자-전체 전직</para>
        /// <para>초월자-제로</para>
        /// <para>은월-전체 전직</para>
        /// <para>프렌즈 월드-전체 전직</para>
        /// <para>프렌즈 월드-키네시스</para>
        /// <para>카데나-전체 전직</para>
        /// <para>일리움-전체 전직</para>
        /// <para>아크-전체 전직</para>
        /// <para>호영-전체 전직</para>
        /// <para>아델-전체 전직</para>
        /// <para>카인-전체 전직</para>
        /// <para>라라-전체 전직</para>
        /// <para>칼리-전체 전직</para>
        /// </param>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="page">페이지 번호</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<OverallRankingResponseDTO> GetOverallRanking(string? worldName, int? worldType, string? characterClass, string? ocid, int? page, DateTimeOffset dateTimeOffset)
        {
            var path = "maplestory/v1/ranking/overall";
            var query = new Dictionary<string, string?>()
            {
                { "date", ToDateString(MinDate(2023, 12, 22), dateTimeOffset) },
                { "ocid", ocid },
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
        /// <param name="worldName">월드 명
        /// <para>스카니아</para>
        /// <para>베라</para>
        /// <para>루나</para>
        /// <para>제니스</para>
        /// <para>크로아</para>
        /// <para>유니온</para>
        /// <para>엘리시움</para>
        /// <para>이노시스</para>
        /// <para>레드</para>
        /// <para>오로라</para>
        /// <para>아케인</para>
        /// <para>노바</para>
        /// <para>리부트</para>
        /// <para>리부트2</para>
        /// <para>버닝</para>
        /// <para>버닝2</para>
        /// <para>버닝3</para>
        /// </param>
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
        /// <param name="worldName">월드 명
        /// <para>스카니아</para>
        /// <para>베라</para>
        /// <para>루나</para>
        /// <para>제니스</para>
        /// <para>크로아</para>
        /// <para>유니온</para>
        /// <para>엘리시움</para>
        /// <para>이노시스</para>
        /// <para>레드</para>
        /// <para>오로라</para>
        /// <para>아케인</para>
        /// <para>노바</para>
        /// <para>리부트</para>
        /// <para>리부트2</para>
        /// <para>버닝</para>
        /// <para>버닝2</para>
        /// <para>버닝3</para>
        /// </param>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="page">페이지 번호</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<UnionRankingResponseDTO> GetUnionRanking(string? worldName, string? ocid, int? page, DateTimeOffset dateTimeOffset)
        {
            var path = "maplestory/v1/ranking/union";
            var query = new Dictionary<string, string?>()
            {
                { "date", ToDateString(MinDate(2023, 12, 22), dateTimeOffset) },
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
        /// <param name="worldName">월드 명
        /// <para>스카니아</para>
        /// <para>베라</para>
        /// <para>루나</para>
        /// <para>제니스</para>
        /// <para>크로아</para>
        /// <para>유니온</para>
        /// <para>엘리시움</para>
        /// <para>이노시스</para>
        /// <para>레드</para>
        /// <para>오로라</para>
        /// <para>아케인</para>
        /// <para>노바</para>
        /// <para>리부트</para>
        /// <para>리부트2</para>
        /// <para>버닝</para>
        /// <para>버닝2</para>
        /// <para>버닝3</para>
        /// </param>
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
        /// <param name="worldName">월드 명
        /// <para>스카니아</para>
        /// <para>베라</para>
        /// <para>루나</para>
        /// <para>제니스</para>
        /// <para>크로아</para>
        /// <para>유니온</para>
        /// <para>엘리시움</para>
        /// <para>이노시스</para>
        /// <para>레드</para>
        /// <para>오로라</para>
        /// <para>아케인</para>
        /// <para>노바</para>
        /// <para>리부트</para>
        /// <para>리부트2</para>
        /// <para>버닝</para>
        /// <para>버닝2</para>
        /// <para>버닝3</para>
        /// </param>
        /// <param name="rankingType">랭킹 타입 (0:주간 명성치, 1:플래그 레이스, 2:지하 수로)</param>
        /// <param name="guildName">길드 명</param>
        /// <param name="page">페이지 번호</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<GuildRankingResponseDTO> GetGuildRanking(string? worldName, int rankingType, string? guildName, int? page, DateTimeOffset dateTimeOffset)
        {
            var path = "maplestory/v1/ranking/guild";
            var query = new Dictionary<string, string?>()
            {
                { "date", ToDateString(MinDate(2023, 12, 22), dateTimeOffset) },
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
        /// <param name="worldName">월드 명
        /// <para>스카니아</para>
        /// <para>베라</para>
        /// <para>루나</para>
        /// <para>제니스</para>
        /// <para>크로아</para>
        /// <para>유니온</para>
        /// <para>엘리시움</para>
        /// <para>이노시스</para>
        /// <para>레드</para>
        /// <para>오로라</para>
        /// <para>아케인</para>
        /// <para>노바</para>
        /// <para>리부트</para>
        /// <para>리부트2</para>
        /// <para>버닝</para>
        /// <para>버닝2</para>
        /// <para>버닝3</para>
        /// </param>
        /// <param name="difficulty">구간 (0:일반, 1:통달)</param>
        /// <param name="characterClass">직업 및 전직
        /// <para>초보자-전체 전직</para>
        /// <para>전사-전체 전직</para>
        /// <para>전사-검사</para>
        /// <para>전사-파이터</para>
        /// <para>전사-페이지</para>
        /// <para>전사-스피어맨</para>
        /// <para>전사-크루세이더</para>
        /// <para>전사-나이트</para>
        /// <para>전사-버서커</para>
        /// <para>전사-히어로</para>
        /// <para>전사-팔라딘</para>
        /// <para>전사-다크나이트</para>
        /// <para>마법사-전체 전직</para>
        /// <para>마법사-매지션</para>
        /// <para>마법사-위자드(불,독)</para>
        /// <para>마법사-위자드(썬,콜)</para>
        /// <para>마법사-클레릭</para>
        /// <para>마법사-메이지(불,독)</para>
        /// <para>마법사-메이지(썬,콜)</para>
        /// <para>마법사-프리스트</para>
        /// <para>마법사-아크메이지(불,독)</para>
        /// <para>마법사-아크메이지(썬,콜)</para>
        /// <para>마법사-비숍</para>
        /// <para>궁수-전체 전직</para>
        /// <para>궁수-아처</para>
        /// <para>궁수-헌터</para>
        /// <para>궁수-사수</para>
        /// <para>궁수-레인저</para>
        /// <para>궁수-저격수</para>
        /// <para>궁수-보우마스터</para>
        /// <para>궁수-신궁</para>
        /// <para>궁수-아처(패스파인더)</para>
        /// <para>궁수-에인션트아처</para>
        /// <para>궁수-체이서</para>
        /// <para>궁수-패스파인더</para>
        /// <para>도적-전체 전직</para>
        /// <para>도적-로그</para>
        /// <para>도적-어쌔신</para>
        /// <para>도적-시프</para>
        /// <para>도적-허밋</para>
        /// <para>도적-시프마스터</para>
        /// <para>도적-나이트로드</para>
        /// <para>도적-섀도어</para>
        /// <para>도적-세미듀어러</para>
        /// <para>도적-듀어러</para>
        /// <para>도적-듀얼마스터</para>
        /// <para>도적-슬래셔</para>
        /// <para>도적-듀얼블레이더</para>
        /// <para>해적-전체 전직</para>
        /// <para>해적-해적</para>
        /// <para>해적-인파이터</para>
        /// <para>해적-건슬링거</para>
        /// <para>해적-캐논슈터</para>
        /// <para>해적-버커니어</para>
        /// <para>해적-발키리</para>
        /// <para>해적-캐논블래스터</para>
        /// <para>해적-바이퍼</para>
        /// <para>해적-캡틴</para>
        /// <para>해적-캐논마스터</para>
        /// <para>기사단-전체 전직</para>
        /// <para>기사단-노블레스</para>
        /// <para>기사단-소울마스터</para>
        /// <para>기사단-플레임위자드</para>
        /// <para>기사단-윈드브레이커</para>
        /// <para>기사단-나이트워커</para>
        /// <para>기사단-스트라이커</para>
        /// <para>기사단-미하일</para>
        /// <para>아란-전체 전직</para>
        /// <para>에반-전체 전직</para>
        /// <para>레지스탕스-전체 전직</para>
        /// <para>레지스탕스-시티즌</para>
        /// <para>레지스탕스-배틀메이지</para>
        /// <para>레지스탕스-와일드헌터</para>
        /// <para>레지스탕스-메카닉</para>
        /// <para>레지스탕스-데몬슬레이어</para>
        /// <para>레지스탕스-데몬어벤져</para>
        /// <para>레지스탕스-제논</para>
        /// <para>레지스탕스-블래스터</para>
        /// <para>메르세데스-전체 전직</para>
        /// <para>팬텀-전체 전직</para>
        /// <para>루미너스-전체 전직</para>
        /// <para>카이저-전체 전직</para>
        /// <para>엔젤릭버스터-전체 전직</para>
        /// <para>초월자-전체 전직</para>
        /// <para>초월자-제로</para>
        /// <para>은월-전체 전직</para>
        /// <para>프렌즈 월드-전체 전직</para>
        /// <para>프렌즈 월드-키네시스</para>
        /// <para>카데나-전체 전직</para>
        /// <para>일리움-전체 전직</para>
        /// <para>아크-전체 전직</para>
        /// <para>호영-전체 전직</para>
        /// <para>아델-전체 전직</para>
        /// <para>카인-전체 전직</para>
        /// <para>라라-전체 전직</para>
        /// <para>칼리-전체 전직</para>
        /// </param>
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
        /// <param name="worldName">월드 명
        /// <para>스카니아</para>
        /// <para>베라</para>
        /// <para>루나</para>
        /// <para>제니스</para>
        /// <para>크로아</para>
        /// <para>유니온</para>
        /// <para>엘리시움</para>
        /// <para>이노시스</para>
        /// <para>레드</para>
        /// <para>오로라</para>
        /// <para>아케인</para>
        /// <para>노바</para>
        /// <para>리부트</para>
        /// <para>리부트2</para>
        /// <para>버닝</para>
        /// <para>버닝2</para>
        /// <para>버닝3</para>
        /// </param>
        /// <param name="difficulty">구간 (0:일반, 1:통달)</param>
        /// <param name="characterClass">직업 및 전직
        /// <para>초보자-전체 전직</para>
        /// <para>전사-전체 전직</para>
        /// <para>전사-검사</para>
        /// <para>전사-파이터</para>
        /// <para>전사-페이지</para>
        /// <para>전사-스피어맨</para>
        /// <para>전사-크루세이더</para>
        /// <para>전사-나이트</para>
        /// <para>전사-버서커</para>
        /// <para>전사-히어로</para>
        /// <para>전사-팔라딘</para>
        /// <para>전사-다크나이트</para>
        /// <para>마법사-전체 전직</para>
        /// <para>마법사-매지션</para>
        /// <para>마법사-위자드(불,독)</para>
        /// <para>마법사-위자드(썬,콜)</para>
        /// <para>마법사-클레릭</para>
        /// <para>마법사-메이지(불,독)</para>
        /// <para>마법사-메이지(썬,콜)</para>
        /// <para>마법사-프리스트</para>
        /// <para>마법사-아크메이지(불,독)</para>
        /// <para>마법사-아크메이지(썬,콜)</para>
        /// <para>마법사-비숍</para>
        /// <para>궁수-전체 전직</para>
        /// <para>궁수-아처</para>
        /// <para>궁수-헌터</para>
        /// <para>궁수-사수</para>
        /// <para>궁수-레인저</para>
        /// <para>궁수-저격수</para>
        /// <para>궁수-보우마스터</para>
        /// <para>궁수-신궁</para>
        /// <para>궁수-아처(패스파인더)</para>
        /// <para>궁수-에인션트아처</para>
        /// <para>궁수-체이서</para>
        /// <para>궁수-패스파인더</para>
        /// <para>도적-전체 전직</para>
        /// <para>도적-로그</para>
        /// <para>도적-어쌔신</para>
        /// <para>도적-시프</para>
        /// <para>도적-허밋</para>
        /// <para>도적-시프마스터</para>
        /// <para>도적-나이트로드</para>
        /// <para>도적-섀도어</para>
        /// <para>도적-세미듀어러</para>
        /// <para>도적-듀어러</para>
        /// <para>도적-듀얼마스터</para>
        /// <para>도적-슬래셔</para>
        /// <para>도적-듀얼블레이더</para>
        /// <para>해적-전체 전직</para>
        /// <para>해적-해적</para>
        /// <para>해적-인파이터</para>
        /// <para>해적-건슬링거</para>
        /// <para>해적-캐논슈터</para>
        /// <para>해적-버커니어</para>
        /// <para>해적-발키리</para>
        /// <para>해적-캐논블래스터</para>
        /// <para>해적-바이퍼</para>
        /// <para>해적-캡틴</para>
        /// <para>해적-캐논마스터</para>
        /// <para>기사단-전체 전직</para>
        /// <para>기사단-노블레스</para>
        /// <para>기사단-소울마스터</para>
        /// <para>기사단-플레임위자드</para>
        /// <para>기사단-윈드브레이커</para>
        /// <para>기사단-나이트워커</para>
        /// <para>기사단-스트라이커</para>
        /// <para>기사단-미하일</para>
        /// <para>아란-전체 전직</para>
        /// <para>에반-전체 전직</para>
        /// <para>레지스탕스-전체 전직</para>
        /// <para>레지스탕스-시티즌</para>
        /// <para>레지스탕스-배틀메이지</para>
        /// <para>레지스탕스-와일드헌터</para>
        /// <para>레지스탕스-메카닉</para>
        /// <para>레지스탕스-데몬슬레이어</para>
        /// <para>레지스탕스-데몬어벤져</para>
        /// <para>레지스탕스-제논</para>
        /// <para>레지스탕스-블래스터</para>
        /// <para>메르세데스-전체 전직</para>
        /// <para>팬텀-전체 전직</para>
        /// <para>루미너스-전체 전직</para>
        /// <para>카이저-전체 전직</para>
        /// <para>엔젤릭버스터-전체 전직</para>
        /// <para>초월자-전체 전직</para>
        /// <para>초월자-제로</para>
        /// <para>은월-전체 전직</para>
        /// <para>프렌즈 월드-전체 전직</para>
        /// <para>프렌즈 월드-키네시스</para>
        /// <para>카데나-전체 전직</para>
        /// <para>일리움-전체 전직</para>
        /// <para>아크-전체 전직</para>
        /// <para>호영-전체 전직</para>
        /// <para>아델-전체 전직</para>
        /// <para>카인-전체 전직</para>
        /// <para>라라-전체 전직</para>
        /// <para>칼리-전체 전직</para>
        /// </param>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="page">페이지 번호</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<DojangRankingResponseDTO> GetDojangRanking(string? worldName, int difficulty, string? characterClass, string? ocid, int? page, DateTimeOffset dateTimeOffset)
        {
            var path = "maplestory/v1/ranking/dojang";
            var query = new Dictionary<string, string?>()
            {
                { "date", ToDateString(MinDate(2023, 12, 22), dateTimeOffset) },
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
        /// <param name="worldName">월드 명
        /// <para>스카니아</para>
        /// <para>베라</para>
        /// <para>루나</para>
        /// <para>제니스</para>
        /// <para>크로아</para>
        /// <para>유니온</para>
        /// <para>엘리시움</para>
        /// <para>이노시스</para>
        /// <para>레드</para>
        /// <para>오로라</para>
        /// <para>아케인</para>
        /// <para>노바</para>
        /// <para>리부트</para>
        /// <para>리부트2</para>
        /// <para>버닝</para>
        /// <para>버닝2</para>
        /// <para>버닝3</para>
        /// </param>
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
        /// <para>스카니아</para>
        /// <para>베라</para>
        /// <para>루나</para>
        /// <para>제니스</para>
        /// <para>크로아</para>
        /// <para>유니온</para>
        /// <para>엘리시움</para>
        /// <para>이노시스</para>
        /// <para>레드</para>
        /// <para>오로라</para>
        /// <para>아케인</para>
        /// <para>노바</para>
        /// <para>리부트</para>
        /// <para>리부트2</para>
        /// <para>버닝</para>
        /// <para>버닝2</para>
        /// <para>버닝3</para>
        /// </param>
        /// <param name="ocid">캐릭터 식별자</param>
        /// <param name="page">페이지 번호</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public async Task<TheSeedRankingResponseDTO> GetTheSeedRanking(string? worldName, string? ocid, int? page, DateTimeOffset dateTimeOffset)
        {
            var path = "maplestory/v1/ranking/theseed";
            var query = new Dictionary<string, string?>()
            {
                { "date", ToDateString(MinDate(2023, 12, 22), dateTimeOffset) },
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
            var path = "maplestory/v1/ranking/achievement";
            var query = new Dictionary<string, string?>()
            {
                { "date", ToDateString(MinDate(2023, 12, 22), dateTimeOffset) },
                { "ocid", ocid },
                { "page", page?.ToString() }
            };

            return await Get<AchievementRankingResponseDTO>(path, query);
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

            request.Timeout = this.timeOut;
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

        private void SetClient(HttpClient client)
        {
            client.Timeout = TimeSpan.FromMilliseconds(this.timeOut);
            client.DefaultRequestHeaders.Add("x-nxopen-api-key", this.apiKey);
        }

        private async Task<ResponseBody> Get<ResponseBody>(string path, Dictionary<string, string?>? query = null)
        {
            var request = new RestRequest(path);

            request.Timeout = this.timeOut;
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

            var response = await this.client.ExecuteGetAsync<ResponseBody>(request);

            if (response.IsSuccessStatusCode)
            {
                return response.Data!;
            }
            else
            {
                throw ParseError(response.Content!);
            }
        }


        private static DateTimeOffset MinDate(int year, int month, int day)
        {
            return new DateTimeOffset(year, month, day, 0, 0, 0, TimeSpan.FromHours(9));
        }

        /// <summary>
        /// API 서버의 데이터 갱신 시간에 따라 데이터를 조회 가능한 최신 날짜를 반환합니다.
        /// </summary>
        /// <param name="option"></param>
        private static DateTimeOffset GetProperDefaultDateTimeOffset(LatestApiUpdateTimeOption option)
        {
            var utcNow = DateTimeOffset.UtcNow;
            var kstNow = utcNow.ToOffset(TimeSpan.FromHours(9));

            var hour = option.Hour;
            var minute = option.Minute;
            var dateOffset = option.DateOffset;

            DateTimeOffset adjustedDateTimeOffset;

            if (kstNow > kstNow.Date.AddHours(hour).AddMinutes(minute))
            {
                adjustedDateTimeOffset = kstNow;
            }
            else
            {
                adjustedDateTimeOffset = kstNow.AddDays(-1);
            }

            return adjustedDateTimeOffset.AddDays(-dateOffset ?? 0);
        }

        /// <summary>
        /// 날짜 정보를 API 서버에서 요구하는 포맷으로 변환합니다.
        /// </summary>
        /// <param name="minDate">API 호출 가능한 최소 날짜</param>
        /// <param name="date">조회 하려는 날짜</param>
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

    struct LatestApiUpdateTimeOption
    {
        public int Hour { get; set; }

        public int Minute { get; set; }

        public int? DateOffset { get; set; }
    }
}