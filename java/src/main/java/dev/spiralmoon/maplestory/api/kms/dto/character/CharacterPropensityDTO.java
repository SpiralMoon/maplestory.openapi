package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * 캐릭터 성향 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterPropensityDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterPropensityDTO {

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    @JsonProperty("date")
    private String date;

    /**
     * 카리스마 레벨
     */
    @JsonProperty("charisma_level")
    private int charismaLevel;

    /**
     * 감성 레벨
     */
    @JsonProperty("sensibility_level")
    private int sensibilityLevel;

    /**
     * 통찰력 레벨
     */
    @JsonProperty("insight_level")
    private int insightLevel;

    /**
     * 의지 레벨
     */
    @JsonProperty("willingness_level")
    private int willingnessLevel;

    /**
     * 손재주 레벨
     */
    @JsonProperty("handicraft_level")
    private int handicraftLevel;

    /**
     * 매력 레벨
     */
    @JsonProperty("charm_level")
    private int charmLevel;

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
