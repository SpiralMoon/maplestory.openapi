package dev.spiralmoon.maplestory.api.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 계정의 보유 캐릭터 목록
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterListDTO {

    /**
     * 메이플스토리 계정 목록
     */
    @SerializedName("account_list")
    private List<CharacterListAccountDTO> accountList;
}
