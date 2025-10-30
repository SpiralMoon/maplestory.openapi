package dev.spiralmoon.maplestory.api.kms.dto.union;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 유니온 챔피언 상세 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UnionChampionInfoDTO {

    /**
     * 유니온 챔피언 캐릭터 명
     */
    @JsonProperty("champion_name")
    private String championName;

    /**
     * 유니온 챔피언 슬롯
     */
    @JsonProperty("champion_slot")
    private int championSlot;

    /**
     * 유니온 챔피언 등급
     */
    @JsonProperty("champion_grade")
    private String championGrade;

    /**
     * 유니온 챔피언 캐릭터의 직업
     */
    @JsonProperty("champion_class")
    private String championClass;

    /**
     * 챔피언 휘장 효과
     */
    @JsonProperty("champion_badge_info")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<UnionChampionBadgeInfoDTO> championBadgeInfo;
}
