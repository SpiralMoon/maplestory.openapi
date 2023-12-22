import {CharacterPetEquipmentItemDto} from "./characterPetEquipmentItemDto";
import {CharacterPetEquipmentDtoBody} from "../response/characterPetEquipmentDtoBody";
import {CharacterPetEquipmentAutoSkillDto} from "./characterPetEquipmentAutoSkillDto";

/**
 * 캐릭터 펫 장비 정보
 */
class CharacterPetEquipmentDto {

    /**
     * 조회 기준일
     */
    date: Date;

    /**
     * 펫1 명
     */
    pet1Name: string;

    /**
     * 펫1 닉네임
     */
    pet1Nickname: string;

    /**
     * 펫1 아이콘
     */
    pet1Icon: string;

    /**
     * 펫1 설명
     */
    pet1Description: string;

    /**
     * 펫1 장착 정보
     */
    pet1Equipment: CharacterPetEquipmentItemDto;

    /**
     * 펫1 펫 버프 자동스킬 정보
     */
    pet1AutoSkill: CharacterPetEquipmentAutoSkillDto;

    /**
     * 펫1 원더 펫 종류
     */
    pet1PetType: string;

    /**
     * 펫1 펫 보유 스킬
     */
    pet1Skill: string[];

    /**
     * 펫1 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
     */
    pet1DateExpire: Date;

    /**
     * 펫2 명
     */
    pet2Name: string;

    /**
     * 펫2 닉네임
     */
    pet2Nickname: string;

    /**
     * 펫2 아이콘
     */
    pet2Icon: string;

    /**
     * 펫2 설명
     */
    pet2Description: string;

    /**
     * 펫2 장착 정보
     */
    pet2Equipment: CharacterPetEquipmentItemDto;

    /**
     * 펫2 펫 버프 자동스킬 정보
     */
    pet2AutoSkill: CharacterPetEquipmentAutoSkillDto;

    /**
     * 펫2 원더 펫 종류
     */
    pet2PetType: string;

    /**
     * 펫2 펫 보유 스킬
     */
    pet2Skill: string[];

    /*
     * 펫2 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
     */
    pet2DateExpire: Date;

    /**
     * 펫3 명
     */
    pet3Name: string;

    /**
     * 펫3 닉네임
     */
    pet3Nickname: string;

    /**
     * 펫3 아이콘
     */
    pet3Icon: string;

    /**
     * 펫3 설명
     */
    pet3Description: string;

    /**
     * 펫3 장착 정보
     */
    pet3Equipment: CharacterPetEquipmentItemDto;

    /**
     * 펫3 펫 버프 자동스킬 정보
     */
    pet3AutoSkill: CharacterPetEquipmentAutoSkillDto;

    /**
     * 펫3 원더 펫 종류
     */
    pet3PetType: string;

    /**
     * 펫3 펫 보유 스킬
     */
    pet3Skill: string[];

    /*
     * 펫3 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
     */
    pet3DateExpire: Date;

    constructor(obj: CharacterPetEquipmentDtoBody) {
        const {
            date,
            pet_1_name,
            pet_1_nickname,
            pet_1_icon,
            pet_1_description,
            pet_1_equipment,
            pet_1_auto_skill,
            pet_1_pet_type,
            pet_1_skill,
            pet_1_date_expire,
            pet_2_name,
            pet_2_nickname,
            pet_2_icon,
            pet_2_description,
            pet_2_equipment,
            pet_2_auto_skill,
            pet_2_pet_type,
            pet_2_skill,
            pet_2_date_expire,
            pet_3_name,
            pet_3_nickname,
            pet_3_icon,
            pet_3_description,
            pet_3_equipment,
            pet_3_auto_skill,
            pet_3_pet_type,
            pet_3_skill,
            pet_3_date_expire,
        } = obj;

        this.date = new Date(date);
        this.pet1Name = pet_1_name;
        this.pet1Nickname = pet_1_nickname;
        this.pet1Icon = pet_1_icon;
        this.pet1Description = pet_1_description;
        this.pet1Equipment = new CharacterPetEquipmentItemDto(pet_1_equipment);
        this.pet1AutoSkill = new CharacterPetEquipmentAutoSkillDto(pet_1_auto_skill);
        this.pet1PetType = pet_1_pet_type;
        this.pet1Skill = pet_1_skill;
        this.pet1DateExpire = new Date(pet_1_date_expire);
        this.pet2Name = pet_2_name;
        this.pet2Nickname = pet_2_nickname;
        this.pet2Icon = pet_2_icon;
        this.pet2Description = pet_2_description;
        this.pet2Equipment = new CharacterPetEquipmentItemDto(pet_2_equipment);
        this.pet2AutoSkill = new CharacterPetEquipmentAutoSkillDto(pet_2_auto_skill);
        this.pet2PetType = pet_2_pet_type;
        this.pet2Skill = pet_2_skill;
        this.pet2DateExpire = new Date(pet_2_date_expire);
        this.pet3Name = pet_3_name;
        this.pet3Nickname = pet_3_nickname;
        this.pet3Icon = pet_3_icon;
        this.pet3Description = pet_3_description;
        this.pet3Equipment = new CharacterPetEquipmentItemDto(pet_3_equipment);
        this.pet3AutoSkill = new CharacterPetEquipmentAutoSkillDto(pet_3_auto_skill);
        this.pet3PetType = pet_3_pet_type;
        this.pet3Skill = pet_3_skill;
        this.pet3DateExpire = new Date(pet_3_date_expire);
    }
}

export {CharacterPetEquipmentDto};
