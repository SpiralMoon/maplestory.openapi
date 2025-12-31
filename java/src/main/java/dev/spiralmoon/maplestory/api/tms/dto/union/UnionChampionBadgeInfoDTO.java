package dev.spiralmoon.maplestory.api.tms.dto.union;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 聯盟冠軍徽章資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UnionChampionBadgeInfoDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionChampionBadgeInfoDTO {

    /**
     * 聯盟冠軍徽章資訊
     */
    @JsonProperty("stat")
    private String stat;
}
