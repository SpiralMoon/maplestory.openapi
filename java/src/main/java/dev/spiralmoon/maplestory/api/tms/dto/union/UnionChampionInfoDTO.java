package dev.spiralmoon.maplestory.api.tms.dto.union;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 聯盟冠軍資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UnionChampionInfoDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionChampionInfoDTO<UnionChampionBadgeInfoDTO> {

    /**
     * 聯盟冠軍角色名稱
     */
    @JsonProperty("champion_name")
    private String championName;

    /**
     * 聯盟冠軍欄位
     */
    @JsonProperty("champion_slot")
    private int championSlot;

    /**
     * 聯盟冠軍等級
     */
    @JsonProperty("champion_grade")
    private String championGrade;

    /**
     * 聯盟冠軍角色職業
     */
    @JsonProperty("champion_class")
    private String championClass;

    /**
     * 聯盟冠軍徽章資訊
     */
    @JsonProperty("champion_badge_info")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<UnionChampionBadgeInfoDTO> championBadgeInfo;
}
