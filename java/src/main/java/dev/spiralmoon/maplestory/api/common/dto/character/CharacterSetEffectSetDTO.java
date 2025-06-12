package dev.spiralmoon.maplestory.api.common.dto.character;

import java.util.List;

public interface CharacterSetEffectSetDTO<CharacterSetEffectInfo extends CharacterSetEffectInfoDTO, CharacterSetEffectOptionFull extends CharacterSetEffectOptionFullDTO> {
    String getSetName();
    long getTotalSetCount();
    List<CharacterSetEffectInfo> getSetEffectInfo();
    List<CharacterSetEffectOptionFull> getSetOptionFull();
}
