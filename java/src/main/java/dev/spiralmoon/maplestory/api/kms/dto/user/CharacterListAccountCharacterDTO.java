package dev.spiralmoon.maplestory.api.kms.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 캐릭터 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterListAccountCharacterDTO {

    /**
     * 캐릭터 식별자
     */
    @JsonProperty("ocid")
    private String ocid;

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
     * 캐릭터 직업
     */
    @JsonProperty("character_class")
    private String characterClass;

    /**
     * 캐릭터 레벨
     */
    @JsonProperty("character_level")
    private int characterLevel;
}
