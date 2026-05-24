package dev.spiralmoon.maplestory.api.kms.dto.battlepractice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 연무장 입장 시 캐릭터 펫 장비 옵션
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeCharacterPetEquipmentItemOptionDTO {

    /**
     * 옵션 타입
     */
    @JsonProperty("option_type")
    private String optionType;

    /**
     * 옵션 값
     */
    @JsonProperty("option_value")
    private String optionValue;
}
