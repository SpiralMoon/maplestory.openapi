package dev.spiralmoon.maplestory.api.common.dto.character;

import java.util.List;

public interface CharacterAbilityPresetDTO<CharacterAbilityInfo extends CharacterAbilityInfoDTO> {
    String getAbilityPresetGrade();
    List<CharacterAbilityInfo> getAbilityInfo();
}
