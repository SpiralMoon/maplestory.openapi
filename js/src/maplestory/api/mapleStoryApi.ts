import axios, { Axios, AxiosError } from 'axios';
import dayjs, { Dayjs } from 'dayjs';
import timezone from 'dayjs/plugin/timezone';
import utc from 'dayjs/plugin/utc';
import xml2js from 'xml2js';

import { CharacterAbilityDto } from './dto/character/characterAbilityDto';
import { CharacterAndroidEquipmentDto } from './dto/character/characterAndroidEquipmentDto';
import { CharacterBasicDto } from './dto/character/characterBasicDto';
import { CharacterBeautyEquipmentDto } from './dto/character/characterBeautyEquipmentDto';
import { CharacterCashItemEquipmentDto } from './dto/character/characterCashItemEquipmentDto';
import { CharacterDojangDto } from './dto/character/characterDojangDto';
import { CharacterDto } from './dto/character/characterDto';
import { CharacterHexaMatrixDto } from './dto/character/characterHexaMatrixDto';
import { CharacterHexaMatrixStatDto } from './dto/character/characterHexaMatrixStatDto';
import { CharacterHyperStatDto } from './dto/character/characterHyperStatDto';
import { CharacterItemEquipmentDto } from './dto/character/characterItemEquipmentDto';
import { CharacterLinkSkillDto } from './dto/character/characterLinkSkillDto';
import { CharacterPetEquipmentDto } from './dto/character/characterPetEquipmentDto';
import { CharacterPopularityDto } from './dto/character/characterPopularityDto';
import { CharacterPropensityDto } from './dto/character/characterPropensityDto';
import { CharacterSetEffectDto } from './dto/character/characterSetEffectDto';
import { CharacterSkillDto } from './dto/character/characterSkillDto';
import { CharacterStatDto } from './dto/character/characterStatDto';
import { CharacterSymbolEquipmentDto } from './dto/character/characterSymbolEquipmentDto';
import { CharacterVMatrixDto } from './dto/character/characterVMatrixDto';
import { GuildBasicDto } from './dto/guild/guildBasicDto';
import { GuildDto } from './dto/guild/guildDto';
import { CubeHistoryResponseDto } from './dto/history/cubeHistoryResponseDto';
import { PotentialHistoryResponseDto } from './dto/history/potentialHistoryResponseDto';
import { StarforceHistoryResponseDto } from './dto/history/starforceHistoryResponseDto';
import { InspectionInfoDto } from './dto/inspectionInfoDto';
import { AchievementRankingResponseDto } from './dto/ranking/achievementRankingResponseDto';
import { DojangRankingResponseDto } from './dto/ranking/dojangRankingResponseDto';
import { GuildRankingResponseDto } from './dto/ranking/guildRankingResponseDto';
import { OverallRankingResponseDto } from './dto/ranking/overallRankingResponseDto';
import { TheSeedRankingResponseDto } from './dto/ranking/theSeedRankingResponseDto';
import { UnionRankingResponseDto } from './dto/ranking/unionRankingResponseDto';
import { UnionArtifactDto } from './dto/union/unionArtifactDto';
import { UnionDto } from './dto/union/unionDto';
import { UnionRaiderDto } from './dto/union/unionRaiderDto';
import { MapleStoryApiError } from './mapleStoryApiError';
import { CharacterAbilityDtoBody } from './response/character/characterAbilityDtoBody';
import { CharacterAndroidEquipmentDtoBody } from './response/character/characterAndroidEquipmentDtoBody';
import { CharacterBasicDtoBody } from './response/character/characterBasicDtoBody';
import { CharacterBeautyEquipmentDtoBody } from './response/character/characterBeautyEquipmentDtoBody';
import { CharacterCashItemEquipmentDtoBody } from './response/character/characterCashItemEquipmentDtoBody';
import { CharacterDojangDtoBody } from './response/character/characterDojangDtoBody';
import { CharacterDtoBody } from './response/character/characterDtoBody';
import { CharacterHexaMatrixDtoBody } from './response/character/characterHexaMatrixDtoBody';
import { CharacterHexaMatrixStatDtoBody } from './response/character/characterHexaMatrixStatDtoBody';
import { CharacterHyperStatDtoBody } from './response/character/characterHyperStatDtoBody';
import { CharacterItemEquipmentDtoBody } from './response/character/characterItemEquipmentDtoBody';
import { CharacterLinkSkillDtoBody } from './response/character/characterLinkSkillDtoBody';
import { CharacterPetEquipmentDtoBody } from './response/character/characterPetEquipmentDtoBody';
import { CharacterPopularityDtoBody } from './response/character/characterPopularityDtoBody';
import { CharacterPropensityDtoBody } from './response/character/characterPropensityDtoBody';
import { CharacterSetEffectDtoBody } from './response/character/characterSetEffectDtoBody';
import { CharacterSkillDtoBody } from './response/character/characterSkillDtoBody';
import { CharacterStatDtoBody } from './response/character/characterStatDtoBody';
import { CharacterSymbolEquipmentDtoBody } from './response/character/characterSymbolEquipmentDtoBody';
import { CharacterVMatrixDtoBody } from './response/character/characterVMatrixDtoBody';
import { GuildBasicDtoBody } from './response/guild/guildBasicDtoBody';
import { GuildDtoBody } from './response/guild/guildDtoBody';
import { CubeHistoryResponseDtoBody } from './response/history/cubeHistoryResponseDtoBody';
import { PotentialHistoryResponseDtoBody } from './response/history/potentialHistoryResponseDtoBody';
import { StarforceHistoryResponseDtoBody } from './response/history/starforceHistoryResponseDtoBody';
import { InspectionInfoSoapBody } from './response/inspectionInfoSoapBody';
import { AchievementRankingResponseDtoBody } from './response/ranking/achievementRankingResponseDtoBody';
import { DojangRankingResponseDtoBody } from './response/ranking/dojangRankingResponseDtoBody';
import { GuildRankingResponseDtoBody } from './response/ranking/guildRankingResponseDtoBody';
import { OverallRankingResponseDtoBody } from './response/ranking/overallRankingResponseDtoBody';
import { TheSeedRankingResponseDtoBody } from './response/ranking/theSeedRankingResponseDtoBody';
import { UnionRankingResponseDtoBody } from './response/ranking/unionRankingResponseDtoBody';
import { UnionArtifactDtoBody } from './response/union/unionArtifactDtoBody';
import { UnionDtoBody } from './response/union/unionDtoBody';
import { UnionRaiderDtoBody } from './response/union/unionRaiderDtoBody';

dayjs.extend(timezone);
dayjs.extend(utc);

/**
 * MapleStory OpenAPI client.<br>
 * This is an implementation of <a href="https://openapi.nexon.com/game/maplestory">MapleStory API</a>
 */
class MapleStoryApi {
  private readonly apiKey: string;

  private readonly client: Axios;

  private static readonly BASE_URL: string = 'https://open.api.nexon.com/';

  private static readonly DEFAULT_TIMEOUT: number = 5000;

  private static readonly kstOffset: number = 540;

  get timeout() {
    return this.client.defaults.timeout!;
  }

  set timeout(value: number) {
    this.client.defaults.timeout = value;
  }

  public constructor(apiKey: string) {
    this.apiKey = apiKey;
    this.client = axios.create({
      baseURL: MapleStoryApi.BASE_URL,
      timeout: MapleStoryApi.DEFAULT_TIMEOUT,
      headers: {
        'x-nxopen-api-key': this.apiKey,
      },
    });
    this.client.interceptors.response.use(
      (response) => response,
      (error) => {

        if (error instanceof AxiosError) {
          const errorBody = (error as AxiosError<MapleStoryErrorBody>).response!.data;

          throw new MapleStoryApiError(errorBody);
        }

        throw  error;
      });
  }

  //#region 캐릭터 정보 조회

  /**
   * 캐릭터 식별자(ocid)를 조회합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param characterName    캐릭터 명
   */
  public async getCharacter(characterName: string): Promise<CharacterDto> {
    const path = 'maplestory/v1/id';
    const { data } = await this.client.get<CharacterDtoBody>(path, {
      params: {
        character_name: characterName,
      },
    });

    return new CharacterDto(data);
  }

  /**
   * 기본 정보를 조회합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterBasic(
    ocid: string,
    dateOptions: DateOptions = MapleStoryApi.getProperDefaultDateOptions({
      hour: 1,
      minute: 0,
      dateOffset: 1,
    }),
  ): Promise<CharacterBasicDto> {
    const path = 'maplestory/v1/character/basic';
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: MapleStoryApi.toDateString(
        {
          year: 2023,
          month: 12,
          day: 21,
        },
        dateOptions,
      ),
    };
    const { data } = await this.client.get<CharacterBasicDtoBody>(path, {
      params: query,
    });

    return new CharacterBasicDto(data);
  }

  /**
   * 인기도 정보를 조회합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterPopularity(
    ocid: string,
    dateOptions: DateOptions = MapleStoryApi.getProperDefaultDateOptions({
      hour: 1,
      minute: 0,
      dateOffset: 1,
    }),
  ): Promise<CharacterPopularityDto> {
    const path = 'maplestory/v1/character/popularity';
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: MapleStoryApi.toDateString(
        {
          year: 2023,
          month: 12,
          day: 21,
        },
        dateOptions,
      ),
    };
    const { data } = await this.client.get<CharacterPopularityDtoBody>(path, {
      params: query,
    });

    return new CharacterPopularityDto(data);
  }

  /**
   * 종합 능력치 정보를 조회합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterStat(
    ocid: string,
    dateOptions: DateOptions = MapleStoryApi.getProperDefaultDateOptions({
      hour: 1,
      minute: 0,
      dateOffset: 1,
    }),
  ): Promise<CharacterStatDto> {
    const path = 'maplestory/v1/character/stat';
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: MapleStoryApi.toDateString(
        {
          year: 2023,
          month: 12,
          day: 21,
        },
        dateOptions,
      ),
    };
    const { data } = await this.client.get<CharacterStatDtoBody>(path, {
      params: query,
    });

    return new CharacterStatDto(data);
  }

  /**
   * 하이퍼스탯 정보를 조회합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterHyperStat(
    ocid: string,
    dateOptions: DateOptions = MapleStoryApi.getProperDefaultDateOptions({
      hour: 1,
      minute: 0,
      dateOffset: 1,
    }),
  ): Promise<CharacterHyperStatDto> {
    const path = 'maplestory/v1/character/hyper-stat';
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: MapleStoryApi.toDateString(
        {
          year: 2023,
          month: 12,
          day: 21,
        },
        dateOptions,
      ),
    };
    const { data } = await this.client.get<CharacterHyperStatDtoBody>(path, {
      params: query,
    });

    return new CharacterHyperStatDto(data);
  }

  /**
   * 성향 정보를 조회합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterPropensity(
    ocid: string,
    dateOptions: DateOptions = MapleStoryApi.getProperDefaultDateOptions({
      hour: 1,
      minute: 0,
      dateOffset: 1,
    }),
  ): Promise<CharacterPropensityDto> {
    const path = 'maplestory/v1/character/propensity';
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: MapleStoryApi.toDateString(
        {
          year: 2023,
          month: 12,
          day: 21,
        },
        dateOptions,
      ),
    };
    const { data } = await this.client.get<CharacterPropensityDtoBody>(path, {
      params: query,
    });

    return new CharacterPropensityDto(data);
  }

  /**
   * 어빌리티 정보를 조회합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterAbility(
    ocid: string,
    dateOptions: DateOptions = MapleStoryApi.getProperDefaultDateOptions({
      hour: 1,
      minute: 0,
      dateOffset: 1,
    }),
  ): Promise<CharacterAbilityDto> {
    const path = 'maplestory/v1/character/ability';
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: MapleStoryApi.toDateString(
        {
          year: 2023,
          month: 12,
          day: 21,
        },
        dateOptions,
      ),
    };
    const { data } = await this.client.get<CharacterAbilityDtoBody>(path, {
      params: query,
    });

    return new CharacterAbilityDto(data);
  }

  /**
   * 장착한 장비 중 캐시 장비를 제외한 나머지 장비 정보를 조회합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterItemEquipment(
    ocid: string,
    dateOptions: DateOptions = MapleStoryApi.getProperDefaultDateOptions({
      hour: 1,
      minute: 0,
      dateOffset: 1,
    }),
  ): Promise<CharacterItemEquipmentDto> {
    const path = 'maplestory/v1/character/item-equipment';
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: MapleStoryApi.toDateString(
        {
          year: 2023,
          month: 12,
          day: 21,
        },
        dateOptions,
      ),
    };
    const { data } = await this.client.get<CharacterItemEquipmentDtoBody>(path, {
      params: query,
    });

    return new CharacterItemEquipmentDto(data);
  }

  /**
   * 장착한 캐시 장비 정보를 조회합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterCashItemEquipment(
    ocid: string,
    dateOptions: DateOptions = MapleStoryApi.getProperDefaultDateOptions({
      hour: 1,
      minute: 0,
      dateOffset: 1,
    }),
  ): Promise<CharacterCashItemEquipmentDto> {
    const path = 'maplestory/v1/character/cashitem-equipment';
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: MapleStoryApi.toDateString(
        {
          year: 2023,
          month: 12,
          day: 21,
        },
        dateOptions,
      ),
    };
    const { data } = await this.client.get<CharacterCashItemEquipmentDtoBody>(
      path,
      {
        params: query,
      },
    );

    return new CharacterCashItemEquipmentDto(data);
  }

  /**
   * 장착한 심볼 정보를 조회합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterSymbolEquipment(
    ocid: string,
    dateOptions: DateOptions = MapleStoryApi.getProperDefaultDateOptions({
      hour: 1,
      minute: 0,
      dateOffset: 1,
    }),
  ): Promise<CharacterSymbolEquipmentDto> {
    const path = 'maplestory/v1/character/symbol-equipment';
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: MapleStoryApi.toDateString(
        {
          year: 2023,
          month: 12,
          day: 21,
        },
        dateOptions,
      ),
    };
    const { data } = await this.client.get<CharacterSymbolEquipmentDtoBody>(path, {
      params: query,
    });

    return new CharacterSymbolEquipmentDto(data);
  }

  /**
   * 적용받고 있는 세트 효과 정보를 조회합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterSetEffect(
    ocid: string,
    dateOptions: DateOptions = MapleStoryApi.getProperDefaultDateOptions({
      hour: 1,
      minute: 0,
      dateOffset: 1,
    }),
  ): Promise<CharacterSetEffectDto> {
    const path = 'maplestory/v1/character/set-effect';
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: MapleStoryApi.toDateString(
        {
          year: 2023,
          month: 12,
          day: 21,
        },
        dateOptions,
      ),
    };
    const { data } = await this.client.get<CharacterSetEffectDtoBody>(path, {
      params: query,
    });

    return new CharacterSetEffectDto(data);
  }

  /**
   * 장착 중인 헤어, 성형, 피부 정보를 조회합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterBeautyEquipment(
    ocid: string,
    dateOptions: DateOptions = MapleStoryApi.getProperDefaultDateOptions({
      hour: 1,
      minute: 0,
      dateOffset: 1,
    }),
  ): Promise<CharacterBeautyEquipmentDto> {
    const path = 'maplestory/v1/character/beauty-equipment';
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: MapleStoryApi.toDateString(
        {
          year: 2023,
          month: 12,
          day: 21,
        },
        dateOptions,
      ),
    };
    const { data } = await this.client.get<CharacterBeautyEquipmentDtoBody>(path, {
      params: query,
    });

    return new CharacterBeautyEquipmentDto(data);
  }

  /**
   * 장착한 안드로이드 정보를 조회합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterAndroidEquipment(
    ocid: string,
    dateOptions: DateOptions = MapleStoryApi.getProperDefaultDateOptions({
      hour: 1,
      minute: 0,
      dateOffset: 1,
    }),
  ): Promise<CharacterAndroidEquipmentDto> {
    const path = 'maplestory/v1/character/android-equipment';
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: MapleStoryApi.toDateString(
        {
          year: 2023,
          month: 12,
          day: 21,
        },
        dateOptions,
      ),
    };
    const { data } = await this.client.get<CharacterAndroidEquipmentDtoBody>(path, {
      params: query,
    });

    return new CharacterAndroidEquipmentDto(data);
  }

  /**
   * 장착한 펫 및 펫 스킬, 장비 정보를 조회합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterPetEquipment(
    ocid: string,
    dateOptions: DateOptions = MapleStoryApi.getProperDefaultDateOptions({
      hour: 1,
      minute: 0,
      dateOffset: 1,
    }),
  ): Promise<CharacterPetEquipmentDto> {
    const path = 'maplestory/v1/character/pet-equipment';
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: MapleStoryApi.toDateString(
        {
          year: 2023,
          month: 12,
          day: 21,
        },
        dateOptions,
      ),
    };
    const { data } = await this.client.get<CharacterPetEquipmentDtoBody>(path, {
      params: query,
    });

    return new CharacterPetEquipmentDto(data);
  }

  /**
   * 캐릭터 스킬과 하이퍼 스킬 정보를 조회합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param characterSkillGrade 조회하고자 하는 전직 차수
   *  - 0: 0차 스킬 및 제로 공용스킬
   *  - 1: 1차 스킬
   *  - 1.5: 1.5차 스킬
   *  - 2: 2차 스킬
   *  - 2.5: 2.5차 스킬
   *  - 3: 3차 스킬
   *  - 4: 4차 스킬 및 제로 알파/베타 스킬
   *  - hyperpassive: 하이퍼 패시브 스킬
   *  - hyperactive: 하이퍼 액티브 스킬
   *  - 5: 5차 스킬
   *  - 6: 6차 스킬
   *  @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterSkill(
    ocid: string,
    characterSkillGrade: string,
    dateOptions: DateOptions = MapleStoryApi.getProperDefaultDateOptions({
      hour: 1,
      minute: 0,
      dateOffset: 1,
    }),
  ): Promise<CharacterSkillDto> {
    const path = 'maplestory/v1/character/skill';
    const query: CharacterSkillApiQuery = {
      ocid: ocid,
      character_skill_grade: characterSkillGrade,
      date: MapleStoryApi.toDateString(
        {
          year: 2023,
          month: 12,
          day: 21,
        },
        dateOptions,
      ),
    };
    const { data } = await this.client.get<CharacterSkillDtoBody>(path, {
      params: query,
    });

    return new CharacterSkillDto(data);
  }

  /**
   * 장착 링크 스킬 정보를 조회합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterLinkSkill(
    ocid: string,
    dateOptions: DateOptions = MapleStoryApi.getProperDefaultDateOptions({
      hour: 1,
      minute: 0,
      dateOffset: 1,
    }),
  ): Promise<CharacterLinkSkillDto> {
    const path = 'maplestory/v1/character/link-skill';
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: MapleStoryApi.toDateString(
        {
          year: 2023,
          month: 12,
          day: 21,
        },
        dateOptions,
      ),
    };
    const { data } = await this.client.get<CharacterLinkSkillDtoBody>(path, {
      params: query,
    });

    return new CharacterLinkSkillDto(data);
  }

  /**
   * V매트릭스 슬롯 정보와 장착한 V코어 정보를 조회합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterVMatrix(
    ocid: string,
    dateOptions: DateOptions = MapleStoryApi.getProperDefaultDateOptions({
      hour: 1,
      minute: 0,
      dateOffset: 1,
    }),
  ): Promise<CharacterVMatrixDto> {
    const path = 'maplestory/v1/character/vmatrix';
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: MapleStoryApi.toDateString(
        {
          year: 2023,
          month: 12,
          day: 21,
        },
        dateOptions,
      ),
    };
    const { data } = await this.client.get<CharacterVMatrixDtoBody>(path, {
      params: query,
    });

    return new CharacterVMatrixDto(data);
  }

  /**
   * HEXA 매트릭스에 장착한 HEXA 코어 정보를 조회합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterHexaMatrix(
    ocid: string,
    dateOptions: DateOptions = MapleStoryApi.getProperDefaultDateOptions({
      hour: 1,
      minute: 0,
      dateOffset: 1,
    }),
  ): Promise<CharacterHexaMatrixDto> {
    const path = 'maplestory/v1/character/hexamatrix';
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: MapleStoryApi.toDateString(
        {
          year: 2023,
          month: 12,
          day: 21,
        },
        dateOptions,
      ),
    };
    const { data } = await this.client.get<CharacterHexaMatrixDtoBody>(path, {
      params: query,
    });

    return new CharacterHexaMatrixDto(data);
  }

  /**
   * HEXA 매트릭스에 설정한 HEXA 스탯 정보를 조회합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterHexaMatrixStat(
    ocid: string,
    dateOptions: DateOptions = MapleStoryApi.getProperDefaultDateOptions({
      hour: 1,
      minute: 0,
      dateOffset: 1,
    }),
  ): Promise<CharacterHexaMatrixStatDto> {
    const path = 'maplestory/v1/character/hexamatrix-stat';
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: MapleStoryApi.toDateString(
        {
          year: 2023,
          month: 12,
          day: 21,
        },
        dateOptions,
      ),
    };
    const { data } = await this.client.get<CharacterHexaMatrixStatDtoBody>(path, {
      params: query,
    });

    return new CharacterHexaMatrixStatDto(data);
  }

  /**
   * 캐릭터 무릉도장 최고 기록 정보를 조회합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterDojang(
    ocid: string,
    dateOptions: DateOptions = MapleStoryApi.getProperDefaultDateOptions({
      hour: 1,
      minute: 0,
      dateOffset: 1,
    }),
  ): Promise<CharacterDojangDto> {
    const path = 'maplestory/v1/character/dojang';
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: MapleStoryApi.toDateString(
        {
          year: 2023,
          month: 12,
          day: 21,
        },
        dateOptions,
      ),
    };
    const { data } = await this.client.get<CharacterDojangDtoBody>(path, {
      params: query,
    });

    return new CharacterDojangDto(data);
  }

  //#endregion

  //#region 유니온 정보 조회

  /**
   * 유니온 정보를 조회합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 유니온 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getUnion(
    ocid: string,
    dateOptions: DateOptions = MapleStoryApi.getProperDefaultDateOptions({
      hour: 1,
      minute: 0,
      dateOffset: 1,
    }),
  ): Promise<UnionDto> {
    const path = 'maplestory/v1/user/union';
    const query: UnionApiQuery = {
      ocid: ocid,
      date: MapleStoryApi.toDateString(
        {
          year: 2023,
          month: 12,
          day: 21,
        },
        dateOptions,
      ),
    };
    const { data } = await this.client.get<UnionDtoBody>(path, {
      params: query,
    });

    return new UnionDto(data);
  }

  /**
   * 유니온 공격대 정보를 조회합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 유니온 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getUnionRaider(
    ocid: string,
    dateOptions: DateOptions = MapleStoryApi.getProperDefaultDateOptions({
      hour: 1,
      minute: 0,
      dateOffset: 1,
    }),
  ): Promise<UnionRaiderDto> {
    const path = 'maplestory/v1/user/union-raider';
    const query: UnionApiQuery = {
      ocid: ocid,
      date: MapleStoryApi.toDateString(
        {
          year: 2023,
          month: 12,
          day: 21,
        },
        dateOptions,
      ),
    };
    const { data } = await this.client.get<UnionRaiderDtoBody>(path, {
      params: query,
    });

    return new UnionRaiderDto(data);
  }

  /**
   * 유니온 아티팩트 정보를 조회합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 유니온 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getUnionArtifact(
    ocid: string,
    dateOptions: DateOptions = MapleStoryApi.getProperDefaultDateOptions({
      hour: 1,
      minute: 0,
      dateOffset: 1,
    }),
  ): Promise<UnionArtifactDto> {
    const path = 'maplestory/v1/user/union-artifact';
    const query: UnionApiQuery = {
      ocid: ocid,
      date: MapleStoryApi.toDateString(
        {
          year: 2023,
          month: 12,
          day: 21,
        },
        dateOptions,
      ),
    };
    const { data } = await this.client.get<UnionArtifactDtoBody>(path, {
      params: query,
    });

    return new UnionArtifactDto(data);
  }

  //#endregion

  //#region 길드 정보 조회

  /**
   * 길드 식별자(oguild_id) 정보를 조회합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 길드 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.).
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param guildName 길드 명
   * @param worldName 월드 명
   */
  public async getGuild(
    guildName: string,
    worldName: string,
  ): Promise<GuildDto> {
    const path = 'maplestory/v1/guild/id';
    const { data } = await this.client.get<GuildDtoBody>(path, {
      params: {
        guild_name: guildName,
        world_name: worldName,
      },
    });

    return new GuildDto(data);
  }

  /**
   * 길드 기본 정보를 조회합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 길드 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.).
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param guildId 길드 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getGuildBasic(
    guildId: string,
    dateOptions: DateOptions = MapleStoryApi.getProperDefaultDateOptions({
      hour: 1,
      minute: 0,
      dateOffset: 1,
    }),
  ): Promise<GuildBasicDto> {
    const path = 'maplestory/v1/guild/basic';
    const query: GuildApiQuery = {
      oguild_id: guildId,
      date: MapleStoryApi.toDateString(
        {
          year: 2023,
          month: 12,
          day: 21,
        },
        dateOptions,
      ),
    };
    const { data } = await this.client.get<GuildBasicDtoBody>(path, {
      params: query,
    });

    return new GuildBasicDto(data);
  }

  //#endregion

  //#region 확률 정보 조회

  /**
   * 스타포스 강화 결과를 조회합니다.
   * - 스타포스 확률 정보는 최대 5분 후 확인 가능합니다.
   * - 2023년 12월 27일 데이터부터 조회할 수 있습니다.
   *
   * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
   */
  public async getStarforceHistory(
    count: number,
  ): Promise<StarforceHistoryResponseDto>;

  /**
   * 지목한 날짜의 스타포스 강화 결과를 조회합니다.
   * - 스타포스 확률 정보는 최대 5분 후 확인 가능합니다.
   * - 2023년 12월 27일 데이터부터 조회할 수 있습니다.
   *
   * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getStarforceHistory(
    count: number,
    dateOptions: DateOptions,
  ): Promise<StarforceHistoryResponseDto>;

  /**
   * 스타포스 강화 결과를 조회합니다.
   * - 스타포스 확률 정보는 최대 5분 후 확인 가능합니다.
   * - 2023년 12월 27일 데이터부터 조회할 수 있습니다.
   *
   * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
   * @param cursor 페이징 처리를 위한 cursor
   */
  public async getStarforceHistory(
    count: number,
    cursor: string,
  ): Promise<StarforceHistoryResponseDto>;

  public async getStarforceHistory(
    count: number,
    parameter?: DateOptions | string,
  ): Promise<StarforceHistoryResponseDto> {
    const path = 'maplestory/v1/history/starforce';
    const query: StarforceApiQuery = {
      count,
    };

    if (typeof parameter === 'string') {
      query.cursor = parameter;
    } else if (typeof parameter === 'object') {
      query.date = MapleStoryApi.toDateString(
        {
          year: 2023,
          month: 12,
          day: 27,
        },
        parameter ??
          MapleStoryApi.getProperDefaultDateOptions({
            hour: 0,
            minute: 0,
            dateOffset: 0,
          }),
      );
    }

    const { data } = await this.client.get<StarforceHistoryResponseDtoBody>(path, {
      params: query,
    });

    return new StarforceHistoryResponseDto(data);
  }

  /**
   * 큐브 사용 결과를 조회합니다.
   * - 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.
   * - e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.
   * - 2022년 11월 25일 데이터부터 조회할 수 있습니다.
   *
   * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
   */
  public async getCubeHistory(count: number): Promise<CubeHistoryResponseDto>;

  /**
   * 지목한 날짜의 큐브 사용 결과를 조회합니다.
   * - 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.
   * - e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.
   * - 2022년 11월 25일 데이터부터 조회할 수 있습니다.
   *
   * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCubeHistory(
    count: number,
    dateOptions: DateOptions,
  ): Promise<CubeHistoryResponseDto>;

  /**
   * 큐브 사용 결과를 조회합니다.
   * - 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.
   * - e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.
   * - 2022년 11월 25일 데이터부터 조회할 수 있습니다.
   *
   * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
   * @param cursor 페이징 처리를 위한 cursor
   */
  public async getCubeHistory(
    count: number,
    cursor: string,
  ): Promise<CubeHistoryResponseDto>;

  public async getCubeHistory(
    count: number,
    parameter?: DateOptions | string,
  ): Promise<CubeHistoryResponseDto> {
    const path = 'maplestory/v1/history/cube';
    const query: CubeApiQuery = {
      count,
    };

    if (typeof parameter === 'string') {
      query.cursor = parameter;
    } else if (typeof parameter === 'object' || parameter === undefined) {
      query.date = MapleStoryApi.toDateString(
        {
          year: 2022,
          month: 11,
          day: 25,
        },
        parameter ??
          MapleStoryApi.getProperDefaultDateOptions({
            hour: 4,
            minute: 0,
            dateOffset: 1,
          }),
      );
    }

    const { data } = await this.client.get<CubeHistoryResponseDtoBody>(path, {
      params: query,
    });

    return new CubeHistoryResponseDto(data);
  }

  /**
   * 잠재능력 재설정 이용 결과를 조회합니다.
   * - 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.
   * - e.g. 오늘 오후 3시 5분 잠재능력 재설정 정보 조회 시, 어제의 잠재능력 재설정 정보 데이터를 조회할 수 있습니다.
   * - 2024년 1월 25일 데이터부터 조회할 수 있습니다.
   *
   * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
   */
  public async getPotentialHistory(
    count: number,
  ): Promise<PotentialHistoryResponseDto>;

  /**
   * 지목한 날짜의 잠재능력 재설정 이용 결과를 조회합니다.
   * - 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.
   * - e.g. 오늘 오후 3시 5분 잠재능력 재설정 정보 조회 시, 어제의 잠재능력 재설정 정보 데이터를 조회할 수 있습니다.
   * - 2024년 1월 25일 데이터부터 조회할 수 있습니다.
   *
   * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getPotentialHistory(
    count: number,
    dateOptions: DateOptions,
  ): Promise<PotentialHistoryResponseDto>;

  /**
   * 잠재능력 재설정 이용 결과를 조회합니다.
   * - 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.
   * - e.g. 오늘 오후 3시 5분 잠재능력 재설정 정보 조회 시, 어제의 잠재능력 재설정 정보 데이터를 조회할 수 있습니다.
   * - 2024년 1월 25일 데이터부터 조회할 수 있습니다.
   *
   * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
   * @param cursor 페이징 처리를 위한 cursor
   */
  public async getPotentialHistory(
    count: number,
    cursor: string,
  ): Promise<PotentialHistoryResponseDto>;

  public async getPotentialHistory(
    count: number,
    parameter?: DateOptions | string,
  ): Promise<PotentialHistoryResponseDto> {
    const path = 'maplestory/v1/history/potential';
    const query: PotentialApiQuery = {
      count,
    };

    if (typeof parameter === 'string') {
      query.cursor = parameter;
    } else if (typeof parameter === 'object' || parameter === undefined) {
      query.date = MapleStoryApi.toDateString(
        {
          year: 2024,
          month: 1,
          day: 25,
        },
        parameter ??
          MapleStoryApi.getProperDefaultDateOptions({
            hour: 4,
            minute: 0,
            dateOffset: 1,
          }),
      );
    }

    const { data } = await this.client.get<PotentialHistoryResponseDtoBody>(path, {
      params: query,
    });

    return new PotentialHistoryResponseDto(data);
  }

  //#endregion

  //#region 랭킹 정보 조회

  /**
   * 종합 랭킹 정보를 조회합니다.
   * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.
   * - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param filterOptions 검색 기준
   * @param dateOptions 조회 기준일 (KST).
   *
   */
  public async getOverallRanking(
    filterOptions?: OverallRankingApiFilterOptions,
    dateOptions: DateOptions = MapleStoryApi.getProperDefaultDateOptions({
      hour: 8,
      minute: 30,
      dateOffset: 0,
    }),
  ): Promise<OverallRankingResponseDto> {
    const path = 'maplestory/v1/ranking/overall';
    const query: OverallRankingApiQuery = {
      date: MapleStoryApi.toDateString(
        {
          year: 2023,
          month: 12,
          day: 22,
        },
        dateOptions,
      ),
    };

    if (filterOptions) {
      const { worldName, worldType, characterClass, ocid, page } =
        filterOptions;

      query.world_name = worldName;
      query.world_type = worldType;
      query.class = characterClass;
      query.ocid = ocid;
      query.page = page;
    }

    const { data } = await this.client.get<OverallRankingResponseDtoBody>(path, {
      params: query,
    });

    return new OverallRankingResponseDto(data);
  }

  /**
   * 유니온 랭킹 정보를 조회합니다.
   * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.
   * - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param filterOptions 검색 기준
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getUnionRanking(
    filterOptions?: UnionRankingApiFilterOptions,
    dateOptions: DateOptions = MapleStoryApi.getProperDefaultDateOptions({
      hour: 8,
      minute: 30,
      dateOffset: 0,
    }),
  ): Promise<UnionRankingResponseDto> {
    const path = 'maplestory/v1/ranking/union';
    const query: UnionRankingApiQuery = {
      date: MapleStoryApi.toDateString(
        {
          year: 2023,
          month: 12,
          day: 22,
        },
        dateOptions,
      ),
    };

    if (filterOptions) {
      const { worldName, ocid, page } = filterOptions;

      query.world_name = worldName;
      query.ocid = ocid;
      query.page = page;
    }

    const { data } = await this.client.get<UnionRankingResponseDtoBody>(path, {
      params: query,
    });

    return new UnionRankingResponseDto(data);
  }

  /**
   * 길드 랭킹 정보를 조회합니다.
   * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.
   * - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param filterOptions 검색 기준
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getGuildRanking(
    filterOptions?: GuildRankingApiFilterOptions,
    dateOptions: DateOptions = MapleStoryApi.getProperDefaultDateOptions({
      hour: 8,
      minute: 30,
      dateOffset: 0,
    }),
  ): Promise<GuildRankingResponseDto> {
    const path = 'maplestory/v1/ranking/guild';
    const query: GuildRankingApiQuery = {
      date: MapleStoryApi.toDateString(
        {
          year: 2023,
          month: 12,
          day: 22,
        },
        dateOptions,
      ),
      ranking_type: 0,
    };

    if (filterOptions) {
      const { worldName, rankingType, ocid, page } = filterOptions;

      query.world_name = worldName;
      query.ranking_type = rankingType;
      query.ocid = ocid;
      query.page = page;
    }

    const { data } = await this.client.get<GuildRankingResponseDtoBody>(path, {
      params: query,
    });

    return new GuildRankingResponseDto(data);
  }

  /**
   * 무릉도장 랭킹 정보를 조회합니다.
   * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.
   * - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param filterOptions 검색 기준
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getDojangRanking(
    filterOptions?: DojangRankingApiFilterOptions,
    dateOptions: DateOptions = MapleStoryApi.getProperDefaultDateOptions({
      hour: 8,
      minute: 30,
      dateOffset: 0,
    }),
  ): Promise<DojangRankingResponseDto> {
    const path = 'maplestory/v1/ranking/dojang';
    const query: DojangRankingApiQuery = {
      date: MapleStoryApi.toDateString(
        {
          year: 2023,
          month: 12,
          day: 22,
        },
        dateOptions,
      ),
      difficulty: 0,
    };

    if (filterOptions) {
      const { worldName, difficulty, characterClass, ocid, page } =
        filterOptions;

      query.world_name = worldName;
      query.difficulty = difficulty;
      query.class = characterClass;
      query.ocid = ocid;
      query.page = page;
    }

    const { data } = await this.client.get<DojangRankingResponseDtoBody>(path, {
      params: query,
    });

    return new DojangRankingResponseDto(data);
  }

  /**
   * 더 시드 랭킹 정보를 조회합니다.
   * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.
   * - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param filterOptions 검색 기준
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getSeedRanking(
    filterOptions?: TheSeedRankingApiFilterOptions,
    dateOptions: DateOptions = MapleStoryApi.getProperDefaultDateOptions({
      hour: 8,
      minute: 30,
      dateOffset: 0,
    }),
  ): Promise<TheSeedRankingResponseDto> {
    const path = 'maplestory/v1/ranking/theseed';
    const query: TheSeedRankingApiQuery = {
      date: MapleStoryApi.toDateString(
        {
          year: 2023,
          month: 12,
          day: 22,
        },
        dateOptions,
      ),
    };

    if (filterOptions) {
      const { worldName, ocid, page } = filterOptions;

      query.world_name = worldName;
      query.ocid = ocid;
      query.page = page;
    }

    const { data } = await this.client.get<TheSeedRankingResponseDtoBody>(path, {
      params: query,
    });

    return new TheSeedRankingResponseDto(data);
  }

  /**
   * 업적 랭킹 정보를 조회합니다.
   * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.
   * - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param filterOptions 검색 기준
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getAchievementRanking(
    filterOptions?: AchievementRankingApiFilterOptions,
    dateOptions: DateOptions = MapleStoryApi.getProperDefaultDateOptions({
      hour: 8,
      minute: 30,
      dateOffset: 0,
    }),
  ): Promise<AchievementRankingResponseDto> {
    const path = 'maplestory/v1/ranking/achievement';
    const query: AchievementRankingApiQuery = {
      date: MapleStoryApi.toDateString(
        {
          year: 2023,
          month: 12,
          day: 22,
        },
        dateOptions,
      ),
    };

    if (filterOptions) {
      const { ocid, page } = filterOptions;

      query.ocid = ocid;
      query.page = page;
    }

    const { data } = await this.client.get<AchievementRankingResponseDtoBody>(
      path,
      {
        params: query,
      },
    );

    return new AchievementRankingResponseDto(data);
  }

  //#endregion

  /**
   * 서버 점검 정보를 조회합니다.
   */
  public async getInspectionInfo(): Promise<InspectionInfoDto> {
    const xmlBuilder = new xml2js.Builder();
    const soapEnvelop = {
      'soap:Envelope': {
        $: {
          'xmlns:xsi': 'http://www.w3.org/2001/XMLSchema-instance',
          'xmlns:xsd': 'http://www.w3.org/2001/XMLSchema',
          'xmlns:soap': 'http://schemas.xmlsoap.org/soap/envelope/',
        },
        'soap:Body': {
          GetInspectionInfo: {
            $: {
              xmlns: 'https://api.maplestory.nexon.com/soap/',
            },
          },
        },
      },
    };

    const baseUrl = 'https://api.maplestory.nexon.com/';
    const path = 'soap/maplestory.asmx';
    const headers = {
      SOAPAction: 'https://api.maplestory.nexon.com/soap/GetInspectionInfo',
      'Content-Type': 'text/xml; charset=utf-8',
    };
    const body = xmlBuilder.buildObject(soapEnvelop);

    const response = await axios.post<string>(path, body, {
      baseURL: baseUrl,
      timeout: this.timeout,
      headers,
    });

    const xml = (await xml2js.parseStringPromise(
      response.data,
    )) as InspectionInfoSoapBody;

    return new InspectionInfoDto(xml);
  }

  /**
   * API 서버의 데이터 갱신 시간에 따라 데이터가 조회 가능한 최신 날짜를 반환합니다.
   *
   * @param options
   * @private
   */
  private static getProperDefaultDateOptions(
    options: LatestApiUpdateTimeOptions,
  ): DateOptions {
    const { hour, minute, dateOffset } = options;

    const kstNow = dayjs().utcOffset(MapleStoryApi.kstOffset);
    const updateDate = dayjs()
      .utcOffset(MapleStoryApi.kstOffset)
      .hour(hour)
      .minute(minute);

    let adjustedDate: Dayjs;

    if (kstNow.isAfter(updateDate)) {
      adjustedDate = kstNow;
    } else {
      adjustedDate = kstNow.subtract(1, 'day');
    }

    adjustedDate = adjustedDate.subtract(dateOffset ?? 0, 'day');

    return {
      year: adjustedDate.year(),
      month: adjustedDate.month() + 1,
      day: adjustedDate.date(),
    };
  }

  /**
   * 날짜 정보를 API 서버에서 요구하는 포맷으로 변환합니다.
   *
   * @param minDateOptions API 호출 가능한 최소 날짜
   * @param dateOptions 조회 하려는 날짜
   * @private
   */
  private static toDateString(
    minDateOptions: DateOptions,
    dateOptions: DateOptions,
  ): string | never {
    const { year: minYear, month: minMonth, day: minDay } = minDateOptions;
    const { year, month, day } = dateOptions;

    if (
      year < minYear ||
      (year === minYear && month < minMonth) ||
      (year === minYear && month === minMonth && day < minDay)
    ) {
      throw new Error(
        `You can only retrieve data after ${dayjs(
          `${minYear}-${minMonth}-${minDay}`,
        ).format('YYYY-MM-DD')}.`,
      );
    }

    return dayjs(`${year}-${month}-${day}`)
      .utcOffset(MapleStoryApi.kstOffset)
      .format('YYYY-MM-DD');
  }
}

type OverallRankingApiFilterOptions = {
  /**
   * 월드 명
   *
   * - 스카니아
   * - 베라
   * - 루나
   * - 제니스
   * - 크로아
   * - 유니온
   * - 엘리시움
   * - 이노시스
   * - 레드
   * - 오로라
   * - 아케인
   * - 노바
   * - 리부트
   * - 리부트2
   * - 버닝
   * - 버닝2
   * - 버닝3
   */
  worldName?: string;

  /**
   * 월드 타입 (0:일반, 1:리부트) (기본 값은 0이며, world_name 입력 시 미 반영)
   */
  worldType?: number;

  /**
   * 직업 및 전직
   * - 초보자-전체 전직
   * - 전사-전체 전직
   * - 전사-검사
   * - 전사-파이터
   * - 전사-페이지
   * - 전사-스피어맨
   * - 전사-크루세이더
   * - 전사-나이트
   * - 전사-버서커
   * - 전사-히어로
   * - 전사-팔라딘
   * - 전사-다크나이트
   * - 마법사-전체 전직
   * - 마법사-매지션
   * - 마법사-위자드(불,독)
   * - 마법사-위자드(썬,콜)
   * - 마법사-클레릭
   * - 마법사-메이지(불,독)
   * - 마법사-메이지(썬,콜)
   * - 마법사-프리스트
   * - 마법사-아크메이지(불,독)
   * - 마법사-아크메이지(썬,콜)
   * - 마법사-비숍
   * - 궁수-전체 전직
   * - 궁수-아처
   * - 궁수-헌터
   * - 궁수-사수
   * - 궁수-레인저
   * - 궁수-저격수
   * - 궁수-보우마스터
   * - 궁수-신궁
   * - 궁수-아처(패스파인더)
   * - 궁수-에인션트아처
   * - 궁수-체이서
   * - 궁수-패스파인더
   * - 도적-전체 전직
   * - 도적-로그
   * - 도적-어쌔신
   * - 도적-시프
   * - 도적-허밋
   * - 도적-시프마스터
   * - 도적-나이트로드
   * - 도적-섀도어
   * - 도적-세미듀어러
   * - 도적-듀어러
   * - 도적-듀얼마스터
   * - 도적-슬래셔
   * - 도적-듀얼블레이더
   * - 해적-전체 전직
   * - 해적-해적
   * - 해적-인파이터
   * - 해적-건슬링거
   * - 해적-캐논슈터
   * - 해적-버커니어
   * - 해적-발키리
   * - 해적-캐논블래스터
   * - 해적-바이퍼
   * - 해적-캡틴
   * - 해적-캐논마스터
   * - 기사단-전체 전직
   * - 기사단-노블레스
   * - 기사단-소울마스터
   * - 기사단-플레임위자드
   * - 기사단-윈드브레이커
   * - 기사단-나이트워커
   * - 기사단-스트라이커
   * - 기사단-미하일
   * - 아란-전체 전직
   * - 에반-전체 전직
   * - 레지스탕스-전체 전직
   * - 레지스탕스-시티즌
   * - 레지스탕스-배틀메이지
   * - 레지스탕스-와일드헌터
   * - 레지스탕스-메카닉
   * - 레지스탕스-데몬슬레이어
   * - 레지스탕스-데몬어벤져
   * - 레지스탕스-제논
   * - 레지스탕스-블래스터
   * - 메르세데스-전체 전직
   * - 팬텀-전체 전직
   * - 루미너스-전체 전직
   * - 카이저-전체 전직
   * - 엔젤릭버스터-전체 전직
   * - 초월자-전체 전직
   * - 초월자-제로
   * - 은월-전체 전직
   * - 프렌즈 월드-전체 전직
   * - 프렌즈 월드-키네시스
   * - 카데나-전체 전직
   * - 일리움-전체 전직
   * - 아크-전체 전직
   * - 호영-전체 전직
   * - 아델-전체 전직
   * - 카인-전체 전직
   * - 라라-전체 전직
   * - 칼리-전체 전직
   */
  characterClass?: string;

  /**
   * 캐릭터 식별자
   */
  ocid?: string;

  /**
   * 페이지 번호
   */
  page?: number;
};

type UnionRankingApiFilterOptions = {
  /**
   * 월드 명
   *
   * - 스카니아
   * - 베라
   * - 루나
   * - 제니스
   * - 크로아
   * - 유니온
   * - 엘리시움
   * - 이노시스
   * - 레드
   * - 오로라
   * - 아케인
   * - 노바
   * - 리부트
   * - 리부트2
   * - 버닝
   * - 버닝2
   * - 버닝3
   */
  worldName?: string;

  /**
   * 캐릭터 식별자
   */
  ocid?: string;

  /**
   * 페이지 번호
   */
  page?: number;
};

type GuildRankingApiFilterOptions = {
  /**
   * 월드 명
   *
   * - 스카니아
   * - 베라
   * - 루나
   * - 제니스
   * - 크로아
   * - 유니온
   * - 엘리시움
   * - 이노시스
   * - 레드
   * - 오로라
   * - 아케인
   * - 노바
   * - 리부트
   * - 리부트2
   * - 버닝
   * - 버닝2
   * - 버닝3
   */
  worldName?: string;

  /**
   * 랭킹 타입 (0:주간 명성치, 1:플래그 레이스, 2:지하 수로)
   */
  rankingType: number;

  /**
   * 캐릭터 식별자
   */
  ocid?: string;

  /**
   * 페이지 번호
   */
  page?: number;
};

type DojangRankingApiFilterOptions = {
  /**
   * 월드 명
   *
   * - 스카니아
   * - 베라
   * - 루나
   * - 제니스
   * - 크로아
   * - 유니온
   * - 엘리시움
   * - 이노시스
   * - 레드
   * - 오로라
   * - 아케인
   * - 노바
   * - 리부트
   * - 리부트2
   * - 버닝
   * - 버닝2
   * - 버닝3
   */
  worldName?: string;

  /**
   * 구간 (0:일반, 1:통달)
   */
  difficulty: number;

  /**
   * 직업 및 전직
   * - 초보자-전체 전직
   * - 전사-전체 전직
   * - 전사-검사
   * - 전사-파이터
   * - 전사-페이지
   * - 전사-스피어맨
   * - 전사-크루세이더
   * - 전사-나이트
   * - 전사-버서커
   * - 전사-히어로
   * - 전사-팔라딘
   * - 전사-다크나이트
   * - 마법사-전체 전직
   * - 마법사-매지션
   * - 마법사-위자드(불,독)
   * - 마법사-위자드(썬,콜)
   * - 마법사-클레릭
   * - 마법사-메이지(불,독)
   * - 마법사-메이지(썬,콜)
   * - 마법사-프리스트
   * - 마법사-아크메이지(불,독)
   * - 마법사-아크메이지(썬,콜)
   * - 마법사-비숍
   * - 궁수-전체 전직
   * - 궁수-아처
   * - 궁수-헌터
   * - 궁수-사수
   * - 궁수-레인저
   * - 궁수-저격수
   * - 궁수-보우마스터
   * - 궁수-신궁
   * - 궁수-아처(패스파인더)
   * - 궁수-에인션트아처
   * - 궁수-체이서
   * - 궁수-패스파인더
   * - 도적-전체 전직
   * - 도적-로그
   * - 도적-어쌔신
   * - 도적-시프
   * - 도적-허밋
   * - 도적-시프마스터
   * - 도적-나이트로드
   * - 도적-섀도어
   * - 도적-세미듀어러
   * - 도적-듀어러
   * - 도적-듀얼마스터
   * - 도적-슬래셔
   * - 도적-듀얼블레이더
   * - 해적-전체 전직
   * - 해적-해적
   * - 해적-인파이터
   * - 해적-건슬링거
   * - 해적-캐논슈터
   * - 해적-버커니어
   * - 해적-발키리
   * - 해적-캐논블래스터
   * - 해적-바이퍼
   * - 해적-캡틴
   * - 해적-캐논마스터
   * - 기사단-전체 전직
   * - 기사단-노블레스
   * - 기사단-소울마스터
   * - 기사단-플레임위자드
   * - 기사단-윈드브레이커
   * - 기사단-나이트워커
   * - 기사단-스트라이커
   * - 기사단-미하일
   * - 아란-전체 전직
   * - 에반-전체 전직
   * - 레지스탕스-전체 전직
   * - 레지스탕스-시티즌
   * - 레지스탕스-배틀메이지
   * - 레지스탕스-와일드헌터
   * - 레지스탕스-메카닉
   * - 레지스탕스-데몬슬레이어
   * - 레지스탕스-데몬어벤져
   * - 레지스탕스-제논
   * - 레지스탕스-블래스터
   * - 메르세데스-전체 전직
   * - 팬텀-전체 전직
   * - 루미너스-전체 전직
   * - 카이저-전체 전직
   * - 엔젤릭버스터-전체 전직
   * - 초월자-전체 전직
   * - 초월자-제로
   * - 은월-전체 전직
   * - 프렌즈 월드-전체 전직
   * - 프렌즈 월드-키네시스
   * - 카데나-전체 전직
   * - 일리움-전체 전직
   * - 아크-전체 전직
   * - 호영-전체 전직
   * - 아델-전체 전직
   * - 카인-전체 전직
   * - 라라-전체 전직
   * - 칼리-전체 전직
   */
  characterClass?: string;

  /**
   * 캐릭터 식별자
   */
  ocid?: string;

  /**
   * 페이지 번호
   */
  page?: number;
};

type TheSeedRankingApiFilterOptions = {
  /**
   * 월드 명
   *
   * - 스카니아
   * - 베라
   * - 루나
   * - 제니스
   * - 크로아
   * - 유니온
   * - 엘리시움
   * - 이노시스
   * - 레드
   * - 오로라
   * - 아케인
   * - 노바
   * - 리부트
   * - 리부트2
   * - 버닝
   * - 버닝2
   * - 버닝3
   */
  worldName?: string;

  /**
   * 캐릭터 식별자
   */
  ocid?: string;

  /**
   * 페이지 번호
   */
  page?: number;
};

type AchievementRankingApiFilterOptions = {
  /**
   * 캐릭터 식별자
   */
  ocid?: string;

  /**
   * 페이지 번호
   */
  page?: number;
};

type DateOptions = {
  year: number;
  month: number;
  day: number;
};

/**
 * API 서버의 데이터 갱신 시각과 조회 가능한 최근 날짜와 현재 날짜와의 차이
 */
type LatestApiUpdateTimeOptions = {
  hour: number;
  minute: number;
  dateOffset?: number;
};

type CharacterApiQuery = {
  ocid: string;
  date: string;
};

type CharacterSkillApiQuery = {
  ocid: string;
  date: string;
  character_skill_grade: string;
};

type StarforceApiQuery = {
  count: number;
  date?: string;
  cursor?: string;
};

type CubeApiQuery = {
  count: number;
  date?: string;
  cursor?: string;
};

type PotentialApiQuery = {
  count: number;
  date?: string;
  cursor?: string;
};

type UnionApiQuery = {
  ocid: string;
  date: string;
};

type GuildApiQuery = {
  oguild_id: string;
  date: string;
};

type OverallRankingApiQuery = {
  date: string;
  world_name?: string;
  world_type?: number;
  class?: string;
  ocid?: string;
  page?: number;
};

type UnionRankingApiQuery = {
  date: string;
  world_name?: string;
  ocid?: string;
  page?: number;
};

type GuildRankingApiQuery = {
  date: string;
  world_name?: string;
  ranking_type: number;
  ocid?: string;
  page?: number;
};

type DojangRankingApiQuery = {
  date: string;
  world_name?: string;
  difficulty: number;
  class?: string;
  ocid?: string;
  page?: number;
};

type TheSeedRankingApiQuery = {
  date: string;
  world_name?: string;
  ocid?: string;
  page?: number;
};

type AchievementRankingApiQuery = {
  date: string;
  ocid?: string;
  page?: number;
};

type MapleStoryErrorBody = {
  error: {
    name: string;
    message: string;
  };
};

export { MapleStoryApi, MapleStoryErrorBody };
