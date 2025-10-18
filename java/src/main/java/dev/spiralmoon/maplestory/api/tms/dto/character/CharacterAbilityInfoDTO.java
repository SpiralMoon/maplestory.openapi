package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 能力資訊
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterAbilityInfoDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAbilityInfoDTO {

    /**
     * 能力編號
     */
    @SerializedName("ability_no")
    private String abilityNo;

    /**
     * 能力階級
     */
    @SerializedName("ability_grade")
    private String abilityGrade;

    /**
     * 能力選項與數值
     */
    @SerializedName("ability_value")
    private String abilityValue;
}
