package dev.spiralmoon.maplestory.api.kms.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 메이플스토리 계정
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterListAccountDTO {

    /**
     * 메이플스토리 계정 식별자
     */
    @JsonProperty("account_id")
    private String accountId;

    /**
     * 캐릭터 목록
     */
    @JsonProperty("character_list")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterListAccountCharacterDTO> characterList;
}
