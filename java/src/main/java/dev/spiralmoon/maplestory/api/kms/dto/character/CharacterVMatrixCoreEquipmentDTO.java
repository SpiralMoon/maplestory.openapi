package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 캐릭터 V코어 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterVMatrixCoreEquipmentDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterVMatrixCoreEquipmentDTO {

    /**
     * 슬롯 인덱스
     */
    @JsonProperty("slot_id")
    private String slotId;

    /**
     * 슬롯 레벨
     * @deprecated 2025년 12월 18일 점검 이후부터 사용하지 않는 항목입니다.
     */
    @JsonProperty("slot_level")
    @Deprecated
    private long slotLevel;

    /**
     * 코어 명
     */
    @JsonProperty("v_core_name")
    private String vCoreName;

    /**
     * 코어 타입
     */
    @JsonProperty("v_core_type")
    private String vCoreType;

    /**
     * 코어 레벨
     */
    @JsonProperty("v_core_level")
    private long vCoreLevel;

    /**
     * 코어에 해당하는 스킬 명
     * @deprecated 2025년 12월 18일 점검 이후부터 사용하지 않는 항목입니다.
     */
    @JsonProperty("v_core_skill_1")
    @Deprecated
    private String vCoreSkill1;

    /**
     * 강화 코어인 경우 코어에 해당하는 두 번째 스킬 명
     * @deprecated 2025년 12월 18일 점검 이후부터 사용하지 않는 항목입니다.
     */
    @JsonProperty("v_core_skill_2")
    @Deprecated
    private String vCoreSkill2;

    /**
     * 강화 코어인 경우 코어에 해당하는 세 번째 스킬 명
     * @deprecated 2025년 12월 18일 점검 이후부터 사용하지 않는 항목입니다.
     */
    @JsonProperty("v_core_skill_3")
    @Deprecated
    private String vCoreSkill3;
}
