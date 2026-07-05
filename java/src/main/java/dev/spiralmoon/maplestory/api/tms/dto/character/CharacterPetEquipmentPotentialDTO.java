package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 寵物 潛在的
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterPetEquipmentPotentialDTO {

    /**
     * 潛在的 步 (1~3, 0:停用)
     */
    @JsonProperty("potential_step")
    private String potentialStep;

    /**
     * 潛在的 類型
     */
    @JsonProperty("potential_type")
    private String potentialType;

    /**
     * 潛在的 增加 (對於攻擊力/魔法攻擊力以外的其他潛在能力類型，百分比)
     */
    @JsonProperty("potential_increase1")
    private String potentialIncrease1;

    /**
     * 潛在的 增加 2 (如果潛在能力類型為攻擊力/魔法攻擊力，則攻擊力分配給 potential_increase_1，魔法攻擊力分配給 potential_increase_2；如果潛在能力類型為最大生命值/最大魔法值，則最大生命值分配給 potential_increase_1，最大魔法值分配給 potential_increase_2。)
     */
    @JsonProperty("potential_increase2")
    private String potentialIncrease2;
}
