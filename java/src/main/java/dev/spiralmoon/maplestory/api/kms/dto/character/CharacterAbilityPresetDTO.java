package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 캐릭터 어빌리티 프리셋 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterAbilityPresetDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAbilityPresetDTO<
        CharacterAbilityInfoDTO> {

    /**
     * 프리셋의 어빌리티 등급
     */
    @SerializedName("ability_preset_grade")
    private String abilityPresetGrade;

    /**
     * 프리셋의 어빌리티 정보
     */
    @SerializedName("ability_info")
    private List<CharacterAbilityInfoDTO> abilityInfo;
}
