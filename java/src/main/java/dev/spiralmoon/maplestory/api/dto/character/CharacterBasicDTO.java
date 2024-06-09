package dev.spiralmoon.maplestory.api.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 캐릭터 기본 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterBasicDTO {

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    @SerializedName("date")
    private String date;

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
     * 캐릭터 성별
     */
    @SerializedName("character_gender")
    private String characterGender;

    /**
     * 캐릭터 직업
     */
    @SerializedName("character_class")
    private String characterClass;

    /**
     * 캐릭터 전직 차수
     */
    @SerializedName("character_class_level")
    private String characterClassLevel;

    /**
     * 캐릭터 레벨
     */
    @SerializedName("character_level")
    private long characterLevel;

    /**
     * 현재 레벨에서 보유한 경험치
     */
    @SerializedName("character_exp")
    private long characterExp;

    /**
     * 현재 레벨에서 경험치 퍼센트
     */
    @SerializedName("character_exp_rate")
    private String characterExpRate;

    /**
     * 캐릭터 소속 길드 명
     */
    @SerializedName("character_guild_name")
    private String characterGuildName;

    /**
     * 캐릭터 외형 이미지
     */
    @SerializedName("character_image")
    private String characterImage;

    /**
     * 캐릭터 생성일
     */
    @SerializedName("character_date_create")
    private String characterDateCreate;

    /**
     * 최근 7일간 접속 여부
     */
    @SerializedName("access_flag")
    private String accessFlag;

    /**
     * 해방 퀘스트 완료 여부
     */
    @SerializedName("liberation_quest_clear_flag")
    private String liberationQuestClearFlag;

    /**
     * 조회 기준일
     */
    public LocalDateTime getDate() {
        return date != null
                ? Utils.toLocalDateTime(this.date)
                : null;
    }

    /**
     * 캐릭터 생성일
     */
    public LocalDateTime getCharacterDateCreate() {
        return Utils.toLocalDateTime(this.characterDateCreate);
    }

    /**
     * 최근 7일간 접속 여부
     */
    public boolean isAccessFlag() {
        return "true".equals(this.accessFlag);
    }

    /**
     * 해방 퀘스트 완료 여부
     */
    public boolean isLiberationQuestClearFlag() {
        return "true".equals(this.liberationQuestClearFlag);
    }
}
