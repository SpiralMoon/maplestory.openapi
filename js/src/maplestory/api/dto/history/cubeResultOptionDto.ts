import { PotentialOptionGrade, potentialOptionGradeFromString } from '@src/maplestory/api/dto/potentialOptionGrade';
import { CubeResultOptionDtoBody } from '@src/maplestory/api/response/history/cubeResultOptionDtoBody';

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
