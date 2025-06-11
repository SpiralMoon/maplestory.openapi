package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * 캐릭터의 무릉도장 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterDojangDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterDojangDTO {

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
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
    private Integer dojangBestFloor;

    /**
     * 무릉도장 최고 기록 달성 일 (KST)
     */
    @SerializedName("date_dojang_record")
    private String dateDojangRecord;

    /**
     * 무릉도장 최고 층수 클리어에 걸린 시간 (초)
     */
    @SerializedName("dojang_best_time")
    private Integer dojangBestTime;

    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }

    public ZonedDateTime getDateDojangRecord() {
        return this.dateDojangRecord != null ? Utils.toZonedDateTime(this.dateDojangRecord) : null;
    }
}
