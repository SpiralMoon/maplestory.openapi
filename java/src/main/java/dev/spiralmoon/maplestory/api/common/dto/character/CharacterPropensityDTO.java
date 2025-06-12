package dev.spiralmoon.maplestory.api.common.dto.character;

import java.time.ZonedDateTime;

public interface CharacterPropensityDTO {
    ZonedDateTime getDate();
    Integer getCharismaLevel();
    Integer getSensibilityLevel();
    Integer getInsightLevel();
    Integer getWillingnessLevel();
    Integer getHandicraftLevel();
    Integer getCharmLevel();
}
