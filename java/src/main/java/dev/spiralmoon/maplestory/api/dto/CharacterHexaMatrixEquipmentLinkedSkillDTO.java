package dev.spiralmoon.maplestory.api.dto;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 연결된 HEXA 스킬 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterHexaMatrixEquipmentLinkedSkillDTO {

    /**
     * HEXA 스킬 명
     */
    @SerializedName("hexa_skill_id")
    private String hexaSkillId;
}
