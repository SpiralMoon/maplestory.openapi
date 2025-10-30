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
 * 계정의 보유 캐릭터 목록
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterListDTO {

    /**
     * 메이플스토리 계정 목록
     */
    @JsonProperty("account_list")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterListAccountDTO> accountList;
}
