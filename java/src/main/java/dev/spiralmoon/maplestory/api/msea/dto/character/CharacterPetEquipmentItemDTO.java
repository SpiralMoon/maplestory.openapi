package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * Equipment information for pet
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterPetEquipmentItemDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterPetEquipmentItemDTO<
        CharacterPetEquipmentItemOptionDTO> {

    /**
     * Item name
     */
    @JsonProperty("item_name")
    private String itemName;

    /**
     * Item icon
     */
    @JsonProperty("item_icon")
    private String itemIcon;

    /**
     * Item description
     */
    @JsonProperty("item_description")
    private String itemDescription;

    /**
     * Displayed item options
     */
    @JsonProperty("item_option")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterPetEquipmentItemOptionDTO> itemOption;

    /**
     * Number of upgrades
     */
    @JsonProperty("scroll_upgrade")
    private int scrollUpgrade;

    /**
     * Number of upgrades available
     */
    @JsonProperty("scroll_upgradable")
    private int scrollUpgradable;

    /**
     * Item appearance
     */
    @JsonProperty("item_shape")
    private String itemShape;

    /**
     * Item appearance icon
     */
    @JsonProperty("item_shape_icon")
    private String itemShapeIcon;
}
