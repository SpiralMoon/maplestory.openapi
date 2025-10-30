package dev.spiralmoon.maplestory.api.tms.dto.character;

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
 * 角色已裝備機器人資訊
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
     * 要搜尋的日期 (TST)
     */
    @JsonProperty("date")
    private String date;

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
     * 機器人的已裝備現金道具資訊
     */
    @JsonProperty("android_cash_item_equipment")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterAndroidCashItemEquipmentDTO> androidCashItemEquipment;

    /**
     * 機器人耳飾感應器
     */
    @JsonProperty("android_ear_sensor_clip_flag")
    private String androidEarSensorClipFlag;

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
     * 非人型機器人
     */
    @JsonProperty("android_non_humanoid_flag")
    private String androidNonHumanoidFlag;

    /**
     * 是否具備雜貨店功能
     */
    @JsonProperty("android_shop_usable_flag")
    private String androidShopUsableFlag;

    /**
     * 目前套用的道具預設編號
     */
    @JsonProperty("preset_no")
    private Integer presetNo;

    /**
     * 預設 1 的機器人資訊
     */
    @JsonProperty("android_preset_1")
    private CharacterAndroidEquipmentPresetDTO androidPreset1;

    /**
     * 預設 2 的機器人資訊
     */
    @JsonProperty("android_preset_2")
    private CharacterAndroidEquipmentPresetDTO androidPreset2;

    /**
     * 預設 3 的機器人資訊
     */
    @JsonProperty("android_preset_3")
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
