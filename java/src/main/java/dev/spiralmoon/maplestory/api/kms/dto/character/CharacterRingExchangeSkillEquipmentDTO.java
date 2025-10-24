package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * 캐릭터 링 익스체인지 스킬 등록 장비 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterRingExchangeSkillEquipmentDTO {

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
     * 링 익스체인지에 등록된 특수 반지
     */
    @SerializedName("special_ring_exchange_name")
    private String specialRingExchangeName;

    /**
     * 링 익스체인지에 등록된 특수 반지 레벨
     */
    @SerializedName("special_ring_exchange_level")
    private Integer specialRingExchangeLevel;

    /**
     * 링 익스체인지에 등록된 특수 반지 아이콘
     */
    @SerializedName("special_ring_exchange_icon")
    private String specialRingExchangeIcon;

    /**
     * 링 익스체인지에 등록된 특수 반지 설명
     */
    @SerializedName("special_ring_exchange_description")
    private String specialRingExchangeDescription;

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}