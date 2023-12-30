package dev.spiralmoon.maplestory.api.dto;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
     * 칭호 옵션 유효 기간 (KST)
     */
    @SerializedName("date_option_expire")
    private String dateOptionExpire;

    private LocalDateTime getDateExpire() {
        return this.dateExpire != null ? Utils.toLocalDateTime(this.dateExpire) : null;
    }

    private LocalDateTime getDateOptionExpire() {
        if (this.dateOptionExpire != null && !"expired".equals(this.dateOptionExpire)) {
            return Utils.toLocalDateTime(this.dateOptionExpire);
        } else {
            return null;
        }
    }

    /**
     * 칭호 옵션 유효 기간 만료 여부
     */
    private Boolean isOptionExpired() {

        if (this.dateOptionExpire == null) {
            return null;
        }

        return "expired".equals(this.dateOptionExpire);
    }
}
