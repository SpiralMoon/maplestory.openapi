package dev.spiralmoon.maplestory.api.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 캐릭터 어빌리티 상세 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterAbilityInfoDTO {

    /**
     * 어빌리티 번호
     */
    @SerializedName("ability_no")
    private String abilityNo;

    /**
     * 어빌리티 등급
     */
    @SerializedName("ability_grade")
    private String abilityGrade;

    /**
     * 어빌리티 옵션 및 수치
     */
    @SerializedName("ability_value")
    private String abilityValue;
}
