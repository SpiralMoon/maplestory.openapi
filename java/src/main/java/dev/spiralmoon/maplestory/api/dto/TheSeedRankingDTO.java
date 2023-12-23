package dev.spiralmoon.maplestory.api.dto;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 더 시드 랭킹 정보
 */
@AllArgsConstructor
@Data
@ToString

public class TheSeedRankingDTO {

    /**
     * 랭킹 업데이트 일자 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    @SerializedName("date")
    private String date;

    /**
     * 더 시드 랭킹 순위
     */
    @SerializedName("ranking")
    private int ranking;

    /**
     * 캐릭터 명
     */
    @SerializedName("character_name")
    private String characterName;

    /**
     * 월드 명
     */
    @SerializedName("world_name")
    private String worldName;

    /**
     * 직업 명
     */
    @SerializedName("class_name")
    private String className;

    /**
     * 전직 직업 명
     */
    @SerializedName("sub_class_name")
    private String subClassName;

    /**
     * 캐릭터 레벨
     */
    @SerializedName("character_level")
    private int characterLevel;

    /**
     * 더 시드 도달 층
     */
    @SerializedName("theseed_floor")
    private int theSeedFloor;

    /**
     * 더 시드 클리어 시간 기록 (초 단위)
     */
    @SerializedName("theseed_time_record")
    private int theSeedTimeRecord;
}
