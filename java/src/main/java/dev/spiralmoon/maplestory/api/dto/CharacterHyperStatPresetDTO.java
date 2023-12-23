package dev.spiralmoon.maplestory.api.dto;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 하이퍼 스탯 프리셋 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterHyperStatPresetDTO {

    /**
     * 스탯 종류
     */
    @SerializedName("stat_type")
    private String statType;

    /**
     * 스탯 투자 포인트
     */
    @SerializedName("stat_point")
    private long statPoint;

    /**
     * 스탯 레벨
     */
    @SerializedName("stat_level")
    private long statLevel;

    /**
     * 스탯 상승량
     */
    @SerializedName("stat_increase")
    private String statIncrease;
}
