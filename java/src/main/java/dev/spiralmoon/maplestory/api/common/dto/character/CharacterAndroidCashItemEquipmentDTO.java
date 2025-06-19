package dev.spiralmoon.maplestory.api.common.dto.character;

import java.time.ZonedDateTime;
import java.util.List;

public interface CharacterAndroidCashItemEquipmentDTO<CharacterAndroidCashItemEquipmentOption extends CharacterAndroidCashItemEquipmentOptionDTO, CharacterAndroidCashItemEquipmentColoringPrism extends CharacterAndroidCashItemEquipmentColoringPrismDTO> {
    String getCashItemEquipmentPart();
    String getCashItemEquipmentSlot();
    String getCashItemName();
    String getCashItemIcon();
    String getCashItemDescription();
    List<CharacterAndroidCashItemEquipmentOption> getCashItemOption();
    ZonedDateTime getDateExpire();
    Boolean isExpired();
    ZonedDateTime getDateOptionExpire();
    Boolean isOptionExpired();
    String getCashItemLabel();
    CharacterAndroidCashItemEquipmentColoringPrism getCashItemColoringPrism();
    String getAndroidItemGender();
}
