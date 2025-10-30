package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 已連接的技能
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterHexaMatrixEquipmentLinkedSkillDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterHexaMatrixEquipmentLinkedSkillDTO {

    /**
     * HEXA 技能名稱
     */
    @JsonProperty("hexa_skill_id")
    private String hexaSkillId;
}
