package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 預設的機器人資訊
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterAndroidEquipmentPresetDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAndroidEquipmentPresetDTO<CharacterAndroidEquipmentHairDTO, CharacterAndroidEquipmentFaceDTO, CharacterAndroidEquipmentSkinDTO> {

    /**
     * 機器人名稱
     */
    @SerializedName("android_name")
    private String androidName;

    /**
     * 機器人暱稱
     */
    @SerializedName("android_nickname")
    private String androidNickname;

    /**
     * 機器人圖示
     */
    @SerializedName("android_icon")
    private String androidIcon;

    /**
     * 機器人道具描述
     */
    @SerializedName("android_description")
    private String androidDescription;

    /**
     * 機器人性別
     */
    @SerializedName("android_gender")
    private String androidGender;

    /**
     * 機器人階級
     */
    @SerializedName("android_grade")
    private String androidGrade;

    /**
     * 機器人髮型資訊
     */
    @SerializedName("android_hair")
    private CharacterAndroidEquipmentHairDTO androidHair;

    /**
     * 機器人臉型資訊
     */
    @SerializedName("android_face")
    private CharacterAndroidEquipmentFaceDTO androidFace;

    /**
     * 機器人膚色資訊
     */
    @SerializedName("android_skin")
    private CharacterAndroidEquipmentSkinDTO androidSkin;

    /**
     * 機器人耳飾感應器
     */
    @SerializedName("android_ear_sensor_clip_flag")
    private String androidEarSensorClipFlag;

    /**
     * 非人型機器人
     */
    @SerializedName("android_non_humanoid_flag")
    private String androidNonHumanoidFlag;

    /**
     * 是否具備雜貨店功能
     */
    @SerializedName("android_shop_usable_flag")
    private String androidShopUsableFlag;
}
