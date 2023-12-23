package dev.spiralmoon.maplestory.api.dto;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 캐릭터 펫 장비 아이템 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterPetEquipmentItemDTO {

    @SerializedName("item_name")
    private String itemName;

    @SerializedName("item_icon")
    private String itemIcon;

    @SerializedName("item_description")
    private String itemDescription;

    @SerializedName("item_option")
    private List<CharacterPetEquipmentItemOptionDTO> itemOption;

    @SerializedName("scroll_upgrade")
    private Long scrollUpgrade;

    @SerializedName("scroll_upgradeable")
    private Long scrollUpgradeable;
}
