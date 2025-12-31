package dev.spiralmoon.maplestory.api.msea.dto.union;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * Union Champion information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UnionChampionInfoDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionChampionInfoDTO<UnionChampionBadgeInfoDTO> {

    /**
     * Union Champion character name
     */
    @JsonProperty("champion_name")
    private String championName;

    /**
     * Union Champion slot
     */
    @JsonProperty("champion_slot")
    private int championSlot;

    /**
     * Union Champion level
     */
    @JsonProperty("champion_grade")
    private String championGrade;

    /**
     * Union Champion character's job
     */
    @JsonProperty("champion_class")
    private String championClass;

    /**
     * Union Champion Insignia information
     */
    @JsonProperty("champion_badge_info")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<UnionChampionBadgeInfoDTO> championBadgeInfo;
}
