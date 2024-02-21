package dev.spiralmoon.maplestory.api;


import lombok.Getter;

/**
 * MapleStory OpenAPI error codes.<br>
 * Please refer to <a href="https://openapi.nexon.com/guide/request-api/">MapleStory API guide</a> for the error code details.<br>
 */
@Getter
public enum MapleStoryApiErrorCode {

    OPENAPI00001("OPENAPI00001"),
    OPENAPI00002("OPENAPI00002"),
    OPENAPI00003("OPENAPI00003"),
    OPENAPI00004("OPENAPI00004"),
    OPENAPI00005("OPENAPI00005"),
    OPENAPI00006("OPENAPI00006"),
    OPENAPI00007("OPENAPI00007"),
    OPENAPI00009("OPENAPI00009"),
    OPENAPI00010("OPENAPI00010");

    private final String code;

    MapleStoryApiErrorCode(String name) {
        this.code = name;
    }

    public static MapleStoryApiErrorCode fromString(String name) {
        for (MapleStoryApiErrorCode errorCode : MapleStoryApiErrorCode.values()) {
            if (errorCode.code.equals(name)) {
                return errorCode;
            }
        }

        throw new IllegalArgumentException("No enum constant for string: " + name);
    }
}
