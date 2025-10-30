package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 預設的機器人資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterAndroidEquipmentPresetDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAndroidEquipmentPresetDTO<CharacterAndroidEquipmentHairDTO, CharacterAndroidEquipmentFaceDTO, CharacterAndroidEquipmentSkinDTO> {

    /**
     * 機器人名稱
     */
    @JsonProperty("android_name")
    private String androidName;

    /**
     * 機器人暱稱
     */
    @JsonProperty("android_nickname")
    private String androidNickname;

    /**
     * 機器人圖示
     */
    @JsonProperty("android_icon")
    private String androidIcon;

    /**
     * 機器人道具描述
     */
    @JsonProperty("android_description")
    private String androidDescription;

    /**
     * 機器人性別
     */
    @JsonProperty("android_gender")
    private String androidGender;

    /**
     * 機器人階級
     */
    @JsonProperty("android_grade")
    private String androidGrade;

    /**
     * 機器人髮型資訊
     */
    @JsonProperty("android_hair")
    private CharacterAndroidEquipmentHairDTO androidHair;

    /**
     * 機器人臉型資訊
     */
    @JsonProperty("android_face")
    private CharacterAndroidEquipmentFaceDTO androidFace;

    /**
     * 機器人膚色資訊
     */
    @JsonProperty("android_skin")
    private CharacterAndroidEquipmentSkinDTO androidSkin;

    /**
     * 機器人耳飾感應器
     */
    @JsonProperty("android_ear_sensor_clip_flag")
    private String androidEarSensorClipFlag;

    /**
     * 非人型機器人
     */
    @JsonProperty("android_non_humanoid_flag")
    private String androidNonHumanoidFlag;

    /**
     * 是否具備雜貨店功能
     */
    @JsonProperty("android_shop_usable_flag")
    private String androidShopUsableFlag;
}
