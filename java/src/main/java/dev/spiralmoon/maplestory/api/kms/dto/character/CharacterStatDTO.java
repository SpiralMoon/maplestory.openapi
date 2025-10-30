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
 * 캐릭터 스탯 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterStatDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterStatDTO<CharacterFinalStatDTO> {

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
     * 현재 스탯 정보
     */
    @JsonProperty("final_stat")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterFinalStatDTO> finalStat;

    /**
     * 잔여 AP
     */
    @JsonProperty("remain_ap")
    private Integer remainAp;

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
