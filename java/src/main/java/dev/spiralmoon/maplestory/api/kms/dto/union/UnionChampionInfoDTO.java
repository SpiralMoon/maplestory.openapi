package dev.spiralmoon.maplestory.api.kms.dto.union;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 유니온 챔피언 상세 정보
 */
@AllArgsConstructor
@Data
@ToString
public class UnionChampionInfoDTO {

    /**
     * 유니온 챔피언 캐릭터 명
     */
    @SerializedName("champion_name")
    private String championName;

    /**
     * 유니온 챔피언 슬롯
     */
    @SerializedName("champion_slot")
    private int championSlot;

    /**
     * 유니온 챔피언 등급
     */
    @SerializedName("champion_grade")
    private String championGrade;

    /**
     * 유니온 챔피언 캐릭터의 직업
     */
    @SerializedName("champion_class")
    private String championClass;

    /**
     * 챔피언 휘장 효과
     */
    @SerializedName("champion_badge_info")
    private List<UnionChampionBadgeInfoDTO> championBadgeInfo;
}
