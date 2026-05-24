package dev.spiralmoon.maplestory.api.kms.dto.battlepractice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 연무장 입장 시 캐릭터 어빌리티 상세 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeCharacterAbilityInfoDTO {

    /**
     * 어빌리티 번호
     */
    @JsonProperty("ability_no")
    private String abilityNo;

    /**
     * 어빌리티 등급
     */
    @JsonProperty("ability_grade")
    private String abilityGrade;

    /**
     * 어빌리티 옵션 및 수치
     */
    @JsonProperty("ability_value")
    private String abilityValue;
}
