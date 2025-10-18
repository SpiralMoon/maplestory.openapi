package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * 角色已裝備道具資訊
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterItemEquipmentDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterItemEquipmentDTO<
        CharacterItemEquipmentInfoDTO,
        CharacterItemEquipmentTitleDTO,
        CharacterItemEquipmentDragonInfoDTO,
        CharacterItemEquipmentMechanicInfoDTO> {

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
     * 目前套用的道具預設編號
     */
    @SerializedName("preset_no")
    private Integer presetNo;

    /**
     * 道具資訊
     */
    @SerializedName("item_equipment")
    private List<CharacterItemEquipmentInfoDTO> itemEquipment;

    /**
     * 預設 1 的道具資訊
     */
    @SerializedName("item_equipment_preset_1")
    private List<CharacterItemEquipmentInfoDTO> itemEquipmentPreset1;

    /**
     * 預設 2 的道具資訊
     */
    @SerializedName("item_equipment_preset_2")
    private List<CharacterItemEquipmentInfoDTO> itemEquipmentPreset2;

    /**
     * 預設 3 的道具資訊
     */
    @SerializedName("item_equipment_preset_3")
    private List<CharacterItemEquipmentInfoDTO> itemEquipmentPreset3;

    /**
     * 稱號資訊
     */
    @SerializedName("title")
    private CharacterItemEquipmentTitleDTO title;

    /**
     * 龍魔導士的龍道具資訊 (僅在龍魔導士時回應)
     */
    @SerializedName("dragon_equipment")
    private List<CharacterItemEquipmentDragonInfoDTO> dragonEquipment;

    /**
     * 機甲戰神道具資訊 (僅在機甲戰神時回應)
     */
    @SerializedName("mechanic_equipment")
    private List<CharacterItemEquipmentMechanicInfoDTO> mechanicEquipment;

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
