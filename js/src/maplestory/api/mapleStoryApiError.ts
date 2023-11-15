/**
 * MapleStory OpenAPI error.<br>
 * Please refer to <a href="https://developers.nexon.com/Maplestory/guides">MapleStory API guide</a> for the error details.
 */
class MapleStoryApiError extends Error {

	readonly name = 'MapleStoryApiError';

	readonly status: number;

	readonly message: string;

	constructor(params: { status: number; message: string }) {
		const {status, message} = params;

		super(message);

		this.status = status;
		this.message = message;
	}
}

export {MapleStoryApiError};
