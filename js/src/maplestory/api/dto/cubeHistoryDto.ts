import {CubeResultOptionDto} from "./cubeResultOptionDto";
import {CubeHistoryDtoBody} from "../response/cubeHistoryDtoBody";
import {PotentialOptionGrade, potentialOptionGradeFromString} from "./potentialOptionGrade";

/**
 * 큐브히스토리 정보
 */
class CubeHistoryDto {

	/**
	 * 큐브 사용 내역에 대한 고유 식별자
	 */
	id: string;

	/**
	 * 캐릭터이름
	 */
	characterName: string;

	/**
	 * 월드 이름
	 */
	worldName: string;

	/**
	 * 큐브 사용 날짜
	 */
	createDate: string;

	/**
	 * 사용한 큐브
	 */
	cubeType: string;

	/**
	 * 큐브 사용 결과
	 */
	itemUpgradeResult: string;

	/**
	 * 미라클 타임 적용 여부
	 */
	miracleTimeFlag: string;

	/**
	 * 장비 분류
	 */
	itemEquipPart: string;

	/**
	 * 장비 레벨
	 */
	itemLevel: number;

	/**
	 * 큐브를 사용한 장비
	 */
	targetItem: string;

	/**
	 * 잠재능력 등급
	 */
	potentialOptionGrade: string;

	/**
	 * 에디셔널 잠재능력 등급
	 */
	additionalPotentialOptionGrade: string;

	/**
	 * 천장에 도달하여 확정 등급 상승한 여부
	 */
	upgradeGuarantee: boolean;

	/**
	 * 현재까지 쌓은 스택
	 */
	upgradeGuaranteeCount: number;

	/**
	 * 큐브 사용 전 잠재능력 옵션
	 */
	beforePotentialOptions: CubeResultOptionDto[];

	/**
	 * 큐브 사용 전 에디셔널 잠재능력 옵션
	 */
	beforeAdditionalPotentialOptions: CubeResultOptionDto[];

	/**
	 * 큐브 사용 후 잠재능력 옵션
	 */
	afterPotentialOptions: CubeResultOptionDto[];

	/**
	 * 큐브 사용 후 에디셔널 잠재능력 옵션
	 */
	afterAdditionalPotentialOptions: CubeResultOptionDto[];

	constructor(obj: CubeHistoryDtoBody) {
		const {
			id,
			character_name,
			world_name,
			create_date,
			cube_type,
			item_upgrade_result,
			miracle_time_flag,
			item_equip_part,
			item_level,
			target_item,
			potential_option_grade,
			additional_potential_option_grade,
			upgradeguarantee,
			upgradeguaranteecount,
			before_potential_options,
			before_additional_potential_options,
			after_potential_options,
			after_additional_potential_options
		} = obj;

		this.id = id;
		this.characterName = character_name;
		this.worldName = world_name;
		this.createDate = create_date;
		this.cubeType = cube_type;
		this.itemUpgradeResult = item_upgrade_result;
		this.miracleTimeFlag = miracle_time_flag;
		this.itemEquipPart = item_equip_part;
		this.itemLevel = item_level;
		this.targetItem = target_item;
		this.potentialOptionGrade = potential_option_grade;
		this.additionalPotentialOptionGrade = additional_potential_option_grade;
		this.upgradeGuarantee = upgradeguarantee;
		this.upgradeGuaranteeCount = upgradeguaranteecount;
		this.beforePotentialOptions = before_potential_options.map(origin => new CubeResultOptionDto(origin));
		this.beforeAdditionalPotentialOptions = before_additional_potential_options.map(origin => new CubeResultOptionDto(origin));
		this.afterPotentialOptions = after_potential_options.map(origin => new CubeResultOptionDto(origin));
		this.afterAdditionalPotentialOptions = after_additional_potential_options.map(origin => new CubeResultOptionDto(origin));
	}

	get isItemUpgrade(): boolean {
		return this.itemUpgradeResult === '성공';
	}

	get isMiracleTimeFlag(): boolean {
		return this.miracleTimeFlag !== '이벤트 적용되지 않음';
	}

	get potentialOptionGradeEnum(): PotentialOptionGrade {
		return potentialOptionGradeFromString(this.potentialOptionGrade);
	}

	get additionalPotentialOptionGradeEnum(): PotentialOptionGrade {
		return potentialOptionGradeFromString(this.additionalPotentialOptionGrade);
	}
}

export {CubeHistoryDto};
