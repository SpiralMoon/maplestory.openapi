package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 캐릭터 안드로이드 성형 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterAndroidEquipmentFaceDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAndroidEquipmentFaceDTO {

    /**
     * 안드로이드 성형 명
     */
    @JsonProperty("face_name")
    private String faceName;

    /**
     * 안드로이드 성형 베이스 컬러
     */
    @JsonProperty("base_color")
    private String baseColor;

    /**
     * 안드로이드 성형 믹스 컬러
     */
    @JsonProperty("mix_color")
    private String mixColor;

    /**
     * 안드로이드 성형 믹스 컬러의 염색 비율
     */
    @JsonProperty("mix_rate")
    private String mixRate;

    /**
     * 프리스타일 쿠폰 적용 여부 (0:미적용, 1:적용)
     */
    @JsonProperty("freestyle_flag")
    private String freestyleFlag;

    /**
     * 프리스타일 쿠폰 적용 여부
     */
    public boolean isFreestyleFlag() {
        return this.freestyleFlag.equals("1");
    }
}
