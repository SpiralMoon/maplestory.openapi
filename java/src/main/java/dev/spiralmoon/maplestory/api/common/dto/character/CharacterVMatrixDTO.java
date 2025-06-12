package dev.spiralmoon.maplestory.api.common.dto.character;

import java.time.ZonedDateTime;
import java.util.List;

public interface CharacterVMatrixDTO<CharacterVMatrixCoreEquipment extends CharacterVMatrixCoreEquipmentDTO> {
    ZonedDateTime getDate();
    String getCharacterClass();
    List<CharacterVMatrixCoreEquipment> getCharacterVCoreEquipment();
    Long getCharacterVMatrixRemainSlotUpgradePoint();
}
