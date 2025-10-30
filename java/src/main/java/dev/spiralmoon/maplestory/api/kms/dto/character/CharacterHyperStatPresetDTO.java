package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 하이퍼 스탯 프리셋 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterHyperStatPresetDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterHyperStatPresetDTO {

    /**
     * 스탯 종류
     */
    @JsonProperty("stat_type")
    private String statType;

    /**
     * 스탯 투자 포인트
     */
    @JsonProperty("stat_point")
    private long statPoint;

    /**
     * 스탯 레벨
     */
    @JsonProperty("stat_level")
    private long statLevel;

    /**
     * 스탯 상승량
     */
    @JsonProperty("stat_increase")
    private String statIncrease;
}
