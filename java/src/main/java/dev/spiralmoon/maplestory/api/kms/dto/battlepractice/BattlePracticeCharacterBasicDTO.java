package dev.spiralmoon.maplestory.api.kms.dto.battlepractice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 연무장 입장 시 캐릭터 기본 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeCharacterBasicDTO {

    /**
     * 캐릭터 명
     */
    @JsonProperty("character_name")
    private String characterName;

    /**
     * 캐릭터 레벨
     */
    @JsonProperty("character_level")
    private Integer characterLevel;

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
     * 캐릭터 외형 이미지
     */
    @JsonProperty("character_image")
    private String characterImage;
}
