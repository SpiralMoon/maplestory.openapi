package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Android hair information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterAndroidEquipmentHairDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAndroidEquipmentHairDTO {

    /**
     * Android hair name
     */
    @JsonProperty("hair_name")
    private String hairName;

    /**
     * Android base hair color
     */
    @JsonProperty("base_color")
    private String baseColor;

    /**
     * Android mixed hair color
     */
    @JsonProperty("mix_color")
    private String mixColor;

    /**
     * Dye ratio for Android mixed hair color
     */
    @JsonProperty("mix_rate")
    private String mixRate;

    /**
     * Freestyle Coupon application status (0:not applied, 1:applied)
     */
    @JsonProperty("freestyle_flag")
    private String freestyleFlag;

    /**
     * Freestyle Coupon application status
     */
    public boolean isFreestyleFlag() {
        return "1".equals(this.freestyleFlag);
    }
}
