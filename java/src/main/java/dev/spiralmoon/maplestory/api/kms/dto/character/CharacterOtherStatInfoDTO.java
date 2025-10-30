package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 스탯 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterOtherStatInfoDTO {

    /**
     * 스탯 명
     */
    @JsonProperty("stat_name")
    private String statName;

    /**
     * 스탯 값
     */
    @JsonProperty("stat_value")
    private String statValue;
}
