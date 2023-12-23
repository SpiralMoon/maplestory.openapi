package dev.spiralmoon.maplestory.api.dto;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 캐릭터 HEXA 스탯 코어 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterHexaMatrixStatCoreDTO {

    /**
     * 슬롯 인덱스
     */
    @SerializedName("slot_id")
    private String slotId;

    /**
     * 메인 스탯 명
     */
    @SerializedName("main_stat_name")
    private String mainStatName;

    /**
     * 첫 번째 서브 명
     */
    @SerializedName("sub_stat_name_1")
    private String subStatName1;

    /**
     * 두 번째 서브 명
     */
    @SerializedName("sub_stat_name_2")
    private String subStatName2;

    /**
     * 메인 스탯 레벨
     */
    @SerializedName("main_stat_level")
    private long mainStatLevel;

    /**
     * 첫 번째 서브 레벨
     */
    @SerializedName("sub_stat_level_1")
    private long subStatLevel1;

    /**
     * 두 번째 서브 레벨
     */
    @SerializedName("sub_stat_level_2")
    private long subStatLevel2;

    /**
     * 스탯 코어 등급
     */
    @SerializedName("stat_grade")
    private long statGrade;
}
