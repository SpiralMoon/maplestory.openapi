package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 캐릭터 펫 루나 쁘띠 펫 스킬 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterPetEquipmentPetiteLunaPetSkillDTO {

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
     * 스킬 효과 설명
     */
    @JsonProperty("skill_effect")
    private String skillEffect;

    /**
     * 스킬 아이콘
     */
    @JsonProperty("skill_icon")
    private String skillIcon;
}
