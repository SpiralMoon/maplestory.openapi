package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 寵物道具資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterPetEquipmentItemDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterPetEquipmentItemDTO<CharacterPetEquipmentItemOptionDTO> {

    /**
     * 道具名稱
     */
    @JsonProperty("item_name")
    private String itemName;

    /**
     * 道具圖示
     */
    @JsonProperty("item_icon")
    private String itemIcon;

    /**
     * 道具描述
     */
    @JsonProperty("item_description")
    private String itemDescription;

    /**
     * 道具顯示選項
     */
    @JsonProperty("item_option")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterPetEquipmentItemOptionDTO> itemOption;

    /**
     * 強化次數
     */
    @JsonProperty("scroll_upgrade")
    private int scrollUpgrade;

    /**
     * 道具可升級次數
     */
    @JsonProperty("scroll_upgradable")
    private int scrollUpgradable;

    /**
     * 道具外型
     */
    @JsonProperty("item_shape")
    private String itemShape;

    /**
     * 道具外型圖示
     */
    @JsonProperty("item_shape_icon")
    private String itemShapeIcon;
}
