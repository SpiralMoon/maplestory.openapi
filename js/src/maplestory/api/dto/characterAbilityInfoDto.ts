import {CharacterAbilityInfoDtoBody} from "../response/characterAbilityDtoBody";

/**
 * 캐릭터 어빌리티 상세 정보
 */
class CharacterAbilityInfoDto {

	abilityNo: string;
	abilityGrade: string;
	abilityValue: string;

	constructor(obj: CharacterAbilityInfoDtoBody) {
		const {
			ability_no,
			ability_grade,
			ability_value,
		} = obj;

		this.abilityNo = ability_no;
		this.abilityGrade = ability_grade;
		this.abilityValue = ability_value;
	}
}

export {CharacterAbilityInfoDto}
