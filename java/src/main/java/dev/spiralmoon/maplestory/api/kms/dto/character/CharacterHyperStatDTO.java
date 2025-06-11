package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * 캐릭터 하이퍼 스탯 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterHyperStatDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterHyperStatDTO<
        CharacterHyperStatPresetDTO> {

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    @SerializedName("date")
    private String date;

    /**
     * 캐릭터 직업
     */
    @SerializedName("character_class")
    private String characterClass;

    /**
     * 적용 중인 프리셋 번호
     */
    @SerializedName("use_preset_no")
    private String usePresetNo;

    /**
     * 사용 가능한 최대 하이퍼 스탯 포인트
     */
    @SerializedName("use_available_hyper_stat")
    private Integer useAvailableHyperStat;

    /**
     * 프리셋 1번 하이퍼 스탯 정보
     */
    @SerializedName("hyper_stat_preset_1")
    private List<CharacterHyperStatPresetDTO> hyperStatPreset1;

    /**
     * 프리셋 1번 하이퍼 스탯 잔여 포인트
     */
    @SerializedName("hyper_stat_preset_1_remain_point")
    private Integer hyperStatPreset1RemainPoint;

    /**
     * 프리셋 2번 하이퍼 스탯 정보
     */
    @SerializedName("hyper_stat_preset_2")
    private List<CharacterHyperStatPresetDTO> hyperStatPreset2;

    /**
     * 프리셋 2번 하이퍼 스탯 잔여 포인트
     */
    @SerializedName("hyper_stat_preset_2_remain_point")
    private Integer hyperStatPreset2RemainPoint;

    /**
     * 프리셋 3번 하이퍼 스탯 정보
     */
    @SerializedName("hyper_stat_preset_3")
    private List<CharacterHyperStatPresetDTO> hyperStatPreset3;

    /**
     * 프리셋 3번 하이퍼 스탯 잔여 포인트
     */
    @SerializedName("hyper_stat_preset_3_remain_point")
    private Integer hyperStatPreset3RemainPoint;

    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
