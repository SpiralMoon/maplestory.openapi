package dev.spiralmoon.maplestory.api.dto;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 캐릭터 현재 스탯 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterFinalStatDTO {

    /**
     * 스탯 명
     */
    @SerializedName("stat_name")
    private String statName;

    /**
     * 스탯 값
     */
    @SerializedName("stat_value")
    private String statValue;
}