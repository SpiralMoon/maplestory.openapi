package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 캐릭터 안드로이드 헤어 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterAndroidEquipmentHairDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAndroidEquipmentHairDTO {

    /**
     * 안드로이드 헤어 명
     */
    @SerializedName("hair_name")
    private String hairName;

    /**
     * 안드로이드 헤어 베이스 컬러
     */
    @SerializedName("base_color")
    private String baseColor;

    /**
     * 안드로이드 헤어 믹스 컬러
     */
    @SerializedName("mix_color")
    private String mixColor;

    /**
     * 안드로이드 헤어 믹스 컬러의 염색 비율
     */
    @SerializedName("mix_rate")
    private String mixRate;
}
