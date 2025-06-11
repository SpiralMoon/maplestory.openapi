package dev.spiralmoon.maplestory.api.kms.dto.union;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * 유니온 챔피언 정보
 */
@AllArgsConstructor
@Data
@ToString
public class UnionChampionDTO {

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    @SerializedName("date")
    private String date;

    /**
     * 유니온 챔피언 정보
     */
    @SerializedName("union_champion")
    private List<UnionChampionInfoDTO> unionChampion;

    /**
     * 유니온 챔피언 휘장 정보
     */
    @SerializedName("champion_badge_total_info")
    private List<UnionChampionBadgeInfoDTO> championBadgeTotalInfo;

    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
