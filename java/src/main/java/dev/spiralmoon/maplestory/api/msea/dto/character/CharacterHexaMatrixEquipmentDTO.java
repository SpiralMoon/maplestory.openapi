package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * HEXA Node information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterHexaMatrixEquipmentDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterHexaMatrixEquipmentDTO<
        CharacterHexaMatrixEquipmentLinkedSkillDTO> {

    /**
     * Node name
     */
    @JsonProperty("hexa_core_name")
    private String hexaCoreName;

    /**
     * Node level
     */
    @JsonProperty("hexa_core_level")
    private Long hexaCoreLevel;

    /**
     * Node type
     */
    @JsonProperty("hexa_core_type")
    private String hexaCoreType;

    /**
     * Linked skill
     */
    @JsonProperty("linked_skill")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterHexaMatrixEquipmentLinkedSkillDTO> linkedSkill;
}
