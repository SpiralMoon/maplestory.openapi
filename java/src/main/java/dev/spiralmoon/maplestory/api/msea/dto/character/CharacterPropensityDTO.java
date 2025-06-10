package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * Character traits information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterPropensityDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterPropensityDTO {

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    @SerializedName("date")
    private String date;

    /**
     * Ambition level
     */
    @SerializedName("charisma_level")
    private Integer charismaLevel;

    /**
     * Empathy level
     */
    @SerializedName("sensibility_level")
    private Integer sensibilityLevel;

    /**
     * Insight level
     */
    @SerializedName("insight_level")
    private Integer insightLevel;

    /**
     * Willpower level
     */
    @SerializedName("willingness_level")
    private Integer willingnessLevel;

    /**
     * Diligence level
     */
    @SerializedName("handicraft_level")
    private Integer handicraftLevel;

    /**
     * Charm level
     */
    @SerializedName("charm_level")
    private Integer charmLevel;

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
