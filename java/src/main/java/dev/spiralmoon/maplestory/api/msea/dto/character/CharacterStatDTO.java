package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Character comprehensive stats information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterStatDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterStatDTO<CharacterFinalStatDTO> {

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
     * Current stat information
     */
    @SerializedName("final_stat")
    private List<CharacterFinalStatDTO> finalStat;

    /**
     * Remaining AP
     */
    @SerializedName("remain_ap")
    private Integer remainAp;

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
