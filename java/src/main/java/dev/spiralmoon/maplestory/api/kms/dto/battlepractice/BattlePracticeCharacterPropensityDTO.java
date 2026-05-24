package dev.spiralmoon.maplestory.api.kms.dto.battlepractice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 연무장 입장 시 캐릭터 성향 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeCharacterPropensityDTO {

    /**
     * 카리스마 레벨
     */
    @JsonProperty("charisma_level")
    private Integer charismaLevel;

    /**
     * 감성 레벨
     */
    @JsonProperty("sensibility_level")
    private Integer sensibilityLevel;

    /**
     * 통찰력 레벨
     */
    @JsonProperty("insight_level")
    private Integer insightLevel;

    /**
     * 의지 레벨
     */
    @JsonProperty("willingness_level")
    private Integer willingnessLevel;

    /**
     * 손재주 레벨
     */
    @JsonProperty("handicraft_level")
    private Integer handicraftLevel;

    /**
     * 매력 레벨
     */
    @JsonProperty("charm_level")
    private Integer charmLevel;
}
