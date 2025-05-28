import { CubeHistoryBody, CubeHistoryResponseBody, CubeResultOptionBody } from '../../response/history/cubeHistoryBody';
import { PotentialOptionGrade, potentialOptionGradeFromString } from '../../../common/potentialOptionGrade';

/**
 * 큐브 히스토리
 */
export class CubeHistoryDto {
  /**
   * 큐브 히스토리 식별자
   */
  id: string;

  /**
   * 캐릭터 명
   */
  characterName: string;

  /**
   * 월드 명
   */
  worldName: string;

  /**
   * 사용 일시
   */
  dateCreate: Date;

  /**
   * 사용 큐브
   */
  cubeType: string;

  /**
   * 사용 결과
   */
  itemUpgradeResult: string;

  /**
   * 미라클 타임 적용 여부
   */
  miracleTimeFlag: string;

  /**
   * 장비 분류
   */
  itemEquipmentPart: string;

  /**
   * 장비 레벨
   */
  itemLevel: number;

  /**
   * 큐브 사용한 장비
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
   * 사용 전 잠재능력 옵션
   */
  beforePotentialOption: CubeResultOptionDto[];

  /**
   * 사용 전 에디셔널 잠재능력 옵션
   */
  beforeAdditionalPotentialOption: CubeResultOptionDto[];

  /**
   * 사용 후 잠재능력 옵션
   */
  afterPotentialOption: CubeResultOptionDto[];

  /**
   * 사용 후 에디셔널 잠재능력 옵션
   */
  afterAdditionalPotentialOption: CubeResultOptionDto[];

  constructor(obj: CubeHistoryBody) {
    const {
      id,
      character_name,
      world_name,
      date_create,
      cube_type,
      item_upgrade_result,
      miracle_time_flag,
      item_equipment_part,
      item_level,
      target_item,
      potential_option_grade,
      additional_potential_option_grade,
      upgrade_guarantee,
      upgrade_guarantee_count,
      before_potential_option,
      before_additional_potential_option,
      after_potential_option,
      after_additional_potential_option,
    } = obj;

    this.id = id;
    this.characterName = character_name;
    this.worldName = world_name;
    this.dateCreate = new Date(date_create);
    this.cubeType = cube_type;
    this.itemUpgradeResult = item_upgrade_result;
    this.miracleTimeFlag = miracle_time_flag;
    this.itemEquipmentPart = item_equipment_part;
    this.itemLevel = item_level;
    this.targetItem = target_item;
    this.potentialOptionGrade = potential_option_grade;
    this.additionalPotentialOptionGrade = additional_potential_option_grade;
    this.upgradeGuarantee = upgrade_guarantee;
    this.upgradeGuaranteeCount = upgrade_guarantee_count;
    this.beforePotentialOption = before_potential_option.map(
      (origin) => new CubeResultOptionDto(origin),
    );
    this.beforeAdditionalPotentialOption =
      before_additional_potential_option.map(
        (origin) => new CubeResultOptionDto(origin),
      );
    this.afterPotentialOption = after_potential_option.map(
      (origin) => new CubeResultOptionDto(origin),
    );
    this.afterAdditionalPotentialOption = after_additional_potential_option.map(
      (origin) => new CubeResultOptionDto(origin),
    );
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

/**
 * 큐브 결과 옵션 정보
 */
export class CubeResultOptionDto {
  /**
   * 옵션 명
   */
  value: string;

  /**
   * 옵션 등급
   */
  grade: string;

  constructor(obj: CubeResultOptionBody) {
    const { value, grade } = obj;

    this.value = value;
    this.grade = grade;
  }

  get gradeEnum(): PotentialOptionGrade {
    return potentialOptionGradeFromString(this.grade);
  }
}

/**
 * 큐브 히스토리 응답 정보
 */
export class CubeHistoryResponseDto {
  /**
   * 결과 건 수
   */
  count: number;

  /**
   * 큐브 히스토리
   */
  cubeHistory: CubeHistoryDto[];

  /**
   * 페이징 처리를 위한 cursor
   */
  nextCursor: string | null;

  constructor(obj: CubeHistoryResponseBody) {
    const { count, cube_history, next_cursor } = obj;

    this.count = count;
    this.cubeHistory = cube_history.map((origin) => new CubeHistoryDto(origin));
    this.nextCursor = next_cursor;
  }
}
