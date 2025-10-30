package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * Character ability preset information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterAbilityPresetDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAbilityPresetDTO<
        CharacterAbilityInfoDTO> {

    /**
     * Ability grade for Preset
     */
    @JsonProperty("ability_preset_grade")
    private String abilityPresetGrade;

    /**
     * Information for Ability Preset
     */
    @JsonProperty("ability_info")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterAbilityInfoDTO> abilityInfo;
}
