package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Character information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterDTO {

    /**
     * Character identifier
     */
    @JsonProperty("ocid")
    private String ocid;
}
