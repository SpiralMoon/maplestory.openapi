package dev.spiralmoon.maplestory.api.msea.dto.union;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Union Champion Insignia information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UnionChampionBadgeInfoDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionChampionBadgeInfoDTO {

    /**
     * Union Champion Insignia information
     */
    @JsonProperty("stat")
    private String stat;
}
