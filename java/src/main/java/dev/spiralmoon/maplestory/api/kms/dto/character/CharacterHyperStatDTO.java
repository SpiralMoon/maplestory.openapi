package dev.spiralmoon.maplestory.api.kms.dto.character;

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
 * 캐릭터 하이퍼 스탯 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterHyperStatDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterHyperStatDTO<
        CharacterHyperStatPresetDTO> {

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    @JsonProperty("date")
    private String date;

    /**
     * 캐릭터 직업
     */
    @JsonProperty("character_class")
    private String characterClass;

    /**
     * 적용 중인 프리셋 번호
     */
    @JsonProperty("use_preset_no")
    private String usePresetNo;

    /**
     * 사용 가능한 최대 하이퍼 스탯 포인트
     */
    @JsonProperty("use_available_hyper_stat")
    private int useAvailableHyperStat;

    /**
     * 프리셋 1번 하이퍼 스탯 정보
     */
    @JsonProperty("hyper_stat_preset_1")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterHyperStatPresetDTO> hyperStatPreset1;

    /**
     * 프리셋 1번 하이퍼 스탯 잔여 포인트
     */
    @JsonProperty("hyper_stat_preset_1_remain_point")
    private int hyperStatPreset1RemainPoint;

    /**
     * 프리셋 2번 하이퍼 스탯 정보
     */
    @JsonProperty("hyper_stat_preset_2")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterHyperStatPresetDTO> hyperStatPreset2;

    /**
     * 프리셋 2번 하이퍼 스탯 잔여 포인트
     */
    @JsonProperty("hyper_stat_preset_2_remain_point")
    private int hyperStatPreset2RemainPoint;

    /**
     * 프리셋 3번 하이퍼 스탯 정보
     */
    @JsonProperty("hyper_stat_preset_3")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterHyperStatPresetDTO> hyperStatPreset3;

    /**
     * 프리셋 3번 하이퍼 스탯 잔여 포인트
     */
    @JsonProperty("hyper_stat_preset_3_remain_point")
    private int hyperStatPreset3RemainPoint;

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
