package dev.spiralmoon.maplestory.api.common.dto.character;

import java.time.ZonedDateTime;
import java.util.List;

public interface CharacterCashItemEquipmentPresetDTO<CharacterCashItemEquipmentOption extends CharacterCashItemEquipmentOptionDTO, CharacterCashItemEquipmentColoringPrism extends CharacterCashItemEquipmentColoringPrismDTO> {
    String getCashItemEquipmentPart();
    String getCashItemEquipmentSlot();
    String getCashItemName();
    String getCashItemIcon();
    String getCashItemDescription();
    List<CharacterCashItemEquipmentOption> getCashItemOption();
    ZonedDateTime getDateExpire();
    Boolean isExpired();
    ZonedDateTime getDateOptionExpire();
    Boolean isOptionExpired();
    String getCashItemLabel();
    CharacterCashItemEquipmentColoringPrism getCashItemColoringPrism();
    String getItemGender();
    String getFreestyleFlag();
}
