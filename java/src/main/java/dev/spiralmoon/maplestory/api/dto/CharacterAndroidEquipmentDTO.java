package dev.spiralmoon.maplestory.api.dto;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 캐릭터 안드로이드 장비 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterAndroidEquipmentDTO {

    /**
     * 조회 기준일 (KST)
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
     * 안드로이드 피부 명
     */
    @SerializedName("android_skin_name")
    private String androidSkinName;

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
}
