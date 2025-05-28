import { PotentialResultOptionDto } from './potentialResultOptionDto';
import { PotentialHistoryBody } from '../../response/history/potentialHistoryBody';
import { PotentialOptionGrade, potentialOptionGradeFromString } from '../potentialOptionGrade';


/**
 * 잠재능력 재설정 히스토리
 */
class PotentialHistoryDto {
  /**
   * 잠재능력 재설정 히스토리 식별자
   */
  id: string;

  /**
   * 캐릭터 명
   */
  characterName: string;

  /**
   * 사용 일시
   */
  dateCreate: Date;

  /**
   * 대상 잠재능력 타입 (잠재능력, 에디셔널 잠재능력)
   */
  potentialType: string;

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
   * 잠재능력 재설정 장비 명
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
  beforePotentialOption: PotentialResultOptionDto[];

  /**
   * 사용 전 에디셔널 잠재능력 옵션
   */
  beforeAdditionalPotentialOption: PotentialResultOptionDto[];

  /**
   * 사용 후 잠재능력 옵션
   */
  afterPotentialOption: PotentialResultOptionDto[];

  /**
   * 사용 후 에디셔널 잠재능력 옵션
   */
  afterAdditionalPotentialOption: PotentialResultOptionDto[];

  constructor(obj: PotentialHistoryBody) {
    const {
      id,
      character_name,
      date_create,
      potential_type,
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
    this.dateCreate = new Date(date_create);
    this.potentialType = potential_type;
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
      (origin) => new PotentialResultOptionDto(origin),
    );
    this.beforeAdditionalPotentialOption =
      before_additional_potential_option.map(
        (origin) => new PotentialResultOptionDto(origin),
      );
    this.afterPotentialOption = after_potential_option.map(
      (origin) => new PotentialResultOptionDto(origin),
    );
    this.afterAdditionalPotentialOption = after_additional_potential_option.map(
      (origin) => new PotentialResultOptionDto(origin),
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

export { PotentialHistoryDto };
