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
 * 연무장 입장 시 캐릭터 링크 스킬 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeCharacterLinkSkillObjectDTO {

    /**
     * 링크 스킬 정보
     */
    @JsonProperty("character_link_skill")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<BattlePracticeCharacterSkillInfoDTO> characterLinkSkill;

    /**
     * 내 링크 스킬 정보
     */
    @JsonProperty("character_owned_link_skill")
    private BattlePracticeCharacterSkillInfoDTO characterOwnedLinkSkill;
}
