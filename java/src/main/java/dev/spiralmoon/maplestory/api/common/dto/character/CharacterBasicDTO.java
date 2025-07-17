package dev.spiralmoon.maplestory.api.common.dto.character;

import java.time.ZonedDateTime;

public interface CharacterBasicDTO {
    ZonedDateTime getDate();
    String getCharacterName();
    String getWorldName();
    String getCharacterGender();
    String getCharacterClass();
    String getCharacterClassLevel();
    long getCharacterLevel();
    long getCharacterExp();
    String getCharacterExpRate();
    String getCharacterGuildName();
    String getCharacterImage();
    ZonedDateTime getCharacterDateCreate();
    boolean isAccessFlag();
}
