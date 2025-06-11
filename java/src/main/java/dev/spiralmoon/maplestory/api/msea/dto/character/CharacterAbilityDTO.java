package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Character ability information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterAbilityDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAbilityDTO<
        CharacterAbilityInfoDTO,
        CharacterAbilityPresetDTO> {

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    @SerializedName("date")
    private String date;

    /**
     * Ability grade
     */
    @SerializedName("ability_grade")
    private String abilityGrade;

    /**
     * Ability information
     */
    @SerializedName("ability_info")
    private List<CharacterAbilityInfoDTO> abilityInfo;

    /**
     * Owned Honor EXP
     */
    @SerializedName("remain_fame")
    private Long remainFame;

    /**
     * Active ability preset number
     */
    @SerializedName("preset_no")
    private Integer presetNo;

    /**
     * Complete information for Ability Preset 1
     */
    @SerializedName("ability_preset_1")
    private CharacterAbilityPresetDTO abilityPreset1;

    /**
     * Complete information for Ability Preset 2
     */
    @SerializedName("ability_preset_2")
    private CharacterAbilityPresetDTO abilityPreset2;

    /**
     * Complete information for Ability Preset 3
     */
    @SerializedName("ability_preset_3")
    private CharacterAbilityPresetDTO abilityPreset3;

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    public ZonedDateTime getDate() {
        return date != null ? Utils.toZonedDateTime(this.date) : null;
    }
}
