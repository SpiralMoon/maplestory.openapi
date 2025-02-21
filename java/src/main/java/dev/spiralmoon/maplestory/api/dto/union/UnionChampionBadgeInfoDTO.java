package dev.spiralmoon.maplestory.api.dto.union;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 유니온 챔피언 휘장 정보
 */
@AllArgsConstructor
@Data
@ToString
public class UnionChampionBadgeInfoDTO {

    /**
     * 유니온 챔피언 휘장 효과
     */
    @SerializedName("stat")
    private String stat;
}
