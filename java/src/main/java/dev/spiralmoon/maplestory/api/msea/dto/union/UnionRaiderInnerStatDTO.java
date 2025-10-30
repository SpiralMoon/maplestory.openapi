package dev.spiralmoon.maplestory.api.msea.dto.union;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Union raider deployment information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UnionRaiderInnerStatDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionRaiderInnerStatDTO {

    /**
     * Raider deployment position (0 to 7, clockwise from 11 o'clock)
     */
    @JsonProperty("stat_field_id")
    private String statFieldId;

    /**
     * Occupation effects over the area
     */
    @JsonProperty("stat_field_effect")
    private String statFieldEffect;
}
