package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Information for Ability Preset
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterAbilityInfoDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAbilityInfoDTO {

    /**
     * Ability number
     */
    @SerializedName("ability_no")
    private String abilityNo;

    /**
     * Ability grade
     */
    @SerializedName("ability_grade")
    private String abilityGrade;

    /**
     * Ability option and value
     */
    @SerializedName("ability_value")
    private String abilityValue;
}
