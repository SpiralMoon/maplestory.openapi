package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 캐릭터 펫 장비 아이템 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterPetEquipmentItemDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterPetEquipmentItemDTO<
        CharacterPetEquipmentItemOptionDTO> {

    /**
     * 아이템 명
     */
    @JsonProperty("item_name")
    private String itemName;

    /**
     * 아이템 아이콘
     */
    @JsonProperty("item_icon")
    private String itemIcon;

    /**
     * 아이템 설명
     */
    @JsonProperty("item_description")
    private String itemDescription;

    /**
     * 아이템 표기상 옵션
     */
    @JsonProperty("item_option")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterPetEquipmentItemOptionDTO> itemOption;

    /**
     * 업그레이드 횟수
     */
    @JsonProperty("scroll_upgrade")
    private int scrollUpgrade;

    /**
     * 업그레이드 가능 횟수
     */
    @JsonProperty("scroll_upgradable")
    private int scrollUpgradable;

    /**
     * 아이템 외형
     */
    @JsonProperty("item_shape")
    private String itemShape;

    /**
     * 아이템 외형 아이콘
     */
    @JsonProperty("item_shape_icon")
    private String itemShapeIcon;
}
