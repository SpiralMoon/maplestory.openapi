import {CharacterItemEquipmentTitleDtoBody} from "../response/characterItemEquipmentDtoBody";

/**
 * 캐릭터 칭호 아이템 정보
 */
class CharacterItemEquipmentTitleDto {

    /**
     * 칭호 장비 명
     */
    titleName: string;

    /**
     * 칭호 아이콘
     */
    titleIcon: string;

    /**
     * 칭호 설명
     */
    titleDescription: string;

    /**
     * 칭호 유효 기간
     */
    dateExpire: Date;

    /**
     * 칭호 옵션 유효 기간
     */
    dateOptionExpire?: Date;

    constructor(obj: CharacterItemEquipmentTitleDtoBody) {

        const {
            title_name,
            title_icon,
            title_description,
            date_expire,
            date_option_expire,
        } = obj;

        this.titleName = title_name;
        this.titleIcon = title_icon;
        this.titleDescription = title_description;
        this.dateExpire = new Date(date_expire);
        this.dateOptionExpire = date_option_expire ? new Date(date_option_expire) : undefined;
    }
}

export {CharacterItemEquipmentTitleDto};
