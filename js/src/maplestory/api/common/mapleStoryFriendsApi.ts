import axios, { Axios, AxiosError } from 'axios';
import dayjs, { Dayjs } from 'dayjs';
import timezone from 'dayjs/plugin/timezone';
import utc from 'dayjs/plugin/utc';

import { MapleStoryApiError } from './mapleStoryApiError';
import { MapleStoryErrorBody } from './mapleStoryApiErrorBody';

dayjs.extend(timezone);
dayjs.extend(utc);

/**
 * MapleStory Friends API client.
 */
export abstract class MapleStoryFriendsApi {
  private readonly accessToken: string;

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

  public constructor(accessToken: string) {
    this.accessToken = accessToken;
    this.client = axios.create({
      baseURL: MapleStoryFriendsApi.BASE_URL,
      timeout: MapleStoryFriendsApi.DEFAULT_TIMEOUT,
      headers: {
        'Authorization': `Bearer ${this.accessToken}`,
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
