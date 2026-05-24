package dev.spiralmoon.maplestory.api.kms.dto.battlepractice;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * 연무장 입장 시 캐릭터 칭호 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeCharacterItemTitleDTO {

    /**
     * 칭호 장비 명
     */
    @JsonProperty("title_name")
    private String titleName;

    /**
     * 칭호 아이콘
     */
    @JsonProperty("title_icon")
    private String titleIcon;

    /**
     * 칭호 설명
     */
    @JsonProperty("title_description")
    private String titleDescription;

    /**
     * 칭호 유효 기간 (KST)
     */
    @JsonProperty("date_expire")
    private String dateExpire;

    /**
     * 칭호 옵션 유효 기간 (expired:만료, null:무제한) (KST)
     */
    @JsonProperty("date_option_expire")
    private String dateOptionExpire;

    /**
     * 외형 설정에 등록한 칭호 장비 명
     */
    @JsonProperty("title_shape_name")
    private String titleShapeName;

    /**
     * 외형 설정에 등록한 칭호 아이콘
     */
    @JsonProperty("title_shape_icon")
    private String titleShapeIcon;

    /**
     * 외형 설정에 등록한 칭호 설명
     */
    @JsonProperty("title_shape_description")
    private String titleShapeDescription;

    /**
     * 칭호 유효 기간 (KST)
     */
    public ZonedDateTime getDateExpire() {
        return dateExpire != null
                ? Utils.toZonedDateTime(this.dateExpire)
                : null;
    }

    /**
     * 칭호 옵션 유효 기간 (expired:만료, null:무제한) (KST)
     */
    public ZonedDateTime getDateOptionExpire() {
        return dateOptionExpire != null
                ? Utils.toZonedDateTime(this.dateOptionExpire)
                : null;
    }
}
