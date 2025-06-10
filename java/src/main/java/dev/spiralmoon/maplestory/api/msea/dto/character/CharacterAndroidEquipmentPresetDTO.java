package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Android preset information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterAndroidEquipmentPresetDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAndroidEquipmentPresetDTO<
        CharacterAndroidEquipmentHairDTO,
        CharacterAndroidEquipmentFaceDTO,
        CharacterAndroidEquipmentSkinDTO> {

    /**
     * Android name
     */
    @SerializedName("android_name")
    private String androidName;

    /**
     * Android nickname
     */
    @SerializedName("android_nickname")
    private String androidNickname;

    /**
     * Android icon
     */
    @SerializedName("android_icon")
    private String androidIcon;

    /**
     * Android item description
     */
    @SerializedName("android_description")
    private String androidDescription;

    /**
     * Android gender
     */
    @SerializedName("android_gender")
    private String androidGender;

    /**
     * Android grade
     */
    @SerializedName("android_grade")
    private String androidGrade;

    /**
     * Android hair information
     */
    @SerializedName("android_hair")
    private CharacterAndroidEquipmentHairDTO androidHair;

    /**
     * Android face information
     */
    @SerializedName("android_face")
    private CharacterAndroidEquipmentFaceDTO androidFace;

    /**
     * Android skin information
     */
    @SerializedName("android_skin")
    private CharacterAndroidEquipmentSkinDTO androidSkin;

    /**
     * Whether the Android ear sensor clip is applied
     */
    @SerializedName("android_ear_sensor_clip_flag")
    private String androidEarSensorClipFlag;

    /**
     * Whether the Android is non-humanoid
     */
    @SerializedName("android_non_humanoid_flag")
    private String androidNonHumanoidFlag;

    /**
     * Whether the Android can use the general store functionality
     */
    @SerializedName("android_shop_usable_flag")
    private String androidShopUsableFlag;
}
