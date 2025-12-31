package dev.spiralmoon.maplestory.api.msea.dto.union;

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
 * Union Champion information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UnionChampionDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionChampionDTO<
        UnionChampionInfoDTO,
        UnionChampionBadgeInfoDTO> {

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    @JsonProperty("date")
    private String date;

    /**
     * Union Champion information
     */
    @JsonProperty("union_champion")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<UnionChampionInfoDTO> unionChampion;

    /**
     * Champion Insignia effects
     */
    @JsonProperty("champion_badge_total_info")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<UnionChampionBadgeInfoDTO> championBadgeTotalInfo;

    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
