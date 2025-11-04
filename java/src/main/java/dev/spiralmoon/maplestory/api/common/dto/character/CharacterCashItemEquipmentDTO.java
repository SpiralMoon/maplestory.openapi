package dev.spiralmoon.maplestory.api.common.dto.character;

import java.time.ZonedDateTime;
import java.util.List;

public interface CharacterCashItemEquipmentDTO<CharacterCashItemEquipmentPreset extends CharacterCashItemEquipmentPresetDTO<?, ?>> {
    ZonedDateTime getDate();
    String getCharacterGender();
    String getCharacterClass();
    String getCharacterLookMode();
    int getPresetNo();
    List<CharacterCashItemEquipmentPreset> getCashItemEquipmentBase();
    List<CharacterCashItemEquipmentPreset> getCashItemEquipmentPreset1();
    List<CharacterCashItemEquipmentPreset> getCashItemEquipmentPreset2();
    List<CharacterCashItemEquipmentPreset> getCashItemEquipmentPreset3();
    List<CharacterCashItemEquipmentPreset> getAdditionalCashItemEquipmentBase();
    List<CharacterCashItemEquipmentPreset> getAdditionalCashItemEquipmentPreset1();
    List<CharacterCashItemEquipmentPreset> getAdditionalCashItemEquipmentPreset2();
    List<CharacterCashItemEquipmentPreset> getAdditionalCashItemEquipmentPreset3();
}
