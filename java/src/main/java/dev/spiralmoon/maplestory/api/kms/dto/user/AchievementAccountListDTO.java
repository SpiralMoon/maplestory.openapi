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
public class AchievementAccountListDTO {

    /**
     * 메이플스토리 계정 식별자
     */
    @JsonProperty("account_id")
    private String accountId;

    /**
     * 달성 업적 정보
     */
    @JsonProperty("achievement_achieve")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<AchievementAchieveDTO> achievementAchieve;
}
