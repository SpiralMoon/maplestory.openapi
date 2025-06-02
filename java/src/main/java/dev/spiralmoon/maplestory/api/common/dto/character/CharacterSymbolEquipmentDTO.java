package dev.spiralmoon.maplestory.api.common.dto.character;

import java.time.ZonedDateTime;
import java.util.List;

public interface CharacterSymbolEquipmentDTO<CharacterSymbolEquipmentInfo extends CharacterSymbolEquipmentInfoDTO> {
    ZonedDateTime getDate();
    String getCharacterClass();
    List<CharacterSymbolEquipmentInfo> getSymbol();
}
