import {CharacterPetEquipmentItemOptionDtoBody} from "../response/characterPetEquipmentDtoBody";

/**
 * 캐릭터 펫 장비 아이템 옵션 정보
 */
class CharacterPetEquipmentItemOptionDto {

    /**
     * 옵션 정보
     */
    optionType: string;

    /**
     * 옵션 값
     */
    optionValue: string;

    constructor(obj: CharacterPetEquipmentItemOptionDtoBody) {
        const {option_type, option_value} = obj;

        this.optionType = option_type;
        this.optionValue = option_value;
    }
}

export {CharacterPetEquipmentItemOptionDto};
