package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * 캐릭터 칭호 아이템 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterItemEquipmentTitleDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterItemEquipmentTitleDTO {

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

    /**
     * 칭호 유효 기간 (KST)
     */
    public ZonedDateTime getDateExpire() {
        if (this.dateExpire != null && !"expired".equals(this.dateExpire)) {
            return Utils.toZonedDateTime(this.dateExpire);
        } else {
            return null;
        }
    }

    /**
     * 칭호 옵션 유효 기간 (KST)
     */
    public ZonedDateTime getDateOptionExpire() {
        if (this.dateOptionExpire != null && !"expired".equals(this.dateOptionExpire)) {
            return Utils.toZonedDateTime(this.dateOptionExpire);
        } else {
            return null;
        }
    }

    /**
     * 칭호 유효 기간 만료 여부
     */
    public Boolean isExpired() {

        if (this.dateExpire == null) {
            return null;
        }

        return "expired".equals(this.dateExpire);
    }

    /**
     * 칭호 옵션 유효 기간 만료 여부
     */
    public Boolean isOptionExpired() {

        if (this.dateOptionExpire == null) {
            return null;
        }

        return "expired".equals(this.dateOptionExpire);
    }

    /**
     * 외형 설정에 등록한 칭호 장비 명
     */
    @SerializedName("title_shape_name")
    private String titleShapeName;

    /**
     * 외형 설정에 등록한 칭호 아이콘
     */
    @SerializedName("title_shape_icon")
    private String titleShapeIcon;

    /**
     * 외형 설정에 등록한 칭호 설명
     */
    @SerializedName("title_shape_description")
    private String titleShapeDescription;
}
