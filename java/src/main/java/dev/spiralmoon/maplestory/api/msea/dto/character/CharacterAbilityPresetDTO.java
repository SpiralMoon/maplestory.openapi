package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Character ability preset information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterAbilityPresetDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAbilityPresetDTO<
        CharacterAbilityInfoDTO> {

    /**
     * Ability grade for Preset
     */
    @SerializedName("ability_preset_grade")
    private String abilityPresetGrade;

    /**
     * Information for Ability Preset
     */
    @SerializedName("ability_info")
    private List<CharacterAbilityInfoDTO> abilityInfo;
}
