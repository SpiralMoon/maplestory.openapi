package dev.spiralmoon.maplestory.api.kms.dto.union;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 유니온 챔피언 휘장 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UnionChampionBadgeInfoDTO {

    /**
     * 유니온 챔피언 휘장 효과
     */
    @JsonProperty("stat")
    private String stat;
}
