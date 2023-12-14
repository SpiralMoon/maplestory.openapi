import {CubeHistoryResponseDto} from "./dto/cubeHistoryResponseDto";
import {InspectionInfoDto} from "./dto/inspectionInfoDto";
import {MapleStoryApiError} from "./mapleStoryApiError";
import {CubeHistoryResponseDtoBody} from "./response/cubeHistoryResponseDtoBody";
import {InspectionInfoSoapBody} from "./response/inspectionInfoSoapBody";

import axios, {AxiosError} from "axios";
import dayjs from "dayjs";
import timezone from "dayjs/plugin/timezone";
import utc from "dayjs/plugin/utc";
import xml2js from 'xml2js';

dayjs.extend(timezone);
dayjs.extend(utc);

/**
 * MapleStory OpenAPI client.<br>
 * This is an implementation of <a href="https://openapi.nexon.com/game/maplestory">MapleStory API</a>
 */
class MapleStoryApi {

	private readonly apiKey: string;

	private static BASE_URL: string = 'https://open.api.nexon.com/';

	private static kstOffset: number = 540;

	public timeout: number;

	public constructor(apiKey: string) {
		this.apiKey = apiKey;
		this.timeout = 5000;
	}

	/**
	 * 오늘 날짜의 큐브 사용 결과를 조회합니다.<br>
	 * 큐브 사용 결과 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.<br>
	 * 큐브 사용 결과 데이터는 2022년 11월 25일부터 조회할 수 있습니다.<br>
	 * e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.<br>
	 *
	 * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
	 */
	public async getCubeResult(count: number): Promise<CubeHistoryResponseDto>;

	/**
	 * 지목한 날짜의 큐브 사용 결과를 조회합니다.<br>
	 * 큐브 사용 결과 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.<br>
	 * 큐브 사용 결과 데이터는 2022년 11월 25일부터 조회할 수 있습니다.<br>
	 * e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.<br>
	 *
	 * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
	 * @param dateOptions 조회 기준일 (KST)
	 */
	public async getCubeResult(count: number, dateOptions: DateOptions): Promise<CubeHistoryResponseDto>;

	/**
	 * 큐브 사용 결과를 조회합니다.<br>
	 * 큐브 사용 결과 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.<br>
	 * 큐브 사용 결과 데이터는 2022년 11월 25일부터 조회할 수 있습니다.<br>
	 * e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.<br>
	 *
	 * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
	 * @param cursor 페이징 처리를 위한 cursor
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
			query.date_kst = date.format('YYYYMMDD')
		} else {
			const now = dayjs().utcOffset(MapleStoryApi.kstOffset);
			query.date_kst = now.format('YYYYMMDD');
		}

		try {
			const path = 'maplestory/v1/history/cube';
			const response = await axios.get<CubeHistoryResponseDtoBody>(path, {
				baseURL: MapleStoryApi.BASE_URL,
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
					'xmlns:soap': 'http://schemas.xmlsoap.org/soap/envelope/'
				},
				'soap:Body': {
					'GetInspectionInfo': {
						$: {
							'xmlns': 'https://api.maplestory.nexon.com/soap/'
						}
					}
				}
			}
		};

		const baseUrl = 'https://api.maplestory.nexon.com/';
		const path = 'soap/maplestory.asmx'
		const headers = {
			'SOAPAction': 'https://api.maplestory.nexon.com/soap/GetInspectionInfo',
			'Content-Type': 'text/xml; charset=utf-8'
		};
		const body = xmlBuilder.buildObject(soapEnvelop);

		const response = await axios.post<string>(path, body, {
			baseURL: baseUrl,
			timeout: this.timeout,
			headers,
		});

		const xml = await xml2js.parseStringPromise(response.data) as InspectionInfoSoapBody;

		return new InspectionInfoDto(xml);
	}

	private buildHeaders(): { [key: string]: string } {
		return {
			'x-nxopen-api-key': this.apiKey
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
	date_kst?: string;
	cursor?: string;
}

type MapleStoryErrorBody = {
	error: {
		name: string;
		message: string;
	}
}

export {MapleStoryApi, MapleStoryErrorBody}
