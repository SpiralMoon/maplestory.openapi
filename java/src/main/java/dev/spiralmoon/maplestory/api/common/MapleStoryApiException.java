package dev.spiralmoon.maplestory.api.common;

import lombok.Getter;

/**
 * MapleStory OpenAPI exception.<br>
 * Please refer to <a href="https://openapi.nexon.com/guide/request-api/">MapleStory API guide</a> for the exception details.<br>
 */
@Getter
public class MapleStoryApiException extends RuntimeException {

    private final String message;

    private final MapleStoryApiErrorCode errorCode;

    public MapleStoryApiException(MapleStoryApiErrorBody errorBody) {
        super(errorBody.getError().getMessage());

        this.message = errorBody.getError().getMessage();
        this.errorCode = MapleStoryApiErrorCode.fromString(errorBody.getError().getName());
    }

    public MapleStoryApiException(MapleStoryApiErrorCode errorCode, String message) {
        super(message);

        this.message = message;
        this.errorCode = errorCode;
    }
}
