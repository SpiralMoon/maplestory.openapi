package dev.spiralmoon.maplestory.api.kms.dto.character;

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
public class CharacterDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterDTO {

    /**
     * 캐릭터 식별자
     */
    @JsonProperty("ocid")
    private String ocid;
}
