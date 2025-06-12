package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Equipment information for pet
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterPetEquipmentItemDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterPetEquipmentItemDTO<
        CharacterPetEquipmentItemOptionDTO> {

    /**
     * Item name
     */
    @SerializedName("item_name")
    private String itemName;

    /**
     * Item icon
     */
    @SerializedName("item_icon")
    private String itemIcon;

    /**
     * Item description
     */
    @SerializedName("item_description")
    private String itemDescription;

    /**
     * Displayed item options
     */
    @SerializedName("item_option")
    private List<CharacterPetEquipmentItemOptionDTO> itemOption;

    /**
     * Number of upgrades
     */
    @SerializedName("scroll_upgrade")
    private int scrollUpgrade;

    /**
     * Number of upgrades available
     */
    @SerializedName("scroll_upgradable")
    private int scrollUpgradable;

    /**
     * Item appearance
     */
    @SerializedName("item_shape")
    private String itemShape;

    /**
     * Item appearance icon
     */
    @SerializedName("item_shape_icon")
    private String itemShapeIcon;
}
