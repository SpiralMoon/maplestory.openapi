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
 * Character HEXA Node information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterHexaMatrixDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterHexaMatrixDTO<
        CharacterHexaMatrixEquipmentDTO> {

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    @JsonProperty("date")
    private String date;

    /**
     * HEXA Node information
     */
    @JsonProperty("character_hexa_core_equipment")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterHexaMatrixEquipmentDTO> characterHexaCoreEquipment;

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
