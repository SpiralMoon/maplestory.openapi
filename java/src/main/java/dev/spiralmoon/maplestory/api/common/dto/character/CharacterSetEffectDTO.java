package dev.spiralmoon.maplestory.api.common.dto.character;

import java.time.ZonedDateTime;
import java.util.List;

public interface CharacterSetEffectDTO<CharacterSetEffectSet extends CharacterSetEffectSetDTO<?, ?>> {
    ZonedDateTime getDate();
    List<CharacterSetEffectSet> getSetEffect();
}
