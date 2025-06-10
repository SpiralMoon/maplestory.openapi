package dev.spiralmoon.maplestory.api.common.dto.character;

import java.time.ZonedDateTime;

public interface CharacterPopularityDTO {
    ZonedDateTime getDate();
    long getPopularity();
}
