package dev.spiralmoon.maplestory.api.common.dto.character;

import java.time.ZonedDateTime;

public interface CharacterPropensityDTO {
    ZonedDateTime getDate();
    int getCharismaLevel();
    int getSensibilityLevel();
    int getInsightLevel();
    int getWillingnessLevel();
    int getHandicraftLevel();
    int getCharmLevel();
}
