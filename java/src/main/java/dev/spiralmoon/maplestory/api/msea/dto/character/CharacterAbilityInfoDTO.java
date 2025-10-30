package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Information for Ability Preset
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterAbilityInfoDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAbilityInfoDTO {

    /**
     * Ability number
     */
    @JsonProperty("ability_no")
    private String abilityNo;

    /**
     * Ability grade
     */
    @JsonProperty("ability_grade")
    private String abilityGrade;

    /**
     * Ability option and value
     */
    @JsonProperty("ability_value")
    private String abilityValue;
}
