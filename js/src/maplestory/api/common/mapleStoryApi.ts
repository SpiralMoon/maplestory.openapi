import axios, { Axios, AxiosError } from 'axios';
import dayjs, { Dayjs } from 'dayjs';
import timezone from 'dayjs/plugin/timezone';
import utc from 'dayjs/plugin/utc';

import { CharacterDto } from './dto/character/character';
import { CharacterAbilityDto } from './dto/character/characterAbility';
import { CharacterAndroidEquipmentDto } from './dto/character/characterAndroidEquipment';
import { CharacterBasicDto } from './dto/character/characterBasic';
import { CharacterBeautyEquipmentDto } from './dto/character/characterBeautyEquipment';
import { CharacterCashItemEquipmentDto } from './dto/character/characterCashItemEquipment';
import { CharacterDojangDto } from './dto/character/characterDojang';
import { CharacterHexaMatrixDto } from './dto/character/characterHexaMatrix';
import { CharacterHexaMatrixStatDto } from './dto/character/characterHexaMatrixStat';
import { CharacterHyperStatDto } from './dto/character/characterHyperStat';
import { CharacterImageDto } from './dto/character/characterImage';
import { CharacterItemEquipmentDto } from './dto/character/characterItemEquipment';
import { CharacterLinkSkillDto } from './dto/character/characterLinkSkill';
import { CharacterPetEquipmentDto } from './dto/character/characterPetEquipment';
import { CharacterPopularityDto } from './dto/character/characterPopularity';
import { CharacterPropensityDto } from './dto/character/characterPropensity';
import { CharacterSetEffectDto } from './dto/character/characterSetEffect';
import { CharacterSkillDto } from './dto/character/characterSkill';
import { CharacterStatDto } from './dto/character/characterStat';
import { CharacterSymbolEquipmentDto } from './dto/character/characterSymbolEquipment';
import { CharacterVMatrixDto } from './dto/character/characterVMatrix';
import { GuildDto } from './dto/guild/guild';
import { GuildBasicDto } from './dto/guild/guildBasic';
import { UnionDto } from './dto/union/union';
import { UnionArtifactDto } from './dto/union/unionArtifact';
import { UnionRaiderDto } from './dto/union/unionRaider';
import { CharacterImageAction, CharacterImageEmotion, CharacterImageWeaponMotion } from './enum/characterImage';
import { MapleStoryApiError } from './mapleStoryApiError';
import { MapleStoryErrorBody } from './mapleStoryApiErrorBody';

dayjs.extend(timezone);
dayjs.extend(utc);

/**
 * MapleStory OpenAPI client.
 */
export abstract class MapleStoryApi {
  private readonly apiKey: string;

  protected readonly client: Axios;

  private static readonly BASE_URL: string = 'https://open.api.nexon.com/';

  private static readonly DEFAULT_TIMEOUT: number = 5000;

  protected abstract subUrl: string;

  protected abstract timezoneOffset: number;

  public get timeout() {
    return this.client.defaults.timeout!;
  }

  public set timeout(value: number) {
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
          const errorBody = (error as AxiosError<MapleStoryErrorBody>).response!
            .data;

          throw new MapleStoryApiError(errorBody);
        }

        throw error;
      },
    );
  }

  //#region Character Information Retrieval

  public abstract getCharacter(characterName: string): Promise<CharacterDto>;
  public abstract getCharacterBasic(ocid: string, dateOptions?: DateOptions): Promise<CharacterBasicDto>;
  public abstract getCharacterImage(ocid: string, imageOptions?: CharacterImageOptions, dateOptions?: DateOptions): Promise<CharacterImageDto>;
  public abstract getCharacterPopularity(ocid: string, dateOptions?: DateOptions): Promise<CharacterPopularityDto>;
  public abstract getCharacterStat(ocid: string, dateOptions?: DateOptions): Promise<CharacterStatDto>;
  public abstract getCharacterHyperStat(ocid: string, dateOptions?: DateOptions): Promise<CharacterHyperStatDto>;
  public abstract getCharacterPropensity(ocid: string, dateOptions?: DateOptions): Promise<CharacterPropensityDto>;
  public abstract getCharacterAbility(ocid: string, dateOptions?: DateOptions): Promise<CharacterAbilityDto>;
  public abstract getCharacterItemEquipment(ocid: string, dateOptions?: DateOptions): Promise<CharacterItemEquipmentDto>;
  public abstract getCharacterCashItemEquipment(ocid: string, dateOptions?: DateOptions): Promise<CharacterCashItemEquipmentDto>;
  public abstract getCharacterSymbolEquipment(ocid: string, dateOptions?: DateOptions): Promise<CharacterSymbolEquipmentDto>;
  public abstract getCharacterSetEffect(ocid: string, dateOptions?: DateOptions): Promise<CharacterSetEffectDto>;
  public abstract getCharacterBeautyEquipment(ocid: string, dateOptions?: DateOptions): Promise<CharacterBeautyEquipmentDto>;
  public abstract getCharacterAndroidEquipment(ocid: string, dateOptions?: DateOptions): Promise<CharacterAndroidEquipmentDto>;
  public abstract getCharacterPetEquipment(ocid: string, dateOptions?: DateOptions): Promise<CharacterPetEquipmentDto>;
  public abstract getCharacterSkill(ocid: string, characterSkillGrade: string, dateOptions?: DateOptions): Promise<CharacterSkillDto>;
  public abstract getCharacterLinkSkill(ocid: string, dateOptions?: DateOptions): Promise<CharacterLinkSkillDto>;
  public abstract getCharacterVMatrix(ocid: string, dateOptions?: DateOptions): Promise<CharacterVMatrixDto>;
  public abstract getCharacterHexaMatrix(ocid: string, dateOptions?: DateOptions): Promise<CharacterHexaMatrixDto>;
  public abstract getCharacterHexaMatrixStat(ocid: string, dateOptions?: DateOptions): Promise<CharacterHexaMatrixStatDto>;
  public abstract getCharacterDojang(ocid: string, dateOptions?: DateOptions): Promise<CharacterDojangDto>;

  //#endregion

  //#region Union Information Retrieval

  public abstract getUnion(ocid: string, dateOptions?: DateOptions): Promise<UnionDto>;
  public abstract getUnionRaider(ocid: string, dateOptions?: DateOptions): Promise<UnionRaiderDto>;
  public abstract getUnionArtifact(ocid: string, dateOptions?: DateOptions): Promise<UnionArtifactDto>;

  //#endregion

  //#region Guild Information Retrieval

  public abstract getGuild(guildName: string, worldName: string): Promise<GuildDto>;
  public abstract getGuildBasic(guildId: string, dateOptions?: DateOptions): Promise<GuildBasicDto>;

  //#endregion

  /**
   * API 서버의 데이터 갱신 시간에 따라 데이터가 조회 가능한 최신 날짜를 반환합니다.
   *
   * @param options
   */
  protected getProperDefaultDateOptions (
    options: LatestApiUpdateTimeOptions,
  ): DateOptions {
    const { hour, minute, dateOffset } = options;

    const nowInTimezone = dayjs().utcOffset(this.timezoneOffset);
    const updateDate = dayjs().utcOffset(this.timezoneOffset).hour(hour).minute(minute);

    let adjustedDate: Dayjs;

    if (nowInTimezone.isAfter(updateDate)) {
      adjustedDate = nowInTimezone;
    } else {
      adjustedDate = nowInTimezone.subtract(1, 'day');
    }

    adjustedDate = adjustedDate.subtract(dateOffset ?? 0, 'day');

    return {
      year: adjustedDate.year(),
      month: adjustedDate.month() + 1,
      day: adjustedDate.date(),
    };
  };

  /**
   * 날짜 정보를 API 서버에서 요구하는 포맷으로 변환합니다.
   *
   * @param dateOptions 조회 하려는 날짜
   * @param minDateOptions API 호출 가능한 최소 날짜
   */
  protected toDateString (
    dateOptions: DateOptions,
    minDateOptions?: DateOptions,
  ): string | never {
    const convert = (dateOptions: DateOptions) => {
      let year: number;
      let month: number;
      let day: number;
      let d: Dayjs;

      if (dateOptions instanceof Date) {
        d = dayjs(dateOptions).utcOffset(this.timezoneOffset);
        year = d.year();
        month = d.month() + 1;
        day = d.date();
      } else {
        year = dateOptions.year;
        month = dateOptions.month;
        day = dateOptions.day;
        d = dayjs(`${year}-${month}-${day}`).utcOffset(this.timezoneOffset);
      }

      return {
        year,
        month,
        day,
        d,
      };
    };
    const { year, month, day, d } = convert(dateOptions);

    const str = d.format('YYYY-MM-DD');

    if (minDateOptions) {
      const {
        year: minYear,
        month: minMonth,
        day: minDay,
      } = convert(minDateOptions);

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
  };
}

/**
 * API 서버의 데이터 갱신 시각과 조회 가능한 최근 날짜와 현재 날짜와의 차이
 */
type LatestApiUpdateTimeOptions = {
  hour: number;
  minute: number;
  dateOffset?: number;
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
export type DateOptions = YMD | Date;

type CharacterImageOptions = {
  /**
   * Character action
   */
  action?: CharacterImageAction;
  /**
   * Character emotion
   */
  emotion?: CharacterImageEmotion;
  /**
   * Character weapon motion
   */
  wmotion?: CharacterImageWeaponMotion;
  /**
   * Character action frame
   */
  actionFrame?: number;
  /**
   * Character emotion frame
   */
  emotionFrame?: number;
  /**
   * Horizontal length (corresponding to the background size, 96 (default) ~ 1000)
   */
  width?: number;
  /**
   * Vertical length (corresponding to the background size, 96 (default) ~ 1000)
   */
  height?: number;
  /**
   * Horizontal coordinate of the character (coordinate range 0 < x < width, 0 is the left starting point)
   */
  x?: number;
  /**
   * Vertical coordinate of the character (coordinate range 0 < y < height, 0 is the top starting point)
   */
  y?: number;
};

