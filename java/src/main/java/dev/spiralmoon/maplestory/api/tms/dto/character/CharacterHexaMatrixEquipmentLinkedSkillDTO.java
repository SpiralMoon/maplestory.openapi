package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 已連接的技能
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterHexaMatrixEquipmentLinkedSkillDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterHexaMatrixEquipmentLinkedSkillDTO {

    /**
     * HEXA 技能名稱
     */
    @SerializedName("hexa_skill_id")
    private String hexaSkillId;
}
