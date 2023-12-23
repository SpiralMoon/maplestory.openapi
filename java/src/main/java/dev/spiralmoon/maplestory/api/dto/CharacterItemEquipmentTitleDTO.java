package dev.spiralmoon.maplestory.api.dto;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 캐릭터 칭호 아이템 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterItemEquipmentTitleDTO {

    /**
     * 칭호 장비 명
     */
    @SerializedName("title_name")
    private String titleName;

    /**
     * 칭호 아이콘
     */
    @SerializedName("title_icon")
    private String titleIcon;

    /**
     * 칭호 설명
     */
    @SerializedName("title_description")
    private String titleDescription;

    /**
     * 칭호 유효 기간 (KST)
     */
    @SerializedName("date_expire")
    private String dateExpire;

    /**
     * 칭호 옵션 유효 기간 (expired:만료, null:무제한) (KST)
     */
    @SerializedName("date_option_expire")
    private String dateOptionExpire;
}
