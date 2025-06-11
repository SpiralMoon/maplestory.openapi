package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Character android equipment information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterAndroidEquipmentDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAndroidEquipmentDTO<
        CharacterAndroidEquipmentHairDTO,
        CharacterAndroidEquipmentFaceDTO,
        CharacterAndroidEquipmentSkinDTO,
        CharacterAndroidCashItemEquipmentDTO,
        CharacterAndroidEquipmentPresetDTO> {

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    @SerializedName("date")
    private String date;

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
     * Android cash item equipment information
     */
    @SerializedName("android_cash_item_equipment")
    private List<CharacterAndroidCashItemEquipmentDTO> androidCashItemEquipment;

    /**
     * Whether the Android ear sensor clip is applied
     */
    @SerializedName("android_ear_sensor_clip_flag")
    private String androidEarSensorClipFlag;

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
     * Whether the Android is non-humanoid
     */
    @SerializedName("android_non_humanoid_flag")
    private String androidNonHumanoidFlag;

    /**
     * Whether the Android can use the general store functionality
     */
    @SerializedName("android_shop_usable_flag")
    private String androidShopUsableFlag;

    /**
     * Active equipment preset number
     */
    @SerializedName("preset_no")
    private Integer presetNo;

    /**
     * Android information for preset 1
     */
    @SerializedName("android_preset_1")
    private CharacterAndroidEquipmentPresetDTO androidPreset1;

    /**
     * Android information for preset 2
     */
    @SerializedName("android_preset_2")
    private CharacterAndroidEquipmentPresetDTO androidPreset2;

    /**
     * Android information for preset 3
     */
    @SerializedName("android_preset_3")
    private CharacterAndroidEquipmentPresetDTO androidPreset3;

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    public ZonedDateTime getDate() {
        return date != null ? Utils.toZonedDateTime(this.date) : null;
    }
}
