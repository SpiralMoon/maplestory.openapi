package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * V 核心資訊
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterVMatrixCoreEquipmentDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterVMatrixCoreEquipmentDTO {

    /**
     * 欄位索引
     */
    @SerializedName("slot_id")
    private String slotId;

    /**
     * 欄位等級
     */
    @SerializedName("slot_level")
    private long slotLevel;

    /**
     * 核心名稱
     */
    @SerializedName("v_core_name")
    private String vCoreName;

    /**
     * 核心類型
     */
    @SerializedName("v_core_type")
    private String vCoreType;

    /**
     * 核心等級
     */
    @SerializedName("v_core_level")
    private long vCoreLevel;

    /**
     * 對應核心的技能名稱
     */
    @SerializedName("v_core_skill_1")
    private String vCoreSkill1;

    /**
     * (若為強化核心) 對應核心的第二個技能名稱
     */
    @SerializedName("v_core_skill_2")
    private String vCoreSkill2;

    /**
     * (若為強化核心) 對應核心的第三個技能名稱
     */
    @SerializedName("v_core_skill_3")
    private String vCoreSkill3;
}
