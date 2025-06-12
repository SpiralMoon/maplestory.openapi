package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Character equipped equipment information
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
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    @SerializedName("date")
    private String date;

    /**
     * Character gender
     */
    @SerializedName("character_gender")
    private String characterGender;

    /**
     * Character job
     */
    @SerializedName("character_class")
    private String characterClass;

    /**
     * Active equipment preset number
     */
    @SerializedName("preset_no")
    private Integer presetNo;

    /**
     * Equipment information
     */
    @SerializedName("item_equipment")
    private List<CharacterItemEquipmentInfoDTO> itemEquipment;

    /**
     * Equipment information for Preset 1
     */
    @SerializedName("item_equipment_preset_1")
    private List<CharacterItemEquipmentInfoDTO> itemEquipmentPreset1;

    /**
     * Equipment information for Preset 2
     */
    @SerializedName("item_equipment_preset_2")
    private List<CharacterItemEquipmentInfoDTO> itemEquipmentPreset2;

    /**
     * Equipment information for Preset 3
     */
    @SerializedName("item_equipment_preset_3")
    private List<CharacterItemEquipmentInfoDTO> itemEquipmentPreset3;

    /**
     * Title information
     */
    @SerializedName("title")
    private CharacterItemEquipmentTitleDTO title;

    /**
     * Evan Dragon equipment information (response provided if the character is Evan)
     */
    @SerializedName("dragon_equipment")
    private List<CharacterItemEquipmentDragonInfoDTO> dragonEquipment;

    /**
     * Mechanic equipment information (response provided if the character is a Mechanic)
     */
    @SerializedName("mechanic_equipment")
    private List<CharacterItemEquipmentMechanicInfoDTO> mechanicEquipment;

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
