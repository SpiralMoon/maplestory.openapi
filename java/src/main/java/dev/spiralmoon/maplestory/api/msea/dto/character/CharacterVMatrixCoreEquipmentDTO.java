package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * V Matrix Node information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterVMatrixCoreEquipmentDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterVMatrixCoreEquipmentDTO {

    /**
     * Slot index
     */
    @SerializedName("slot_id")
    private String slotId;

    /**
     * Slot level
     */
    @SerializedName("slot_level")
    private long slotLevel;

    /**
     * Node name
     */
    @SerializedName("v_core_name")
    private String vCoreName;

    /**
     * Node type
     */
    @SerializedName("v_core_type")
    private String vCoreType;

    /**
     * Node level
     */
    @SerializedName("v_core_level")
    private long vCoreLevel;

    /**
     * Name of the skill that corresponds to the node
     */
    @SerializedName("v_core_skill_1")
    private String vCoreSkill1;

    /**
     * Name of the second skill that corresponds to the node (for Boost Nodes)
     */
    @SerializedName("v_core_skill_2")
    private String vCoreSkill2;

    /**
     * Name of the third skill that corresponds to the node (for Boost Nodes)
     */
    @SerializedName("v_core_skill_3")
    private String vCoreSkill3;
}
