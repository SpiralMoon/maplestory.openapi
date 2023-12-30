package dev.spiralmoon.maplestory.api.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 캐릭터 인기도 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterPopularityDTO {

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    @SerializedName("date")
    private String date;

    /**
     * 캐릭터 인기도
     */
    @SerializedName("popularity")
    private long popularity;

    public LocalDateTime getDate() {
        return Utils.toLocalDateTime(this.date);
    }
}