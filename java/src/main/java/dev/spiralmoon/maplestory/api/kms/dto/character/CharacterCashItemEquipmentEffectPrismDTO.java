package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 캐릭터 캐시 장비(무기) 이펙트 프리즘
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterCashItemEquipmentEffectPrismDTO {

    /**
     * 이펙트 프리즘 색상 범위
     */
    @JsonProperty("color_range")
    private String colorRange;

    /**
     * 이펙트 프리즘 색조
     */
    @JsonProperty("hue")
    private long hue;

    /**
     * 이펙트 프리즘 채도
     */
    @JsonProperty("saturation")
    private long saturation;

    /**
     * 이펙트 프리즘 명도
     */
    @JsonProperty("value")
    private long value;
}
