package dev.spiralmoon.maplestory.api.common.dto.character;

import java.time.ZonedDateTime;
import java.util.List;

public interface CharacterPetEquipmentDTO<CharacterPetEquipmentItem extends CharacterPetEquipmentItemDTO<?>, CharacterPetEquipmentAutoSkill extends CharacterPetEquipmentAutoSkillDTO> {
    ZonedDateTime getDate();
    String getPet1Name();
    String getPet1Nickname();
    String getPet1Icon();
    String getPet1Description();
    CharacterPetEquipmentItem getPet1Equipment();
    CharacterPetEquipmentAutoSkill getPet1AutoSkill();
    String getPet1PetType();
    List<String> getPet1Skill();
    ZonedDateTime getPet1DateExpire();
    Boolean isPet1Expired();
    String getPet1Appearance();
    String getPet1AppearanceIcon();
    String getPet2Name();
    String getPet2Nickname();
    String getPet2Icon();
    String getPet2Description();
    CharacterPetEquipmentItem getPet2Equipment();
    CharacterPetEquipmentAutoSkill getPet2AutoSkill();
    String getPet2PetType();
    List<String> getPet2Skill();
    ZonedDateTime getPet2DateExpire();
    Boolean isPet2Expired();
    String getPet2Appearance();
    String getPet2AppearanceIcon();
    String getPet3Name();
    String getPet3Nickname();
    String getPet3Icon();
    String getPet3Description();
    CharacterPetEquipmentItem getPet3Equipment();
    CharacterPetEquipmentAutoSkill getPet3AutoSkill();
    String getPet3PetType();
    List<String> getPet3Skill();
    ZonedDateTime getPet3DateExpire();
    Boolean isPet3Expired();
    String getPet3Appearance();
    String getPet3AppearanceIcon();
}
