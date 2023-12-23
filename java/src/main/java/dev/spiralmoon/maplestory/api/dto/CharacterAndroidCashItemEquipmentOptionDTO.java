package dev.spiralmoon.maplestory.api.dto;

import com.google.gson.annotations.SerializedName;

/**
 * 캐릭터 안드로이드 캐시 아이템 옵션 정보
 */
public class CharacterAndroidCashItemEquipmentOptionDTO {

    /**
     * 옵션 타입
     */
    @SerializedName("option_type")
    private String optionType;

    /**
     * 옵션 값
     */
    @SerializedName("option_value")
    private String optionValue;
}
