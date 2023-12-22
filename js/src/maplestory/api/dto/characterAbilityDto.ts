import {CharacterAbilityDtoBody} from "../response/characterAbilityDtoBody";
import {CharacterAbilityInfoDto} from "./characterAbilityInfoDto";

/**
 * 캐릭터 어빌리티 정보
 */
class CharacterAbilityDto {
	/**
	 * 조회 기준일
	 */
	date: Date;

	/**
	 * 어빌리티 등급
	 */
	abilityGrade: string;

	/**
	 *  어빌리티 정보
	 */
	abilityInfo: CharacterAbilityInfoDto[];

	/**
	 * 보유 명성치
	 */
	remainFame: number;

	constructor(obj: CharacterAbilityDtoBody) {
		const {
			date,
			ability_grade,
			ability_info,
			remain_fame,
		} = obj;

		// 날짜는 Date 객체로 변환
		this.date = new Date(date);
		this.abilityGrade = ability_grade;
		this.abilityInfo = ability_info.map(info => new CharacterAbilityInfoDto(info));
		this.remainFame = remain_fame;
	}
}

export {CharacterAbilityDto};
