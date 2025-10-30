package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 캐릭터 펫 장비 자동 스킬 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterPetEquipmentAutoSkillDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterPetEquipmentAutoSkillDTO {

    /**
     * 첫 번째 슬롯에 등록된 자동 스킬
     */
    @JsonProperty("skill_1")
    private String skill1;

    /**
     * 첫 번째 슬롯에 등록된 자동 스킬 아이콘
     */
    @JsonProperty("skill_1_icon")
    private String skill1Icon;

    /**
     * 두 번째 슬롯에 등록된 자동 스킬
     */
    @JsonProperty("skill_2")
    private String skill2;

    /**
     * 두 번째 슬롯에 등록된 자동 스킬 아이콘
     */
    @JsonProperty("skill_2_icon")
    private String skill2Icon;
}
