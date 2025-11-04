package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Character V Matrix information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterVMatrixDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterVMatrixDTO<CharacterVMatrixCoreEquipmentDTO> {

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    @JsonProperty("date")
    private String date;

    /**
     * Character job
     */
    @JsonProperty("character_class")
    private String characterClass;

    /**
     * V Matrix Node information
     */
    @JsonProperty("character_v_core_equipment")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterVMatrixCoreEquipmentDTO> characterVCoreEquipment;

    /**
     * Remaining Matrix enhancement points for the character
     */
    @JsonProperty("character_v_matrix_remain_slot_upgrade_point")
    private long characterVMatrixRemainSlotUpgradePoint;

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
