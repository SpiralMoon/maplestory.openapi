package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 캐릭터 링크 스킬 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterLinkSkillInfoDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterLinkSkillInfoDTO {

    /**
     * 스킬 명
     */
    @JsonProperty("skill_name")
    private String skillName;

    /**
     * 스킬 설명
     */
    @JsonProperty("skill_description")
    private String skillDescription;

    /**
     * 스킬 레벨
     */
    @JsonProperty("skill_level")
    private Long skillLevel;

    /**
     * 스킬 효과
     */
    @JsonProperty("skill_effect")
    private String skillEffect;

    /**
     * 다음 레벨의 스킬 효과
     */
    @JsonProperty("skill_effect_next")
    private String skillEffectNext;

    /**
     * 스킬 아이콘
     */
    @JsonProperty("skill_icon")
    private String skillIcon;
}
