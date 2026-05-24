package dev.spiralmoon.maplestory.api.kms.dto.battlepractice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 연무장 입장 시 캐릭터 기타 스탯 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeCharacterOtherStatInfoDTO {

    /**
     * 스탯 명
     */
    @JsonProperty("stat_name")
    private String statName;

    /**
     * 스탯 값
     */
    @JsonProperty("stat_value")
    private String statValue;
}
