package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Character equipped symbol information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterSymbolEquipmentDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterSymbolEquipmentDTO<
        CharacterSymbolEquipmentInfoDTO> {

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
     * Symbol information
     */
    @SerializedName("symbol")
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
