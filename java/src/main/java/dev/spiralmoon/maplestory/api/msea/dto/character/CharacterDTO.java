package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Character information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterDTO {

    /**
     * Character identifier
     */
    @SerializedName("ocid")
    private String ocid;
}
