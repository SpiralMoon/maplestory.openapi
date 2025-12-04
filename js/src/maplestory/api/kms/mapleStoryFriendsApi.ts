import { CubeHistoryResponseDto } from './dto/history/cubeHistory';
import { PotentialHistoryResponseDto } from './dto/history/potentialHistory';
import { StarforceHistoryResponseDto } from './dto/history/starforceHistory';
import { AchievementDto } from './dto/user/achievement';
import { CharacterListDto } from './dto/user/characterList';
import { CubeHistoryResponseBody } from './response/history/cubeHistoryBody';
import { PotentialHistoryResponseBody } from './response/history/potentialHistoryBody';
import { StarforceHistoryResponseBody } from './response/history/starforceHistoryBody';
import { AchievementBody } from './response/user/achievementBody';
import { CharacterListBody } from './response/user/characterListBody';
import { DateOptions } from '../common/mapleStoryFriendsApi';
import * as base from '../common/mapleStoryFriendsApi';

/**
 * MapleStory Friends API client for KMS<br>
 * This is an implementation of <a href="https://openapi.nexon.com/ko/friends/maplestory/?id=36">MapleStory Friends API</a>
 */
export class MapleStoryFriendsApi extends base.MapleStoryFriendsApi {

  protected override subUrl: string = 'maplestory';

  protected override timezoneOffset: number = 540;

  public constructor(accessToken: string) {
    super(accessToken);
  }

  //#region 계정 정보 조회

  /**
   * 계정의 보유 캐릭터 목록을 조회합니다.
   * - 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '캐릭터 목록'을 활용 데이터 항목으로 선택해주세요.
   * - 이후 자세한 데이터 호출 및 활용 방법은 <a href="https://openapi.nexon.com/ko/open-id/development-guide/">NEXON Open ID 개발 가이드 문서</a>를 참조해주세요.
   */
  public async getCharacterList(): Promise<CharacterListDto> {
    const path = `${this.subUrl}/v1/character/list`;
    const { data } = await this.client.get<CharacterListBody>(path);

    return new CharacterListDto(data);
  }

  /**
   * 계정의 업적 정보를 조회합니다.
   * - 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '업적 정보'를 활용 데이터 항목으로 선택해주세요.
   * - 이후 자세한 데이터 호출 및 활용 방법은 <a href="https://openapi.nexon.com/ko/open-id/development-guide/">NEXON Open ID 개발 가이드 문서</a>를 참조해주세요.
   */
  public async getAchievement(): Promise<AchievementDto> {
    const path = `${this.subUrl}/v1/user/achievement`;
    const { data } = await this.client.get<AchievementBody>(path);

    return new AchievementDto(data);
  }

  //#endregion

  //#region 확률 정보 조회

  /**
   * 스타포스 강화 결과를 조회합니다.
   * - 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '스타포스 강화 결과'를 활용 데이터 항목으로 선택해주세요.
   * - 이후 자세한 데이터 호출 및 활용 방법은 <a href="https://openapi.nexon.com/ko/open-id/development-guide/">NEXON Open ID 개발 가이드 문서</a>를 참조해주세요.
   * - 스타포스 확률 정보는 최대 5분 후 확인 가능합니다.
   * - 스타포스 강화 결과는 2023년 12월 27일 데이터부터 조회 가능하며, 최대 2년동안의 데이터만 제공됩니다.
   * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
   */
  public async getStarforceHistory(
    count: number,
  ): Promise<StarforceHistoryResponseDto>;

  /**
   * 지목한 날짜의 스타포스 강화 결과를 조회합니다.
   * - 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '스타포스 강화 결과'를 활용 데이터 항목으로 선택해주세요.
   * - 이후 자세한 데이터 호출 및 활용 방법은 <a href="https://openapi.nexon.com/ko/open-id/development-guide/">NEXON Open ID 개발 가이드 문서</a>를 참조해주세요.
   * - 스타포스 확률 정보는 최대 5분 후 확인 가능합니다.
   * - 스타포스 강화 결과는 2023년 12월 27일 데이터부터 조회 가능하며, 최대 2년동안의 데이터만 제공됩니다.
   * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getStarforceHistory(
    count: number,
    dateOptions: DateOptions,
  ): Promise<StarforceHistoryResponseDto>;

  /**
   * 스타포스 강화 결과를 조회합니다.
   * - 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '스타포스 강화 결과'를 활용 데이터 항목으로 선택해주세요.
   * - 이후 자세한 데이터 호출 및 활용 방법은 <a href="https://openapi.nexon.com/ko/open-id/development-guide/">NEXON Open ID 개발 가이드 문서</a>를 참조해주세요.
   * - 스타포스 확률 정보는 최대 5분 후 확인 가능합니다.
   * - 스타포스 강화 결과는 2023년 12월 27일 데이터부터 조회 가능하며, 최대 2년동안의 데이터만 제공됩니다.
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
    const path = `${this.subUrl}/v1/history/starforce`;
    const query: StarforceApiQuery = {
      count,
    };

    if (typeof parameter === 'string') {
      query.cursor = parameter;
    } else if (typeof parameter === 'object' || parameter === undefined) {
      query.date = this.toDateString(
        parameter ??
          this.getProperDefaultDateOptions({
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
   * - 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '큐브 사용 결과'를 활용 데이터 항목으로 선택해주세요.
   * - 이후 자세한 데이터 호출 및 활용 방법은 <a href="https://openapi.nexon.com/ko/open-id/development-guide/">NEXON Open ID 개발 가이드 문서</a>를 참조해주세요.
   * - 큐브 확률 정보는 최대 30분 후 확인 가능합니다.
   * - 큐브 사용 결과는 최근 2년 데이터만 조회 가능합니다.
   * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000). 옵션 재설정을 3회 진행한 결과가 포함될 경우 입력한 count보다 적은 수로 조회될 수 있습니다.
   */
  public async getCubeHistory(count: number): Promise<CubeHistoryResponseDto>;

  /**
   * 지목한 날짜의 큐브 사용 결과를 조회합니다.
   * - 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '큐브 사용 결과'를 활용 데이터 항목으로 선택해주세요.
   * - 이후 자세한 데이터 호출 및 활용 방법은 <a href="https://openapi.nexon.com/ko/open-id/development-guide/">NEXON Open ID 개발 가이드 문서</a>를 참조해주세요.
   * - 큐브 확률 정보는 최대 30분 후 확인 가능합니다.
   * - 큐브 사용 결과는 최근 2년 데이터만 조회 가능합니다.
   * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000). 옵션 재설정을 3회 진행한 결과가 포함될 경우 입력한 count보다 적은 수로 조회될 수 있습니다.
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getCubeHistory(
    count: number,
    dateOptions: DateOptions,
  ): Promise<CubeHistoryResponseDto>;

  /**
   * 큐브 사용 결과를 조회합니다.
   * - 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '큐브 사용 결과'를 활용 데이터 항목으로 선택해주세요.
   * - 이후 자세한 데이터 호출 및 활용 방법은 <a href="https://openapi.nexon.com/ko/open-id/development-guide/">NEXON Open ID 개발 가이드 문서</a>를 참조해주세요.
   * - 큐브 확률 정보는 최대 30분 후 확인 가능합니다.
   * - 큐브 사용 결과는 최근 2년 데이터만 조회 가능합니다.
   * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000). 옵션 재설정을 3회 진행한 결과가 포함될 경우 입력한 count보다 적은 수로 조회될 수 있습니다.
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
    const path = `${this.subUrl}/v1/history/cube`;
    const query: CubeApiQuery = {
      count,
    };

    if (typeof parameter === 'string') {
      query.cursor = parameter;
    } else if (typeof parameter === 'object' || parameter === undefined) {
      query.date = this.toDateString(
        parameter ??
          this.getProperDefaultDateOptions({
            hour: 0,
            minute: 0,
            dateOffset: 0,
          }),
      );
    }

    const { data } = await this.client.get<CubeHistoryResponseBody>(path, {
      params: query,
    });

    return new CubeHistoryResponseDto(data);
  }

  /**
   * 잠재능력 재설정 이용 결과를 조회합니다.
   * - 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '잠재능력 재설정 이용 결과'를 활용 데이터 항목으로 선택해주세요.
   * - 이후 자세한 데이터 호출 및 활용 방법은 <a href="https://openapi.nexon.com/ko/open-id/development-guide/">NEXON Open ID 개발 가이드 문서</a>를 참조해주세요.
   * - 잠재능력 재설정 정보는 최대 30분 후 확인 가능합니다.
   * - 잠재능력 재설정 이용 결과는 2024년 01월 25일 데이터부터 조회 가능하며, 최대 2년동안의 데이터만 제공됩니다.
   * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000). 옵션 재설정을 3회 진행한 결과가 포함될 경우 입력한 count보다 적은 수로 조회될 수 있습니다.
   */
  public async getPotentialHistory(
    count: number,
  ): Promise<PotentialHistoryResponseDto>;

  /**
   * 지목한 날짜의 잠재능력 재설정 이용 결과를 조회합니다.
   * - 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '잠재능력 재설정 이용 결과'를 활용 데이터 항목으로 선택해주세요.
   * - 이후 자세한 데이터 호출 및 활용 방법은 <a href="https://openapi.nexon.com/ko/open-id/development-guide/">NEXON Open ID 개발 가이드 문서</a>를 참조해주세요.
   * - 잠재능력 재설정 정보는 최대 30분 후 확인 가능합니다.
   * - 잠재능력 재설정 이용 결과는 2024년 01월 25일 데이터부터 조회 가능하며, 최대 2년동안의 데이터만 제공됩니다.
   * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000). 옵션 재설정을 3회 진행한 결과가 포함될 경우 입력한 count보다 적은 수로 조회될 수 있습니다.
   * @param dateOptions 조회 기준일 (KST)
   */
  public async getPotentialHistory(
    count: number,
    dateOptions: DateOptions,
  ): Promise<PotentialHistoryResponseDto>;

  /**
   * 잠재능력 재설정 이용 결과를 조회합니다.
   * - 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '잠재능력 재설정 이용 결과'를 활용 데이터 항목으로 선택해주세요.
   * - 이후 자세한 데이터 호출 및 활용 방법은 <a href="https://openapi.nexon.com/ko/open-id/development-guide/">NEXON Open ID 개발 가이드 문서</a>를 참조해주세요.
   * - 잠재능력 재설정 정보는 최대 30분 후 확인 가능합니다.
   * - 잠재능력 재설정 이용 결과는 2024년 01월 25일 데이터부터 조회 가능하며, 최대 2년동안의 데이터만 제공됩니다.
   * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000). 옵션 재설정을 3회 진행한 결과가 포함될 경우 입력한 count보다 적은 수로 조회될 수 있습니다.
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
    const path = `${this.subUrl}/v1/history/potential`;
    const query: PotentialApiQuery = {
      count,
    };

    if (typeof parameter === 'string') {
      query.cursor = parameter;
    } else if (typeof parameter === 'object' || parameter === undefined) {
      query.date = this.toDateString(
        parameter ??
          this.getProperDefaultDateOptions({
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
}

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
