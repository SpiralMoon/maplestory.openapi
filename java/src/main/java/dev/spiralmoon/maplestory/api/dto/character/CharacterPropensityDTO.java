package dev.spiralmoon.maplestory.api.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 캐릭터 성향 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterPropensityDTO {

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    @SerializedName("date")
    private String date;

    /**
     * 카리스마 레벨
     */
    @SerializedName("charisma_level")
    private Integer charismaLevel;

    /**
     * 감성 레벨
     */
    @SerializedName("sensibility_level")
    private Integer sensibilityLevel;

    /**
     * 통찰력 레벨
     */
    @SerializedName("insight_level")
    private Integer insightLevel;

    /**
     * 의지 레벨
     */
    @SerializedName("willingness_level")
    private Integer willingnessLevel;

    /**
     * 손재주 레벨
     */
    @SerializedName("handicraft_level")
    private Integer handicraftLevel;

    /**
     * 매력 레벨
     */
    @SerializedName("charm_level")
    private Integer charmLevel;

    public LocalDateTime getDate() {
        return date != null
                ? Utils.toLocalDateTime(this.date)
                : null;
    }
}
