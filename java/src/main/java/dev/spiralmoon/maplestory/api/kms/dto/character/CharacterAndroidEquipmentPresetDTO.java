package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 캐릭터 안드로이드 프리셋 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterAndroidEquipmentPresetDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAndroidEquipmentPresetDTO<
        CharacterAndroidEquipmentHairDTO,
        CharacterAndroidEquipmentFaceDTO,
        CharacterAndroidEquipmentSkinDTO> {

    /**
     * 안드로이드 명
     */
    @JsonProperty("android_name")
    private String androidName;

    /**
     * 안드로이드 닉네임
     */
    @JsonProperty("android_nickname")
    private String androidNickname;

    /**
     * 안드로이드 아이콘
     */
    @JsonProperty("android_icon")
    private String androidIcon;

    /**
     * 안드로이드 아이템 설명
     */
    @JsonProperty("android_description")
    private String androidDescription;

    /**
     * 안드로이드 성별
     */
    @JsonProperty("android_gender")
    private String androidGender;

    /**
     * 안드로이드 등급
     */
    @JsonProperty("android_grade")
    private String androidGrade;

    /**
     * 안드로이드 헤어 정보
     */
    @JsonProperty("android_hair")
    private CharacterAndroidEquipmentHairDTO androidHair;

    /**
     * 안드로이드 성형 정보
     */
    @JsonProperty("android_face")
    private CharacterAndroidEquipmentFaceDTO androidFace;

    /**
     * 안드로이드 피부 정보
     */
    @JsonProperty("android_skin")
    private CharacterAndroidEquipmentSkinDTO androidSkin;

    /**
     * 안드로이드 이어센서 클립 적용 여부
     */
    @JsonProperty("android_ear_sensor_clip_flag")
    private String androidEarSensorClipFlag;

    /**
     * 비인간형 안드로이드 여부
     */
    @JsonProperty("android_non_humanoid_flag")
    private String androidNonHumanoidFlag;

    /**
     * 잡화상점 기능 이용 가능 여부
     */
    @JsonProperty("android_shop_usable_flag")
    private String androidShopUsableFlag;
}
