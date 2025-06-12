package dev.spiralmoon.maplestory.api.common.dto.character;

public interface CharacterAndroidEquipmentPresetDTO<CharacterAndroidEquipmentHair extends CharacterAndroidEquipmentHairDTO, CharacterAndroidEquipmentFace extends CharacterAndroidEquipmentFaceDTO, CharacterAndroidEquipmentSkin extends CharacterAndroidEquipmentSkinDTO> {
    String getAndroidName();
    String getAndroidNickname();
    String getAndroidIcon();
    String getAndroidDescription();
    String getAndroidGender();
    String getAndroidGrade();
    CharacterAndroidEquipmentHair getAndroidHair();
    CharacterAndroidEquipmentFace getAndroidFace();
    CharacterAndroidEquipmentSkin getAndroidSkin();
    String getAndroidEarSensorClipFlag();
    String getAndroidNonHumanoidFlag();
    String getAndroidShopUsableFlag();
}
