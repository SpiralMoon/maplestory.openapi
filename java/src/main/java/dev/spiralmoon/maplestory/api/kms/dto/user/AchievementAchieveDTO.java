package dev.spiralmoon.maplestory.api.kms.dto.user;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 달성 업적 정보
 */
@AllArgsConstructor
@Data
@ToString
public class AchievementAchieveDTO {

    /**
     * 업적 명
     */
    @SerializedName("achievement_name")
    private String achievementName;

    /**
     * 업적 설명
     */
    @SerializedName("achievement_description")
    private String achievementDescription;
}
