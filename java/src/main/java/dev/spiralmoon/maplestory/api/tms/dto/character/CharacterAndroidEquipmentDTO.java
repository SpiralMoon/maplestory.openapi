package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * 角色已裝備機器人資訊
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
     * 要搜尋的日期 (TST)
     */
    @SerializedName("date")
    private String date;

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
     * 機器人的已裝備現金道具資訊
     */
    @SerializedName("android_cash_item_equipment")
    private List<CharacterAndroidCashItemEquipmentDTO> androidCashItemEquipment;

    /**
     * 機器人耳飾感應器
     */
    @SerializedName("android_ear_sensor_clip_flag")
    private String androidEarSensorClipFlag;

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
     * 非人型機器人
     */
    @SerializedName("android_non_humanoid_flag")
    private String androidNonHumanoidFlag;

    /**
     * 是否具備雜貨店功能
     */
    @SerializedName("android_shop_usable_flag")
    private String androidShopUsableFlag;

    /**
     * 目前套用的道具預設編號
     */
    @SerializedName("preset_no")
    private Integer presetNo;

    /**
     * 預設 1 的機器人資訊
     */
    @SerializedName("android_preset_1")
    private CharacterAndroidEquipmentPresetDTO androidPreset1;

    /**
     * 預設 2 的機器人資訊
     */
    @SerializedName("android_preset_2")
    private CharacterAndroidEquipmentPresetDTO androidPreset2;

    /**
     * 預設 3 的機器人資訊
     */
    @SerializedName("android_preset_3")
    private CharacterAndroidEquipmentPresetDTO androidPreset3;

    /**
     * 要搜尋的日期 (TST)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
