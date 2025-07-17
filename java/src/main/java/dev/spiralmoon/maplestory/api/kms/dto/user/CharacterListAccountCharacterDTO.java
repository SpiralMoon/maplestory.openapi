package dev.spiralmoon.maplestory.api.kms.dto.user;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 캐릭터 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterListAccountCharacterDTO {

    /**
     * 캐릭터 식별자
     */
    @SerializedName("ocid")
    private String ocid;

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
     * 캐릭터 직업
     */
    @SerializedName("character_class")
    private String characterClass;

    /**
     * 캐릭터 레벨
     */
    @SerializedName("character_level")
    private int characterLevel;
}
