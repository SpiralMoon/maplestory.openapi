package dev.spiralmoon.maplestory.api.kms.dto.battlepractice;

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
 * 연무장 입장 시 캐릭터 펫 장착 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeCharacterPetEquipmentDTO {

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
     * 아이템의 표기상 옵션
     */
    @JsonProperty("item_option")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<BattlePracticeCharacterPetEquipmentItemOptionDTO> itemOption;

    /**
     * 주문서 횟수
     */
    @JsonProperty("scroll_upgrade")
    private Integer scrollUpgrade;

    /**
     * 주문서 잔여 횟수
     */
    @JsonProperty("scroll_upgradable")
    private Integer scrollUpgradable;

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

    /**
     * 아이템 만료 시간
     */
    @JsonProperty("item_date_expire")
    private String itemDateExpire;

    /**
     * 아이템 만료 시간
     */
    public ZonedDateTime getItemDateExpire() {
        return itemDateExpire != null
                ? Utils.toZonedDateTime(this.itemDateExpire)
                : null;
    }
}
