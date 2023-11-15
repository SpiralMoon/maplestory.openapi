import {MapleStoryApi, MapleStoryApiError} from "../src";
import {CubeHistoryResponseDto} from "../types";

const apiKey: string = '{Your API Key}';
const api: MapleStoryApi = new MapleStoryApi(apiKey);

api.getCubeResult(1000, {
	year: 2023,
	month: 10,
	day: 15
})
	.then((dto: CubeHistoryResponseDto) => {
		const {count, cubeHistories, nextCursor} = dto;

		console.log('You used ' + count + ' cubes.');
	})
	.catch((e) => {
		if (e instanceof MapleStoryApiError) {
			// handle MapleStoryApiError
		} else {
			// handle
		}

		console.log(e);
	});

