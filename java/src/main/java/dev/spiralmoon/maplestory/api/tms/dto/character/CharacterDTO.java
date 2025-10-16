package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 角色辨識器資訊
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterDTO {

    /**
     * 角色辨識器
     */
    @SerializedName("ocid")
    private String ocid;
}
