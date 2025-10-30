package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 能力預設完整資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterAbilityPresetDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAbilityPresetDTO<CharacterAbilityInfoDTO> {

    /**
     * 能力預設能力階級
     */
    @JsonProperty("ability_preset_grade")
    private String abilityPresetGrade;

    /**
     * 能力預設資訊
     */
    @JsonProperty("ability_info")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterAbilityInfoDTO> abilityInfo;
}
