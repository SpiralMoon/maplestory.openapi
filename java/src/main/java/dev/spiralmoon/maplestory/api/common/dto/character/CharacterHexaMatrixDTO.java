package dev.spiralmoon.maplestory.api.common.dto.character;

import java.time.ZonedDateTime;
import java.util.List;

public interface CharacterHexaMatrixDTO<CharacterHexaMatrixEquipment extends CharacterHexaMatrixEquipmentDTO<?>> {
    ZonedDateTime getDate();
    List<CharacterHexaMatrixEquipment> getCharacterHexaCoreEquipment();
}
