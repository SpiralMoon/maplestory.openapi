package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Character V Matrix information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterVMatrixDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterVMatrixDTO<CharacterVMatrixCoreEquipmentDTO> {

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    @SerializedName("date")
    private String date;

    /**
     * Character job
     */
    @SerializedName("character_class")
    private String characterClass;

    /**
     * V Matrix Node information
     */
    @SerializedName("character_v_core_equipment")
    private List<CharacterVMatrixCoreEquipmentDTO> characterVCoreEquipment;

    /**
     * Remaining Matrix enhancement points for the character
     */
    @SerializedName("character_v_matrix_remain_slot_upgrade_point")
    private Long characterVMatrixRemainSlotUpgradePoint;

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
