package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * 角色已裝備於 HEXA 矩陣的 HEXA 核心資訊
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterHexaMatrixDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterHexaMatrixDTO<CharacterHexaMatrixEquipmentDTO> {

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    @SerializedName("date")
    private String date;

    /**
     * HEXA 核心資訊
     */
    @SerializedName("character_hexa_core_equipment")
    private List<CharacterHexaMatrixEquipmentDTO> characterHexaCoreEquipment;

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
