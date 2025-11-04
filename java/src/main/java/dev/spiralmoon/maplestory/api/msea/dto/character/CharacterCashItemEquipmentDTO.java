package dev.spiralmoon.maplestory.api.msea.dto.character;

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
 * Character cash item equipment information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterCashItemEquipmentDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterCashItemEquipmentDTO<
        CharacterCashItemEquipmentPresetDTO> {

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    @JsonProperty("date")
    private String date;

    /**
     * Character gender
     */
    @JsonProperty("character_gender")
    private String characterGender;

    /**
     * Character job
     */
    @JsonProperty("character_class")
    private String characterClass;

    /**
     * Character appearance mode (0:Normal mode, 1:Beta for Zero, Dress-up mode for Angelic Buster)
     */
    @JsonProperty("character_look_mode")
    private String characterLookMode;

    /**
     * Preset number for equipped cash item
     */
    @JsonProperty("preset_no")
    private int presetNo;

    /**
     * Equipped cash item
     */
    @JsonProperty("cash_item_equipment_base")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterCashItemEquipmentPresetDTO> cashItemEquipmentBase;

    /**
     * Cosmetic item preset 1
     */
    @JsonProperty("cash_item_equipment_preset_1")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterCashItemEquipmentPresetDTO> cashItemEquipmentPreset1;

    /**
     * Cosmetic item preset 2
     */
    @JsonProperty("cash_item_equipment_preset_2")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterCashItemEquipmentPresetDTO> cashItemEquipmentPreset2;

    /**
     * Cosmetic item preset 3
     */
    @JsonProperty("cash_item_equipment_preset_3")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterCashItemEquipmentPresetDTO> cashItemEquipmentPreset3;

    /**
     * Equipped cash items for Beta mode (if Zero) or Dress-up mode (if Angelic Buster)
     */
    @JsonProperty("additional_cash_item_equipment_base")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterCashItemEquipmentPresetDTO> additionalCashItemEquipmentBase;

    /**
     * Cosmetic item preset 1 for Beta mode (if Zero) or Dress-up mode (if Angelic Buster)
     */
    @JsonProperty("additional_cash_item_equipment_preset_1")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterCashItemEquipmentPresetDTO> additionalCashItemEquipmentPreset1;

    /**
     * Cosmetic item preset 2 for Beta mode (if Zero) or Dress-up mode (if Angelic Buster)
     */
    @JsonProperty("additional_cash_item_equipment_preset_2")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterCashItemEquipmentPresetDTO> additionalCashItemEquipmentPreset2;

    /**
     * Cosmetic item preset 3 for Beta mode (if Zero) or Dress-up mode (if Angelic Buster)
     */
    @JsonProperty("additional_cash_item_equipment_preset_3")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterCashItemEquipmentPresetDTO> additionalCashItemEquipmentPreset3;

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
