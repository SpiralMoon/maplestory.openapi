package dev.spiralmoon.maplestory.api.common.dto.character;

import java.time.ZonedDateTime;
import java.util.List;

public interface CharacterAndroidEquipmentDTO<
        CharacterAndroidEquipmentHair extends CharacterAndroidEquipmentHairDTO,
        CharacterAndroidEquipmentFace extends CharacterAndroidEquipmentFaceDTO,
        CharacterAndroidEquipmentSkin extends CharacterAndroidEquipmentSkinDTO,
        CharacterAndroidCashItemEquipment extends CharacterAndroidCashItemEquipmentDTO<?, ?>,
        CharacterAndroidEquipmentPreset extends CharacterAndroidEquipmentPresetDTO<?, ?, ?>>{
    ZonedDateTime getDate();
    String getAndroidName();
    String getAndroidNickname();
    String getAndroidIcon();
    String getAndroidDescription();
    CharacterAndroidEquipmentHair getAndroidHair();
    CharacterAndroidEquipmentFace getAndroidFace();
    CharacterAndroidEquipmentSkin getAndroidSkin();
    List<CharacterAndroidCashItemEquipment> getAndroidCashItemEquipment();
    String getAndroidEarSensorClipFlag();
    String getAndroidGender();
    String getAndroidGrade();
    String getAndroidNonHumanoidFlag();
    String getAndroidShopUsableFlag();
    Integer getPresetNo();
    CharacterAndroidEquipmentPreset getAndroidPreset1();
    CharacterAndroidEquipmentPreset getAndroidPreset2();
    CharacterAndroidEquipmentPreset getAndroidPreset3();
}
