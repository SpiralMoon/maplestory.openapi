import {CubeHistoryResponseDto} from "./dto/cubeHistoryResponseDto";
import {MapleStoryApiError} from "./mapleStoryApiError";
import {CubeHistoryResponseDtoBody} from "./response/cubeHistoryResponseDtoBody";

import axios, {AxiosError} from "axios";
import dayjs from "dayjs";
import timezone from "dayjs/plugin/timezone";
import utc from "dayjs/plugin/utc";

dayjs.extend(timezone);
dayjs.extend(utc);

class MapleStoryApi {

	private readonly apiKey: string;

	private static baseUrl: string = 'https://public.api.nexon.com/';

	private static kstOffset: number = 540;

	public timeout: number;

	public constructor(apiKey: string) {
		this.apiKey = apiKey;
		this.timeout = 5000;
	}

	/**
	 * 오늘 날짜의 확률형 아이템 큐브의 사용 결과를 조회합니다.<br>
	 * 데이터는 일단위로 갱신되며, 오전 4시 조회 시 전일 데이터를 조회할 수 있습니다.<br>
	 * 데이터는 2022년 11월 25일부터 조회할 수 있습니다.<br>
	 *
	 * @param count 한번에 가져오려는 결과의 갯수(최소 10, 최대 1000) Default value : 10
	 */
	public async getCubeResult(count: number): Promise<CubeHistoryResponseDto>;

	/**
	 * 지목한 날짜의 확률형 아이템 큐브의 사용 결과를 조회합니다.<br>
	 * 데이터는 일단위로 갱신되며, 오전 4시 조회 시 전일 데이터를 조회할 수 있습니다.<br>
	 * 데이터는 2022년 11월 25일부터 조회할 수 있습니다.<br>
	 *
	 * @param count 한번에 가져오려는 결과의 갯수(최소 10, 최대 1000) Default value : 10
	 * @param dateOptions 조회할 연월일 날짜 정보
	 */
	public async getCubeResult(count: number, dateOptions: DateOptions): Promise<CubeHistoryResponseDto>;

	/**
	 * 확률형 아이템 큐브의 사용 결과를 조회합니다.<br>
	 * 데이터는 일단위로 갱신되며, 오전 4시 조회 시 전일 데이터를 조회할 수 있습니다.<br>
	 * 데이터는 2022년 11월 25일부터 조회할 수 있습니다.<br>
	 *
	 * @param count 한번에 가져오려는 결과의 갯수(최소 10, 최대 1000) Default value : 10
	 * @param cursor
	 */
	public async getCubeResult(count: number, cursor: string): Promise<CubeHistoryResponseDto>;

	public async getCubeResult(count: number, parameter?: DateOptions | string): Promise<CubeHistoryResponseDto> {

		const query: CubeApiQuery = {
			count,
		};

		if (typeof parameter === 'string') {
			query.cursor = parameter;
		} else if (typeof parameter === 'object') {
			const {year, month, day} = parameter;

			if (year <= 2022 && month <= 11 && day < 25) {
				throw new Error('You can only retrieve data after 2022-11-25.');
			}

			const date = dayjs(`${year}-${month}-${day}`).utcOffset(MapleStoryApi.kstOffset);
			query.date = date.format('YYYY-MM-DD')
		} else {
			const now = dayjs().utcOffset(MapleStoryApi.kstOffset);
			query.date = now.format('YYYY-MM-DD');
		}

		try {
			const path = 'openapi/maplestory/v1/cube-use-results';
			const response = await axios.get<CubeHistoryResponseDtoBody>(path, {
				baseURL: MapleStoryApi.baseUrl,
				timeout: this.timeout,
				headers: this.buildHeaders(),
				params: query
			});

			return new CubeHistoryResponseDto(response.data);
		} catch (e: any) {
			if (e instanceof AxiosError) {
				const errorBody = (e as AxiosError<MapleStoryErrorBody>).response!.data;

				throw new MapleStoryApiError(errorBody);
			}

			throw e;
		}
	}

	private buildHeaders(): { [key: string]: string } {
		return {
			'authorization': this.apiKey
		}
	}
}

type DateOptions = {
	year: number;
	month: number;
	day: number;
}

type CubeApiQuery = {
	count: number;
	date?: string;
	cursor?: string;
}

type MapleStoryErrorBody = {
	status: number;
	message: string;
}

export {MapleStoryApi}
