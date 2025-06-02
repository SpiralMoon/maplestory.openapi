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
 * Character information about equipped set item effects
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterSetEffectDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterSetEffectDTO<
        CharacterSetEffectSetDTO> {

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    @SerializedName("date")
    private String date;

    /**
     * Set Item effect information
     */
    @SerializedName("set_effect")
    private List<CharacterSetEffectSetDTO> setEffect;

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
