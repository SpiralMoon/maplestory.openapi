package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 캐릭터 어빌리티 프리셋 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterAbilityPresetDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAbilityPresetDTO<
        CharacterAbilityInfoDTO> {

    /**
     * 프리셋의 어빌리티 등급
     */
    @JsonProperty("ability_preset_grade")
    private String abilityPresetGrade;

    /**
     * 프리셋의 어빌리티 정보
     */
    @JsonProperty("ability_info")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterAbilityInfoDTO> abilityInfo;
}
