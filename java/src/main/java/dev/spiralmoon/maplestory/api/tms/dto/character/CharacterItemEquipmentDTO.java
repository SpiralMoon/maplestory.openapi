package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * 角色已裝備道具資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterItemEquipmentDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterItemEquipmentDTO<
        CharacterItemEquipmentInfoDTO,
        CharacterItemEquipmentTitleDTO,
        CharacterItemEquipmentMedalShapeDTO,
        CharacterItemEquipmentDragonInfoDTO,
        CharacterItemEquipmentMechanicInfoDTO> {

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    @JsonProperty("date")
    private String date;

    /**
     * 角色性別
     */
    @JsonProperty("character_gender")
    private String characterGender;

    /**
     * 角色職業
     */
    @JsonProperty("character_class")
    private String characterClass;

    /**
     * 目前套用的道具預設編號
     */
    @JsonProperty("preset_no")
    private Integer presetNo;

    /**
     * 道具資訊
     */
    @JsonProperty("item_equipment")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterItemEquipmentInfoDTO> itemEquipment;

    /**
     * 預設 1 的道具資訊
     */
    @JsonProperty("item_equipment_preset_1")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterItemEquipmentInfoDTO> itemEquipmentPreset1;

    /**
     * 預設 2 的道具資訊
     */
    @JsonProperty("item_equipment_preset_2")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterItemEquipmentInfoDTO> itemEquipmentPreset2;

    /**
     * 預設 3 的道具資訊
     */
    @JsonProperty("item_equipment_preset_3")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterItemEquipmentInfoDTO> itemEquipmentPreset3;

    /**
     * 稱號資訊
     */
    @JsonProperty("title")
    private CharacterItemEquipmentTitleDTO title;

    /**
     * 外型設定中已登錄勳章的外型資訊
     */
    @JsonProperty("medal_shape")
    private CharacterItemEquipmentMedalShapeDTO medalShape;

    /**
     * 龍魔導士的龍道具資訊 (僅在龍魔導士時回應)
     */
    @JsonProperty("dragon_equipment")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterItemEquipmentDragonInfoDTO> dragonEquipment;

    /**
     * 機甲戰神道具資訊 (僅在機甲戰神時回應)
     */
    @JsonProperty("mechanic_equipment")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
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
