package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * 캐릭터 기본 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterBasicDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterBasicDTO {

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    @JsonProperty("date")
    private String date;

    /**
     * 캐릭터 명
     */
    @JsonProperty("character_name")
    private String characterName;

    /**
     * 월드 명
     */
    @JsonProperty("world_name")
    private String worldName;

    /**
     * 캐릭터 성별
     */
    @JsonProperty("character_gender")
    private String characterGender;

    /**
     * 캐릭터 직업
     */
    @JsonProperty("character_class")
    private String characterClass;

    /**
     * 캐릭터 전직 차수
     */
    @JsonProperty("character_class_level")
    private String characterClassLevel;

    /**
     * 캐릭터 레벨
     */
    @JsonProperty("character_level")
    private long characterLevel;

    /**
     * 현재 레벨에서 보유한 경험치
     */
    @JsonProperty("character_exp")
    private long characterExp;

    /**
     * 현재 레벨에서 경험치 퍼센트
     */
    @JsonProperty("character_exp_rate")
    private String characterExpRate;

    /**
     * 캐릭터 소속 길드 명
     */
    @JsonProperty("character_guild_name")
    private String characterGuildName;

    /**
     * 캐릭터 외형 이미지
     */
    @JsonProperty("character_image")
    private String characterImage;

    public void setCharacterImage(String characterImage) {
        this.characterImage = Utils.removeQuery(characterImage);
    }

    /**
     * 캐릭터 생성일
     */
    @JsonProperty("character_date_create")
    private String characterDateCreate;

    /**
     * 최근 7일간 접속 여부
     */
    @JsonProperty("access_flag")
    private String accessFlag;

    /**
     * 해방 퀘스트 완료 여부 (0:미완료, 1:제네시스 무기 해방, 2:데스티니 무기 1차 해방)
     */
    @JsonProperty("liberation_quest_clear")
    private String liberationQuestClear;

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }

    /**
     * 캐릭터 생성일
     */
    public ZonedDateTime getCharacterDateCreate() {
        return characterDateCreate != null
                ? Utils.toZonedDateTime(this.characterDateCreate)
                : null;
    }

    /**
     * 최근 7일간 접속 여부
     */
    public boolean isAccessFlag() {
        return "true".equals(this.accessFlag);
    }
}
