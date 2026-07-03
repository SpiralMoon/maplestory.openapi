package dev.spiralmoon.maplestory.api.kms.dto.union;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 유니온 스탯 프리셋 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UnionRaiderStateStatPresetDTO {

    /**
     * 프리셋 번호
     */
    @JsonProperty("preset_no")
    private int presetNo;

    /**
     * 유니온 스탯 효과
     */
    @JsonProperty("union_state_stat")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<String> unionStateStat;
}
