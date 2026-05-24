package dev.spiralmoon.maplestory.api.kms.dto.battlepractice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 연무장 입장 시 캐릭터 펫 자동스킬 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeCharacterPetAutoSkillDTO {

    /**
     * 첫 번째 슬롯에 등록된 자동 스킬 명
     */
    @JsonProperty("skill_1")
    private String skill1;

    /**
     * 첫 번째 슬롯에 등록된 자동 스킬 아이콘
     */
    @JsonProperty("skill_1_icon")
    private String skill1Icon;

    /**
     * 두 번째 슬롯에 등록된 자동 스킬 명
     */
    @JsonProperty("skill_2")
    private String skill2;

    /**
     * 두 번째 슬롯에 등록된 자동 스킬 아이콘
     */
    @JsonProperty("skill_2_icon")
    private String skill2Icon;
}
