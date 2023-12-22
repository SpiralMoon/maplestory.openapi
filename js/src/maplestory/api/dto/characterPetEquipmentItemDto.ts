import {CharacterPetEquipmentItemDtoBody} from "../response/characterPetEquipmentDtoBody";
import {CharacterPetEquipmentItemOptionDto} from "./characterPetEquipmentItemOptionDto";

/**
 * 캐릭터 펫 장비 아이템 정보
 */
class CharacterPetEquipmentItemDto {

    /**
     * 아이템 명
     */
    itemName: string;

    /**
     * 아이템 아이콘
     */
    itemIcon: string;

    /**
     * 아이템 설명
     */
    itemDescription: string;

    /**
     * 아이템 표기상 옵션
     */
    itemOption: CharacterPetEquipmentItemOptionDto[];

    /**
     * 업그레이드 횟수
     */
    scrollUpgrade: number;

    /**
     * 업그레이드 가능 횟수
     */
    scrollUpgradeable: number;

    constructor(obj: CharacterPetEquipmentItemDtoBody) {
        const {
            item_name,
            item_icon,
            item_description,
            item_option,
            scroll_upgrade,
            scroll_upgradeable,
        } = obj;

        this.itemName = item_name;
        this.itemIcon = item_icon;
        this.itemDescription = item_description;
        this.itemOption = item_option.map(option => new CharacterPetEquipmentItemOptionDto(option));
        this.scrollUpgrade = scroll_upgrade;
        this.scrollUpgradeable = scroll_upgradeable;
    }
}

export {CharacterPetEquipmentItemDto};
