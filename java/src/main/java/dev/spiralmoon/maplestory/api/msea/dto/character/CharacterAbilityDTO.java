package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Character ability information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterAbilityDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAbilityDTO<
        CharacterAbilityInfoDTO,
        CharacterAbilityPresetDTO> {

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    @JsonProperty("date")
    private String date;

    /**
     * Ability grade
     */
    @JsonProperty("ability_grade")
    private String abilityGrade;

    /**
     * Ability information
     */
    @JsonProperty("ability_info")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterAbilityInfoDTO> abilityInfo;

    /**
     * Owned Honor EXP
     */
    @JsonProperty("remain_fame")
    private long remainFame;

    /**
     * Active ability preset number
     */
    @JsonProperty("preset_no")
    private Integer presetNo;

    /**
     * Complete information for Ability Preset 1
     */
    @JsonProperty("ability_preset_1")
    private CharacterAbilityPresetDTO abilityPreset1;

    /**
     * Complete information for Ability Preset 2
     */
    @JsonProperty("ability_preset_2")
    private CharacterAbilityPresetDTO abilityPreset2;

    /**
     * Complete information for Ability Preset 3
     */
    @JsonProperty("ability_preset_3")
    private CharacterAbilityPresetDTO abilityPreset3;

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    public ZonedDateTime getDate() {
        return date != null ? Utils.toZonedDateTime(this.date) : null;
    }
}
