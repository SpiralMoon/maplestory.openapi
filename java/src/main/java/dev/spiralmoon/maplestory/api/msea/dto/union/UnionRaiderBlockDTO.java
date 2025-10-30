package dev.spiralmoon.maplestory.api.msea.dto.union;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * Union Legion Block information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UnionRaiderBlockDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionRaiderBlockDTO<UnionRaiderBlockControlPointDTO, UnionRaiderBlockPositionDTO> {

    /**
     * Block shapes (Warrior, Magician, Bowman, Thief, Pirate, Maple M, Hybrid)
     */
    @JsonProperty("block_type")
    private String blockType;

    /**
     * Character class corresponding to the block
     */
    @JsonProperty("block_class")
    private String blockClass;

    /**
     * Character level corresponding to the block
     */
    @JsonProperty("block_level")
    private String blockLevel;

    /**
     * Coordinates of the block's reference point
     */
    @JsonProperty("block_control_point")
    private UnionRaiderBlockControlPointDTO blockControlPoint;

    /**
     * Coordinates of the area occupied by the block (null if not placed)
     */
    @JsonProperty("block_position")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<UnionRaiderBlockPositionDTO> blockPosition;
}
