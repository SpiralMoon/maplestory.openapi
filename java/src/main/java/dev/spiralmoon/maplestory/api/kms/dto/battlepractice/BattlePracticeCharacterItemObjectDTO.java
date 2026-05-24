package dev.spiralmoon.maplestory.api.kms.dto.battlepractice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 연무장 입장 시 캐릭터 장비(캐시 장비 제외) 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeCharacterItemObjectDTO {

    /**
     * 장착 장비 정보
     */
    @JsonProperty("item_equipment_object")
    private BattlePracticeCharacterItemEquipmentObjectDTO itemEquipmentObject;

    /**
     * 적용 세트 효과 정보
     */
    @JsonProperty("set_effect_object")
    private BattlePracticeCharacterSetEffectObjectDTO setEffectObject;
}
