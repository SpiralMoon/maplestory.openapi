import { CubeResultOptionDtoBody } from '../../response/history/cubeResultOptionDtoBody';
import {
  PotentialOptionGrade,
  potentialOptionGradeFromString,
} from '../potentialOptionGrade';

/**
 * 큐브 결과 옵션 정보
 */
class CubeResultOptionDto {
  /**
   * 옵션 명
   */
  value: string;

  /**
   * 옵션 등급
   */
  grade: string;

  constructor(obj: CubeResultOptionDtoBody) {
    const { value, grade } = obj;

    this.value = value;
    this.grade = grade;
  }

  get gradeEnum(): PotentialOptionGrade {
    return potentialOptionGradeFromString(this.grade);
  }
}

export { CubeResultOptionDto };
