package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * 稱號資訊
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterItemEquipmentTitleDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterItemEquipmentTitleDTO {

    /**
     * 稱號道具名稱
     */
    @SerializedName("title_name")
    private String titleName;

    /**
     * 稱號圖示
     */
    @SerializedName("title_icon")
    private String titleIcon;

    /**
     * 稱號描述
     */
    @SerializedName("title_description")
    private String titleDescription;

    /**
     * 稱號有效期間 (TST)
     */
    @SerializedName("date_expire")
    private String dateExpire;

    /**
     * 稱號有效期間 (TST)
     */
    public ZonedDateTime getDateExpire() {
        if (this.dateExpire != null && !"expired".equals(this.dateExpire)) {
            return Utils.toZonedDateTime(this.dateExpire);
        } else {
            return null;
        }
    }

    /**
     * 稱號選項有效期間 (expired：已到期，null：無限期) (TST)
     */
    @SerializedName("date_option_expire")
    private String dateOptionExpire;

    /**
     * 稱號選項有效期間 (expired：已到期，null：無限期) (TST)
     */
    public ZonedDateTime getDateOptionExpire() {
        if (this.dateOptionExpire != null && !"expired".equals(this.dateOptionExpire)) {
            return Utils.toZonedDateTime(this.dateOptionExpire);
        } else {
            return null;
        }
    }

    /**
     * 外型設定中已登錄稱號的道具名稱
     */
    @SerializedName("title_shape_name")
    private String titleShapeName;

    /**
     * 外型設定中已登錄稱號的圖示
     */
    @SerializedName("title_shape_icon")
    private String titleShapeIcon;

    /**
     * 外型設定中已登錄稱號的描述
     */
    @SerializedName("title_shape_description")
    private String titleShapeDescription;

    /**
     * Whether the Android cash item is expired
     */
    public Boolean isExpired() {

        if (this.dateExpire == null) {
            return null;
        }

        return "expired".equals(this.dateExpire);
    }

    /**
     * Whether the Android cash item option is expired
     */
    public Boolean isOptionExpired() {

        if (this.dateOptionExpire == null) {
            return null;
        }

        return "expired".equals(this.dateOptionExpire);
    }
}