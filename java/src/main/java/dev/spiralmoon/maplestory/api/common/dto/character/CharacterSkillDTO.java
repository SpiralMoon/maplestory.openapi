package dev.spiralmoon.maplestory.api.common.dto.character;

import java.time.ZonedDateTime;
import java.util.List;

public interface CharacterSkillDTO<CharacterSkillInfo extends CharacterSkillInfoDTO> {
    ZonedDateTime getDate();
    String getCharacterClass();
    String getCharacterSkillGrade();
    List<CharacterSkillInfo> getCharacterSkill();
}
