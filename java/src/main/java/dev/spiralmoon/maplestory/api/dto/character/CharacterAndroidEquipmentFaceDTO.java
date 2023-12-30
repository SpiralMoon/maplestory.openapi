package dev.spiralmoon.maplestory.api.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 캐릭터 안드로이드 성형 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterAndroidEquipmentFaceDTO {

    /**
     * 안드로이드 성형 명
     */
    @SerializedName("face_name")
    private String faceName;

    /**
     * 안드로이드 성형 베이스 컬러
     */
    @SerializedName("base_color")
    private String baseColor;

    /**
     * 안드로이드 성형 믹스 컬러
     */
    @SerializedName("mix_color")
    private String mixColor;

    /**
     * 안드로이드 성형 믹스 컬러의 염색 비율
     */
    @SerializedName("mix_rate")
    private String mixRate;
}
