package dev.spiralmoon.maplestory.api.dto;

import com.google.gson.annotations.SerializedName;

/**
 * 종합 랭킹 정보
 */
public class OverallRankingDTO {

    /**
     * 랭킹 업데이트 일자 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    @SerializedName("date")
    private String date;

    /**
     * 종합 랭킹 순위
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
     * 캐릭터 경험치
     */
    @SerializedName("character_exp")
    private long characterExp;

    /**
     * 캐릭터 인기도
     */
    @SerializedName("character_popularity")
    private int characterPopularity;

    /**
     * 길드 명
     */
    @SerializedName("character_guildname")
    private String characterGuildName;
}
