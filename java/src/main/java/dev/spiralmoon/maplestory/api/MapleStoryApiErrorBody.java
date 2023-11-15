package dev.spiralmoon.maplestory.api;

import lombok.Data;

@Data
class MapleStoryApiErrorBody {

    private String message;

    private int status;
}
