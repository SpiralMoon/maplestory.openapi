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
 * Character comprehensive stats information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterStatDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterStatDTO<CharacterFinalStatDTO> {

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
     * Current stat information
     */
    @JsonProperty("final_stat")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterFinalStatDTO> finalStat;

    /**
     * Remaining AP
     */
    @JsonProperty("remain_ap")
    private int remainAp;

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
