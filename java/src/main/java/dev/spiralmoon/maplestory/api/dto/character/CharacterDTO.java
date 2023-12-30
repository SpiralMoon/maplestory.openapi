package dev.spiralmoon.maplestory.api.dto.character;

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
public class CharacterDTO {

    /**
     * 캐릭터 식별자
     */
    @SerializedName("ocid")
    private String ocid;
}