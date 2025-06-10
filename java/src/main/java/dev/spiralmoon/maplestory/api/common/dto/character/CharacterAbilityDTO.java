package dev.spiralmoon.maplestory.api.common.dto.character;

import java.time.ZonedDateTime;
import java.util.List;

public interface CharacterAbilityDTO<CharacterAbilityInfo extends CharacterAbilityInfoDTO, CharacterAbilityPreset extends CharacterAbilityPresetDTO<?>> {
    ZonedDateTime getDate();
    String getAbilityGrade();
    List<CharacterAbilityInfo> getAbilityInfo();
    Long getRemainFame();
    Integer getPresetNo();
    CharacterAbilityPreset getAbilityPreset1();
    CharacterAbilityPreset getAbilityPreset2();
    CharacterAbilityPreset getAbilityPreset3();
}
