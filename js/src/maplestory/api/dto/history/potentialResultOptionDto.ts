import {
  PotentialOptionGrade,
  potentialOptionGradeFromString,
} from '../potentialOptionGrade';
import { PotentialResultOptionDtoBody } from '../../response/history/potentialHistoryResponseDtoBody';

/**
 * 잠재능력 재설정 결과 옵션 정보
 */
class PotentialResultOptionDto {
  /**
   * 옵션 명
   */
  value: string;

  /**
   * 옵션 등급
   */
  grade: string;

  constructor(obj: PotentialResultOptionDtoBody) {
    const { value, grade } = obj;

    this.value = value;
    this.grade = grade;
  }

  get gradeEnum(): PotentialOptionGrade {
    return potentialOptionGradeFromString(this.grade);
  }
}

export { PotentialResultOptionDto };
