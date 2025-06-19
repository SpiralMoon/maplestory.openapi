package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 캐릭터 성형 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterBeautyEquipmentFaceDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterBeautyEquipmentFaceDTO {

    /**
     * 성형 명
     */
    @SerializedName("face_name")
    private String faceName;

    /**
     * 성형 베이스 컬러
     */
    @SerializedName("base_color")
    private String baseColor;

    /**
     * 성형 믹스 컬러
     */
    @SerializedName("mix_color")
    private String mixColor;

    /**
     * 성형 믹스 컬러의 염색 비율
     */
    @SerializedName("mix_rate")
    private String mixRate;

    /**
     * 프리스타일 쿠폰 적용 여부 (0:미적용, 1:적용)
     */
    @SerializedName("freestyle_flag")
    private String freestyleFlag;

    /**
     * 프리스타일 쿠폰 적용 여부
     */
    public boolean isFreestyleFlag() {
        return this.freestyleFlag.equals("1");
    }
}
