package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * 캐릭터의 무릉도장 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterDojangDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterDojangDTO {

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    @JsonProperty("date")
    private String date;

    /**
     * 캐릭터 직업
     */
    @JsonProperty("character_class")
    private String characterClass;

    /**
     * 월드 명
     */
    @JsonProperty("world_name")
    private String worldName;

    /**
     * 무릉도장 최고 기록 층수
     */
    @JsonProperty("dojang_best_floor")
    private int dojangBestFloor;

    /**
     * 무릉도장 최고 기록 달성 일 (KST)
     */
    @JsonProperty("date_dojang_record")
    private String dateDojangRecord;

    /**
     * 무릉도장 최고 층수 클리어에 걸린 시간 (초)
     */
    @JsonProperty("dojang_best_time")
    private int dojangBestTime;

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }

    /**
     * 무릉도장 최고 기록 달성 일 (KST)
     */
    public ZonedDateTime getDateDojangRecord() {
        return this.dateDojangRecord != null ? Utils.toZonedDateTime(this.dateDojangRecord) : null;
    }
}
