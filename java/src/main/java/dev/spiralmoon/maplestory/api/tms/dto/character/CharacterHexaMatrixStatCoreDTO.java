package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * HEXA 屬性核心資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterHexaMatrixStatCoreDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterHexaMatrixStatCoreDTO {

    /**
     * 欄位索引
     */
    @JsonProperty("slot_id")
    private String slotId;

    /**
     * 主要屬性名稱
     */
    @JsonProperty("main_stat_name")
    private String mainStatName;

    /**
     * 第一副屬性名稱
     */
    @JsonProperty("sub_stat_name_1")
    private String subStatName1;

    /**
     * 第二副屬性名稱
     */
    @JsonProperty("sub_stat_name_2")
    private String subStatName2;

    /**
     * 主要屬性等級
     */
    @JsonProperty("main_stat_level")
    private long mainStatLevel;

    /**
     * 第一副屬性等級
     */
    @JsonProperty("sub_stat_level_1")
    private long subStatLevel1;

    /**
     * 第二副屬性等級
     */
    @JsonProperty("sub_stat_level_2")
    private long subStatLevel2;

    /**
     * 屬性核心階級
     */
    @JsonProperty("stat_grade")
    private long statGrade;
}
