package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 캐릭터 링크 스킬 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterLinkSkillInfoDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterLinkSkillInfoDTO {

    /**
     * 스킬 명
     */
    @SerializedName("skill_name")
    private String skillName;

    /**
     * 스킬 설명
     */
    @SerializedName("skill_description")
    private String skillDescription;

    /**
     * 스킬 레벨
     */
    @SerializedName("skill_level")
    private Long skillLevel;

    /**
     * 스킬 효과
     */
    @SerializedName("skill_effect")
    private String skillEffect;

    /**
     * 다음 레벨의 스킬 효과
     */
    @SerializedName("skill_effect_next")
    private String skillEffectNext;

    /**
     * 스킬 아이콘
     */
    @SerializedName("skill_icon")
    private String skillIcon;
}
