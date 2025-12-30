package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * Title information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterItemEquipmentTitleDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterItemEquipmentTitleDTO {

    /**
     * Title name
     */
    @JsonProperty("title_name")
    private String titleName;

    /**
     * Title icon
     */
    @JsonProperty("title_icon")
    private String titleIcon;

    /**
     * Title description
     */
    @JsonProperty("title_description")
    private String titleDescription;

    /**
     * Title validity period (SGT)
     */
    @JsonProperty("date_expire")
    private String dateExpire;

    /**
     * Title validity period (SGT)
     */
    public ZonedDateTime getDateExpire() {
        if (this.dateExpire != null && !"expired".equals(this.dateExpire)) {
            return Utils.toZonedDateTime(this.dateExpire);
        } else {
            return null;
        }
    }

    /**
     * Title option validity period (expired:expired, null unlimited) (SGT)
     */
    @JsonProperty("date_option_expire")
    private String dateOptionExpire;

    /**
     * Title option validity period (expired:expired, null unlimited) (SGT)
     */
    public ZonedDateTime getDateOptionExpire() {
        if (this.dateOptionExpire != null && !"expired".equals(this.dateOptionExpire)) {
            return Utils.toZonedDateTime(this.dateOptionExpire);
        } else {
            return null;
        }
    }

    /**
     * Whether the title is expired
     */
    public Boolean isExpired() {

        if (this.dateExpire == null) {
            return null;
        }

        return "expired".equals(this.dateExpire);
    }

    /**
     * Whether the title option is expired
     */
    public Boolean isOptionExpired() {

        if (this.dateOptionExpire == null) {
            return null;
        }

        return "expired".equals(this.dateOptionExpire);
    }

    /**
     * Title equipment name registered in the appearance settings
     */
    @JsonProperty("title_shape_name")
    private String titleShapeName;

    /**
     * Title icon registered in the appearance settings
     */
    @JsonProperty("title_shape_icon")
    private String titleShapeIcon;

    /**
     * Title description registered in the appearance settings
     */
    @JsonProperty("title_shape_description")
    private String titleShapeDescription;
}
