const {MapleStoryApi, MapleStoryApiError} = require('../dist');

const apiKey = '{Your API Key}';
const api = new MapleStoryApi(apiKey);

api.getCubeResult(1000, {
	year: 2023,
	month: 10,
	day: 15
})
	.then((dto) => {
		const {count, cubeHistory, nextCursor} = dto;

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

