package dev.spiralmoon.maplestory.api;

import lombok.Getter;

/**
 * MapleStory OpenAPI exception.<br>
 * Please refer to <a href="https://developers.nexon.com/Maplestory/guides">MapleStory API guide</a> for the exception details.
 */
@Getter
public class MapleStoryApiException extends RuntimeException {

    private final String message;

    private final int status;

    public MapleStoryApiException(MapleStoryApiErrorBody error) {
        super(error.getMessage());

        this.message = error.getMessage();
        this.status = error.getStatus();
    }

    public MapleStoryApiException(int status, String message) {
        super(message);

        this.message = message;
        this.status = status;
    }
}
