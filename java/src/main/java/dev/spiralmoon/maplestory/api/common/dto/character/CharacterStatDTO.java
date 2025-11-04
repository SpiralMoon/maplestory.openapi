package dev.spiralmoon.maplestory.api.common.dto.character;

import java.time.ZonedDateTime;
import java.util.List;

public interface CharacterStatDTO<CharacterFinalStat extends CharacterFinalStatDTO> {
    ZonedDateTime getDate();
    String getCharacterClass();
    List<CharacterFinalStat> getFinalStat();
    int getRemainAp();
}
