package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * HEXA 核心資訊
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterHexaMatrixEquipmentDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterHexaMatrixEquipmentDTO<CharacterHexaMatrixEquipmentLinkedSkillDTO> {

    /**
     * 核心名稱
     */
    @SerializedName("hexa_core_name")
    private String hexaCoreName;

    /**
     * 核心等級
     */
    @SerializedName("hexa_core_level")
    private Long hexaCoreLevel;

    /**
     * 核心類型
     */
    @SerializedName("hexa_core_type")
    private String hexaCoreType;

    /**
     * 已連接的技能
     */
    @SerializedName("linked_skill")
    private List<CharacterHexaMatrixEquipmentLinkedSkillDTO> linkedSkill;
}
