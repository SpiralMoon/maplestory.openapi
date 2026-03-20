package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * 캐릭터 예비 특수 반지 장착 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterRingReserveSkillEquipmentDTO {

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
     * 예비 특수 반지 슬롯에 장착한 특수 반지
     */
    @JsonProperty("special_ring_reserve_name")
    private String specialRingReserveName;

    /**
     * 예비 특수 반지 슬롯에 장착한 특수 반지 레벨
     */
    @JsonProperty("special_ring_reserve_level")
    private Integer specialRingReserveLevel;

    /**
     * 예비 특수 반지 슬롯에 장착한 특수 반지 아이콘
     */
    @JsonProperty("special_ring_reserve_icon")
    private String specialRingReserveIcon;

    /**
     * 예비 특수 반지 슬롯에 장착한 특수 반지 설명
     */
    @JsonProperty("special_ring_reserve_description")
    private String specialRingReserveDescription;

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
