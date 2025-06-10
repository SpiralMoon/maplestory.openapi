package dev.spiralmoon.maplestory.api.common.dto.character;

import java.util.List;

public interface CharacterPetEquipmentItemDTO<CharacterPetEquipmentItemOption extends CharacterPetEquipmentItemOptionDTO> {
    String getItemName();
    String getItemIcon();
    String getItemDescription();
    List<CharacterPetEquipmentItemOption> getItemOption();
    int getScrollUpgrade();
    int getScrollUpgradable();
    String getItemShape();
    String getItemShapeIcon();
}
