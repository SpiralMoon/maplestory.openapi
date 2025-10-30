package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 캐릭터 HEXA 스탯 코어 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterHexaMatrixStatCoreDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterHexaMatrixStatCoreDTO {

    /**
     * 슬롯 인덱스
     */
    @JsonProperty("slot_id")
    private String slotId;

    /**
     * 메인 스탯 명
     */
    @JsonProperty("main_stat_name")
    private String mainStatName;

    /**
     * 첫 번째 서브 명
     */
    @JsonProperty("sub_stat_name_1")
    private String subStatName1;

    /**
     * 두 번째 서브 명
     */
    @JsonProperty("sub_stat_name_2")
    private String subStatName2;

    /**
     * 메인 스탯 레벨
     */
    @JsonProperty("main_stat_level")
    private long mainStatLevel;

    /**
     * 첫 번째 서브 레벨
     */
    @JsonProperty("sub_stat_level_1")
    private long subStatLevel1;

    /**
     * 두 번째 서브 레벨
     */
    @JsonProperty("sub_stat_level_2")
    private long subStatLevel2;

    /**
     * 스탯 코어 등급
     */
    @JsonProperty("stat_grade")
    private long statGrade;
}
