package dev.spiralmoon.maplestory.api.tms.dto.union;

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
 * 聯盟冠軍資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UnionChampionDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionChampionDTO<
        UnionChampionInfoDTO,
        UnionChampionBadgeInfoDTO> {

    /**
     * 查詢基準日（TST，以日為單位，時與分一律標示為 0）
     */
    @JsonProperty("date")
    private String date;

    /**
     * 聯盟冠軍資訊
     */
    @JsonProperty("union_champion")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<UnionChampionInfoDTO> unionChampion;

    /**
     * 冠軍徽章效果
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
