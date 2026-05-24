package dev.spiralmoon.maplestory.api.kms.dto.battlepractice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 연무장 입장 시 캐릭터 HEXA 매트릭스 코어에 연결된 스킬
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeCharacterHexaLinkedSkillDTO {

    /**
     * HEXA 스킬 명
     */
    @JsonProperty("hexa_skill_id")
    private String hexaSkillId;
}
