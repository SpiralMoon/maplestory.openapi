package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 角色辨識器資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterDTO {

    /**
     * 角色辨識器
     */
    @JsonProperty("ocid")
    private String ocid;
}
