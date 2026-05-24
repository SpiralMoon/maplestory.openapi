package dev.spiralmoon.maplestory.api.kms.dto.battlepractice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 연무장 입장 시 캐릭터 하이퍼 스탯 상세 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeCharacterHyperStatDTO {

    /**
     * 스탯 종류
     */
    @JsonProperty("stat_type")
    private String statType;

    /**
     * 스탯 레벨
     */
    @JsonProperty("stat_level")
    private Integer statLevel;

    /**
     * 스탯 상승량
     */
    @JsonProperty("stat_increase")
    private String statIncrease;
}
