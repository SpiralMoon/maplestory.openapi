package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * V Matrix Node information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterVMatrixCoreEquipmentDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterVMatrixCoreEquipmentDTO {

    /**
     * Slot index
     */
    @JsonProperty("slot_id")
    private String slotId;

    /**
     * Slot level
     */
    @JsonProperty("slot_level")
    private long slotLevel;

    /**
     * Node name
     */
    @JsonProperty("v_core_name")
    private String vCoreName;

    /**
     * Node type
     */
    @JsonProperty("v_core_type")
    private String vCoreType;

    /**
     * Node level
     */
    @JsonProperty("v_core_level")
    private long vCoreLevel;

    /**
     * Name of the skill that corresponds to the node
     */
    @JsonProperty("v_core_skill_1")
    private String vCoreSkill1;

    /**
     * Name of the second skill that corresponds to the node (for Boost Nodes)
     */
    @JsonProperty("v_core_skill_2")
    private String vCoreSkill2;

    /**
     * Name of the third skill that corresponds to the node (for Boost Nodes)
     */
    @JsonProperty("v_core_skill_3")
    private String vCoreSkill3;
}
