package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * HEXA Node information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterHexaMatrixEquipmentDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterHexaMatrixEquipmentDTO<
        CharacterHexaMatrixEquipmentLinkedSkillDTO> {

    /**
     * Node name
     */
    @SerializedName("hexa_core_name")
    private String hexaCoreName;

    /**
     * Node level
     */
    @SerializedName("hexa_core_level")
    private Long hexaCoreLevel;

    /**
     * Node type
     */
    @SerializedName("hexa_core_type")
    private String hexaCoreType;

    /**
     * Linked skill
     */
    @SerializedName("linked_skill")
    private List<CharacterHexaMatrixEquipmentLinkedSkillDTO> linkedSkill;
}
