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
 * Character information about equipped set item effects
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterSetEffectDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterSetEffectDTO<
        CharacterSetEffectSetDTO> {

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    @JsonProperty("date")
    private String date;

    /**
     * Set Item effect information
     */
    @JsonProperty("set_effect")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
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
