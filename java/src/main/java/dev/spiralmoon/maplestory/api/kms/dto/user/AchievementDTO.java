package dev.spiralmoon.maplestory.api.kms.dto.user;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 계정의 업적 목록
 */
@AllArgsConstructor
@Data
@ToString
public class AchievementDTO {

    /**
     * 메이플스토리 계정
     */
    @SerializedName("account_list")
    private List<AchievementAccountListDTO> accountList;
}
