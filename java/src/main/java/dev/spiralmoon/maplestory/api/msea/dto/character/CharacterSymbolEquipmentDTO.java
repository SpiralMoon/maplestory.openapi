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
 * Character equipped symbol information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterSymbolEquipmentDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterSymbolEquipmentDTO<
        CharacterSymbolEquipmentInfoDTO> {

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
     * Symbol information
     */
    @JsonProperty("symbol")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterSymbolEquipmentInfoDTO> symbol;

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
