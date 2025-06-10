package dev.spiralmoon.maplestory.api.common.dto.character;

import java.time.ZonedDateTime;
import java.util.List;

public interface CharacterLinkSkillDTO<CharacterLinkSkillInfo extends CharacterLinkSkillInfoDTO> {
    ZonedDateTime getDate();
    String getCharacterClass();
    List<CharacterLinkSkillInfo> getCharacterLinkSkill();
    List<CharacterLinkSkillInfo> getCharacterLinkSkillPreset1();
    List<CharacterLinkSkillInfo> getCharacterLinkSkillPreset2();
    List<CharacterLinkSkillInfo> getCharacterLinkSkillPreset3();
    CharacterLinkSkillInfo getCharacterOwnedLinkSkill();
    CharacterLinkSkillInfo getCharacterOwnedLinkSkillPreset1();
    CharacterLinkSkillInfo getCharacterOwnedLinkSkillPreset2();
    CharacterLinkSkillInfo getCharacterOwnedLinkSkillPreset3();
}
