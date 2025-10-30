package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * HEXA 核心資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterHexaMatrixEquipmentDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterHexaMatrixEquipmentDTO<CharacterHexaMatrixEquipmentLinkedSkillDTO> {

    /**
     * 核心名稱
     */
    @JsonProperty("hexa_core_name")
    private String hexaCoreName;

    /**
     * 核心等級
     */
    @JsonProperty("hexa_core_level")
    private Long hexaCoreLevel;

    /**
     * 核心類型
     */
    @JsonProperty("hexa_core_type")
    private String hexaCoreType;

    /**
     * 已連接的技能
     */
    @JsonProperty("linked_skill")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterHexaMatrixEquipmentLinkedSkillDTO> linkedSkill;
}
