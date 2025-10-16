package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 寵物道具資訊
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterPetEquipmentItemDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterPetEquipmentItemDTO<CharacterPetEquipmentItemOptionDTO> {

    /**
     * 道具名稱
     */
    @SerializedName("item_name")
    private String itemName;

    /**
     * 道具圖示
     */
    @SerializedName("item_icon")
    private String itemIcon;

    /**
     * 道具描述
     */
    @SerializedName("item_description")
    private String itemDescription;

    /**
     * 道具顯示選項
     */
    @SerializedName("item_option")
    private List<CharacterPetEquipmentItemOptionDTO> itemOption;

    /**
     * 強化次數
     */
    @SerializedName("scroll_upgrade")
    private int scrollUpgrade;

    /**
     * 道具可升級次數
     */
    @SerializedName("scroll_upgradable")
    private int scrollUpgradable;

    /**
     * 道具外型
     */
    @SerializedName("item_shape")
    private String itemShape;

    /**
     * 道具外型圖示
     */
    @SerializedName("item_shape_icon")
    private String itemShapeIcon;
}
