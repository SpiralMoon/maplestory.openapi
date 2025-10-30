package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 캐릭터 HEXA 코어 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterHexaMatrixEquipmentDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterHexaMatrixEquipmentDTO<
        CharacterHexaMatrixEquipmentLinkedSkillDTO> {
    /**
     * 코어 명
     */
    @JsonProperty("hexa_core_name")
    private String hexaCoreName;

    /**
     * 코어 레벨
     */
    @JsonProperty("hexa_core_level")
    private Long hexaCoreLevel;

    /**
     * 코어 타입
     */
    @JsonProperty("hexa_core_type")
    private String hexaCoreType;

    /**
     * 연결된 스킬
     */
    @JsonProperty("linked_skill")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterHexaMatrixEquipmentLinkedSkillDTO> linkedSkill;
}
