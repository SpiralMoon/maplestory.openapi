package dev.spiralmoon.maplestory.api.kms.dto.battlepractice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 연무장 입장 시 캐릭터 장착 장비 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeCharacterItemEquipmentObjectDTO {

    /**
     * 장착 장비 정보
     */
    @JsonProperty("item_equipment")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<BattlePracticeCharacterItemEquipmentDTO> itemEquipment;

    /**
     * 칭호 정보
     */
    @JsonProperty("title")
    private BattlePracticeCharacterItemTitleDTO title;

    /**
     * 에반 드래곤 장비 정보 (에반인 경우 응답)
     */
    @JsonProperty("dragon_equipment")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<BattlePracticeCharacterItemDragonEquipmentDTO> dragonEquipment;

    /**
     * 메카닉 장비 목록 (메카닉인 경우 응답)
     */
    @JsonProperty("mechanic_equipment")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<BattlePracticeCharacterItemMechanicEquipmentDTO> mechanicEquipment;
}
