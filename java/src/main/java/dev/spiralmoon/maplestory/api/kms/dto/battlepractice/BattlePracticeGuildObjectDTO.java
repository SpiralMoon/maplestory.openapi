package dev.spiralmoon.maplestory.api.kms.dto.battlepractice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 연무장 입장 시 길드 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeGuildObjectDTO {

    /**
     * 길드 스킬 목록
     */
    @JsonProperty("guild_skill")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<BattlePracticeGuildSkillDTO> guildSkill;

    /**
     * 노블레스 스킬 목록
     */
    @JsonProperty("guild_noblesse_skill")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<BattlePracticeGuildSkillDTO> guildNoblesseSkill;
}
