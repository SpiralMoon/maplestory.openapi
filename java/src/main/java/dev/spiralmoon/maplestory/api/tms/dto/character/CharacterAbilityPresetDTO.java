package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 能力預設完整資訊
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterAbilityPresetDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAbilityPresetDTO<CharacterAbilityInfoDTO> {

    /**
     * 能力預設能力階級
     */
    @SerializedName("ability_preset_grade")
    private String abilityPresetGrade;

    /**
     * 能力預設資訊
     */
    @SerializedName("ability_info")
    private List<CharacterAbilityInfoDTO> abilityInfo;
}
