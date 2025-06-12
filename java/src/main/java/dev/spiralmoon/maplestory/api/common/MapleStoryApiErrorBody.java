package dev.spiralmoon.maplestory.api.common;

import lombok.Data;

@Data
class MapleStoryApiErrorBody {

    @Data
    class Error {

        private String message;

        private String name;
    }

    private Error error;
}
