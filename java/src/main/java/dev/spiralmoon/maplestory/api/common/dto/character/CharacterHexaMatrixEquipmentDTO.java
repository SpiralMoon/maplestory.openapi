package dev.spiralmoon.maplestory.api.common.dto.character;

import java.util.List;

public interface CharacterHexaMatrixEquipmentDTO<CharacterHexaMatrixEquipmentLinkedSkill extends CharacterHexaMatrixEquipmentLinkedSkillDTO> {
    String getHexaCoreName();
    Long getHexaCoreLevel();
    String getHexaCoreType();
    List<CharacterHexaMatrixEquipmentLinkedSkill> getLinkedSkill();
}
