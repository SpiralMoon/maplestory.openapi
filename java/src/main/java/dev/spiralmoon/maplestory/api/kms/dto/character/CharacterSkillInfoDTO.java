package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 캐릭터 스킬 상세 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterSkillInfoDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterSkillInfoDTO {

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
     * 스킬 레벨 별 효과 설명
     */
    @JsonProperty("skill_effect")
    private String skillEffect;

    /**
     * 다음 스킬 레벨 효과 설명
     */
    @JsonProperty("skill_effect_next")
    private String skillEffectNext;

    /**
     * 스킬 아이콘
     */
    @JsonProperty("skill_icon")
    private String skillIcon;
}
