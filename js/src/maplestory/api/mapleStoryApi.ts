import axios, { Axios, AxiosError } from 'axios';
import { Buffer } from 'buffer/'; // polyfill of Buffer for browser
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
import {
  CharacterImageAction,
  CharacterImageDto,
  CharacterImageEmotion,
  CharacterImageWeaponMotion,
} from './dto/character/characterImageDto';
import { CharacterItemEquipmentDto } from './dto/character/characterItemEquipmentDto';
import { CharacterLinkSkillDto } from './dto/character/characterLinkSkillDto';
import { CharacterListDto } from './dto/character/characterListDto';
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
import { CashshopNoticeDetailDto } from './dto/notice/cashshopNoticeDetailDto';
import { CashshopNoticeListDto } from './dto/notice/cashshopNoticeListDto';
import { EventNoticeDetailDto } from './dto/notice/eventNoticeDetailDto';
import { EventNoticeListDto } from './dto/notice/eventNoticeListDto';
import { NoticeDetailDto } from './dto/notice/noticeDetailDto';
import { NoticeListDto } from './dto/notice/noticeListDto';
import { UpdateNoticeDetailDto } from './dto/notice/updateNoticeDetailDto';
import { UpdateNoticeListDto } from './dto/notice/updateNoticeListDto';
import { AchievementRankingResponseDto } from './dto/ranking/achievementRankingResponseDto';
import { DojangRankingResponseDto } from './dto/ranking/dojangRankingResponseDto';
import { GuildRankingResponseDto } from './dto/ranking/guildRankingResponseDto';
import { OverallRankingResponseDto } from './dto/ranking/overallRankingResponseDto';
import { TheSeedRankingResponseDto } from './dto/ranking/theSeedRankingResponseDto';
import { UnionRankingResponseDto } from './dto/ranking/unionRankingResponseDto';
import { UnionArtifactDto } from './dto/union/unionArtifactDto';
import { UnionChampionDto } from './dto/union/unionChampionDto';
import { UnionDto } from './dto/union/unionDto';
import { UnionRaiderDto } from './dto/union/unionRaiderDto';
import { MapleStoryApiError } from './mapleStoryApiError';
import { CharacterAbilityBody } from './response/character/characterAbilityBody';
import { CharacterAndroidEquipmentBody } from './response/character/characterAndroidEquipmentBody';
import { CharacterBasicBody } from './response/character/characterBasicBody';
import { CharacterBeautyEquipmentBody } from './response/character/characterBeautyEquipmentBody';
import { CharacterBody } from './response/character/characterBody';
import { CharacterCashItemEquipmentBody } from './response/character/characterCashItemEquipmentBody';
import { CharacterDojangBody } from './response/character/characterDojangBody';
import { CharacterHexaMatrixBody } from './response/character/characterHexaMatrixBody';
import { CharacterHexaMatrixStatBody } from './response/character/characterHexaMatrixStatBody';
import { CharacterHyperStatBody } from './response/character/characterHyperStatBody';
import { CharacterItemEquipmentBody } from './response/character/characterItemEquipmentBody';
import { CharacterLinkSkillBody } from './response/character/characterLinkSkillBody';
import { CharacterListBody } from './response/character/characterListBody';
import { CharacterPetEquipmentBody } from './response/character/characterPetEquipmentBody';
import { CharacterPopularityBody } from './response/character/characterPopularityBody';
import { CharacterPropensityBody } from './response/character/characterPropensityBody';
import { CharacterSetEffectBody } from './response/character/characterSetEffectBody';
import { CharacterSkillBody } from './response/character/characterSkillBody';
import { CharacterStatBody } from './response/character/characterStatBody';
import { CharacterSymbolEquipmentBody } from './response/character/characterSymbolEquipmentBody';
import { CharacterVMatrixBody } from './response/character/characterVMatrixBody';
import { GuildBasicBody } from './response/guild/guildBasicBody';
import { GuildBody } from './response/guild/guildBody';
import { CubeHistoryResponseBody } from './response/history/cubeHistoryBody';
import { PotentialHistoryResponseBody } from './response/history/potentialHistoryBody';
import { StarforceHistoryResponseBody } from './response/history/starforceHistoryBody';
import { InspectionInfoSoapBody } from './response/inspectionInfoSoapBody';
import { CashshopNoticeDetailBody } from './response/notice/cashshopNoticeDetailBody';
import { CashshopNoticeListBody } from './response/notice/cashshopNoticeListBody';
import { EventNoticeDetailBody } from './response/notice/eventNoticeDetailBody';
import { EventNoticeListBody } from './response/notice/eventNoticeListBody';
import { NoticeDetailBody } from './response/notice/noticeDetailBody';
import { NoticeListBody } from './response/notice/noticeListBody';
import { UpdateNoticeDetailBody } from './response/notice/updateNoticeDetailBody';
import { UpdateNoticeListBody } from './response/notice/updateNoticeListBody';
import { AchievementRankingResponseBody } from './response/ranking/achievementRankingBody';
import { DojangRankingResponseBody } from './response/ranking/dojangRankingBody';
import { GuildRankingResponseBody } from './response/ranking/guildRankingBody';
import { OverallRankingResponseBody } from './response/ranking/overallRankingBody';
import { TheSeedRankingResponseBody } from './response/ranking/theSeedRankingBody';
import { UnionRankingResponseBody } from './response/ranking/unionRankingBody';
import { UnionArtifactBody } from './response/union/unionArtifactBody';
import { UnionBody } from './response/union/unionBody';
import { UnionChampionBody } from './response/union/unionChampionBody';
import { UnionRaiderBody } from './response/union/unionRaiderBody';

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

        throw error;
      });
  }

  //#region 캐릭터 정보 조회

  /**
   * 캐릭터 식별자(ocid)를 조회합니다.
   * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param characterName    캐릭터 명
   */
  public async getCharacter(characterName: string): Promise<CharacterDto> {
    const path = 'maplestory/v1/id';
    const { data } = await this.client.get<CharacterBody>(path, {
      params: {
        character_name: characterName,
      },
    });

    return new CharacterDto(data);
  }

  /**
   * 계정의 보유 캐릭터 목록을 조회합니다.
   * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
   * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   */
  public async getCharacterList(): Promise<CharacterListDto> {
    const path = 'maplestory/v1/character/list';
    const { data } = await this.client.get<CharacterListBody>(path);

    return new CharacterListDto(data);
  }

  /**
   * 기본 정보를 조회합니다.
   * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterBasic(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterBasicDto> {
    const path = 'maplestory/v1/character/basic';
    const date = dateOptions
      ? toDateString(dateOptions, {
        year: 2023,
        month: 12,
        day: 21,
      })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterBasicBody>(path, {
      params: query,
    });

    return new CharacterBasicDto(data);
  }

  /**
   * 캐릭터 외형 이미지 정보를 조회합니다.
   * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param imageOptions 캐릭터 외형 파라미터
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterImage(ocid: string, imageOptions?: CharacterImageOptions, dateOptions?: DateOptions): Promise<CharacterImageDto> {
    const { date, characterImage: path } = await this.getCharacterBasic(ocid, dateOptions);
    const action = imageOptions?.action ?? CharacterImageAction.Stand1;
    const emotion = imageOptions?.emotion ?? CharacterImageEmotion.Default;
    const wmotion = imageOptions?.wmotion ?? CharacterImageWeaponMotion.Default;
    const actionFrame = imageOptions?.actionFrame ?? 0;
    const emotionFrame = imageOptions?.emotionFrame ?? 0;
    const width = 96;
    const height = 96;
    const x = imageOptions?.x ?? null;
    const y = imageOptions?.y ?? null;

    const query = {
      action: `${action}.${actionFrame}`,
      emotion: `${emotion}.${emotionFrame}`,
      wmotion,
      width,
      height,
      x,
      y,
    };

    const urlImageToBase64 = async (path: string, query?: object): Promise<string> => {
      const { data, headers } = await axios.get<string>(path, {
        params: query,
        responseType: 'arraybuffer',
      });
      const base64 = Buffer.from(data, 'binary').toString('base64');
      const mimeType = headers['content-type'];

      return `data:${mimeType};base64,${base64}`;
    };

    const [originImage, image] = await Promise.all([
      urlImageToBase64(path),
      urlImageToBase64(path, query),
    ]);

    return new CharacterImageDto({
      date,
      originUrl: path,
      originImage,
      image,
      action,
      emotion,
      wmotion,
      actionFrame,
      emotionFrame,
      width,
      height,
      x,
      y,
    });
  }

  /**
   * 인기도 정보를 조회합니다.
   * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterPopularity(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterPopularityDto> {
    const path = 'maplestory/v1/character/popularity';
    const date = dateOptions
      ? toDateString(dateOptions, {
        year: 2023,
        month: 12,
        day: 21,
      })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterPopularityBody>(path, {
      params: query,
    });

    return new CharacterPopularityDto(data);
  }

  /**
   * 종합 능력치 정보를 조회합니다.
   * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterStat(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterStatDto> {
    const path = 'maplestory/v1/character/stat';
    const date = dateOptions
      ? toDateString(dateOptions, {
        year: 2023,
        month: 12,
        day: 21,
      })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterStatBody>(path, {
      params: query,
    });

    return new CharacterStatDto(data);
  }

  /**
   * 하이퍼스탯 정보를 조회합니다.
   * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterHyperStat(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterHyperStatDto> {
    const path = 'maplestory/v1/character/hyper-stat';
    const date = dateOptions
      ? toDateString(dateOptions, {
        year: 2023,
        month: 12,
        day: 21,
      })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterHyperStatBody>(path, {
      params: query,
    });

    return new CharacterHyperStatDto(data);
  }

  /**
   * 성향 정보를 조회합니다.
   * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterPropensity(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterPropensityDto> {
    const path = 'maplestory/v1/character/propensity';
    const date = dateOptions
      ? toDateString(dateOptions, {
        year: 2023,
        month: 12,
        day: 21,
      })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterPropensityBody>(path, {
      params: query,
    });

    return new CharacterPropensityDto(data);
  }

  /**
   * 어빌리티 정보를 조회합니다.
   * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterAbility(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterAbilityDto> {
    const path = 'maplestory/v1/character/ability';
    const date = dateOptions
      ? toDateString(dateOptions, {
        year: 2023,
        month: 12,
        day: 21,
      })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterAbilityBody>(path, {
      params: query,
    });

    return new CharacterAbilityDto(data);
  }

  /**
   * 장착한 장비 중 캐시 장비를 제외한 나머지 장비 정보를 조회합니다.
   * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterItemEquipment(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterItemEquipmentDto> {
    const path = 'maplestory/v1/character/item-equipment';
    const date = dateOptions
      ? toDateString(dateOptions, {
        year: 2023,
        month: 12,
        day: 21,
      })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterItemEquipmentBody>(path, {
      params: query,
    });

    return new CharacterItemEquipmentDto(data);
  }

  /**
   * 장착한 캐시 장비 정보를 조회합니다.
   * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterCashItemEquipment(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterCashItemEquipmentDto> {
    const path = 'maplestory/v1/character/cashitem-equipment';
    const date = dateOptions
      ? toDateString(dateOptions, {
        year: 2023,
        month: 12,
        day: 21,
      })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterCashItemEquipmentBody>(
      path,
      {
        params: query,
      },
    );

    return new CharacterCashItemEquipmentDto(data);
  }

  /**
   * 장착한 심볼 정보를 조회합니다.
   * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterSymbolEquipment(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterSymbolEquipmentDto> {
    const path = 'maplestory/v1/character/symbol-equipment';
    const date = dateOptions
      ? toDateString(dateOptions, {
        year: 2023,
        month: 12,
        day: 21,
      })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterSymbolEquipmentBody>(path, {
      params: query,
    });

    return new CharacterSymbolEquipmentDto(data);
  }

  /**
   * 적용받고 있는 세트 효과 정보를 조회합니다.
   * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterSetEffect(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterSetEffectDto> {
    const path = 'maplestory/v1/character/set-effect';
    const date = dateOptions
      ? toDateString(dateOptions, {
        year: 2023,
        month: 12,
        day: 21,
      })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterSetEffectBody>(path, {
      params: query,
    });

    return new CharacterSetEffectDto(data);
  }

  /**
   * 장착 중인 헤어, 성형, 피부 정보를 조회합니다.
   * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterBeautyEquipment(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterBeautyEquipmentDto> {
    const path = 'maplestory/v1/character/beauty-equipment';
    const date = dateOptions
      ? toDateString(dateOptions, {
        year: 2023,
        month: 12,
        day: 21,
      })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterBeautyEquipmentBody>(path, {
      params: query,
    });

    return new CharacterBeautyEquipmentDto(data);
  }

  /**
   * 장착한 안드로이드 정보를 조회합니다.
   * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterAndroidEquipment(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterAndroidEquipmentDto> {
    const path = 'maplestory/v1/character/android-equipment';
    const date = dateOptions
      ? toDateString(dateOptions, {
        year: 2023,
        month: 12,
        day: 21,
      })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterAndroidEquipmentBody>(path, {
      params: query,
    });

    return new CharacterAndroidEquipmentDto(data);
  }

  /**
   * 장착한 펫 및 펫 스킬, 장비 정보를 조회합니다.
   * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterPetEquipment(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterPetEquipmentDto> {
    const path = 'maplestory/v1/character/pet-equipment';
    const date = dateOptions
      ? toDateString(dateOptions, {
        year: 2023,
        month: 12,
        day: 21,
      })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterPetEquipmentBody>(path, {
      params: query,
    });

    return new CharacterPetEquipmentDto(data);
  }

  /**
   * 캐릭터 스킬과 하이퍼 스킬 정보를 조회합니다.
   * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
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
    dateOptions?: DateOptions,
  ): Promise<CharacterSkillDto> {
    const path = 'maplestory/v1/character/skill';
    const date = dateOptions
      ? toDateString(dateOptions, {
        year: 2023,
        month: 12,
        day: 21,
      })
      : undefined;
    const query: CharacterSkillApiQuery = {
      ocid: ocid,
      character_skill_grade: characterSkillGrade,
      date: date,
    };
    const { data } = await this.client.get<CharacterSkillBody>(path, {
      params: query,
    });

    return new CharacterSkillDto(data);
  }

  /**
   * 장착 링크 스킬 정보를 조회합니다.
   * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterLinkSkill(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterLinkSkillDto> {
    const path = 'maplestory/v1/character/link-skill';
    const date = dateOptions
      ? toDateString(dateOptions, {
        year: 2023,
        month: 12,
        day: 21,
      })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterLinkSkillBody>(path, {
      params: query,
    });

    return new CharacterLinkSkillDto(data);
  }

  /**
   * V매트릭스 슬롯 정보와 장착한 V코어 정보를 조회합니다.
   * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterVMatrix(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterVMatrixDto> {
    const path = 'maplestory/v1/character/vmatrix';
    const date = dateOptions
      ? toDateString(dateOptions, {
        year: 2023,
        month: 12,
        day: 21,
      })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterVMatrixBody>(path, {
      params: query,
    });

    return new CharacterVMatrixDto(data);
  }

  /**
   * HEXA 매트릭스에 장착한 HEXA 코어 정보를 조회합니다.
   * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterHexaMatrix(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterHexaMatrixDto> {
    const path = 'maplestory/v1/character/hexamatrix';
    const date = dateOptions
      ? toDateString(dateOptions, {
        year: 2023,
        month: 12,
        day: 21,
      })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterHexaMatrixBody>(path, {
      params: query,
    });

    return new CharacterHexaMatrixDto(data);
  }

  /**
   * HEXA 매트릭스에 설정한 HEXA 스탯 정보를 조회합니다.
   * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterHexaMatrixStat(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterHexaMatrixStatDto> {
    const path = 'maplestory/v1/character/hexamatrix-stat';
    const date = dateOptions
      ? toDateString(dateOptions, {
        year: 2023,
        month: 12,
        day: 21,
      })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterHexaMatrixStatBody>(path, {
      params: query,
    });

    return new CharacterHexaMatrixStatDto(data);
  }

  /**
   * 캐릭터 무릉도장 최고 기록 정보를 조회합니다.
   * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCharacterDojang(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterDojangDto> {
    const path = 'maplestory/v1/character/dojang';
    const date = dateOptions
      ? toDateString(dateOptions, {
        year: 2023,
        month: 12,
        day: 21,
      })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterDojangBody>(path, {
      params: query,
    });

    return new CharacterDojangDto(data);
  }

  //#endregion

  //#region 유니온 정보 조회

  /**
   * 유니온 정보를 조회합니다.
   * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getUnion(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<UnionDto> {
    const path = 'maplestory/v1/user/union';
    const date = dateOptions
      ? toDateString(dateOptions, {
        year: 2023,
        month: 12,
        day: 21,
      })
      : undefined;
    const query: UnionApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<UnionBody>(path, {
      params: query,
    });

    return new UnionDto(data);
  }

  /**
   * 유니온 공격대 정보를 조회합니다.
   * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getUnionRaider(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<UnionRaiderDto> {
    const path = 'maplestory/v1/user/union-raider';
    const date = dateOptions
      ? toDateString(dateOptions, {
        year: 2023,
        month: 12,
        day: 21,
      })
      : undefined;
    const query: UnionApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<UnionRaiderBody>(path, {
      params: query,
    });

    return new UnionRaiderDto(data);
  }

  /**
   * 유니온 아티팩트 정보를 조회합니다.
   * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getUnionArtifact(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<UnionArtifactDto> {
    const path = 'maplestory/v1/user/union-artifact';
    const date = dateOptions
      ? toDateString(dateOptions, {
        year: 2023,
        month: 12,
        day: 21,
      })
      : undefined;
    const query: UnionApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<UnionArtifactBody>(path, {
      params: query,
    });

    return new UnionArtifactDto(data);
  }

  /**
   * 유니온 챔피언 정보를 조회합니다.<br>
   * 유니온 챔피언 정보는 2025년 2월 20일 메이플스토리 점검 이후 데이터부터 조회 가능합니다.<br>
   * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param ocid 캐릭터 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getUnionChampion(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<UnionChampionDto> {
    const path = 'maplestory/v1/user/union-champion';
    const date = dateOptions
      ? toDateString(dateOptions, {
        year: 2023,
        month: 12,
        day: 21,
      })
      : undefined;
    const query: UnionApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<UnionChampionBody>(path, {
      params: query,
    });

    return new UnionChampionDto(data);
  }

  //#endregion

  //#region 길드 정보 조회

  /**
   * 길드 식별자(oguild_id) 정보를 조회합니다.
   * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
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
    const { data } = await this.client.get<GuildBody>(path, {
      params: {
        guild_name: guildName,
        world_name: worldName,
      },
    });

    return new GuildDto(data);
  }

  /**
   * 길드 기본 정보를 조회합니다.
   * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
   * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
   * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
   * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
   *
   * @param guildId 길드 식별자
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getGuildBasic(
    guildId: string,
    dateOptions?: DateOptions,
  ): Promise<GuildBasicDto> {
    const path = 'maplestory/v1/guild/basic';
    const date = dateOptions
      ? toDateString(dateOptions, {
        year: 2023,
        month: 12,
        day: 21,
      })
      : undefined;
    const query: GuildApiQuery = {
      oguild_id: guildId,
      date: date,
    };
    const { data } = await this.client.get<GuildBasicBody>(path, {
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
    } else if (typeof parameter === 'object' || parameter === undefined) {
      query.date = toDateString(
        parameter ??
        getProperDefaultDateOptions({
          hour: 0,
          minute: 0,
          dateOffset: 0,
        }),
        {
          year: 2023,
          month: 12,
          day: 27,
        },
      );
    }

    const { data } = await this.client.get<StarforceHistoryResponseBody>(path, {
      params: query,
    });

    return new StarforceHistoryResponseDto(data);
  }

  /**
   * 큐브 사용 결과를 조회합니다.
   * - 큐브 확률 정보는 최대 30분 후 확인 가능합니다.
   * - 큐브 사용 결과는 최근 2년 데이터만 조회 가능합니다.
   *
   * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
   */
  public async getCubeHistory(count: number): Promise<CubeHistoryResponseDto>;

  /**
   * 지목한 날짜의 큐브 사용 결과를 조회합니다.
   * - 큐브 확률 정보는 최대 30분 후 확인 가능합니다.
   * - 큐브 사용 결과는 최근 2년 데이터만 조회 가능합니다.
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
   * - 큐브 확률 정보는 최대 30분 후 확인 가능합니다.
   * - 큐브 사용 결과는 최근 2년 데이터만 조회 가능합니다.
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
      query.date = toDateString(
        parameter ??
        getProperDefaultDateOptions({
          hour: 0,
          minute: 0,
          dateOffset: 0,
        })
      );
    }

    const { data } = await this.client.get<CubeHistoryResponseBody>(path, {
      params: query,
    });

    return new CubeHistoryResponseDto(data);
  }

  /**
   * 잠재능력 재설정 이용 결과를 조회합니다.
   * - 잠재능력 재설정 정보는 최대 30분 후 확인 가능합니다.
   * - 잠재능력 재설정 이용 결과는 2024년 01월 25일 데이터부터 조회 가능하며, 최대 2년동안의 데이터만 제공됩니다.
   *
   * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
   */
  public async getPotentialHistory(
    count: number,
  ): Promise<PotentialHistoryResponseDto>;

  /**
   * 지목한 날짜의 잠재능력 재설정 이용 결과를 조회합니다.
   * - 잠재능력 재설정 정보는 최대 30분 후 확인 가능합니다.
   * - 잠재능력 재설정 이용 결과는 2024년 01월 25일 데이터부터 조회 가능하며, 최대 2년동안의 데이터만 제공됩니다.
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
   * - 잠재능력 재설정 정보는 최대 30분 후 확인 가능합니다.
   * - 잠재능력 재설정 이용 결과는 2024년 01월 25일 데이터부터 조회 가능하며, 최대 2년동안의 데이터만 제공됩니다.
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
      query.date = toDateString(
        parameter ??
        getProperDefaultDateOptions({
          hour: 0,
          minute: 0,
          dateOffset: 0,
        }),
        {
          year: 2024,
          month: 1,
          day: 25,
        },
      );
    }

    const { data } = await this.client.get<PotentialHistoryResponseBody>(path, {
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
    dateOptions: DateOptions = getProperDefaultDateOptions({
      hour: 8,
      minute: 30,
      dateOffset: 0,
    }),
  ): Promise<OverallRankingResponseDto> {
    const path = 'maplestory/v1/ranking/overall';
    const query: OverallRankingApiQuery = {
      date: toDateString(dateOptions, {
          year: 2023,
          month: 12,
          day: 22,
      }),
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

    const { data } = await this.client.get<OverallRankingResponseBody>(path, {
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
    dateOptions: DateOptions = getProperDefaultDateOptions({
      hour: 8,
      minute: 30,
      dateOffset: 0,
    }),
  ): Promise<UnionRankingResponseDto> {
    const path = 'maplestory/v1/ranking/union';
    const query: UnionRankingApiQuery = {
      date: toDateString(dateOptions, {
        year: 2023,
        month: 12,
        day: 22,
      }),
    };

    if (filterOptions) {
      const { worldName, ocid, page } = filterOptions;

      query.world_name = worldName;
      query.ocid = ocid;
      query.page = page;
    }

    const { data } = await this.client.get<UnionRankingResponseBody>(path, {
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
    dateOptions: DateOptions = getProperDefaultDateOptions({
      hour: 8,
      minute: 30,
      dateOffset: 0,
    }),
  ): Promise<GuildRankingResponseDto> {
    const path = 'maplestory/v1/ranking/guild';
    const query: GuildRankingApiQuery = {
      date: toDateString(dateOptions, {
        year: 2023,
        month: 12,
        day: 22,
      }),
      ranking_type: 0,
    };

    if (filterOptions) {
      const { worldName, rankingType, ocid, page } = filterOptions;

      query.world_name = worldName;
      query.ranking_type = rankingType;
      query.ocid = ocid;
      query.page = page;
    }

    const { data } = await this.client.get<GuildRankingResponseBody>(path, {
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
    dateOptions: DateOptions = getProperDefaultDateOptions({
      hour: 8,
      minute: 30,
      dateOffset: 0,
    }),
  ): Promise<DojangRankingResponseDto> {
    const path = 'maplestory/v1/ranking/dojang';
    const query: DojangRankingApiQuery = {
      date: toDateString(dateOptions, {
        year: 2023,
        month: 12,
        day: 22,
      }),
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

    const { data } = await this.client.get<DojangRankingResponseBody>(path, {
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
    dateOptions: DateOptions = getProperDefaultDateOptions({
      hour: 8,
      minute: 30,
      dateOffset: 0,
    }),
  ): Promise<TheSeedRankingResponseDto> {
    const path = 'maplestory/v1/ranking/theseed';
    const query: TheSeedRankingApiQuery = {
      date: toDateString(dateOptions, {
        year: 2023,
        month: 12,
        day: 22,
      }),
    };

    if (filterOptions) {
      const { worldName, ocid, page } = filterOptions;

      query.world_name = worldName;
      query.ocid = ocid;
      query.page = page;
    }

    const { data } = await this.client.get<TheSeedRankingResponseBody>(path, {
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
    dateOptions: DateOptions = getProperDefaultDateOptions({
      hour: 8,
      minute: 30,
      dateOffset: 0,
    }),
  ): Promise<AchievementRankingResponseDto> {
    const path = 'maplestory/v1/ranking/achievement';
    const query: AchievementRankingApiQuery = {
      date: toDateString(dateOptions, {
        year: 2023,
        month: 12,
        day: 22,
      }),
    };

    if (filterOptions) {
      const { ocid, page } = filterOptions;

      query.ocid = ocid;
      query.page = page;
    }

    const { data } = await this.client.get<AchievementRankingResponseBody>(
      path,
      {
        params: query,
      },
    );

    return new AchievementRankingResponseDto(data);
  }

  //#endregion

  //#region 공지 정보 조회

  /**
   * 메이플스토리 공지사항에 최근 등록된 게시글 20개를 조회합니다.
   *
   * - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.
   * - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.
   */
  public async getNoticeList(): Promise<NoticeListDto> {
    const path = 'maplestory/v1/notice';

    const { data } = await this.client.get<NoticeListBody>(
      path,
    );

    return new NoticeListDto(data);
  }

  /**
   * 메이플스토리 공지사항 게시글 세부 사항을 조회합니다.
   *
   * - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.
   * - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.
   * @param noticeId 공지 식별자
   */
  public async getNoticeDetail(noticeId: number): Promise<NoticeDetailDto> {
    const path = 'maplestory/v1/notice/detail';
    const query: NoticeApiQuery = {
      notice_id: noticeId,
    };

    const { data } = await this.client.get<NoticeDetailBody>(
      path,
      {
        params: query,
      },
    );

    return new NoticeDetailDto(data);
  }

  /**
   * 메이플스토리 업데이트에 최근 등록된 게시글 20개를 조회합니다.
   *
   * - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.
   * - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.
   */
  public async getUpdateNoticeList(): Promise<UpdateNoticeListDto> {
    const path = 'maplestory/v1/notice-update';

    const { data } = await this.client.get<UpdateNoticeListBody>(
      path,
    );

    return new UpdateNoticeListDto(data);
  }

  /**
   * 메이플스토리 업데이트 게시글 세부 사항을 조회합니다.
   *
   * - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.
   * - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.
   * @param noticeId 공지 식별자
   */
  public async getUpdateNoticeDetail(noticeId: number): Promise<UpdateNoticeDetailDto> {
    const path = 'maplestory/v1/notice-update/detail';
    const query: NoticeApiQuery = {
      notice_id: noticeId,
    };

    const { data } = await this.client.get<UpdateNoticeDetailBody>(
      path,
      {
        params: query,
      },
    );

    return new UpdateNoticeDetailDto(data);
  }

  /**
   * 메이플스토리 진행 중 이벤트에 최근 등록된 공지사항 20개를 조회합니다.
   *
   * - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.
   * - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.
   */
  public async getEventNoticeList(): Promise<EventNoticeListDto> {
    const path = 'maplestory/v1/notice-event';

    const { data } = await this.client.get<EventNoticeListBody>(
      path,
    );

    return new EventNoticeListDto(data);
  }

  /**
   * 메이플스토리 진행 중 이벤트 게시글 세부 사항을 조회합니다.
   *
   * - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.
   * - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.
   * @param noticeId 공지 식별자
   */
  public async getEventNoticeDetail(noticeId: number): Promise<EventNoticeDetailDto> {
    const path = 'maplestory/v1/notice-event/detail';
    const query: NoticeApiQuery = {
      notice_id: noticeId,
    };

    const { data } = await this.client.get<EventNoticeDetailBody>(
      path,
      {
        params: query,
      },
    );

    return new EventNoticeDetailDto(data);
  }

  /**
   * 메이플스토리 캐시샵 공지에 최근 등록된 공지사항 20개를 조회합니다.
   *
   * - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.
   * - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.
   */
  public async getCashshopNoticeList(): Promise<CashshopNoticeListDto> {
    const path = 'maplestory/v1/notice-cashshop';

    const { data } = await this.client.get<CashshopNoticeListBody>(
      path,
    );

    return new CashshopNoticeListDto(data);
  }

  /**
   * 메이플스토리 캐시샵 공지 게시글 세부 사항을 조회합니다.
   *
   * - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.
   * - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.
   * @param noticeId 공지 식별자
   */
  public async getCashshopNoticeDetail(noticeId: number): Promise<CashshopNoticeDetailDto> {
    const path = 'maplestory/v1/notice-cashshop/detail';
    const query: NoticeApiQuery = {
      notice_id: noticeId,
    };

    const { data } = await this.client.get<CashshopNoticeDetailBody>(
      path,
      {
        params: query,
      },
    );

    return new CashshopNoticeDetailDto(data);
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
}

const KST_OFFSET = 540;

/**
 * API 서버의 데이터 갱신 시간에 따라 데이터가 조회 가능한 최신 날짜를 반환합니다.
 *
 * @param options
 */
const getProperDefaultDateOptions = (
  options: LatestApiUpdateTimeOptions,
): DateOptions => {
  const { hour, minute, dateOffset } = options;

  const kstNow = dayjs().utcOffset(KST_OFFSET);
  const updateDate = dayjs()
    .utcOffset(KST_OFFSET)
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
 * @param dateOptions 조회 하려는 날짜
 * @param minDateOptions API 호출 가능한 최소 날짜
 */
const toDateString = (
  dateOptions: DateOptions,
  minDateOptions?: DateOptions,
): string | never => {

  const convert = (dateOptions: DateOptions) => {
    let year: number;
    let month: number;
    let day: number;
    let d: Dayjs;

    if (dateOptions instanceof Date) {
      d = dayjs(dateOptions).utcOffset(KST_OFFSET);
      year = d.year();
      month = d.month() + 1;
      day = d.date();
    } else {
      year = dateOptions.year;
      month = dateOptions.month;
      day = dateOptions.day;
      d = dayjs(`${year}-${month}-${day}`).utcOffset(KST_OFFSET);
    }

    return {
      year,
      month,
      day,
      d,
    }
  }
  const { year, month, day, d } = convert(dateOptions);

  const str = d.format('YYYY-MM-DD');

  if (minDateOptions) {
    const { year: minYear, month: minMonth, day: minDay } = convert(minDateOptions);

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
  }

  return str;
}


type CharacterImageOptions = {
  /**
   * 캐릭터 액션
   */
  action?: CharacterImageAction,
  /**
   * 캐릭터 감정표현
   */
  emotion?: CharacterImageEmotion,
  /**
   * 캐릭터 무기 모션
   */
  wmotion?: CharacterImageWeaponMotion,
  /**
   * 캐릭터 액션 프레임.
   */
  actionFrame?: number;
  /**
   * 캐릭터 감정표현 프레임
   */
  emotionFrame?: number;
  /**
   * 가로 길이. 배경 크기에 해당함, 96 (default) ~ 1000
   */
  width?: number,
  /**
   * 세로 길이. 배경 크기에 해당함, 96 (default) ~ 1000
   */
  height?: number,
  /**
   * 캐릭터의 가로 좌표
   */
  x?: number,
  /**
   * 캐릭터의 세로 좌표.
   */
  y?: number,
};

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
   * - 에오스
   * - 헬리오스
   * - 버닝
   * - 버닝2
   * - 버닝3
   */
  worldName?: string;

  /**
   * 월드 타입 (0:일반, 1:에오스,헬리오스) (기본 값은 0이며, world_name 입력 시 미 반영)
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
   * - 에오스
   * - 헬리오스
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
   * - 에오스
   * - 헬리오스
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
   * - 에오스
   * - 헬리오스
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
   * - 에오스
   * - 헬리오스
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

type YMD = {
  year: number;
  month: number;
  day: number;
};

/**
 * 날짜 옵션
 * - Date 객체 또는 YMD 형식의 객체를 사용할 수 있습니다.
 * - 날짜는 해당 서비스 지역의 표준 시를 사용 합니다.
 * - Date 객체의 offset이 해당 서비스 지역의 offset과 다를 경우 자동으로 변환 됩니다.
 */
type DateOptions = YMD | Date;

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
  date?: string;
};

type CharacterSkillApiQuery = {
  ocid: string;
  date?: string;
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
  date?: string;
};

type GuildApiQuery = {
  oguild_id: string;
  date?: string;
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

type NoticeApiQuery = {
  notice_id: number;
};

type MapleStoryErrorBody = {
  error: {
    name: string;
    message: string;
  };
};

export { MapleStoryApi, MapleStoryErrorBody };
