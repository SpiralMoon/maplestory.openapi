package dev.spiralmoon.maplestory.api.kms.dto.battlepractice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 연무장 입장 시 캐릭터 예비 특수 반지 슬롯에 장착한 특수 반지 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeCharacterRingReserveSkillObjectDTO {

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
}
