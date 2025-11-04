package dev.spiralmoon.maplestory.api.common.dto.character;

import java.time.ZonedDateTime;

public interface CharacterDojangDTO {
    ZonedDateTime getDate();
    String getCharacterClass();
    String getWorldName();
    int getDojangBestFloor();
    ZonedDateTime getDateDojangRecord();
    int getDojangBestTime();
}
