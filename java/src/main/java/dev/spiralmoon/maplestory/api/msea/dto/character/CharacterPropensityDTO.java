package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * Character traits information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterPropensityDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterPropensityDTO {

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    @JsonProperty("date")
    private String date;

    /**
     * Ambition level
     */
    @JsonProperty("charisma_level")
    private Integer charismaLevel;

    /**
     * Empathy level
     */
    @JsonProperty("sensibility_level")
    private Integer sensibilityLevel;

    /**
     * Insight level
     */
    @JsonProperty("insight_level")
    private Integer insightLevel;

    /**
     * Willpower level
     */
    @JsonProperty("willingness_level")
    private Integer willingnessLevel;

    /**
     * Diligence level
     */
    @JsonProperty("handicraft_level")
    private Integer handicraftLevel;

    /**
     * Charm level
     */
    @JsonProperty("charm_level")
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
