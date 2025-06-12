package dev.spiralmoon.maplestory.api.common.dto.character;

import java.time.ZonedDateTime;

public interface CharacterBeautyEquipmentDTO<
        CharacterBeautyEquipmentHair extends CharacterBeautyEquipmentHairDTO,
        CharacterBeautyEquipmentFace extends CharacterBeautyEquipmentFaceDTO,
        CharacterBeautyEquipmentSkin extends CharacterBeautyEquipmentSkinDTO> {
    ZonedDateTime getDate();
    String getCharacterGender();
    String getCharacterClass();
    CharacterBeautyEquipmentHair getCharacterHair();
    CharacterBeautyEquipmentFace getCharacterFace();
    CharacterBeautyEquipmentSkin getCharacterSkin();
    CharacterBeautyEquipmentHair getAdditionalCharacterHair();
    CharacterBeautyEquipmentFace getAdditionalCharacterFace();
    CharacterBeautyEquipmentSkin getAdditionalCharacterSkin();
}
