package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * 角色 V 矩陣欄位資訊與已裝備 V 核心資訊
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterVMatrixDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterVMatrixDTO<CharacterVMatrixCoreEquipmentDTO> {

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    @SerializedName("date")
    private String date;

    /**
     * 角色職業
     */
    @SerializedName("character_class")
    private String characterClass;

    /**
     * V 核心資訊
     */
    @SerializedName("character_v_core_equipment")
    private List<CharacterVMatrixCoreEquipmentDTO> characterVCoreEquipment;

    /**
     * 角色剩餘的矩陣強化點數
     */
    @SerializedName("character_v_matrix_remain_slot_upgrade_point")
    private Long characterVMatrixRemainSlotUpgradePoint;

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
