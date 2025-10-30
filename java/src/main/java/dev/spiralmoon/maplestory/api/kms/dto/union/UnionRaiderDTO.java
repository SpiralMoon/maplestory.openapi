package dev.spiralmoon.maplestory.api.kms.dto.union;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * 유니온 공격대 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UnionRaiderDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionRaiderDTO<UnionRaiderInnerStatDTO, UnionRaiderBlockDTO, UnionRaiderPresetDTO> {

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    @JsonProperty("date")
    private String date;

    /**
     * 유니온 공격대원 효과
     */
    @JsonProperty("union_raider_stat")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<String> unionRaiderStat;

    /**
     * 유니온 공격대 점령 효과
     */
    @JsonProperty("union_occupied_stat")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<String> unionOccupiedStat;

    /**
     * 유니온 공격대 배치
     */
    @JsonProperty("union_inner_stat")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<UnionRaiderInnerStatDTO> unionInnerStat;

    /**
     * 유니온 블록 정보
     */
    @JsonProperty("union_block")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<UnionRaiderBlockDTO> unionBlock;

    /**
     * 적용 중인 프리셋 번호
     */
    @JsonProperty("use_preset_no")
    private int usePresetNo;

    /**
     * 유니온 프리셋 1번 정보
     */
    @JsonProperty("union_raider_preset_1")
    private UnionRaiderPresetDTO unionRaiderPreset1;

    /**
     * 유니온 프리셋 2번 정보
     */
    @JsonProperty("union_raider_preset_2")
    private UnionRaiderPresetDTO unionRaiderPreset2;

    /**
     * 유니온 프리셋 3번 정보
     */
    @JsonProperty("union_raider_preset_3")
    private UnionRaiderPresetDTO unionRaiderPreset3;

    /**
     * 유니온 프리셋 4번 정보
     */
    @JsonProperty("union_raider_preset_4")
    private UnionRaiderPresetDTO unionRaiderPreset4;

    /**
     * 유니온 프리셋 5번 정보
     */
    @JsonProperty("union_raider_preset_5")
    private UnionRaiderPresetDTO unionRaiderPreset5;

    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
