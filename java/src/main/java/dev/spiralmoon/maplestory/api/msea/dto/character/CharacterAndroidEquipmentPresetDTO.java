package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Android preset information
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
     * Android name
     */
    @JsonProperty("android_name")
    private String androidName;

    /**
     * Android nickname
     */
    @JsonProperty("android_nickname")
    private String androidNickname;

    /**
     * Android icon
     */
    @JsonProperty("android_icon")
    private String androidIcon;

    /**
     * Android item description
     */
    @JsonProperty("android_description")
    private String androidDescription;

    /**
     * Android gender
     */
    @JsonProperty("android_gender")
    private String androidGender;

    /**
     * Android grade
     */
    @JsonProperty("android_grade")
    private String androidGrade;

    /**
     * Android hair information
     */
    @JsonProperty("android_hair")
    private CharacterAndroidEquipmentHairDTO androidHair;

    /**
     * Android face information
     */
    @JsonProperty("android_face")
    private CharacterAndroidEquipmentFaceDTO androidFace;

    /**
     * Android skin information
     */
    @JsonProperty("android_skin")
    private CharacterAndroidEquipmentSkinDTO androidSkin;

    /**
     * Whether the Android ear sensor clip is applied
     */
    @JsonProperty("android_ear_sensor_clip_flag")
    private String androidEarSensorClipFlag;

    /**
     * Whether the Android is non-humanoid
     */
    @JsonProperty("android_non_humanoid_flag")
    private String androidNonHumanoidFlag;

    /**
     * Whether the Android can use the general store functionality
     */
    @JsonProperty("android_shop_usable_flag")
    private String androidShopUsableFlag;
}
