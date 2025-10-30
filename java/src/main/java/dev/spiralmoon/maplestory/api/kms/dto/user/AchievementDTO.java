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
 * 계정의 업적 목록
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AchievementDTO {

    /**
     * 메이플스토리 계정
     */
    @JsonProperty("account_list")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<AchievementAccountListDTO> accountList;
}
