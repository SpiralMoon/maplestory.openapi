package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * HEXA 屬性核心資訊
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterHexaMatrixStatCoreDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterHexaMatrixStatCoreDTO {

    /**
     * 欄位索引
     */
    @SerializedName("slot_id")
    private String slotId;

    /**
     * 主要屬性名稱
     */
    @SerializedName("main_stat_name")
    private String mainStatName;

    /**
     * 第一副屬性名稱
     */
    @SerializedName("sub_stat_name_1")
    private String subStatName1;

    /**
     * 第二副屬性名稱
     */
    @SerializedName("sub_stat_name_2")
    private String subStatName2;

    /**
     * 主要屬性等級
     */
    @SerializedName("main_stat_level")
    private long mainStatLevel;

    /**
     * 第一副屬性等級
     */
    @SerializedName("sub_stat_level_1")
    private long subStatLevel1;

    /**
     * 第二副屬性等級
     */
    @SerializedName("sub_stat_level_2")
    private long subStatLevel2;

    /**
     * 屬性核心階級
     */
    @SerializedName("stat_grade")
    private long statGrade;
}
