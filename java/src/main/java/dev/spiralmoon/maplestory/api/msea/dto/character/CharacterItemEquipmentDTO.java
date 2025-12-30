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
 * Character equipped equipment information
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
     * Active equipment preset number
     */
    @JsonProperty("preset_no")
    private Integer presetNo;

    /**
     * Equipment information
     */
    @JsonProperty("item_equipment")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterItemEquipmentInfoDTO> itemEquipment;

    /**
     * Equipment information for Preset 1
     */
    @JsonProperty("item_equipment_preset_1")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterItemEquipmentInfoDTO> itemEquipmentPreset1;

    /**
     * Equipment information for Preset 2
     */
    @JsonProperty("item_equipment_preset_2")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterItemEquipmentInfoDTO> itemEquipmentPreset2;

    /**
     * Equipment information for Preset 3
     */
    @JsonProperty("item_equipment_preset_3")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterItemEquipmentInfoDTO> itemEquipmentPreset3;

    /**
     * Title information
     */
    @JsonProperty("title")
    private CharacterItemEquipmentTitleDTO title;

    /**
     * Medal appearance information registered in the appearance settings
     */
    @JsonProperty("medal_shape")
    private CharacterItemEquipmentMedalShapeDTO medalShape;

    /**
     * Evan Dragon equipment information (response provided if the character is Evan)
     */
    @JsonProperty("dragon_equipment")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterItemEquipmentDragonInfoDTO> dragonEquipment;

    /**
     * Mechanic equipment information (response provided if the character is a Mechanic)
     */
    @JsonProperty("mechanic_equipment")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
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
