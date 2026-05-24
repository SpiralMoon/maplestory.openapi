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
 * 연무장 입장 시 캐릭터 HEXA 매트릭스 코어 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeCharacterHexaCoreEquipmentDTO {

    /**
     * 코어 명
     */
    @JsonProperty("hexa_core_name")
    private String hexaCoreName;

    /**
     *  코어 레벨
     */
    @JsonProperty("hexa_core_level")
    private Integer hexaCoreLevel;

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
    private List<BattlePracticeCharacterHexaLinkedSkillDTO> linkedSkill;
}
