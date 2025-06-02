package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 캐릭터 V코어 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterVMatrixCoreEquipmentDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterVMatrixCoreEquipmentDTO {

    /**
     * 슬롯 인덱스
     */
    @SerializedName("slot_id")
    private String slotId;

    /**
     * 슬롯 레벨
     */
    @SerializedName("slot_level")
    private long slotLevel;

    /**
     * 코어 명
     */
    @SerializedName("v_core_name")
    private String vCoreName;

    /**
     * 코어 타입
     */
    @SerializedName("v_core_type")
    private String vCoreType;

    /**
     * 코어 레벨
     */
    @SerializedName("v_core_level")
    private long vCoreLevel;

    /**
     * 코어에 해당하는 스킬 명
     */
    @SerializedName("v_core_skill_1")
    private String vCoreSkill1;

    /**
     * 강화 코어인 경우 코어에 해당하는 두 번째 스킬 명
     */
    @SerializedName("v_core_skill_2")
    private String vCoreSkill2;

    /**
     * 강화 코어인 경우 코어에 해당하는 세 번째 스킬 명
     */
    @SerializedName("v_core_skill_3")
    private String vCoreSkill3;
}
