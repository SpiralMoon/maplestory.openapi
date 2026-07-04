package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 選項訊息
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterFamiliarInfoOptionDTO {

    /**
     * 選項號
     */
    @JsonProperty("option_no")
    private long optionNo;

    /**
     * 選項名稱
     */
    @JsonProperty("option_name")
    private String optionName;

    /**
     * 選擇權價值
     */
    @JsonProperty("option_value")
    private String optionValue;
}
