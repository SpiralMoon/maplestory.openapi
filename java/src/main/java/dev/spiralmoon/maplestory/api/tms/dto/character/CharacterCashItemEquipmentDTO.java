package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * 角色已裝備現金道具資訊
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterCashItemEquipmentDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterCashItemEquipmentDTO<CharacterCashItemEquipmentPresetDTO> {

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    @SerializedName("date")
    private String date;

    /**
     * 角色性別
     */
    @SerializedName("character_gender")
    private String characterGender;

    /**
     * 角色職業
     */
    @SerializedName("character_class")
    private String characterClass;

    /**
     * 角色外型模式 (0：一般模式，1：神之子為 Beta、天使破壞者為變裝模式時)
     */
    @SerializedName("character_look_mode")
    private String characterLookMode;

    /**
     * 目前套用的現金道具預設編號
     */
    @SerializedName("preset_no")
    private Integer presetNo;

    /**
     * 目前已裝備的現金道具
     */
    @SerializedName("cash_item_equipment_base")
    private List<CharacterCashItemEquipmentPresetDTO> cashItemEquipmentBase;

    /**
     * 外型預設 1
     */
    @SerializedName("cash_item_equipment_preset_1")
    private List<CharacterCashItemEquipmentPresetDTO> cashItemEquipmentPreset1;

    /**
     * 外型預設 2
     */
    @SerializedName("cash_item_equipment_preset_2")
    private List<CharacterCashItemEquipmentPresetDTO> cashItemEquipmentPreset2;

    /**
     * 外型預設 3
     */
    @SerializedName("cash_item_equipment_preset_3")
    private List<CharacterCashItemEquipmentPresetDTO> cashItemEquipmentPreset3;

    /**
     * 神之子為 Beta 及天使破壞者為變裝模式時的目前已裝備現金道具
     */
    @SerializedName("additional_cash_item_equipment_base")
    private List<CharacterCashItemEquipmentPresetDTO> additionalCashItemEquipmentBase;

    /**
     * 神之子為 Beta 及天使破壞者為變裝模式時的外型預設 1
     */
    @SerializedName("additional_cash_item_equipment_preset_1")
    private List<CharacterCashItemEquipmentPresetDTO> additionalCashItemEquipmentPreset1;

    /**
     * 神之子為 Beta 及天使破壞者為變裝模式時的外型預設 2
     */
    @SerializedName("additional_cash_item_equipment_preset_2")
    private List<CharacterCashItemEquipmentPresetDTO> additionalCashItemEquipmentPreset2;

    /**
     * 神之子為 Beta 及天使破壞者為變裝模式時的外型預設 3
     */
    @SerializedName("additional_cash_item_equipment_preset_3")
    private List<CharacterCashItemEquipmentPresetDTO> additionalCashItemEquipmentPreset3;

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
