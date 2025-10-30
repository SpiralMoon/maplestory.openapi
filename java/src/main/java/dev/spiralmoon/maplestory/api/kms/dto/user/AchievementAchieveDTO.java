package dev.spiralmoon.maplestory.api.kms.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 달성 업적 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AchievementAchieveDTO {

    /**
     * 업적 명
     */
    @JsonProperty("achievement_name")
    private String achievementName;

    /**
     * 업적 설명
     */
    @JsonProperty("achievement_description")
    private String achievementDescription;
}
