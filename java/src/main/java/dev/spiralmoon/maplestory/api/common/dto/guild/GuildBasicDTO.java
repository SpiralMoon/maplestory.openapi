package dev.spiralmoon.maplestory.api.common.dto.guild;

import java.time.ZonedDateTime;
import java.util.List;

public interface GuildBasicDTO<GuildSkill extends GuildSkillDTO> {
    ZonedDateTime getDate();
    String getWorldName();
    String getGuildName();
    long getGuildLevel();
    long getGuildFame();
    long getGuildPoint();
    String getGuildMasterName();
    long getGuildMemberCount();
    List<String> getGuildMember();
    List<GuildSkill> getGuildSkill();
    List<GuildSkill> getGuildNoblesseSkill();
}
