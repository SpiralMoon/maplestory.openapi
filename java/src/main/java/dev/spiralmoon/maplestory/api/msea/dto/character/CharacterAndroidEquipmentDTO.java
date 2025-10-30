package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Character android equipment information
 */
@AllArgsConstructor
@NoArgsConstructor
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
    @JsonProperty("date")
    private String date;

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
     * Android cash item equipment information
     */
    @JsonProperty("android_cash_item_equipment")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterAndroidCashItemEquipmentDTO> androidCashItemEquipment;

    /**
     * Whether the Android ear sensor clip is applied
     */
    @JsonProperty("android_ear_sensor_clip_flag")
    private String androidEarSensorClipFlag;

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
     * Whether the Android is non-humanoid
     */
    @JsonProperty("android_non_humanoid_flag")
    private String androidNonHumanoidFlag;

    /**
     * Whether the Android can use the general store functionality
     */
    @JsonProperty("android_shop_usable_flag")
    private String androidShopUsableFlag;

    /**
     * Active equipment preset number
     */
    @JsonProperty("preset_no")
    private Integer presetNo;

    /**
     * Android information for preset 1
     */
    @JsonProperty("android_preset_1")
    private CharacterAndroidEquipmentPresetDTO androidPreset1;

    /**
     * Android information for preset 2
     */
    @JsonProperty("android_preset_2")
    private CharacterAndroidEquipmentPresetDTO androidPreset2;

    /**
     * Android information for preset 3
     */
    @JsonProperty("android_preset_3")
    private CharacterAndroidEquipmentPresetDTO androidPreset3;

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    public ZonedDateTime getDate() {
        return date != null ? Utils.toZonedDateTime(this.date) : null;
    }
}
