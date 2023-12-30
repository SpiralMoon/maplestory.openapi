package dev.spiralmoon.maplestory.api.dto;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 캐릭터의 무릉도장 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterDojangDTO {

    /**
     * 조회 기준일 (KST)
     */
    @SerializedName("date")
    private String date;

    /**
     * 캐릭터 직업
     */
    @SerializedName("character_class")
    private String characterClass;

    /**
     * 월드 명
     */
    @SerializedName("world_name")
    private String worldName;

    /**
     * 무릉도장 최고 기록 층수
     */
    @SerializedName("dojang_best_floor")
    private long dojangBestFloor;

    /**
     * 무릉도장 최고 기록 달성 일 (KST)
     */
    @SerializedName("date_dojang_record")
    private String dateDojangRecord;

    /**
     * 무릉도장 최고 층수 클리어에 걸린 시간 (초)
     */
    @SerializedName("dojang_best_time")
    private long dojangBestTime;

    public LocalDateTime getDojangRecord() {
        return this.dateDojangRecord != null ? Utils.toLocalDateTime(this.dateDojangRecord) : null;
    }
}
