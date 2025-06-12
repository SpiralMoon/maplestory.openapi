package dev.spiralmoon.maplestory.api.msea.dto.union;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Union Legion Block information
 */
@AllArgsConstructor
@Data
@ToString
public class UnionRaiderBlockDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionRaiderBlockDTO<UnionRaiderBlockControlPointDTO, UnionRaiderBlockPositionDTO> {

    /**
     * Block shapes (Warrior, Magician, Bowman, Thief, Pirate, Maple M, Hybrid)
     */
    @SerializedName("block_type")
    private String blockType;

    /**
     * Character class corresponding to the block
     */
    @SerializedName("block_class")
    private String blockClass;

    /**
     * Character level corresponding to the block
     */
    @SerializedName("block_level")
    private String blockLevel;

    /**
     * Coordinates of the block's reference point
     */
    @SerializedName("block_control_point")
    private UnionRaiderBlockControlPointDTO blockControlPoint;

    /**
     * Coordinates of the area occupied by the block (null if not placed)
     */
    @SerializedName("block_position")
    private List<UnionRaiderBlockPositionDTO> blockPosition;
}
