package dev.spiralmoon.maplestory.api.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 메이플스토리 계정
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterListAccountDTO {

    /**
     * 메이플스토리 계정 식별자
     */
    @SerializedName("account_id")
    private String accountId;

    /**
     * 캐릭터 목록
     */
    @SerializedName("character_list")
    private List<CharacterListAccountCharacterDTO> characterList;
}
