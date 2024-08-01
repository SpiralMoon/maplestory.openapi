import { MapleStoryErrorBody } from './mapleStoryApi';

/**
 * MapleStory OpenAPI error.<br>
 * Please refer to <a href="https://openapi.nexon.com/guide/request-api/">MapleStory API guide</a> for the error details.
 */
class MapleStoryApiError extends Error {
  readonly name = 'MapleStoryApiError';

  readonly errorCode: MapleStoryApiErrorCode;

  readonly message: string;

  constructor(errorBody: MapleStoryErrorBody) {
    const { name, message } = errorBody.error;

    super(message);

    this.errorCode = errorMap[name];
    this.message = message;
  }
}

/**
 * MapleStory OpenAPI error codes.<br>
 * Please refer to <a href="https://openapi.nexon.com/guide/request-api/">MapleStory API guide</a> for the error code details.
 */
enum MapleStoryApiErrorCode {
  OPENAPI00001,
  OPENAPI00002,
  OPENAPI00003,
  OPENAPI00004,
  OPENAPI00005,
  OPENAPI00006,
  OPENAPI00007,
  OPENAPI00009,
  OPENAPI00010,
  OPENAPI00011,
}

const errorMap: {
  [key: string]: MapleStoryApiErrorCode;
} = {
  ['OPENAPI00001']: MapleStoryApiErrorCode.OPENAPI00001,
  ['OPENAPI00002']: MapleStoryApiErrorCode.OPENAPI00002,
  ['OPENAPI00003']: MapleStoryApiErrorCode.OPENAPI00003,
  ['OPENAPI00004']: MapleStoryApiErrorCode.OPENAPI00004,
  ['OPENAPI00005']: MapleStoryApiErrorCode.OPENAPI00005,
  ['OPENAPI00006']: MapleStoryApiErrorCode.OPENAPI00006,
  ['OPENAPI00007']: MapleStoryApiErrorCode.OPENAPI00007,
  ['OPENAPI00009']: MapleStoryApiErrorCode.OPENAPI00009,
  ['OPENAPI00010']: MapleStoryApiErrorCode.OPENAPI00010,
  ['OPENAPI00011']: MapleStoryApiErrorCode.OPENAPI00011,
};

export { MapleStoryApiError, MapleStoryApiErrorCode };
