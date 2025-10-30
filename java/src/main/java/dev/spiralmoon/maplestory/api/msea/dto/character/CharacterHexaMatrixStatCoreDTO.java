package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Information for HEXA Stat Node
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterHexaMatrixStatCoreDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterHexaMatrixStatCoreDTO {

    /**
     * Slot index
     */
    @JsonProperty("slot_id")
    private String slotId;

    /**
     * Main Stat name
     */
    @JsonProperty("main_stat_name")
    private String mainStatName;

    /**
     * First sub stat name
     */
    @JsonProperty("sub_stat_name_1")
    private String subStatName1;

    /**
     * Second sub stat name
     */
    @JsonProperty("sub_stat_name_2")
    private String subStatName2;

    /**
     * Main Stat level
     */
    @JsonProperty("main_stat_level")
    private long mainStatLevel;

    /**
     * First sub stat level
     */
    @JsonProperty("sub_stat_level_1")
    private long subStatLevel1;

    /**
     * Second sub stat level
     */
    @JsonProperty("sub_stat_level_2")
    private long subStatLevel2;

    /**
     * Stat core level
     */
    @JsonProperty("stat_grade")
    private long statGrade;
}
