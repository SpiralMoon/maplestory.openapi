package dev.spiralmoon.maplestory.api.common.dto.character;

import java.time.ZonedDateTime;
import java.util.List;

public interface CharacterItemEquipmentDTO<
        CharacterItemEquipmentInfo extends CharacterItemEquipmentInfoDTO<?, ?, ?, ?, ?, ?>,
        CharacterItemEquipmentTitle extends CharacterItemEquipmentTitleDTO,
        CharacterItemEquipmentMedalShape extends CharacterItemEquipmentMedalShapeDTO,
        CharacterItemEquipmentDragonInfo extends CharacterItemEquipmentDragonInfoDTO<?, ?, ?, ?, ?, ?>,
        CharacterItemEquipmentMechanicInfo extends CharacterItemEquipmentMechanicInfoDTO<?, ?, ?, ?, ?, ?>> {
    ZonedDateTime getDate();
    String getCharacterGender();
    String getCharacterClass();
    Integer getPresetNo();
    List<CharacterItemEquipmentInfo> getItemEquipment();
    List<CharacterItemEquipmentInfo> getItemEquipmentPreset1();
    List<CharacterItemEquipmentInfo> getItemEquipmentPreset2();
    List<CharacterItemEquipmentInfo> getItemEquipmentPreset3();
    CharacterItemEquipmentTitle getTitle();
    CharacterItemEquipmentMedalShape getMedalShape();
    List<CharacterItemEquipmentDragonInfo> getDragonEquipment();
    List<CharacterItemEquipmentMechanicInfo> getMechanicEquipment();
}
