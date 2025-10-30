package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 能力資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterAbilityInfoDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAbilityInfoDTO {

    /**
     * 能力編號
     */
    @JsonProperty("ability_no")
    private String abilityNo;

    /**
     * 能力階級
     */
    @JsonProperty("ability_grade")
    private String abilityGrade;

    /**
     * 能力選項與數值
     */
    @JsonProperty("ability_value")
    private String abilityValue;
}
