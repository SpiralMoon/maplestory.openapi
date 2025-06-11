package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * 캐릭터 안드로이드 장비 정보
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
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    @SerializedName("date")
    private String date;

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
     * 안드로이드 캐시 아이템 장착 정보
     */
    @SerializedName("android_cash_item_equipment")
    private List<CharacterAndroidCashItemEquipmentDTO> androidCashItemEquipment;

    /**
     * 안드로이드 이어센서 클립 적용 여부
     */
    @SerializedName("android_ear_sensor_clip_flag")
    private String androidEarSensorClipFlag;

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
     * 비인간형 안드로이드 여부
     */
    @SerializedName("android_non_humanoid_flag")
    private String androidNonHumanoidFlag;

    /**
     * 잡화상점 기능 이용 가능 여부
     */
    @SerializedName("android_shop_usable_flag")
    private String androidShopUsableFlag;

    /**
     * 적용 중인 장비 프리셋 번호
     */
    @SerializedName("preset_no")
    private Integer presetNo;

    /**
     * 1번 프리셋 안드로이드 정보
     */
    @SerializedName("android_preset_1")
    private CharacterAndroidEquipmentPresetDTO androidPreset1;

    /**
     * 2번 프리셋 안드로이드 정보
     */
    @SerializedName("android_preset_2")
    private CharacterAndroidEquipmentPresetDTO androidPreset2;

    /**
     * 3번 프리셋 안드로이드 정보
     */
    @SerializedName("android_preset_3")
    private CharacterAndroidEquipmentPresetDTO androidPreset3;

    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
