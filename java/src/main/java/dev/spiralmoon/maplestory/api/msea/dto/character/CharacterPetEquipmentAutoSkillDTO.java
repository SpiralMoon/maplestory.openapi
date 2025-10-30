package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Auto buff skill information for pet
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterPetEquipmentAutoSkillDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterPetEquipmentAutoSkillDTO {

    /**
     * Auto skill registered in the first slot
     */
    @JsonProperty("skill_1")
    private String skill1;

    /**
     * Icon for the auto skill in the first slot
     */
    @JsonProperty("skill_1_icon")
    private String skill1Icon;

    /**
     * Auto skill registered in the second slot
     */
    @JsonProperty("skill_2")
    private String skill2;

    /**
     * Icon for the auto skill in the second slot
     */
    @JsonProperty("skill_2_icon")
    private String skill2Icon;
}
