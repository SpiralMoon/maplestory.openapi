package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * 캐릭터 스탯 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterStatDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterStatDTO<CharacterFinalStatDTO> {

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
     * 현재 스탯 정보
     */
    @SerializedName("final_stat")
    private List<CharacterFinalStatDTO> finalStat;

    /**
     * 잔여 AP
     */
    @SerializedName("remain_ap")
    private Integer remainAp;

    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
