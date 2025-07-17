package dev.spiralmoon.maplestory.api.kms.dto.user;

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
public class AchievementAccountListDTO {

    /**
     * 메이플스토리 계정 식별자
     */
    @SerializedName("account_id")
    private String accountId;

    /**
     * 달성 업적 정보
     */
    @SerializedName("achievement_achieve")
    private List<AchievementAchieveDTO> achievementAchieve;
}
