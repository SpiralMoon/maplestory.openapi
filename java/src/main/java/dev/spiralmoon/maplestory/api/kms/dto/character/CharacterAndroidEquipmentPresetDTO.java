package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 캐릭터 안드로이드 프리셋 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterAndroidEquipmentPresetDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAndroidEquipmentPresetDTO<
        CharacterAndroidEquipmentHairDTO,
        CharacterAndroidEquipmentFaceDTO,
        CharacterAndroidEquipmentSkinDTO> {

    /**
     * 안드로이드 명
     */
    @SerializedName("android_name")
    private String androidName;

    /**
     * 안드로이드 닉네임
     */
    @SerializedName("android_nickname")
    private String androidNickname;

    /**
     * 안드로이드 아이콘
     */
    @SerializedName("android_icon")
    private String androidIcon;

    /**
     * 안드로이드 아이템 설명
     */
    @SerializedName("android_description")
    private String androidDescription;

    /**
     * 안드로이드 성별
     */
    @SerializedName("android_gender")
    private String androidGender;

    /**
     * 안드로이드 등급
     */
    @SerializedName("android_grade")
    private String androidGrade;

    /**
     * 안드로이드 헤어 정보
     */
    @SerializedName("android_hair")
    private CharacterAndroidEquipmentHairDTO androidHair;

    /**
     * 안드로이드 성형 정보
     */
    @SerializedName("android_face")
    private CharacterAndroidEquipmentFaceDTO androidFace;

    /**
     * 안드로이드 피부 정보
     */
    @SerializedName("android_skin")
    private CharacterAndroidEquipmentSkinDTO androidSkin;

    /**
     * 안드로이드 이어센서 클립 적용 여부
     */
    @SerializedName("android_ear_sensor_clip_flag")
    private String androidEarSensorClipFlag;

    /**
     * 비인간형 안드로이드 여부
     */
    @SerializedName("android_non_humanoid_flag")
    private String androidNonHumanoidFlag;

    /**
     * 잡화상점 기능 이용 가능 여부
     */
    @SerializedName("android_shop_usable_flag")
    private String androidShopUsableFlag;
}
